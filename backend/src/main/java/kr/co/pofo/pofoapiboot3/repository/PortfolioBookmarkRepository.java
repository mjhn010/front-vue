package kr.co.pofo.pofoapiboot3.repository;

import kr.co.pofo.pofoapiboot3.entity.BookmarkDto;
import kr.co.pofo.pofoapiboot3.entity.PortfolioBookmark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PortfolioBookmarkRepository {
    List<PortfolioBookmark> selectByPortfolioId(Integer portfolioId);
    void insert(BookmarkDto bookmarkDto);
    void delete(BookmarkDto bookmarkDto);
}
