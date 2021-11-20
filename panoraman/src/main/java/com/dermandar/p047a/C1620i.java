package com.dermandar.p047a;

import android.content.Context;

import com.dermandar.panoraman.R;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.dermandar.a.i */
class C1620i implements C1619h {
    /* renamed from: a */
    private Context f4505a;
    /* renamed from: b */
    private List<C1748t> f4506b = new ArrayList();

    public C1620i(Context context) {
        this.f4505a = context;
        this.f4506b.add(new C1748t(0, "none", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 0));
        int i = 2;
        this.f4506b.add(new C1748t(i, "blackboard", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 2));
        i = 3;
        this.f4506b.add(new C1748t(i, "mono", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 3));
        i = 4;
        this.f4506b.add(new C1748t(i, "negative", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 4));
        this.f4506b.add(new C1748t(5, "point-blue", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 5));
        this.f4506b.add(new C1748t(6, "point-green", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 6));
        this.f4506b.add(new C1748t(7, "point-red-yellow", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 7));
        this.f4506b.add(new C1748t(9, "sepia", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 9));
        this.f4506b.add(new C1748t(11, "vintage-cold", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 11));
        this.f4506b.add(new C1748t(12, "vintage-warm", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 12));
        this.f4506b.add(new C1748t(13, "washed", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 13));
        this.f4506b.add(new C1748t(14, "whiteboard", null, this.f4505a.getResources().getDrawable(R.drawable.fav), null, 14));
    }

    /* renamed from: a */
    public C1748t mo5955a(String str) {
        for (C1748t c1748t : this.f4506b) {
            if (c1748t.mo6267d().equals(str)) {
                return c1748t;
            }
        }
        return null;
    }
}
