package linkedin2vcard;

import java.io.IOException;

public class MainTest {

	//@Test
	public void run() {
		try {
			Main.run("LINKEDIN URL", "API KEY");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
