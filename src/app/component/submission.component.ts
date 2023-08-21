import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Orders } from '../models';
import { Subscription } from 'rxjs';
import { SubmissionService } from '../services/submission.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-submission',
  templateUrl: './submission.component.html',
  styleUrls: ['./submission.component.css']
})
export class SubmissionComponent implements OnInit{
  form! : FormGroup;
  lineItemsArray!: FormArray;
  sub$!: Subscription;
  orders!: Orders;

  constructor(private fb: FormBuilder, private service : SubmissionService){}

  ngOnInit(): void {
    this.form = this.createForm();

  }

  submit() {
    const order: Orders = this.form.value
    // console.log(this.form.value);

    this.sub$ = this.service.postOrder(order).subscribe((data:any) => {
      this.orders = data;
      console.log(this.orders);

    })
  }

  createForm() {
    this.lineItemsArray = this.fb.array([]);
    return this.form = this.fb.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      express: [false],
      lineItems: this.lineItemsArray
    })
  }

  addLineItem() {
   this.lineItemsArray.push(
      this.fb.group({
        name: ['', [Validators.required]],
        quantity: ['', [Validators.required, Validators.min(2)]],
        unitPrice: ['', [Validators.required, Validators.min(2)]]
      }))

  }

  removeLineItem(idx: number) {
    this.lineItemsArray.removeAt(idx)
  }

  invalid() : boolean {
    return this.form.invalid || this.lineItemsArray.controls.length <=0
  }

}
