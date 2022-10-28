import {Grade} from "./grade";
import {Module} from "./module";

export interface Level {
  id:number;
  name: string;
  semester: number;
  grade: Grade;
  modules: Array<Module>;
}
