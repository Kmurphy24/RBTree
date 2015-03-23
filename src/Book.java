
public class Book implements Comparable<Book> {
	
	private String isbn;
	private String title;
	private String author;
	private int year;
	private String publisher;
	
	public Book(){
		isbn = "";
		title = "";
		author = "";
		publisher = "";
	}
	
	public Book (String isbn, String title, String author, int year, String publisher){
		this.isbn = isbn;
		this.isbn.trim();
		this.title = title;
		this.title.trim();
		this.author = author;
		this.author.trim();
		this.year = year;
		this.publisher = publisher;
		this.publisher.trim();
	}
	
	public Book(Book aBook){
		this(aBook.isbn, aBook.title, aBook.author, aBook.year, aBook.publisher);
	}
	
	public String getIsbn(){
		return isbn;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public int getYear(){
		return year;
	}

	public String getPublisher(){
		return publisher;
	}
	
	public void setIsbn(String isbn){
		this.isbn = isbn;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public void setYear(int year){
		this.year = year;
	}

	public void setPublisher(String publisher){
		this.publisher = publisher;
	}
	
	public String toString() {
        String str = "";
        str += "ISBN: " + isbn + "\n";
        str += "Title: " + title + "\n";
        str += "Author: " + author + "\n";
        str += "Year Published: " + year + "\n";
        str += "Publisher: " + publisher;
        return str;
    }
	
	public boolean equals(Object obj) {
        if (this == obj) // are they the same object?
            return true;
        if (obj == null) // is the other one even an object?
            return false;
        if (!(obj instanceof Book)) // are they not both the same type?
            return false;
        Book other = (Book) obj; // now we know it's a Book
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (isbn != other.isbn)
            return false;
        if (publisher == null) {
            if (other.publisher != null)
                return false;
        } else if (!publisher.equals(other.publisher))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (year != other.year)
            return false;
        return true;
    }
	
	public int compareTo(Book arg0) {
        return isbn.compareTo(arg0.isbn);
    }
}