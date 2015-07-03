package dei.uc.pt.ar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RolesTest {

	@Test
	public void testGetId() {
		// System.out.println("getId");
		Roles r = new Roles();
		int expected = 0;
		int result = r.getIdRoleUtilizador();
		assertEquals(expected, result);

	}
}
