import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Classroom } from 'src/app/models/classroom';
import { Establishment } from 'src/app/models/establishment';
import { ClassroomService } from 'src/app/services/classroom.service';
import { EstablishmentService } from 'src/app/services/establishment.service';

@Component({
  selector: 'app-update-classroom',
  templateUrl: './update-classroom.component.html',
  styleUrls: ['./update-classroom.component.css']
})
export class UpdateClassroomComponent implements OnInit {

  public classroom: Classroom| any;
  public id: number|any;
  public form: FormGroup | any;
  public establishments:Establishment[]| any;
  public establishment:Establishment| any;

  constructor(private fb: FormBuilder,
    private classroomService: ClassroomService,
    private establishmentService:EstablishmentService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

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
  
    this.id = this.route.snapshot.params["id"]
    this.classroomService.getClassroom(this.id).subscribe({
      next:(classroom:Classroom)=>this.displayClassroom(classroom),
      error:(error)=>console.error(error)
      
    }
    );

    this.form.get('establishment').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getEstablishment(value.id)
      }
    })
   
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

 
   
  displayClassroom(classroom:Classroom) {
    this.classroom = classroom;
    console.log(classroom);
    this.form.patchValue({
      name: this.classroom.name,
      establishment: this.classroom.establishment
    })
    
  }
  // Update classroom data
  edite(){
    this.form.value.establishment= this.establishment;
    const classroom: Classroom = {
      ...this.classroom,
      ...this.form.value
    };
    console.log(classroom);
      this.classroomService.updateClassroom(this.id,classroom).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/classrooms']);
  }
}
