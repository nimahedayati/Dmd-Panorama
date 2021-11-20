package com.p045b.p046a;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.p045b.p046a.C1517y.C1518a;
import com.p045b.p046a.C1559t.C1555d;

import java.io.IOException;

/* renamed from: com.b.a.b */
class C1519b extends C1517y {
    /* renamed from: a */
    private static final int f4144a = "file:///android_asset/".length();
    /* renamed from: b */
    private final AssetManager f4145b;

    public C1519b(Context context) {
        this.f4145b = context.getAssets();
    }

    /* renamed from: b */
    static String m7417b(C1565w c1565w) {
        return c1565w.f4303d.toString().substring(f4144a);
    }

    /* renamed from: a */
    public C1518a mo5685a(C1565w c1565w, int i) throws IOException {
        return new C1518a(this.f4145b.open(C1519b.m7417b(c1565w)), C1555d.DISK);
    }

    /* renamed from: a */
    public boolean mo5686a(C1565w c1565w) {
        Uri uri = c1565w.f4303d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
