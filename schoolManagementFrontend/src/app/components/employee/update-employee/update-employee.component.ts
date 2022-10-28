import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/models/employee';
import { EmployeeService } from 'src/app/services/employee.service';
@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  public employee: Employee| any;
  public id: number|any;
  public form: FormGroup | any;

  constructor(private fb: FormBuilder,
    private employeeService: EmployeeService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

  ngOnInit(): void {
    this.form = this.fb.group({
      firstname: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      lastname:["",[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],  
      email: ["",[Validators.required,Validators.email]],
      gender: ["",[Validators.required,Validators.maxLength(1)]],
      username: ["",[Validators.required]],
      password:["",[Validators.required]],
      // passwordGroup: this.fb.group({
      //   password: ['',[Validators.required]],
      //   confirmPassword: ['',[Validators.required]]
      // },{validators:passwordConstraint}),
      birthDay: ["",[Validators.required]],
      birthPlace: ["",[Validators.required]],
      phone: ["",[Validators.required]],
      cni: ["",[Validators.required]],
      address: [""],
      salary: [""],
      hireDate:["",[Validators.required]],
      situationFamilliale: [""],
      decede: [""],
      fire: [""],
      childNumber:[""],
      roles: this.fb.array([
        this.createRolesGroup()
      ])
    });
  
    this.id = this.route.snapshot.params["id"]
    this.employeeService.getEmployee(this.id).subscribe({
      next:(employee:Employee)=>this.displayEmployee(employee),
      error:(error)=>console.error(error)
      
    }
    );
   
  }

  private createRolesGroup():FormGroup{
    return this.fb.group(
      {
        id:[''],
        roleName:['']
      }
     
    );
  }

 public get rolesList():FormArray{
    return this.form.get('roles') as FormArray;
  }

  public addRole():void{
    // this.rolesList.push(this.createRolesGroup);
  }
   
  displayEmployee(employee:Employee) {
    this.employee = employee;
    console.log(employee.roles);
    this.form.patchValue({
      firstname: this.employee.firstname,
      lastname:this.employee.lastname,  
      email: this.employee.email,
      gender: this.employee.gender,
      username: this.employee.username,
      password:this.employee.password,
      birthDay: this.employee.birthDay,
      birthPlace: this.employee.birthPlace,
      phone: this.employee.phone,
      cni: this.employee.cni,
      address: this.employee.address,
      salary: this.employee.salary,
      hireDate:this.employee.hireDate,
      situationFamilliale: this.employee.situationFamilliale,
      decede: this.employee.decede,
      fire:this.employee.fire,
      childNumber:this.employee.childNumber,
      roles: this.employee.roles
    })
    
  }
  // Update employee data
  edite(){
    const employee: Employee = {
      ...this.employee,
      ...this.form.value
    };

      this.employeeService.updateEmployee(this.id,employee).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/employees']);
  }

}
