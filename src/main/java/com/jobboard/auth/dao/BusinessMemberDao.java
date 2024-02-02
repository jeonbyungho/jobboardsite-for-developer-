package com.jobboard.auth.dao;

import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jobboard.auth.dto.BusinessMemberDTO;
import com.jobboard.mybatis.MybatisSessionFactory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BusinessMemberDao implements MemberDao<BusinessMemberDTO>{
	private static BusinessMemberDao instance;
	
	public static BusinessMemberDao getInstance() {
		if(instance == null) {
			instance = new BusinessMemberDao();
		}
		return instance;
	}
	
	private final String NAMESPACE = "BusinessMemberMapper";
	private final SqlSessionFactory sqlSessionFactory = MybatisSessionFactory.getInstance();
	
	@Override
	public boolean signUp(BusinessMemberDTO businessMember) {
        SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.insert(NAMESPACE + ".signUp", businessMember);
			sqlSession.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			sqlSession.close();
		}
        return false;
    }
	
	@Override
	public Optional<BusinessMemberDTO> signIn(String username, String password) {
		Map<String, String> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			BusinessMemberDTO bizMember = sqlSession.selectOne(NAMESPACE + ".signIn", params);
			return Optional.ofNullable(bizMember);
		}
	}

	@Override
	public long checkDuplicateUsername(String username) {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			return sqlSession.selectOne(NAMESPACE + ".countByUsername", username);
		}
	}
	
}
