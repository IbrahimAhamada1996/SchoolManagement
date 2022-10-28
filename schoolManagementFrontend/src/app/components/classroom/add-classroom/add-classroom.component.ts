import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Classroom } from 'src/app/models/classroom';
import { Establishment } from 'src/app/models/establishment';
import { ClassroomService } from 'src/app/services/classroom.service';
import { EstablishmentService } from 'src/app/services/establishment.service';

@Component({
  selector: 'app-add-classroom',
  templateUrl: './add-classroom.component.html',
  styleUrls: ['./add-classroom.component.css']
})
export class AddClassroomComponent implements OnInit {

  public form:FormGroup | any;
  public classroom:Classroom | any;
  public establishments:Establishment[]| any;
  public establishment:Establishment|any;
 
  constructor(private fb:FormBuilder,
    private establishmentService:EstablishmentService,
    private classroomService:ClassroomService,
    private router:Router) { }

  ngOnInit(): void {
      this.establishmentService.getEstablishments().subscribe({
        next:(establishments:Establishment)=>{
          this.establishments = establishments;
          console.log(this.establishments);
        }
      });

      this.form = this.fb.group({
        designation: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        number: ['',[Validators.required]],
        establishment: this.fb.group({
          id:['']
        }),
        ability: ['',[Validators.required]],
        available: [true,[Validators.required]],
    });
    this.form.get('establishment').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getEstablishment(value.id)
      }
    })
    console.log(this.form.get('establishment'))
  }

  getEstablishment(id:any){
    if(id!=null || id!=''){

      this.establishmentService.getEstablishment(id).subscribe({
        next:(establishment:Establishment)=>{
          this.establishment = establishment;
          console.log("establishment",establishment)
        }
      });
    }
  }
  
  onSubmit() {

    this.form.value.establishment = this.establishment;
    

    console.log("fromvalue",this.form.value);
    const classroom: Classroom={
        ...this.classroom,
        ...this.form.value
    }
     console.log("befors",classroom);

    this.classroomService.createClassroom(classroom).subscribe({
      next:(classroom:Classroom)=>{
        console.log("after",classroom);
        this.router.navigate(['/admin/classrooms'])
      }
    })
  }
}
