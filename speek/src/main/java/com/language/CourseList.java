package com.language;

import java.util.ArrayList;
import java.util.UUID;

/** @author grace 
 * 
**/

public class CourseList {
    private ArrayList<Course> courses; 
    private static CourseList courseList;

    //load content from json
    private CourseList()
    { 
        courses = DataLoader.getCourse(); 
    }

    public static CourseList getInstance()
    { 
        if (courseList == null)
        { 
            courseList = new CourseList();
        }
        return courseList;
    }

    public ArrayList<Course> getCourses() 
    { 
        return courses;
    }

    public Course getCourseByUUID(UUID id) {
        for(Course course : courses){
            if(course.getCourseID().equals(id)){
                return course;
            }
        }
        return null;
    }
}