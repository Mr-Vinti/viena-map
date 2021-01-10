import { ActivityDetails } from './activity-details.model';

export interface Park {
  id: number;
  name: string;
  surface: number;
  playgrounds: boolean;
  petspaces: boolean;
  activityDetails: ActivityDetails;
}