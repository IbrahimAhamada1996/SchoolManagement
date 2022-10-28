import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Inscription } from 'src/app/models/inscription';
import { Payment } from 'src/app/models/payment';
import { InscriptionService } from 'src/app/services/inscription.service';
import { PaymentService } from 'src/app/services/payment.service';

@Component({
  selector: 'app-add-payment',
  templateUrl: './add-payment.component.html',
  styleUrls: ['./add-payment.component.css']
})
export class AddPaymentComponent implements OnInit {

  public form:FormGroup | any;
  public formSearch: FormGroup | any;
  public payment:Payment | any;
  public inscriptions:Inscription[]| any;
  public inscription:Inscription|any;
  public id='';
 
  constructor(private fb:FormBuilder,
    private inscriptionService:InscriptionService,
    private paymentService:PaymentService,
    private router:Router) { }

  ngOnInit(): void {
      this.inscriptionService.getInscriptions().subscribe({
        next:(inscriptions:Inscription)=>{
          this.inscriptions = inscriptions;
          console.log(this.inscriptions);
        }
      });
  

      this.form = this.fb.group({
        student: this.fb.group({
          id:['']
        }),
        payments: this.fb.array([]),
        inscription: this.fb.group({
          id:['']
        })
    });
    // this.form.get('inscription').valueChanges.subscribe({
    //   next:(value:any)=>{
    //     console.log(value.id);
    //     this.getInscription(value.id)
    //   }
    // })
    // console.log(this.form.get('inscription'))

    this.formSearch = this.fb.group({
      yearId:[''],
      studentNumber:['']
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
  
  onSubmit() {

    this.form.value.inscription = this.inscription;
    

    console.log("fromvalue",this.form.value);
    const payment: Payment={
        ...this.payment,
        ...this.form.value
    }
     console.log("befors",payment);

    this.paymentService.createPayment(payment).subscribe({
      next:(payment:Payment)=>{
        console.log("after",payment);
        this.router.navigate(['/admin/payments'])
      }
    })
  }

  get payments() {
    return this.form.controls["payments"] as FormArray;
  }

  addPayment() {
    const form =  this.fb.group({
      amount: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
      type: ['',[Validators.required,Validators.maxLength(30),Validators.minLength(2)]],
    });
    console.log(form)
    this.payments.push(form);
  }

  deletePayment(index: number) {
    this.payments.removeAt(index);
  }


  search(){
   
    console.log("name = ",this.formSearch.value)
  }
}
