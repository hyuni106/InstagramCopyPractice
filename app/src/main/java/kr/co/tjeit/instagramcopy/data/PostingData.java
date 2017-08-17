package kr.co.tjeit.instagramcopy.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-08-17.
 */

public class PostingData implements Serializable {
    // 게시하는 사진

    // 포스팅 데이터가 갖는 기본 속성
    private int postingId; // DB와의 연동을 고려한 변수.
    private String imageURL; // 게시한 포스팅의 사진이 있는 경로.
    private String content; // 사용자가 사진을 포스팅할때 첨부한 글.

    // 포스팅 데이터 갖는 관계.

    // 게시글 -> 작성자 (1)
    private UserData writerData;
    // 게시글 -> 좋아한 사람들 (N)
    private List<UserData> likeUsers = new ArrayList<>();
    // 게시글 -> 댓글 (N)
    // TODO 댓글 데이터 정리되면 추가해야함.
    // 게시글 -> 해시태그 (N)
    private List<String> hashTags = new ArrayList<>();


}










