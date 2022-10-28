import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SchoolCareer } from 'src/app/models/school-career';
import { Student } from 'src/app/models/student';
import { SchoolCareerService } from 'src/app/services/school-career.service';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-add-school-career',
  templateUrl: './add-school-career.component.html',
  styleUrls: ['./add-school-career.component.css']
})
export class AddSchoolCareerComponent implements OnInit {

  public form:FormGroup | any;
  public schoolCareer:SchoolCareer | any;
  public students:Student[]| any;
  public student:Student|any;
 
  constructor(private fb:FormBuilder,
    private studentService:StudentService,
    private schoolCareerService:SchoolCareerService,
    private router:Router) { }

  ngOnInit(): void {
      this.studentService.getStudents().subscribe({
        next:(students:Student)=>{
          this.students = students;
          console.log(this.students);
        }
      });

      this.form = this.fb.group({
        year:['',[Validators.required]],
        level: ['',[Validators.required]],
        faculty:['',[Validators.required]],
        school: ['',[Validators.required]],
        results: ['',[Validators.required]],
        student: this.fb.group({
          id:['']
        })
    });
    this.form.get('student').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getStudent(value.id)
      }
    })
    console.log(this.form.get('student'))
  }

  getStudent(id:any){
    if(id!=null || id!=''){

      this.studentService.getStudent(id).subscribe({
        next:(student:Student)=>{
          this.student = student;
          console.log("student",student)
        }
      });
    }
  }
  
  onSubmit() {

    this.form.value.student = this.student;
    

    console.log("fromvalue",this.form.value);
    const schoolCareer: SchoolCareer={
        ...this.schoolCareer,
        ...this.form.value
    }
     console.log("befors",schoolCareer);

    this.schoolCareerService.createSchoolCareer(schoolCareer).subscribe({
      next:(schoolCareer:SchoolCareer)=>{
        console.log("after",schoolCareer);
        this.router.navigate(['/admin/schoolCareers'])
      }
    })
  }
}
