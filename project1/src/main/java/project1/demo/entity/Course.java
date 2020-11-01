package project1.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_course")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "course_name")
    private String courseName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<CourseUnit> book;
}
