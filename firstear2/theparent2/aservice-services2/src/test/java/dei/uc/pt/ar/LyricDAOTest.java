package dei.uc.pt.ar;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LyricDAOTest {
	private static final int ID_LYRIC = 0;
	private static final int ID_USER = 0;
	private static final int ID_MUSIC = 0;

	@Mock
	Query q;
	@Mock
	EntityManager em;
	@InjectMocks
	LyricDAO ld;

	@Test
	public void findLyricsByIDUserTest() {
		ArrayList<Lyric> l = new ArrayList<Lyric>();
		Utilizador u = new Utilizador();
		u.setIdUtilizador(ID_USER);

		when(
				em.createQuery("SELECT l FROM Lyric l WHERE l.utilizador.idUtilizador = :id"))
				.thenReturn(q);
		when(q.setParameter("id", ID_USER)).thenReturn(q);
		when(q.getResultList()).thenReturn(l);
		l = (ArrayList<Lyric>) ld.findLyricsByUser(ID_USER);
		verify(q).setParameter("id", ID_USER);

	}
}
