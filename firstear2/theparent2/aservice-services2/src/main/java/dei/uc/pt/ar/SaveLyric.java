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

	private String lyricString = null;

	private int idUser = 0;
	private int idMusic = 0;
	private int idLyric = 0;

	public String saveL(Lyric lyric) {
		String result = null;
		this.idUser = lyric.getUtilizador().getIdUtilizador();
		this.idMusic = lyric.getMusica().getIdMusic();
		this.lyricString = lyric.getLyric();

		List<Lyric> list = ld.findLyricsByUser(idUser);
		//for (int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i).getIdLyric());
		//}
			

		try {
			if (list.isEmpty()) {
				em.persist(lyric);
				log.info("A letra foi criada com sucesso na base de dados");
				result = "A letra foi criada na base de dados...";
				//System.out.println("entre1");
			} else {
				for (Lyric l : list) {
					if (l.getMusica().getIdMusic() == this.idMusic
							&& l.getUtilizador().getIdUtilizador() == this.idUser) {
						idLyric = l.getIdLyric();
						if (ld.updateLyrics(lyricString, idLyric)) {
							log.info("A letra foi actualizada com sucesso");
							result = "A letra foi actualizada...";
							//System.out.println("entre2");
						} else {
							log.info("Ocorreu um erro na actualização da letra");
							result = "A letra não foi actualizada...";
							//System.out.println("entre2");
						}
					}
				}
				if (result == null) {
					em.persist(lyric);
					log.info("A letra foi criada com sucesso na base de dados");
					result = "A letra foi criada na base de dados...";
					//System.out.println("entre3");
				}
			}
			// if (list.size() != 0) {
			// for (int i = 0; i < list.size(); i++) {
			// if (list.get(i).getUtilizador().getIdUtilizador() == idUser
			// && list.get(i).getMusica().getIdMusic() == idMusic) {
			// idLyric = list.get(i).getIdLyric();
			//
			// if (ld.updateLyrics(lyricString, idLyric)) {
			// log.info("A letra foi actualizada com sucesso");
			// result = "A letra foi actualizada...";
			//
			// } else {
			// log.info("Ocorreu um erro na actualização da letra");
			// result = "A letra não foi actualizada...";
			//
			// }
			// } else {
			// em.persist(l);
			// log.info("A letra foi criada com sucesso na base de dados");
			//
			// result = "A letra foi criada na base de dados...";
			// }
			// }
			// } else {
			// em.persist(l);
			// log.info("A letra foi criada com sucesso na base de dados");
			// result = "A letra foi criada na base de dados...";
			// }
		} catch (Exception e) {
			log.error("An error ocurred: " + e.getMessage());
			//System.out.println("entre4");
		}

		// System.out.println(result);
		return result;
	}

	public String getLyricString() {
		return lyricString;
	}

	public void setLyricString(String lyricString) {
		this.lyricString = lyricString;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdMusic() {
		return idMusic;
	}

	public void setIdMusic(int idMusic) {
		this.idMusic = idMusic;
	}

	public int getIdLyric() {
		return idLyric;
	}

	public void setIdLyric(int idLyric) {
		this.idLyric = idLyric;
	}

}
