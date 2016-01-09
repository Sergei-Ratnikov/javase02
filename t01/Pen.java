package javase02.t01;

// Задание 1. Принципы ООП, простейшие классы и объекты
// Разработайте спецификацию и создайте класс Ручка (Pen). Определите в этом классе методы equals(), hashCode() и toString().

public class Pen {
    int price;
    String producerName;
   
    // конструктор
    public Pen(int price, String producerName) {
        this.price = price;
        this.producerName = producerName;
    }
    
    // сравнивает между собой два объекта класса Pen
    @Override
    public boolean equals(Object obj) {
        if ( getClass() != obj.getClass() ) return false;  //сравнение классов 
        else {
            Pen pen = (Pen) obj;
            if ( (price == pen.price) & (producerName == pen. producerName) ) return true;
            else return false;
        } 
    }

    // возвращает хэш-код объекта класса Pen
    @Override
    public int hashCode() {
        return (int) (price + ((null == producerName) ? 0 : producerName.hashCode()));
    }

    // выводит в строку содержимое объекта класса Pen
    public String toString() {
        return getClass().getName() + "; price: " + price + "; producerName: " + producerName;
    }

    public static void main(String[] args) {
        int ind = 25;
        String str = "Kohinoor";
        
        Pen onePen = new Pen(25, "Kohinoor");
        Pen twoPen = new Pen(ind, str);
        Pen threePen = new Pen(265, "Parker");
        System.out.println("\nonePen.toString() is: " + onePen.toString());
		System.out.println("twoPen.toString() is: " + twoPen.toString());
		System.out.println("threePen.toString() is: " + threePen.toString());
		
        System.out.println("\nonePen.equals(twoPen) is: " + onePen.equals(twoPen));
        System.out.println("onePen.equals(threePen) is: " + onePen.equals(threePen));       
        System.out.println("\nonePen.hashCode() is: " + onePen.hashCode());        
        System.out.println("twoPen.hashCode() is: " + twoPen.hashCode());       
    }
    
}