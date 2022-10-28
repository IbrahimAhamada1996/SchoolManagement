import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Level } from 'src/app/models/level';
import { Module } from 'src/app/models/module';
import { Unity } from 'src/app/models/unity';
import { LevelService } from 'src/app/services/level.service';
import { ModuleService } from 'src/app/services/module.service';
import { UnityService } from 'src/app/services/unity.service';

@Component({
  selector: 'app-update-module',
  templateUrl: './update-module.component.html',
  styleUrls: ['./update-module.component.css']
})
export class UpdateModuleComponent implements OnInit {

  public id: number|any;
  public form:FormGroup | any;
  public module:Module | any;
  public unities:Unity[]| any;
  public unity:Unity|any;
  public levels:Level[]| any;
  public level:Level|any;

  constructor(private fb: FormBuilder,
    private unityService:UnityService,
    private moduleService:ModuleService,
    private levelService:LevelService,
    private router:Router,
    private route: ActivatedRoute) {
   
  }

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
  
    this.id = this.route.snapshot.params["id"]
    this.moduleService.getModule(this.id).subscribe({
      next:(module:Module)=>this.displayModule(module),
      error:(error)=>console.error(error)
      
    }
    );

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

 
   
  displayModule(module:Module) {
    this.module = module;
    console.log(module);
    this.form.patchValue({
      name: this.module.name,
      employee: this.module.employee
    })
    
  }
  // Update module data
  edite(){
    this.form.value.unity= this.unity;
    this.form.value.level= this.level;
    const module: Module = {
      ...this.module,
      ...this.form.value
    };
    console.log(module);
      this.moduleService.updateModule(this.id,module).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/modules']);
  }

}
