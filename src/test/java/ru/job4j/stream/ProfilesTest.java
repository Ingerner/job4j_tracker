package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Address addressOne = new Address("Moscow", "Lenina", 10, 5);
        Address addressTwo = new Address("Moscow", "Lenina", 2, 9);
        Address addressTree = new Address("Moscow", "Lenina", 6, 5);

        List<Address> expected = List.of(addressOne, addressTwo, addressTree);

        List<Profile> profilesList = List.of(
                new Profile(addressOne),
                new Profile(addressTwo),
                new Profile(addressTree)
        );

        Profiles profiles = new Profiles();

        assertThat(profiles.collect(profilesList), is(expected));

    }
}