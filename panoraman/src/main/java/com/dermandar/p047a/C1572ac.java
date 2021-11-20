package com.dermandar.p047a;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* renamed from: com.dermandar.a.ac */
class C1572ac {
    /* renamed from: a */
    protected Context f4342a;
    /* renamed from: b */
    protected PopupWindow f4343b;
    /* renamed from: c */
    protected View f4344c;
    /* renamed from: d */
    protected Drawable f4345d = null;
    /* renamed from: e */
    protected WindowManager f4346e;

    /* renamed from: com.dermandar.a.ac$1 */
    class C15711 implements OnTouchListener {
        C15711() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 4) {
                return false;
            }
            C1572ac.this.f4343b.dismiss();
            return true;
        }
    }

    public C1572ac(Context context) {
        this.f4342a = context;
        this.f4343b = new PopupWindow(context);
        this.f4343b.setTouchInterceptor(new C15711());
        this.f4346e = (WindowManager) context.getSystemService("window");
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo5816a() {
    }

    /* renamed from: a */
    public void mo5817a(View view) {
        this.f4344c = view;
        this.f4343b.setContentView(view);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo5818b() {
        if (this.f4344c == null) {
            throw new IllegalStateException("setContentView was not called with a view to display.");
        }
        mo5816a();
        if (this.f4345d == null) {
            this.f4343b.setBackgroundDrawable(new BitmapDrawable(this.f4342a.getResources()));
        } else {
            this.f4343b.setBackgroundDrawable(this.f4345d);
        }
        this.f4343b.setWidth(-2);
        this.f4343b.setHeight(-2);
        this.f4343b.setTouchable(true);
        this.f4343b.setFocusable(true);
        this.f4343b.setOutsideTouchable(true);
        this.f4343b.setContentView(this.f4344c);
    }

    /* renamed from: c */
    public void mo5819c() {
        this.f4343b.dismiss();
    }

    /* Access modifiers changed, original: protected */
    public void onDismiss() {
    }
}
