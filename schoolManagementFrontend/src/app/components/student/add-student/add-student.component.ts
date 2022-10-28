import {Component, OnInit} from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder, FormArray } from '@angular/forms'
import { Router } from '@angular/router';
import { Department } from 'src/app/models/department';
import { Faculty } from 'src/app/models/faculty';
import { Grade } from 'src/app/models/grade';
import { Inscription } from 'src/app/models/inscription';
import { Session } from 'src/app/models/session';
import { Student } from 'src/app/models/student';
import { DepartmentService } from 'src/app/services/department.service';
import { FacultyService } from 'src/app/services/faculty.service';
import { GradeService } from 'src/app/services/grade.service';
import { InscriptionService } from 'src/app/services/inscription.service';
import { SessionService } from 'src/app/services/session.service';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {
  public form:FormGroup | any;
  public department:Department | any;
  public departments:Department[] | any;
  public student:Student|any;
  public students:Student[]|any;
  public session:Session| any;
  public sessions:Session[]| any;
  public faculty:Faculty[]| any;
  public faculties:Faculty[]| any;
  public grade:Grade|any;
  public grades:Grade[]|any;
  public inscription:Inscription|any;
  public inscriptions:Inscription[]|any;

  // form = new FormGroup({

  //   firstname: new FormControl(),
  //   lastname: new FormControl(),
  //   email: new FormControl(),
  //   gender: new FormControl(),
  //   username: new FormControl(),
  //   password: new FormControl(),
  //   birthDay: new FormControl(),
  //   birthPlace: new FormControl(),
  //   phone: new FormControl(),
  //   cni: new FormControl(),
  //   address: new FormControl(),
  
  //   parent:new FormGroup({
      
  //     firstname: new FormControl(),
  //     lastname: new FormControl(),
  //     email: new FormControl(),
  //     gender: new FormControl(),
  //     birthDay: new FormControl(),
  //     birthPlace: new FormControl(),
  //     phone: new FormControl(),
  //     cni: new FormControl(),
  //     city: new FormControl(),
  //     job: new FormControl()
      
  //   }),

  //   inscription:new FormGroup({
  //     year: new FormControl(),
  //     payments: new FormGroup({
  //       amount: new FormControl(),
  //       type: new FormControl()
  
  //     }),

  //     session: new FormGroup({
  //       number: new FormControl(),
  //       name: new FormControl(),
  //       totalsAmount: new FormControl(),
  
  //     }),

  //     faculty:new FormGroup({
  //       name:new FormControl(),
  //       grades: new FormGroup({  
  //         name:  new FormControl(),
  //       }),

  //       department: new FormGroup({
  //         name: new FormControl(),
  //       }),
  
  //     }),

  //   }),
  // })

  constructor(private fb:FormBuilder,
    private studentService:StudentService,
    private sessionService: SessionService,
    private facultyService:FacultyService,
    private gradeService:GradeService,
    private inscriptionService: InscriptionService,
    private departmentService:DepartmentService,
    private router:Router) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      firstname: ['Ali',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      lastname: ['Fall',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      email: ['alifall@gmail.com',[Validators.required]],
      gender: ['M',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      username: ['alifall',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      password: ['passer',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      birthDay: ['1996-01-12',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      birthPlace: ['Comoros',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      phone: ['725221253',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      cni: ['45PO-HJ',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      address: ['Liverté 6 extension',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      parent: this.fb.group({
        firstname: ['Omar',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        lastname: ['Hassane',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        email: ['omar@gmail.com',[Validators.required]],
        gender: ['M',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        birthDay: ['1990-01-01',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        birthPlace: ['Sima',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        phone: ['774526321',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        cni: ['878-DF',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        city: ['Dakar',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        job: ['Magnagement',[Validators.maxLength(30),Validators.minLength(2)]],
        address: ['same',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      }),
      schoolCareers: this.fb.array([]),
      payments: this.fb.array([
        this.fb.group({
          amount: ['1000000',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
          type: ['collage',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        })
      ]),
      inscriptions: this.fb.array([
        this.fb.group({
            year: ['2022',[Validators.required]],
            
            // session: this.fb.group({
            //   id:[''],
              
            // }),
            faculty: this.fb.group({
              id:[''],
              grades: this.fb.array([
                this.fb.group({
                  id:['']
                })
              ]),
            }),
          }),
      ]),
     
    });
   
    this.form.get('inscriptions').valueChanges.subscribe({
      next:(value:any)=>{
       
        console.log(value[0])
        console.log('faculty id',value[0].faculty.id);
        console.log('grade id',value[0].faculty?.grades[0]?.id);

        if(value[0].faculty.id != null)
          this.getFaculty(value[0].faculty.id)

        if(value[0].faculty?.grades[0]?.id != null) 
          this.getGrade(value[0].faculty.grades[0].id)

        // if(value[0].session.id != null) 
        //   this.getSession(value[0].session.id)  
      }
    })
    //GET ALL

    this.facultyService.getFacultys().subscribe({
      next:(faculties:Faculty)=>{
        this.faculties = faculties;
        console.log("Faculties",this.faculties)
      }
    })
    

    // this.sessionService.getSessions().subscribe({
    //   next:(sessions:Session)=>{
    //     this.sessions = sessions;
    //     console.log("sessions",this.sessions)
    //   }
    // })
    this.gradeService.getGrades().subscribe({
      next:(grades:Grade)=>{
        this.grades = grades;
        console.log("grades",this.grades)
      }
    })
    this.inscriptionService.getInscriptions().subscribe({
      next:(inscriptions:Inscription)=>{
        this.inscriptions = inscriptions;
        console.log("inscriptions",this.inscriptions)
      }
    })

  }
  // getSession(id:any){
  //   if(id!=null || id!=''){

  //     this.sessionService.getSession(id).subscribe({
  //       next:(session:Session)=>{
  //         this.session = session;
  //         console.log("session",this.session)
  //       }
  //     });
  //   }
  // }
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


 

  onSubmit() {
    console.log("session",this.session);
    console.log("faculty",this.faculty);
    console.log("grade",this.grade);

    // this.form.value.inscriptions[0].session= this.session;
   
    this.form.value.inscriptions[0].faculty = this.faculty;
    this.form.value.inscriptions[0].faculty.grades[0] = this.grade;
    console.log("fromvalue",this.form.value);
    const student: Student={
        ...this.student,
        ...this.form.value
    }
    // student.inscriptions[0].session.exams=null;
    this.student = student;
     console.log("before",student);

    this.studentService.createStudent(student).subscribe({
      next:(student:Student)=>{
        console.log("after",student);
        this.router.navigate(['/admin/faculies'])
      }
    })
  }

  get schoolCareers() {
    return this.form.controls["schoolCareers"] as FormArray;
  }

  addSchoolCareer() {

    const form = this.fb.group({
      year: ['2012', Validators.required],
      level: ['Bac', Validators.required],
      faculty: ['Serie c', Validators.required],
      school: ['Hight school', Validators.required],
      results: ['Bien', Validators.required],
    });
    this.schoolCareers.push(form);
  }

  deleteSchoolCareer(index: number) {
    this.schoolCareers.removeAt(index);
  }
}
