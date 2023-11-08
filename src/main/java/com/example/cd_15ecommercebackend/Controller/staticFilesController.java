package com.example.cd_15ecommercebackend.Controller;


import com.example.cd_15ecommercebackend.Service.StaticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/static")
@RequiredArgsConstructor
public class staticFilesController {


    private final StaticService staticService;

    @GetMapping("/{imageSrc}")
    public ResponseEntity<?> getImage(@PathVariable String imageSrc){
        return staticService.sendImage(imageSrc);
    }
}
