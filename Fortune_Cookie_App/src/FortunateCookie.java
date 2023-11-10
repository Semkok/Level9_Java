import java.util.Random;

public class FortunateCookie {
	
	FortunateCookie(){
		System.out.println(randomQuotes());
	}
	
	private String randomQuotes() {
		Random random = new Random();
		
		String quoteList[] = {
				"Goodness is the only investment that never fails.",
				"Respect yourself and others will respect you.",
				"You will receive money from an unexpected source.",
				"Stay healthy. Walk a mile.",
				"Happy News is on its way.",
				"The only way to have a friend is to be one.",
				"Nothing great was ever achieved without enthusiasm.",
				"Dance as if no one is watching.",
				"Live this day as if it were your last.",
				"Your life will be happy and peaceful."};

		return quoteList[random.nextInt(quoteList.length)];
	}
	
}
