package com.p045b.p046a;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: com.b.a.m */
public class C1541m implements C1527d {
    /* renamed from: b */
    final LinkedHashMap<String, Bitmap> f4202b;
    /* renamed from: c */
    private final int f4203c;
    /* renamed from: d */
    private int f4204d;
    /* renamed from: e */
    private int f4205e;
    /* renamed from: f */
    private int f4206f;
    /* renamed from: g */
    private int f4207g;
    /* renamed from: h */
    private int f4208h;

    public C1541m(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.f4203c = i;
        this.f4202b = new LinkedHashMap(0, 0.75f, true);
    }

    public C1541m(Context context) {
        this(C1516ae.m7401c(context));
    }

    /* JADX WARNING: Missing block: B:9:0x0031, code skipped:
            throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m7495a(int i) {
        while (true) {
            synchronized (this) {
                if (this.f4204d >= 0 && (!this.f4202b.isEmpty() || this.f4204d == 0)) {
                    if (this.f4204d <= i || this.f4202b.isEmpty()) {
                    } else {
                        Entry entry = (Entry) this.f4202b.entrySet().iterator().next();
                        String str = (String) entry.getKey();
                        Bitmap bitmap = (Bitmap) entry.getValue();
                        this.f4202b.remove(str);
                        this.f4204d -= C1516ae.m7381a(bitmap);
                        this.f4206f++;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final synchronized int mo5717a() {
        return this.f4204d;
    }

    /* renamed from: a */
    public Bitmap mo5718a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap bitmap = (Bitmap) this.f4202b.get(str);
            if (bitmap != null) {
                this.f4207g++;
                return bitmap;
            }
            this.f4208h++;
            return null;
        }
    }

    /* renamed from: a */
    public void mo5719a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.f4205e++;
            this.f4204d += C1516ae.m7381a(bitmap);
            Bitmap bitmap2 = (Bitmap) this.f4202b.put(str, bitmap);
            if (bitmap2 != null) {
                this.f4204d -= C1516ae.m7381a(bitmap2);
            }
        }
        m7495a(this.f4203c);
    }

    /* renamed from: b */
    public final synchronized int mo5720b() {
        return this.f4203c;
    }
}
