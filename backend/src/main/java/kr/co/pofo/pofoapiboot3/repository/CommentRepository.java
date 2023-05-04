package kr.co.pofo.pofoapiboot3.repository;

import kr.co.pofo.pofoapiboot3.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository {
    List<Comment> findPortfolioComments(Integer portfolioId);

    void save(Comment comment);

    void deleteById(Integer id);
}