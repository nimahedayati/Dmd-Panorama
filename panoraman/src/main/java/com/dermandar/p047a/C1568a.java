package com.dermandar.p047a;

import android.graphics.drawable.Drawable;

/* renamed from: com.dermandar.a.a */
class C1568a implements Comparable<C1568a> {
    /* renamed from: a */
    private Drawable f4332a;
    /* renamed from: b */
    private Drawable f4333b;
    /* renamed from: c */
    private String f4334c;
    /* renamed from: d */
    private String f4335d;
    /* renamed from: e */
    private int f4336e;
    /* renamed from: f */
    private boolean f4337f;
    /* renamed from: g */
    private boolean f4338g;
    /* renamed from: h */
    private int f4339h;

    public C1568a(int i, String str, String str2, Drawable drawable, Drawable drawable2) {
        this.f4336e = -1;
        this.f4338g = true;
        this.f4339h = Integer.MAX_VALUE;
        this.f4334c = str;
        this.f4335d = str2;
        this.f4332a = drawable;
        this.f4336e = i;
        this.f4333b = drawable2;
    }

    /* renamed from: a */
    public int compareTo(C1568a c1568a) {
        return (c1568a == null || this.f4339h < c1568a.f4339h) ? 1 : this.f4339h > c1568a.f4339h ? -1 : 0;
    }

    /* renamed from: a */
    public String mo5805a() {
        return this.f4334c;
    }

    /* renamed from: a */
    public void mo5806a(int i) {
        this.f4339h = i;
    }

    /* renamed from: a */
    public void mo5807a(boolean z) {
        this.f4337f = z;
    }

    /* renamed from: b */
    public String mo5808b() {
        return this.f4335d;
    }

    /* renamed from: c */
    public Drawable mo5809c() {
        return this.f4332a;
    }

    /* renamed from: d */
    public Drawable mo5811d() {
        return this.f4333b;
    }

    /* renamed from: e */
    public int mo5812e() {
        return this.f4336e;
    }

    /* renamed from: f */
    public boolean mo5813f() {
        return this.f4338g;
    }

    /* renamed from: g */
    public boolean mo5814g() {
        return this.f4337f;
    }
}
