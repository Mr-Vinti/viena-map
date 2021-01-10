import { ActivityDetails } from './activity-details.model';

export interface TouristAttraction {
  id: number;
  name: string;
  activityDetails: ActivityDetails;
}