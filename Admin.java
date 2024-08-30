import java.util.List;
import java.util.ArrayList;

class Admin {
    
    Library lib = new Library();
    private String name;
    private String admincontactInfo;
    private String adminId;
    private String adminPassword;
    
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    private static Admin instance;

    public static Admin getInstance() {
        if(instance == null) {
            instance = new Admin();
        }
        return instance;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdmincontactInfo() {
        return admincontactInfo;
    }

    public void setAdmincontactInfo(String admincontactInfo) {
        this.admincontactInfo = admincontactInfo;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public void addBook(Book book) {
        List<Book> booklist = lib.getBooklist();
        booklist.add(book);
    }

    public void removeBook(Book book) {
        int f = 0;
        List<Book> booklist = lib.getBooklist();
        for(Book b : booklist) {
            if(b.isAvailable()) {
                booklist.remove(b);
                f = 1;
            }
        }
        if(f == 1) {
            System.out.println("Book removed succesfully");
        }
        else {
            System.out.println("Can't remove book");
        }
        
    }
    
}