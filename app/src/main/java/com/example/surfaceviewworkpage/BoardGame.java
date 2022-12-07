package com.example.surfaceviewworkpage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class BoardGame extends SurfaceView implements Runnable {


    Context context;
    SurfaceHolder holder;

    boolean threadRunning = true;
    boolean isRunning = true;

    float cordX = 100;
    float cordY = 100;
    float deltaX = 10;
    float deltaY = 10;

    Paint p;

    int size = 100;



    public BoardGame(Context context) {
        super(context);
        this.context = context;
        holder = getHolder();


        p = new Paint();

        p.setColor(Color.BLUE);


    }






    @Override
    public void run() {
        while(threadRunning){
            if (isRunning){

                if (!holder.getSurface().isValid())
                    continue;
                Canvas c =null;

                try {
                    c = this.getHolder().lockCanvas();
                    synchronized (this.getHolder()) {
                        c.drawRGB(100, 100, 250);


                        c.drawRect(cordX, cordY, cordX + size, cordY + size, p);

                        cordX += deltaX;
                        cordY += deltaY;


                        if (cordX < 0 ){
                            deltaX = -deltaX;
                            p.setColor(Color.BLUE);
                        }

                        if (cordX > this.getWidth() - 100){
                            deltaX = -deltaX;
                            p.setColor(Color.RED);
                        }


                        if(cordY < 0) {
                            deltaY = -deltaY;
                            p.setColor(Color.BLACK);
                        }

                        if (cordY > this.getHeight()-100){
                            deltaY = -deltaY;
                            p.setColor(Color.rgb(242, 163, 15));
                        }

                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    if (c != null)
                    {
                        this.getHolder().unlockCanvasAndPost(c);

                    }

                }


            }
        }

    }
}
