import {Faculty} from "./faculty";
import {Payment} from "./payment";
import {Session} from "./session";
import {Student} from "./student";

export interface Inscription {
  id:number;
  year: string;
  createdAt: string;
  students: Array<Student>;
  payments: Array<Payment>;
  session: Session;
  faculty: Faculty;
}
