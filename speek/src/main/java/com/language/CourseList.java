package com.language;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class CourseList {
    private ArrayList<Course> courses; 
    private static CourseList courseList;

    /**
    * private constructor
    */
    private CourseList()
    { 
        courses = DataLoader.getCourse(); 
    }

    /**
     * getInstance method (singleton design pat.)
     * creates one instance of the course list
     * @return a single instance of the list
     */
    public static CourseList getInstance()
    { 
        if (courseList == null)
        { 
            courseList = new CourseList();
        }
        return courseList;
    }

    /**
     * getCourses method
     * retrieves the list of courses
     * @return courses
     */
    public ArrayList<Course> getCourses() 
    { 
        return courses;
    }

    /**
     * getCourseByUUID method
     * retrieves the course by the UUID
     * @param UUID id
     * @return course
     */
    public Course getCourseByUUID(UUID id) {
        for(Course course : courses){
            if(course.getCourseID().equals(id)){
                return course;
            }
        }
        return null;
    }
}
