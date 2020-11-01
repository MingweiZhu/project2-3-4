package project1.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_course_unit")
public class CourseUnit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String study_state;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    public Long getId() {
        return id;
    }
}
