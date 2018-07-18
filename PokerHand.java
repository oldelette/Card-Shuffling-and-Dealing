import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class PokerHand extends Hand {

	private static final int NUMBER_OF_CARDS = 5;
	
	private static final String[] faces =  { "Ace","Deuce","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King", "Ace" };

	private static final String[] suitRanking = {"Spades","Hearts","Clubs","Diamonds"};

	public PokerHand() {
		super(NUMBER_OF_CARDS);
	}

	public Card getHighCard() {
		
		Card highCard = null;
			
		for(int face_key = faces.length-1; face_key>=0; face_key--) {		
			
			if(highCard != null) break;
			
			for(Card card:myHand) {
			
				if(card.getFace() == faces[face_key]) {
					highCard = card;
				    break;
				}
			
			}
			
		}
		
		if(getFaceOccurence().get(highCard.getFace().toLowerCase())>1) {
			
			boolean highSuitFound = false;
			
			for(int suit_key = 0; suit_key<suitRanking.length; suit_key++) {
		
				if(highSuitFound) break;
				
				for(Card card:myHand) {
				
					if(highCard.getFace() == card.getFace()) {
						
						if(card.getSuit() == suitRanking[suit_key]) {
							highCard = card;
							highSuitFound = true; 
						    break;
						}
					}
				
				}
			}
			
		}
		return highCard;			
	}
	
	
	private ArrayList<String> getNOfAKind(int n) {
		
		ArrayList<String> nOfAKind = new ArrayList<String>();
		
		Set<String> faces = getFaceOccurence().keySet();

		for( String face: faces) {
			if(getFaceOccurence().get(face)==n)
				nOfAKind.add(face);
		}

		return nOfAKind;
	}
	
	public ArrayList<String> get2OfAKind() {
		return getNOfAKind(2);
	}

	public boolean hasPair() {
		return (get2OfAKind().size() == 1);
	}

	public boolean has2Pairs() {
		return (get2OfAKind().size() >= 2);
	}
	

	public ArrayList<String> get3OfAKind() {
		return getNOfAKind(3);
	}

	public boolean has3OfAKind() {
		return (get3OfAKind().size() >= 1);
	}

	public ArrayList<String> get4OfAKind() {
		return getNOfAKind(4);
	}
	
	public boolean has4OfAKind() {
		return (get4OfAKind().size() >= 1);
	}

	public boolean hasFlush() {
		return getDistinctSuits().size() == 1;
	}

	public boolean hasFullHouse() {
		return (get3OfAKind().size() == 1 && get2OfAKind().size() == 1);
	}

	public boolean hasStraight() {
		
		if(getFaceOccurence().size()==NUMBER_OF_CARDS) {

			for(int straight_start = 0;straight_start<10;straight_start++) {

				int straightcount = 0;

				for(int straight_face = 0;straight_face<5;straight_face++) {

					String face = faces[straight_start + straight_face].toLowerCase();

					if(!getFaceOccurence().keySet().contains(face))
						break;
					else
						straightcount++;
				}
				
				if(straightcount == 5){
				    return true;
				}
			}
		}
		return false;
	}
 

	public boolean hasRoyalFlush() {
		return (hasStraight() && hasFlush() && getFaceOccurence().keySet().contains("ace") && getFaceOccurence().keySet().contains("king"));
	}


	public boolean hasStraightFlush() {
		return (hasStraight() && hasFlush() && !hasRoyalFlush());
	}
}
