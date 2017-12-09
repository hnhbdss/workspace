package com.demo;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

public class Main {

	private static final Log log = LogFactory.getLog(Main.class);
	
	public static void main(String[] args) throws SQLException {
		log.info("main enter");
		SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient(
				Main.class.getClassLoader().getResourceAsStream("sqlmap/root.xml"));
		if (client  == null) {
			System.out.println("load sqlmap error");
		}
		queryNe(client);
		//updateDao(client);
		//dao(client);
	}
	
	private static void updateDao(SqlMapClient client) throws SQLException {
		RanNe ne = new RanNe();
		ne.setNeName("laomao");
		ne.setNeId(1);
		SqlMapClientImpl impl = (SqlMapClientImpl)client;
		SessionScope ss = new SessionScope();
		StatementScope sts = new StatementScope(ss);
		MappedStatement ms = impl.getMappedStatement("updateRanne");
		sts.setStatement(ms);
		System.out.println(ms.getSql().getSql(sts, ne));
		client.update("updateRanne", ne);
	}
	

	private static void dao(SqlMapClient client) throws SQLException {

		RanNe insNe = new RanNe();
		insNe.setNeId(3);
		insNe.setNeName("dushishuang3");
		client.insert("insertRanNe", insNe);
	}

	private static void queryNe(SqlMapClient client) throws SQLException {
		RanNe ne = new RanNe();
		ne.setNeName("lili");
		ne.setNeId(1);
		
		@SuppressWarnings("unchecked")
		List<RanNe> ranNes = (List<RanNe>)client.queryForList("ranne.selectRanne");
		for (RanNe ranNe : ranNes) {
			System.out.println("name:" + ranNe.getNeName() + ",id:" + ranNe.getNeId());
		}
	}
}
