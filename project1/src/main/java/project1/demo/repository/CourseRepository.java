package project1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import project1.demo.entity.Course;

@RepositoryRestResource(collectionResourceRel = "course", path = "Course")
public interface CourseRepository extends JpaRepository<Course, Long> {
}
