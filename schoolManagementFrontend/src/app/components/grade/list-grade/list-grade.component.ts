import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Grade } from 'src/app/models/grade';
import { GradeService } from 'src/app/services/grade.service';

@Component({
  selector: 'app-list-grade',
  templateUrl: './list-grade.component.html',
  styleUrls: ['./list-grade.component.css']
})
export class ListGradeComponent implements OnInit {

  grades:Grade[]| any;
 
  constructor(private gradeService: GradeService,
              private router:Router) {
    
  }

   delete(id:number){    
    this.gradeService.deleteGrade(id).subscribe(
        (response)=>{
          this.router.navigate(['/admin/grades']);
        }
      )
  }

  ngOnInit(): void {
    this.gradeService.getGrades().subscribe((data) => {

      this.grades = data;      
      console.log(" grade ",data);
    });
  
  }

}
