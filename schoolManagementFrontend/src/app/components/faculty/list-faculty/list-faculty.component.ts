import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Faculty } from 'src/app/models/faculty';
import { FacultyService } from 'src/app/services/faculty.service';

@Component({
  selector: 'app-list-faculty',
  templateUrl: './list-faculty.component.html',
  styleUrls: ['./list-faculty.component.css']
})
export class ListFacultyComponent implements OnInit {

  faculties:Faculty[]| any;
 
  constructor(private facultyService: FacultyService,
              private router:Router) {
    
  }

   delete(id:number){    
    this.facultyService.deleteFaculty(id).subscribe(
        (response)=>{
          this.router.navigate(['/admin/faculties']);
        }
      )
  }

  ngOnInit(): void {
    this.facultyService.getFacultys().subscribe((data) => {

      this.faculties = data;      
      console.log(this.faculties);
    });
  
  }

}
