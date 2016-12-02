package com.wet.api.nutrition.service;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;

import com.wet.api.nutrition.dao.SourceDao;
import com.wet.api.nutrition.model.Source;
import com.wet.api.nutrition.service.SourceDaoService;
import com.wet.api.nutrition.service.impl.SourceDaoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SourceDaoServiceImplTest 
{
	private SourceDaoService sourceDaoService;
	
	@Mock
	private SourceDao mockSourceDao;
	
	@Before
	public void setup()
	{
		sourceDaoService = new SourceDaoServiceImpl();
		Whitebox.setInternalState(sourceDaoService, "sourceDao", mockSourceDao);
	}
	
	@Test
	public void testFindById()
	{
		long id = 1L;
		Source expected = new Source();
		
		when(mockSourceDao.find(id)).thenReturn(expected);
		Source found = sourceDaoService.find(id);
		
		assertThat(found, sameInstance(expected));
		verify(mockSourceDao).find(id);
	}
	
	@Test
	public void testFindAll()
	{
		Source source = new Source();
		List<Source> expected = new ArrayList<Source>();
		expected.add(source);
		
		when(mockSourceDao.findAll()).thenReturn(expected);
		List<Source> found = sourceDaoService.findAll();
		
		assertThat(found, sameInstance(expected));
		verify(mockSourceDao).findAll();
	}

	@Test
	public void testSave()
	{
		Source source = new Source();
		
		doNothing().when(mockSourceDao).save(source);	
		sourceDaoService.save(source);
		
		verify(mockSourceDao).save(source);
	}
	
	@Test(expected = DataAccessException.class)
	public void testDataAccessException()
	{
		Source source = new Source();
		
		DataAccessException dae = new DataAccessException("Data access message", new Exception("Exception message")) 
		{
			private static final long serialVersionUID = 1L;
		};
		
		// Mock throwing the DataAccessException
		// This should be caught and re-thrown since there's no constraint violation
		Mockito.doThrow(dae).when(mockSourceDao).save(source);
		sourceDaoService.save(source);
	}

	@Test
	public void testDelete()
	{
		Source source = new Source();
		
		doNothing().when(mockSourceDao).delete(source);	
		sourceDaoService.delete(source);
		
		verify(mockSourceDao).delete(source);
	}
}