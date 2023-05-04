package kr.co.pofo.pofoapiboot3.controller;

import kr.co.pofo.pofoapiboot3.service.CommentService;
import kr.co.pofo.pofoapiboot3.service.PortfolioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pofo")
public class PortfolioController {
    private final PortfolioService portfolioService;
    private final CommentService commentService;

    public PortfolioController(PortfolioService portfolioService, CommentService commentService) {
        this.portfolioService = portfolioService;
        this.commentService = commentService;
    }
}
