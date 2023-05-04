package kr.co.pofo.pofoapiboot3.repository;

import kr.co.pofo.pofoapiboot3.entity.PortfolioDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PortfolioDetailRepository {
    PortfolioDetail findPortfolioDetail(Integer id);
}