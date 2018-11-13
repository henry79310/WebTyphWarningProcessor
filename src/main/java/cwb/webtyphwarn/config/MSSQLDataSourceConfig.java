package cwb.webtyphwarn.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MSSQLDataSourceConfig {

	private HikariDataSource mssqlDataSource;
	
	@Value("${database.mssql.serverName}")
	private String serverName;
	@Value("${database.mssql.portNumber}")
	private String portNumber;
	@Value("${database.mssql.databaseName}")
	private String databaseName;
	@Value("${database.mssql.username}")
	private String username;
	@Value("${database.mssql.password}")
	private String password;
	
	@PostConstruct
	public void initialHikariCP() throws Exception{
		HikariConfig config = new HikariConfig();
		config.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
		config.addDataSourceProperty("serverName", serverName);
		config.addDataSourceProperty("portNumber", portNumber);
		config.addDataSourceProperty("databaseName", databaseName);
		config.addDataSourceProperty("user", username);
		config.addDataSourceProperty("password", password);
		//config.setJdbcUrl(jdbcUrl);
		//config.setUsername(username);
		//config.setPassword(password);
		
//			config.setMaximumPoolSize(maximumPoolSize);
		//		config.setMinimumIdle(minIdle);
		//		config.setAutoCommit(autoCommit);
		// In case we're using MySQL, these settings are recommended by HikariCP:
		//		config.addDataSourceProperty("useServerPrepStmts", useServerPrepStmts);
		//		config.addDataSourceProperty("cachePrepStmts", cachePrepStmts);
		//		config.addDataSourceProperty("prepStmtCacheSize", prepStmtCacheSize);
		//		config.addDataSourceProperty("prepStmtCacheSqlLimit", prepStmtCacheSqlLimit);
		mssqlDataSource = new HikariDataSource(config);
			
	}
	
	
	@PreDestroy
	public void cleanup(){
		mssqlDataSource.close();
	}
	
	@Bean(name = "jdbcTemplateMSSQL")
	public JdbcTemplate getJdbcTemplateMySQL(){
		return new JdbcTemplate(mssqlDataSource);
	}
}
