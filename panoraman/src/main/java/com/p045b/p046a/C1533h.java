package com.p045b.p046a;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* renamed from: com.b.a.h */
class C1533h implements OnPreDrawListener {
    /* renamed from: a */
    final C1566x f4178a;
    /* renamed from: b */
    final WeakReference<ImageView> f4179b;
    /* renamed from: c */
    C1529e f4180c;

    C1533h(C1566x c1566x, ImageView imageView, C1529e c1529e) {
        this.f4178a = c1566x;
        this.f4179b = new WeakReference(imageView);
        this.f4180c = c1529e;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5724a() {
        this.f4180c = null;
        ImageView imageView = (ImageView) this.f4179b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f4179b.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width > 0 && height > 0) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                    this.f4178a.mo5798a().mo5800a(width, height).mo5802a(imageView, this.f4180c);
                }
            }
        }
        return true;
    }
}
