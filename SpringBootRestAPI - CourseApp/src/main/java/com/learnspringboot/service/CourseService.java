package com.learnspringboot.service;

import com.learnspringboot.entity.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourseById(Integer id);

    public Course addCourse(Course course);

    public Course updateCourse( Course course, Integer id);

    public void deleteCourseById(Integer id);
}
