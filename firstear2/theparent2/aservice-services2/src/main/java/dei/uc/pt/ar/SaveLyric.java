package dei.uc.pt.ar;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@LocalBean
public class SaveLyric {

	@Inject
	private LyricDAO ld;

	private static final Logger log = LoggerFactory
			.getLogger(UserRegister.class);

	@PersistenceContext(name = "Playlist")
	private EntityManager em;

	private String lyricString;

	private int idUser;
	private int idMusic;
	private int idLyric;

	public String saveL(Lyric l) {
		String result = null;
		this.idUser = l.getUtilizador().getIdUtilizador();
		this.idMusic = l.getMusica().getIdMusic();
		this.lyricString = l.getLyric();

		List<Lyric> list = ld.findLyricsByUser(idUser);

		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getUtilizador().getIdUtilizador() == idUser
						&& list.get(i).getMusica().getIdMusic() == idMusic) {
					idLyric = list.get(i).getIdLyric();

					if (ld.updateLyrics(lyricString, idLyric)) {
						log.info("A letra foi actualizada com sucesso");
						result = "A letra foi actualizada...";

					} else {
						log.info("Ocorreu um erro na actualização da letra");

						result = "A letra não foi actualizada...";

					}
				} else {
					em.persist(l);
					log.info("A letra foi criada com sucesso na base de dados");

					result = "A letra foi criada na base de dados...";
				}
			}
		} else {
			em.persist(l);
			log.info("A letra foi criada com sucesso na base de dados");
			result = "A letra foi criada na base de dados...";
		}
		// System.out.println(result);
		return result;
	}
}
