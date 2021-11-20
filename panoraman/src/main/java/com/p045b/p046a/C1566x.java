package com.p045b.p046a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.p045b.p046a.C1559t.C1555d;
import com.p045b.p046a.C1565w.C1564a;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.b.a.x */
public class C1566x {
    /* renamed from: a */
    private static final AtomicInteger f4318a = new AtomicInteger();
    /* renamed from: b */
    private final C1559t f4319b;
    /* renamed from: c */
    private final C1564a f4320c;
    /* renamed from: d */
    private boolean f4321d;
    /* renamed from: e */
    private boolean f4322e;
    /* renamed from: f */
    private boolean f4323f;
    /* renamed from: g */
    private int f4324g;
    /* renamed from: h */
    private int f4325h;
    /* renamed from: i */
    private int f4326i;
    /* renamed from: j */
    private int f4327j;
    /* renamed from: k */
    private Drawable f4328k;
    /* renamed from: l */
    private Drawable f4329l;
    /* renamed from: m */
    private Object f4330m;

    C1566x() {
        this.f4323f = true;
        this.f4319b = null;
        this.f4320c = new C1564a(null, 0, null);
    }

    C1566x(C1559t c1559t, Uri uri, int i) {
        this.f4323f = true;
        if (c1559t.f4270m) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f4319b = c1559t;
        this.f4320c = new C1564a(uri, i, c1559t.f4267j);
    }

    /* renamed from: a */
    private C1565w m7559a(long j) {
        int andIncrement = f4318a.getAndIncrement();
        C1565w d = this.f4320c.mo5789d();
        d.f4300a = andIncrement;
        d.f4301b = j;
        boolean z = this.f4319b.f4269l;
        if (z) {
            C1516ae.m7395a("Main", "created", d.mo5791b(), d.toString());
        }
        C1565w a = this.f4319b.mo5765a(d);
        if (a != d) {
            a.f4300a = andIncrement;
            a.f4301b = j;
            if (z) {
                C1516ae.m7395a("Main", "changed", a.mo5790a(), "into " + a);
            }
        }
        return a;
    }

    /* renamed from: c */
    private Drawable m7560c() {
        return this.f4324g != 0 ? this.f4319b.f4260c.getResources().getDrawable(this.f4324g) : this.f4328k;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public C1566x mo5798a() {
        this.f4322e = false;
        return this;
    }

    /* renamed from: a */
    public C1566x mo5799a(int i) {
        if (!this.f4323f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.f4328k != null) {
            throw new IllegalStateException("Placeholder image already set.");
        } else {
            this.f4324g = i;
            return this;
        }
    }

    /* renamed from: a */
    public C1566x mo5800a(int i, int i2) {
        this.f4320c.mo5785a(i, i2);
        return this;
    }

    /* renamed from: a */
    public void mo5801a(ImageView imageView) {
        mo5802a(imageView, null);
    }

    /* renamed from: a */
    public void mo5802a(ImageView imageView, C1529e c1529e) {
        long nanoTime = System.nanoTime();
        C1516ae.m7391a();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (this.f4320c.mo5786a()) {
            if (this.f4322e) {
                if (this.f4320c.mo5787b()) {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width == 0 || height == 0) {
                    if (this.f4323f) {
                        C1560u.m7543a(imageView, m7560c());
                    }
                    this.f4319b.mo5771a(imageView, new C1533h(this, imageView, c1529e));
                    return;
                }
                this.f4320c.mo5785a(width, height);
            }
            C1565w a = m7559a(nanoTime);
            String a2 = C1516ae.m7389a(a);
            if (C1545p.m7508a(this.f4326i)) {
                Bitmap b = this.f4319b.mo5774b(a2);
                if (b != null) {
                    this.f4319b.mo5770a(imageView);
                    C1560u.m7542a(imageView, this.f4319b.f4260c, b, C1555d.MEMORY, this.f4321d, this.f4319b.f4268k);
                    if (this.f4319b.f4269l) {
                        C1516ae.m7395a("Main", "completed", a.mo5791b(), "from " + C1555d.MEMORY);
                    }
                    if (c1529e != null) {
                        c1529e.mo5721a();
                        return;
                    }
                    return;
                }
            }
            if (this.f4323f) {
                C1560u.m7543a(imageView, m7560c());
            }
            this.f4319b.mo5772a(new C1540l(this.f4319b, imageView, a, this.f4326i, this.f4327j, this.f4325h, this.f4329l, a2, this.f4330m, c1529e, this.f4321d));
        } else {
            this.f4319b.mo5770a(imageView);
            if (this.f4323f) {
                C1560u.m7543a(imageView, m7560c());
            }
        }
    }

    /* renamed from: b */
    public C1566x mo5803b() {
        this.f4320c.mo5788c();
        return this;
    }
}
