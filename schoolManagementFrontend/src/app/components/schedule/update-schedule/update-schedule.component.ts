import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Schedule } from 'src/app/models/schedule';
import { ScheduleService } from 'src/app/services/schedule.service';

@Component({
  selector: 'app-update-schedule',
  templateUrl: './update-schedule.component.html',
  styleUrls: ['./update-schedule.component.css']
})
export class UpdateScheduleComponent implements OnInit {

  public schedule: Schedule| any;
  public id: number|any;
  public form: FormGroup | any;

  constructor(private fb: FormBuilder,
    private scheduleService: ScheduleService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

  ngOnInit(): void {

    this.form = this.fb.group({
      startDate:['',[Validators.required]],
      endDate: ['',[Validators.required]],
     
  });
  
    this.id = this.route.snapshot.params["id"]
    this.scheduleService.getSchedule(this.id).subscribe({
      next:(schedule:Schedule)=>this.displaySchedule(schedule),
      error:(error)=>console.error(error)
      
    }
    );
   
  }

   
  displaySchedule(schedule:Schedule) {
    this.schedule = schedule;
    console.log(schedule);
    this.form.patchValue({
      startDate: this.schedule.startDate,
      endDate: this.schedule.endDate
    })
    
  }
  // Update schedule data
  edite(){
        const schedule: Schedule = {
      ...this.schedule,
      ...this.form.value
    };
    console.log(schedule);
      this.scheduleService.updateSchedule(this.id,schedule).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/schedules']);
  }

}
