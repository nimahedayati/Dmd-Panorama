package com.p045b.p046a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.p045b.p046a.C1559t.C1555d;

/* renamed from: com.b.a.l */
class C1540l extends C1498a<ImageView> {
    /* renamed from: m */
    C1529e f4201m;

    C1540l(C1559t c1559t, ImageView imageView, C1565w c1565w, int i, int i2, int i3, Drawable drawable, String str, Object obj, C1529e c1529e, boolean z) {
        super(c1559t, imageView, c1565w, i, i2, i3, drawable, str, obj, z);
        this.f4201m = c1529e;
    }

    /* renamed from: a */
    public void mo5644a() {
        ImageView imageView = (ImageView) this.f4088c.get();
        if (imageView != null) {
            if (this.f4092g != 0) {
                imageView.setImageResource(this.f4092g);
            } else if (this.f4093h != null) {
                imageView.setImageDrawable(this.f4093h);
            }
            if (this.f4201m != null) {
                this.f4201m.mo5722b();
            }
        }
    }

    /* renamed from: a */
    public void mo5645a(Bitmap bitmap, C1555d c1555d) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
        }
        ImageView imageView = (ImageView) this.f4088c.get();
        if (imageView != null) {
            Bitmap bitmap2 = bitmap;
            C1555d c1555d2 = c1555d;
            C1560u.m7542a(imageView, this.f4086a.f4260c, bitmap2, c1555d2, this.f4089d, this.f4086a.f4268k);
            if (this.f4201m != null) {
                this.f4201m.mo5721a();
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5646b() {
        super.mo5646b();
        if (this.f4201m != null) {
            this.f4201m = null;
        }
    }
}
