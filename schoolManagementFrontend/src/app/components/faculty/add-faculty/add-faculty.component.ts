import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Department } from 'src/app/models/department';
import { Faculty } from 'src/app/models/faculty';
import { DepartmentService } from 'src/app/services/department.service';
import { FacultyService } from 'src/app/services/faculty.service';

@Component({
  selector: 'app-add-faculty',
  templateUrl: './add-faculty.component.html',
  styleUrls: ['./add-faculty.component.css']
})
export class AddFacultyComponent implements OnInit {

  public form:FormGroup | any;
  public faculty:Faculty| any;
  public departments:Department[] | any;
  public department:Department|any;
 
  constructor(private fb:FormBuilder,
    private facultyService:FacultyService,
    private departmentService:DepartmentService,
    private router:Router) { }

  ngOnInit(): void {
      this.departmentService.getDepartments().subscribe({
        next:(departments:Department)=>{
          this.departments = departments;
          console.log(this.departments);
        }
      });

      this.form = this.fb.group({
        name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        department: this.fb.group({
          id:['']
        })
    });
    this.form.get('department').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getDepartment(value.id)
      }
    })
    console.log(this.form.get('department'))
  }

  getDepartment(id:any){
    if(id!=null || id!=''){

      this.departmentService.getDepartment(id).subscribe({
        next:(department:Department)=>{
          this.department = department;
          console.log("faculty",this.department)
        }
      });
    }
  }
  
  onSubmit() {

    this.form.value.department = this.department;
    

    console.log("fromvalue",this.form.value);
    const faculty: Faculty={
        ...this.faculty,
        ...this.form.value
    }
     console.log("befors",faculty);

    this.facultyService.createFaculty(faculty).subscribe({
      next:(faculty:Faculty)=>{
        console.log("after",faculty);
        this.router.navigate(['/admin/faculties'])
      }
    })
  }

}
