
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-signup',
  templateUrl: './student-signup.component.html',
  styleUrls: ['./student-signup.component.css']
})
export class StudentSignupComponent implements OnInit{

    student = new Student();
    msg = '';
  
    constructor(private _Service: StudentService, private _router: Router) { }
  
    ngOnInit(): void {
    }
    SignUpStudent()
    {
      this._Service.signupStudentFromRemote(this.student).subscribe(
        data=> {console.log("Response received");
      this.msg="Registration successful"},
        error =>{console.log("exception occured");
        this.msg=error.error;
      }
        
        
      )
     
      
   
    }
  
  }
  

