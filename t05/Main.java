package javase02.t05;
import java.util.*;

/* 
Разработайте приложение, позволяющее формировать группы студентов по разным дисциплинам. Состав групп может быть разным.
Каждая дисциплина в отдельности определяет, целыми или вещественными будут оценки по нет.
Необходимо найти группы, в которые входит студент X, и сравнить его оценки.
Для огранизации перечня дисциплин можно использовать перечисление.


Класс Student - поля Имя, деньрожденье + любая информация о студентусе
ArrayList<Student> Students - список студентов
Класс Оценка. поля: Студент (ссылка на студента из списка), тип оценки (зачет int или оценка boolean), сама оценка по предмету 
ArrayList<Оценка> Оценки - список студентов по данному предмету
enum Предметы - ПРЕДМЕТ(ArrayList Оценки )
Поиск получает строку Имя, пробегается по ПРЕДМЕТам и выдает строку предмет - оценка.
 */



interface Outer {
	public String outString();
	public float outPrice();
	public String outProductType();
}

class Student {
	String name;
	
	public Student ()
}

class Bubble {
	static ArrayList sortPrice(ArrayList<Outer> inputList) {
		int a, b, s;
		s = inputList.size() - 1; // s - порядковый номер последнего элемента коллекции
		inputList.add(inputList.get(0)); // добавление элемента массива для сортировки
		for( a = 1; a < s ; a++)
			for( b = (s - 1); b >= a; b--) {
				if( inputList.get(b-1).outPrice() > inputList.get(b).outPrice() ) { // если требуемый порядок следования не соблюдается, поменять элементы местами
					// замена
					inputList.set((s + 1), inputList.get(b - 1));
					inputList.set((b - 1), inputList.get(b));
					inputList.set(b, inputList.get(s + 1));
				}
			}	
		inputList.remove(s + 1); // удаление элемента массива для сортировки
		
		return inputList;
	}
}

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		ArrayList<Outer> BaseList = new ArrayList();
		BaseList.add(new Pen("Corvina", 1, 1.25f, 0));
		BaseList.add(new Pen("Komus", 2, 1.55f, 1));
		BaseList.add(new Pencil("Kohinoor", 3, 0.25f, 0));
		BaseList.add(new Pen("Pilot", 4, 1.75f, 2));
		
		System.out.println("\nUnsorted base set:");
		for(int i = 0; i < BaseList.size(); i++)
			System.out.println((BaseList.get(i)).outString());

		BaseList = Bubble.sortPrice(BaseList);
		
		System.out.println("\nBase set sorted by price:");
		for(int i = 0; i < BaseList.size(); i++)
			System.out.println((BaseList.get(i)).outString());
	}
}