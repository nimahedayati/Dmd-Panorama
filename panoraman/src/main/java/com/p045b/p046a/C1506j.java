package com.p045b.p046a;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.b.a.j */
public interface C1506j {

    /* renamed from: com.b.a.j$a */
    public static class C1507a {
        /* renamed from: a */
        final InputStream f4129a;
        /* renamed from: b */
        final Bitmap f4130b;
        /* renamed from: c */
        final boolean f4131c;
        /* renamed from: d */
        final long f4132d;

        public C1507a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f4129a = inputStream;
            this.f4130b = null;
            this.f4131c = z;
            this.f4132d = j;
        }

        /* renamed from: a */
        public InputStream mo5677a() {
            return this.f4129a;
        }

        @Deprecated
        /* renamed from: b */
        public Bitmap mo5678b() {
            return this.f4130b;
        }

        /* renamed from: c */
        public long mo5679c() {
            return this.f4132d;
        }
    }

    /* renamed from: com.b.a.j$b */
    public static class C1508b extends IOException {
        /* renamed from: a */
        final boolean f4133a;
        /* renamed from: b */
        final int f4134b;

        public C1508b(String str, int i, int i2) {
            super(str);
            this.f4133a = C1546q.m7512c(i);
            this.f4134b = i2;
        }
    }

    /* renamed from: a */
    C1507a mo5676a(Uri uri, int i) throws IOException;
}
