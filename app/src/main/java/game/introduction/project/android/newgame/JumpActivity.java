package game.introduction.project.android.newgame;

/**
 * Created by appu2 on 2018/03/14.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Handler;

/**
 * Created by appu2 on 2018/03/12.
 */

public class JumpActivity extends AppCompatActivity{
    private ImageView yariImage;
    private TranslateAnimation yariAnimation;
    private ImageView nekoView;
    private TranslateAnimation nekoAnimation;
    private Intent MainIntent;
    private Button startButton;
//    スタートボタンが押されているか否か
    private boolean GameIsStart;
//    ジャンプをしているか否か
    private boolean JumpIsTrue;
//    それぞれの大きさチェックなど
//        キャラクターの大きさ
    private int charaHeight;
    private int charaWidth;
    //        キャラクターの中心点
    private int charaHeightHref;
    private int charaWidthHref;
    //        キャラクターの座標
    private int charaX;
    private int charaY;
    //        槍の座標
    private int yariX;
    private int yariY;
    //        槍の大きさ
    private int yariWidth;
    private int yariHeight;
    //        槍の中心点
    private int yariWidthHref;
    private int yariHeightHref;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jump_activity);
        GameIsStart = false;
        JumpIsTrue = false;
//        キャラクターがジャンプするアニメ
        characterJumpAnimation();
//        スタートボタンを押したらGameIsStartきりかえ
        startbuttonPush();
//        キャラと障害物がぶつからないか
//        if(GameIsStart) {
//            //        槍が画面右に流れるアニメ
//            yariAnimationv();
//            Log.d("スタート判定","スタートしました");
//            if(JumpIsTrue){
//
//            }else{
//                butukaru();
//            }
//        }else{
//            System.out.println("スタートしてません");
//        }
    }

    @Override
    public void onResume(){
        super.onResume();
    }
    private void yariAnimationv(){
        yariImage = findViewById(R.id.yari);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                yariAnimation = new TranslateAnimation(
                        TranslateAnimation.RELATIVE_TO_PARENT,0,
                        TranslateAnimation.RELATIVE_TO_PARENT,1,
                        TranslateAnimation.RELATIVE_TO_PARENT,0,
                        TranslateAnimation.RELATIVE_TO_PARENT,0
                );
                yariAnimation.setDuration(3000);
                yariImage.startAnimation(yariAnimation);
                int yariX = (int)yariImage.getX();
                int yariY = (int)yariImage.getY();
                Log.d("槍座標","槍ｘ"+yariX+":"+"槍Y"+yariY);

                nekoView = findViewById(R.id.neko);
                int charaX = (int)nekoView.getX();
                int charaY = (int)nekoView.getY();
                Log.d("ねこ座標","ねこx"+charaX+"ねこy"+charaY);
                yariAnimationv();
            }

        },2000);
    }
    private void characterJumpAnimation(){
        nekoView = findViewById(R.id.neko);
        nekoAnimation = new TranslateAnimation(
                TranslateAnimation.RELATIVE_TO_SELF,0,
                TranslateAnimation.RELATIVE_TO_SELF,0,
                TranslateAnimation.RELATIVE_TO_SELF,0,
                TranslateAnimation.RELATIVE_TO_SELF,-2
        );
        nekoAnimation.setDuration(1000);
        nekoView.startAnimation(nekoAnimation);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
//        タッチするとジャンプするからtrueにする
        JumpIsTrue = true;
        characterJumpAnimation();
        return false;
    }
    private void intentMainGamen(){
        MainIntent = new Intent(this,MainActivity.class);
        startActivity(MainIntent);
    }
    private void startbuttonPush(){
        startButton = findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                GameIsStart = true;
                startButton.setVisibility(View.INVISIBLE);
                if(GameIsStart) {
                    //        槍が画面右に流れるアニメ
                    yariAnimationv();
                    Log.d("スタート判定","スタートしました");
                    if(JumpIsTrue){

                    }else{
                        Log.d("実行","ぶつかる判定呼び出されている");
                        butukaru();
                    }
                }else{
                    System.out.println("スタートしてません");
                }
            }
        });
    }
    private void butukaru(){
        nekoView = findViewById(R.id.neko);
        yariImage = findViewById(R.id.yari);

//        キャラクターの大きさ
        charaHeight = nekoView.getHeight();
        charaWidth = nekoView.getWidth();
//        キャラクターの中心点
        charaHeightHref = charaHeight/2;
        charaWidthHref = charaWidth/2;
//        キャラクターの座標
        charaX = (int)nekoView.getX();
        charaY = (int)nekoView.getY();
//        槍の座標
        yariX = (int)yariImage.getX();
        yariY = (int)yariImage.getY();
//        槍の大きさ
        yariWidth = yariImage.getWidth();
        yariHeight = yariImage.getHeight();
//        槍の中心点
        yariWidthHref = yariWidth/2;
        yariHeightHref = yariHeight/2;
//        if(yariX >= charaX+charaWidthHref){
//            Log.d("判定","当たった");
//        }
        hitCharaAndYari();
    }
    private void hitCharaAndYari(){
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                if(yariX >= charaX+charaWidthHref){
                    Log.d("判定","当たった");
                }
            }
        },1000);
    }
}