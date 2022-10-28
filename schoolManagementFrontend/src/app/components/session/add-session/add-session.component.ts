import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Session } from 'src/app/models/session';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-add-session',
  templateUrl: './add-session.component.html',
  styleUrls: ['./add-session.component.css']
})
export class AddSessionComponent implements OnInit {

  public form:FormGroup | any;
  public session:Session | any;

 
  constructor(private fb:FormBuilder,
    private sessionService:SessionService,
    private router:Router) { }

  ngOnInit(): void {
    
      this.form = this.fb.group({
        name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(1)]],
    });
    this.form.get('employee').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
      }
    })
    console.log(this.form.get('employee'))
  }


  onSubmit() {

    console.log("fromvalue",this.form.value);
    const session: Session={
        ...this.session,
        ...this.form.value
    }
     console.log("befors",session);

    this.sessionService.createSession(session).subscribe({
      next:(session:Session)=>{
        console.log("after",session);
        this.router.navigate(['/admin/sessions'])
      }
    })
  }

}
