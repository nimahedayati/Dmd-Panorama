package com.p045b.p046a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.p045b.p046a.C1498a.C1497a;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* renamed from: com.b.a.t */
public class C1559t {
    /* renamed from: a */
    static final Handler f4258a = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            List list;
            int size;
            int i;
            switch (message.what) {
                case 3:
                    C1498a c1498a = (C1498a) message.obj;
                    if (c1498a.mo5654j().f4269l) {
                        C1516ae.m7395a("Main", "canceled", c1498a.f4087b.mo5790a(), "target got garbage collected");
                    }
                    c1498a.f4086a.m7527a(c1498a.mo5648d());
                    return;
                case 8:
                    list = (List) message.obj;
                    size = list.size();
                    for (i = 0; i < size; i++) {
                        C1526c c1526c = (C1526c) list.get(i);
                        c1526c.f4156b.mo5773a(c1526c);
                    }
                    return;
                case 13:
                    list = (List) message.obj;
                    size = list.size();
                    for (i = 0; i < size; i++) {
                        C1498a c1498a2 = (C1498a) list.get(i);
                        c1498a2.f4086a.mo5776c(c1498a2);
                    }
                    return;
                default:
                    throw new AssertionError("Unknown handler message received: " + message.what);
            }
        }
    };
    /* renamed from: b */
    static volatile C1559t f4259b = null;
    /* renamed from: c */
    final Context f4260c;
    /* renamed from: d */
    final C1538i f4261d;
    /* renamed from: e */
    final C1527d f4262e;
    /* renamed from: f */
    final C1501aa f4263f;
    /* renamed from: g */
    final Map<Object, C1498a> f4264g;
    /* renamed from: h */
    final Map<ImageView, C1533h> f4265h;
    /* renamed from: i */
    final ReferenceQueue<Object> f4266i;
    /* renamed from: j */
    final Config f4267j;
    /* renamed from: k */
    boolean f4268k;
    /* renamed from: l */
    volatile boolean f4269l;
    /* renamed from: m */
    boolean f4270m;
    /* renamed from: n */
    private final C1554c f4271n;
    /* renamed from: o */
    private final C1557f f4272o;
    /* renamed from: p */
    private final C1553b f4273p;
    /* renamed from: q */
    private final List<C1517y> f4274q;

    /* renamed from: com.b.a.t$a */
    public static class C1551a {
        /* renamed from: a */
        private final Context f4234a;
        /* renamed from: b */
        private C1506j f4235b;
        /* renamed from: c */
        private ExecutorService f4236c;
        /* renamed from: d */
        private C1527d f4237d;
        /* renamed from: e */
        private C1554c f4238e;
        /* renamed from: f */
        private C1557f f4239f;
        /* renamed from: g */
        private List<C1517y> f4240g;
        /* renamed from: h */
        private Config f4241h;
        /* renamed from: i */
        private boolean f4242i;
        /* renamed from: j */
        private boolean f4243j;

        public C1551a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f4234a = context.getApplicationContext();
        }

        /* renamed from: a */
        public C1559t mo5760a() {
            Context context = this.f4234a;
            if (this.f4235b == null) {
                this.f4235b = C1516ae.m7384a(context);
            }
            if (this.f4237d == null) {
                this.f4237d = new C1541m(context);
            }
            if (this.f4236c == null) {
                this.f4236c = new C1562v();
            }
            if (this.f4239f == null) {
                this.f4239f = C1557f.f4257a;
            }
            C1501aa c1501aa = new C1501aa(this.f4237d);
            return new C1559t(context, new C1538i(context, this.f4236c, C1559t.f4258a, this.f4235b, this.f4237d, c1501aa), this.f4237d, this.f4238e, this.f4239f, this.f4240g, c1501aa, this.f4241h, this.f4242i, this.f4243j);
        }
    }

    /* renamed from: com.b.a.t$b */
    private static class C1553b extends Thread {
        /* renamed from: a */
        private final ReferenceQueue<Object> f4246a;
        /* renamed from: b */
        private final Handler f4247b;

        C1553b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f4246a = referenceQueue;
            this.f4247b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    C1497a c1497a = (C1497a) this.f4246a.remove(1000);
                    Message obtainMessage = this.f4247b.obtainMessage();
                    if (c1497a != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = c1497a.f4085a;
                        this.f4247b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException e) {
                    return;
                } catch (final Exception e2) {
                    this.f4247b.post(new Runnable() {
                        public void run() {
                            throw new RuntimeException(e2);
                        }
                    });
                    return;
                }
            }
        }
    }

    /* renamed from: com.b.a.t$c */
    public interface C1554c {
        /* renamed from: a */
        void mo5763a(C1559t c1559t, Uri uri, Exception exception);
    }

    /* renamed from: com.b.a.t$d */
    public enum C1555d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        /* renamed from: d */
        final int f4252d;

        private C1555d(int i) {
            this.f4252d = i;
        }
    }

    /* renamed from: com.b.a.t$e */
    public enum C1556e {
        LOW,
        NORMAL,
        HIGH
    }

    /* renamed from: com.b.a.t$f */
    public interface C1557f {
        /* renamed from: a */
        public static final C1557f f4257a = new C15581();

        /* renamed from: com.b.a.t$f$1 */
        static class C15581 implements C1557f {
            C15581() {
            }

            /* renamed from: a */
            public C1565w mo5764a(C1565w c1565w) {
                return c1565w;
            }
        }

        /* renamed from: a */
        C1565w mo5764a(C1565w c1565w);
    }

    C1559t(Context context, C1538i c1538i, C1527d c1527d, C1554c c1554c, C1557f c1557f, List<C1517y> list, C1501aa c1501aa, Config config, boolean z, boolean z2) {
        this.f4260c = context;
        this.f4261d = c1538i;
        this.f4262e = c1527d;
        this.f4271n = c1554c;
        this.f4272o = c1557f;
        this.f4267j = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new C1567z(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new C1531f(context));
        arrayList.add(new C1544o(context));
        arrayList.add(new C1532g(context));
        arrayList.add(new C1519b(context));
        arrayList.add(new C1539k(context));
        arrayList.add(new C1548r(c1538i.f4188d, c1501aa));
        this.f4274q = Collections.unmodifiableList(arrayList);
        this.f4263f = c1501aa;
        this.f4264g = new WeakHashMap();
        this.f4265h = new WeakHashMap();
        this.f4268k = z;
        this.f4269l = z2;
        this.f4266i = new ReferenceQueue();
        this.f4273p = new C1553b(this.f4266i, f4258a);
        this.f4273p.start();
    }

    /* renamed from: a */
    public static C1559t m7524a(Context context) {
        if (f4259b == null) {
            synchronized (C1559t.class) {
                if (f4259b == null) {
                    f4259b = new C1551a(context).mo5760a();
                }
            }
        }
        return f4259b;
    }

    /* renamed from: a */
    private void m7525a(Bitmap bitmap, C1555d c1555d, C1498a c1498a) {
        if (!c1498a.mo5650f()) {
            if (!c1498a.mo5651g()) {
                this.f4264g.remove(c1498a.mo5648d());
            }
            if (bitmap == null) {
                c1498a.mo5644a();
                if (this.f4269l) {
                    C1516ae.m7394a("Main", "errored", c1498a.f4087b.mo5790a());
                }
            } else if (c1555d == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            } else {
                c1498a.mo5645a(bitmap, c1555d);
                if (this.f4269l) {
                    C1516ae.m7395a("Main", "completed", c1498a.f4087b.mo5790a(), "from " + c1555d);
                }
            }
        }
    }

    /* renamed from: a */
    private void m7527a(Object obj) {
        C1516ae.m7391a();
        C1498a c1498a = (C1498a) this.f4264g.remove(obj);
        if (c1498a != null) {
            c1498a.mo5646b();
            this.f4261d.mo5739b(c1498a);
        }
        if (obj instanceof ImageView) {
            C1533h c1533h = (C1533h) this.f4265h.remove((ImageView) obj);
            if (c1533h != null) {
                c1533h.mo5724a();
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public C1565w mo5765a(C1565w c1565w) {
        C1565w a = this.f4272o.mo5764a(c1565w);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Request transformer " + this.f4272o.getClass().getCanonicalName() + " returned null for " + c1565w);
    }

    /* renamed from: a */
    public C1566x mo5766a(Uri uri) {
        return new C1566x(this, uri, 0);
    }

    /* renamed from: a */
    public C1566x mo5767a(File file) {
        return file == null ? new C1566x(this, null, 0) : mo5766a(Uri.fromFile(file));
    }

    /* renamed from: a */
    public C1566x mo5768a(String str) {
        if (str == null) {
            return new C1566x(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return mo5766a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public List<C1517y> mo5769a() {
        return this.f4274q;
    }

    /* renamed from: a */
    public void mo5770a(ImageView imageView) {
        m7527a((Object) imageView);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5771a(ImageView imageView, C1533h c1533h) {
        this.f4265h.put(imageView, c1533h);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5772a(C1498a c1498a) {
        Object d = c1498a.mo5648d();
        if (!(d == null || this.f4264g.get(d) == c1498a)) {
            m7527a(d);
            this.f4264g.put(d, c1498a);
        }
        mo5775b(c1498a);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo5773a(C1526c c1526c) {
        Object obj = 1;
        C1498a i = c1526c.mo5710i();
        List k = c1526c.mo5712k();
        Object obj2 = (k == null || k.isEmpty()) ? null : 1;
        if (i == null && obj2 == null) {
            obj = null;
        }
        if (obj != null) {
            Uri uri = c1526c.mo5709h().f4303d;
            Exception l = c1526c.mo5713l();
            Bitmap e = c1526c.mo5706e();
            C1555d m = c1526c.mo5714m();
            if (i != null) {
                m7525a(e, m, i);
            }
            if (obj2 != null) {
                int size = k.size();
                for (int i2 = 0; i2 < size; i2++) {
                    m7525a(e, m, (C1498a) k.get(i2));
                }
            }
            if (this.f4271n != null && l != null) {
                this.f4271n.mo5763a(this, uri, l);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public Bitmap mo5774b(String str) {
        Bitmap a = this.f4262e.mo5718a(str);
        if (a != null) {
            this.f4263f.mo5659a();
        } else {
            this.f4263f.mo5663b();
        }
        return a;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo5775b(C1498a c1498a) {
        this.f4261d.mo5732a(c1498a);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo5776c(C1498a c1498a) {
        Bitmap bitmap = null;
        if (C1545p.m7508a(c1498a.f4090e)) {
            bitmap = mo5774b(c1498a.mo5649e());
        }
        if (bitmap != null) {
            m7525a(bitmap, C1555d.MEMORY, c1498a);
            if (this.f4269l) {
                C1516ae.m7395a("Main", "completed", c1498a.f4087b.mo5790a(), "from " + C1555d.MEMORY);
                return;
            }
            return;
        }
        mo5772a(c1498a);
        if (this.f4269l) {
            C1516ae.m7394a("Main", "resumed", c1498a.f4087b.mo5790a());
        }
    }
}
