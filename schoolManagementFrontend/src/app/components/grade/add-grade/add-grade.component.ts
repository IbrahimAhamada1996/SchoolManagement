import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Grade } from 'src/app/models/grade';
import { GradeService } from 'src/app/services/grade.service';

@Component({
  selector: 'app-add-grade',
  templateUrl: './add-grade.component.html',
  styleUrls: ['./add-grade.component.css']
})
export class AddGradeComponent implements OnInit {

  public form:FormGroup | any;
  public grade:Grade | any;
 
  constructor(private fb:FormBuilder,
    private gradeService:GradeService,
    private router:Router) { }

  ngOnInit(): void {
    

      this.form = this.fb.group({
        name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(1)]],
    });

  }

  
  onSubmit() {

    console.log("fromvalue",this.form.value);
    const grade: Grade={
        ...this.grade,
        ...this.form.value
    }
     console.log("before",grade);

    this.gradeService.createGrade(grade).subscribe({
      next:(grade:Grade)=>{
        console.log("after grade",grade);
        this.router.navigate(['/admin/grades'])
      }
    })
  }
}
