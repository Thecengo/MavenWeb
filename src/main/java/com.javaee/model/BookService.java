

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookService {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookStorePU");
	
	private EntityManager em = emf.createEntityManager();
	
	private EntityTransaction tx = em.getTransaction();
	
	public Book createBook(Long id, String title,String desc,Float unitCost,String isbn,Integer numOfPages) {
		
		Book book = new Book();
		
		book.setId(id);
		book.setTitle(title);
		book.setDescription(desc);
		book.setUnitCost(unitCost);
		book.setIsbn(isbn);
		book.setNbOfPages(numOfPages);

		tx.begin();
		em.persist(book);
		tx.commit();
		return book;
		
	}
	
	public Book raiseUnitCost(Long id, Float raise) {
		
		Book book = new Book();
		
		if(book != null) {
			
			tx.begin();
			book.setUnitCost(book.getUnitCost()+ raise);
			tx.commit();
		}
		
		return book;
	}
	
	public void removeBook(Long id) {
		Book book = new Book();
		
		if(book != null) {
			
			tx.begin();
			em.remove(book);
			tx.commit();
		}
	}
	
	public Book findBook(Long id) {
		return em.find(Book.class,id);
	}

}
