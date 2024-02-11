package com.learnspringboot.service;

import com.learnspringboot.DAO.CourseRepo;
import com.learnspringboot.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepo courseRepo;

    //get all courses
    @Override
    public List<Course> getCourses() {
        List<Course> courses = this.courseRepo.findAll();
        return courses;
    }

    // get course by id
    @Override
    public Course getCourseById(Integer id) {
        Course course = this.courseRepo.findById(id).orElseThrow();
        return course;
    }

    // add course
    @Override
    public Course addCourse(Course course) {
        Course savedCourse = this.courseRepo.save(course);
        return savedCourse;
    }

    //update course by id
    @Override
    public Course updateCourse(Course course, Integer id) {
        Course course1=this.courseRepo.findById(id).orElseThrow();
        course1.setCourseName(course.getCourseName());
        course1.setCourseDescription(course.getCourseDescription());
        this.courseRepo.save(course1);

        return course1;
    }


    //delete course by id
    @Override
    public void deleteCourseById(Integer id) {
        Course course = this.courseRepo.findById(id).orElseThrow();
        this.courseRepo.delete(course);
    }
}
