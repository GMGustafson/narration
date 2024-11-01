package com.language;

// import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;

import com.language.DataLoader;
import com.language.DataWriter;
import com.language.User;
import com.language.UserList;

public class DataWriterTester {
    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();

    @Before
    public void setUp() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @After
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @Test
    void testWritingNoUsers() {
        userList = DataLoader.getUsers();
        assertEquals(0, userList.size());
    }

    @Test
    void testWritingOneUser() {
        userList.add(new User( null, "John", "Doe", "jdoe@gmail.com", "627-917-2739",null, "jdoe", "ilovemyCat"));
        DataWriter.saveUsers();
        assertEquals("jdoe", DataLoader.getUsers().get(0).getUsername());
   }

   @Test
   void testWritingUserProgress() {
    User user = new User(null, "John", "Doe", "jdoe@gmail.com", "627-917-2739",null, "2004-12-8", "ilovemyCat");
    Progress progress = new Progress(10, 7, "colors", 5, 2, new ArrayList<>(List.of("verde", "amarillo")));
    user.setProgress(progress);
    userList.add(user);
    
    DataWriter.saveUsers();
    
    Progress loadedProgress = DataLoader.getUsers().get(0).getProgress();
    assertEquals(7, loadedProgress.getNumCorrectAnswers());
    assertEquals("colors", loadedProgress.getCurrentCategory());
   }

   @Test
   void testWritingCourseWithCategories() {
    Course course = new Course("Spanish", "8c24fea9-e192-457d-8ba3-db5828f62490");
    Category category = new Category("numbers");
    course.addCategory(category);
    
    DataWriter.saveCourse(course);
    
    HashMap<Course,Progress> loadedCourse = DataLoader.getCourses().get(0);
    assertEquals("numbers", loadedCourse.getCategories().get(0).getTitle());
}


@Test
void testWritingEmptyUser() {
    userList.add(new User(null, "", "", "", "", null, "", null));
    DataWriter.saveUsers();
    assertEquals("", DataLoader.getUsers().get(0).getUsername());
}

@Test
void testWritingNullUser() {
    userList.add(new User(null, null, null, null, null, null, null, null));
    DataWriter.saveUsers();
    assertNull(DataLoader.getUsers().get(0).getUsername());
}

@Test
void testMultipleUsers() {
    userList.add(new User(null, "John", "Doe", "jdoe@gmail.com", "803-144-1021", null, "jdoe", "ilovemycat"));
    userList.add(new User(null, "Amy", "Smith", "asmith@gamil.com","803-456-9037", null, "jdoe", "ilovemycat"));
    
    DataWriter.saveUsers();
    
    assertEquals("asmith", DataLoader.getUsers().get(1).getUsername());
}
}

