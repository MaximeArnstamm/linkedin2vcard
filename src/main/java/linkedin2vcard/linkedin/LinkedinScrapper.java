package linkedin2vcard.linkedin;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import linkedin2vcard.domain.Person;

public class LinkedinScrapper {
	public Person getPerson(String url) throws IOException {
		Person person = new Person(url);

		Document doc = Jsoup.connect(url).get();
		String fullName = doc.getElementById("name").text();
		String firstName = doc.select("#groups > .reg-upsell > ul > li > strong").first().text();
		person.setFirstName(firstName);
		person.setLastName(fullName.replace(firstName, "").trim());
		// doc.select("#profile > img").first().absUrl("src");
		Element title = doc.select("#experience > ul > li").first();
		person.setTitle(title.select(".item-title").first().text());
		person.setCompany(title.select(".item-subtitle").first().text());

		return person;
	}
}
