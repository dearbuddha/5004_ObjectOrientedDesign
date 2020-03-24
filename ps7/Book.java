package ps7;

/*
Wenhan Cai
ps7
 */
public class Book implements Comparable, Quotable {

    public Book(String title, String name, String ISBN, int pages, Date date) {
        this.title = title;
        this.name = name;
        this.ISBN = ISBN;
        this.pages = pages;
        this.date = date;
    }

    public Book(){
        this.title = "";
        this.name = "";
        this.ISBN = "";
        this.pages = 0;
        this.date = new Date();
    }

    public Book(Book other){
        this(other.title, other.name, other.ISBN, other.pages, other.date);
    }

    private String title;
    private String name;
    private String ISBN;
    private int pages;
    private Date date;
    private String quote;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null){
            throw new IllegalArgumentException("title can't be null");
        }
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("name can't be null");
        }
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean setISBN(String ISBN) {
        if ( ISBN == null )
        {
            throw new IllegalArgumentException("ISBN can't be null");
        }

        ISBN = ISBN.replaceAll( "-", "" );

        if ( ISBN.length() != 10 )
        {
            throw new IllegalArgumentException("Invalid ISBN");
        }

        try
        {
            int total = 0;
            for ( int i = 0; i < 9; i++ )
            {
                int digit = Integer.parseInt( ISBN.substring( i, i + 1 ) );
                total += ((10 - i) * digit);
            }

            String checksum = Integer.toString( (11 - (total % 11)) % 11 );
            if ( "10".equals( checksum ) )
            {
                checksum = "X";
            }

            return checksum.equals(ISBN.substring( 9 ) );
        }
        catch ( NumberFormatException nfe )
        {
            return false;
        }
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if(pages <=0){
            throw new IllegalArgumentException("Illegal page");
        }
        this.pages = pages;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if(date == null){
            throw new IllegalArgumentException("date can't be null");
        }
        this.date = date;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", ISBN=" + ISBN +
                ", pages=" + pages +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book)) return false;
        if (o == null) return false;
        if (this == o) return true;
        Book book = (Book) o;
        return getISBN() == book.getISBN() &&
                getPages() == book.getPages() &&
                getTitle().equals(book.getTitle()) &&
                getName().equals(book.getName()) &&
                getDate().equals(book.getDate());
    }

    @Override
    public int compareTo(Object o) {
        if(o == null) throw new NullPointerException();
        if(!(o instanceof Book)) throw new ClassCastException();
        Book book = (Book) o;
        String isbn1 = this.getISBN().replaceAll("-","");
        String isbn2 = book.getISBN().replaceAll("-","");
        return isbn1.compareTo(isbn2);
    }

    @Override
    public String quote() {
        return this.getQuote();
    }
}


interface Quotable{
    String quote();
}

class Date {

    public Date(int month, int day, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public Date() {
        new Date(1, 1, 1900);
    }

    public Date(Date other) {
        this(other.month, other.day, other.year);
    }

    private int year;
    private int month;
    private int day;

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day");
        }
        this.day = day;
    }

    public boolean isEqual(Date other) {
        return this.year == other.year && this.month == other.month && this.day == other.day;
    }
}
