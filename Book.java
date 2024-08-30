class Book {

    private String title;
    private String releaseyear;
    private String genre;
    private String status;
    private int id;
    private String author;
    
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    
    private static int idCounter = 1;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    Book(String title, String releaseyear, String genre, String author) {
        this.id = idCounter++;
        this.title = title;
        this.releaseyear = releaseyear;
        this.genre = genre;
        this.author = author;
        this.status = "Available";
    }
    
    public boolean isAvailable() {
        return status.equalsIgnoreCase("Available");
    }
    
    public int getBookId() {
        return this.id;
    }
    
    public String toString() {
        return "[Book ID : " + this.id + ", Title : " + this.title + ", AuthorName" + this.author + ", publishyear : " + this.releaseyear + ", Genre : " + this.genre + ", Status : " + this.status + "]"; 
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(String releaseyear) {
        this.releaseyear = releaseyear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
