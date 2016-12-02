package com.wet.api.nutrition.dao.driver;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wet.api.nutrition.dao.SourceDao;
import com.wet.api.nutrition.model.Source;

public class SourceDaoTestDriver
{	
	private SourceDao sourceDao;
	
	public void run()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring.xml");
		sourceDao = (SourceDao)context.getBean("sourceDaoJpa");
		Source source = save();
		update(source);
		context.close();
	}

	private Source save()
	{
		Source source = new Source();
		source.setSource("Test Source");
		source.setCreateDate(new Date());
		sourceDao.save(source);

		return source;
	}
	
	private void update(Source source)
	{
		Source foundSource = sourceDao.find(source.getId());
		foundSource.setSource("Updated Test Source");
		sourceDao.save(foundSource);
	}
	
	public static void main(String[] args) 
	{
		SourceDaoTestDriver testDriver = new SourceDaoTestDriver();
		testDriver.run();
	}
}