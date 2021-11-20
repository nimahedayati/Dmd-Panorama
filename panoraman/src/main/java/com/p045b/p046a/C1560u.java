package com.p045b.p046a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.ImageView;
import com.p045b.p046a.C1559t.C1555d;

/* renamed from: com.b.a.u */
final class C1560u extends BitmapDrawable {
    /* renamed from: e */
    private static final Paint f4275e = new Paint();
    /* renamed from: a */
    Drawable f4276a;
    /* renamed from: b */
    long f4277b;
    /* renamed from: c */
    boolean f4278c;
    /* renamed from: d */
    int f4279d = 255;
    /* renamed from: f */
    private final boolean f4280f;
    /* renamed from: g */
    private final float f4281g;
    /* renamed from: h */
    private final C1555d f4282h;

    C1560u(Context context, Bitmap bitmap, Drawable drawable, C1555d c1555d, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f4280f = z2;
        this.f4281g = context.getResources().getDisplayMetrics().density;
        this.f4282h = c1555d;
        boolean z3 = (c1555d == C1555d.MEMORY || z) ? false : true;
        if (z3) {
            this.f4276a = drawable;
            this.f4278c = true;
            this.f4277b = SystemClock.uptimeMillis();
        }
    }

    /* renamed from: a */
    private static Path m7540a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        return path;
    }

    /* renamed from: a */
    private void m7541a(Canvas canvas) {
        f4275e.setColor(-1);
        canvas.drawPath(C1560u.m7540a(new Point(0, 0), (int) (16.0f * this.f4281g)), f4275e);
        f4275e.setColor(this.f4282h.f4252d);
        canvas.drawPath(C1560u.m7540a(new Point(0, 0), (int) (15.0f * this.f4281g)), f4275e);
    }

    /* renamed from: a */
    static void m7542a(ImageView imageView, Context context, Bitmap bitmap, C1555d c1555d, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new C1560u(context, bitmap, drawable, c1555d, z, z2));
    }

    /* renamed from: a */
    static void m7543a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f4278c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f4277b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f4278c = false;
                this.f4276a = null;
                super.draw(canvas);
            } else {
                if (this.f4276a != null) {
                    this.f4276a.draw(canvas);
                }
                super.setAlpha((int) (uptimeMillis * ((float) this.f4279d)));
                super.draw(canvas);
                super.setAlpha(this.f4279d);
                if (VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f4280f) {
            m7541a(canvas);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f4276a != null) {
            this.f4276a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i) {
        this.f4279d = i;
        if (this.f4276a != null) {
            this.f4276a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f4276a != null) {
            this.f4276a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
