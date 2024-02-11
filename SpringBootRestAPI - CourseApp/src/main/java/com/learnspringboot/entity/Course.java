package com.learnspringboot.entity;



import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer courseId;

    @Column(name = "name")
    private String courseName;

    @Column(name = "description")
    private String courseDescription;

}
