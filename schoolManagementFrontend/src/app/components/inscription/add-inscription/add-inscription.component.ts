import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Faculty } from 'src/app/models/faculty';
import { Inscription } from 'src/app/models/inscription';
import { Session } from 'src/app/models/session';
import { FacultyService } from 'src/app/services/faculty.service';
import { InscriptionService } from 'src/app/services/inscription.service';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-add-inscription',
  templateUrl: './add-inscription.component.html',
  styleUrls: ['./add-inscription.component.css']
})
export class AddInscriptionComponent implements OnInit {

  public form:FormGroup | any;
  public inscription:Inscription | any;
  public sessions:Session[]| any;
  public session:Session|any;
  public faculty:Faculty| any;
  public faculties:Faculty[]| any;
 
  constructor(private fb:FormBuilder,
    private sessionService:SessionService,
    private facultyService:FacultyService,
    private inscriptionService:InscriptionService,
    private router:Router) { }

  ngOnInit(): void {
   
      this.sessionService.getSessions().subscribe({
        next:(sessions:any)=>{
         this.sessions = sessions;
         console.log(this.sessions);
        }
      });

      this.facultyService.getFacultys().subscribe({
        next:(faculties:Faculty)=>{
         
          this.faculties = faculties;
          console.log(this.faculties);
        }
      })

      this.form = this.fb.group({
        name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        year: ['',[Validators.required]],
        session: this.fb.group({
          id:['']
        }),
        faculty: this.fb.group({
          id:['']
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
        this.getFacuty(value.id)
      }
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

  getFacuty(id:any){
    if(id!=null || id!=''){
      
      this.facultyService.getFaculty(id).subscribe({
        next:(faculty:Faculty)=>{
          this.faculty = faculty;
          console.log("faculty",this.faculty)
        }
      });
      
    }
  }
  
  onSubmit() {

    this.form.value.session = this.session;
    this.form.value.faculty = this.faculty;
    

    console.log("fromvalue",this.form.value);
    const inscription: Inscription={
        ...this.inscription,
        ...this.form.value
    }
     console.log("befors",inscription);

    this.inscriptionService.createInscription(inscription).subscribe({
      next:(inscription:Inscription)=>{
        console.log("after",inscription);
        this.router.navigate(['/admin/inscriptions'])
      }
    })
  }
}
