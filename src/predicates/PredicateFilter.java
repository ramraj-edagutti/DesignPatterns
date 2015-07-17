package predicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class PredicateFilter {
	
	public static <T> Collection<T> filter(Collection<T> col, Predicate<T> type){
		Collection<T> results = new ArrayList<T>();
		for (T object : col) {
			if (type.apply(object))
				results.add(object);
		}
		return results;
	}

	public static void main(String[] args) {
		
		Person p1 = new Person("Ramraj", 32, Gender.MALE);
		Person p2 = new Person("Edagutti", 30, Gender.MALE);
		Person p3 = new Person("Mohan", 35, Gender.MALE);
		Person p4 = new Person("Pavani", 26, Gender.FEMALE);
		Person p5 = new Person("Dhriti", 2, Gender.FEMALE);
		
		List<Person> persons = Arrays.asList(p1,p2,p3,p4,p5);
		
		Predicate<Person> malePersonFilter = new Predicate<Person>() {
			@Override
			public boolean apply(Person type) {
				return Gender.MALE.equals(type.getSex());
			}
		};
		
		Predicate<Person> femalePersonFilter = new Predicate<Person>() {
     		@Override
			public boolean apply(Person type) {
				return Gender.FEMALE.equals(type.getSex());
			}
		};
		
		Predicate<Person> middleAgePersons = new Predicate<Person>() {
			@Override
			public boolean apply(Person type) {
			return type.age > 30;
			}
		};
		
		Collection<Person> males = filter(persons, malePersonFilter);
		Collection<Person> females = filter(persons, femalePersonFilter);
		Collection<Person> middleAgers = filter(persons, middleAgePersons);
		
		System.out.println("Males: "+males.toString());
		System.out.println("Females: "+females.toString());
		System.out.println("Middle agers: "+middleAgers);
		
	}
}
enum Gender {MALE, FEMALE};

class Person {
	String name;
	int age;
	Gender sex;
	
	public Person(String name, int age, Gender sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "{Name=" + name + ", age=" + age + ", sex=" + sex +"}";
	}
	
}