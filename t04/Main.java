package javase02.t04;
import java.util.*;

interface Outer { // интерфейс вывода информации из класса
	public String outString();
	public float outPrice();
	public String outProductType();
}

abstract class Stationery implements Outer {
    String productType;
	String producerName;
	int quantity;
	float price;

    public Stationery(String productType, String producerName, int quantity, float price) {
        this.productType = productType;
        this.producerName = producerName;
		this.quantity = quantity;
		this.price = price;
    }
	
	public String outString() {
		return getClass().getName();
	}
	
	public float outPrice() { return price; }
	
	public String outProductType() { return productType; }
}

class Pen extends Stationery {
	String[] colors = {"blue", "black", "red"};
	String color;
	
	public Pen(String producerName, int quantity, float price, int col) {
		super("Pen", producerName, quantity, price);
		color = colors[col];
	}
	
	public String outString() {
	return quantity + " " + color + " " + productType + " of \"" + producerName + "\" price: " + price;
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
		
	public String outString() {
	return quantity + " " + color + " " + productType + " " + type + "-class of \"" + producerName + "\" price: " + price;
	}
}

class Pencil extends Stationery {
	String[] types = {"wooden", "plactic"};
	String type;
	
	public Pencil(String producerName, int quantity, float price, int t) {
		super("Pencil", producerName, quantity, price);
		type = types[t];
	}
	
	public String outString() {
	return quantity + " " + type + " " + productType + " of \"" + producerName + "\" price: " + price;
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
	
	public String outString() {
	return quantity + " " + type + " " + productType + " diameter = " + dia + " of \"" + producerName + "\" price: " + price;
	}
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