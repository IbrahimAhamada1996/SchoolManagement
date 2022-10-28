import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Course } from 'src/app/models/course';
import { Employee } from 'src/app/models/employee';
import { CourseService } from 'src/app/services/course.service';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  public form:FormGroup | any;
  public course:Course | any;
  public employees:Employee[]| any;
  public employee:Employee|any;
 
  constructor(private fb:FormBuilder,
    private employeeService:EmployeeService,
    private courseService:CourseService,
    private router:Router) { }

  ngOnInit(): void {
      this.employeeService.getEmployees().subscribe({
        next:(employees:Employee)=>{
          this.employees = employees;
          console.log(this.employees);
        }
      });

      this.form = this.fb.group({
        name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        totalHour: ['',[Validators.required]],
        teachHour:['',[Validators.required]],
        teacher: this.fb.group({
          id:['']
        })
    });
    this.form.get('employee').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getEmployee(value.id)
      }
    })
    console.log(this.form.get('employee'))
  }

  getEmployee(id:any){
    if(id!=null || id!=''){

      this.employeeService.getEmployee(id).subscribe({
        next:(employee:Employee)=>{
          this.employee = employee;
          console.log("employee",employee)
        }
      });
    }
  }
  
  onSubmit() {

    this.form.value.employee = this.employee;
    

    console.log("fromvalue",this.form.value);
    const course: Course={
        ...this.course,
        ...this.form.value
    }
     console.log("befors",course);

    this.courseService.createCourse(course).subscribe({
      next:(course:Course)=>{
        console.log("after",course);
        this.router.navigate(['/admin/courses'])
      }
    })
  }

}
