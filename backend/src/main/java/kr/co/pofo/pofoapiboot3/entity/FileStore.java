package kr.co.pofo.pofoapiboot3.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class FileStore {
	
	@Autowired
	private HttpServletRequest request;

	//파일 이름을 포함하는 전체 경로 반환 메소드
	public String getFullPath(String filename) {
		String realPath = request.getServletContext().getRealPath("/image/") + filename;
		System.out.println("realPath:"+realPath);
		return realPath;
	}
	
	//
	public String storeFile(MultipartFile multipartFile) throws IOException {
		
		// 전달받은 값이 없으면 null 반환
		if(multipartFile.isEmpty())
			return "없음";
		
		//파일 이름을 가져오는 방법
		String originalFilename = multipartFile.getOriginalFilename();
		
		// 작성자가 업로드한 파일명 -> 서버 내부에서 관리하는 파일명
		// 파일명이 중복되지 않게끔 UUID로 정하고, ".확장자"는 그대로
		String storeFilename = UUID.randomUUID() + "."+ extractExt(originalFilename);
		
		//파일을 저장하는 부분 -> 파일경로 + storeFilename 에 저장
		System.out.println("내부");
		System.out.println(getFullPath(storeFilename));
		System.out.println(storeFilename);
		multipartFile.transferTo(new File(getFullPath(storeFilename)));
		
		return storeFilename;
	}
	
	//파일이 여러개 들어왔을때 처리해주는 부분
	//우리 컨셉에 맞게 사진의 순서도 처리해 줘여 하는 부분
	public List<String> storeFiles(List<MultipartFile> multipartFiles) throws IllegalStateException, IOException{
		if(multipartFiles.isEmpty())
			return null;
		// 여러개를 담을 그릇을 만든다
		List<String> storeFileResult = new ArrayList<>();
		//받아온 전체 파일들에 대한 유효성 검사 시행
		for(MultipartFile multipartFile : multipartFiles) {
			// 해당파일이 있다면 그릇에 추가
			if(!multipartFile.isEmpty()) {
				storeFileResult.add(storeFile(multipartFile));
			}
		}
		// 정보가 담긴 그릇을 반환
		System.out.println("image list" + storeFileResult);
		return storeFileResult;
	}
	
	//확장자 추출
	private String extractExt(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		return originalFilename.substring(pos+1);
	}
	
	
}
