package testspring;

import java.io.Serializable;

public class RuntimeRecord {
	private String startTime;
	private String endTime;
	private String className;
	private String methodName;
	private long duration;
	
	public RuntimeRecord(){}
	
	public RuntimeRecord(String start, String end, String classname, String method, long duration)
	{
		setStartTime(start);
		setEndTime(end);
		setClassName(classname);
		setMethodName(method);
		setDuration(duration);
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public String toString()
	{
		return "startTime:"+ startTime +",endTime:" +endTime +",duration:" + duration +",className:"+className +",methodName:" +methodName;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
}
