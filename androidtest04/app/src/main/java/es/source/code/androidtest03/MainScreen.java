package es.source.code.androidtest03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class MainScreen extends AppCompatActivity {
    private Button signorregister;//不允许在元素没加载出来调用控件
    private String inputdata ;
    private Button call ;
    private Button check ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent= getIntent();
        inputdata =  intent.getStringExtra("extra_data");

        Log.d("ms",inputdata);

        setContentView(R.layout.activity_main_screen);

        call =findViewById(R.id.button);
        check =findViewById(R.id.button2);
        signorregister= findViewById(R.id.button3);

        signorregister.setOnClickListener(new View.OnClickListener()
                { @Override
                    public void onClick(View v) {
                        Intent intent = new Intent( MainScreen.this,LoginOrRegister.class);
                    try {
                        sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    startActivityForResult(intent,99);
                    }
                }
        );
        if(!inputdata.equals("FromEntry"))//不能用==
        {
            Button call =findViewById(R.id.button);
            Button check =findViewById(R.id.button2);
            check.setVisibility(View.INVISIBLE);
            call.setVisibility(View.INVISIBLE);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Boolean INVISIABLE = true;

        switch(requestCode)
        {
            case 99:
                if(resultCode==88)
                {
                    Log.d("back",data.getStringExtra("back_data"));
                    inputdata =  data.getStringExtra("back_data");
                }
                else if (resultCode==89)
            {
                Log.d("back",data.getStringExtra("back_data"));
                inputdata =  data.getStringExtra("back_data");
                INVISIABLE = false;

            }
                break;
                default :
        }
        if(!inputdata.equals("FromEntry")&& INVISIABLE)//不能用  == 判断
        {

            check.setVisibility(View.INVISIBLE);
            call.setVisibility(View.INVISIBLE);
        }
        else if((check.getVisibility()|check.getVisibility()) != View.VISIBLE )
            {
                check.setVisibility(View.VISIBLE);
                call.setVisibility(View.VISIBLE);

            }

    }
}
