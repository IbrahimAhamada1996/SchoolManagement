import {Department} from "./department";
import {Grade} from "./grade";
import { Inscription } from "./inscription";
import {Module} from "./module";

export interface Faculty {
  id:number;
  name: string;
  inscription: Array<Inscription>;
  modules: Array<Module>;
  grades: Array<Grade>;
  department: Department;
}
