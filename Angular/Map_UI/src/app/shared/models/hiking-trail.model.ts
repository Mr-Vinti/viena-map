import { ActivityDetails } from './activity-details.model';
import { PolylinePoint } from './polyline-point.model';

export interface HikingTrail {
  id: number;
  name: string;
  length: number;
  duration: number;
  dificulty: number;
  activityDetails: ActivityDetails;
  points: PolylinePoint[];
}
