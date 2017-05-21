package com.fiskra.coding.challange.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import com.fiskra.coding.challange.project.data.Country;
import com.fiskra.coding.challange.project.data.Person;
import com.fiskra.coding.challange.project.provider.PersonDataProvider;
import com.fiskra.coding.challange.project.provider.file.FileBasedProvider;

public class FileBasedProviderTest {
	 private static FileBasedProvider PROVIDER;

	    private PersonDataProvider provider;

	    @BeforeClass
	    public static void setUpClass() throws IOException {
	        File file;
	        try {
	            file = new File(FileBasedProviderTest.class.getClassLoader().getResource("people.csv").getFile());
	        }
	        catch(NullPointerException ex) {
	            // if you imported this project as a Java project (not maven), the line above will fail
	            // and you will end up in this place
	            // please provide an absolute path to [people.csv] so that everything works fine

	            // and of course comment out the exception in the line below:
	            throw new IllegalArgumentException("cannot load the resource file (is project imported as Maven?) - please supply direct path to the file");

	            // and uncomment the following line:
	            // file = new File("replace/this/with/a/direct/path/to/src/main/resources/people.csv");
	        }

	        PROVIDER = new FileBasedProvider();
	        PROVIDER.read(file);
	    }

	    @Before
	    public void setUp() {
	        // this is just to make sure the interface is not changed
	        this.provider = PROVIDER;
	    }

	    @Test
	    public void testReadAll() {
	        assertEquals("incorrect number of entries read from the file", 500, provider.findAll().size());
	    }

	    @Test
	    public void testFindByFirstName() {
	        Collection<Person> entries = provider.search("Russ", null, null, 0);
	        assertEquals(10, entries.size());
	        List<Person> results = Arrays.asList(
	            new Person("Russ", "Wyatt", Country.SLOVENIA, 24),
	            new Person("Russ", "York", Country.CROATIA, 37),
	            new Person("Russ", "Gross", Country.SWITZERLAND, 39),
	            new Person("Russ", "Scott", Country.ARMENIA, 26),
	            new Person("Russ", "Stephenson", Country.BOSNIA_AND_HERZEGOVINA, 35),
	            new Person("Russ", "Walton", Country.DENMARK, 42),
	            new Person("Russ", "Moses", Country.MONACO, 32),
	            new Person("Russ", "Harrison", Country.ARMENIA, 38),
	            new Person("Russ", "Shea", Country.TURKEY, 25),
	            new Person("Russ", "Casey", Country.FRANCE, 22)
	        );
	        assertTrue("not all expected data are included in the results", entries.containsAll(results));
	    }

	    @Test
	    public void testFindNothingByFirstNameAndEuAndAge() {
	        Collection<Person> entries = provider.search("Russ", null, true, 50);
	        assertTrue("no records should match the search criteria", entries.isEmpty());
	    }

	    @Test
	    public void testFindByFirstNameAndEuAndAge() {
	        Collection<Person> entries = provider.search("Russ", null, true, 37);
	        assertEquals("two matching records are expected", 2, entries.size());
	        List<Person> results = Arrays.asList(
	            new Person("Russ", "York", Country.CROATIA, 37),
	            new Person("Russ", "Walton", Country.DENMARK, 42)
	        );
	        assertTrue(entries.containsAll(results));
	    }

	    @Test
	    public void testFindBySurnameAndAge() {
	        Collection<Person> entries = provider.search(null, "Scott", null, 56);
	        assertEquals("exactly one matching record should be found",1, entries.size());
	        Person result = new Person("Tanya","Scott",Country.ARMENIA,56);
	        assertEquals(result, entries.iterator().next());
	    }
	    

	    /**
	     * Runs the tests as a java app.
	     * This method should be used if your IDE does not have support for Maven or JUnit.
	     *
	     * @param args
	     *          Command line arguments. Ignored.
	     */
	    public static final void main(String[] args) {
	        JUnitCore.main("org.vaadin.hr.FileBasedProviderTest");
	    }

}
