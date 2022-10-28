import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup,FormBuilder, Validators, FormArray } from '@angular/forms';
import { Router } from '@angular/router';
import { Department } from 'src/app/models/department';
import { Employee } from 'src/app/models/employee';
import { DepartmentService } from 'src/app/services/department.service';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-add-department',
  templateUrl: './add-department.component.html',
  styleUrls: ['./add-department.component.css']
})
export class AddDepartmentComponent implements OnInit {
  public form:FormGroup | any;
  public department:Department | any;
  public employees:Employee[]| any;
  public employee:Employee|any;
 
  constructor(private fb:FormBuilder,
    private employeeService:EmployeeService,
    private departmentService:DepartmentService,
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
        employee: this.fb.group({
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
    const department: Department={
        ...this.department,
        ...this.form.value
    }
     console.log("befors",department);

    this.departmentService.createDepartment(department).subscribe({
      next:(department:Department)=>{
        console.log("after",department);
        this.router.navigate(['/admin/departments'])
      }
    })
  }
}
