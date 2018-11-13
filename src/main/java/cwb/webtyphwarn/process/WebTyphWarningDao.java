package cwb.webtyphwarn.process;

import java.util.Set;

import cwb.webtyphwarn.model.WebTyphWarning;

public interface WebTyphWarningDao {
	public void insertWebTyphWarnings(Set<WebTyphWarning> webTyphWarnings);
	public void deleteWebTyphWarnings(Set<WebTyphWarning> webTyphWarnings);

}
