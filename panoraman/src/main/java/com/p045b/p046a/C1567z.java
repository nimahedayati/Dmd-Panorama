package com.p045b.p046a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.p045b.p046a.C1517y.C1518a;
import com.p045b.p046a.C1559t.C1555d;

import java.io.FileNotFoundException;

/* renamed from: com.b.a.z */
class C1567z extends C1517y {
    /* renamed from: a */
    private final Context f4331a;

    C1567z(Context context) {
        this.f4331a = context;
    }

    /* renamed from: a */
    private static Bitmap m7567a(Resources resources, int i, C1565w c1565w) {
        Options c = C1517y.m7407c(c1565w);
        if (C1517y.m7406a(c)) {
            BitmapFactory.decodeResource(resources, i, c);
            C1517y.m7405a(c1565w.f4307h, c1565w.f4308i, c, c1565w);
        }
        return BitmapFactory.decodeResource(resources, i, c);
    }

    /* renamed from: a */
    public C1518a mo5685a(C1565w c1565w, int i) throws FileNotFoundException {
        Resources a = C1516ae.m7383a(this.f4331a, c1565w);
        return new C1518a(C1567z.m7567a(a, C1516ae.m7380a(a, c1565w), c1565w), C1555d.DISK);
    }

    /* renamed from: a */
    public boolean mo5686a(C1565w c1565w) {
        return c1565w.f4304e != 0 ? true : "android.resource".equals(c1565w.f4303d.getScheme());
    }
}
