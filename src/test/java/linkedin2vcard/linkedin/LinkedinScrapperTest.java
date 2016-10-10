package linkedin2vcard.linkedin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.Test;

import linkedin2vcard.domain.Person;

public class LinkedinScrapperTest {

	@Test
	public void getPerson() throws IOException {
		// Given
		String url = "https://raw.githubusercontent.com/MaximeArnstamm/linkedin2vcard/master/src/test/resources/linkedin.html";

		// When
		Person actual = new LinkedinScrapper().getPerson(url);

		// Then
		assertEquals("Maxime", actual.getFirstName());
		assertEquals("ARNSTAMM", actual.getLastName());
		assertEquals("Indépendant", actual.getCompany());
		assertEquals("Indépendant", actual.getTitle());
		assertEquals(url, actual.getUrl());
		assertNull(actual.getEmail());
	}

}
