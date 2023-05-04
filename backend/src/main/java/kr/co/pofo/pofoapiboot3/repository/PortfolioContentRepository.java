package kr.co.pofo.pofoapiboot3.repository;

import kr.co.pofo.pofoapiboot3.entity.PortfolioContents;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PortfolioContentRepository {
    List<PortfolioContents> selectByPortfolioId(Integer portfolioId);
}
