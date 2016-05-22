package com.goodjoon.guppy.engine.common.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import com.goodjoon.guppy.engine.common.Constants;

// TODO: JDBC 쪽의 NULL 값 처리도 해줘야 한다.
@MappedTypes(String[].class)
@MappedJdbcTypes(value=JdbcType.VARCHAR, includeNullJdbcType=true)
public class ArrayForVarcharTypeHandler implements TypeHandler<String[]> {
	@Override
	public void setParameter(PreparedStatement ps, int i, String[] parameter,
			JdbcType jdbcType) throws SQLException {
		String param = "";
		for (int nParamIndex = 0 ; nParamIndex < parameter.length ; nParamIndex++) {
			param += parameter[nParamIndex];
			if (nParamIndex+1 < parameter.length)
				 param += Constants.DB_FIELD_SEPERATOR;
		}
		
		ps.setString(i, param);
	}

	@Override
	public String[] getResult(ResultSet rs, String columnName)
			throws SQLException {
		String[] values = rs.getString(columnName).split(Constants.DB_FIELD_SEPERATOR);
		return values;
	}

	@Override
	public String[] getResult(ResultSet rs, int columnIndex)
			throws SQLException {
		String[] values = rs.getString(columnIndex).split(Constants.DB_FIELD_SEPERATOR);
		return values;
	}

	@Override
	public String[] getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		String[] values = cs.getString(columnIndex).split(Constants.DB_FIELD_SEPERATOR);
		return values;
	}
	
}
