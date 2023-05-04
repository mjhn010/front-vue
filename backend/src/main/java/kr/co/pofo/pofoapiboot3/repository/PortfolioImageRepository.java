package kr.co.pofo.pofoapiboot3.repository;

import kr.co.pofo.pofoapiboot3.entity.PortfolioImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PortfolioImageRepository {
    PortfolioImage findNameByMemberId(Integer memberId);
    List<PortfolioImage> findNamesByPortfolioId(Integer portfolioId);
}
