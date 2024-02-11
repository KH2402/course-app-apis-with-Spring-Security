package com.learnspringboot.controller;

import com.learnspringboot.entity.Course;
import com.learnspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String home(){
        return "<h1>Welcome</h1>";
    }

    @GetMapping("/user")
    public String user(){
        return "<h1>Welcome user !!</h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1>Welcome admin !!</h1>";
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses(){
        List<Course> courses=this.courseService.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id){
        Course course = this.courseService.getCourseById(id);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course course1=this.courseService.addCourse(course);
        return new ResponseEntity<>(course1, HttpStatus.CREATED);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Integer id){
        Course course1=this.courseService.updateCourse(course,id);
        return new ResponseEntity<>(course1,HttpStatus.OK);
    }

    @DeleteMapping("courses/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Integer id){
         this.courseService.deleteCourseById(id);
         return new ResponseEntity<>("Successfully deleted course !!",HttpStatus.OK);
    }
}
