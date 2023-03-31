package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MyController {
    @Autowired
    private CourseService courseService;  // adding @autowired will simply make the object of CourseServiceImpl class,
    // as we know that we can not make an object of CourseService because it is an interface
    @GetMapping("/home")
    public String home(){

        return "this is home page";
    }


    // get the course.
    @GetMapping("/courses")
    public List<Course> getCourses(){

        return this.courseService.getCourses(); // using run time polymorphism the fucntion in CourseServiceImpl will be called
    }


    // get a particular course
    @GetMapping("/courses/{courseID}")
    public Course getCourse(@PathVariable String courseId){

        // by writing @Pathvariable, the courseId written in the "/courses/{courseID}"
        // will be passed to the argument of the function

        return this.courseService.getCourse(Long.parseLong(courseId)); // as in CourseService we have passed long , therefore we will convert here
    }

    // add a particular course
    @PostMapping("/courses")
    public Course  addCourse(@RequestBody Course course){
/*
        Spring automatically deserializes the JSON into a Java type, assuming an appropriate one is specified.
        By default, the type we annotate with the @RequestBody annotation
        must correspond to the JSON sent from our client-side controller:

        means @RequestBody converts the json which will be fired from postman into the required Java Object.
        * */
        return this.courseService.addCourse(course);
    }

    // Update will simpl update the if course is found to exist beforehand.
    @PutMapping("/courses")
    public Course UpdateCourse(@RequestBody Course course){

        return this.courseService.UpdateCourse(course);
    }

    // in this example we have shown that how we can also return the status i.e HTTP STATUS
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> DeleteCourse(@PathVariable String courseId){
        // if courseId will be found then this will be done
        try {
            this.courseService.DeleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

/*
ResponseEntity represents the whole HTTP response: status code,
headers, and body. As a result, we can use it to fully configure the HTTP response.

If we want to use it, we have to return it from the endpoint; Spring takes care of the rest.

ResponseEntity is a generic type. Consequently, we can use any type as the response body:


 */

}
