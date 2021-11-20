package com.p045b.p046a;

/* renamed from: com.b.a.p */
public enum C1545p {
    NO_CACHE(1),
    NO_STORE(2);
    
    /* renamed from: c */
    final int f4225c;

    private C1545p(int i) {
        this.f4225c = i;
    }

    /* renamed from: a */
    static boolean m7508a(int i) {
        return (NO_CACHE.f4225c & i) == 0;
    }

    /* renamed from: b */
    static boolean m7509b(int i) {
        return (NO_STORE.f4225c & i) == 0;
    }
}
