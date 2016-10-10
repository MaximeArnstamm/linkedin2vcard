package linkedin2vcard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import linkedin2vcard.domain.Person;
import linkedin2vcard.email.EmailHunter;
import linkedin2vcard.linkedin.LinkedinScrapper;
import linkedin2vcard.vcard.VcardCreator;

public class Main {
	public static void main(String[] args) throws IOException {
		String linkedinUrl = getUrl(args);
		String apiKey = System.getenv("EMAIL_HUNTER_API_KEY");

		run(linkedinUrl, apiKey);
	}

	protected static void run(String linkedinUrl, String apiKey) throws IOException {
		Person person = new LinkedinScrapper().getPerson(linkedinUrl);

		person.setEmail(new EmailHunter().getEmail(person, apiKey));

		VCard card = new VcardCreator().createVcard(person);

		File file = new File(person.getLastName() + "-card.vcf");
		Ezvcard.write(card).go(new FileWriter(file));

	}

	private static String getUrl(String[] args) {
		return args[0]; // TODO maybe more advanced command line. For now, just put the url
	}
}
