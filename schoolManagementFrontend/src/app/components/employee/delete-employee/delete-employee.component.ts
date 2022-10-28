import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/models/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-delete-employee',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {
  private id:number| any;
  private employee: Employee| any;

  constructor(private employeeService:EmployeeService,
              private route:ActivatedRoute,
              private router:Router) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.params['id'];
    console.log(this.route.snapshot.params);
    this.delete();
  }

 
  delete(){

    console.log(this.id);
      
      this.employeeService.deleteEmployee(this.id).subscribe(
        (response)=>{
          console.log("delete")
          this.router.navigate(['/admin/employees']);
        },
        (error)=>{
          console.log("erroor",error);
          this.router.navigate(['/admin/employees'])
        }
      )
  }

}
