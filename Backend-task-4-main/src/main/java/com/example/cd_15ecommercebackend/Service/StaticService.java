package com.example.cd_15ecommercebackend.Service;


import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class StaticService {

    public ResponseEntity<?> sendImage(String fileName){
        try {
            String filePath = "src/main/resources/static/"+fileName;
            byte[] imageBytes = ImagePathToByteArray(filePath);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private byte[] ImagePathToByteArray(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        return IOUtils.toByteArray(fileInputStream);
    }
}


