# 🗄️DB 인덱스와 커버링 인덱스

# 1. 인덱스(Index)란?

인덱스란 **추가적인 쓰기 작업과 저장 공간을 활용하여 데이터베이스 테이블의 검색 속도를 향상시키기 위한 자료구조이다.** 

> 예를 들어 우리가 Java 프로그래밍 책에서 Stream이 궁금하여 찾아본다고 했을 때, 책의 맨 뒷편에 **색인**으로 쪽 번호와 함께 별도로 배열해놓은 항목을 통해 쉽게 찾을 수 있다.
> 
> 
> ![image](https://github.com/Longstick0/TIL/assets/69510442/ed5981d0-9ff0-4a64-8bd2-3a3877f5a20b)
> 

DB에서도 테이블의 모든 데이터를 검색한다면 시간이 오래 걸리기 때문에 데이터의 물리적 위치를 자료구조를 통해 조회할 수 있도록 돕는 **인덱스**가 있다.

실제 DB 관련 작업을 할 때 대부분 속도 저하의 원인은 **조회(Select)의 Where문**에서 발생하는데, 가장 먼저 생각해볼 수 있는 대안으로 Index를 생각할 수 있다.

![image](https://github.com/Longstick0/TIL/assets/69510442/4f748fef-0610-4b8b-8a52-a34530183f92)
이 부분은 확실하지 않지만, 조심스레 추측해보자면, C언어가 다른 언어에 비해서 ‘포인터’라는 개념 때문에 조금 어렵게 느껴진다. 하지만 이는 개발자가 직접 위치를 할당해주기 때문에 속도 측면에서는 다른 언어에 비해 매우 빠르다. 이러한 개념으로 DB 인덱스를 이해하니 좀 더 수월하였다.

## 인덱스 사용

```sql
//mysql
CREATE INDEX USER_COMPANY_INDEX ON USER(COMPANY_ID);
```

- CREATE INDEX: 인덱스 생성 명령어
- USER_COMPANY_INDEX: 인덱스 이름
- ON USER(): 테이블 지정 명령어
- COMPANY_ID: 인덱스를 걸어줄 컬럼명
    - 여러 컬럼을 걸어주고 싶다면, (COMPANY_ID, EMAIL_ID,…, ADDRESS) 이런 식으로 설정해주면 된다.

## 인덱스 사용 시 주의점

### CRUD 각각에 미치는 영향

주의점을 알아보기 전에, CRUD에 미치는 영향을 먼저 살펴보자.

> **READ** → 위 그림에서 살펴보았던 것처럼 각 테이블에 접근하기 위한 인덱스를 설정해두고, 이를 빠르게 찾아낼 수 있기 때문에 가장 빛을 발한다.
**UPDATE, DELETE →** WHERE 절에 잘 설정된 인덱스로 조건을 붙여주면 조회할 때 성능은 크게 저하되지 않는다. **(단, 이는 수정 및 삭제를 할 데이터를 찾을 때 속도가 빨라지는 것이고, 수정 및 삭제 자체의 속도가 빨라지는 것은 아님!)**
**CREATE →** 새로운 데이터가 추가되면서 기존에 인덱스 페이지에 저장되어 있던 탐색 위치가 수정되기 때문에 **효율이 좋지 못하다.**
> 

데이터베이스는 Index를 항상 최신의 정렬 상태로 유지해야 원하는 값을 빠르게 얻을 수 있다. 그렇기 때문에 인덱스가 적용된 컬럼에 INSERT, UPDATE, DELETE가 수행된다면 각각 다음과 같은 연산을 추가적으로 해주어야 하며 그에 따른 오버헤드가 발생한다.

- INSERT: 새로운 데이터에 대한 인덱스를 추가
- DELETE: 삭제하는 데이터의 인덱스를 사용하지 않는다는 작업을 진행
- UPDATE: 기존의 인덱스를 사용하지 않음 처리하고, 갱신된 데이터에 대해 인덱스를 추가

### 그러면 모든 테이블 컬럼에 인덱스를 설정해주는 것이 좋겠네요?!

무조건 많이 인덱스를 설정하는 것은 오히려 성능을 저하시킬 수 있다. 그 이유로 바로 위에 있는 문단을 참고하면 되는데, **수정, 삽입, 삭제를 할 때 발생하는 오버헤드가 성능을 저하시킬 수 있기 때문이다.** 

또한 인덱스는 DB 메모리를 사용하여 테이블 형태로 저장하기 때문에 인덱스의 개수와 저장 공간이 비례하다. **즉 인덱스를 많이 설정하면, 메모리 사용량과 저장 공간이 높아져 성능 저하의 가능성이 있다.**

### 그러면 언제 인덱스를 만들어줘야 하는 거죠?

> **카디널리티(Cardinality)가 높고 활용도가 높을 수록 인덱스를 설정하기 좋은 컬럼이다!
또한 규모가 큰 테이블이나 INSERT, UPDATE, DELETE가 자주 발생하지 않는 컬럼에서 사용하기 적합하다.**
> 
- DB에서 **카디널리티란 컬럼의 고유한 값의 개수를 나타내는 수치다.** 
예를 들어, “커피”라는 테이블이 있고, “메뉴명”이라는 컬럼이 있을 때,
1. 아메리카노
2. 카페라떼
3. 콜드브루
4. 아메리카노
5. 아인슈페너
의 카디널리티는 4다. 고유한 컬럼이 총 4개가 있기 때문이다.

카디널리티가 낮을수록(아메리카노가 5잔 있다고 생각) 인덱스가 중복된 값들을 가지게 되므로 인덱스를 사용하여 특정 값을 찾는 것이 비효율적일 수 있다.

- 활용도는 말 그대로 해당 컬럼이 실제 작업에서 얼마나 활용이 되는지에 대한 값이다. 특히 WHERE 절에 자주 사용되는지 확인해보면 활용도를 판단할 수 있다.

## 정리

전체적으로 위 내용을 정리하자면 아래와 같다.

- 인덱스를 사용하면, 조회하는 속도와 그에 따른 성능을 향상시킬 수 있다.
- 또한 시스템 전반의 부하를 줄일 수 있다.
- 하지만 오용(CREATE, DELETE, UPDATE가 빈번한 속성에 인덱스를 걸었을 )하게 되면 오히려 성능이 저하되는 역효과가 발생할 수 있다.

# 커버링 인덱스

일반적으로 인덱스를 설계한다면 `WHERE` 절에 대한 인덱스를 생각하지만, 실제로는 **쿼리 전체**에 대한 인덱스 설계가 필요하다

인덱스는 데이터를 효율적으로 찾는 방법이지만, 이를 잘 활용한다면 실제 데이터까지 접근하지 않고도 데이터를 찾아올 수 있다.

쿼리를 충족시키는데 필요한 모든 데이터를 가지고 있는 인덱스를 **커버링 인덱스(Covering Index)**라 한다.

## 관련 지식

### 실행 계획 (EXPLAIN)

쿼리의 맨 앞에 `EXPLAIN`을 붙혀 실행하면, 상세한 실행 계획을 확인할 수 있다.

```sql
EXPLAIN
SELECT *
FROM board.member m
WHERE m.member_id < 10;
```

![image](https://github.com/Longstick0/TIL/assets/69510442/89016dec-0015-4cf0-81bc-6221a339c767)

1. **id** : SQL문이 실행되는 순서
2. **select_type** : SELECT 문의 유형
3. **key** : 옵티마이저가 실제로 선택한 인덱스
4. **rows** : SQL문을 수행하기 위해 접근한 데이터 행 수

### extra

- Using where: WHERE로 필터링 한 경우
- Using index: 커버링 인덱스를 사용한 경우
- Using filesort: 데이터를 정렬한 경우

### Non-clustered Key와 Clustered Key

|  | 대상 | 제한 |
| --- | --- | --- |
| Non-clustered Key | 일반적인 인덱스 | 테이블에 여러개 생성 가능 |
| Clustered Key | (1)PK (2) PK가 없을 땐, Unique Key(3) 둘 다 없다면, 6bytes의 Hidden Key 생성 | 테이블당 1개만 생성 가능 |

### 탐색 절차

> Non-clustered Key는 age에 Clustered Key는 PK에 걸려있는 상황
>

![image](https://github.com/Longstick0/TIL/assets/69510442/4129e77a-4c2b-47ad-b100-b6576bbb2885)

MYSQL에서는 **Non Clustered Key에 Clustered Key가 항상 포함**되어 있다. 이유는 Non Clustered Key에는 **데이터 블록의 위치가 없기 때문**

따라서, 인덱스 조건이 where 검색 조건에 있더라도 Clustered Key 값으로 데이터를 찾는 과정이 필요하다.

> 만약 PK를 사용할 경우엔 인덱스 탐색을 하지 않기 때문에 조금 더 빠르게 접근 가능하다.
> 

**커버링 인덱스**는 **실제 데이터에 접근하지 않고 인덱스의 존재하는 컬럼 값만으로 쿼리를 완성**하는 것을 의미한다.

## 커버링 인덱스 적용

테스트용 데이터로 아래와 같은 컬럼을 가지는 약 20만개의 데이터를 생성했다.

- Member 테이블에 있는 email 컬럼을 인덱스로 추가했다.

```
CREATE INDEX 'idx_member_idx' ON 'test_member' (email);
```

### SELECT + WHERE

먼저 아래의 쿼리 실행 계획을 살펴본다.

```
EXPLAIN
SELECT *
FROM test_member
WHERE email = 'test20@gmail.com';

```

![image](https://velog.velcdn.com/images/taaaaate/post/003214d3-1225-4a02-914d-46f4ef5e9d64/image.png)

그렇다면 이번엔 *를 email로 변경하면 어떻게 될까?

```
EXPLAIN
SELECT email
FROM test_member
WHERE email = 'test20@gmail.com';

```

![image](https://velog.velcdn.com/images/taaaaate/post/49674ebd-6eb0-4bfa-a41d-53ae1d7b1e66/image.png)

`extra` 를 확인해보면, `using index`로 커버링 인덱스가 사용된 것을 확일 할 수 있다.

### WHERE + GROUP BY

`GROUP BY` 는 아래의 조건에서 인덱스가 적용된다.

```
--- 인덱스가 (a, b, c)인 경우

GROUP BY b              --- 인덱스 적용 X
GROUP BY b, a           --- 인덱스 적용 X
GROUP BY a, c, b        --- 인덱스 적용 X

GROUP BY a              --- 인덱스 적용 O
GROUP BY a, b           --- 인덱스 적용 O
GROUP BY a, b, c        --- 인덱스 적용 O

GROUP BY b, c           --- 인덱스 적용 X

GROUP BY a, b, c, d     --- 인덱스 적용 X

```

**학습을 위해 (email, PK, age)로 인덱스를 추가한다.**

```
CREATE INDEX `idx_member_email_id_age` ON `test_member` (email, member_id, age);

```

그리고 아래 쿼리의 실행 계획과 수행 시간을 확인했다.

```
SELECT *
FROM test_member
WHERE email LIKE 'test20%'
GROUP BY member_id, age;

```

![image](https://velog.velcdn.com/images/taaaaate/post/82dd021f-00ed-48e5-a197-153394af4df3/image.png)

`extra` 를 확인해보면, `using where`이 사용된 것을 확일 할 수 있다. 실제 수행 시간은 약 `0.01sec`이 나왔다.

이번엔 커버링 인덱스를 사용해보자.

```
SELECT email, member_id, age
FROM test_member
WHERE email LIKE 'test20%'

GROUP BY member_id, age;

```

![image](https://velog.velcdn.com/images/taaaaate/post/b426648e-7096-4513-9aaa-b6fdbf722dc3/image.png)


`extra` 를 확인해보면, `using index`이 사용된 것을 확일 할 수 있다. 실제 수행 시간은 약 `0.0025sec`이 나왔다.
약 4배 단축되었다.

### 결론

조회 쿼리를 작성할 때, 인덱스 적용 조건을 잘 숙지하여 `커버링 인덱스`를 활용하면 성능 개선에 도움을 줄 수 있다.