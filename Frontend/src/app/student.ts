import { Courses } from './courses';

export class Student {
  id_student: number;
  email: string;
  password: string;
  name: string;
  courses: Courses[];
  constructor() {}
}
