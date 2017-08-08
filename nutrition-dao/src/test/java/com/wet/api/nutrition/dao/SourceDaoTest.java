package com.wet.api.nutrition.dao;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import org.h2.tools.RunScript;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wet.api.nutrition.dao.SourceDao;
import com.wet.api.nutrition.model.Source;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/spring-test.xml" })
public abstract class SourceDaoTest
{
    // TODO: This should be put into a test-specific spring configuration or
    // properties file
    private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
    private static final String JDBC_URL = "jdbc:h2:mem:nutrition;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final String SCHEMA_LOCATION = "classpath:META-INF/h2/schema.sql";
    private static final String DATASET_LOCATION = "META-INF/h2/dataset.xml";
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final boolean CONTINUE_ON_ERROR = false;

    private static final int NUMBER_ROWS = 3;
    private static final String TABLE = "SOURCE";
    private static final String ID = "ID";
    private static final String SOURCE = "SOURCE";
    private static final String CREATE_DATE = "CREATE_DATE";
    private static final String VERSION = "VERSION";

    private static List<Source> expectedSources = new ArrayList<Source>();
    private static IDataSet dataSet;

    protected abstract SourceDao getSourceDao();

    private static IDataSet readDataSet() throws Exception
    {
        ClassLoader classLoader = SourceDaoTest.class.getClassLoader();
        File file = new File(classLoader.getResource(DATASET_LOCATION).getFile());
        return new FlatXmlDataSetBuilder().build(file);
    }

    private static Source createSourceFromDataSet(ITable table, int row) throws Exception
    {
        Source source = new Source();

        source.setId(Long.valueOf((String) table.getValue(row, ID)));
        source.setSource((String) table.getValue(row, SOURCE));
        source.setCreateDate(convertRowToDate(table.getValue(row, CREATE_DATE)));
        source.setVersion(convertRowToDate(table.getValue(row, VERSION)));

        return source;
    }

    private static Date convertRowToDate(Object value)
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.parseDateTime((String) value).toDate();
    }

    @BeforeClass
    public static void createSources() throws Exception
    {
        dataSet = readDataSet();
        ITable table = dataSet.getTable(TABLE);

        for (int row = 0; row < NUMBER_ROWS; row++)
        {
            expectedSources.add(createSourceFromDataSet(table, row));
        }
    }

    @BeforeClass
    public static void createSchema() throws Exception
    {
        RunScript.execute(JDBC_URL, USER, PASSWORD, SCHEMA_LOCATION, CHARSET, CONTINUE_ON_ERROR);
    }

    private void cleanlyInsertDataset(IDataSet dataSet) throws Exception
    {
        IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    @Before
    public void importDataSet() throws Exception
    {
        cleanlyInsertDataset(dataSet);
    }

    protected Source getSource()
    {
        Source source = new Source();
        source.setSource("Test Source 11");
        source.setCreateDate(new Date());

        return source;
    }

    @Test
    public void testFindById()
    {
        Iterator<Source> expectedItr = expectedSources.iterator();
        while (expectedItr.hasNext())
        {
            Source expected = expectedItr.next();
            Source actual = getSourceDao().find(expected.getId());

            assertThat(actual, is(expected));
            assertThat(actual.getId(), is(expected.getId()));
            assertThat(actual.getSource(), is(expected.getSource()));
            assertThat(actual.getCreateDate().compareTo(expected.getCreateDate()), is(0));
            assertThat(actual.getVersion().compareTo(expected.getVersion()), is(0));
        }
    }

    @Test
    public void testFindAll()
    {
        List<Source> actualSources = getSourceDao().findAll();

        Iterator<Source> expectedItr = expectedSources.iterator();
        while (expectedItr.hasNext())
        {
            assertThat(actualSources, hasItem(expectedItr.next()));
        }
    }

    @Test
    public void testSave()
    {
        Source source = getSource();
        getSourceDao().save(source);

        assertThat(source.getId(), greaterThan(0L));
        assertThat(source.getVersion(), notNullValue());
    }

    @Test
    public void testDelete()
    {
        Source source = getSourceDao().find(1L);
        getSourceDao().delete(source);
        List<Source> actualSources = getSourceDao().findAll();

        assertThat(actualSources, not(hasItem(source)));

        Source deletedSource = getSourceDao().find(1L);
        assertNull(deletedSource);
    }
}