package cloud.task.task5.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_student;
	private String name;
	private String email;

	public Student(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	private String password;

	@ManyToMany
	@JoinTable(
			name = "StudentxCourse",
			joinColumns = @JoinColumn(name = "id_student"),
			inverseJoinColumns = @JoinColumn(name = "id")
	)
	@JsonIgnoreProperties("students")
	private List<Course> courses = new ArrayList<Course>();

	public Student() {}
	public Student(Long id_student, String name, String email, String password, List<Course> courses) {
		this.id_student = id_student;
		this.name = name;
		this.email = email;
		this.password = password;
		this.courses = courses;
	}
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course){
		courses.add(course);
	}

	public void removeCourse(Long id){
		Course course = this.courses.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
		if(course != null){
			this.courses.remove(course);
			course.getStudents().remove(this);
		}
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Long getId_student() {
		return id_student;
	}
	public void setId_student(Long id_student) {
		this.id_student = id_student;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


}