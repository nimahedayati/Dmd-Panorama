package com.dermandar.p047a;

import android.content.Context;


import com.dermandar.panoraman.R;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.dermandar.a.aj */
class C1606aj implements C1605ai {
    /* renamed from: a */
    private List<C1748t> f4478a = new ArrayList();
    /* renamed from: b */
    private C1748t f4479b ;
    /* renamed from: c */
    private Context f4480c;

    public C1606aj(Context context) {
        this.f4480c = context;
        int i = 1;
         f4479b = new C1748t(0, "auto", "this.f4480c.getString(R.string.fav)", this.f4480c.getResources().getDrawable(R.drawable.fav), this.f4480c.getResources().getDrawable(R.drawable.fav), 0);
        this.f4478a.add(new C1748t(i, "auto", "this.f4480c.getString(R.string.wb_auto)", this.f4480c.getResources().getDrawable(R.drawable.fav), this.f4480c.getResources().getDrawable(R.drawable.fav), 1));
        i = 2;
        this.f4478a.add(new C1748t(i, "cloudy-daylight", "this.f4480c.getString(R.string.wb_cloudy_daylight)", this.f4480c.getResources().getDrawable(R.drawable.fav), this.f4480c.getResources().getDrawable(R.drawable.fav), 2));
        i = 3;
        this.f4478a.add(new C1748t(i, "daylight", "this.f4480c.getString(R.string.wb_daylight)", this.f4480c.getResources().getDrawable(R.drawable.fav), this.f4480c.getResources().getDrawable(R.drawable.fav), 3));
        i = 4;
        this.f4478a.add(new C1748t(i, "fluorescent", "this.f4480c.getString(R.string.wb_fluorescent)", this.f4480c.getResources().getDrawable(R.drawable.fav), this.f4480c.getResources().getDrawable(R.drawable.fav), 4));
        this.f4478a.add(new C1748t(5, "incandescent", "this.f4480c.getString(R.string.wb_incandescent)", this.f4480c.getResources().getDrawable(R.drawable.fav), this.f4480c.getResources().getDrawable(R.drawable.fav), 5));
    }

    /* renamed from: a */
    public C1748t mo5905a() {
        return this.f4479b;
    }

    /* renamed from: a */
    public C1748t mo5906a(String str) {
        for (C1748t c1748t : this.f4478a) {
            if (c1748t.mo6267d().equals(str)) {
                return c1748t;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String mo5907a(int i) {
        if (this.f4479b.mo6264a() == i) {
            return this.f4479b.mo6267d();
        }
        for (C1748t c1748t : this.f4478a) {
            if (c1748t.mo6264a() == i) {
                return c1748t.mo6267d();
            }
        }
        return null;
    }
}
