# feature1 게시글 생성, 조회, 수정 API 만들기
Spring Boot + JPA를 활용

## 주안점
- Domain 클래스 작성
- DTO 클래스를 이용한 Request
- 메세지 던지기
- Builder패턴 (Setter X)

## Domain 클래스 작성 : Posts Domain
```java
@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Posts(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
```
### 스키마 제약조건
`@Column` 어노테이션을 통해 직접 기본값을 설정하는 방법입니다. 대표적으로 `nullable`, `unique` 조건 등 Entity 클래스만으로도 DB 테이블 구조를 파악할 수 있습니다.

