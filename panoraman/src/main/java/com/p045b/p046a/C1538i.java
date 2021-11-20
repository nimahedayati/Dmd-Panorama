package com.p045b.p046a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.p045b.p046a.C1548r.C1547a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* renamed from: com.b.a.i */
class C1538i {
    /* renamed from: a */
    final C1536b f4185a = new C1536b();
    /* renamed from: b */
    final Context f4186b;
    /* renamed from: c */
    final ExecutorService f4187c;
    /* renamed from: d */
    final C1506j f4188d;
    /* renamed from: e */
    final Map<String, C1526c> f4189e;
    /* renamed from: f */
    final Map<Object, C1498a> f4190f;
    /* renamed from: g */
    final Map<Object, C1498a> f4191g;
    /* renamed from: h */
    final Set<Object> f4192h;
    /* renamed from: i */
    final Handler f4193i;
    /* renamed from: j */
    final Handler f4194j;
    /* renamed from: k */
    final C1527d f4195k;
    /* renamed from: l */
    final C1501aa f4196l;
    /* renamed from: m */
    final List<C1526c> f4197m;
    /* renamed from: n */
    final C1537c f4198n;
    /* renamed from: o */
    final boolean f4199o;
    /* renamed from: p */
    boolean f4200p;

    /* renamed from: com.b.a.i$a */
    private static class C1535a extends Handler {
        /* renamed from: a */
        private final C1538i f4183a;

        public C1535a(Looper looper, C1538i c1538i) {
            super(looper);
            this.f4183a = c1538i;
        }

        public void handleMessage(final Message message) {
            boolean z = true;
            switch (message.what) {
                case 1:
                    this.f4183a.mo5743c((C1498a) message.obj);
                    return;
                case 2:
                    this.f4183a.mo5745d((C1498a) message.obj);
                    return;
                case 4:
                    this.f4183a.mo5747e((C1526c) message.obj);
                    return;
                case 5:
                    this.f4183a.mo5746d((C1526c) message.obj);
                    return;
                case 6:
                    this.f4183a.mo5735a((C1526c) message.obj, false);
                    return;
                case 7:
                    this.f4183a.mo5730a();
                    return;
                case 9:
                    this.f4183a.mo5738b((NetworkInfo) message.obj);
                    return;
                case 10:
                    C1538i c1538i = this.f4183a;
                    if (message.arg1 != 1) {
                        z = false;
                    }
                    c1538i.mo5742b(z);
                    return;
                case 11:
                    this.f4183a.mo5736a(message.obj);
                    return;
                case 12:
                    this.f4183a.mo5741b(message.obj);
                    return;
                default:
                    C1559t.f4258a.post(new Runnable() {
                        public void run() {
                            throw new AssertionError("Unknown handler message received: " + message.what);
                        }
                    });
                    return;
            }
        }
    }

    /* renamed from: com.b.a.i$b */
    static class C1536b extends HandlerThread {
        C1536b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* renamed from: com.b.a.i$c */
    static class C1537c extends BroadcastReceiver {
        /* renamed from: a */
        private final C1538i f4184a;

        C1537c(C1538i c1538i) {
            this.f4184a = c1538i;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public void mo5728a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f4184a.f4199o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f4184a.f4186b.registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        this.f4184a.mo5737a(intent.getBooleanExtra("state", false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.f4184a.mo5731a(((ConnectivityManager) C1516ae.m7385a(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    C1538i(Context context, ExecutorService executorService, Handler handler, C1506j c1506j, C1527d c1527d, C1501aa c1501aa) {
        this.f4185a.start();
        C1516ae.m7392a(this.f4185a.getLooper());
        this.f4186b = context;
        this.f4187c = executorService;
        this.f4189e = new LinkedHashMap();
        this.f4190f = new WeakHashMap();
        this.f4191g = new WeakHashMap();
        this.f4192h = new HashSet();
        this.f4193i = new C1535a(this.f4185a.getLooper(), this);
        this.f4188d = c1506j;
        this.f4194j = handler;
        this.f4195k = c1527d;
        this.f4196l = c1501aa;
        this.f4197m = new ArrayList(4);
        this.f4200p = C1516ae.m7403d(this.f4186b);
        this.f4199o = C1516ae.m7399b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.f4198n = new C1537c(this);
        this.f4198n.mo5728a();
    }

    /* renamed from: a */
    private void m7466a(List<C1526c> list) {
        if (list != null && !list.isEmpty() && ((C1526c) list.get(0)).mo5711j().f4269l) {
            StringBuilder stringBuilder = new StringBuilder();
            for (C1526c c1526c : list) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(C1516ae.m7387a(c1526c));
            }
            C1516ae.m7394a("Dispatcher", "delivered", stringBuilder.toString());
        }
    }

    /* renamed from: b */
    private void m7467b() {
        if (!this.f4190f.isEmpty()) {
            Iterator it = this.f4190f.values().iterator();
            while (it.hasNext()) {
                C1498a c1498a = (C1498a) it.next();
                it.remove();
                if (c1498a.mo5654j().f4269l) {
                    C1516ae.m7394a("Dispatcher", "replaying", c1498a.mo5647c().mo5790a());
                }
                mo5733a(c1498a, false);
            }
        }
    }

    /* renamed from: e */
    private void m7468e(C1498a c1498a) {
        Object d = c1498a.mo5648d();
        if (d != null) {
            c1498a.f4096k = true;
            this.f4190f.put(d, c1498a);
        }
    }

    /* renamed from: f */
    private void m7469f(C1526c c1526c) {
        C1498a i = c1526c.mo5710i();
        if (i != null) {
            m7468e(i);
        }
        List k = c1526c.mo5712k();
        if (k != null) {
            int size = k.size();
            for (int i2 = 0; i2 < size; i2++) {
                m7468e((C1498a) k.get(i2));
            }
        }
    }

    /* renamed from: g */
    private void m7470g(C1526c c1526c) {
        if (!c1526c.mo5704c()) {
            this.f4197m.add(c1526c);
            if (!this.f4193i.hasMessages(7)) {
                this.f4193i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5730a() {
        List arrayList = new ArrayList(this.f4197m);
        this.f4197m.clear();
        this.f4194j.sendMessage(this.f4194j.obtainMessage(8, arrayList));
        m7466a(arrayList);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5731a(NetworkInfo networkInfo) {
        this.f4193i.sendMessage(this.f4193i.obtainMessage(9, networkInfo));
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5732a(C1498a c1498a) {
        this.f4193i.sendMessage(this.f4193i.obtainMessage(1, c1498a));
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5733a(C1498a c1498a, boolean z) {
        if (this.f4192h.contains(c1498a.mo5656l())) {
            this.f4191g.put(c1498a.mo5648d(), c1498a);
            if (c1498a.mo5654j().f4269l) {
                C1516ae.m7395a("Dispatcher", "paused", c1498a.f4087b.mo5790a(), "because tag '" + c1498a.mo5656l() + "' is paused");
                return;
            }
            return;
        }
        C1526c c1526c = (C1526c) this.f4189e.get(c1498a.mo5649e());
        if (c1526c != null) {
            c1526c.mo5700a(c1498a);
        } else if (!this.f4187c.isShutdown()) {
            c1526c = C1526c.m7426a(c1498a.mo5654j(), this, this.f4195k, this.f4196l, c1498a);
            c1526c.f4168n = this.f4187c.submit(c1526c);
            this.f4189e.put(c1498a.mo5649e(), c1526c);
            if (z) {
                this.f4190f.remove(c1498a.mo5648d());
            }
            if (c1498a.mo5654j().f4269l) {
                C1516ae.m7394a("Dispatcher", "enqueued", c1498a.f4087b.mo5790a());
            }
        } else if (c1498a.mo5654j().f4269l) {
            C1516ae.m7395a("Dispatcher", "ignored", c1498a.f4087b.mo5790a(), "because shut down");
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5734a(C1526c c1526c) {
        this.f4193i.sendMessage(this.f4193i.obtainMessage(4, c1526c));
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5735a(C1526c c1526c, boolean z) {
        if (c1526c.mo5711j().f4269l) {
            C1516ae.m7395a("Dispatcher", "batched", C1516ae.m7387a(c1526c), "for error" + (z ? " (will replay)" : ""));
        }
        this.f4189e.remove(c1526c.mo5707f());
        m7470g(c1526c);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5736a(Object obj) {
        if (this.f4192h.add(obj)) {
            Iterator it = this.f4189e.values().iterator();
            while (it.hasNext()) {
                C1526c c1526c = (C1526c) it.next();
                boolean z = c1526c.mo5711j().f4269l;
                C1498a i = c1526c.mo5710i();
                List k = c1526c.mo5712k();
                Object obj2 = (k == null || k.isEmpty()) ? null : 1;
                if (i != null || obj2 != null) {
                    if (i != null && i.mo5656l().equals(obj)) {
                        c1526c.mo5702b(i);
                        this.f4191g.put(i.mo5648d(), i);
                        if (z) {
                            C1516ae.m7395a("Dispatcher", "paused", i.f4087b.mo5790a(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (obj2 != null) {
                        for (int size = k.size() - 1; size >= 0; size--) {
                            C1498a c1498a = (C1498a) k.get(size);
                            if (c1498a.mo5656l().equals(obj)) {
                                c1526c.mo5702b(c1498a);
                                this.f4191g.put(c1498a.mo5648d(), c1498a);
                                if (z) {
                                    C1516ae.m7395a("Dispatcher", "paused", c1498a.f4087b.mo5790a(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (c1526c.mo5703b()) {
                        it.remove();
                        if (z) {
                            C1516ae.m7395a("Dispatcher", "canceled", C1516ae.m7387a(c1526c), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5737a(boolean z) {
        this.f4193i.sendMessage(this.f4193i.obtainMessage(10, z ? 1 : 0, 0));
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5738b(NetworkInfo networkInfo) {
        if (this.f4187c instanceof C1562v) {
            ((C1562v) this.f4187c).mo5783a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            m7467b();
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5739b(C1498a c1498a) {
        this.f4193i.sendMessage(this.f4193i.obtainMessage(2, c1498a));
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5740b(C1526c c1526c) {
        this.f4193i.sendMessageDelayed(this.f4193i.obtainMessage(5, c1526c), 500);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5741b(Object obj) {
        if (this.f4192h.remove(obj)) {
            ArrayList obj2 = null;
            Iterator it = this.f4191g.values().iterator();
            while (it.hasNext()) {
                C1498a c1498a = (C1498a) it.next();
                if (c1498a.mo5656l().equals(obj)) {
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                    }
                    obj2.add(c1498a);
                    it.remove();
                }
            }
            if (obj2 != null) {
                this.f4194j.sendMessage(this.f4194j.obtainMessage(13, obj2));
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5742b(boolean z) {
        this.f4200p = z;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo5743c(C1498a c1498a) {
        mo5733a(c1498a, true);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo5744c(C1526c c1526c) {
        this.f4193i.sendMessage(this.f4193i.obtainMessage(6, c1526c));
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public void mo5745d(C1498a c1498a) {
        String e = c1498a.mo5649e();
        C1526c c1526c = (C1526c) this.f4189e.get(e);
        if (c1526c != null) {
            c1526c.mo5702b(c1498a);
            if (c1526c.mo5703b()) {
                this.f4189e.remove(e);
                if (c1498a.mo5654j().f4269l) {
                    C1516ae.m7394a("Dispatcher", "canceled", c1498a.mo5647c().mo5790a());
                }
            }
        }
        if (this.f4192h.contains(c1498a.mo5656l())) {
            this.f4191g.remove(c1498a.mo5648d());
            if (c1498a.mo5654j().f4269l) {
                C1516ae.m7395a("Dispatcher", "canceled", c1498a.mo5647c().mo5790a(), "because paused request got canceled");
            }
        }
        C1498a c1498a2 = (C1498a) this.f4190f.remove(c1498a.mo5648d());
        if (c1498a2 != null && c1498a2.mo5654j().f4269l) {
            C1516ae.m7395a("Dispatcher", "canceled", c1498a2.mo5647c().mo5790a(), "from replaying");
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public void mo5746d(C1526c c1526c) {
        boolean z = true;
        if (!c1526c.mo5704c()) {
            if (this.f4187c.isShutdown()) {
                mo5735a(c1526c, false);
                return;
            }
            NetworkInfo activeNetworkInfo = this.f4199o ? ((ConnectivityManager) C1516ae.m7385a(this.f4186b, "connectivity")).getActiveNetworkInfo() : null;
            boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            boolean a = c1526c.mo5701a(this.f4200p, activeNetworkInfo);
            boolean d = c1526c.mo5705d();
            if (!a) {
                if (!(this.f4199o && d)) {
                    z = false;
                }
                mo5735a(c1526c, z);
                if (z) {
                    m7469f(c1526c);
                }
            } else if (!this.f4199o || z2) {
                if (c1526c.mo5711j().f4269l) {
                    C1516ae.m7394a("Dispatcher", "retrying", C1516ae.m7387a(c1526c));
                }
                if (c1526c.mo5713l() instanceof C1547a) {
                    c1526c.f4163i |= C1546q.NO_CACHE.f4230d;
                }
                c1526c.f4168n = this.f4187c.submit(c1526c);
            } else {
                mo5735a(c1526c, d);
                if (d) {
                    m7469f(c1526c);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: e */
    public void mo5747e(C1526c c1526c) {
        if (C1545p.m7509b(c1526c.mo5708g())) {
            this.f4195k.mo5719a(c1526c.mo5707f(), c1526c.mo5706e());
        }
        this.f4189e.remove(c1526c.mo5707f());
        m7470g(c1526c);
        if (c1526c.mo5711j().f4269l) {
            C1516ae.m7395a("Dispatcher", "batched", C1516ae.m7387a(c1526c), "for completion");
        }
    }
}
