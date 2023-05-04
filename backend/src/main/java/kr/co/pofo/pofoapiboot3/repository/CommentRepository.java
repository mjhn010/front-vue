package kr.co.pofo.pofoapiboot3.repository;

import kr.co.pofo.pofoapiboot3.entity.Comment;
import kr.co.pofo.pofoapiboot3.entity.PortfolioComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository {
    List<PortfolioComment> findPortfolioComments(Integer portfolioId);

    void save(Comment comment);

    void delete(Integer id);
}