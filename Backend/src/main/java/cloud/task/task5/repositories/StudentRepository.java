package cloud.task.task5.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import cloud.task.task5.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("SELECT a FROM Student a WHERE a.email = ?1")
	Optional<Student> findStudentByEmail(String email);

	@Query("SELECT a FROM Student a WHERE a.id_student = ?1")
	Student findStudentById(Long id_student);


}