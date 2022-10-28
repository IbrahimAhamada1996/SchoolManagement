import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Faculty } from 'src/app/models/faculty';
import { Inscription } from 'src/app/models/inscription';
import { Session } from 'src/app/models/session';
import { FacultyService } from 'src/app/services/faculty.service';
import { InscriptionService } from 'src/app/services/inscription.service';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-update-inscription',
  templateUrl: './update-inscription.component.html',
  styleUrls: ['./update-inscription.component.css']
})
export class UpdateInscriptionComponent implements OnInit {

  public form:FormGroup | any;
  public id: number|any;
  public inscription:Inscription | any;
  public sessions:Session[]| any;
  public session:Session|any;
  public faculty:Faculty| any;
  public faculties:Faculty[]| any;
 
  constructor(private fb:FormBuilder,
    private sessionService:SessionService,
    private facultyService:FacultyService,
    private inscriptionService:InscriptionService,
    private router:Router,
    private route:ActivatedRoute) { }


  ngOnInit(): void {
    this.sessionService.getSessions().subscribe({
      next:(sessions:Session)=>{
        this.sessions = sessions;
        console.log(this.sessions);
      }
    });
    this.facultyService.getFacultys().subscribe({
      next:(faculties:Faculty)=>{
        this.faculties = faculties;
        console.log(this.session);
      }
    });
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
  
  
    this.id = this.route.snapshot.params["id"]
    this.inscriptionService.getInscription(this.id).subscribe({
      next:(inscription:Inscription)=>this.displayInscription(inscription),
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
  
  displayInscription(inscription:Inscription) {
    this.inscription = inscription;
    console.log(inscription);
    this.form.patchValue({
      name: this.inscription.name,
      year: this.inscription.year,
      session: this.inscription.session,
      faculty: this.inscription.faculty,
    })
    
  }
  // Update inscription data
  edite(){
    this.form.value.session= this.session;
    this.form.value.faculty= this.faculty;

    const inscription: Inscription = {
      ...this.inscription,
      ...this.form.value
    };
    console.log(inscription);
      this.inscriptionService.updateInscription(this.id,inscription).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/inscriptions']);
  }
}
