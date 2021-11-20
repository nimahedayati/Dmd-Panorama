package com.p045b.p046a;

/* renamed from: com.b.a.q */
public enum C1546q {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    
    /* renamed from: d */
    final int f4230d;

    private C1546q(int i) {
        this.f4230d = i;
    }

    /* renamed from: a */
    public static boolean m7510a(int i) {
        return (NO_CACHE.f4230d & i) == 0;
    }

    /* renamed from: b */
    public static boolean m7511b(int i) {
        return (NO_STORE.f4230d & i) == 0;
    }

    /* renamed from: c */
    public static boolean m7512c(int i) {
        return (OFFLINE.f4230d & i) != 0;
    }
}
