import {Course} from "./course";
import {Exam} from "./exam";
import {Faculty} from "./faculty";
import {Level} from "./level";
import {Unity} from "./unity";

export interface Module {
  id:number;
  name: string;
  coeficient: number;
  faculties: Array<Faculty>;
  courses: Array<Course>;
  unity: Unity;
  level: Level;
  exams: Array<Exam>;
}
