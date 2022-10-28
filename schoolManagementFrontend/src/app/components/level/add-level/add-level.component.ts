import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Grade } from 'src/app/models/grade';
import { Level } from 'src/app/models/level';
import { GradeService } from 'src/app/services/grade.service';
import { LevelService } from 'src/app/services/level.service';

@Component({
  selector: 'app-add-level',
  templateUrl: './add-level.component.html',
  styleUrls: ['./add-level.component.css']
})
export class AddLevelComponent implements OnInit {

  public form:FormGroup | any;
  public level:Level| any;
  public grades:Grade[]| any;
  public grade:Grade|any;
 
  constructor(private fb:FormBuilder,
    private gradeService:GradeService,
    private levelService:LevelService,
    private router:Router) { }

  ngOnInit(): void {
      this.gradeService.getGrades().subscribe({
        next:(grades:Grade)=>{
          this.grades = grades;
          console.log(this.grades);
        }
      });

      this.form = this.fb.group({
        name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        semester:  ['',[Validators.required]],
        grade: this.fb.group({
          id:['']
        })
    });
    this.form.get('grade').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getGrade(value.id)
      }
    })
    console.log(this.form.get('grade'))
  }

  getGrade(id:any){
    if(id!=null || id!=''){

      this.gradeService.getGrade(id).subscribe({
        next:(grade:Grade)=>{
          this.grade = grade;
          console.log("grade",grade)
        }
      });
    }
  }
  
  onSubmit() {

    this.form.value.grade = this.grade;
    

    console.log("fromvalue",this.form.value);
    const level: Level={
        ...this.level,
        ...this.form.value
    }
     console.log("befors",level);

    this.levelService.createLevel(level).subscribe({
      next:(level:Level)=>{
        console.log("after",level);
        this.router.navigate(['/admin/levels'])
      }
    })
  }
}
