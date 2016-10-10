package linkedin2vcard.email;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

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
		String json = getJson(apiUrl);

		// fucking java, you can't have something clean and simple
		JsonObject data = Json.parse(json).asObject().get("data").asObject();

		if (data.get("score").asInt() < 65) {
			System.err.println("warning : score level < 65");
		}

		return data.get("email").asString();
	}

	private String getJson(String apiUrl) {
		String json = null;
		InputStream in = null;

		try {
			in = new URL(apiUrl).openStream();

			json = IOUtils.toString(in, Charset.defaultCharset());
		}
		catch (IOException e) {
			throw new RuntimeException("Failed : " + e.getMessage(), e);
		}
		finally {
			IOUtils.closeQuietly(in);
		}

		return json;
	}
}
