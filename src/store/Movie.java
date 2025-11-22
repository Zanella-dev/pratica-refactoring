package store;

public class Movie {

  public static final int  CHILDRENS = 2;
  public static final int  REGULAR = 0;
  public static final int  NEW_RELEASE = 1;

  private String _title;
  private Price _price; // MUDANÇA: Agora é um objeto do tipo Price

  public Movie(String title, int priceCode) {
      _title = title;
      setPriceCode(priceCode); // O construtor usa o set para inicializar
  }

  // MUDANÇA: Delega para o objeto _price
  public int getPriceCode() {
      return _price.getPriceCode();
  }

  // MUDANÇA: Cria a instância da classe correta baseada no número
  public void setPriceCode(int arg) {
      switch (arg) {
         case REGULAR:
            _price = new RegularPrice();
            break;
         case CHILDRENS:
            _price = new ChildrensPrice();
            break;
         case NEW_RELEASE:
            _price = new NewReleasePrice();
            break;
         default:
            throw new IllegalArgumentException("Incorrect Price Code");
      }
  }

  public String getTitle (){
      return _title;
  }
  
  // Mantemos este método aqui por enquanto, mas ele usa o getPriceCode() atualizado
  public double getCharge(int daysRented) {
      double result = 0;
      switch (getPriceCode()) {
         case Movie.REGULAR:
            result += 2;
            if (daysRented > 2)
               result += (daysRented - 2) * 1.5;
            break;
         case Movie.NEW_RELEASE:
            result += daysRented * 3;
            break;
         case Movie.CHILDRENS:
            result += 1.5;
            if (daysRented > 3)
               result += (daysRented - 3) * 1.5;
             break;
      }
      return result;
   }

  // Mantemos este método aqui por enquanto
  public int getFrequentRenterPoints(int daysRented) {
      if ((getPriceCode() == NEW_RELEASE) && daysRented > 1)
          return 2;
      else
          return 1;
  }
}