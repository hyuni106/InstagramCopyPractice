package kr.co.tjeit.instagramcopy.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by user on 2017-08-17.
 */

public class ReplyData implements Serializable {
    // 댓글이 고유하게 가지는 속성
    private int replyId;    // db 연동 고려한 id
    private String content; // 댓글의 내용
    private Calendar createdAt; // 댓글 작성 시간

    // 댓글과 다른 객체들간의 관게
    // 댓글과 작성자간의 관계 > 일반 사용자 객체
    private UserData writerData;
    // 댓글 > 좋아한 사람들
    private List<UserData> likeUsers = new ArrayList<>();
    // 댓글 <- 부모댓글
    // 부모댓글의 id값을 저장함으로써 대댓글임을 명시
    // id가 유효하지 않은 값 (Ex. -1) 이면 부모가 없는 원본 댓글임을 명시
    // id가 유효한 값 (Ex. > 1) 이면 부모 댓글에 매달려있는 답글임을 명시
    private int parentReplyId;
}
