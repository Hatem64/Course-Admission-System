import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StudentService } from '../student.service';
import { Route, Router } from '@angular/router';
import { Student } from '../student';
import { BehaviorSubject } from 'rxjs';
import { CoursesComponent } from '../courses/courses.component';
import { CoursesService } from '../courses.service';

@Component({
  selector: 'app-student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css'],
  // providers: [CoursesComponent],
})
export class StudentLoginComponent implements OnInit {
  newStudent = new Student();
  student: Student;
  msg = '';
  students: Student[];
  // sessionStorage: WindowSessionStorage;

  constructor(
    private _Service: StudentService,
    private _router: Router // private course: CoursesComponent
  ) {}

  ngOnInit(): void {
    this._Service.getStudentsList().subscribe((data) => {
      this.students = data;
    });
  }

  SignInStudent() {
    this._Service.loginStudentFromRemote(this.newStudent).subscribe(
      (data) => {
        for (let i = 0; i < this.students.length; i++) {
          if (this.students.at(i)?.email === this.newStudent.email) {
            // console.log(this.students.at(i));
            // this.course.setStudent(this.students.at(i)!);
            sessionStorage.setItem('num',this.students.at(i)!.id_student.toString()
            );
          }
        }
        this._router.navigate(['/appstudent']);
      },
      (error) => {
        alert('Login failed');
        this.msg = 'Bad credntials, Please enter valid username and password';
      }
    );
  }

  NewAccount() {
    this._router.navigate(['/studentsignup']);
  }
}
