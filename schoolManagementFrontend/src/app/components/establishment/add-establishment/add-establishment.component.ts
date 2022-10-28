import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Establishment } from 'src/app/models/establishment';
import { EstablishmentService } from 'src/app/services/establishment.service';

@Component({
  selector: 'app-add-establishment',
  templateUrl: './add-establishment.component.html',
  styleUrls: ['./add-establishment.component.css']
})
export class AddEstablishmentComponent implements OnInit {

  public form:FormGroup | any;
  public establishment:Establishment | any;
 
  constructor(private fb:FormBuilder,
    private establishmentService:EstablishmentService,
    private router:Router) { }

  ngOnInit(): void {

      this.form = this.fb.group({
        name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        ability:  ['',[Validators.required]],
    });
  }

  
  onSubmit() {

    console.log("fromvalue",this.form.value);
    const establishment: Establishment={
        ...this.establishment,
        ...this.form.value
    }
     console.log("befors",establishment);

    this.establishmentService.createEstablishment(establishment).subscribe({
      next:(establishment:Establishment)=>{
        console.log("after",establishment);
        this.router.navigate(['/admin/establishments'])
      }
    })
  }

}
