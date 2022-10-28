import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Schedule } from 'src/app/models/schedule';
import { ScheduleService } from 'src/app/services/schedule.service';

@Component({
  selector: 'app-add-schedule',
  templateUrl: './add-schedule.component.html',
  styleUrls: ['./add-schedule.component.css']
})
export class AddScheduleComponent implements OnInit {

  public form:FormGroup | any;
  public schedule:Schedule | any;
 
  constructor(private fb:FormBuilder,
    private scheduleService:ScheduleService,
    private router:Router) { }

  ngOnInit(): void {

    this.form = this.fb.group({
      startDate:['',[Validators.required]],
      endDate: ['',[Validators.required]],
    });

  }

  
  onSubmit() {

    const schedule: Schedule={
        ...this.schedule,
        ...this.form.value
    }
     console.log("befors",schedule);

    this.scheduleService.createSchedule(schedule).subscribe({
      next:(schedule:Schedule)=>{
        console.log("after",schedule);
        this.router.navigate(['/admin/schedules'])
      }
    })
  }

}
