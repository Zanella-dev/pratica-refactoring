package store;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
   private String _name;
   private Vector _rentals = new Vector();

   public Customer (String name){
      _name = name;
   }

   public void addRental(Rental arg) {
      _rentals.addElement(arg);
   }
   
   public String getName (){
      return _name;
   }
  
   public String statement() {
      Enumeration rentals = _rentals.elements();
      String result = "Rental Record for " + getName() + "\n";
      
      // MUDANÇA: O loop agora serve APENAS para montar as linhas de texto.
      // As variáveis 'totalAmount' e 'frequentRenterPoints' foram removidas daqui.
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();

         // show figures for this rental
         result += "\t" + each.getMovie().getTitle()+ "\t" +
                  String.valueOf(each.getCharge()) + "\n";
      }

      // add footer lines
      // MUDANÇA: Agora chamamos os novos métodos getTotalCharge() e getTotalFrequentRenterPoints()
      result +=  "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
      result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                     " frequent renter points";
      return result;
   }
      
   // NOVO MÉTODO EXTRAÍDO
   private double getTotalCharge() {
      double result = 0;
      Enumeration rentals = _rentals.elements();
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += each.getCharge();
         }
         return result;
   }

   // NOVO MÉTODO EXTRAÍDO
   private int getTotalFrequentRenterPoints(){
      int result = 0;
      Enumeration rentals = _rentals.elements();
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += each.getFrequentRenterPoints();
      }
      return result;
   }
}