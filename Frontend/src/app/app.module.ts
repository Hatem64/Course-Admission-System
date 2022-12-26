import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentSignupComponent } from './student-signup/student-signup.component';
import { StudentLoginComponent } from './student-login/student-login.component';
import { CoursesComponent } from './courses/courses.component';
import { StudentComponent } from './student/student.component';
import { AddCourseComponent } from './add-course/add-course.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentSignupComponent,
    StudentLoginComponent,
    CoursesComponent,
    StudentComponent,
    AddCourseComponent,
  ],

  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [CoursesComponent],
  bootstrap: [AppComponent],
})
export class AppModule {}
