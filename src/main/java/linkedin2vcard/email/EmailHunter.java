package linkedin2vcard.email;

import linkedin2vcard.domain.Person;

public class EmailHunter {
	protected static String apiUrl = "https://api.emailhunter.co/v2/email-finder?company=%s&first_name=%s&last_name=%s&api_key=%s";
	public String getEmail(Person person, String apiKey) {
		String apiUrl = buildApiUrl(person, apiKey);
		return parseEmail(apiUrl);
	}

	protected String buildApiUrl(Person person, String apiKey) {
		return String.format(apiUrl, person.getCompany(), person.getFirstName(), person.getLastName(), apiKey);
	}

	protected String parseEmail(String apiUrl) {
		return null;
	}
}
