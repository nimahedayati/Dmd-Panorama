package com.p045b.p046a;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.p045b.p046a.C1506j.C1507a;
import com.p045b.p046a.C1517y.C1518a;
import com.p045b.p046a.C1559t.C1555d;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.b.a.r */
class C1548r extends C1517y {
    /* renamed from: a */
    private final C1506j f4231a;
    /* renamed from: b */
    private final C1501aa f4232b;

    /* renamed from: com.b.a.r$a */
    static class C1547a extends IOException {
        public C1547a(String str) {
            super(str);
        }
    }

    public C1548r(C1506j c1506j, C1501aa c1501aa) {
        this.f4231a = c1506j;
        this.f4232b = c1501aa;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public int mo5684a() {
        return 2;
    }

    /* renamed from: a */
    public C1518a mo5685a(C1565w c1565w, int i) throws IOException {
        C1507a a = this.f4231a.mo5676a(c1565w.f4303d, c1565w.f4302c);
        if (a == null) {
            return null;
        }
        C1555d c1555d = a.f4131c ? C1555d.DISK : C1555d.NETWORK;
        Bitmap b = a.mo5678b();
        if (b != null) {
            return new C1518a(b, c1555d);
        }
        InputStream a2 = a.mo5677a();
        if (a2 == null) {
            return null;
        }
        if (c1555d == C1555d.DISK && a.mo5679c() == 0) {
            C1516ae.m7393a(a2);
            throw new C1547a("Received response with 0 content-length header.");
        }
        if (c1555d == C1555d.NETWORK && a.mo5679c() > 0) {
            this.f4232b.mo5660a(a.mo5679c());
        }
        return new C1518a(a2, c1555d);
    }

    /* renamed from: a */
    public boolean mo5686a(C1565w c1565w) {
        String scheme = c1565w.f4303d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public boolean mo5687a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public boolean mo5688b() {
        return true;
    }
}
