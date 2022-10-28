import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Unity } from 'src/app/models/unity';
import { UnityService } from 'src/app/services/unity.service';

@Component({
  selector: 'app-update-unity',
  templateUrl: './update-unity.component.html',
  styleUrls: ['./update-unity.component.css']
})
export class UpdateUnityComponent implements OnInit {

  public unity: Unity| any;
  public id: number|any;
  public form: FormGroup | any;

  constructor(private fb: FormBuilder,
    private unityService: UnityService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

  ngOnInit(): void {
    
    this.form = this.fb.group({
      name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(1)]],
      credit: ['',[Validators.required]],
  });
  
    this.id = +this.route.snapshot.params["id"]
    this.unityService.getUnity(this.id).subscribe({
      next:(unity:Unity)=>this.displayUnity(unity),
      error:(error)=>console.error(error)
      
    }
    );
   
  }
 
   
  displayUnity(unity:Unity) {
    this.unity = unity;
    console.log(unity);
    this.form.patchValue({
      name: this.unity.name,
      credit: this.unity.credit
    })
    
  }
  // Update unity data
  edite(){
    const unity: Unity = {
      ...this.unity,
      ...this.form.value
    };
    console.log(unity);
      this.unityService.updateUnity(this.id,unity).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/unitys']);
  }

}
