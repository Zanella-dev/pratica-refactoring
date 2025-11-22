package store;

public abstract class Price {
   public abstract int getPriceCode();

   public abstract double getCharge(int daysRented);

   // MUDANÇA: Comportamento padrão (genérico) para todas as classes
   public int getFrequentRenterPoints(int daysRented) {
       return 1;
   }
}