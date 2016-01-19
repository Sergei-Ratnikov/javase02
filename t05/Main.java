/* 
Разработайте приложение, позволяющее формировать группы студентов по разным дисциплинам. Состав групп может быть разным.
Каждая дисциплина в отдельности определяет, целыми или вещественными будут оценки по нет.
Необходимо найти группы, в которые входит студент X, и сравнить его оценки.
Для огранизации перечня дисциплин можно использовать перечисление.
*/

package javase02.t05;
import java.util.*;

enum Discipline { HERBOLOGY("HERBOLOGY", "gradeFloat"), POTIONS("POTIONS", "gradeFloat"),
	TRANSFIGURATION("TRANSFIGURATION", "grade"), CHARMS("CHARMS", "grade"), ARITHMANCY("ARITHMANCY", "grade");

	private final String title;
	private final String type;
	
	private Discipline(String title, String type) {
		this.title = title;
		this.type = type;
	}
	
	@Override
	public String toString(){
		return title;
	}
	
	public String typeOf(){
		return type;
	}
}

class Grade {
	Discipline dis;
	int grade = 0;
	float gradeFloat = 0f;
	
	public boolean disChecker(String discipline) { // return true if entered discipline is in the Discipline enum
		boolean finder = false;
		Discipline[] alldis = Discipline.values();
		for(Discipline dis : alldis) {
			if (dis.toString() == discipline) { finder = true; }
		}
		return finder;
	}

	public void addGrade(String discipline, float gradeFloat) {
		if ( disChecker(discipline) ) {
			Discipline disTemporary = Discipline.valueOf(discipline);
			dis = Discipline.valueOf(discipline);
			if ( disTemporary.typeOf() == "gradeFloat" ) {
				this.gradeFloat = gradeFloat;
				System.out.print(discipline + " graded is " + gradeFloat);
			}
			else { 
				System.out.println("Error! Discipline " + discipline + " grade must be float!");
				return;
			}
		}
		else { 
			System.out.println("Error! Discipline " + discipline + " is not correct!");
			return;
		}
	}
	
	public void addGrade(String discipline, int grade) {
		if ( disChecker(discipline) ) {
			Discipline disTemporary = Discipline.valueOf(discipline);
			dis = Discipline.valueOf(discipline);
			if (disTemporary.typeOf() == "grade" ) {
				this.grade = grade;
				System.out.print(discipline + " graded is " + grade);
			}
			else {
			System.out.print("Error! Discipline " + discipline + " grade must be integer!");
			return;
			}
		}
		else { 
			System.out.println("Error! Discipline " + discipline + " is not correct!");
			return;
		}		
	}
	
	public void addGrade(float gradeFloat) {	// to change a grade
		if ( dis.typeOf() == "gradeFloat" ) {
			this.gradeFloat = gradeFloat;
			System.out.print("graded is " + gradeFloat);
		}
		else System.out.println(" must be float!");
	}

	public void addGrade(int grade) {		// to change a grade
		if ( dis.typeOf() == "grade" ) {
			this.grade = grade;
			System.out.print("graded is " + grade);
		}
		else System.out.println(" must be integer!");
	}
	
	@Override
	public String toString() {
		if ( dis.typeOf() == "gradeFloat" ) {
			return dis.toString() + " - " + gradeFloat;
		}
		else if ( dis.typeOf() == "grade" ) {
			return dis.toString() + " - " + grade;			
		}
		else return null;
	}
	
	public String gradeToString() {
		if ( dis.typeOf() == "gradeFloat" ) {
			return String.format("%1$d", gradeFloat);
		}
		else if ( dis.typeOf() == "grade" ) {
			return String.format("%1$d", grade);
		}
		else return null;
	}
	
}

class Student {
	String name;
	int age;
	ArrayList<Grade> grades = new ArrayList<Grade>(); // student's list of discipline grades

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void addGrade(String discipline, float gradeFloat) {
		Grade gradeTemporary = new Grade();
		if (gradeTemporary.disChecker(discipline) ) {
			boolean finder = true;
			for (int i = 0; i  < grades.size(); i++ ) { 			
				if (grades.get(i).dis.toString() == discipline) {	// changing grade if discipline there is at the student's list
					finder = false;
					System.out.print(discipline + " ");
					gradeTemporary = grades.get(i);
					gradeTemporary.addGrade(gradeFloat);
					break;
				}
			}
			if (finder) {				// adding new discipline grade if discipline there is not at the student's list
				gradeTemporary = new Grade();
				gradeTemporary.addGrade(discipline, gradeFloat);
				grades.add(gradeTemporary);
			}
		}
		else { 
			System.out.println("Error! Discipline " + discipline + " is not correct!");
			return;
		}
	}

	
	public void addGrade(String discipline, int grade) {
		Grade gradeTemporary = new Grade();
		if (gradeTemporary.disChecker(discipline) ) {		
			boolean finder = true;
			for (int i = 0; i  < grades.size(); i++ ) {
				if (grades.get(i).dis.toString() == discipline) {	// changing grade if discipline there is at the student's list
					finder = false;
					System.out.print(discipline + " ");
					gradeTemporary = grades.get(i);
					gradeTemporary.addGrade(grade);
					break;
				}
			}
			if (finder) {				// adding new discipline grade if discipline there is not at the student's list
				gradeTemporary = new Grade();
				gradeTemporary.addGrade(discipline, grade);
				grades.add(gradeTemporary);
			}
		}
		else { 
			System.out.println("Error! Discipline " + discipline + " is not correct!");
			return;
		}
	}
}

class Students {
	static ArrayList<Student> students = new ArrayList<Student>(); // list of all students
	private Students(Student s) { students.add(s); }
	
	static void addStudent(String name, int age) { 
		boolean finder = true;	
		for (int i = 0; i < students.size(); i++) { // before adding is searching for equality 
			if (students.get(i).name == name ) { finder = false; }
		}

		if (finder) { 
			students.add(new Student(name, age) );		// adding new student if there no equality
			System.out.println("Student " + name + " added!");
		}
		else System.out.println("Attention! Someone used Polyjuice potion! Mr. Filch, check " + name + "!");
	}

	static void addGrade(String name, String discipline, float gradeFloat) {
		boolean finder = true;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).name == name) {
				System.out.print("\n" + name + ": ");
				Student s = students.get(i);
				s.addGrade(discipline, gradeFloat);
				finder = false;
			}
		}
		if (finder) { System.out.println("Error! Incorrect student name: " + name + "!"); }
	}

	static void addGrade(String name, String discipline, int grade) {
		boolean finder = true;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).name == name) {
				System.out.print("\n" + name + ": ");
				Student s = students.get(i);
				s.addGrade(discipline, grade);
				finder = false;
			}
		}
		if (finder) { System.out.println("Error! Incorrect student name: " + name + "!"); }
	}	

	static Student getStudent(String name) {
		Student student = null;
		for (int i = 0; i < students.size(); i++) { 
			if (students.get(i).name == name) { student = students.get(i); }
		}
		return student;
	}
	
	static public void printStudent(String name) {
		Student student = getStudent(name);
		if (student != null) {
				System.out.println("\nStudent name: " + student.name);
				System.out.println("Age: " + student.age + "\n");
				System.out.println("Disciplines:");
				for (int j = 0; j < student.grades.size(); j++) {
					System.out.println(student.grades.get(j).toString());
				}
		}
		else System.out.println("There is no student " + name + " at the Hogwarts.");
	}
	
	static public void printAllStudents() {
		System.out.println("\nList of students:");
		for (int i = 0; i < students.size(); i++) {
			System.out.println("-----\nStudent name: " + students.get(i).name);
			System.out.println("Age: " + students.get(i).age + "\n");
			System.out.println("Disciplines:");
				for (int j = 0; j < students.get(i).grades.size(); j++) {
					System.out.println(students.get(i).grades.get(j).toString());
				}
		}
	}
	
	static public void printDiscipline(String discipline) {
		System.out.println("List of " + discipline + " group:");
		boolean finder = true;
		for (int i = 0; i < students.size(); i++) {
			for (int j = 0; j < students.get(i).grades.size(); j++) {
				if (students.get(i).grades.get(j).dis.toString() == discipline) {
					System.out.println(students.get(i).name + ", graded " + students.get(i).grades.get(j).gradeToString() ); 
					finder = false;
				}
			}
		}
		
		if (finder) System.out.print(" no students.");
	}
		
}
 
class Main {
	public static void main(String[] args)	{

		Students.addStudent("Hermione Granger", 12);
		Students.addStudent("Harry Potter", 12);
		Students.addStudent("Ronald Weasley", 12);		
		Students.addStudent("Ronald Weasley", 12);	// try to add Ron one more time
		System.out.println("\n----------------\n");
		
		Students.addGrade("Harry Potter", "HERBOLOGY", 4.1f); 
		Students.addGrade("Harry Potter", "CHARMS", 4.5f); // try to grade with wrong type of value
		Students.addGrade("Harry Potter", "CHARMS", 3.4f); // try to grade with wrong type of value
		Students.addGrade("Harry Potter", "CHARMS", 4);
		
		Students.addGrade("Ronald Weasley", "POTIONS", 3.2f);
		Students.addGrade("Ronald Weasley", "CHARMS", 3);
		
		Students.addGrade("Hermione Granger", "ARITHMANCY", 4);	
		Students.addGrade("Hermione Granger", "HERBOLOGY", 5.0f);		
		Students.addGrade("Hermione Granger", "POTIONS", 5.0f);
		Students.addGrade("Hermione Granger", "TRANSFIGURATION", 5);
		Students.addGrade("Hermione Granger", "CHARMS", 5);
		Students.addGrade("Hermione Granger", "ARITHMANCY", 5); //Hermione changed the ARITHMANCY grade
		Students.addGrade("Hermione Granger", "RUSSIAN LANGUAGE", 4); // try to add not declarated discipline
		System.out.println("\n-----------------\n");		
		Students.printStudent("Hermione Granger");
		System.out.println("\n-----------------\n");		
		Students.printStudent("Harry Potter");
		System.out.println("\n-----------------\n");
		Students.printStudent("Ginny Weasley"); // try to out no student
		System.out.println("\n-----------------\n");

		Students.printDiscipline("CHARMS");
		System.out.println("\n-----------------\n");		
		Students.printAllStudents();
	}
}
