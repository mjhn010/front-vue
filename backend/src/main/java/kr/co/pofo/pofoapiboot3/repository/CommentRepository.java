package kr.co.pofo.pofoapiboot3.repository;

import kr.co.pofo.pofoapiboot3.entity.Comment;
import kr.co.pofo.pofoapiboot3.entity.CommentDto;
import kr.co.pofo.pofoapiboot3.entity.CommentView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository {
    List<Comment> findComments(Integer portfolioId);

    List<CommentView> findCommentViews(Integer portfolioId);

    void insert(CommentDto commentDto);

    void delete(Comment comment);
}