package kr.co.pofo.pofoapiboot3.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageRepository {

	void insert(int portfolioId, String imageName, int orders);

}
