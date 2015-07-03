package lyricsSearch;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LyricsResult")
public class GetLyricsWikia {

	@XmlElement(name = "lyrics")
	private String lyricMusic;

	public String getLyric() {
		return lyricMusic;
	}

	public void setLyric(String lyric) {
		this.lyricMusic = lyric;
	}

}
