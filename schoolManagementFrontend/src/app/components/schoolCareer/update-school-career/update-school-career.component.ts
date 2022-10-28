import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from 'src/app/models/student';
import { SchoolCareer } from 'src/app/models/school-career';
import { StudentService } from 'src/app/services/student.service';
import { SchoolCareerService } from 'src/app/services/school-career.service';

@Component({
  selector: 'app-update-school-career',
  templateUrl: './update-school-career.component.html',
  styleUrls: ['./update-school-career.component.css']
})
export class UpdateSchoolCareerComponent implements OnInit {

  public schoolCareer: SchoolCareer| any;
  public id: number|any;
  public form: FormGroup | any;
  public students:Student[]| any;
  public student:Student| any;

  constructor(private fb: FormBuilder,
    private schoolCareerService: SchoolCareerService,
    private studentService:StudentService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

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
  
    this.id = this.route.snapshot.params["id"]
    this.schoolCareerService.getSchoolCareer(this.id).subscribe({
      next:(schoolCareer:SchoolCareer)=>this.displaySchoolCareer(schoolCareer),
      error:(error)=>console.error(error)
      
    }
    );

    this.form.get('student').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getStudent(value.id)
      }
    })
   
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

 
   
  displaySchoolCareer(schoolCareer:SchoolCareer) {
    this.schoolCareer = schoolCareer;
    console.log(schoolCareer);
    this.form.patchValue({
      year:this.schoolCareer.year,
      level: this.schoolCareer.level,
      faculty:this.schoolCareer.faculty,
      school: this.schoolCareer.schedule,
      results: this.schoolCareer.results,
      student: this.schoolCareer.student
    })
    
  }
  // Update schoolCareer data
  edite(){
    this.form.value.student= this.student;
    const schoolCareer: SchoolCareer = {
      ...this.schoolCareer,
      ...this.form.value
    };
    console.log(schoolCareer);
      this.schoolCareerService.updateSchoolCareer(this.id,schoolCareer).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/schoolCareers']);
  }

}
