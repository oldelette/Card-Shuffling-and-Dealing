import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Hand {

	protected Card[] myHand;
	private int handCount;
	protected HashMap<String, Integer> faceOccurence; 
	
	public Hand( int numCards) {
		handCount = numCards;
        myHand = new Card[handCount];
	}

	protected HashMap<String, Integer> getFaceOccurence() {
		if(faceOccurence == null)
			findFaceOccurences();
		
		return faceOccurence;
	}

	public Card[] dealPlayer(DeckOfCards deck) {
		
		for( int i = 0; i < handCount; i++ ) {			
			myHand[i] = deck.dealCard(); 
		}
		
		findFaceOccurences();
		
		return myHand;
	}

	public void setHand(Card[] cards) {
		myHand = cards;
	}

	protected Set<String> getDistinctSuits() {
		
		Set<String> suits = new TreeSet<String>();
		
		for(int i = 0; i < handCount; i++) {
            
			Card card = myHand[i];

			if(!suits.contains(card.getSuit()))
                suits.add(card.getSuit());     
        }

		return suits;
	}

	protected void findFaceOccurences() {
	
		faceOccurence = new HashMap<String, Integer>();
		
		for(int i = 0; i < handCount; i++) {

			Card card = myHand[i];
			String face = card.getFace().toLowerCase();
			
			if(faceOccurence.containsKey(face)) {
				int count = faceOccurence.get(face);
				faceOccurence.put(face, count+1);
			}
			else {		
				faceOccurence.put(face,1);
			}
			
        }
	}
	

	public void displayFaceOccurences() {
		
		for( String face: getFaceOccurence().keySet()) {
			    System.out.printf("%-10s%10s\n",face, getFaceOccurence().get(face));
		}	
		 
	}


	public String toString() {
		String output = "";
		
		for(Card card:myHand)
			System.out.println(card);
		
		return output;
	}
}
