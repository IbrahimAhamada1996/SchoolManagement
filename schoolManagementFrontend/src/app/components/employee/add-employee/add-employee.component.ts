import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/employee';
import { EmployeeService } from 'src/app/services/employee.service';

export function passwordConstraint(c: AbstractControl):{[key:string]:boolean}|null {
  const passwordControler = c.get('password');
  const confirmPasswordControler = c.get('confirmPassword');

  if (passwordControler?.pristine || confirmPasswordControler?.pristine) {
   return null;
  }

  if (passwordControler?.value === confirmPasswordControler?.value) {
   return null;
  }
  return{ 'errorPassword':true};
}

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})

export class AddEmployeeComponent implements OnInit {
  public form: FormGroup | any;
  private employee:Employee | any;

  constructor(private fb: FormBuilder,
    private employeeService: EmployeeService,
    private router: Router) {
   
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
      roles: this.fb.array([ this.createRolesGroup() ])
    })
  }

  onSubmit(form:FormGroup) {
    let v = form.value;
    console.log(v.roles.roleName);
   const e :Employee ={
    ...this.employee,
    ...form.value
   }
   console.log("e",e);
    // let roles = Array(new Role(0,'ROLE_'+v.roles.roleName));
  
    // let employee =  new Employee(0,"",v.firstname,v.lastname,v.email,v.username,v.password,v.birthDay,v.birthPlace,v.phone,v.cni,v.gender,v.address,v.image,roles,true,v.salary,v.hireDate,v.situationFamilliale,false,false,v.childNumber);

    //   console.log(employee);
    this.employeeService.createEmployee(e).subscribe(
        response=>{
          console.log("save employee",response);
          this.router.navigate(['/admin/employees']);
        }
      )
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
  
}

