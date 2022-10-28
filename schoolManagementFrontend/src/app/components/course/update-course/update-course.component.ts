import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from 'src/app/models/course';
import { Employee } from 'src/app/models/employee';
import { CourseService } from 'src/app/services/course.service';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrls: ['./update-course.component.css']
})
export class UpdateCourseComponent implements OnInit {

  public course: Course| any;
  public id: number|any;
  public form: FormGroup | any;
  public employees:Employee[]| any;
  public employee:Employee| any;

  constructor(private fb: FormBuilder,
    private courseService: CourseService,
    private employeeService:EmployeeService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

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
    })
  
    this.id = this.route.snapshot.params["id"];
    this.courseService.getCourse(this.id).subscribe({
      next:(course:Course)=>this.displayCourse(course),
      error:(error)=>console.error(error)
      
    }
    );

    this.form.get('employee').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getEmployee(value.id)
      }
    })
   
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

 
   
  displayCourse(course:Course) {
    this.course = course;
    console.log(course);
    this.form.patchValue({
      name: this.course.name,
      totalHour: this.course.totalHour,
      teachHour:this.course.teachHour,
      teacher: this.course.employee
    })
    
  }
  // Update course data
  edite(){
    this.form.value.teacher= this.employee;
    const course: Course = {
      ...this.course,
      ...this.form.value
    };
    console.log(course);
      this.courseService.updateCourse(this.id,course).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/courses']);
  }

}
