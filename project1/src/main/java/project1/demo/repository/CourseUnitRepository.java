package project1.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import project1.demo.entity.CourseUnit;

@CrossOrigin("*")
public interface CourseUnitRepository extends JpaRepository<CourseUnit, Long> {

//    @RestResource(path="courseid")
//    Page<CourseUnit> findByCourseId(@Param("id") Long id, Pageable pageable);
}
