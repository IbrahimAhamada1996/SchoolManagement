import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Grade } from 'src/app/models/grade';
import { Level } from 'src/app/models/level';
import { GradeService } from 'src/app/services/grade.service';
import { LevelService } from 'src/app/services/level.service';

@Component({
  selector: 'app-update-level',
  templateUrl: './update-level.component.html',
  styleUrls: ['./update-level.component.css']
})
export class UpdateLevelComponent implements OnInit {

  public level: Level| any;
  public id: number|any;
  public form: FormGroup | any;
  public grades:Grade[]| any;
  public grade:Grade| any;

  constructor(private fb: FormBuilder,
    private levelService: LevelService,
    private gradeService:GradeService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

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
  
    this.id = this.route.snapshot.params["id"]
    this.levelService.getLevel(this.id).subscribe({
      next:(level:Level)=>this.displayLevel(level),
      error:(error)=>console.error(error)
      
    }
    );

    this.form.get('grade').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getGrade(value.id)
      }
    })
   
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

 
   
  displayLevel(level:Level) {
    this.level = level;
    console.log(level);
    this.form.patchValue({
      name: this.level.name,
      grade: this.level.grade
    })
    
  }
  // Update level data
  edite(){
    this.form.value.grade= this.grade;
    const level: Level = {
      ...this.level,
      ...this.form.value
    };
    console.log(level);
      this.levelService.updateLevel(this.id,level).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/levels']);
  }
}
