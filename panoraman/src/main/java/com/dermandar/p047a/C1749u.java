package com.dermandar.p047a;

import android.content.Context;

import com.dermandar.panoraman.R;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.dermandar.a.u */
class C1749u {
    /* renamed from: a */
    private Context f5002a;
    /* renamed from: b */
    private List<C1748t> f5003b = new ArrayList();

    public C1749u(Context context) {
        this.f5002a = context;
        this.f5003b.add(new C1748t(0, "", "this.f5002a.getString(R.string.exp_auto)", this.f5002a.getResources().getDrawable(R.drawable.fav), this.f5002a.getResources().getDrawable(R.drawable.fav), 0));
        int i = 1;
        this.f5003b.add(new C1748t(i, "", "this.f5002a.getString(R.string.exp_locked)", this.f5002a.getResources().getDrawable(R.drawable.fav), this.f5002a.getResources().getDrawable(R.drawable.fav), 1));
        i = 2;
        this.f5003b.add(new C1748t(i, "", "this.f5002a.getString(R.string.exp_locked_start)", this.f5002a.getResources().getDrawable(R.drawable.fav), this.f5002a.getResources().getDrawable(R.drawable.fav), 2));
    }

    /* renamed from: a */
    public List<C1748t> mo6270a() {
        return this.f5003b;
    }
}
