import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from 'src/app/models/department';
import { Employee } from 'src/app/models/employee';
import { DepartmentService } from 'src/app/services/department.service';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-update-department',
  templateUrl: './update-department.component.html',
  styleUrls: ['./update-department.component.css']
})
export class UpdateDepartmentComponent implements OnInit {

  public department: Department| any;
  public id: number|any;
  public form: FormGroup | any;
  public employees:Employee[]| any;
  public employee:Employee| any;

  constructor(private fb: FormBuilder,
    private departmentService: DepartmentService,
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
      employee: this.fb.group({
        id:['']
      })
  });
  
    this.id = this.route.snapshot.params["id"]
    this.departmentService.getDepartment(this.id).subscribe({
      next:(department:Department)=>this.displayDepartment(department),
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

 
   
  displayDepartment(department:Department) {
    this.department = department;
    console.log(department);
    this.form.patchValue({
      name: this.department.name,
      employee: this.department.employee
    })
    
  }
  // Update department data
  edite(){
    this.form.value.employee= this.employee;
    const department: Department = {
      ...this.department,
      ...this.form.value
    };
    console.log(department);
      this.departmentService.updateDepartment(this.id,department).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/departments']);
  }

}
