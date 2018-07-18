public class mytest {

	public static void main( String[] args ) {

		//Instantiate a poker hand to deal
		PokerHand hand = new PokerHand();		
		
		findStraight(hand);
		
		findFlush(hand);
		
		findFullHouse(hand);
		
		findPair(hand);

		find2Pairs(hand);
		
		find3OfAKind(hand);
		
		find4OfAKind(hand);

	}


	public static DeckOfCards newDeal() {
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		return myDeckOfCards;
	}

	public static void findStraight(PokerHand hand) {
		
		 do {
            DeckOfCards deck = newDeal();
            hand.dealPlayer(deck);
		    if(hand.hasStraight()) {
	    	    System.out.printf("%s----------\nIts a Straight!\n\n",hand);
		    }
		    
		}while(!hand.hasStraight());
	}

	public static void findFlush(PokerHand hand) {
		
		 do {
	        DeckOfCards deck = newDeal();
	        hand.dealPlayer(deck);
		    
		    if(hand.hasFlush()) {
	    	    System.out.printf("%s----------\nIts a Flush!\n\n",hand);
		    }
		    
		}while(!hand.hasFlush());
	}

	public static void findFullHouse(PokerHand hand) {
		
		 do {
		    DeckOfCards deck = newDeal();
		    hand.dealPlayer(deck);
		    
		    if(hand.hasFullHouse()) {
	    	    System.out.printf("%s----------\nIts a Full House!\n\n",hand);
		    }
		    
		}while(!hand.hasFullHouse());
	}

	public static void findPair(PokerHand hand) {
		
		 do {
			DeckOfCards deck = newDeal();
			hand.dealPlayer(deck);
		    
		    if(hand.hasPair()) {
	    	    System.out.printf("%s----------\nIts a Pair!\n\n",hand);
		    }
		    
		}while(!hand.hasPair());
	}


	public static void find2Pairs(PokerHand hand) {
		
		 do {
			DeckOfCards deck = newDeal();
			hand.dealPlayer(deck);
		    
		    if(hand.has2Pairs()) {
	    	    System.out.printf("%s----------\nIts 2 pairs!\n\n",hand);
		    }
		    
		}while(!hand.has2Pairs());
	}
	
	public static void find3OfAKind(PokerHand hand) {
		
		 do {
			DeckOfCards deck = newDeal();
			hand.dealPlayer(deck);
		    
		    if(hand.has3OfAKind()) {
	    	    System.out.printf("%s----------\nIts a 3 of a kind!\n\n",hand);
		    }
		    
		}while(!hand.has3OfAKind());
	}

	public static void find4OfAKind(PokerHand hand) {
		
		 do {
			DeckOfCards deck = newDeal();
			hand.dealPlayer(deck);
		    
		    if(hand.has4OfAKind()) {
	    	    System.out.printf("%s----------\nIts a 4 of a kind!\n\n",hand);
		    }
		}while(!hand.has4OfAKind());
	}
}
