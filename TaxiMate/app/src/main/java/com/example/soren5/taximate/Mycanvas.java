package com.example.soren5.taximate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;

public class Mycanvas extends SurfaceView {
    Paint paint;

    public  Mycanvas (Context context) {
        super(context);
        paint = new Paint();



    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        drawRectangles(canvas);
        drawText(canvas);
        drawLine(canvas);

    }
    private void drawRectangles(Canvas canvas){
        paint.setColor(Color.rgb(255,255,102));
        canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(),paint);
        paint.setColor(Color.rgb(169,169,169));
        canvas.drawRect(0,140,canvas.getWidth(),160,paint);
        canvas.drawRect(0,250,canvas.getWidth(),500,paint);
        canvas.drawRect(0,660-70,canvas.getWidth(),750-70,paint);
        canvas.drawRect(0,840-70,canvas.getWidth(),930-70,paint);
        canvas.drawRect(0,1020-70,canvas.getWidth(),1110-70,paint);
    }
    private void drawText(Canvas canvas){
        paint.setTextSize(50f);
        paint.setColor(Color.rgb(0,0,0));
        canvas.drawText("TRAJETO",20,220,paint);
        canvas.drawText("CIDADE\",20,550,paint);\n" +
                "        canvas.drawText(\"DATA",20,750,paint);
        canvas.drawText("HORA",20,930,paint);


    }
    private void drawLine(Canvas canvas){

    }

}
