package javase02.t03;
import java.util.*;

// Задание 3. Наследование
// Разработайте иерархию канцелярских товаров. Создайте “набор новичка”, используя созданную иерархию.

class Stationery {
    String productType;
	String producerName;
	int quantity;
	float price;

    // конструктор
    public Stationery(String productType, String producerName, int quantity, float price) {
        this.productType = productType;
        this.producerName = producerName;
		this.quantity = quantity;
		this.price = price;
    }
}

class Pen extends Stationery {
	String[] colors = {"blue", "black", "red"};
	String color;
	public Pen(String producerName, int quantity, float price, int col) {
		super("Pen", producerName, quantity, price);
		color = colors[col];
	}
	
	public String toString() {
	return getClass().getName() + ": " + quantity + " " + color + " " + productType
			+ " of \"" + producerName + "\" price: " + price;
    }
}

// подкласс 2 уровня 
class InkPen extends Pen {
	String[] types = {"standart", "premium"};
	String type;
	public InkPen(String producerName, int quantity, float price, int col, int ind) {
		super(producerName, quantity, price, col);
		productType = "Ink pen";
		type = types[ind];
	}
		
	public String toString() {
	return getClass().getName() + ": " + quantity + " " + color + " " + productType
			+ " " + type + "-class of \"" + producerName + "\" price: " + price;
	}
}

class Pencil extends Stationery {
	String[] types = {"wooden", "plactic"};
	String type;
	public Pencil(String producerName, int quantity, float price, int t) {
		super("Pencil", producerName, quantity, price);
		type = types[t];
	}
	
	public String toString() {
	return getClass().getName() + ": " + quantity + " " + type + " " + productType
			+ " of \"" + producerName + "\" price: " + price;
	}
}

// подкласс 2 уровня 
class MechPencil extends Pencil {
	float[] diameters = {0.5f, 0.7f};
	float dia;
	public MechPencil(String producerName, int quantity, float price, int d) {
		super(producerName, quantity, price, 1);
		productType = "Mechanic pencil";
		dia = diameters[d];
	}
	
	public String toString() {
	return getClass().getName() + ": " + quantity + " " + type + " " + productType
			+ " diameter = " + dia + " of \"" + producerName + "\" price: " + price;
	}
}

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		ArrayList<Stationery> BaseList = new ArrayList();
		BaseList.add(new Pen("Pilot", 5, 2.75f, 1));
		BaseList.add(new Pen("Pilot", 5, 2.75f, 0));
		BaseList.add(new Pencil("Kohinoor", 3, 0.25f, 0));
		
		System.out.println("\nBase set:");
		for(int i = 0; i < BaseList.size(); i++)
			System.out.println((BaseList.get(i)).toString());
// Здесь метод toString работает только потому, что он является методом класса Object
// назывался бы метод по-другому - потребовался бы интерфейс - см. 4 задание
		
		ArrayList<Stationery> BossList = new ArrayList();
		BossList.add(new InkPen("Parker", 5, 10.75f, 0, 1));
		BossList.add(new MechPencil("Kohinoor", 3, 3.55f, 1));
		
		System.out.println("\nBoss set:");
		for(int i = 0; i < BossList.size(); i++)
			System.out.println((BossList.get(i)).toString());
		
	}
}

