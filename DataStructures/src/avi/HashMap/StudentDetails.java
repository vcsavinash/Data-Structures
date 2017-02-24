package avi.assignment6;

public class StudentDetails {

	String name;
	int studentId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public StudentDetails(int studentId,String name){
		this.name = name;
		this.studentId = studentId;
	}
}
