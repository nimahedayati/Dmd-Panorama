package com.dermandar.p047a;

import android.content.Context;
import com.dermandar.panoraman.R;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.dermandar.a.j */
class C1621j implements C1619h {
    /* renamed from: a */
    private Context f4507a;
    /* renamed from: b */
    private List<C1748t> f4508b = new ArrayList();

    public C1621j(Context context) {
        this.f4507a = context;
        this.f4508b.add(new C1748t(0, String.valueOf(0), null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 0));
        this.f4508b.add(new C1748t(2, String.valueOf(7), null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 2));
        this.f4508b.add(new C1748t(3, String.valueOf(1), null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 3));
        this.f4508b.add(new C1748t(4, String.valueOf(2), null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 4));
        this.f4508b.add(new C1748t(5, "point-blue", null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 5));
        int i = 6;
        this.f4508b.add(new C1748t(i, "point-green", null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 6));
        this.f4508b.add(new C1748t(7, "point-red-yellow", null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 7));
        this.f4508b.add(new C1748t(9, String.valueOf(4), null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 9));
        this.f4508b.add(new C1748t(11, "vintage-cold", null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 11));
        this.f4508b.add(new C1748t(12, "vintage-warm", null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 12));
        this.f4508b.add(new C1748t(13, "washed", null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 13));
        this.f4508b.add(new C1748t(14, String.valueOf(6), null, this.f4507a.getResources().getDrawable(R.drawable.fav), null, 14));
    }

    /* renamed from: a */
    public C1748t mo5955a(String str) {
        for (C1748t c1748t : this.f4508b) {
            if (c1748t.mo6267d().equals(str)) {
                return c1748t;
            }
        }
        return null;
    }
}
