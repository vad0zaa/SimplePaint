package ee.sinchukov.simplepaint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by user_39 on 16.04.2015.
 */
public class Draw2D extends View {

    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;

    public Draw2D(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);

        // закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        // Рисуем желтый круг
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(30, 30, 25, mPaint);

        // Рисуем зеленый прямоугольник
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(100, 100, 400, 120, mPaint);

        // Рисуем текст
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(10);
        canvas.drawText("Лужайка только для котов", 120, 120, mPaint);

        // Текст под углом
        int x = 50;
        int y = 50;

        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(11);
        String str2rotate = "Лучик солнца!";

// Создаем ограничивающий прямоугольник для наклонного текста
// поворачиваем холст по центру текста
        canvas.rotate(45, x + mRect.exactCenterX(), y + mRect.exactCenterY());
// Рисуем текст
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2rotate, x, y, mPaint);
// восстанавливаем холст
        canvas.restore();




    }
}

