package linkedin2vcard.vcard;

import ezvcard.VCard;
import ezvcard.parameter.EmailType;
import ezvcard.property.StructuredName;
import linkedin2vcard.domain.Person;

public class VcardCreator {
	public VCard createVcard(Person person) {
		VCard card = new VCard();
		StructuredName n = new StructuredName();
		n.setFamily(person.getLastName());
		n.setGiven(person.getFirstName());
		card.setStructuredName(n);
		card.addTitle(person.getTitle());
		card.setOrganization(person.getCompany());
		card.addEmail(person.getEmail(), EmailType.WORK);
		card.addUrl(person.getUrl());
		return card;
	}
}
