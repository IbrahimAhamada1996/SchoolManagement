import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Unity } from 'src/app/models/unity';
import { UnityService } from 'src/app/services/unity.service';

@Component({
  selector: 'app-add-unity',
  templateUrl: './add-unity.component.html',
  styleUrls: ['./add-unity.component.css']
})
export class AddUnityComponent implements OnInit {

  public form:FormGroup | any;
  public unity:Unity | any;
  public unitys:Unity[]| any;
 
  constructor(private fb:FormBuilder,
    private unityService:UnityService,
    private router:Router) { }

  ngOnInit(): void {
     
      this.form = this.fb.group({
        name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(1)]],
        credit: ['',[Validators.required]],
    });
 
  }

  onSubmit() {

    console.log("fromvalue",this.form.value);
    const unity: Unity={
        ...this.unity,
        ...this.form.value
    }
     console.log("befors",unity);

    this.unityService.createUnity(unity).subscribe({
      next:(unity:Unity)=>{
        console.log("after",unity);
        this.router.navigate(['/admin/unities'])
      }
    })
  }

}
