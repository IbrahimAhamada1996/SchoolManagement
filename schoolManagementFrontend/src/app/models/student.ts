import {Course} from "./course";
import {Exam} from "./exam";
import {Inscription} from "./inscription";
import {Parent} from "./parent";
import { Payment } from "./payment";
import {Schedule} from "./schedule";
import {SchoolCareer} from "./school-career";
import {User} from "./user";

export interface Student extends User {
  parent: Parent;
  studentStudent: number ;
  schoolCareers: Array<SchoolCareer>;
  schedules: Array<Schedule>;
  courses: Array<Course>;
  inscriptions: Array<Inscription>;
  exams: Array<Exam>;
  payments:Array<Payment>;
}
