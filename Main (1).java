import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        DefaultBooks(lib);
        
        while(true) {
            System.out.println("1. AddAdminDetails\n2. Add Book to Library\n3. AddUser\n4. Show Library Books Detail\n5. details of user\n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 6) {
                break;
            }

            switch(choice) {
                case 1:
                    addAdmin(sc);
                    break;
                case 2:
                    addbooks(sc, lib);
                    break;
                case 3:
                    User user = addUser(sc, lib);
                    System.out.println("User fesilities : ");
                    System.out.println("1. Borrow Books\n2. Return Books");
                    int val = sc.nextInt();
                    if(val == 1) {
                        borrow(sc, lib, user);
                    }
                    if(val == 2) {
                        System.out.println("User " + user.getName() + "'s Available  Books");
                        List<Book> userBooks = user.getList();
                        for(Book b : userBooks) {
                            System.out.println(b);
                        }
                        System.out.println("Montion a book ID to return");
                        int id = sc.nextInt();
                        Book bookToReturn = user.searchBooks(id);
                        if(bookToReturn != null) {
                            returnBook(sc, lib, user, bookToReturn);
                        }
                    }
                    break;
                case 4:    
                    lib.listOfBooks();
                    break;
                case 5:
                    List<User> userlist = lib.getUserlist();
                     for(User us : userlist) {
                         us.getUserDetails();
                     }
                    break;
                default:
                    break;
            }
        }
    }

    public static User addUser(Scanner sc, Library lib) {
        
        System.out.println("Enter User Name:");
        String name = sc.nextLine();
        System.out.println("Enter User ID:");
        String userId = sc.nextLine();
        System.out.println("Enter User Contact Info:");
        String contactInfo = sc.nextLine();
        List<User> userList = lib.getUserlist();
        userList.add(new User(name, userId, contactInfo));
        return userList.get(userList.size() - 1);
        
    }

    public static void addbooks(Scanner sc, Library lib) {

        Admin admin = Admin.getInstance();
        while(true) {
            System.out.println("Enter AdminId and AdminPassword to Add New Books");
            String adminId = sc.nextLine();
            String adminPassword = sc.nextLine();
            
            if(admin.getAdminId().equals(adminId) && admin.getAdminPassword().equals(adminPassword)) {
                System.out.println("Enter a Book Title");
                String title = sc.nextLine();
                System.out.println("Enter a Book Release year");
                String releaseyear = sc.nextLine();
                System.out.println("Enter a Book Genre");
                String genre = sc.nextLine();
                System.out.println("Enter a Author Name");
                String author = sc.nextLine();
                System.out.println();
                lib.addBook(title, releaseyear, genre, author);
                System.out.println("Book added successfully.");
                break;
            }
            else {
                System.out.println("Invalid Admin Id and Password Enter Again");
            }
        }

    }

    public static void addAdmin(Scanner sc) {
        Admin admin = Admin.getInstance();
        System.out.println("Enter a Admin Name");
        String adminName = sc.nextLine();
        admin.setName(adminName);
        System.out.println("Enter a Admin ID");
        String adminId = sc.nextLine();
        admin.setAdminId(adminId);
        System.out.println("Enter a Admin Password");
        String adminPassword = sc.nextLine();
        admin.setAdminPassword(adminPassword);
        System.out.println("Enter a Admin Contacy info");
        String adminContactInfo = sc.nextLine();
        admin.setAdmincontactInfo(adminContactInfo);
    }

    public static void returnBook(Scanner sc, Library lib, User user, Book book) {
        book.setStatus("available");
        List<Book> userbooks = user.getList();
        userbooks.remove(book);
    }

    public static void borrow(Scanner sc, Library lib, User user) {
        lib.listOfBooks();
        System.out.println("choose a book id to borrow : ");
        int bookId = sc.nextInt();
        Book bookToBorrow = lib.search(bookId);
        if(bookToBorrow != null) {
            user.getList().add(bookToBorrow);
            bookToBorrow.setStatus("Issued");
            System.out.println("Book : " + bookToBorrow.getTitle() + " was added to the User " + user.getName());
        }
        else {
        System.out.println("you can't borrow the book");
        }        
    }
    public static void DefaultBooks(Library lib) {
        List<Book> bookslist = lib.getBooklist();
        bookslist.add(new Book("To Kill a Mockingbird", "1960", "Fiction", "Harper Lee"));
        bookslist.add(new Book("1984", "1949", "Dystopian", "George Orwell"));
        bookslist.add(new Book("The Great Gatsby", "1925", "Fiction", "F. Scott Fitzgerald"));
        bookslist.add(new Book("The Catcher in the Rye", "1951", "Fiction", "J.D. Salinger"));
        bookslist.add(new Book("Moby-Dick", "1851", "Adventure", "Herman Melville"));
        bookslist.add(new Book("Pride and Prejudice", "1813", "Romance", "Jane Austen"));
        bookslist.add(new Book("The Hobbit", "1937", "Fantasy", "J.R.R. Tolkien"));
        bookslist.add(new Book("Brave New World", "1932", "Dystopian", "Aldous Huxley"));
        bookslist.add(new Book("The Odyssey", "-800", "Epic", "Homer"));
        bookslist.add(new Book("Crime and Punishment", "1866", "Fiction", "Fyodor Dostoevsky"));
        bookslist.add(new Book("War and Peace", "1869", "Historical Fiction", "Leo Tolstoy"));
        bookslist.add(new Book("Frankenstein", "1818", "Horror", "Mary Shelley"));
        bookslist.add(new Book("Jane Eyre", "1847", "Fiction", "Charlotte Brontë"));
        bookslist.add(new Book("The Lord of the Rings", "1954", "Fantasy", "J.R.R. Tolkien"));
        bookslist.add(new Book("The Alchemist", "1988", "Adventure", "Paulo Coelho"));
        bookslist.add(new Book("The Divine Comedy", "1320", "Epic", "Dante Alighieri"));
        bookslist.add(new Book("Dracula", "1897", "Gothic", "Bram Stoker"));
        bookslist.add(new Book("The Iliad", "-750", "Epic", "Homer"));
        bookslist.add(new Book("The Brothers Karamazov", "1880", "Fiction", "Fyodor Dostoevsky"));
        bookslist.add(new Book("Harry Potter and the Philosopher's Stone", "1997", "Fantasy", "J.K. Rowling"));
        
    }

}
