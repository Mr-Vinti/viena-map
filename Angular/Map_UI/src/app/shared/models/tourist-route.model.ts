import { ActivityDetails } from './activity-details.model';

export interface TouristRoute {
  id: number;
  name: string;
  length: number;
  objectivesNumber: number;
  activityDetails: ActivityDetails;
}