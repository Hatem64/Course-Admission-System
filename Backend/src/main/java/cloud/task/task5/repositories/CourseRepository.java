package cloud.task.task5.repositories;

import cloud.task.task5.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT a FROM Course a WHERE a.id = ?1")
    Course findCourseByid(Long id);

}
