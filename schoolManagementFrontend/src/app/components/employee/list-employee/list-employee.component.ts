import { Component, OnInit,ViewChild  } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/employee';
import { EmployeeService } from 'src/app/services/employee.service';


@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
  displayedColumns: string[] = ['id', 'userId', 'title', 'body'];
  dataSource!: MatTableDataSource<Employee>;
  employees: any;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


  constructor(private employeeService: EmployeeService,
              private router:Router) {
    this.employeeService.getEmployees().subscribe((data) => {
      console.log(data);
      this.employees = data;      ;
      // Assign the data to the data source for the table to render
      this.dataSource = new MatTableDataSource(this.employees);

      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });

  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

   delete(id:number){    
    this.employeeService.deleteEmployee(id).subscribe(
        (response)=>{
          this.router.navigate(['/admin/employees']);
        }
      )
  }

  ngOnInit(): void {
  }

}
