import java.util.Stack;

public class Deck extends Stack {

    public Deck(){
        for(int i = 0; i < Suite.values().length; i++){
            for(int j = 0; j < Rank.values().length; j++){
                push(new Card(Suite.values()[i], Rank.values()[j]));
            }
        }
    }

    private void shuffle(){

    }
}
