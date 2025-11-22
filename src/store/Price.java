package store;

public abstract class Price {
   public abstract int getPriceCode();

   // MUDANÇA: O método agora é abstrato.
   // As subclasses são OBRIGADAS a implementar sua própria lógica.
   public abstract double getCharge(int daysRented);
}