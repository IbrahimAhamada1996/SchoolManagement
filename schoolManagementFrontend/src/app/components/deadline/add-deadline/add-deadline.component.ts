import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Deadline } from 'src/app/models/deadline';
import { Payment } from 'src/app/models/payment';
import { DeadlineService } from 'src/app/services/deadline.service';
import { PaymentService } from 'src/app/services/payment.service';

@Component({
  selector: 'app-add-deadline',
  templateUrl: './add-deadline.component.html',
  styleUrls: ['./add-deadline.component.css']
})
export class AddDeadlineComponent implements OnInit {

  public form:FormGroup | any;
  public deadline:Deadline | any;
  public payments:Payment[]| any;
  public payment:Payment|any;
 
  constructor(private fb:FormBuilder,
    private paymentService:PaymentService,
    private deadlineService:DeadlineService,
    private router:Router) { }

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
    this.form.get('payment').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getPayment(value.id)
      }
    })
    console.log(this.form.get('payment'))
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
  
  onSubmit() {

    this.form.value.payment = this.payment;
    

    console.log("fromvalue",this.form.value);
    const deadline: Deadline={
        ...this.deadline,
        ...this.form.value
    }
     console.log("befors",deadline);

    this.deadlineService.createDeadline(deadline).subscribe({
      next:(deadline:Deadline)=>{
        console.log("after",deadline);
        this.router.navigate(['/admin/deadlines'])
      }
    })
  }

}
