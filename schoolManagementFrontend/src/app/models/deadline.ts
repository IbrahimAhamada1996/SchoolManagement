import {Payment} from "./payment";

export interface Deadline {
  id:number;
  startDate: string;
  endDate: number;
  amount: number;
  createdAt: string;
  payment: Payment;

}

