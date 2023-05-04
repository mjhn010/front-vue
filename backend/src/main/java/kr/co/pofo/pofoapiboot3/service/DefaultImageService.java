package kr.co.pofo.pofoapiboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pofo.pofoapiboot3.entity.Image;
import kr.co.pofo.pofoapiboot3.repository.ImageRepository;

@Service
public class DefaultImageService implements ImageService {

	@Autowired
	private ImageRepository reposiroty;
	
	
	@Override
	public int add(Image img) {
		int portfolioId = img.getPortfolioId();
		List<String> imageNames = img.getNames();
		
		if(imageNames.isEmpty())
			return 0;
		
		int nums = imageNames.size();
		for(int i = 0; i<nums;i++) {
			String imageName = imageNames.get(i);
			reposiroty.insert(portfolioId, imageName, i);
		}
		
		
		return 1;
	}

}
