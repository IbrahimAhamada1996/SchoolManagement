import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Level } from 'src/app/models/level';
import { LevelService } from 'src/app/services/level.service';

@Component({
  selector: 'app-list-level',
  templateUrl: './list-level.component.html',
  styleUrls: ['./list-level.component.css']
})
export class ListLevelComponent implements OnInit {

  levels:Level[]| any;
 
  constructor(private levelService: LevelService,
              private router:Router) {
   
  }

   delete(id:number){    
    this.levelService.deleteLevel(id).subscribe(
        (response)=>{
          this.router.navigate(['/admin/levels']);
        }
      )
  }

  ngOnInit(): void {
    this.levelService.getLevels().subscribe((data) => {

      this.levels = data;      
      console.log(this.levels);
    });
  
  }
}
