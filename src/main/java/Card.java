public class Card {
    private Suite suite;
    private Rank rank;

    public Card(Suite suite, Rank rank) {
        this.suite = suite;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " OF " + suite;
    }
}
