package cwb.webtyphwarn.process;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cwb.webtyphwarn.model.WebTyphWarning;

@Repository("webTyphWarningDaoMSSQLImpl")
public class WebTyphWarningDaoMSSQLImpl implements WebTyphWarningDao {

	private JdbcTemplate jdbcTemplate;
	
	private static final String DELETE_WEB_TYPH_WARNING_STATEMENT = 
			"DELETE FROM WebTyphWarning WHERE TyphName = ? AND AlarmDate = ? AND State = ?";
	
	private static final String INSERT_WEB_TYPH_WARNING_STATEMENT = 
			"INSERT INTO WebTyphWarning (TyphName, AlarmDate, State, ModifyDate) VALUES (?,?,?,?)";
	
	@Override
	public void insertWebTyphWarnings(Set<WebTyphWarning> webTyphWarnings) {
		// TODO Auto-generated method stub
		
		for(WebTyphWarning webTyphWarning:webTyphWarnings) {
			jdbcTemplate.update(INSERT_WEB_TYPH_WARNING_STATEMENT,
					webTyphWarning.getTyphName(),webTyphWarning.getAlarmDate(), 
					webTyphWarning.getState(),webTyphWarning.getModifyDate());
		}
	}
	
	@Override
	public void deleteWebTyphWarnings(Set<WebTyphWarning> webTyphWarnings) {
		// TODO Auto-generated method stub
		for(WebTyphWarning webTyphWarning:webTyphWarnings) {
			jdbcTemplate.update(DELETE_WEB_TYPH_WARNING_STATEMENT,
					webTyphWarning.getTyphName(),webTyphWarning.getAlarmDate(), 
					webTyphWarning.getState());
		}
	}
	
	@Autowired
	@Qualifier("jdbcTemplateMSSQL")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	
}
