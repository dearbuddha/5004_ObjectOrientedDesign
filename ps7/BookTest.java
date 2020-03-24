package ps7;

import java.util.Arrays;

public class BookTest {
    public static void main(String[] args) {
        Book[] books = new Book[10];

        for(int i = 0; i < books.length; i++){
            books[i] = new Book();
        }

        books[0].setName("The Gadfly");
        books[0].setQuote("Then am I a happy fly, if I live or if I die");
        books[0].setISBN("1986402878");

        books[1].setName("Principles");
        books[1].setQuote("Pain + Reflection = Progress");
        books[1].setISBN("1501124021");

        books[2].setName("The Art of War");
        books[2].setQuote("Whoever waits for the fight is full; whoever chases the fight is empty");
        books[2].setISBN("1599869772");

        books[3].setName("A Brief History of Time");
        books[3].setQuote("Only time will tell");
        books[3].setISBN("0553380168");

        books[4].setName("Le Mythe de Sisyphe");
        books[4].setQuote("Seeking what is true is not seeking what is desirable");
        books[4].setISBN("2070322882");

        books[5].setName("The Shawshank Redemption");
        books[5].setQuote("Get busy living or get busy dying");
        books[5].setISBN("0751514624");

        books[6].setName("The Lord of the Rings");
        books[6].setQuote("Not all those who wander are lost");
        books[6].setISBN("0345538374");

        books[7].setName("Brida");
        books[7].setQuote("Nothing in the world is ever completely wrong. Even a stopped clock is right twice a day");
        books[7].setISBN("0061578959");

        books[8].setName("The Little Prince");
        books[8].setQuote("It is only with the heart that one can see rightly; " +
                "what is essential is invisible to the eye");
        books[8].setISBN("0544656490");

        books[9].setName("Catcher in the Rye");
        books[9].setQuote("The mark of the immature man is that he wants to die nobly for a cause, " +
                "while the mark of the mature man is that he wants to live humbly for one");
        books[9].setISBN("0316769533");

        Arrays.sort(books);

        for(int i = 0; i < books.length; i++){
            System.out.println('\n'+books[i].getName() + ": " + books[i].quote());
        }
    }
}
