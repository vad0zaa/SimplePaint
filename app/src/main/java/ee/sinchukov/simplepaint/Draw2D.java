package ee.sinchukov.simplepaint;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

        // Выводим значок из ресурсов
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.cat_bottom_small);

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
        canvas.drawRect(130, 130, 400, 150, mPaint);

        // Рисуем красный круг
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(230, 230, 45, mPaint);

        // Рисуем синий прямоугольник
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(300, 350, 500, 540, mPaint);

        // Рисуем текст
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(10);
        canvas.drawText("Лужайка только для котов", 150, 150, mPaint);

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

        // Выводим изображение
        canvas.drawBitmap(mBitmap, 150, 10, mPaint);



    }
}

