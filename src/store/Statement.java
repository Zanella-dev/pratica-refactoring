package store;
import java.util.Enumeration;

// MUDANÇA: Agora a classe é abstrata pois tem métodos abstratos
public abstract class Statement {

   // TEMPLATE METHOD: Este método define o esqueleto do algoritmo.
   // Ele foi movido das subclasses para cá.
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

   // Métodos abstratos que as subclasses DEVEM implementar
   abstract String headerString(Customer aCustomer);
   abstract String rentalString(Rental aRental);
   abstract String footerString(Customer aCustomer);
}