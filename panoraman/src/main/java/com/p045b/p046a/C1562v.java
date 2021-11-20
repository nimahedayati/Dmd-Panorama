package com.p045b.p046a;

import android.net.NetworkInfo;
import com.p045b.p046a.C1516ae.C1515e;
import com.p045b.p046a.C1559t.C1556e;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.b.a.v */
class C1562v extends ThreadPoolExecutor {

    /* renamed from: com.b.a.v$a */
    private static final class C1561a extends FutureTask<C1526c> implements Comparable<C1561a> {
        /* renamed from: a */
        private final C1526c f4283a;

        public C1561a(C1526c c1526c) {
            super(c1526c, null);
            this.f4283a = c1526c;
        }

        /* renamed from: a */
        public int compareTo(C1561a c1561a) {
            C1556e n = this.f4283a.mo5715n();
            C1556e n2 = c1561a.f4283a.mo5715n();
            return n == n2 ? this.f4283a.f4155a - c1561a.f4283a.f4155a : n2.ordinal() - n.ordinal();
        }
    }

    C1562v() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C1515e());
    }

    /* renamed from: a */
    private void m7545a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5783a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            m7545a(3);
            return;
        }
        switch (networkInfo.getType()) {
            case 0:
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                        m7545a(1);
                        return;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 12:
                        m7545a(2);
                        return;
                    case 13:
                    case 14:
                    case 15:
                        m7545a(3);
                        return;
                    default:
                        m7545a(3);
                        return;
                }
            case 1:
            case 6:
            case 9:
                m7545a(4);
                return;
            default:
                m7545a(3);
                return;
        }
    }

    public Future<?> submit(Runnable runnable) {
        C1561a c1561a = new C1561a((C1526c) runnable);
        execute(c1561a);
        return c1561a;
    }
}
