package linkedin2vcard.vcard;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ezvcard.VCard;
import linkedin2vcard.domain.Person;

public class VcardCreatorTest {

	@Test
	public void createVcard() throws Exception {
		// Given
		Person person = new Person();
		person.setFirstName("bob");
		person.setLastName("obo");
		person.setEmail("bob@obo.com");
		person.setTitle("ceo");
		person.setCompany("bob corp");
		person.setUrl("localhost");

		// When
		VCard actual = new VcardCreator().createVcard(person);

		// Then
		assertEquals(person.getFirstName(), actual.getStructuredName().getGiven());
		assertEquals(person.getLastName(), actual.getStructuredName().getFamily());
		assertEquals(1, actual.getEmails().size());
		assertEquals(person.getEmail(), actual.getEmails().get(0).getValue());
		assertEquals(1, actual.getTitles().size());
		assertEquals(person.getTitle(), actual.getTitles().get(0).getValue());
		assertEquals(person.getCompany(), actual.getOrganization().getValues().get(0));
		assertEquals(1, actual.getUrls().size());
		assertEquals(person.getUrl(), actual.getUrls().get(0).getValue());
	}

}
