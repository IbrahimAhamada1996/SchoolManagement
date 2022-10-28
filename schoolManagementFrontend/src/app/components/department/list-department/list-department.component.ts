import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { Department } from 'src/app/models/department';
import { DepartmentService } from 'src/app/services/department.service';

@Component({
  selector: 'app-list-department',
  templateUrl: './list-department.component.html',
  styleUrls: ['./list-department.component.css']
})
export class ListDepartmentComponent implements OnInit {
  departments:Department[]| any;
 
  constructor(private employeeService: DepartmentService,
              private router:Router) {
    this.employeeService.getDepartments().subscribe((data) => {

      this.departments = data;      
      console.log(this.departments);
    });
  
  }

   delete(id:number){    
    this.employeeService.deleteDepartment(id).subscribe(
        (response)=>{
          this.router.navigate(['/admin/departments']);
        }
      )
  }

  ngOnInit(): void {
  }

}
