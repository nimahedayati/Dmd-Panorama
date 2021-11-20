package com.dermandar.p047a;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;

/* renamed from: com.dermandar.a.g */
public class C1618g extends TextureView {
    /* renamed from: a */
    private int f4503a;
    /* renamed from: b */
    private int f4504b;

    public C1618g(Context context) {
        this(context, null);
    }

    public C1618g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1618g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4503a = 0;
        this.f4504b = 0;
    }

    /* renamed from: a */
    public void mo5951a(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        this.f4503a = i;
        this.f4504b = i2;
        requestLayout();
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.e("rmh", "attached");
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.e("rmh", "deta");
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f4503a == 0 || this.f4504b == 0) {
            setMeasuredDimension(size, size2);
        } else if (size < (this.f4503a * size2) / this.f4504b) {
            setMeasuredDimension(size, (this.f4504b * size) / this.f4503a);
        } else {
            setMeasuredDimension((this.f4503a * size2) / this.f4504b, size2);
        }
    }
}
