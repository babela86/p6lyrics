package dei.uc.pt.ar;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class LyricDAO {

	@PersistenceContext(name = "Playlist")
	private EntityManager em;
	private Query q;

	@SuppressWarnings("unchecked")
	public List<Lyric> findLyricsByUser(int id) {

		q = em.createQuery("SELECT l FROM Lyric l WHERE l.utilizador.idUtilizador = :id");
		q.setParameter("id", id);
		return q.getResultList();
	}

	public boolean updateLyrics(String l, int idL) {
		try {
			q = em.createQuery("UPDATE Lyric SET lyric =:ly WHERE idLyric = :idL");

			q.setParameter("ly", l);
			q.setParameter("idL", idL);
			q.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
