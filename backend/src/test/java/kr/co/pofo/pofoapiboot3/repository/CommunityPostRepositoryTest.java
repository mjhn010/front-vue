package kr.co.pofo.pofoapiboot3.repository;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@MybatisTest
class CommunityPostRepositoryTest {

	@Autowired
	private CommunityPostRepository repository;
	
	@Test
	void test() {
		System.out.println(repository.findAll());
	}

}
