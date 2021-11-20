package com.p045b.p046a;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.p045b.p046a.C1517y.C1518a;
import com.p045b.p046a.C1559t.C1555d;

import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.b.a.k */
class C1539k extends C1532g {
    C1539k(Context context) {
        super(context);
    }

    /* renamed from: a */
    static int m7489a(Uri uri) throws IOException {
        switch (new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1)) {
            case 3:
                return 180;
            case 6:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public C1518a mo5685a(C1565w c1565w, int i) throws IOException {
        return new C1518a(null, mo5723b(c1565w), C1555d.DISK, C1539k.m7489a(c1565w.f4303d));
    }

    /* renamed from: a */
    public boolean mo5686a(C1565w c1565w) {
        return "file".equals(c1565w.f4303d.getScheme());
    }
}
