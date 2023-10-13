package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE Library (
  id INT NOT NULL AUTO_INCREMENT,    
  title VARCHAR(30) NOT NULL,   
  rating VARCHAR(30) NOT NULL,    
  synop VARCHAR(255) NOT NULL,
  owned VARCHAR(30) NOT NULL,
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "Library")
public class tech_ex_lib {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "title")
   private String title;

   @Column(name = "rating")
   private String rating;
   
   @Column(name = "synop")
   private String synop;
   
   @Column(name = "owned")
   private String owned;

   public tech_ex_lib() {
   }

   public tech_ex_lib(Integer id, String title, String rating, String synop, String own) {
      this.id = id;
      this.title = title;
      this.rating = rating;
      this.synop = synop;
      this.owned = own;
   }

   public tech_ex_lib(String title, String rating, String synop, String own) {
	   this.title = title;
	   this.rating = rating;
	   this.synop = synop;
	   this.owned = own;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }
   
   public void setTitle(String name) {
      this.title = name;
   }
   
   public String getRating() {
	      return rating;
   }
   
   public void setRating(String rate) {
	      this.rating = rate;
   }

   public String getSynop() {
      return synop;
   }

   public void setSynop(String syn) {
      this.synop = syn;
   }

   public String getOwned() {
	   return owned;
   }

   public void setOwned(String owe) {
	   this.owned = owe;
   }
   
   @Override
   public String toString() {
      return "Employee: " + this.id + ", " + this.title + ", " + this.rating + this.synop + ", " + this.owned;
   }
}