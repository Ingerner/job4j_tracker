package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Address addressOne = new Address("Moscow", "Lenina", 6, 5);
        Address addressTwo = new Address("Moscow", "Lenina", 6, 5);
        Address addressTree = new Address("Madrid", "Fuencarral", 6, 5);
        Address addressFour = new Address("Berlin", "Wilhelmstrasse", 6, 5);
        Address addressFive = new Address("Amsterdam", "Kalverstraat", 10, 5);


        List<Address> expected = List.of(addressFive, addressFour, addressTree, addressOne);

        List<Profile> profilesList = List.of(
                new Profile(addressOne),
                new Profile(addressTwo),
                new Profile(addressTree),
                new Profile(addressFour),
                new Profile(addressFive)

        );

        Profiles profiles = new Profiles();

        assertThat(profiles.collect(profilesList), is(expected));

    }
}