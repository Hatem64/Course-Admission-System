package cloud.task.task5.services;

import cloud.task.task5.entities.Course;
import cloud.task.task5.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import cloud.task.task5.entities.Student;
import cloud.task.task5.repositories.StudentRepository;
import java.util.List;


@Service
public class StudentService {
	private final StudentRepository studentR;
	private final CourseRepository courseRepository;

	@Autowired
	public StudentService(StudentRepository studentR, CourseRepository courseRepository) {
		this.studentR = studentR;
		this.courseRepository = courseRepository;
	}

	public List<Student> getStudents(){
		return studentR.findAll();
	}

	public String addStudent(Student st) {
		java.util.Optional<Student> studentOptional = studentR.findStudentByEmail(st.getEmail());
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		studentR.save(st);
		return "You've signed up successfully.";
	}

	public String joinCourse(Long studentId, Long courseId){
		//ana 3amel function fel 2 repositories el mfrood btrg3 1 student, 2o 1 course.
		//7awelt 2st5dmha, wel mfrood hya btrg3 f3ln student/course, then el mfrood 2kml 23ml add le dah, we add le dah
		//bas hya m4 bt3ml add, el function 4klha 48ala, 34an hya btgbha, we bt3ml add, bas mafee4 7aga btegy fel classes
		//hena ana 2olt hst5dm 7aget el repo nfsha, 2olt momken el mo4kela tkoon fel query 2ly 3mlha, bas same result.

		Student student = studentR.findStudentById(studentId);
		Course course = courseRepository.findCourseByid(courseId);
		if(!student.getCourses().contains(course))
		{
			student.addCourse(course);
			course.addStudent(student);
			studentR.save(student);
			courseRepository.save(course);
			return "Course added successfully";
		}
		else
			return "Course already exists";

	}

	public String removeCourse(Long studentId, Long courseId){
		Student student = studentR.findStudentById(studentId);
		Course course = courseRepository.findCourseByid(courseId);
		if(student.getCourses().contains(course) || course.getStudents().contains(student))
		{
			student.removeCourse(courseId);
			course.removeStudent(studentId);
			return "Course removed successfully";
		}
		else
			return "Course does not exist";

	}

	public Student getStudentById(Long studentId){
		return studentR.findStudentById(studentId);
	}



	public ResponseEntity<Student> signIn(Student st) {
		boolean flag = false;
		Student student = null;
		for (int i = 0; i < studentR.findAll().size(); i++) {
			if (studentR.findAll().get(i).getEmail().equals(st.getEmail())
					&& studentR.findAll().get(i).getPassword().equals(st.getPassword())) {
				student = studentR.findAll().get(i);
				flag = true;

			}

		}

		if (flag == true)
			//return "login successfull.";
			return ResponseEntity.ok(student);
		else
			return (ResponseEntity<Student>) ResponseEntity.internalServerError();

	}



}
