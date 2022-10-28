import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Grade } from 'src/app/models/grade';
import { GradeService } from 'src/app/services/grade.service';

@Component({
  selector: 'app-update-grade',
  templateUrl: './update-grade.component.html',
  styleUrls: ['./update-grade.component.css']
})
export class UpdateGradeComponent implements OnInit {

  public grade: Grade| any;
  public id: number|any;
  public form: FormGroup | any;

  constructor(private fb: FormBuilder,
    private gradeService: GradeService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

  ngOnInit(): void {
    this.form = this.fb.group({
      name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(1)]],

  });
  
    this.id = this.route.snapshot.params["id"]
    this.gradeService.getGrade(this.id).subscribe({
      next:(grade:Grade)=>this.displayGrade(grade),
      error:(error)=>console.error(error)
      
    }
    );
   
  }
   
  displayGrade(grade:Grade) {
    this.grade = grade;
    console.log(grade);
    this.form.patchValue({
      name: this.grade.name,
    })
    
  }
  // Update grade data
  edite(){
    const grade: Grade = {
      ...this.grade,
      ...this.form.value
    };
    console.log(grade);
      this.gradeService.updateGrade(this.id,grade).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/grades']);
  }
}
