package com.p045b.p046a;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import com.p045b.p046a.C1559t.C1556e;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.b.a.w */
public final class C1565w {
    /* renamed from: s */
    private static final long f4299s = TimeUnit.SECONDS.toNanos(5);
    /* renamed from: a */
    int f4300a;
    /* renamed from: b */
    long f4301b;
    /* renamed from: c */
    int f4302c;
    /* renamed from: d */
    public final Uri f4303d;
    /* renamed from: e */
    public final int f4304e;
    /* renamed from: f */
    public final String f4305f;
    /* renamed from: g */
    public final List<C1503ac> f4306g;
    /* renamed from: h */
    public final int f4307h;
    /* renamed from: i */
    public final int f4308i;
    /* renamed from: j */
    public final boolean f4309j;
    /* renamed from: k */
    public final boolean f4310k;
    /* renamed from: l */
    public final boolean f4311l;
    /* renamed from: m */
    public final float f4312m;
    /* renamed from: n */
    public final float f4313n;
    /* renamed from: o */
    public final float f4314o;
    /* renamed from: p */
    public final boolean f4315p;
    /* renamed from: q */
    public final Config f4316q;
    /* renamed from: r */
    public final C1556e f4317r;

    /* renamed from: com.b.a.w$a */
    public static final class C1564a {
        /* renamed from: a */
        private Uri f4284a;
        /* renamed from: b */
        private int f4285b;
        /* renamed from: c */
        private String f4286c;
        /* renamed from: d */
        private int f4287d;
        /* renamed from: e */
        private int f4288e;
        /* renamed from: f */
        private boolean f4289f;
        /* renamed from: g */
        private boolean f4290g;
        /* renamed from: h */
        private boolean f4291h;
        /* renamed from: i */
        private float f4292i;
        /* renamed from: j */
        private float f4293j;
        /* renamed from: k */
        private float f4294k;
        /* renamed from: l */
        private boolean f4295l;
        /* renamed from: m */
        private List<C1503ac> f4296m;
        /* renamed from: n */
        private Config f4297n;
        /* renamed from: o */
        private C1556e f4298o;

        C1564a(Uri uri, int i, Config config) {
            this.f4284a = uri;
            this.f4285b = i;
            this.f4297n = config;
        }

        /* renamed from: a */
        public C1564a mo5785a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f4287d = i;
                this.f4288e = i2;
                return this;
            }
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public boolean mo5786a() {
            return (this.f4284a == null && this.f4285b == 0) ? false : true;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: b */
        public boolean mo5787b() {
            return (this.f4287d == 0 && this.f4288e == 0) ? false : true;
        }

        /* renamed from: c */
        public C1564a mo5788c() {
            if (this.f4290g) {
                throw new IllegalStateException("Center crop can not be used after calling centerInside");
            }
            this.f4289f = true;
            return this;
        }

        /* renamed from: d */
        public C1565w mo5789d() {
            if (this.f4290g && this.f4289f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f4289f && this.f4287d == 0 && this.f4288e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            } else if (this.f4290g && this.f4287d == 0 && this.f4288e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            } else {
                if (this.f4298o == null) {
                    this.f4298o = C1556e.NORMAL;
                }
                return new C1565w(this.f4284a, this.f4285b, this.f4286c, this.f4296m, this.f4287d, this.f4288e, this.f4289f, this.f4290g, this.f4291h, this.f4292i, this.f4293j, this.f4294k, this.f4295l, this.f4297n, this.f4298o);
            }
        }
    }

    private C1565w(Uri uri, int i, String str, List<C1503ac> list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Config config, C1556e c1556e) {
        this.f4303d = uri;
        this.f4304e = i;
        this.f4305f = str;
        if (list == null) {
            this.f4306g = null;
        } else {
            this.f4306g = Collections.unmodifiableList(list);
        }
        this.f4307h = i2;
        this.f4308i = i3;
        this.f4309j = z;
        this.f4310k = z2;
        this.f4311l = z3;
        this.f4312m = f;
        this.f4313n = f2;
        this.f4314o = f3;
        this.f4315p = z4;
        this.f4316q = config;
        this.f4317r = c1556e;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public String mo5790a() {
        long nanoTime = System.nanoTime() - this.f4301b;
        return nanoTime > f4299s ? mo5791b() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's' : mo5791b() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public String mo5791b() {
        return "[R" + this.f4300a + ']';
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public String mo5792c() {
        return this.f4303d != null ? String.valueOf(this.f4303d.getPath()) : Integer.toHexString(this.f4304e);
    }

    /* renamed from: d */
    public boolean mo5793d() {
        return (this.f4307h == 0 && this.f4308i == 0) ? false : true;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: e */
    public boolean mo5794e() {
        return mo5795f() || mo5796g();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: f */
    public boolean mo5795f() {
        return mo5793d() || this.f4312m != 0.0f;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: g */
    public boolean mo5796g() {
        return this.f4306g != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{");
        if (this.f4304e > 0) {
            stringBuilder.append(this.f4304e);
        } else {
            stringBuilder.append(this.f4303d);
        }
        if (!(this.f4306g == null || this.f4306g.isEmpty())) {
            for (C1503ac a : this.f4306g) {
                stringBuilder.append(' ').append(a.mo5673a());
            }
        }
        if (this.f4305f != null) {
            stringBuilder.append(" stableKey(").append(this.f4305f).append(')');
        }
        if (this.f4307h > 0) {
            stringBuilder.append(" resize(").append(this.f4307h).append(',').append(this.f4308i).append(')');
        }
        if (this.f4309j) {
            stringBuilder.append(" centerCrop");
        }
        if (this.f4310k) {
            stringBuilder.append(" centerInside");
        }
        if (this.f4312m != 0.0f) {
            stringBuilder.append(" rotation(").append(this.f4312m);
            if (this.f4315p) {
                stringBuilder.append(" @ ").append(this.f4313n).append(',').append(this.f4314o);
            }
            stringBuilder.append(')');
        }
        if (this.f4316q != null) {
            stringBuilder.append(' ').append(this.f4316q);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
