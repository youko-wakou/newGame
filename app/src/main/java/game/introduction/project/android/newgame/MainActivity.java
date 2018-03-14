package game.introduction.project.android.newgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Intent jumpIntent;
    private Button jumpubtton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jumpubtton = findViewById(R.id.jump);
        jumpubtton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                jumpIntent();
            }
        });
    }
    private void jumpIntent(){
        jumpIntent = new Intent(this,JumpActivity.class);
        startActivity(jumpIntent);
    }
}