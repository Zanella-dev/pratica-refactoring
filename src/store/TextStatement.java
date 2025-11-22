package store;
import java.util.Enumeration;

public class TextStatement extends Statement {
   
   public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = headerString(aCustomer);
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += rentalString(each);
      }
      result += footerString(aCustomer);
      return result;
   }

   private String headerString(Customer aCustomer) {
      return "Rental Record for " + aCustomer.getName() + "\n";
   }

   private String rentalString(Rental aRental) {
      return "\t" + aRental.getMovie().getTitle()+ "\t" +
             String.valueOf(aRental.getCharge()) + "\n";
   }

   private String footerString(Customer aCustomer) {
      return "Amount owed is " +
             String.valueOf(aCustomer.getTotalCharge()) + "\n" +
             "You earned " +
             String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
             " frequent renter points";
   }
}