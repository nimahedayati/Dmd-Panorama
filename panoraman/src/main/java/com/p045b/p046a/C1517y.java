package com.p045b.p046a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.p045b.p046a.C1559t.C1555d;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.b.a.y */
public abstract class C1517y {

    /* renamed from: com.b.a.y$a */
    public static final class C1518a {
        /* renamed from: a */
        private final C1555d f4140a;
        /* renamed from: b */
        private final Bitmap f4141b;
        /* renamed from: c */
        private final InputStream f4142c;
        /* renamed from: d */
        private final int f4143d;

        public C1518a(Bitmap bitmap, C1555d c1555d) {
            this((Bitmap) C1516ae.m7386a((Object) bitmap, "bitmap == null"), null, c1555d, 0);
        }

        C1518a(Bitmap bitmap, InputStream inputStream, C1555d c1555d, int i) {
            int i2 = 1;
            int i3 = bitmap != null ? 1 : 0;
            if (inputStream == null) {
                i2 = 0;
            }
            if ((i2 ^ i3) == 0) {
                throw new AssertionError();
            }
            this.f4141b = bitmap;
            this.f4142c = inputStream;
            this.f4140a = (C1555d) C1516ae.m7386a((Object) c1555d, "loadedFrom == null");
            this.f4143d = i;
        }

        public C1518a(InputStream inputStream, C1555d c1555d) {
            this(null, (InputStream) C1516ae.m7386a((Object) inputStream, "stream == null"), c1555d, 0);
        }

        /* renamed from: a */
        public Bitmap mo5689a() {
            return this.f4141b;
        }

        /* renamed from: b */
        public InputStream mo5690b() {
            return this.f4142c;
        }

        /* renamed from: c */
        public C1555d mo5691c() {
            return this.f4140a;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: d */
        public int mo5692d() {
            return this.f4143d;
        }
    }

    /* renamed from: a */
    static void m7404a(int i, int i2, int i3, int i4, Options options, C1565w c1565w) {
        int i5 = 1;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                i5 = (int) Math.floor((double) (((float) i3) / ((float) i)));
            } else if (i == 0) {
                i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
            } else {
                i5 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor = (int) Math.floor((double) (((float) i3) / ((float) i)));
                i5 = c1565w.f4310k ? Math.max(i5, floor) : Math.min(i5, floor);
            }
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }

    /* renamed from: a */
    static void m7405a(int i, int i2, Options options, C1565w c1565w) {
        C1517y.m7404a(i, i2, options.outWidth, options.outHeight, options, c1565w);
    }

    /* renamed from: a */
    static boolean m7406a(Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    /* renamed from: c */
    static Options m7407c(C1565w c1565w) {
        boolean d = c1565w.mo5793d();
        Object obj = c1565w.f4316q != null ? 1 : null;
        Options options = null;
        if (d || obj != null) {
            options = new Options();
            options.inJustDecodeBounds = d;
            if (obj != null) {
                options.inPreferredConfig = c1565w.f4316q;
            }
        }
        return options;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public int mo5684a() {
        return 0;
    }

    /* renamed from: a */
    public abstract C1518a mo5685a(C1565w c1565w, int i) throws Throwable;

    /* renamed from: a */
    public abstract boolean mo5686a(C1565w c1565w);

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public boolean mo5687a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public boolean mo5688b() {
        return false;
    }
}
