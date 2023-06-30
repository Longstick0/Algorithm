# OSIV - Open Session In View

![image](https://github.com/Longstick0/TIL/assets/69510442/20bd820d-ea72-4580-b167-2a0ea45c2164)

### ```spring.jpa.open-in-view```: ```true```(기본값)

- 언제 jpa가 DB Connection을 가져오고, 언제 반환을 할지에 대한 문제

> OSIV가 켜져있으면, Controller에서 클라이언트에게 응답을 보내주기까지 트랜잭션을 물고있는다. 즉 DB 커넥션 반환을 끝날 때까지 안 한다.
> 
> **why?** 예를 들어 fetch type이 LAZY로 설정되어 있을 때, 프록시 객체를 호출할 일이 생겼을 때, 프록시 초기화가 필요하다. 이 때 영속성 컨텍스트가 DB 커넥션을 물고 살아있어야 하기 때문.

- OSIV는 트랜잭션이 끝나도 끝까지 DB 커넥션을 물고 살려두는 것이다. (view 랜더링 시에는 view 랜더링이 모두 끝날 때까지)

> 하지만 이 전략의 치명적인 단점은, 너무 오랫동안 DB 커넥션을 물고 있는다. 그렇기 때문에 실시간 트래픽이 중요한 서비스에서는 커넥션을 너무 오래 들고 있기 때문에, 커넥션이 모자랄 수 있다.

---
### ```spring.jpa.open-in-view```: ```false```
- OSIV를 끄면, 트랜잭션을 종료할 때 영속성 컨텍스트를 닫고, DB 커넥션도 반환한다.
- 즉 불필요한 커넥션을 낭비하지 않는다! (제일 큰 장점)
- 하지만 지연로딩을 트랜잭션 안에서 처리해야 한다. 즉 Service, Repository 계층에서 지연로딩 처리를 끝내야 한다.
- OSIV 옵션을 끈 상태로 트랜잭션이 종료된 상태에서 LAZY로딩으로 설정된 Entity 객체를 호출하게 되면, 당연하게도 영속성 컨텍스트가 종료됐기 때문에 오류가 발생한다.
  - ```org.hibernate.LazyInitializationException: could not initialize proxy```

### 정리해보자면
- ```true```의 경우, Entity를 LAZY로딩 기술 등을 Controller나 View에서 적극 활용이 가능
- 중복도 줄이고, 투명하게 LAZY로딩 끝까지 유지할 수 있기 때문에 유지보수 측면에서 장점이 존재
- 하지만 커넥션을 너무 오래 들고 있기 때문에 커넥션 풀이 바닥나는 치명적인 장애 가능성 존재

### CQRS 패턴을 사용해 서비스를 분리하자
- 위에서 설명한 단점대로 OSIV를 켜두게 되면 큰 서비스의 경우 큰 장애를 초래할 수 있다.
- 하지만 Controller에서 LAZY로딩을 통해 호출할 Entity도 존재하고, 서비스도 큰 경우에는 어떻게 할까?
- 여러가지 해결방법이 존재하겠지만, 보편적으로 CQRS로 해결하자.
> **CQRS(Command and Query Responsibility Segregation)**
> 데이터 저장소에 대한 읽기 및 업데이트 작업을 구분하여 명령과 조회의 책임 분리


