package models;

public class Student {
	public Integer id;
	public String name;
	public String surname;
	public String icon;
	
	public Student(Integer id, String name, String surname, String icon){
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.icon = icon;
	}
}
