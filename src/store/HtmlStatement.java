package store;

public class HtmlStatement extends Statement {

   // O método value() foi REMOVIDO (herdado de Statement)

   String headerString(Customer aCustomer) {
      return "<H1>Rentals for <EM>" + aCustomer.getName() +
             "</EM></H1><P>\n";
   }

   String rentalString(Rental aRental) {
      return aRental.getMovie().getTitle()+ ": " +
             String.valueOf(aRental.getCharge()) + "<BR>\n";
   }

   String footerString(Customer aCustomer) {
      return "<P>You owe <EM>" +
             String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" +
             "On this rental you earned <EM>" + 
             String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
             "</EM> frequent renter points<P>";
   }
}