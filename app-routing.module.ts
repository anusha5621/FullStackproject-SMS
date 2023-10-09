import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateStudentComponent } from './create-student/create-student.component';
import { StudentListComponent } from './student-list/student-list.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { ViewStudentComponent } from './view-student/view-student.component';
import { AuthGuardService } from './auth-guard.service';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';

import { AboutusComponent } from './aboutus/aboutus.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { SchoollistComponent } from './schoollist/schoollist.component';

import { TeacherlistComponent } from './teacherlist/teacherlist.component';
import { CreateschoolComponent } from './createschool/createschool.component';
import { CreateteacherComponent } from './createteacher/createteacher.component';
import { ViewschoolComponent } from './viewschool/viewschool.component';
import { UpdateschoolComponent } from './updateschool/updateschool.component';
import { ViewteacherComponent } from './viewteacher/viewteacher.component';
import { UpdateteacherComponent } from './updateteacher/updateteacher.component';
import { ContactusComponent } from './contactus/contactus.component';
import { CreateclassroomComponent } from './createclassroom/createclassroom.component';
import { UpdateclassroomComponent } from './updateclassroom/updateclassroom.component';
import { ViewclassroomComponent } from './viewclassroom/viewclassroom.component';
import { ClassroomlistComponent } from './classroomlist/classroomlist.component';
import { AddfeedbackComponent } from './addfeedback/addfeedback.component';
import { ViewfeedbackComponent } from './viewfeedback/viewfeedback.component';
const routes: Routes = [
  {path: 'see-all-schools', component: SchoollistComponent, canActivate:[AuthGuardService]},
  {path: 'see-all-students', component: StudentListComponent,canActivate:[AuthGuardService]},
  {path: 'see-all-classRooms', component:ClassroomlistComponent, canActivate:[AuthGuardService]},
  {path: 'see-all-teachers', component: TeacherlistComponent, canActivate:[AuthGuardService]},
  {path:'',redirectTo: 'signin', pathMatch:'full'},
  {path: 'library', component: StudentListComponent},
  {path: 'librarysch', component: SchoollistComponent},
  {path: 'create-classRoom', component: CreateclassroomComponent,canActivate:[AuthGuardService]},
  {path: 'create-teacher', component: CreateteacherComponent,canActivate:[AuthGuardService]},
  {path: 'create-school', component: CreateschoolComponent,canActivate:[AuthGuardService]},
  {path: 'update-classRoom/:id', component: UpdateclassroomComponent,canActivate:[AuthGuardService]},
  {path: 'update-school/:id', component: UpdateschoolComponent,canActivate:[AuthGuardService]},
  {path: 'create-student', component: CreateStudentComponent,canActivate:[AuthGuardService]},
  {path: 'update-teacher/:id', component: UpdateteacherComponent,canActivate:[AuthGuardService]},
  {path: 'update-student/:id', component: UpdateStudentComponent,canActivate:[AuthGuardService]},
  {path: 'view-student-details/:id', component: ViewStudentComponent,canActivate:[AuthGuardService]},
  {path: 'view-school-details/:id', component: ViewschoolComponent,canActivate:[AuthGuardService]},
  {path: 'view-teacher-details/:id', component: ViewteacherComponent,canActivate:[AuthGuardService]},
  {path: 'view-classRoom-details/:id', component: ViewclassroomComponent,canActivate:[AuthGuardService]},
  {path: 'feedback/:id', component: ViewfeedbackComponent,canActivate:[AuthGuardService]},
  {path: 'sign-in',component:SigninComponent},
  {path: 'sign-up',component:SignupComponent},
  { path: 'about-us', component: AboutusComponent },
  { path: 'contact-us', component: ContactusComponent },
  {path:'feed-back',component:FeedbackComponent},
  {path:'add-feedback/:id',component:AddfeedbackComponent},
 
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
}) 
export class AppRoutingModule { }
