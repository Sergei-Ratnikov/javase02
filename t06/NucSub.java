package javase02.t06;

public class NucSub {

    String[] subTypeAll = {"SSN", "SSBN", "SSGN", "Yellow Submarine"};
    String subType;
    String reactorType;
    float power;  
    
   NucSub(byte boatTypeInd, byte reactTypeInd, float pow) {
        subType = subTypeAll[boatTypeInd];
       
        AtomicPile engine = new AtomicPile();
        reactorType = engine.type(reactTypeInd);
        
        power = pow;
   }

    class AtomicPile {
        String[] reactorTypeAll = {"LMFR (Liquid metal fast reactor)", "PWR (Pressurized water reactor)"};
        
        String type(byte i) {
            return reactorTypeAll[i];
        }
    }
   
    public static void main(String[] args) {
            
        byte boatTypeInd = 3;
        byte reactTypeInd = 0;
        NucSub boat = new NucSub(boatTypeInd, reactTypeInd, (float) 2500);
            
        System.out.println("\nSubmarine type:\t\t" + boat.subType);
        System.out.println("Atomic pile type:\t" + boat.reactorType);
        System.out.println("Atomic pile power:\t" + boat.power + " kWt");
        System.out.println("\nWelcome aboard!");
        System.out.println("         |_\n   _____|~ |____\n  (  --         ~~~~--_,\n   ~~~~~~~~~~~~~~~~~~~'` \n");

    }

}
