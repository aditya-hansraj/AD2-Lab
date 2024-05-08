import java.util.*;
import com.traf.Job;

public class IntervalScheduling {
	public static void main(String[] args) {
		Job[] jobs = { 
				new Job(0, 6, "a"), 
				new Job(1, 4, "b"), 
				new Job(3, 5, "c"), 
				new Job(3, 8, "d"), 
				new Job(4, 7, "e"), 
				new Job(5, 9, "f"), 
				new Job(6, 10, "g"),
				new Job(8, 11, "h")
		};
		List<Job> selctedJobs = IntervalScheduling.findOptimalJobSchedule(jobs);
		System.out.println(selctedJobs);
	}
	
	public static List<Job> findOptimalJobSchedule(Job[] jobs) {
		Arrays.sort(jobs);
		
		List<Job> selectedJobs = new LinkedList<Job>();
		
		selectedJobs.add(jobs[0]);
		Job lastJobAdded = jobs[0];
		
		for(Job j : jobs) {
			if(j.start >= lastJobAdded.finish) {
				selectedJobs.add(j);
				lastJobAdded = j;
			}
		}
		
		return selectedJobs;
	}
}
