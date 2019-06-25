package model;

public class Main {
	
  public static void main(String[] args) {
	
	  BookService bookService = new BookService();
	  
	  Book book = bookService.createBook(4004L,"h2g2","Scfi Book", 12.5f,"1234",738);
	  
	  System.out.println("Book persisted :"+book);
	  
	  book = bookService.findBook(404L);
	  
	  System.out.println("Book found: "+book);
	  
	  book = bookService.raiseUnitCost(404L,13.5f);
	  
	  System.out.println("Book updated : "+book);
	  
	  
}

}
