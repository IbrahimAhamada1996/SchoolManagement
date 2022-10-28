import {Classroom} from "./classroom";
import { Employee } from "./employee";
import {Module} from "./module";
import {Student} from "./student";

export interface Course {
  id:number;
  name: string;
  totalHour: number;
  teachHour: number;
  createdAt: string;
  teacher: Employee;
  students: Array<Student>;
  classroom: Array<Classroom>;
  module: Array<Module>;
}
