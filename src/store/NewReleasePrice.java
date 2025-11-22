package store;

public class NewReleasePrice extends Price {
   public int getPriceCode() {
       return Movie.NEW_RELEASE;
   }

   public double getCharge(int daysRented){
      return daysRented * 3;
   }
   
   // MUDANÇA: Sobrescrevemos o método para aplicar a regra de bônus
   public int getFrequentRenterPoints(int daysRented) {
       return (daysRented > 1) ? 2: 1;
   }
}