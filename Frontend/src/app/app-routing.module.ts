import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentLoginComponent } from './student-login/student-login.component';
import { StudentSignupComponent } from './student-signup/student-signup.component';
import { StudentComponent } from './student/student.component';
import { CoursesComponent } from './courses/courses.component';
import { AddCourseComponent } from './add-course/add-course.component';

const routes: Routes = [
  { path: '', component: StudentLoginComponent },
  { path: '', redirectTo: 'studentloginsuccess', pathMatch: 'full' },
  { path: 'studentsignup', component: StudentSignupComponent },
  { path: '', redirectTo: 'studentsignup', pathMatch: 'full' },
  { path: 'studentlogin', component: StudentLoginComponent },
  { path: '', redirectTo: 'adminlogin', pathMatch: 'full' },
  { path: 'appstudent', component: StudentComponent },
  { path: 'appcourses', component: CoursesComponent },
  { path: 'appaddcourse', component: AddCourseComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
