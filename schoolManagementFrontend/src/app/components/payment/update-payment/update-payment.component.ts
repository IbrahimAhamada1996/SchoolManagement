import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Inscription } from 'src/app/models/inscription';
import { Payment } from 'src/app/models/payment';
import { InscriptionService } from 'src/app/services/inscription.service';
import { PaymentService } from 'src/app/services/payment.service';

@Component({
  selector: 'app-update-payment',
  templateUrl: './update-payment.component.html',
  styleUrls: ['./update-payment.component.css']
})
export class UpdatePaymentComponent implements OnInit {

  public payment: Payment| any;
  public id: number|any;
  public form: FormGroup | any;
  public inscriptions:Inscription[]| any;
  public inscription:Inscription| any;

  constructor(private fb: FormBuilder,
    private paymentService: PaymentService,
    private inscriptionService:InscriptionService,
    private router: Router,
    private route: ActivatedRoute) {
   
  }

  ngOnInit(): void {
    this.inscriptionService.getInscriptions().subscribe({
      next:(inscriptions:Inscription)=>{
        this.inscriptions = inscriptions;
        console.log(this.inscriptions);
      }
    });
    this.form = this.fb.group({
      amount: ['',[Validators.required]],
      createdAt: ['',[Validators.required]],
      type: ['',[Validators.required]],
      inscription: this.fb.group({
        id:['']
      })
  });
  
    this.id = this.route.snapshot.params["id"]
    this.paymentService.getPayment(this.id).subscribe({
      next:(payment:Payment)=>this.displayPayment(payment),
      error:(error)=>console.error(error)
      
    }
    );

    this.form.get('inscription').valueChanges.subscribe({
      next:(value:any)=>{
        console.log(value.id);
        this.getInscription(value.id)
      }
    })
   
  }
  getInscription(id:any){
    if(id!=null || id!=''){

      this.inscriptionService.getInscription(id).subscribe({
        next:(inscription:Inscription)=>{
          this.inscription = inscription;
          console.log("inscription",inscription)
        }
      });
    }
  }

 
   
  displayPayment(payment:Payment) {
    this.payment = payment;
    console.log(payment);
    this.form.patchValue({
      name: this.payment.name,
      inscription: this.payment.inscription
    })
    
  }
  // Update payment data
  edite(){
    this.form.value.inscription= this.inscription;
    const payment: Payment = {
      ...this.payment,
      ...this.form.value
    };
    console.log(payment);
      this.paymentService.updatePayment(this.id,payment).subscribe({
        next:()=>this.resetCompleted(),
        error:(error)=>console.error(error)
      })
   
  }

  //reset
  public resetCompleted(): void {
    this.form.reset();
    this.router.navigate(['/admin/payments']);
  }

}
