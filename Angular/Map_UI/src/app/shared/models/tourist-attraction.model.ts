import { ActivityDetails } from './activity-details.model';

export interface TouristAttraction {
  id: number;
  name: string;
  url: string;
  activityDetails: ActivityDetails;
}
