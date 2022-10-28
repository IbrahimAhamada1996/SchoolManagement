import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Session } from 'src/app/models/session';
import { SessionService } from 'src/app/services/session.service';

@Component({
  selector: 'app-list-session',
  templateUrl: './list-session.component.html',
  styleUrls: ['./list-session.component.css']
})
export class ListSessionComponent implements OnInit {

  sessions:Session[]| any;
 
  constructor(private sessionService: SessionService,
              private router:Router) {
  
  }

   delete(id:number){    
    this.sessionService.deleteSession(id).subscribe(
        (response)=>{
          this.router.navigate(['/admin/sessions']);
        }
      )
  }

  ngOnInit(): void {
    this.sessionService.getSessions().subscribe((data) => {
      this.sessions = data;      
      console.log(this.sessions);
    });
  
  }

}
