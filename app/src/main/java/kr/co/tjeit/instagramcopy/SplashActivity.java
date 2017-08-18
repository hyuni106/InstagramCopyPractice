package kr.co.tjeit.instagramcopy;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import kr.co.tjeit.instagramcopy.data.UserData;
import kr.co.tjeit.instagramcopy.util.ContextUtil;
import kr.co.tjeit.instagramcopy.util.GlobalData;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {
        // 시간이 지나면 실행되게 하는 코드 : Handler, Runnable
        // Handler > 안드로이드의 쓰레드(Thread) 개념
        // Thread > 기본 앱과 볅개로 돌아가는 프로세스 > CPU 하나 더 쓰는 것과 같다
        // Handler는 시간에 관련된 특수한 동작을 실행
        // 백그라운드에서 돌아가야 하는 일들 > 메인쓰레드 이외의 작업
        Handler myHandler = new Handler();
        // 1. 핸들러 변수 생성 및 객체화
        // 2. 만들어진 핸들러에게 업무 지시. 업무를 n초 이후에 하도록 지시 postDelayed
        // postDelayed의 파라미터는 2개 필요
        // 1) 해야할 일 > new Runnable
        // 2) 실행 할 시간은 1/1000초 단위로(밀리세컨드)
        // Runnable 객체의 내부에 있는 run 메쏘드에 실제로 해야할 일 구현
        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                화면을 전환하고 자신을 종료하는 코드를 작성.
                // 화면을 전환하는 코드

                // Intent 변수를 빈 공간으로 설정.
                // 왜? 상황에 따라 목적지가 달라질 수 있으므로.
                Intent intent;

                UserData tempData = ContextUtil.getUserData(mContext);
                if (tempData == null) {
                    // 로그인이 안되어있는 상황
                    intent = new Intent(mContext, LoginActivity.class);
                }
                else {
                    intent = new Intent(mContext, MainActivity.class);
                }


                // 상황에따라 만들어진 intent를 실제로 실행
                startActivity(intent);
                // 스플래쉬 화면을 종료
                finish();

            }
        }, 2000);

    }

    @Override
    public void setValues() {
        GlobalData.initGlobalData();
    }

    @Override
    public void bindViews() {

    }
}
