package test.goodjoon.guppy.channel.model;

public class SimplePostParam {
	protected String Name;
	protected int age;
	protected String[] cars;
	protected int[] years;
	protected int[] nullNumberTests;
	protected String[] nullStringTests;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getCars() {
		return cars;
	}
	public void setCars(String[] cars) {
		this.cars = cars;
	}
	public int[] getYears() {
		return years;
	}
	public void setYears(int[] years) {
		this.years = years;
	}
	public int[] getNullNumberTests() {
		return nullNumberTests;
	}
	public void setNullNumberTests(int[] nullNumberTests) {
		this.nullNumberTests = nullNumberTests;
	}
	public String[] getNullStringTests() {
		return nullStringTests;
	}
	public void setNullStringTests(String[] nullStringTests) {
		this.nullStringTests = nullStringTests;
	}
	
	
}
