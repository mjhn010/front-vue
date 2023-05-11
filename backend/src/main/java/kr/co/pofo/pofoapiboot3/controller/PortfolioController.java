package kr.co.pofo.pofoapiboot3.controller;

import kr.co.pofo.pofoapiboot3.entity.Comment;
import kr.co.pofo.pofoapiboot3.entity.CommentView;
import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.entity.PortfolioContents;
import kr.co.pofo.pofoapiboot3.service.CommentService;
import kr.co.pofo.pofoapiboot3.service.PortfolioContentsService;
import kr.co.pofo.pofoapiboot3.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/pofo")
public class PortfolioController {
    private final PortfolioService portfolioService;
    private final PortfolioContentsService portfolioContentsService;
    private final CommentService commentService;

    public PortfolioController(PortfolioService portfolioService, PortfolioContentsService portfolioContentsService, CommentService commentService) {
        this.portfolioService = portfolioService;
        this.portfolioContentsService = portfolioContentsService;
        this.commentService = commentService;
    }

    @GetMapping("{portfolioId}")
    public Map<String, Object> getPortfolioDetail(@PathVariable("portfolioId") Integer portfolioId) {
        Portfolio portfolio = portfolioService.getPortfolioById(portfolioId);
        List<PortfolioContents> contents = portfolioContentsService.getPortfolioContents(portfolioId);
        List<CommentView> comments = commentService.getCommentViews(portfolioId);

        Map<String, Object> objectMap = new LinkedHashMap<>();

        objectMap.put("portfolio", portfolio);
        objectMap.put("contents", contents);
        objectMap.put("comments", comments);

        return objectMap;
    }
}
