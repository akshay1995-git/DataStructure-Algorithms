package activitySelection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class ActivitySelection {

	//method 1
 public static void activity_selection(ArrayList<ActivityDetail> activitylist) {
	 Collections.sort(activitylist);
	 
	 ActivityDetail first_act=activitylist.get(0);
	 for(ActivityDetail activity:activitylist) {
		 if(activity.getStart()>=first_act.getFinish()) {
			 System.out.println(activity);
			 first_act=activity;
		 }
	 }
 }
 //method 2
 
static void selection_activity(ArrayList<ActivityDetail> activitylist) {
	Comparator<ActivityDetail> finishTime=new Comparator<ActivityDetail>() {
		@Override
		public int compare(ActivityDetail o1,ActivityDetail o2) {
			return o1.getFinish()-o2.getFinish();
		}
	};
	Collections.sort(activitylist,finishTime);
	 ActivityDetail first_act=activitylist.get(0);
	 for(ActivityDetail activity:activitylist) {
		 if(activity.getStart()>=first_act.getFinish()) {
			 System.out.println(activity);
			 first_act=activity;
		 }
	 }
	
}
	public static void main(String[] args) {
		ArrayList<ActivityDetail> list=new ArrayList<ActivityDetail>();
		list.add(new ActivityDetail("A1",0,6));
		list.add(new ActivityDetail("A2",3,4));
		list.add(new ActivityDetail("A3",1,2));
		list.add(new ActivityDetail("A4",5,8));
		list.add(new ActivityDetail("A5",5,7));
		list.add(new ActivityDetail("A6",8,9));
		list.add(new ActivityDetail("A7",9,11));
		System.out.println("Activty selection is given below 1 method: ");
        activity_selection(list);
		System.out.println("\n\nActivty selection is given below 1 method: ");
        selection_activity(list);
	}


}
