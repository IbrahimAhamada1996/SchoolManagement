import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Session } from 'src/app/models/session';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-update-session',
  templateUrl: './update-session.component.html',
  styleUrls: ['./update-session.component.css']
})
export class UpdateSessionComponent implements OnInit {

  public session: Session| any;
  public id: number|any;
  public form: FormGroup | any;

  constructor(private fb: FormBuilder,
    private sessionService: SessionService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

  ngOnInit(): void {
   
    this.form = this.fb.group({
      name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(1)]],
      // number: ['',[Validators.required]],
      // totalsAmount:['',[Validators.required]],
    });
  
    this.id = this.route.snapshot.params["id"]
    this.sessionService.getSession(this.id).subscribe({
      next:(session:Session)=>this.displaySession(session),
      error:(error)=>console.error(error)
      
    }
    );

    this.form.get('employee').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
      }
    })
   
  }

 
   
  displaySession(session:Session) {
    this.session = session;
    console.log(session);
    this.form.patchValue({
      name: this.session.name,
      employee: this.session.employee
    })
    
  }
  // Update session data
  edite(){
    const session: Session = {
      ...this.session,
      ...this.form.value
    };
    console.log(session);
      this.sessionService.updateSession(this.id,session).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/sessions']);
  }

}
