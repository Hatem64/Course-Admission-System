package cloud.task.task5.services;

import cloud.task.task5.entities.Course;
import cloud.task.task5.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public String addCourse(Course course){
        List<Course> courses = courseRepository.findAll();
        boolean flag = false;
        for(int i=0; i<courses.size(); i++){
            if(courses.get(i).getName().equals(course.getName())){
                flag = true;
            }
        }
        if (flag == false) {
            courseRepository.save(course);
            return "Course added successfully";
        }else
            return "Course already exists";
    }

    public String deleteCourse(Long num){

        try {
            courseRepository.deleteById(num);
            return "Course deleted!";
        }catch (Exception e){
            return "Course does not exists";
        }

    }

}
