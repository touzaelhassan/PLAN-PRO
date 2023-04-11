import { Category } from "./category";
import { User } from "./user";

export class Event {

  public id: number | undefined;
  public name: string;
  public description: string;
  public imageUrl: string;
  public places: number | undefined;
  public startDate : Date | null;
  public endDate : Date | null;
  public isAvailable: boolean;
  public isApproved: boolean;
  public organizer: User;
  public category: Category;


  constructor() {
    this.id = undefined;
    this.name = '';
    this.description = '';
    this.imageUrl = '';
    this.places = undefined;
    this.startDate = null;
    this.endDate = null;
    this.isAvailable = false;
    this.isApproved = false;
    this.organizer = new User();
    this.category = new Category();

  }

}