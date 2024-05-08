package com.traf;

public class Job implements Comparable<Job>{
	public int start, finish;
	public String name;
	
	public Job(int start, int finish, String name) {
		this.start = start;
		this.finish = finish;
		this.name = name;
	}
	
	public int compareTo(Job j) {
		return this.finish - j.finish;
	}

	@Override
	public String toString() {
		return "Job [start=" + start + ", finish=" + finish + ", name=" + name + "]";
	}
	
}
