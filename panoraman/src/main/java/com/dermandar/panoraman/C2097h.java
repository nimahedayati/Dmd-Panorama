package com.dermandar.panoraman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.ImageView;

/* renamed from: ir.vira.panoraman.h */
public class C2097h extends ImageView {
    /* renamed from: a */
    private Paint f6289a = new Paint();
    /* renamed from: b */
    private int f6290b = 24;
    /* renamed from: c */
    private boolean f6291c = true;

    public C2097h(Context context) {
        super(context);
        this.f6289a.setColor(-1);
        this.f6289a.setStyle(Style.FILL);
        this.f6289a.setStrokeWidth((float) this.f6290b);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6291c) {
            canvas.drawLine(0.0f, 0.0f, (float) getWidth(), 0.0f, this.f6289a);
            canvas.drawLine(0.0f, (float) getHeight(), (float) getWidth(), (float) getHeight(), this.f6289a);
            canvas.drawLine(0.0f, 0.0f, 0.0f, (float) getHeight(), this.f6289a);
            canvas.drawLine((float) getWidth(), 0.0f, (float) getWidth(), (float) getHeight(), this.f6289a);
        }
    }

    public void setBorderThickness(int i) {
        this.f6290b = i;
        if (this.f6289a != null) {
            this.f6289a.setStrokeWidth((float) this.f6290b);
        }
    }

    public void setIsDrawBorder(boolean z) {
        this.f6291c = z;
    }
}
