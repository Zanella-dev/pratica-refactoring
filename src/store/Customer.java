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
   
   // NOVO MÉTODO: Necessário para expor a lista para as classes Statement
   public Enumeration getRentals() {
       return _rentals.elements();
   }
  
   // MUDANÇA: Agora delega para a classe TextStatement
   public String statement() {
      return new TextStatement().value(this);
   }
   
   // MUDANÇA: Agora delega para a classe HtmlStatement
   public String htmlStatement() {
      return new HtmlStatement().value(this);
   }
      
   // MUDANÇA: Visibilidade alterada de private para public
   public double getTotalCharge() {
      double result = 0;
      Enumeration rentals = _rentals.elements();
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += each.getCharge();
         }
         return result;
   }

   // MUDANÇA: Visibilidade alterada de private para public
   public int getTotalFrequentRenterPoints(){
      int result = 0;
      Enumeration rentals = _rentals.elements();
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += each.getFrequentRenterPoints();
      }
      return result;
   }
}