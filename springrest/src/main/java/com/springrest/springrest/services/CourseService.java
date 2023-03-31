package com.springrest.springrest.services;
import com.springrest.springrest.entities.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

// this is the service layer, provides the implementation to the service layer
@Service
public interface CourseService {
    public List<Course> getCourses();

    public Course getCourse(long courseId);

    public Course  addCourse(Course course);

    public Course UpdateCourse(Course course);

    public void DeleteCourse(long courseId);
}
