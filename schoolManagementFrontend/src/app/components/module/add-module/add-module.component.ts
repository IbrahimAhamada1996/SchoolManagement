import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Level } from 'src/app/models/level';
import { Module } from 'src/app/models/module';
import { Unity } from 'src/app/models/unity';
import { LevelService } from 'src/app/services/level.service';
import { ModuleService } from 'src/app/services/module.service';
import { UnityService } from 'src/app/services/unity.service';

@Component({
  selector: 'app-add-module',
  templateUrl: './add-module.component.html',
  styleUrls: ['./add-module.component.css']
})
export class AddModuleComponent implements OnInit {

  public form:FormGroup | any;
  public module:Module | any;
  public unities:Unity[]| any;
  public unity:Unity|any;
  public levels:Level[]| any;
  public level:Level|any;
 
  constructor(private fb:FormBuilder,
    private unityService:UnityService,
    private moduleService:ModuleService,
    private levelService:LevelService,
    private router:Router) { }

  ngOnInit(): void {
      this.unityService.getUnitys().subscribe({
        next:(unities:Unity)=>{
          this.unities = unities;
          console.log(this.unities);
        }
      });

      this.levelService.getLevels().subscribe({
        next:(levels:Level)=>{
          this.levels= levels;
          console.log(this.levels);
        }
      });

      this.form = this.fb.group({
        name: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
        coeficient: ['',[Validators.required]],
        unity: this.fb.group({
          id:['']
        }),
        level: this.fb.group({
          id:['']
        })
    });
    this.form.get('unity').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getUnity(value.id)
      }
    })
    this.form.get('level').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getLevel(value.id)
      }
    })
    console.log(this.form.get('unity'))
  }

  getUnity(id:any){
    if(id!=null || id!=''){

      this.unityService.getUnity(id).subscribe({
        next:(unity:Unity)=>{
          this.unity = unity;
          console.log("unity",unity)
        }
      });
    }
  }
  getLevel(id:any){
    if(id!=null || id!=''){

      this.levelService.getLevel(id).subscribe({
        next:(level:Level)=>{
          this.level=level;
          console.log("level",level);
        }
      });
    }
  }
  
  onSubmit() {

    this.form.value.unity = this.unity;
    this.form.value.level = this.level;

    console.log("fromvalue",this.form.value);
    const module: Module={
        ...this.module,
        ...this.form.value
    }
     console.log("befors",module);

    this.moduleService.createModule(module).subscribe({
      next:(module:Module)=>{
        console.log("after",module);
        this.router.navigate(['/admin/modules'])
      }
    })
  }

}
