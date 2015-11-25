package com.example.bloodaccount;

public class Student {

	private int id;
	private String name;
	private String batch;
	private String dept;
	private String mobile;
	private String bgroup;
	//public int idno;
	public Student(int id, String name, String batch, String dept,
			String mobile, String bgroup) {
		this.id = id;
		this.name = name;
		this.batch = batch;
		this.dept = dept;
		this.mobile = mobile;
		this.bgroup = bgroup;
	}
	public Student(String name, String batch, String dept, String mobile,
			String bgroup) {
		this.name = name;
		this.batch = batch;
		this.dept = dept;
		this.mobile = mobile;
		this.bgroup = bgroup;
	}
	public Student() {
		//this.id = id;
		/*this.name ="empty";
		this.batch = "empty";
		this.dept = "empty";
		this.mobile ="empty";
		this.bgroup ="empty";*/
	}
	/*public Student(int irow, String iName, String iDept, String iMob) {
		// TODO Auto-generated constructor stub
		this.name = iName;
		this.id=irow;
		this.dept = iDept;
		this.mobile = iMob;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public String toString() {
		
		/*return "Student [id=" + id + ", name=" + name + ", batch=" + batch
				+ ", dept=" + dept + ", mobile=" + mobile + ", bgroup="
				+ bgroup + "]";*/
		return "Student id=" + id + "\n Name=" + name + "\n Batch=" + batch
				+ "\t Department=" + dept + "\n BloodGroup=" + bgroup + "\n Mobile Number="
				+ mobile ;
	}
	public String getString(){
		return "Student Name=" + name + "\n Batch=" + batch
				+ "\t Department=" + dept + "\n BloodGroup=" + bgroup + "\n Mobile Number="
				+ mobile ;
	}
}
