import java.util.*;

class User {
    private String name;
    private String userid;
    private String contactinfo;
    private List<Book> list = new ArrayList<>();

    User(String name, String userId, String contacyinfo) {
        this.name = name;
        this.userid = userId;
        this.contactinfo = contacyinfo;
    }
    
    public Book searchBooks(int id) {
        
        for(Book b : list) {
            if(b.getBookId() == id) {
                return b;
            }
        }
        return null;
    }
    
    public List<Book> getList() {
        return list;
    }
    
    public void setList(List<Book> list) {
        this.list = list;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getContactinfo() {
        return contactinfo;
    }
    
    public void setUserContanctinfo(String contactinfo) {
        this.contactinfo = contactinfo;
    }
    
    public String getUserid() {
        return userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void borrowbook(Book book) {
        if(book.isAvailable()) {
            list.add(book);
            book.setStatus("issued");
        }
    }

    public void returnBook(Book book) {
        list.remove(book);
        book.setStatus("Available");
    }
    
    public void getborrowedbooklist() {
        for(Book b : list) {
            System.out.print(b + ", ");
        }
        System.out.println();
    }

    public void getUserDetails() {
        System.out.print("userName : " + this.name + " userid : " + this.userid + " contactinfo : " + this.contactinfo);
        getborrowedbooklist();
        
    }
    
}
