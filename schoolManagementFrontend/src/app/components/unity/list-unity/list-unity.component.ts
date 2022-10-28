import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Unity } from 'src/app/models/unity';
import { UnityService } from 'src/app/services/unity.service';

@Component({
  selector: 'app-list-unity',
  templateUrl: './list-unity.component.html',
  styleUrls: ['./list-unity.component.css']
})
export class ListUnityComponent implements OnInit {

  unities:Unity[]| any;
 
  constructor(private unityService: UnityService,
              private router:Router) {
   
  }

   delete(id:number){    
    this.unityService.deleteUnity(id).subscribe(
        (response)=>{
          this.router.navigate(['/admin/unitys']);
        }
      )
  }

  ngOnInit(): void {
    this.unityService.getUnitys().subscribe((data) => {

      this.unities = data;      
      console.log(this.unities);
    });
  
  }

}
