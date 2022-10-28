import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './login/login.component';
import {PageNotFoundComponent} from './page-error/page-not-found/page-not-found.component';
import {ProfileComponent} from './components/profile/profile.component';
import {AddStudentComponent} from './components/student/add-student/add-student.component';
import { ListDepartmentComponent } from './components/department/list-department/list-department.component';
import { AddDepartmentComponent } from './components/department/add-department/add-department.component';
import { UpdateDepartmentComponent } from './components/department/update-department/update-department.component';
import { DeleteDepartmentComponent } from './components/department/delete-department/delete-department.component';
import { ListEmployeeComponent } from './components/employee/list-employee/list-employee.component';
import { AddEmployeeComponent } from './components/employee/add-employee/add-employee.component';
import { UpdateEmployeeComponent } from './components/employee/update-employee/update-employee.component';
import { DeleteEmployeeComponent } from './components/employee/delete-employee/delete-employee.component';
import { DetailEmployeeComponent } from './components/employee/detail-employee/detail-employee.component';
import { ListFacultyComponent } from './components/faculty/list-faculty/list-faculty.component';
import { AddFacultyComponent } from './components/faculty/add-faculty/add-faculty.component';
import { UpdateFacultyComponent } from './components/faculty/update-faculty/update-faculty.component';
import { DeteteFacultyComponent } from './components/faculty/detete-faculty/detete-faculty.component';
import { AddClassroomComponent } from './components/classroom/add-classroom/add-classroom.component';
import { UpdateClassroomComponent } from './components/classroom/update-classroom/update-classroom.component';
import { DeleteClassroomComponent } from './components/classroom/delete-classroom/delete-classroom.component';
import { ListCourseComponent } from './components/course/list-course/list-course.component';
import { AddCourseComponent } from './components/course/add-course/add-course.component';
import { UpdateCourseComponent } from './components/course/update-course/update-course.component';
import { AddDeadlineComponent } from './components/deadline/add-deadline/add-deadline.component';
import { UpdateDeadlineComponent } from './components/deadline/update-deadline/update-deadline.component';
import { DeleteDeadlineComponent } from './components/deadline/delete-deadline/delete-deadline.component';
import { AddEstablishmentComponent } from './components/establishment/add-establishment/add-establishment.component';
import { DeleleEstablishmentComponent } from './components/establishment/delele-establishment/delele-establishment.component';
import { AddGradeComponent } from './components/grade/add-grade/add-grade.component';
import { UpdateGradeComponent } from './components/grade/update-grade/update-grade.component';
import { DeleteGradeComponent } from './components/grade/delete-grade/delete-grade.component';
import { ListInscriptionComponent } from './components/inscription/list-inscription/list-inscription.component';
import { AddInscriptionComponent } from './components/inscription/add-inscription/add-inscription.component';
import { UpdateInscriptionComponent } from './components/inscription/update-inscription/update-inscription.component';
import { DeleteInscriptionComponent } from './components/inscription/delete-inscription/delete-inscription.component';
import { ListLevelComponent } from './components/level/list-level/list-level.component';
import { AddLevelComponent } from './components/level/add-level/add-level.component';
import { UpdateLevelComponent } from './components/level/update-level/update-level.component';
import { DeleteLevelComponent } from './components/level/delete-level/delete-level.component';
import { ListModuleComponent } from './components/module/list-module/list-module.component';
import { AddModuleComponent } from './components/module/add-module/add-module.component';
import { UpdateModuleComponent } from './components/module/update-module/update-module.component';
import { DeleteModuleComponent } from './components/module/delete-module/delete-module.component';
import { ListPaymentComponent } from './components/payment/list-payment/list-payment.component';
import { AddPaymentComponent } from './components/payment/add-payment/add-payment.component';
import { UpdatePaymentComponent } from './components/payment/update-payment/update-payment.component';
import { DeletePaymentComponent } from './components/payment/delete-payment/delete-payment.component';
import { DetailPaymentComponent } from './components/payment/detail-payment/detail-payment.component';
import { AddScheduleComponent } from './components/schedule/add-schedule/add-schedule.component';
import { UpdateScheduleComponent } from './components/schedule/update-schedule/update-schedule.component';
import { DeleteScheduleComponent } from './components/schedule/delete-schedule/delete-schedule.component';
import { ListSchoolCareerComponent } from './components/schoolCareer/list-school-career/list-school-career.component';
import { ListSessionComponent } from './components/session/list-session/list-session.component';
import { AddSessionComponent } from './components/session/add-session/add-session.component';
import { UpdateSessionComponent } from './components/session/update-session/update-session.component';
import { ListStudentComponent } from './components/student/list-student/list-student.component';
import { UpdateStudentComponent } from './components/student/update-student/update-student.component';
import { DeleteStudentComponent } from './components/student/delete-student/delete-student.component';
import { DetailStudentComponent } from './components/student/detail-student/detail-student.component';
import { ListUnityComponent } from './components/unity/list-unity/list-unity.component';
import { AddUnityComponent } from './components/unity/add-unity/add-unity.component';
import { UpdateUnityComponent } from './components/unity/update-unity/update-unity.component';
import { DeleteUnityComponent } from './components/unity/delete-unity/delete-unity.component';
import { AddSchoolCareerComponent } from './components/schoolCareer/add-school-career/add-school-career.component';
import { UpdateSchoolCareerComponent } from './components/schoolCareer/update-school-career/update-school-career.component';
import { ListGradeComponent } from './components/grade/list-grade/list-grade.component';

const routes: Routes = [

  {path: 'login', component: LoginComponent},
  {path: 'admin/home', component: HomeComponent},
  {path: 'admin/profile', component: ProfileComponent},
  
  {path: 'admin',
    children:[
      
      {path: 'classrooms',
        children:[
          // {path: "",component:AddClassroomComponent},
          {path: "add",component:AddClassroomComponent},
          {path: "update/:id",component:UpdateClassroomComponent},
          {path: "delete/:id",component:DeleteClassroomComponent},
        ]
      },
      {path: 'courses',
        children:[
          {path: "",component:ListCourseComponent},
          {path: "add",component:AddCourseComponent},
          {path: "update/:id",component:UpdateCourseComponent},
          // {path: "delete/:id",component:DeleteCourse},
        ]
      },
      {path: 'deadlines',
        children:[
          // {path: "",component:DeleteDeadlineComponent},
          {path: "add",component:AddDeadlineComponent},
          {path: "update/:id",component:UpdateDeadlineComponent},
          {path: "delete/:id",component:DeleteDeadlineComponent},
        ]
      },
      {path: 'departments',
        children:[
          {path: "",component:ListDepartmentComponent},
          {path: "add",component:AddDepartmentComponent},
          {path: "update/:id",component:UpdateDepartmentComponent},
          {path: "delete/:id",component:DeleteDepartmentComponent},
        ]
      },
      {path: 'employees',
        children:[
          {path: "",component:ListEmployeeComponent},
          {path: "add",component:AddEmployeeComponent},
          {path: "update/:id",component:UpdateEmployeeComponent},
          {path: "delete/:id",component:DeleteEmployeeComponent},
          {path: "detail/:id",component:DetailEmployeeComponent},
        ]
      },
      {path: 'establishments',
        children:[
          // {path: "",component:AddEstablishmentComponent},
          {path: "add",component:AddEstablishmentComponent},
          // {path: "update/:id",component:DeleleEstablishmentComponent},
          {path: "delete/:id",component:DeleleEstablishmentComponent},
        ]
      },
      {path: 'faculties',
        children:[
          {path: "",component:ListFacultyComponent},
          {path: "add",component:AddFacultyComponent},
          {path: "update/:id",component:UpdateFacultyComponent},
          {path: "delete/:id",component:DeteteFacultyComponent},
        ]
      },
      {path: 'grades',
        children:[
          {path: "",component:ListGradeComponent},
          {path: "add",component:AddGradeComponent},
          {path: "update/:id",component:UpdateGradeComponent},
          {path: "delete/:id",component:DeleteGradeComponent},
        ]
      },
      {path: 'inscriptions',
        children:[
          {path: "",component:ListInscriptionComponent},
          {path: "add",component:AddInscriptionComponent},
          {path: "update/:id",component:UpdateInscriptionComponent},
          {path: "delete/:id",component:DeleteInscriptionComponent},
        ]
      },
      {path: 'levels',
        children:[
          {path: "",component:ListLevelComponent},
          {path: "add",component:AddLevelComponent},
          {path: "update/:id",component:UpdateLevelComponent},
          {path: "delete/:id",component:DeleteLevelComponent},
        ]
      },
      {path: 'modules',
        children:[
          {path: "",component:ListModuleComponent},
          {path: "add",component:AddModuleComponent},
          {path: "update/:id",component:UpdateModuleComponent},
          {path: "delete/:id",component:DeleteModuleComponent},
        ]
      },
      {path: 'payments',
        children:[
          {path: "",component:ListPaymentComponent},
          {path: "add",component:AddPaymentComponent},
          {path: "update/:id",component:UpdatePaymentComponent},
          {path: "delete/:id",component:DeletePaymentComponent},
          {path: "delail/:id",component:DetailPaymentComponent},
        ]
      },
      {path: 'schedules',
        children:[
          // {path: "",component:Schedule},
          {path: "add",component:AddScheduleComponent},
          {path: "update/:id",component:UpdateScheduleComponent},
          {path: "delete/:id",component:DeleteScheduleComponent},
        ]
      },
      {path: 'school-careers',
        children:[
          {path: "",component:ListSchoolCareerComponent},
          {path: "add",component:AddSchoolCareerComponent},
          {path: "update/:id",component:UpdateSchoolCareerComponent},
          // {path: "delete/:id",component:DeleteSchool},
        ]
      },
      {path: 'sessions',
        children:[
          {path: "",component:ListSessionComponent},
          {path: "add",component:AddSessionComponent},
          {path: "update/:id",component:UpdateSessionComponent},
          // {path: "delete/:id",component:UpdateSessionComponent},
        ]
      },
      {path: 'students',
        children:[
          {path: "",component:ListStudentComponent},
          {path: "add",component:AddStudentComponent},
          {path: "update/:id",component:UpdateStudentComponent},
          {path: "delete/:id",component:DeleteStudentComponent},
          {path: "detail/:id",component:DetailStudentComponent},
        ]
      },
      {path: 'unities',
        children:[
          {path: "",component:ListUnityComponent},
          {path: "add",component:AddUnityComponent},
          {path: "update/:id",component:UpdateUnityComponent},
          {path: "delete/:id",component:DeleteUnityComponent},
        ]
      },
    ],
    
  },
 
 
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
