import {Exam} from "./exam";
import {Inscription} from "./inscription";

export interface Session {
  id:number;
  name: string;
  inscriptions: Array<Inscription> | any;
  exams: Array<Exam> | any;
}
