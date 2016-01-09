package javase02.t06;

public class NucSub {

	String[] boatTypeAll = {"SSN", "SSBN", "SSGN", "Yellow Submarine"}; // перечисление существующих типов лодок
    String boatType;			// тип лодки конкретного объекта
    String reactorType;		// тип реактора конкретного объекта, объявляется через подкласс
    float power;			// мощность силовой установки
    
	// конструктор
	NucSub(byte boatTypeInd, byte reactTypeInd, float power) {
        boatType = boatTypeAll[boatTypeInd];
       
        AtomicPile engine = new AtomicPile();
        reactorType = engine.type(reactTypeInd);
        
        this.power = power;
	}

    class AtomicPile {  // вложенный класс
        String[] reactorTypeAll = {"LMFR (Liquid metal fast reactor)", "PWR (Pressurized water reactor)"};	// перечисление существующих типов реакторов
        
        String type(byte i) {
            return reactorTypeAll[i];
        }
    }
   
    public static void main(String[] args) {
            
        byte boatTypeInd = 3;
        byte reactTypeInd = 0;
        NucSub boat = new NucSub(boatTypeInd, reactTypeInd, (float) 2500);
            
        System.out.println("\nSubmarine type:\t\t" + boat.boatType);
        System.out.println("Atomic pile type:\t" + boat.reactorType);
        System.out.println("Atomic pile power:\t" + boat.power + " kWt");
        System.out.println("\nWelcome aboard!");
        System.out.println("         |_\n   _____|~ |____\n  (  --         ~~~~--_,\n   ~~~~~~~~~~~~~~~~~~~'` \n");

    }

}
