package com.dermandar.p047a;

import android.content.Context;
import ir.helmik.namya.R;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.dermandar.a.ak */
class C1607ak implements C1605ai {
    /* renamed from: a */
    private List<C1748t> f4481a = new ArrayList();
    /* renamed from: b */
    private C1748t f4482b = new C1748t(0, String.valueOf(0), "this.f4483c.getString(R.string.fav)", this.f4483c.getResources().getDrawable(R.drawable.fav), this.f4483c.getResources().getDrawable(R.drawable.fav), 0);
    /* renamed from: c */
    private Context f4483c;

    public C1607ak(Context context) {
        this.f4483c = context;
        this.f4481a.add(new C1748t(1, String.valueOf(1), "this.f4483c.getString(R.string.fav)", this.f4483c.getResources().getDrawable(R.drawable.fav), this.f4483c.getResources().getDrawable(R.drawable.fav), 1));
        this.f4481a.add(new C1748t(6, String.valueOf(6), "this.f4483c.getString(R.string.fav)", this.f4483c.getResources().getDrawable(R.drawable.fav), this.f4483c.getResources().getDrawable(R.drawable.fav), 2));
        this.f4481a.add(new C1748t(5, String.valueOf(5), "this.f4483c.getString(R.string.fav)", this.f4483c.getResources().getDrawable(R.drawable.fav), this.f4483c.getResources().getDrawable(R.drawable.fav), 3));
        this.f4481a.add(new C1748t(3, String.valueOf(3), "this.f4483c.getString(R.string.fav)", this.f4483c.getResources().getDrawable(R.drawable.fav), this.f4483c.getResources().getDrawable(R.drawable.fav), 4));
        this.f4481a.add(new C1748t(2, String.valueOf(2), "this.f4483c.getString(R.string.fav)", this.f4483c.getResources().getDrawable(R.drawable.fav), this.f4483c.getResources().getDrawable(R.drawable.fav), 5));
    }

    /* renamed from: a */
    public C1748t mo5905a() {
        return this.f4482b;
    }

    /* renamed from: a */
    public C1748t mo5906a(String str) {
        for (C1748t c1748t : this.f4481a) {
            if (c1748t.mo6267d().equals(str)) {
                return c1748t;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String mo5907a(int i) {
        return null;
    }
}
