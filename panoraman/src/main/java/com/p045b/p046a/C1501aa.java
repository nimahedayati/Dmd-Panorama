package com.p045b.p046a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.b.a.aa */
class C1501aa {
    /* renamed from: a */
    final HandlerThread f4101a = new HandlerThread("Picasso-Stats", 10);
    /* renamed from: b */
    final C1527d f4102b;
    /* renamed from: c */
    final Handler f4103c;
    /* renamed from: d */
    long f4104d;
    /* renamed from: e */
    long f4105e;
    /* renamed from: f */
    long f4106f;
    /* renamed from: g */
    long f4107g;
    /* renamed from: h */
    long f4108h;
    /* renamed from: i */
    long f4109i;
    /* renamed from: j */
    long f4110j;
    /* renamed from: k */
    long f4111k;
    /* renamed from: l */
    int f4112l;
    /* renamed from: m */
    int f4113m;
    /* renamed from: n */
    int f4114n;

    /* renamed from: com.b.a.aa$a */
    private static class C1500a extends Handler {
        /* renamed from: a */
        private final C1501aa f4100a;

        public C1500a(Looper looper, C1501aa c1501aa) {
            super(looper);
            this.f4100a = c1501aa;
        }

        public void handleMessage(final Message message) {
            switch (message.what) {
                case 0:
                    this.f4100a.mo5666c();
                    return;
                case 1:
                    this.f4100a.mo5668d();
                    return;
                case 2:
                    this.f4100a.mo5664b((long) message.arg1);
                    return;
                case 3:
                    this.f4100a.mo5667c((long) message.arg1);
                    return;
                case 4:
                    this.f4100a.mo5662a((Long) message.obj);
                    return;
                default:
                    C1559t.f4258a.post(new Runnable() {
                        public void run() {
                            throw new AssertionError("Unhandled stats message." + message.what);
                        }
                    });
                    return;
            }
        }
    }

    C1501aa(C1527d c1527d) {
        this.f4102b = c1527d;
        this.f4101a.start();
        C1516ae.m7392a(this.f4101a.getLooper());
        this.f4103c = new C1500a(this.f4101a.getLooper(), this);
    }

    /* renamed from: a */
    private static long m7352a(int i, long j) {
        return j / ((long) i);
    }

    /* renamed from: a */
    private void m7353a(Bitmap bitmap, int i) {
        this.f4103c.sendMessage(this.f4103c.obtainMessage(i, C1516ae.m7381a(bitmap), 0));
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5659a() {
        this.f4103c.sendEmptyMessage(0);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5660a(long j) {
        this.f4103c.sendMessage(this.f4103c.obtainMessage(4, Long.valueOf(j)));
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5661a(Bitmap bitmap) {
        m7353a(bitmap, 2);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5662a(Long l) {
        this.f4112l++;
        this.f4106f += l.longValue();
        this.f4109i = C1501aa.m7352a(this.f4112l, this.f4106f);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5663b() {
        this.f4103c.sendEmptyMessage(1);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5664b(long j) {
        this.f4113m++;
        this.f4107g += j;
        this.f4110j = C1501aa.m7352a(this.f4113m, this.f4107g);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5665b(Bitmap bitmap) {
        m7353a(bitmap, 3);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo5666c() {
        this.f4104d++;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo5667c(long j) {
        this.f4114n++;
        this.f4108h += j;
        this.f4111k = C1501aa.m7352a(this.f4113m, this.f4108h);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public void mo5668d() {
        this.f4105e++;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: e */
    public C1502ab mo5669e() {
        return new C1502ab(this.f4102b.mo5720b(), this.f4102b.mo5717a(), this.f4104d, this.f4105e, this.f4106f, this.f4107g, this.f4108h, this.f4109i, this.f4110j, this.f4111k, this.f4112l, this.f4113m, this.f4114n, System.currentTimeMillis());
    }
}
