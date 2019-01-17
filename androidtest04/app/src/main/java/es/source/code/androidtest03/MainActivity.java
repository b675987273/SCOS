package es.source.code.androidtest03;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity implements  android.view.GestureDetector.OnGestureListener {

    //https://blog.csdn.net/luoshen87/article/details/73732319 Android studio开发中，监控手指的滑动方向，并做出相应的响应事件 --Bigtreey
    private GestureDetector detector;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detector = new GestureDetector(this,this);
        setContentView(R.layout.activity_main);



        intent =new Intent ("scos.intent.action.SCOSMAI");
        //intent.addCategory("scos.intent.category.SCOSLAUNCHER");
        intent.addCategory("scos.intent.category.SCOSLAUNCHER");


        Intent exintent = getIntent();
        Bundle bundle = exintent.getExtras();

        if (bundle != null) {

            String name = bundle.getString("next");

            Toast.makeText(getApplicationContext(),"imput"+name , Toast.LENGTH_SHORT).show();

//
            if (name.equals("MainScreeen"))
            {
                String data = "";//必须传入数据
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        }
    }


    public boolean onTouchEvent(MotionEvent me){
        return detector.onTouchEvent(me);
    }
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float minMove = 120;         //定义最小滑动距离
        float minVelocity = 0;      //定义最小滑动速度
        float beginX = e1.getX();
        float endX = e2.getX();
        float beginY = e1.getY();
        float endY = e2.getY();

        if(beginX-endX>minMove&&Math.abs(velocityX)>minVelocity){   //左滑
            Toast.makeText(this,"左滑",Toast.LENGTH_SHORT).show();  //此处可以更改为当前动作下你想要做的事情

//            Intent intent =new Intent ("es.source.code.activity.MainSreen");

//            startActivity(intent);

            String data = "FromEntry";
            intent.putExtra("extra_data",data);
            startActivity(intent);
            //new一个手势检测器



        }else if(endX-beginX>minMove&&Math.abs(velocityX)>minVelocity){   //右滑
            Toast.makeText(this,"右滑",Toast.LENGTH_SHORT).show();  //此处可以更改为当前动作下你想要做的事情
        }else if(beginY-endY>minMove&&Math.abs(velocityY)>minVelocity){   //上滑
            Toast.makeText(this,"上滑",Toast.LENGTH_SHORT).show();  //此处可以更改为当前动作下你想要做的事情
        }else if(endY-beginY>minMove&&Math.abs(velocityY)>minVelocity){   //下滑
            Toast.makeText(this,"下滑",Toast.LENGTH_SHORT).show();  //此处可以更改为当前动作下你想要做的事情
        }

        return false;
    }
//https://blog.csdn.net/luoshen87/article/details/73732319 Android studio开发中，监控手指的滑动方向，并做出相应的响应事件 --Bigtreey


}
