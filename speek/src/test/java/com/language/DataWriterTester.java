package com.language;


// import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;


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

@Test
void testWritingUserProgress() {
    // Create a new user with dummy data
    User user = new User(null, "John", "Doe", "jdoe@gmail.com", "627-917-2739", null, "jdoe", "ilovemyCat");
    
    // Create a UUID for the course
    //UUID courseID = UUID.randomUUID();
    
    // Create HashMaps for phrases, words, and stories
    HashMap<String, ArrayList<Phrase>> phrases = new HashMap<>();
    HashMap<String, ArrayList<Word>> words = new HashMap<>();
    HashMap<String, Story> stories = new HashMap<>();
    
    // Create a course object
    Course colorsCourse = new Course(null, "Phrase", phrases, words, "Numbers", stories);
    
    // Create a progress object
    Progress progress = new Progress(10, 7, "Colors", 5, 2, new ArrayList<>(List.of("verde", "amarillo")));

    // Directly set the course and progress in the user's course list
    user.getCourses().put(colorsCourse, progress);
    
    // Add the user to the user list
    userList.add(user);
   
    // Save the user data
    DataWriter.saveUsers();
   
    // Load the users and retrieve the progress
    Progress loadedProgress = DataLoader.getUsers().get(0).getCourses().get(colorsCourse);
    
    // Assertions to verify progress data
    assertEquals(7, loadedProgress.getNumCorrectAnswers());
    assertEquals("colors", loadedProgress.getCurrentCategory());
}

@Test
void testMultipleUsersProgress() {
    User user1 = new User(null, "John", "Doe", "jdoe@gmail.com", "803-144-1021", null, "jdoe", "ilovemycat");
    
    // Create a math course with a legitimate course name that is not "Words" or "Phrases"
    Course mathCourse = new Course(null, "Calculus", new HashMap<>(), new HashMap<>(), "Math", new HashMap<>());
    Progress mathProgress = new Progress(10, 8, "Calculus", 5, 3, new ArrayList<>(List.of("integral calculus", "derivatives")));
    user1.getCourses().put(mathCourse, mathProgress);
    
    User user2 = new User(null, "Amy", "Smith", "asmith@gmail.com", "803-456-9037", null, "asmith", "password123");
    
    // Create a science course with a legitimate course name that is not "Words" or "Phrases"
    Course scienceCourse = new Course(UUID.randomUUID(), "Physics", new HashMap<>(), new HashMap<>(), "Science", new HashMap<>());
    Progress scienceProgress = new Progress(12, 9, "Physics", 6, 4, new ArrayList<>(List.of("Newton's Laws", "thermodynamics")));
    user2.getCourses().put(scienceCourse, scienceProgress);

    // Add users to the user list
    userList.add(user1);
    userList.add(user2);
   
    // Save the user data
    DataWriter.saveUsers();

    // Load the users and validate their progress
    assertEquals(8, DataLoader.getUsers().get(0).getCourses().get(mathCourse).getNumCorrectAnswers());
    assertEquals("Calculus", DataLoader.getUsers().get(0).getCourses().get(mathCourse).getCurrentCategory());
    
    assertEquals(9, DataLoader.getUsers().get(1).getCourses().get(scienceCourse).getNumCorrectAnswers());
    assertEquals("Physics", DataLoader.getUsers().get(1).getCourses().get(scienceCourse).getCurrentCategory());

    // Check if courses are not "Words" or "Phrases"
    assertNotEquals("Words", mathCourse.getCourse());
    assertNotEquals("Phrases", mathCourse.getCourse());

    assertNotEquals("Words", scienceCourse.getCourse());
    assertNotEquals("Phrases", scienceCourse.getCourse());
}



}

