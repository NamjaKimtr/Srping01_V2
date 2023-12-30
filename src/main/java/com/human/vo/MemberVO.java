package com.human.vo;

public class MemberVO {
	private String id;
	private String name;
	private int point;
	private String pass;
	private String levels;
	private int enaled;
	
	
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public int getEnaled() {
		return enaled;
	}
	public void setEnaled(int enaled) {
		this.enaled = enaled;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
