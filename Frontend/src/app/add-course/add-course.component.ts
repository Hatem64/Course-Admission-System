import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Courses } from '../courses';
import { CoursesService } from '../courses.service';
import { Student } from '../student';
import { StudentLoginComponent } from '../student-login/student-login.component';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css'],
})
export class AddCourseComponent implements OnInit {
  courses: any;
  course: Courses = new Courses();
  student: Student;
  constructor(private courseService: CoursesService, private router: Router) {}

  ngOnInit(): void {}

  public addCourse() {
    this.courseService.addCourse(this.course).subscribe(
      (data) => {
        console.log(data);
        this.goToCourseList();
      },
      (error) => console.log(error)
    );
  }

  public goToCourseList() {
    this.router.navigate(['/appcourses']);
  }

  public onSubmit() {
    console.log(this.course);
    this.addCourse();
  }
}
