package kr.co.pofo.pofoapiboot3.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class FileUpload {

    public void upload(MultipartFile img, String modifiedName, HttpServletRequest request) {
        String urlPath = "/pofoThumbnail" + File.separator + modifiedName;
        String realPath = request.getServletContext().getRealPath(urlPath);
        try {
            img.transferTo(new File(realPath));
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
    }

    public String modifyImgName(String originalName) {
        int index = originalName.lastIndexOf(".");
        String extension = originalName.substring(index);
        String modifiedName = String.valueOf(UUID.randomUUID()) + extension;
        return modifiedName;
    }
}
