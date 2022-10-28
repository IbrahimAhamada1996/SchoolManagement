import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route } from '@angular/router';
import { Employee } from 'src/app/models/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-detail-employee',
  templateUrl: './detail-employee.component.html',
  styleUrls: ['./detail-employee.component.css']
})
export class DetailEmployeeComponent implements OnInit {
  private id:number| any;
  public employee: Employee | any;

  constructor(
    private employeeeService: EmployeeService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {

    this.id = +this.route.snapshot.params["id"];
    
    this.employeeeService.getEmployee(this.id).subscribe(
      (data)=>{
        this.employee = data;
        console.log(this.employee);
      },
      (error)=>{
        console.log('error',error);
      }
    );
  }

}
