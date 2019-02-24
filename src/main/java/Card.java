import java.util.Comparator;

public class Card {
    private Suite suite;
    private Rank rank;

    public Suite getSuite() {
        return suite;
    }

    public Rank getRank() {
        return rank;
    }

    public Card(Suite suite, Rank rank) {
        this.suite = suite;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " OF " + suite;
    }

    public static Comparator<Card> rankComparator = new Comparator<Card>() {
        public int compare(Card o1, Card o2) {
            return o2.getRank().ordinal() - o1.getRank().ordinal();
        }
    };
}
