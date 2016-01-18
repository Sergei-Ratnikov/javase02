/* 
Разработайте приложение, позволяющее формировать группы студентов по разным дисциплинам. Состав групп может быть разным.
Каждая дисциплина в отдельности определяет, целыми или вещественными будут оценки по нет.
Необходимо найти группы, в которые входит студент X, и сравнить его оценки.
Для огранизации перечня дисциплин можно использовать перечисление.
*/

package javase02.t05;
import java.util.*;

enum Discipline { HERBOLOGY("HERBOLOGY", "pass"), POTIONS("POTIONS", "pass"),
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

// Класс Grade (оценка). поля: Предмет (ссылка на String enum Subjects), тип оценки (зачет int или оценка boolean), сама оценка по предмету
class Grade {

	Discipline dis;
	int grade;
	boolean pass;

	public void addGrade(String d, boolean pass) {
		Discipline disTemporary = Discipline.valueOf(d);
		if ( disTemporary.typeOf() == "pass" ) {
				dis = Discipline.valueOf(d);
				this.pass = pass;
			}
	}
	public void addGrade(String d, int grade) {
		Discipline disTemporary = Discipline.valueOf(d);
		if ( disTemporary.typeOf() == "grade" ) {
				dis = Discipline.valueOf(d);
				this.grade = grade;
		}
	}
	
	@Override
	public String toString() {
		if ( dis.typeOf() == "pass" ) {
			return dis.toString() + " - " + pass;
		}
		else {
			return dis.toString() + " - " + grade;			
		}		
	}
	
}

class Student {
	String name;
	int age;
	ArrayList<Grade> grades = new ArrayList(); // список оценок студента

	public Student(String name, int age) { this.name = name; this.age = age; }

	public void addGrade(String d, boolean pass) { 			//дисциплина, зачет
		boolean finder = true;								// маркер совпадений при поиске
		for (int i = 0; i  < grades.size(); i++ ) { 	// поиск предмета в зачетке студента
			if (grades.get(i).dis.toString() == d) {		// если предмет уже есть в списке, то происходит замена оценки
				Grade g = new Grade();
				g.addGrade(d, pass);
				grades.set(i, g);
				finder = false;
			}
		}

		if (finder) {					// если нет совпадений, то в список добавляется новый предмет
			Grade g = new Grade();
			g.addGrade(d, pass);
			grades.add(g);
		}
	}

	
	public void addGrade(String d, int grade) { 			//дисциплина, оценка
		boolean finder = true;								// маркер совпадений при поиске
		for (int i = 0; i  < grades.size(); i++ ) { 	// поиск предмета в зачетке студента
			if (grades.get(i).dis.toString() == d) {		// если предмет уже есть в списке, то происходит замена оценки
				Grade g = new Grade();
				g.addGrade(d, grade);
				grades.set(i, g);
				finder = false;
			}
		}
		
		if (finder) {					// если нет совпадений, то в список добавляется новый предмет
			Grade g = new Grade();
			g.addGrade(d, grade);
			grades.add(g);
		}
	}
}

class Students {
	static ArrayList<Student> students = new ArrayList();
	public Students(Student s) { students.add(s); }
	
	static void addStudent(String name, int age) { 
		boolean finder = true;	
		for (int i = 0; i < students.size(); i++) { // поиск студента, проверка на совпадение имен
			if (students.get(i).name == name ) { finder = false; }
		}

		if (finder) { 
			students.add(new Student(name, age) );		// если нет совпадений, то в список добавляется новый студент
			System.out.println("Student " + name + " added!");
		}
		else System.out.println("\n\tSomeone used Polyjuice potion!\n"); // если есть совпадение - кто-то использует оборотное зелье
	}

	static void addGrade(String n, String d, boolean pass) { // имя студента, предмет, зачет
		for (int i = 0; i < students.size(); i++) { // поиск студента
			if (students.get(i).name == n) {
				Student s = students.get(i);
				s.addGrade(d, pass);
				students.set(i, s);
			}
		}
	}

	static void addGrade(String n, String d, int grade) { // имя студента, предмет, оценка
		for (int i = 0; i < students.size(); i++) { // поиск студента
			if (students.get(i).name == n) {
				Student s = students.get(i);
				s.addGrade(d, grade);
				students.set(i, s);
			}
		}
	}	

	static Student getStudent(String n) {
		Student s = null;
		for (int i = 0; i < students.size(); i++) { // поиск студента
			if (students.get(i).name == n) { s = students.get(i); }
		}
		return s;
	}
	
	static void printStudent(String n) {
		for (int i = 0; i < students.size(); i++) { // поиск студента
			if (students.get(i).name == n) {
				System.out.println("Student name: " + students.get(i).name);
				System.out.println("Age: " + students.get(i).age + "\n");
				System.out.println("Disciplines:\n");
				for (int j = 0; j < students.get(i).grades.size(); j++) {
					System.out.println(students.get(i).grades.get(j).toString());
				}
			}
		}
	}
	
}
 
class Main {
	public static void main(String[] args)	{

		Students.addStudent("Hermione Granger", 12);
		Students.addStudent("Harry Potter", 12);
		Students.addStudent("Ronald Weasley", 12);		

		Students.addStudent("Ronald Weasley", 12);	// пробуем добавить Рона еще раз
		
		Students.addGrade("Harry Potter", "HERBOLOGY", true); 
		Students.addGrade("Harry Potter", "CHARMS", 4);
		
		Students.addGrade("Ronald Weasley", "POTIONS", true);
		Students.addGrade("Ronald Weasley", "CHARMS", 3);  //Рон троешник
		
		Students.addGrade("Hermione Granger", "ARITHMANCY", 4);	
		Students.addGrade("Hermione Granger", "HERBOLOGY", true);		
		Students.addGrade("Hermione Granger", "POTIONS", true);
		Students.addGrade("Hermione Granger", "TRANSFIGURATION", 5);
		Students.addGrade("Hermione Granger", "CHARMS", 5);  //У Гермионы есть маховик времени, она ходит на все уроки
		

		System.out.println("----------------\n");
		Students.printStudent("Hermione Granger");
		System.out.println("-----------------\n");
		
		Students.addGrade("Hermione Granger", "ARITHMANCY", 5); //Гермиона исправила четверку по нумерологии
		Students.printStudent("Hermione Granger");
		System.out.println("-----------------\n");
		
		Students.printStudent("Ronald Weasley");
		System.out.println("-----------------\n");
	}
}
