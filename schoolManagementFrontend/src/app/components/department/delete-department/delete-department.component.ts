import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DepartmentService } from 'src/app/services/department.service';

@Component({
  selector: 'app-delete-department',
  templateUrl: './delete-department.component.html',
  styleUrls: ['./delete-department.component.css']
})
export class DeleteDepartmentComponent implements OnInit {
  private id:number |any;
  constructor(private route:ActivatedRoute,
              private router:Router,
              private departmentService:DepartmentService) { }

  ngOnInit(): void {

    this.id = +this.route.snapshot.params['id'];
    this.departmentService.deleteDepartment(this.id).subscribe(
     
    );
    this.router.navigate(['/admin/departments']);
    
  }

}
