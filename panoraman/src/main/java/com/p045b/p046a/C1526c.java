package com.p045b.p046a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import com.p045b.p046a.C1506j.C1508b;
import com.p045b.p046a.C1517y.C1518a;
import com.p045b.p046a.C1548r.C1547a;
import com.p045b.p046a.C1559t.C1555d;
import com.p045b.p046a.C1559t.C1556e;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.b.a.c */
class C1526c implements Runnable {
    /* renamed from: t */
    private static final Object f4151t = new Object();
    /* renamed from: u */
    private static final ThreadLocal<StringBuilder> f4152u = new C15201();
    /* renamed from: v */
    private static final AtomicInteger f4153v = new AtomicInteger();
    /* renamed from: w */
    private static final C1517y f4154w = new C15212();
    /* renamed from: a */
    final int f4155a = f4153v.incrementAndGet();
    /* renamed from: b */
    final C1559t f4156b;
    /* renamed from: c */
    final C1538i f4157c;
    /* renamed from: d */
    final C1527d f4158d;
    /* renamed from: e */
    final C1501aa f4159e;
    /* renamed from: f */
    final String f4160f;
    /* renamed from: g */
    final C1565w f4161g;
    /* renamed from: h */
    final int f4162h;
    /* renamed from: i */
    int f4163i;
    /* renamed from: j */
    final C1517y f4164j;
    /* renamed from: k */
    C1498a f4165k;
    /* renamed from: l */
    List<C1498a> f4166l;
    /* renamed from: m */
    Bitmap f4167m;
    /* renamed from: n */
    Future<?> f4168n;
    /* renamed from: o */
    C1555d f4169o;
    /* renamed from: p */
    Exception f4170p;
    /* renamed from: q */
    int f4171q;
    /* renamed from: r */
    int f4172r;
    /* renamed from: s */
    C1556e f4173s;

    /* renamed from: com.b.a.c$1 */
    static class C15201 extends ThreadLocal<StringBuilder> {
        C15201() {
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    /* renamed from: com.b.a.c$2 */
    static class C15212 extends C1517y {
        C15212() {
        }

        /* renamed from: a */
        public C1518a mo5685a(C1565w c1565w, int i) {
            throw new IllegalStateException("Unrecognized type of request: " + c1565w);
        }

        /* renamed from: a */
        public boolean mo5686a(C1565w c1565w) {
            return true;
        }
    }

    C1526c(C1559t c1559t, C1538i c1538i, C1527d c1527d, C1501aa c1501aa, C1498a c1498a, C1517y c1517y) {
        this.f4156b = c1559t;
        this.f4157c = c1538i;
        this.f4158d = c1527d;
        this.f4159e = c1501aa;
        this.f4165k = c1498a;
        this.f4160f = c1498a.mo5649e();
        this.f4161g = c1498a.mo5647c();
        this.f4173s = c1498a.mo5655k();
        this.f4162h = c1498a.mo5652h();
        this.f4163i = c1498a.mo5653i();
        this.f4164j = c1517y;
        this.f4172r = c1517y.mo5684a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static Bitmap m7423a(C1565w c1565w, Bitmap bitmap, int i) {
        int ceil = 0;
        int i2 = 0;
        int i3 = 0;
        Bitmap createBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z = c1565w.f4311l;
        Matrix matrix = new Matrix();
        if (c1565w.mo5795f()) {
            int i4 = c1565w.f4307h;
            int i5 = c1565w.f4308i;
            float f = c1565w.f4312m;
            if (f != 0.0f) {
                if (c1565w.f4315p) {
                    matrix.setRotate(f, c1565w.f4313n, c1565w.f4314o);
                } else {
                    matrix.setRotate(f);
                }
            }
            float f2;
            if (c1565w.f4309j) {
                int i6;
                int i7;
                f2 = ((float) i4) / ((float) width);
                f = ((float) i5) / ((float) height);
                if (f2 > f) {
                    ceil = (int) Math.ceil((double) ((f / f2) * ((float) height)));
                    f = ((float) i5) / ((float) ceil);
                    i6 = 0;
                    i7 = (height - ceil) / 2;
                    i2 = width;
                } else {
                    ceil = (int) Math.ceil((double) ((f2 / f) * ((float) width)));
                    f2 = ((float) i4) / ((float) ceil);
                    i6 = (width - ceil) / 2;
                    i7 = 0;
                    i2 = ceil;
                    ceil = height;
                }
                if (C1526c.m7428a(z, width, height, i4, i5)) {
                    matrix.preScale(f2, f);
                }
                height = i2;
                i3 = i6;
                i2 = ceil;
                ceil = i7;
            } else if (c1565w.f4310k) {
                f = ((float) i4) / ((float) width);
                f2 = ((float) i5) / ((float) height);
                if (f >= f2) {
                    f = f2;
                }
                if (C1526c.m7428a(z, width, height, i4, i5)) {
                    matrix.preScale(f, f);
                }
                ceil = 0;
                i3 = 0;
                i2 = height;
                height = width;
            } else if (!((i4 == 0 && i5 == 0) || (i4 == width && i5 == height))) {
                f2 = i4 != 0 ? ((float) i4) / ((float) width) : ((float) i5) / ((float) height);
                f = i5 != 0 ? ((float) i5) / ((float) height) : ((float) i4) / ((float) width);
                if (C1526c.m7428a(z, width, height, i4, i5)) {
                    matrix.preScale(f2, f);
                }
            }
            if (i != 0) {
                matrix.preRotate((float) i);
            }
            createBitmap = Bitmap.createBitmap(bitmap, i3, ceil, height, i2, matrix, true);
            if (createBitmap != bitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        }
        ceil = 0;
        i3 = 0;
        i2 = height;
        height = width;
        if (i != 0) {
        }
        createBitmap = Bitmap.createBitmap(bitmap, i3, ceil, height, i2, matrix, true);
        if (createBitmap != bitmap) {
        }
        return null;
    }

    /* renamed from: a */
    static Bitmap m7424a(InputStream inputStream, C1565w c1565w) throws IOException {
        C1542n c1542n = new C1542n(inputStream);
        long a = c1542n.mo5748a(65536);
        Options c = C1517y.m7407c(c1565w);
        boolean a2 = C1517y.m7406a(c);
        boolean c2 = C1516ae.m7402c(c1542n);
        c1542n.mo5749a(a);
        if (c2) {
            byte[] b = C1516ae.m7400b(c1542n);
            if (a2) {
                BitmapFactory.decodeByteArray(b, 0, b.length, c);
                C1517y.m7405a(c1565w.f4307h, c1565w.f4308i, c, c1565w);
            }
            return BitmapFactory.decodeByteArray(b, 0, b.length, c);
        }
        if (a2) {
            BitmapFactory.decodeStream(c1542n, null, c);
            C1517y.m7405a(c1565w.f4307h, c1565w.f4308i, c, c1565w);
            c1542n.mo5749a(a);
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(c1542n, null, c);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    /* renamed from: a */
    static Bitmap m7425a(List<C1503ac> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        Bitmap bitmap2 = bitmap;
        while (i < size) {
            final C1503ac c1503ac = (C1503ac) list.get(i);
            try {
                bitmap = c1503ac.mo5672a(bitmap2);
                if (bitmap == null) {
                    final StringBuilder append = new StringBuilder().append("Transformation ").append(c1503ac.mo5673a()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
                    for (C1503ac c1503ac2 : list) {
                        append.append(c1503ac2.mo5673a()).append(10);
                    }
                    C1559t.f4258a.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(append.toString());
                        }
                    });
                    return null;
                } else if (bitmap == bitmap2 && bitmap2.isRecycled()) {
                    C1559t.f4258a.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + c1503ac.mo5673a() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                } else if (bitmap == bitmap2 || bitmap2.isRecycled()) {
                    i++;
                    bitmap2 = bitmap;
                } else {
                    C1559t.f4258a.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + c1503ac.mo5673a() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
            } catch (final RuntimeException e) {
                C1559t.f4258a.post(new Runnable() {
                    public void run() {
                        throw new RuntimeException("Transformation " + c1503ac.mo5673a() + " crashed with exception.", e);
                    }
                });
                return null;
            }
        }
        return bitmap2;
    }

    /* renamed from: a */
    static C1526c m7426a(C1559t c1559t, C1538i c1538i, C1527d c1527d, C1501aa c1501aa, C1498a c1498a) {
        C1565w c = c1498a.mo5647c();
        List a = c1559t.mo5769a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            C1517y c1517y = (C1517y) a.get(i);
            if (c1517y.mo5686a(c)) {
                return new C1526c(c1559t, c1538i, c1527d, c1501aa, c1498a, c1517y);
            }
        }
        return new C1526c(c1559t, c1538i, c1527d, c1501aa, c1498a, f4154w);
    }

    /* renamed from: a */
    static void m7427a(C1565w c1565w) {
        String c = c1565w.mo5792c();
        StringBuilder stringBuilder = (StringBuilder) f4152u.get();
        stringBuilder.ensureCapacity("Picasso-".length() + c.length());
        stringBuilder.replace("Picasso-".length(), stringBuilder.length(), c);
        Thread.currentThread().setName(stringBuilder.toString());
    }

    /* renamed from: a */
    private static boolean m7428a(boolean z, int i, int i2, int i3, int i4) {
        return !z || i > i3 || i2 > i4;
    }

    /* renamed from: o */
    private C1556e m7429o() {
        int i = 1;
        int i2 = 0;
        C1556e c1556e = C1556e.LOW;
        int i3 = (this.f4166l == null || this.f4166l.isEmpty()) ? 0 : 1;
        if (this.f4165k == null && i3 == 0) {
            i = 0;
        }
        if (i == 0) {
            return c1556e;
        }
        C1556e k = this.f4165k != null ? this.f4165k.mo5655k() : c1556e;
        if (i3 == 0) {
            return k;
        }
        int size = this.f4166l.size();
        while (i2 < size) {
            C1556e k2 = ((C1498a) this.f4166l.get(i2)).mo5655k();
            if (k2.ordinal() <= k.ordinal()) {
                k2 = k;
            }
            i2++;
            k = k2;
        }
        return k;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public Bitmap mo5699a() throws Throwable {
        Bitmap bitmap = null;
        if (C1545p.m7508a(this.f4162h)) {
            bitmap = this.f4158d.mo5718a(this.f4160f);
            if (bitmap != null) {
                this.f4159e.mo5659a();
                this.f4169o = C1555d.MEMORY;
                if (this.f4156b.f4269l) {
                    C1516ae.m7395a("Hunter", "decoded", this.f4161g.mo5790a(), "from cache");
                }
                return bitmap;
            }
        }
        this.f4161g.f4302c = this.f4172r == 0 ? C1546q.OFFLINE.f4230d : this.f4163i;
        C1518a a = this.f4164j.mo5685a(this.f4161g, this.f4163i);
        if (a != null) {
            this.f4169o = a.mo5691c();
            this.f4171q = a.mo5692d();
            bitmap = a.mo5689a();
            if (bitmap == null) {
                InputStream b = a.mo5690b();
                try {
                    bitmap = C1526c.m7424a(b, this.f4161g);
                } finally {
                    C1516ae.m7393a(b);
                }
            }
        }
        if (bitmap != null) {
            if (this.f4156b.f4269l) {
                C1516ae.m7394a("Hunter", "decoded", this.f4161g.mo5790a());
            }
            this.f4159e.mo5661a(bitmap);
            if (this.f4161g.mo5794e() || this.f4171q != 0) {
                synchronized (f4151t) {
                    if (this.f4161g.mo5795f() || this.f4171q != 0) {
                        bitmap = C1526c.m7423a(this.f4161g, bitmap, this.f4171q);
                        if (this.f4156b.f4269l) {
                            C1516ae.m7394a("Hunter", "transformed", this.f4161g.mo5790a());
                        }
                    }
                    if (this.f4161g.mo5796g()) {
                        bitmap = C1526c.m7425a(this.f4161g.f4306g, bitmap);
                        if (this.f4156b.f4269l) {
                            C1516ae.m7395a("Hunter", "transformed", this.f4161g.mo5790a(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.f4159e.mo5665b(bitmap);
                }
            }
        }
        return bitmap;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5700a(C1498a c1498a) {
        boolean z = this.f4156b.f4269l;
        C1565w c1565w = c1498a.f4087b;
        if (this.f4165k == null) {
            this.f4165k = c1498a;
            if (!z) {
                return;
            }
            if (this.f4166l == null || this.f4166l.isEmpty()) {
                C1516ae.m7395a("Hunter", "joined", c1565w.mo5790a(), "to empty hunter");
                return;
            } else {
                C1516ae.m7395a("Hunter", "joined", c1565w.mo5790a(), C1516ae.m7388a(this, "to "));
                return;
            }
        }
        if (this.f4166l == null) {
            this.f4166l = new ArrayList(3);
        }
        this.f4166l.add(c1498a);
        if (z) {
            C1516ae.m7395a("Hunter", "joined", c1565w.mo5790a(), C1516ae.m7388a(this, "to "));
        }
        C1556e k = c1498a.mo5655k();
        if (k.ordinal() > this.f4173s.ordinal()) {
            this.f4173s = k;
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public boolean mo5701a(boolean z, NetworkInfo networkInfo) {
        if (!(this.f4172r > 0)) {
            return false;
        }
        this.f4172r--;
        return this.f4164j.mo5687a(z, networkInfo);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5702b(C1498a c1498a) {
        boolean z = false;
        if (this.f4165k == c1498a) {
            this.f4165k = null;
            z = true;
        } else if (this.f4166l != null) {
            z = this.f4166l.remove(c1498a);
        }
        if (z && c1498a.mo5655k() == this.f4173s) {
            this.f4173s = m7429o();
        }
        if (this.f4156b.f4269l) {
            C1516ae.m7395a("Hunter", "removed", c1498a.f4087b.mo5790a(), C1516ae.m7388a(this, "from "));
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public boolean mo5703b() {
        return this.f4165k == null ? (this.f4166l == null || this.f4166l.isEmpty()) && this.f4168n != null && this.f4168n.cancel(false) : false;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public boolean mo5704c() {
        return this.f4168n != null && this.f4168n.isCancelled();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public boolean mo5705d() {
        return this.f4164j.mo5688b();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: e */
    public Bitmap mo5706e() {
        return this.f4167m;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: f */
    public String mo5707f() {
        return this.f4160f;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: g */
    public int mo5708g() {
        return this.f4162h;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: h */
    public C1565w mo5709h() {
        return this.f4161g;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: i */
    public C1498a mo5710i() {
        return this.f4165k;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: j */
    public C1559t mo5711j() {
        return this.f4156b;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: k */
    public List<C1498a> mo5712k() {
        return this.f4166l;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: l */
    public Exception mo5713l() {
        return this.f4170p;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: m */
    public C1555d mo5714m() {
        return this.f4169o;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: n */
    public C1556e mo5715n() {
        return this.f4173s;
    }

    public void run() {
        try {
            C1526c.m7427a(this.f4161g);
            if (this.f4156b.f4269l) {
                C1516ae.m7394a("Hunter", "executing", C1516ae.m7387a(this));
            }
            this.f4167m = mo5699a();
            if (this.f4167m == null) {
                this.f4157c.mo5744c(this);
            } else {
                this.f4157c.mo5734a(this);
            }
            Thread.currentThread().setName("Picasso-Idle");
        } catch (C1508b e) {
            if (!(e.f4133a && e.f4134b == 504)) {
                this.f4170p = e;
            }
            this.f4157c.mo5744c(this);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (C1547a e2) {
            this.f4170p = e2;
            this.f4157c.mo5740b(this);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (IOException e3) {
            this.f4170p = e3;
            this.f4157c.mo5740b(this);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (OutOfMemoryError e4) {
            StringWriter stringWriter = new StringWriter();
            this.f4159e.mo5669e().mo5670a(new PrintWriter(stringWriter));
            this.f4170p = new RuntimeException(stringWriter.toString(), e4);
            this.f4157c.mo5744c(this);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Exception e5) {
            this.f4170p = e5;
            this.f4157c.mo5744c(this);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }
}
