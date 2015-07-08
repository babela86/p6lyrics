package dei.uc.pt.ar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class LyricTest {

	@Test
	public void testGetId() {
		// System.out.println("getId");
		Lyric l = new Lyric();
		int expected = 0;
		int result = l.getIdLyric();
		assertEquals(expected, result);
		//MatcherAssert.assertThat(result, is(expected));
	}
}
