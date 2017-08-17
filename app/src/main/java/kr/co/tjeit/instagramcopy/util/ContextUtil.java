package kr.co.tjeit.instagramcopy.util;

import android.content.Context;
import android.content.SharedPreferences;

import kr.co.tjeit.instagramcopy.data.UserData;

/**
 * Created by user on 2017-08-17.
 */

// 컨텍스트 유틸은 자동로그인과 같이 앱이 종료되어도 기록되어야 하는 것들을
    // 실제로 기록하기 위한 용도로 만들어줌
    // 로그인한 사람의 경우에는 여기서 빼내는게 더 효율적
public class ContextUtil {
    // 기본적으로 로그인을 하지 않은 상태로 정의
    // loginUserData가 null이 아니면 비로그인 상태
    public static UserData loginUserData = null;

    // 사용할 메모장 파일의 이름을 고정시켜두고 변수로 활용하면
    // 오타도 방지할 수 있고 자동완성으로 집어넣을 수 있음
    // final static 변수로 고정시켜서 활용
    private final static String prefName = "instaPref";
    // 항목들도 마찬가지의 이유로 final static 변수로 설정
    // ID를 넣고 뺄때 활용하는 String 변수
    private final static String loginUserId = "LOGIN_USER_ID";
    private final static String loginUserName = "LOGIN_USER_NAME";
    private final static String loginUserNickName = "LOGIN_USER_NICKNAME";
    private final static String loginUserProfURL = "LOGIN_USER_PROFILE_URL";

    // 멤버변수가 있음녀 게터/세터 필요
    // 수동으로 구현

    // SharedPreference를 이용할 수 있게 하기 위한 context를 재료 1번
    // 실제로 저장될 근본 데이터인 UserData를 지료 2번
    public static void setLoginUser(Context context, UserData inputUserData) {
        // 기록을 하기 위한 메모장 SharedPreference를 소환
        // 소환을 할 때 항상 메모(꼬리표) 붙여서 소환
        // 저장한 pref의 꼬리표와 불러올때 pref의 꼬리표는 동일해야만 데이터가 공유
        // MODE_PRIVATE는 외부에 공개하지 않겠다는 의미
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        // 실제로 저장하는 부분
        // LOGIN_USER_ID = 10 저장
        // commit() 메소드 실행해야 실제로 저장
        pref.edit().putInt(loginUserId, inputUserData.getUserId()).commit();
        pref.edit().putString(loginUserName, inputUserData.getName()).commit();
        pref.edit().putString(loginUserNickName, inputUserData.getNickName()).commit();
        pref.edit().putString(loginUserProfURL, inputUserData.getProfileImgURL()).commit();
    }

    public static UserData getUserData(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        // 로그인을 한 상태인지 체크
        if (pref.getInt(loginUserId, -1) != -1) {
            // 만약 로그인이 되어있다면
            if (loginUserData == null) {
                // 만약 로그인은 되어있는데 loginUserData 객체가 생성되지 않았다면
                loginUserData = new UserData();
            }
            loginUserData.setUserId(pref.getInt(loginUserId, -1));
            loginUserData.setName(pref.getString(loginUserName, ""));
            loginUserData.setName(pref.getString(loginUserNickName, ""));
            loginUserData.setName(pref.getString(loginUserProfURL, ""));
        } else {
            loginUserData = null;
        }

        return loginUserData;
    }

    public static void logoutProcess(Context context) {
        // 메모장에 기록된 사용자 정보를 다 초기화

        // 1. 메모장 파일 Open
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putInt(loginUserId, -1).commit();
        pref.edit().putString(loginUserName, "").commit();
        pref.edit().putString(loginUserNickName, "").commit();
        pref.edit().putString(loginUserProfURL, "").commit();
    }
}
