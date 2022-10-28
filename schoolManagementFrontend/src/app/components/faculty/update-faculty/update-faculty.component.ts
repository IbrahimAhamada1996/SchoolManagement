import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from 'src/app/models/department';
import { Faculty } from 'src/app/models/faculty';
import { DepartmentService } from 'src/app/services/department.service';
import { FacultyService } from 'src/app/services/faculty.service';

@Component({
  selector: 'app-update-faculty',
  templateUrl: './update-faculty.component.html',
  styleUrls: ['./update-faculty.component.css']
})
export class UpdateFacultyComponent implements OnInit {

  public faculty: Faculty| any;
  public id: number|any;
  public form: FormGroup | any;
  public departments:Department[]| any;
  public department:Department| any;

  constructor(private fb: FormBuilder,
    private facultyService: FacultyService,
    private departmentService:DepartmentService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

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
  
    this.id = this.route.snapshot.params["id"]
    this.facultyService.getFaculty(this.id).subscribe({
      next:(faculty:Faculty)=>this.displayFaculty(faculty),
      error:(error)=>console.error(error)
      
    }
    );

    this.form.get('department').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getDepartment(value.id)
      }
    })
   
  }
  getDepartment(id:any){
    if(id!=null || id!=''){

      this.departmentService.getDepartment(id).subscribe({
        next:(department:Department)=>{
          this.department = department;
          console.log("department",department)
        }
      });
    }
  }

 
   
  displayFaculty(faculty:Faculty) {
    this.faculty = faculty;
    console.log(faculty);
    this.form.patchValue({
      name: this.faculty.name,
      department: this.faculty.department
    })
    
  }
  // Update faculty data
  edite(){
    this.form.value.department= this.department;
    const faculty: Faculty = {
      ...this.faculty,
      ...this.form.value
    };
    console.log("edite");
      this.facultyService.updateFaculty(this.id,faculty).subscribe({
        next:(faculty:Faculty)=>{
          console.log(faculty);
          this.resetCompleted()
        },
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/faculties']);
  }

}
