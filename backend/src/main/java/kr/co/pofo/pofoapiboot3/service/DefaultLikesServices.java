package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Portfolio;
import kr.co.pofo.pofoapiboot3.repository.LikesRepository;

@Service
public class DefaultLikesServices implements LikesService{
    
    @Autowired
    private LikesRepository repository;

    @Override
    public List<Portfolio> getByUserId(int id) {
        return repository.findByUserId(id);
    }
}
