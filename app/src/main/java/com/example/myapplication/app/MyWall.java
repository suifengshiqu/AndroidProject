package com.example.myapplication.app;

import android.app.*;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;


@SuppressWarnings("ConstantConditions")
public class MyWall extends ActionBarActivity {

    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private Button btnFlush;
    private Button btnColor;

    private float oldX = 0f;
    private float oldY = 0f;

    private boolean canDraw = false;
    private Paint mPaint = null;

    private int selectedColor = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wall);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        surfaceView = (SurfaceView)findViewById(R.id.surfaceview);
        surfaceHolder = surfaceView.getHolder();

        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2.0f);

        btnFlush = (Button) findViewById(R.id.btnFlush);
        btnFlush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //锁定整个SurfaceView
                Canvas mCanvas = surfaceHolder.lockCanvas();
                if (mCanvas != null) {
                    mCanvas.drawColor(Color.BLACK);
                }
                //绘制完成，提交修改
                surfaceHolder.unlockCanvasAndPost(mCanvas);
                //重新锁定一次
                surfaceHolder.lockCanvas(new Rect(0,0,0,0));
                surfaceHolder.unlockCanvasAndPost(mCanvas);
            }
        });

        btnColor = (Button)findViewById(R.id.btnColor);
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog mDialog = new AlertDialog.Builder(MyWall.this)
                        .setTitle("颜色设置")
                        .setSingleChoiceItems(new String[] {"红色", "绿色", "蓝色"}, selectedColor, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int selected){
                                switch (selected)
                                {
                                    case 0: {
                                        //画笔颜色
                                        mPaint.setColor(Color.RED);
                                        break;
                                    }
                                    case 1:
                                    {
                                        mPaint.setColor(Color.GREEN);
                                        break;
                                    }
                                    case 2:
                                    {
                                        mPaint.setColor(Color.BLUE);
                                        break;
                                    }
                                }
                            }
                        }).setPositiveButton("确定", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int selected)
                            {
                                dialog.dismiss();
                            }
                        }).create();
                mDialog.show();

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        //获取x坐标
        float x= event.getX();
        float y = event.getY() - 50;

        if(canDraw)
            switch (event.getAction()) {
                case MotionEvent.ACTION_MOVE: {
                    Canvas mCanvas = surfaceHolder.lockCanvas();
                    if (mCanvas != null) {
                        mCanvas.drawLine(x, y, oldX, oldY, mPaint);
                    }
                    surfaceHolder.unlockCanvasAndPost(mCanvas);
                    surfaceHolder.lockCanvas(new Rect(0, 0, 0, 0));
                    surfaceHolder.unlockCanvasAndPost(mCanvas);
                    break;
                }
            }
        oldX=x;
        oldY = y;
        canDraw = true;
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_wall, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

}
