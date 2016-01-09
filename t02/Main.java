package javase02.t02;

// Задание 2. Классы и объекты
// Напишите приложение, позволяющее вести учет канцелярских товаров на рабочем месте сотрудника.
// Определите полную стоимость канцтоваров у определенного сотрудника.

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

class Staff {

    int index;  // количество видов канцтоваров у одного сотрудника
	Stationery[] set;
	
	public Staff(int index) {
		this.index = index;
		this.set = new Stationery[index];
	}
	
	void printer() {
		System.out.println();
		for (int i = 0; i < index; i++) {
			String s = "";
			if (set[i].quantity > 1) s = "s";
			System.out.println(set[i].quantity + " " + set[i].productType + s +" of \"" + set[i].producerName + "\" - " + set[i].price + " for each.");
		}
	}
	
	float totalPrice() {
		float p = 0;
		for (int i = 0; i < index; i++) {
			p = p + set[i].quantity * set[i].price;
		}
		
		return p;
	}
	
}
	
public class Main {
	public static void main(String[] args) {
		Staff stSet = new Staff(3);
		stSet.set[0] = new Stationery("pen", "Pilot", 5, 2.75f);
		stSet.set[1] = new Stationery("pensil", "Kohinoor", 3, 1.25f);
		stSet.set[2] = new Stationery("eraser", "Silky", 1, 2.15f);
		stSet.printer();
		System.out.println("-------------");
		System.out.println("Total stationery price: " + stSet.totalPrice());
	}
}


