import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    public Poker(){};

    public boolean isFlush(ArrayList<Card> checkingPile){
        int heartsCount = 0;
        int diamondsCount = 0;
        int spadesCount = 0;
        int clubsCount = 0;
        for(Card iterrator : checkingPile){
            switch(iterrator.getSuite()){
                case CLUBS:
                    clubsCount++;
                    break;
                case HEARTS:
                    heartsCount++;
                    break;
                case SPADES:
                    spadesCount++;
                    break;
                case DIAMONDS:
                    diamondsCount++;
                    break;
            }
        }
        return (clubsCount == 5 || spadesCount == 5 || diamondsCount == 5 || heartsCount == 5);

    }

    public boolean isPair(ArrayList<Card> checkingPile){
        Collections.sort(checkingPile, Card.rankComparator);
        for (int i = 0; i < checkingPile.size() - 1; i++){
            for (int j = i + 1; j < checkingPile.size(); j++){
                if(checkingPile.get(i).getRank() == checkingPile.get(j).getRank()){
                    return true;
                }
            }
        }
        return false;
    }

    private ArrayList<Card> removePair(ArrayList<Card> checkingPile){
        Collections.sort(checkingPile, Card.rankComparator);
        for (int i = 0; i < checkingPile.size() - 1; i++){
            for (int j = i + 1; j < checkingPile.size(); j++){
                if(checkingPile.get(i).getRank() == checkingPile.get(j).getRank()){
                    checkingPile.remove(i);
                    checkingPile.remove(j);
                    return checkingPile;
                }
            }
        }
        return checkingPile;
    }

    public boolean isTwoPair(ArrayList<Card> checkingPile){
        if(isPair(checkingPile)){
                return (isPair(removePair(checkingPile)));
        }
        return  false;
    }

    public boolean isFourOfKind(ArrayList<Card> checkingPile){
        Collections.sort(checkingPile, Card.rankComparator);
        boolean fourAndThree = checkingPile.get(0).getRank() == checkingPile.get(1).getRank() &&
                checkingPile.get(1).getRank() == checkingPile.get(2).getRank() &&
                checkingPile.get(2).getRank() == checkingPile.get(3).getRank();
        boolean threeAndFour = checkingPile.get(3).getRank() == checkingPile.get(4).getRank() &&
                checkingPile.get(4).getRank() == checkingPile.get(5).getRank() &&
                checkingPile.get(5).getRank() == checkingPile.get(6).getRank();
        boolean oneAndFourAndTwo = checkingPile.get(1).getRank() == checkingPile.get(2).getRank() &&
                checkingPile.get(2).getRank() == checkingPile.get(3).getRank() &&
                checkingPile.get(3).getRank() == checkingPile.get(4).getRank();
        boolean twoAndFourAndOne = checkingPile.get(2).getRank() == checkingPile.get(3).getRank() &&
                checkingPile.get(3).getRank() == checkingPile.get(4).getRank() &&
                checkingPile.get(4).getRank() == checkingPile.get(5).getRank();
        return (fourAndThree || threeAndFour || oneAndFourAndTwo || twoAndFourAndOne);
    }

    public boolean isThreeOfKind(ArrayList<Card> checkingPile){
        Collections.sort(checkingPile, Card.rankComparator);
        boolean threeAndFour = checkingPile.get(0).getRank() == checkingPile.get(1).getRank() &&
                checkingPile.get(1).getRank() == checkingPile.get(2).getRank();
        boolean oneAndThreeAndThree = checkingPile.get(1).getRank() == checkingPile.get(2).getRank() &&
                checkingPile.get(2).getRank() == checkingPile.get(3).getRank();
        boolean twoAndThreeAndTwo = checkingPile.get(2).getRank() == checkingPile.get(3).getRank() &&
                checkingPile.get(3).getRank() == checkingPile.get(4).getRank();
        boolean threeAndThreeAndOne = checkingPile.get(3).getRank() == checkingPile.get(4).getRank() &&
                checkingPile.get(4).getRank() == checkingPile.get(5).getRank();
        boolean fourAndThree = checkingPile.get(4).getRank() == checkingPile.get(5).getRank() &&
                checkingPile.get(5).getRank() == checkingPile.get(6).getRank();
        return (threeAndFour || oneAndThreeAndThree || twoAndThreeAndTwo || threeAndThreeAndOne || fourAndThree);
    }




}
