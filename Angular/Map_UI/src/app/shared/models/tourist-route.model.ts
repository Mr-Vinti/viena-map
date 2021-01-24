import { ActivityDetails } from './activity-details.model';
import { PolylinePoint } from './polyline-point.model';

export interface TouristRoute {
  id: number;
  name: string;
  length: number;
  objectivesNumber: number;
  activityDetails: ActivityDetails;
  points: PolylinePoint[];
}
