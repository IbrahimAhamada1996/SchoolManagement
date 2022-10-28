import {ExamType} from "./exam-type";
import {Module} from "./module";
import {Session} from "./session";
import {Student} from "./student";

export interface Exam {
  id:number;
  observation: string;
  result: string;
  dateTime: string;
  note: number;
  session: Session;
  examType: ExamType;
  student: Student;
  module: Module;
}
