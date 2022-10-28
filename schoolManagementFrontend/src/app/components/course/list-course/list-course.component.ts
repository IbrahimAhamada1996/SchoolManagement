import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from 'src/app/models/course';
import { CourseService } from 'src/app/services/course.service';

@Component({
  selector: 'app-list-course',
  templateUrl: './list-course.component.html',
  styleUrls: ['./list-course.component.css']
})
export class ListCourseComponent implements OnInit {

   courses:Course[]| any;
 
  constructor(private courseService: CourseService,
              private router:Router) {
    this.courseService.getCourses().subscribe((data) => {

      this.courses = data;      
      console.log(this.courses);
    });
  
  }

   delete(id:number){    
    this.courseService.deleteCourse(id).subscribe(
        (response)=>{
          this.router.navigate(['/admin/courses']);
        }
      )
  }

  ngOnInit(): void {
  }
}
