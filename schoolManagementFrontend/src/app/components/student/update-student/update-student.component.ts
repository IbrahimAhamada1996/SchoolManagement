import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Department } from 'src/app/models/department';
import { Faculty } from 'src/app/models/faculty';
import { Grade } from 'src/app/models/grade';
import { Inscription } from 'src/app/models/inscription';
import { Session } from 'src/app/models/session';
import { Student } from 'src/app/models/student';
import { DepartmentService } from 'src/app/services/department.service';
import { FacultyService } from 'src/app/services/faculty.service';
import { GradeService } from 'src/app/services/grade.service';
import { SessionService } from 'src/app/services/session.service';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {
  private id:number|any;
  public form:FormGroup | any;
  public department:Department | any;
  public departments:Department[] | any;
  public student:Student|any;
  public sutudents:Student[]|any;
  public session:Session| any;
  public sessions:Session[]| any;
  public faculty:Faculty[]| any;
  public faculties:Faculty[]| any;
  public inscription:Inscription | any;
  public inscriptions:Inscription[] | any;
  public grade:Grade|any;
  public grades:Grade[]|any;

  constructor(private fb:FormBuilder,
    private studentService:StudentService,
    private sessionService: SessionService,
    private facultyService:FacultyService,
    private gradeService:GradeService,
    private departmentService:DepartmentService,
    private router:Router,
    private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.departmentService.getDepartments().subscribe({
      next:(departments:Department)=>{
        this.departments = departments;
        console.log(this.departments);
      }
    });
    this.form = this.fb.group({
      firstname: ['',[Validators.required,Validators.maxLength (30),Validators.minLength(2)]],
      lastname: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      email: ['',[Validators.required]],
      gender: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      username: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      password: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      birthDay: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      birthPlace: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      phone: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      cni: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      address: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      parent: this.fb.group({
        firstname: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        lastname: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        email: ['',[Validators.required]],
        gender: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        birthDay: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        birthPlace: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        phone: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        cni: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        city: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        job: ['',[Validators.maxLength(30),Validators.minLength(2)]],
      }),
      inscription: this.fb.group({
        year: ['',[Validators.required]],
        payments: this.fb.group({
          amount: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
          type: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        }),
      }),
      session: this.fb.group({
        id:['']
      }),
      faculty: this.fb.group({
        id:[''],
        grade: this.fb.group({
          id:['']
        }),
        department: this.fb.group({
          id:['']
        })
      }),
    });
    this.form.get('session').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getSession(value.id)
      }
    })
    this.form.get('faculty').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getFaculty(value.id)
      }
    })
    this.form.get('faculty').get('grade').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getGrade(value.id)
      }
    })

    this.form.get('department').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getDepartment(value.id)
      }
    })
  
    this.id = +this.route.snapshot.params["id"]
    this.studentService.getStudent(this.id).subscribe({
      next:(student:Student)=>this.displayStudent(student),
      error:(error)=>console.error(error)
      
    }
    );

    this.form.get('session').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getSession(value.id)
      }
    })
    this.form.get('faculty').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getFaculty(value.id)
      }
    })
    this.form.get('faculty').get('grade').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getGrade(value.id)
      }
    })

    this.form.get('department').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getDepartment(value.id)
      }
    })

    this.id = +this.route.snapshot.params["id"]
    this.studentService.getStudent(this.id).subscribe({
      next:(student:Student)=>this.displayStudent(student),
      error:(error)=>console.error(error)
      
    }
    );
   
  }

  displayStudent(student:Student) {
    this.student=student;
    console.log(student);
    this.form.patchValue({
      firstname: this.student.firstname,
      lastname: this.student.lastname,
      email: this.student.email,
      username: this.student.username,
      password: this.student.password,
      birthDay: this.student.birthDay,
      birthPlace: this.student.birthPlace,
      phone: this.student.phone,
      cni: this.student.cni,
      address: this.student.address,
      parent: this.fb.group({
        firstname: this.student.parent.firstname,
        lastname: this.student.parent.lastname,
        email: this.student.parent.email,
        gender: this.student.parent.gender,
        birthDay: this.student.parent.birthDay,
        birthPlace: this.student.parent.birthPlace,
        phone: this.student.parent.phone,
        cni: this.student.parent.cni,
        city: this.student.parent.city,
        job: this.student.parent.job,
      }),
      inscription: this.fb.group({
        year:this.student.year,
        payments:this.student.payments
      }),
      session: this.student.session,
      faculty: this.student.faculty,
      department:this.student.department,
    })
    
  }

  getSession(id:any){
    if(id!=null || id!=''){

      this.sessionService.getSession(id).subscribe({
        next:(session:Session)=>{
          this.session = session;
          console.log("session",this.session)
        }
      });
    }
  }
  getFaculty(id:any){
    if(id!=null || id!=''){

      this.facultyService.getFaculty(id).subscribe({
        next:(faculty:Faculty)=>{
          this.faculty = faculty
          console.log("faculty",this.faculty)
        }
      });
    }
  }

  getGrade(id:any){
    if(id!=null || id!=''){

      this.gradeService.getGrade(id).subscribe({
        next:(grade:Grade)=>{
          this.grade=grade
          console.log("grade",this.grade)
        }
      });
    }
  }

  getDepartment(id:any){
    if(id!=null || id!=''){

      this.departmentService.getDepartment(id).subscribe({
        next:(department:Department)=>{
          this.department = department;
          console.log("department",this.department)
        }
      });
    }
  }

 
  // Update student data
  edite(){
    this.form.value.session= this.session;
    this.form.value.inscription= this.inscription;
    this.form.value.faculty = this.faculty;
    this.form.value.grade = this.grade;
    this.form.value.department = this.department;
    const student: Student = {
      ...this.student,
      ...this.form.value
    };
    console.log(student);
      this.studentService.updateStudent(this.id,student).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/students']);
  }

}
