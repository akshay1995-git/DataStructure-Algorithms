package activitySelection;

public class ActivityDetail implements Comparable<ActivityDetail> {

	private String name;
	private int start;
	private int finish;
	public ActivityDetail(String name,int start,int finish) {
		this.name=name;
		this.start=start;
		this.finish=finish;
				
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getFinish() {
		return finish;
	}
	public void setFinish(int finish) {
		this.finish = finish;
	}
	
	@Override
	public String toString() {
		return "ActivityDetail [name=" + name + ", start=" + start + ", finish=" + finish + "]";
	}
	@Override
	public int compareTo(ActivityDetail o) {
//		if(finish>o.finish) {
//			return -1;
//		}
//		else if(finish<o.finish) {
//			return 1;
//		}
//		else {
//			return 0;
//		}
		return finish-o.finish;
	}

}
