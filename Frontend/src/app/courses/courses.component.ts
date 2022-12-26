import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Courses } from '../courses';
import { CoursesService } from '../courses.service';
import { Student } from '../student';
import { StudentLoginComponent } from '../student-login/student-login.component';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css'],
})
export class CoursesComponent implements OnInit {
  courses: any;
  student: Student;
  selectedStudent: any;
  students: Student[];
  size: number;
  msg = '';

  constructor(
    private courseService: CoursesService,
    private studentService: StudentService
  ) {}

  ngOnInit(): void {
    this.courseService.getCoursesList().subscribe((data) => {
      this.courses = data;
    });
    this.studentService.getStudentsList().subscribe((data) => {
      this.students = data;
      this.size = this.students.length;
    });
    this.studentService
      .getStudentById(Number(sessionStorage.getItem('num')))
      .subscribe((data) => {
        this.selectedStudent = data;
      });
  }

  public joinCourse(id: number) {
    this.selectedStudent.courses.push(this.courses.at(id - 1));
    console.log(this.selectedStudent);
    // console.log(this.student.courses.at(this.student.courses.length - 1)?.id);
    this.courseService.joinCourse(this.selectedStudent).subscribe();
    window.location.reload();
  }
}
