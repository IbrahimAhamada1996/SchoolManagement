import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Module } from 'src/app/models/module';
import { ModuleService } from 'src/app/services/module.service';

@Component({
  selector: 'app-list-module',
  templateUrl: './list-module.component.html',
  styleUrls: ['./list-module.component.css']
})
export class ListModuleComponent implements OnInit {

  modules:Module[]| any;
 
  constructor(private moduleService: ModuleService,
              private router:Router) {
   
  
  }

   delete(id:number){    
    this.moduleService.deleteModule(id).subscribe(
        (response)=>{
          this.router.navigate(['/admin/modules']);
        }
      )
  }

  ngOnInit(): void {
    this.moduleService.getModules().subscribe((data) => {

      this.modules = data;      
      console.log(this.modules);
    });
  }

}
