package linkedin2vcard;

import java.io.IOException;

public class MainTest {

	//@Test
	public void run() {
		try {
			Main.run("https://www.linkedin.com/in/philippe-huriaux-04a15552", "c1a70e87cc4dc809e93e6fc90f3aca93ce401371");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
