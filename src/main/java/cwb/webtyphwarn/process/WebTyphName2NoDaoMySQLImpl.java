package cwb.webtyphwarn.process;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cwb.webtyphwarn.model.WebTyphName2No;


@Repository("webTyphName2NoDaoMySQLImpl")
public class WebTyphName2NoDaoMySQLImpl implements WebTyphName2NoDao{
	
	private JdbcTemplate jdbcTemplate;
	
	private static final String INSERT_WEB_TYPH_NAME_2_NO_STATEMENT = 
			"REPLACE INTO WebTyphName2No (TyphNo, TyphNameEng, TyphNameCht) " +
		    "VALUES (?, ?, ?) ";
	
	@Override
	public void insertWebTyphName2Nos(Set<WebTyphName2No> webTyphName2Nos) {
		// TODO Auto-generated method stub
		for(WebTyphName2No webTyphName2No:webTyphName2Nos) {
			jdbcTemplate.update(INSERT_WEB_TYPH_NAME_2_NO_STATEMENT,
					webTyphName2No.getTyphNo(),webTyphName2No.getTyphNameEng(), 
					webTyphName2No.getTyphNameCht());
		}
	}

	
	@Autowired
	@Qualifier(value="jdbcTemplateMySQL")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public void deleteWebTyphName2Nos(Set<WebTyphName2No> webTyphName2Nos) {
		// TODO Auto-generated method stub
		
	}
	
}
