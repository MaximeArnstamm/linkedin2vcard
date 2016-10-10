package linkedin2vcard;

import java.io.IOException;

import linkedin2vcard.domain.Person;
import linkedin2vcard.email.EmailHunter;
import linkedin2vcard.linkedin.LinkedinScrapper;

public class Main {
	public static void main(String[] args) throws IOException {
		String linkedinUrl = getUrl(args);
		String apiKey = System.getenv("EMAIL_HUNTER_API_KEY");

		Person person = new LinkedinScrapper().getPerson(linkedinUrl);
		person.setEmail(new EmailHunter().getEmail(person, apiKey));
		// 5 create vcard
		// 6 write vcard
	}

	private static String getUrl(String[] args) {
		// TODO Auto-generated method stub
		return null;
	}
}
