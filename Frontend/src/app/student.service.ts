import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';
import { HttpClient, HttpHeaders } from '@angular/common/http';

headers: new HttpHeaders({
  'Access-Control-Allow-Headers': 'Content-Type',
  'Access-Control-Allow-Methods': 'GET',
  'Access-Control-Allow-Origin': '*',
});

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  constructor(private _http: HttpClient, private http: HttpClient) {}
  public loginStudentFromRemote(student: Student): Observable<object> {
    return this._http.post<Student>(
      'http://localhost:8080/api/student/signIn',
      student
    );
  }
  public signupStudentFromRemote(student: Student): Observable<any> {
    return this._http.post<any>(
      'http://localhost:8080/api/student/signUp',
      student
    );
  }
  public getStudentsList(): Observable<Student[]> {
    return this.http.get<Student[]>(
      'http://localhost:8080/api/student/getStudents'
    );
  }
  public getStudentById(studentid: number): Observable<Student> {
    return this.http.get<Student>(
      `http://localhost:8080/api/student/getStudent/${studentid}`
    );
  }
}
