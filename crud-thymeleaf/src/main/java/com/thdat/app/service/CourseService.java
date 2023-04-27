package com.thdat.app.service;

import com.thdat.app.model.Course;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

//    list Course
    List<Course> getAllCourse();

//    Save course
    void saveCourse(Course course);

//    update course


//    delete course
    void deleteCourse(long id);

//    search course by name

}
