import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Courses } from './courses';
import { Student } from './student';

headers: new HttpHeaders({
  'Access-Control-Allow-Headers': 'Content-Type',
  'Access-Control-Allow-Methods': 'GET',
  'Access-Control-Allow-Origin': '*',
});

@Injectable({
  providedIn: 'root',
})
export class CoursesService {
  constructor(private http: HttpClient) {}

  public getCoursesList(): Observable<object> {
    return this.http.get('http://localhost:8080/api/student/getCourses');
  }

  public addCourse(course: Courses): Observable<Courses> {
    return this.http.post<Courses>(
      'http://localhost:8080/api/course/addCourse',
      course
    );
  }

  public joinCourse(student: Student): Observable<any> {
    return this.http.post(
      `http://localhost:8080/api/student/joinCourse/${student.id_student}/${
        student.courses.at(student.courses.length - 1)?.id
      }`,
      null
    );
  }
}
