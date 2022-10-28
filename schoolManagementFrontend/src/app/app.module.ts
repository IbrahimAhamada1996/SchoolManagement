import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule,ReactiveFormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';


import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {FooterComponent} from './layouts/footer/footer.component';
import {HomeComponent} from './components/home/home.component';
import {HeaderComponent} from './layouts/header/header.component';
import {SiderbarComponent} from './layouts/siderbar/siderbar.component';
import {ProfileComponent} from './components/profile/profile.component';
import {AddStudentComponent} from './components/student/add-student/add-student.component';
import { AddDepartmentComponent } from './components/department/add-department/add-department.component';
import { UpdateDepartmentComponent } from './components/department/update-department/update-department.component';
import { DeleteDepartmentComponent } from './components/department/delete-department/delete-department.component';
import { ListDepartmentComponent } from './components/department/list-department/list-department.component';
import { AddFacultyComponent } from './components/faculty/add-faculty/add-faculty.component';
import { DeteteFacultyComponent } from './components/faculty/detete-faculty/detete-faculty.component';
import { ListFacultyComponent } from './components/faculty/list-faculty/list-faculty.component';
import { UpdateFacultyComponent } from './components/faculty/update-faculty/update-faculty.component';
import { AddEmployeeComponent } from './components/employee/add-employee/add-employee.component';
import { DeleteEmployeeComponent } from './components/employee/delete-employee/delete-employee.component';
import { ListEmployeeComponent } from './components/employee/list-employee/list-employee.component';
import { UpdateEmployeeComponent } from './components/employee/update-employee/update-employee.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DetailEmployeeComponent } from './components/employee/detail-employee/detail-employee.component';
import { AddGradeComponent } from './components/grade/add-grade/add-grade.component';
import { UpdateGradeComponent } from './components/grade/update-grade/update-grade.component';
import { DeleteGradeComponent } from './components/grade/delete-grade/delete-grade.component';
import { AddLevelComponent } from './components/level/add-level/add-level.component';
import { UpdateLevelComponent } from './components/level/update-level/update-level.component';
import { DeleteLevelComponent } from './components/level/delete-level/delete-level.component';
import { ListLevelComponent } from './components/level/list-level/list-level.component';
import { AddUnityComponent } from './components/unity/add-unity/add-unity.component';
import { ListUnityComponent } from './components/unity/list-unity/list-unity.component';
import { DeleteUnityComponent } from './components/unity/delete-unity/delete-unity.component';
import { UpdateUnityComponent } from './components/unity/update-unity/update-unity.component';
import { UpdateModuleComponent } from './components/module/update-module/update-module.component';
import { AddModuleComponent } from './components/module/add-module/add-module.component';
import { DeleteModuleComponent } from './components/module/delete-module/delete-module.component';
import { ListModuleComponent } from './components/module/list-module/list-module.component';
import { ListInscriptionComponent } from './components/inscription/list-inscription/list-inscription.component';
import { AddInscriptionComponent } from './components/inscription/add-inscription/add-inscription.component';
import { UpdateInscriptionComponent } from './components/inscription/update-inscription/update-inscription.component';
import { DeleteInscriptionComponent } from './components/inscription/delete-inscription/delete-inscription.component';
import { DetailInscriptionComponent } from './components/inscription/detail-inscription/detail-inscription.component';
import { AddSessionComponent } from './components/session/add-session/add-session.component';
import { ListSessionComponent } from './components/session/list-session/list-session.component';
import { UpdateSessionComponent } from './components/session/update-session/update-session.component';
import { UpdatePaymentComponent } from './components/payment/update-payment/update-payment.component';
import { AddPaymentComponent } from './components/payment/add-payment/add-payment.component';
import { ListPaymentComponent } from './components/payment/list-payment/list-payment.component';
import { DetailPaymentComponent } from './components/payment/detail-payment/detail-payment.component';
import { AddScheduleComponent } from './components/schedule/add-schedule/add-schedule.component';
import { UpdateScheduleComponent } from './components/schedule/update-schedule/update-schedule.component';
import { DeleteScheduleComponent } from './components/schedule/delete-schedule/delete-schedule.component';
import { DeleteClassroomComponent } from './components/classroom/delete-classroom/delete-classroom.component';
import { AddClassroomComponent } from './components/classroom/add-classroom/add-classroom.component';
import { UpdateClassroomComponent } from './components/classroom/update-classroom/update-classroom.component';
import { UpdateCourseComponent } from './components/course/update-course/update-course.component';
import { AddCourseComponent } from './components/course/add-course/add-course.component';
import { ListCourseComponent } from './components/course/list-course/list-course.component';
import { AddDeadlineComponent } from './components/deadline/add-deadline/add-deadline.component';
import { UpdateDeadlineComponent } from './components/deadline/update-deadline/update-deadline.component';
import { DeleteDeadlineComponent } from './components/deadline/delete-deadline/delete-deadline.component';
import { DeletePaymentComponent } from './components/payment/delete-payment/delete-payment.component';
import { AddSchoolCareerComponent } from './components/schoolCareer/add-school-career/add-school-career.component';
import { ListSchoolCareerComponent } from './components/schoolCareer/list-school-career/list-school-career.component';
import { UpdateSchoolCareerComponent } from './components/schoolCareer/update-school-career/update-school-career.component';
import { DeleleSchoolCareerComponent } from './components/schoolCareer/delele-school-career/delele-school-career.component';
import { DeleleEstablishmentComponent } from './components/establishment/delele-establishment/delele-establishment.component';
import { AddEstablishmentComponent } from './components/establishment/add-establishment/add-establishment.component';
import { ListStudentComponent } from './components/student/list-student/list-student.component';
import { UpdateStudentComponent } from './components/student/update-student/update-student.component';
import { DeleteStudentComponent } from './components/student/delete-student/delete-student.component';
import { DetailStudentComponent } from './components/student/detail-student/detail-student.component';
import { ListGradeComponent } from './components/grade/list-grade/list-grade.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FooterComponent,
    HomeComponent,
    HeaderComponent,
    SiderbarComponent,
    ProfileComponent,
    AddStudentComponent,
    AddDepartmentComponent,
    UpdateDepartmentComponent,
    DeleteDepartmentComponent,
    ListDepartmentComponent,
    AddFacultyComponent,
    DeteteFacultyComponent,
    ListFacultyComponent,
    UpdateFacultyComponent,
    AddEmployeeComponent,
    DeleteEmployeeComponent,
    ListEmployeeComponent,
    UpdateEmployeeComponent,
    DetailEmployeeComponent,
    AddGradeComponent,
    UpdateGradeComponent,
    DeleteGradeComponent,
    AddLevelComponent,
    UpdateLevelComponent,
    DeleteLevelComponent,
    ListLevelComponent,
    AddUnityComponent,
    ListUnityComponent,
    DeleteUnityComponent,
    UpdateUnityComponent,
    UpdateModuleComponent,
    AddModuleComponent,
    DeleteModuleComponent,
    ListModuleComponent,
    ListInscriptionComponent,
    AddInscriptionComponent,
    UpdateInscriptionComponent,
    DeleteInscriptionComponent,
    DetailInscriptionComponent,
    AddSessionComponent,
    ListSessionComponent,
    UpdateSessionComponent,
    UpdatePaymentComponent,
    AddPaymentComponent,
    ListPaymentComponent,
    DetailPaymentComponent,
    AddScheduleComponent,
    UpdateScheduleComponent,
    DeleteScheduleComponent,
    DeleteClassroomComponent,
    AddClassroomComponent,
    UpdateClassroomComponent,
    UpdateCourseComponent,
    AddCourseComponent,
    ListCourseComponent,
    AddDeadlineComponent,
    UpdateDeadlineComponent,
    DeleteDeadlineComponent,
    DeletePaymentComponent,
    AddSchoolCareerComponent,
    ListSchoolCareerComponent,
    UpdateSchoolCareerComponent,
    DeleleSchoolCareerComponent,
    DeleleEstablishmentComponent,
    AddEstablishmentComponent,
    ListStudentComponent,
    UpdateStudentComponent,
    DeleteStudentComponent,
    DetailStudentComponent,
    ListGradeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
