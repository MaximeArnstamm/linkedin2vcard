package linkedin2vcard.email;

import org.junit.Assert;
import org.junit.Test;

import linkedin2vcard.domain.Person;

public class EmailHunterTest {
	private EmailHunter emailHunter = new EmailHunter();

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
		Assert.assertEquals("https://api.emailhunter.co/v2/email-finder?company=Gogol&first_name=Jean&last_name=Bon&api_key=apiKey", actual);
	}

}
