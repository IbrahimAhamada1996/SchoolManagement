import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Deadline } from 'src/app/models/deadline';
import { Payment } from 'src/app/models/payment';
import { DeadlineService } from 'src/app/services/deadline.service';
import { PaymentService } from 'src/app/services/payment.service';

@Component({
  selector: 'app-update-deadline',
  templateUrl: './update-deadline.component.html',
  styleUrls: ['./update-deadline.component.css']
})
export class UpdateDeadlineComponent implements OnInit {

  public deadline: Deadline| any;
  public id: number|any;
  public form: FormGroup | any;
  public payments:Payment[]| any;
  public payment:Payment| any;

  constructor(private fb: FormBuilder,
    private deadlineService: DeadlineService,
    private paymentService:PaymentService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

  ngOnInit(): void {
    this.paymentService.getPayments().subscribe({
      next:(payments:Payment)=>{
        this.payments = payments;
        console.log(this.payments);
      }
    });
    this.form = this.fb.group({
      startDate: ['',[Validators.required]],
      endDate: ['',[Validators.required]],
      amount: ['',[Validators.required]],
      payment: this.fb.group({
        id:['']
      })
  });
  
    this.id = this.route.snapshot.params["id"]
    this.deadlineService.getDeadline(this.id).subscribe({
      next:(deadline:Deadline)=>this.displayDeadline(deadline),
      error:(error)=>console.error(error)
      
    }
    );

    this.form.get('payment').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getPayment(value.id)
      }
    })
   
  }
  getPayment(id:any){
    if(id!=null || id!=''){

      this.paymentService.getPayment(id).subscribe({
        next:(payment:Payment)=>{
          this.payment = payment;
          console.log("payment",payment)
        }
      });
    }
  }

 
   
  displayDeadline(deadline:Deadline) {
    this.deadline = deadline;
    console.log(deadline);
    this.form.patchValue({
      startDate: this.deadline.startDate,
      endDate: this.deadline.endDate,
      amount: this.deadline.amount,
      payment: this.deadline.payment
    })
    
  }
  // Update deadline data
  edite(){
    this.form.value.payment= this.payment;
    const deadline: Deadline = {
      ...this.deadline,
      ...this.form.value
    };
    console.log(deadline);
      this.deadlineService.updateDeadline(this.id,deadline).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/deadlines']);
  }

}
