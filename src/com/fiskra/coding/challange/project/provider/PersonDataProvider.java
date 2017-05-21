package com.fiskra.coding.challange.project.provider;

import java.util.Collection;

import com.fiskra.coding.challange.project.data.Person;

public interface PersonDataProvider {
	
	 /**
     * Returns all data found in this provider.
     *
     * @return
     *              A collection of all people data.
     */
    Collection<Person> findAll();

    /**
     * Searches people by given criteria. All given criteria must match ({@code AND} search).
     *
     * @param firstName
     *              If not {@code null}, only people with given first name.
     * @param lastName
     *              If not {@code null}, only people with given last name.
     * @param eu
     *              If not {@code null}, only people with country either from EU ({@code true}) or not ({@code false}).
     * @param minimumAge
     *              If a positive number, only people <strong>with that age or older</strong>.
     * @return
     *              A collection of people data matching the criteria.
     */
    Collection<Person> search(String firstName, String lastName, Boolean eu, int minimumAge);

}
