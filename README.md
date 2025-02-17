```java

도커 이미지 : 컴파일러된 파일까지 만든다.
도커 컨테이너 : 컨테이너에서 이미지를 만들면 그 이미지를 실행하는 명령어 

RUN은 이미지를 빌드할 때 실행됩니다
CMD는 컨테이너가 시작될 때 실행됩니다
COPY는 빌드 과정에서 파일을 복사하는 용도로만 사용됩니다
FROM은 항상 Dockerfile의 첫 번째 명령어여야 합니다

DockerFile 생성
FROM alpine

COPY ./hithere.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/hithere.sh

CMD ["/usr/local/bin/hithere.sh"]

docker image build -t example/echo:latest . 
현재 디렉토리의 Dockerfile을 읽어서
example/echo:latest라는 이름으로
도커 이미지를 생성합니다.

docker container run example/echo:latest
>> Hi! there

docker image ls 
다운로드 된 도커 이미지 리스트

docker container run
-d : 백그라운드로 실행
-p : 포트포워딩

docker container run -d -p 3000(내 PC의 PORT) : 3000(도커 PORT)
즉, 컨테이너 밖의 PORT와 컨테이너 안의 PORT를 연결시켜주는것이다.

docker container run -d example/echo:latest 
7ace0f417cbf5212f889fd4f275c1f9e8201ee4edde1964976847599e7c17e04 ( < 컨테이너 아이디)

-----------------------------
docker > spring boot 포트포워딩
-----------------------------

도커 이미지 빌드
docker build -t bootdocker:latest .

docker container run -d -p 8082:8080 bootdocker:latest
외부에서는 localhost:8082로 접속하면 내부적으로 컨테이너의 8080 포트에서 실행 중인 애플리케이션에 접근할 수 있다.
=> http://localhost:8082/hello url 정상적으로 접속 확인


-- 컨테이너 이름을 지정하는 옵션
docker container run -d --name bootdocker -p 8082:8080 bootdocker:latest

도커 운영과 관리를 위한 명령 
## prune

docker container prune
docker image prune

```
