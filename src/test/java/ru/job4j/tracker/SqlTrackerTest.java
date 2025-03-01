package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void wipeTable()  {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenItemMustBeReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        item.setName("item1");
        tracker.replace(item.getId(), item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenItemMustBeReplacDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));

    }

    @Test
    public void  whenNumberOfApplicationsMustBeEqualToThoseFound()  {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 =  tracker.add(new Item("item1"));
        Item item2 =  tracker.add(new Item("item2"));
        List<Item> list = tracker.findAll();
        assertThat(list, is(List.of(item1, item2)));
    }

    @Test
    public void whenSearchesForItemWithTheGivenName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findByName(item.getName()), is(List.of(item)));
    }

    @Test
    public void whenSearchForAnApplicationById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenItemMustBeDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        tracker.delete(item.getId());
        assertNull(tracker.findById(item.getId()));
    }
}