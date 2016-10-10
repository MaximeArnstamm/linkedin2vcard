package linkedin2vcard.email;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import linkedin2vcard.domain.Person;

public class EmailHunterTest {
	private EmailHunter emailHunter = new EmailHunter();
	private static final String apiTestUrl = "https://raw.githubusercontent.com/MaximeArnstamm/linkedin2vcard/master/src/test/resources/emailHunterJson.json";

	@Test
	public void buildApiUrl() {
		// Given
		Person person = new Person();
		person.setCompany("Gogol");
		person.setFirstName("Jean");
		person.setLastName("Bon");

		String apiKey = "apiKey";

		// When
		String actual = emailHunter.buildApiUrl(person, apiKey);

		// Then
		assertEquals("https://api.emailhunter.co/v2/email-finder?company=Gogol&first_name=Jean&last_name=Bon&api_key=apiKey", actual);
	}

	@Test
	public void parseEmail() throws Exception {
		// Given

		// When
		String actual = emailHunter.parseEmail(apiTestUrl);

		// Then
		assertEquals("dustin@asana.com", actual);
	}

}
