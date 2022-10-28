import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Inscription } from 'src/app/models/inscription';
import { InscriptionService } from 'src/app/services/inscription.service';

@Component({
  selector: 'app-list-inscription',
  templateUrl: './list-inscription.component.html',
  styleUrls: ['./list-inscription.component.css']
})
export class ListInscriptionComponent implements OnInit {

  inscriptions:Inscription[]| any;
 
  constructor(private inscriptionService: InscriptionService,
              private router:Router) {
    
  
  }

   delete(id:number){    
    this.inscriptionService.deleteInscription(id).subscribe(
        (response)=>{
          this.router.navigate(['/admin/inscriptions']);
        }
      )
  }

  ngOnInit(): void {
    this.inscriptionService.getInscriptions().subscribe((data) => {

      this.inscriptions = data;      
      console.log(this.inscriptions);
    });
  }

}
