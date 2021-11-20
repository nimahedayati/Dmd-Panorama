package com.p045b.p046a;

import android.content.Context;
import com.p045b.p046a.C1517y.C1518a;
import com.p045b.p046a.C1559t.C1555d;

import java.io.FileNotFoundException;
import java.io.InputStream;

/* renamed from: com.b.a.g */
class C1532g extends C1517y {
    /* renamed from: a */
    final Context f4177a;

    C1532g(Context context) {
        this.f4177a = context;
    }

    /* renamed from: a */
    public C1518a mo5685a(C1565w c1565w, int i) throws Throwable {
        return new C1518a(mo5723b(c1565w), C1555d.DISK);
    }

    /* renamed from: a */
    public boolean mo5686a(C1565w c1565w) {
        return "content".equals(c1565w.f4303d.getScheme());
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public InputStream mo5723b(C1565w c1565w) throws FileNotFoundException {
        return this.f4177a.getContentResolver().openInputStream(c1565w.f4303d);
    }
}
