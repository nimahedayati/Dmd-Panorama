package com.p045b.p046a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.p045b.p046a.C1559t.C1555d;
import com.p045b.p046a.C1559t.C1556e;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.b.a.a */
abstract class C1498a<T> {
    /* renamed from: a */
    final C1559t f4086a;
    /* renamed from: b */
    final C1565w f4087b;
    /* renamed from: c */
    final WeakReference<T> f4088c;
    /* renamed from: d */
    final boolean f4089d;
    /* renamed from: e */
    final int f4090e;
    /* renamed from: f */
    final int f4091f;
    /* renamed from: g */
    final int f4092g;
    /* renamed from: h */
    final Drawable f4093h;
    /* renamed from: i */
    final String f4094i;
    /* renamed from: j */
    final Object f4095j;
    /* renamed from: k */
    boolean f4096k;
    /* renamed from: l */
    boolean f4097l;

    /* renamed from: com.b.a.a$a */
    static class C1497a<M> extends WeakReference<M> {
        /* renamed from: a */
        final C1498a f4085a;

        public C1497a(C1498a c1498a, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f4085a = c1498a;
        }
    }

    C1498a(C1559t c1559t, T t, C1565w c1565w, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.f4086a = c1559t;
        this.f4087b = c1565w;
        this.f4088c = t == null ? null : new C1497a(this, t, c1559t.f4266i);
        this.f4090e = i;
        this.f4091f = i2;
        this.f4089d = z;
        this.f4092g = i3;
        this.f4093h = drawable;
        this.f4094i = str;
        if (obj == null) {
            obj = this;
        }
        this.f4095j = obj;
    }

    /* renamed from: a */
    public abstract void mo5644a();

    /* renamed from: a */
    public abstract void mo5645a(Bitmap bitmap, C1555d c1555d);

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5646b() {
        this.f4097l = true;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public C1565w mo5647c() {
        return this.f4087b;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public T mo5648d() {
        return this.f4088c == null ? null : this.f4088c.get();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: e */
    public String mo5649e() {
        return this.f4094i;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: f */
    public boolean mo5650f() {
        return this.f4097l;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: g */
    public boolean mo5651g() {
        return this.f4096k;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: h */
    public int mo5652h() {
        return this.f4090e;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: i */
    public int mo5653i() {
        return this.f4091f;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: j */
    public C1559t mo5654j() {
        return this.f4086a;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: k */
    public C1556e mo5655k() {
        return this.f4087b.f4317r;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: l */
    public Object mo5656l() {
        return this.f4095j;
    }
}
