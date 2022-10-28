import {Establishment} from "./establishment";

export interface Room {

  id:number;
  designation: string;
  number: string;
  establishment: Establishment;
}
