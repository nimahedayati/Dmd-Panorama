package com.dermandar.panoraman.p050a.p051a;

/* renamed from: com.dermandar.panoraman.a.a.d */
public class C2035d {
    /* renamed from: a */
    int f6045a;
    /* renamed from: b */
    String f6046b;

    public C2035d(int i, String str) {
        this.f6045a = i;
        if (str == null || str.trim().length() == 0) {
            this.f6046b = C2034c.m9124a(i);
        } else {
            this.f6046b = str + " (response: " + C2034c.m9124a(i) + ")";
        }
    }

    /* renamed from: a */
    public String mo6773a() {
        return this.f6046b;
    }

    /* renamed from: b */
    public boolean mo6774b() {
        return this.f6045a == 0;
    }

    /* renamed from: c */
    public boolean mo6775c() {
        return !mo6774b();
    }

    public String toString() {
        return "IabResult: " + mo6773a();
    }
}
