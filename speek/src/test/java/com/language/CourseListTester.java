package com.language;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;
import java.util.UUID;


import com.language.Course;
import com.language.CourseList;
import com.language.DataLoader;
import com.language.DataWriter;

import org.junit.Before;
import org.junit.Test;

public class CourseListTester {
    private CourseList courselist;

    @Before
    public void setUp() {
        courselist = CourseList.getInstance();
    }   

    @Test
    public void testGetInstance() {
        CourseList instnc = CourseList.getInstance();
        assertEquals(instnc, courselist);
    }

    @Test
    public void testGetCoursesNotNull(){
        ArrayList<Course> cours = courselist.getCourses();
        assertEquals(false, cours==null);
    }

    @Test
    public void testGetOneCourse(){
        ArrayList<Course> cours = courselist.getCourses();
        assertEquals(1, cours.size());
    }

    @Test
    public void testGetCourses(){
        UUID courseID = UUID.fromString("8c24fea9-e192-457d-8ba3-db5828f62490");
        ArrayList<Course> courses = courselist.getCourses();
        Course course = courses.get(0);
        assertEquals("Spanish", course.getCourse());
    }

    @Test
    public void testGetCourseByUUID() {
        UUID courseID = UUID.fromString("8c24fea9-e192-457d-8ba3-db5828f62490");
        Course cours = courselist.getCourseByUUID(courseID);
        assertEquals(courseID, cours.getCourseID());
    }


}
