package javase02.t01;

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
        if ( getClass() != obj.getClass() ) return false;
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
        return getClass().getName() + "@" + "price: " + price + ", producerName: " + producerName;
    }

    public static void main(String[] args) {
        int ind = 25;
        String str = "Kohinoor";
        
        Pen onePen = new Pen(25, "Kohinoor");
        Pen twoPen = new Pen(ind, str);
        Pen threePen = new Pen(26, "Kohinoor");
        System.out.println(onePen.toString());
        System.out.println("onePen.equals(twoPen) = " + onePen.equals(twoPen));
        System.out.println("onePen.equals(threePen) = " + onePen.equals(threePen));       
        System.out.println(onePen.hashCode());        
        System.out.println(twoPen.hashCode());       
    }
    
}