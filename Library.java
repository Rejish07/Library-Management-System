import java.util.*;

class Library {

    private List<Book> booklist = new ArrayList<>();
    private List<User> userlist = new ArrayList<>();

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }
    
    public void addBook(String title, String releaseyear, String genre, String author) {
        booklist.add(new Book(title, releaseyear, genre, author));
    }

    public void borrowbook(User user, Book book) {
        if(book.isAvailable()) {
            user.borrowbook(book);
        }
        else {
            System.out.println("user : " + user.getName() + " can't borrow");
        }
    }

    public void remove(int id) {
        Book book = search(id);
        if(book != null) {
            booklist.remove(book);
        }
        else {
            System.out.println("There isn't book in this title");
        }
    }

    public Book search(int id) {
        for(Book b : booklist) {
            if(id == b.getBookId()) {
                return b;
            }
        }
        return null;
    }

    public void listOfBooks() {
        for(Book b : booklist) {
            System.out.println(b);
        }
    }

}
