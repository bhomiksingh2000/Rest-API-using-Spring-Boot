package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

// CourseServiceImpl is created to add generic code to the code base ,
// bec in future if any problem comes we can just change here
// this is basically implementation class


// dont forget to add @Service here , otherwise it will give error , as this is Service part of Spring boot

@Service
public class CourseServiceImpl implements CourseService {

    // vase hum yha pe koi database rkhenge , bec it is service layer ,
    // and through this we will just fetch from database
    List<Course> list;


    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(145, "CH 1", "to excel java"));
        list.add(new Course(146, "CH 2", "to master java"));

    }


    @Override
    public List<Course> getCourses() {
        return list;
    }

    // now making a fucntion if a specific courseId will be required , means requested at the PostMan
    @Override
    public Course getCourse(long courseId) {
        Course c = null;

        for(Course course:list){
            if(course.getId() == courseId){
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }



    @Override
    public Course UpdateCourse(Course course) {
        /* here we will loop over the list and check whether there is already a list by this id or not,
        if yes , then we will update .

         */
        list.forEach(e -> {
            if (e.getId() == course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    }

    @Override
    public void DeleteCourse(long parseLong) {
        list = this.list.stream().filter(e -> e.getId()!=parseLong).collect(Collectors.toList());
    }


}
