package com.fiskra.coding.challange.project.provider.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.fiskra.coding.challange.project.data.Country;
import com.fiskra.coding.challange.project.data.Person;
import com.fiskra.coding.challange.project.provider.PersonDataProvider;

public class FileBasedProvider implements PersonDataProvider{

	 /**
     * Reads the contents of the file.
     * @param file
     *          File to get data from, in CSV format ({@code firstName,lastName,country,age}).<br/>
     *          Assume that the data is correct.<br/>
     *          The file contains one data per line (unix line endings). The first line is a header line.<br/>
     *          First name and last name are Strings that contain letters a-z and start with a capital letter.<br/>
     *          Country is all UPPER CASE and matches the enum name in the Country class.<br/>
     *          Age is a positive integer.
     * @throws IOException when reading the file fails for any reason.
     * @see Person a POJO that corresponds to an entry in the file
     * @see Country an enum with defined countries
     */
	private static List<Person> myPeople = new ArrayList<Person>();
	
    public void read(File file) throws IOException {
        // todo task-1: read contents of the given file
    	
    	try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			myPeople = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
		} catch (Exception e) {
			throw new UnsupportedOperationException("not implemented: "+ e);
		}
    }
    
    private Function<String, Person> mapToItem = (line) -> {
    	  String[] p = line.split(",");// a CSV has comma separated lines
    	  Person person = new Person(p[0],p[1],Country.valueOf(p[2]),Integer.parseInt(p[3]));
    	  
    	  return person;
    	};

    @Override
    public Collection<Person> findAll() {
        // todo task-2: return all data read from the file
        return myPeople;
    }

    @Override
    public Collection<Person> search(String firstName, String lastName, Boolean eu, int minimumAge) {
        // todo task-3: implement the searching as described in this method's javadoc
    	
    	/*List<Predicate<Person>> allPredicates = Arrays.asList(
                w -> w.getFirstName().equals(firstName),
                w -> w.getLastName().equals(lastName),
                w -> w.getCountry().isEu() == eu.booleanValue(),
                w -> w.getAge()>=minimumAge
            );*/
    	
    //	return myPeople.stream().filter(allPredicates).collect(Collectors.toList());
    	
      
       return myPeople.stream().filter(person -> person.getFirstName().equals(firstName))
       		.filter(person -> person.getLastName().equals(lastName))
       		.filter(person -> person.getCountry().isEu() == eu.booleanValue())
       		.filter(person -> person.getAge()>=minimumAge)
       		.collect(Collectors.toList());
       
    	/*return myPeople.stream().filter(person -> person.getFirstName().equals(firstName) | 
    			person.getLastName().equals(lastName) | person.getCountry().isEu() == eu.booleanValue()
    			| person.getAge()>=minimumAge).collect(Collectors.toList()); */
    }
    
    public Collection<Person> search2(){
    	return myPeople.stream()
         .filter(((Predicate<Person>) p -> p.getAge() == 56).and(p -> p.getFirstName().equals("Scott")))
         .collect(Collectors.toList());       
    }


}
