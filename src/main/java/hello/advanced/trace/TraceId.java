package hello.advanced.trace;

import java.util.UUID;

/**
 * 프로토 타입 개발
 * @@ TraceId 는 단순히 id(트랜잭션ID)와 level 정보
 */
public class TraceId {


    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        /**
         * UUID가 너무 길기 때문에, 8자리만 사용
         * 이정도면 로그를 충분히 구분 가능.
         */
        return UUID.randomUUID().toString().substring(0, 8);
    }
    //트랜잭션 ID는 같지만, 깊이는 하나 증가. (Level 증가)
    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    // Lvel 하나 감소.
    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }
    // 첫 번쨰 레벨 여부를 편리하게 확인할 수 있는 메서드
    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }


}
