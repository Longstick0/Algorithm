## 트랜잭션 전파

### 트랜잭션 전파란?
> 어떤 트랜잭션이 동작중인 과정에서 다른 트랜잭션을 실행할 경우 `어떻게 처리하는 가`에 대한 개념이다.

서비스에서 회원가입하는 로직과 해당 과정이 완료되기전 로그를 남기는 로직이 묶여 있다고 생각해보자.
사용자가 회원가입 내용을 모두 채우고 가입을 눌렀을 때 알 수 없는 이유로 로그를 남기는 로직에서 에러가 발생하면
전파 옵션이 Default 일 경우 모든 회원가입 정보가 함께 롤백되는 문제가 생길 수 있다.

이때 필요한 개념이 트랜잭션 전파다. 위의 상황에선 작업 단위로 트랜잭션이 동작하도록 설정한다면
로그 로직에서 문제가 생기더라도 회원 가입 정보는 커밋된다. 트랜잭션 전파 옵션 종류에 대해서 알아보자.

### REQUIRED
- Default
- 부모 트랜잭션이 있다면 종속되고 없다면 새로운 트랜잭션 생성
### REQUIRES_NEW
- 부모 트랜잭션이 있더라도 새로운 트랜잭션 생성
- 부모 트랜잭션은 해당 트랜잭션이 완료될 때까지 대기
### SUPPORTS
- 부모 트랜잭션이 있을 때만 종속
- 없다면 트랜잭션이 적용되지 않는다.
### NOT_SUPPORTED
- 부모 트랜잭션이 있어도 트랜잭션 없이 실행
- 부모 트랜잭션이 있다면 대기
### MANDATORY
- 부모 트랜잭션이 있으면 족송
- 부모 트랜잭션이 없다면 예외 발생
### NEVER
- 트랜잭션이 적용되면 안되는 경우 사용
- 부모 트랜잭션이 있다면 예외 발생
### NESTED
- 부모 트랜잭션이 있으면 새로운 트랜잭션 생성
- 자식 트랜잭션이 롤백되어도 부모 트랜잭션은 커밋
- 부모 트랜잭션이 롤백되면 자식 트랜잭션도 롤백

## 예제

> REQUIRED 와 REQUIRES_NEW 의 중요도가 높고 나머지는 약간의 응용이므로 2가지 위주로 실습해 보자.

현재 멤버의 정보를 입력해서 회원가입을 하고 회원 정보로 로그가 데이터베이스에 저장되는 상황이다. 이때 회원의 이름이 "Ex"라면 로그 생성시 예외를 던진다고 해보자.
```java
    public Log(Member member) {
        if (member.getName().equals("Ex")) {
            throw new IllegalArgumentException("예외 발생!!!");
        }
        this.log = member.getName() + "-" + member.getAge();
    }
```
회원 가입 로직은 다음과 같다.
```java
    @Transactional
    public Member joinMemberWithLog(String name, int age) {
        Member member = memberService.joinMember(name, age);
        logService.createLog(member);
        return member;
    }
```

### 1. 정상 저장
```
{
    "name": "an",
    "age" : 100
}
```

![](https://velog.velcdn.com/images/taaaaate/post/fce76a4e-0232-485b-9991-ccc114eed070/image.png)

모두 제대로 저장 되었다.

### 2. 예외 상황
```
{
    "name": "Ex",
    "age" : 100
}
```
예외가 발생 했고, 데이터베이스에도 둘 다 저장되지 않았다.
![](https://velog.velcdn.com/images/taaaaate/post/c57b6e9f-3fc6-454b-9904-77cbb62a475c/image.png)

### 3. 예외 상황 (+ REQUIRES_NEW)

`createLog()` `joinMember()` 로직의 트랜잭션 전파 속성을 `REQUIRES_NEW` 로 변경해주었다.

```java
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createLog(Member member) {
        logRepository.save(new Log(member));
    }
 
     @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Member joinMember(String name, int age) {
        return memberRepository.save(new Member(name, age));
    }
```
![](https://velog.velcdn.com/images/taaaaate/post/e06f2612-e748-4ced-b284-69d5a6988552/image.png)
예외는 발생 했지만, 회원 정보는 데이터베이스에 저장되었다.
로그 저장 부분에서 예외로 롤백이 되더라도, 회원 관련 로직은 커밋된 것이다.


## 정리
트랜잭션 전파 속성을 잘 이해하고 사용하면 비교적 중요하지 않은 로직때문에 중요한 로직의 편의성이 방해되는 상황을 방지할 수 있다.














