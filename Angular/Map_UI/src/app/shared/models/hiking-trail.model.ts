import { ActivityDetails } from './activity-details.model';

export interface HikingTrail {
  id: number;
  name: string;
  length: number;
  duration: number;
  dificulty: number;
  activityDetails: ActivityDetails;
}
