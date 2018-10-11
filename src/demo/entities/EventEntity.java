package demo.entities;

import java.io.*;

public class EventEntity implements Serializable {

	private int id;
	private String title;
	private String start;
	private String end;
    private String remindme="false";
    private String time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getRemindme() {
		return remindme;
	}

	public void setRemindme(String remindme) {
		this.remindme = remindme;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	

}
