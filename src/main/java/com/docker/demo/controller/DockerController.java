package com.docker.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. 도커 이미지 만든다(도커 이미지 빌드) > docker build -t bootdocker:latest .
 * 2. 도커 컨테이너로 포트포워딩을 한다 > docker container run -d --name bootdocker -p 8082:8080 bootdocker:latest
 * 3. 애플리케이션에 접근한다. > http://localhost:8082/hello
 *      - 호스트의 8082 포트로 접근 , 내부적으로 컨테이너의 8080 포트로 연결됨
 */

@RestController
public class DockerController {

    @GetMapping("/hello")
    public String getMethodName() {
        return "hello!! ";
    }
}
