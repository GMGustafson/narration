package com.language;

// import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

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
public void testWritingNoUsers() {
        userList = DataLoader.getUsers();
        assertEquals(0, userList.size());
    }

    @Test
public void testWritingOneUser() {
        userList.add(new User(UUID.randomUUID(), "John", "Doe", "jdoe@gmail.com", "627-917-2739",null, "jdoe", "ilovemyCat"));
        DataWriter.saveUsers();
        assertEquals("jdoe", DataLoader.getUsers().get(0).getUsername());
   }

@Test
public void testWritingEmptyUser() {
    userList.add(new User(UUID.randomUUID(), "", "", "", "", null, "", null));
    DataWriter.saveUsers();
    assertEquals("", DataLoader.getUsers().get(0).getUsername());
}

@Test
public void testWritingNullUser() {
    userList.add(new User(null, null, null, null, null, null, null, null));
    DataWriter.saveUsers();
    assertNull(DataLoader.getUsers().get(0).getUsername());
}

@Test
public void testMultipleUsers() {
    userList.add(new User(UUID.randomUUID(), "John", "Doe", "jdoe@gmail.com", "803-144-1021", null, "jdoe", "ilovemycat"));
    userList.add(new User(UUID.randomUUID(), "Amy", "Smith", "asmith@gamil.com","803-456-9037", null, "jdoe", "ilovemycat"));
   
    DataWriter.saveUsers();
   
    assertEquals("asmith", DataLoader.getUsers().get(1).getUsername());
}

@Test
public void testWritingUserProgress() {
    User user = new User(UUID.randomUUID(), "John", "Doe", "jdoe@gmail.com", "627-917-2739", null, "jdoe", "ilovemyCat");
   
    HashMap<String, ArrayList<Phrase>> phrases = new HashMap<>();
    HashMap<String, ArrayList<Word>> words = new HashMap<>();
    HashMap<String, Story> stories = new HashMap<>();
   
    Course colorsCourse = new Course(UUID.randomUUID(), "Phrase", phrases, words, "Numbers", stories);


    Progress progress = new Progress(10, 7, "Colors", 5, 2, new ArrayList<>(List.of("verde", "amarillo")));


    user.getCourses().put(colorsCourse, progress);
   
    userList.add(user);
   
    DataWriter.saveUsers();
   
    Progress loadedProgress = DataLoader.getUsers().get(0).getCourses().get(colorsCourse);
    assertEquals(7, loadedProgress.getNumCorrectAnswers());
    assertEquals("Colors", loadedProgress.getCurrentCategory());
}


@Test
public void testMultipleUsersProgressAndCourses() {
    User user1 = new User(UUID.randomUUID(), "John", "Doe", "jdoe@gmail.com", "803-144-1021", null, "jdoe", "ilovemycat");
    Course mathCourse = new Course(UUID.randomUUID(), "Calculus", new HashMap<>(), new HashMap<>(), "Math", new HashMap<>());
    assertFalse("Course category should not be valid", isValidCourseCategory(mathCourse.getCourse()));
    Progress mathProgress = new Progress(10, 8, "Calculus", 5, 3, new ArrayList<>(List.of("integral calculus", "derivatives")));
    // This would not be added since the course is invalid
    if (isValidCourseCategory(mathCourse.getCourse())) {
        user1.getCourses().put(mathCourse, mathProgress);
    }

    User user2 = new User(UUID.randomUUID(), "Amy", "Smith", "asmith@gmail.com", "803-456-9037", null, "asmith", "password123");
    
    // Attempt to create a science course (this should also be invalid)
    Course scienceCourse = new Course(UUID.randomUUID(), "Physics", new HashMap<>(), new HashMap<>(), "Science", new HashMap<>());
    assertFalse("Course category should not be valid", isValidCourseCategory(scienceCourse.getCourse()));

    Progress scienceProgress = new Progress(12, 9, "Physics", 6, 4, new ArrayList<>(List.of("Newton's Laws", "thermodynamics")));
    // This would not be added since the course is invalid
    if (isValidCourseCategory(scienceCourse.getCourse())) {
        user2.getCourses().put(scienceCourse, scienceProgress);
    }

    DataWriter.saveUsers();
    List<User> loadedUsers = DataLoader.getUsers();
    
    assertEquals("Users with invalid courses should not be added", 0, loadedUsers.size());
}

private boolean isValidCourseCategory(String courseCategory) {
    return courseCategory.equals("Words") || courseCategory.equals("Phrases");
}

public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("com.language.DataWriterTester");
}

}



