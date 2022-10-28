import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Payment } from 'src/app/models/payment';
import { PaymentService } from 'src/app/services/payment.service';

@Component({
  selector: 'app-list-payment',
  templateUrl: './list-payment.component.html',
  styleUrls: ['./list-payment.component.css']
})
export class ListPaymentComponent implements OnInit {

  payments:Payment[]| any;
 
  constructor(private paymentService: PaymentService,
              private router:Router) {
   
  
  }

  delete(id:number){    

    this.paymentService.deletePayment(id).subscribe(
        (response)=>{
          this.router.navigate(['/admin/payments']);
        }
      )
  }

  ngOnInit(): void {

    this.paymentService.getPayments().subscribe((data) => {
      this.payments = data;      
      console.log(this.payments);
    });
  }

}
