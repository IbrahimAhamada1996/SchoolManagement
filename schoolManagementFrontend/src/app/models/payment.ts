import {Inscription} from "./inscription";

export interface Payment {
  id:number;
  amount: string;
  createdAt: string;
  type: string;
  inscription: Inscription;

}
