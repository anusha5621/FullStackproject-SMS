import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CreateStudentComponent } from './create-student/create-student.component';
import { StudentListComponent } from './student-list/student-list.component';
import { ViewStudentComponent } from './view-student/view-student.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { AuthGuardService } from './auth-guard.service';
import { AboutusComponent } from './aboutus/aboutus.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { CreateteacherComponent } from './createteacher/createteacher.component';
import { ViewteacherComponent } from './viewteacher/viewteacher.component';
import { UpdateteacherComponent } from './updateteacher/updateteacher.component';
import { TeacherlistComponent } from './teacherlist/teacherlist.component';
import { CreateschoolComponent } from './createschool/createschool.component';
import { ViewschoolComponent } from './viewschool/viewschool.component';
import { UpdateschoolComponent } from './updateschool/updateschool.component';
import { SchoollistComponent } from './schoollist/schoollist.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { ContactusComponent } from './contactus/contactus.component';
import { AddfeedbackComponent } from './addfeedback/addfeedback.component';
import { ClassroomlistComponent } from './classroomlist/classroomlist.component';
import { CreateclassroomComponent } from './createclassroom/createclassroom.component';
import { UpdateclassroomComponent } from './updateclassroom/updateclassroom.component';
import { ViewclassroomComponent } from './viewclassroom/viewclassroom.component';
import { ViewfeedbackComponent } from './viewfeedback/viewfeedback.component';



@NgModule({
  declarations: [
    AppComponent,
   CreateStudentComponent,
    StudentListComponent,
    ViewStudentComponent,
    UpdateStudentComponent,
    SigninComponent,
    SignupComponent,
    AboutusComponent,
    FeedbackComponent,
    CreateteacherComponent,
    ViewteacherComponent,
    UpdateteacherComponent,
    TeacherlistComponent,
    CreateschoolComponent,
    ViewschoolComponent,
    UpdateschoolComponent,
    SchoollistComponent,
   
    ContactusComponent,
    AddfeedbackComponent,
    ClassroomlistComponent,
    CreateclassroomComponent,
    UpdateclassroomComponent,
    ViewclassroomComponent,
    ViewfeedbackComponent,

   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    AuthGuardService,
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
  
})
export class AppModule { }

