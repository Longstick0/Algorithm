## @EventListener
`Spring` 에서 제공 하는 `@EventListener` 를 사용하면 의존성이 강한 로직들의 레이어를 분리할 수 있다. 

예를 들어, 서비스 A의 로직 a에서 서비스 B의 b로직이 같이 동작해야하는 경우에 이벤트 발행을 통해서 두 서비스의 결합도를 낮출 수 있다.

> Spring 4버전 이하에선 `ApplicationEvent` 와 `ApplicationListener` 를 구현해야 했지만 현재는 어노테이션을 통해서 가능하다. 

### 적용

현재 엔티티의 연관관계는 다음과 같다.
![](https://velog.velcdn.com/images/taaaaate/post/e8e82c05-cc20-436b-af37-74e3d2432712/image.png)

#### Event Class
이벤트 리스너에 걸리는 이벤트 클래스 

```java
@Value(staticConstructor = "of")
public class MemberEvent {
    Member member;
}
```

#### Service Logic
서비스 로직내에서 `ApplicationEventPublisher` 의 `publishEvent` 메서드를 통해서 이벤트 발행
```java
private final ApplicationEventPublisher publisher;

public void deleteWithEventListener(Long memberId) {
    Member member = memberRepository.findById(memberId)
            .orElseThrow(IllegalArgumentException::new);
    publisher.publishEvent(MemberEvent.of(member));
    memberRepository.delete(member);
}
```

#### EventListener Method
이벤트 발생시 동작하는 메서드
`@EventListener` 어노테이션을 붙혀서 사용한다.
```java
@EventListener
public void deleteByMember(MemberEvent memberEvent) {
    Member member = memberEvent.getMember();
    postService.deleteByPosts(member.getPosts()); 
    reviewService.deleteByReviews(member.getReviews());
}
```

## @Async - 비동기 처리

스프링 이벤트는 기본적으로 **동기처리** 방식을 사용합니다. 하지만 이런 처리 방식은 회원을 삭제했는데 **게시글이나 리뷰의 삭제 시간까지 포함**된 시간이 지나야지만 응답을 받을 수 있다는 단점이 있다.

메인 로직을 제외한 이벤트들은 비동기 처리 방식이 더 적합할 것 같다.

### 적용

#### Main Class
`@EableAsync` 어노테이션을 추가한다.

```java
@EnableAsync
@SpringBootApplication
public class AsyncEventlistenerPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncEventlistenerPracticeApplication.class, args);
    }

}
```

#### 비동기 적용 메서드
비동기 처리를 하려는 메서드에 `@Async` 어노테이션을 달아준다.
```java
@Async
@EventListener
public void deleteByMember(MemberEvent memberEvent) {
    Member member = memberEvent.getMember();
    postService.deleteByPosts(member.getPosts());
    reviewService.deleteByReviews(member.getReviews());
}
```

> 오늘은 @EventListener 와 @Async를 활용한 로직 의존성 감소와 비동기 처리 방식에 대해 알아보았습니다.


