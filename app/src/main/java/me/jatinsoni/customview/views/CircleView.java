package me.jatinsoni.customview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import me.jatinsoni.customview.R;

public class CircleView extends View {

    private int circleCol, labelCol;
    private String labelText;
    private Paint  circlePaint;

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        circlePaint = new Paint();

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircleView, 0, 0);

        try {
            labelText = a.getString(R.styleable.CircleView_circleLabel);
            circleCol = a.getInteger(R.styleable.CircleView_circleColor, 0);
            labelCol = a.getInteger(R.styleable.CircleView_labelColor, 0);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        int viewWidthHalf  = this.getMeasuredWidth() / 2;
        int viewHeightHalf = this.getMeasuredHeight() / 2;
        int radius         = 0;

        if (viewWidthHalf > viewHeightHalf) {
            radius = viewHeightHalf - 10;
        } else {
            radius = viewWidthHalf - 10;
        }

        // setup circle attrs
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);

        // draw the circle
        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);

        // setup text label attrs
        circlePaint.setColor(labelCol);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(50);

        // draw the text label
        canvas.drawText(labelText, viewWidthHalf, viewHeightHalf, circlePaint);

    }

    public int getCircleCol() {
        return circleCol;
    }

    public void setCircleCol(int circleCol) {
        this.circleCol = circleCol;
        invalidate();
        requestLayout();
    }

    public int getLabelCol() {
        return labelCol;
    }

    public void setLabelCol(int labelCol) {
        this.labelCol = labelCol;
        invalidate();
        requestLayout();
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
        invalidate();
        requestLayout();
    }
}
