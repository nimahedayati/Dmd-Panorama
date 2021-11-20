package com.dermandar.p047a;

import android.os.Build;

/* renamed from: com.dermandar.a.v */
class C1751v {
    /* renamed from: a */
    private static C1750a[] f5008a = new C1750a[]{new C1750a("SAMSUNG", "GT-I9000", 34.5f, false), new C1750a("SAMSUNG", "GT-I9100", 32.697f, false), new C1750a("SAMSUNG", "GT-I9100T", 32.697f, false), new C1750a("SAMSUNG", "SC-02C", 32.697f, false), new C1750a("SAMSUNG", "SHW-M250K", 32.697f, false), new C1750a("SAMSUNG", "SHW-M250L", 32.697f, false), new C1750a("SAMSUNG", "SHW-M250S", 32.697f, false), new C1750a("SAMSUNG", "SPH-D710", 32.697f, false), new C1750a("SAMSUNG", "GT-I9100", 36.064f, true), new C1750a("SAMSUNG", "GT-I9100T", 36.064f, true), new C1750a("SAMSUNG", "SC-02C", 36.064f, true), new C1750a("SAMSUNG", "SHW-M250K", 36.064f, true), new C1750a("SAMSUNG", "SHW-M250L", 36.064f, true), new C1750a("SAMSUNG", "SHW-M250S", 36.064f, true), new C1750a("SAMSUNG", "SPH-D710", 36.064f, true), new C1750a("SAMSUNG", "GT-I9300", 29.806f, false), new C1750a("SAMSUNG", "GT-I9300T", 29.806f, false), new C1750a("SAMSUNG", "GT-I9305", 29.806f, false), new C1750a("SAMSUNG", "GT-I9305T", 29.806f, false), new C1750a("SAMSUNG", "GT-I9308", 29.806f, false), new C1750a("SAMSUNG", "SHV-E210K", 29.806f, false), new C1750a("SAMSUNG", "SHV-E210L", 29.806f, false), new C1750a("SAMSUNG", "SHV-E210S", 29.806f, false), new C1750a("SAMSUNG", "SGH-T999", 29.806f, false), new C1750a("SAMSUNG", "SGH-T999v", 29.806f, false), new C1750a("SAMSUNG", "SGH-I747", 29.806f, false), new C1750a("SAMSUNG", "SGH-I747m", 29.806f, false), new C1750a("SAMSUNG", "SGH-N064", 29.806f, false), new C1750a("SAMSUNG", "SC-06D", 29.806f, false), new C1750a("SAMSUNG", "SCH-R530", 29.806f, false), new C1750a("SAMSUNG", "SCH-I535", 29.806f, false), new C1750a("SAMSUNG", "SPH-L710", 29.806f, false), new C1750a("SAMSUNG", "GT-I9300", 37.974f, true), new C1750a("SAMSUNG", "GT-I9300T", 37.974f, true), new C1750a("SAMSUNG", "GT-I9305", 37.974f, true), new C1750a("SAMSUNG", "GT-I9305T", 37.974f, true), new C1750a("SAMSUNG", "GT-I9308", 37.974f, true), new C1750a("SAMSUNG", "SHV-E210K", 37.974f, true), new C1750a("SAMSUNG", "SHV-E210L", 37.974f, true), new C1750a("SAMSUNG", "SHV-E210S", 37.974f, true), new C1750a("SAMSUNG", "SGH-T999", 37.974f, true), new C1750a("SAMSUNG", "SGH-T999v", 37.974f, true), new C1750a("SAMSUNG", "SGH-I747", 37.974f, true), new C1750a("SAMSUNG", "SGH-I747m", 37.974f, true), new C1750a("SAMSUNG", "SGH-N064", 37.974f, true), new C1750a("SAMSUNG", "SC-06D", 37.974f, true), new C1750a("SAMSUNG", "SCH-R530", 37.974f, true), new C1750a("SAMSUNG", "SCH-I535", 37.974f, true), new C1750a("SAMSUNG", "SPH-L710", 37.974f, true), new C1750a("SAMSUNG", "GT-S5830", 36.54f, false), new C1750a("SAMSUNG", "GALAXY NEXUS", 36.141f, false), new C1750a("SAMSUNG", "GALAXY NEXUS", 32.897f, true), new C1750a("SAMSUNG", "GT-N7000", 32.317f, false), new C1750a("SAMSUNG", "GT-N7000B", 32.317f, false), new C1750a("SAMSUNG", "GT-I9220", 32.317f, false), new C1750a("SAMSUNG", "GT-N7003", 32.317f, false), new C1750a("SAMSUNG", "GT-N7100", 30.03f, false), new C1750a("SAMSUNG", "GT-N7102", 30.03f, false), new C1750a("SAMSUNG", "GT-N7108", 30.03f, false), new C1750a("SAMSUNG", "SCH-i605", 30.03f, false), new C1750a("SAMSUNG", "SCH-R950", 30.03f, false), new C1750a("SAMSUNG", "SGH-i317", 30.03f, false), new C1750a("SAMSUNG", "SGH-i317M", 30.03f, false), new C1750a("SAMSUNG", "SGH-T889", 30.03f, false), new C1750a("SAMSUNG", "SGH-T889V", 30.03f, false), new C1750a("SAMSUNG", "SPH-L900", 30.03f, false), new C1750a("SAMSUNG", "SCH-N719", 30.03f, false), new C1750a("SAMSUNG", "SGH-N025", 30.03f, false), new C1750a("SAMSUNG", "SC-02E", 30.03f, false), new C1750a("SAMSUNG", "SHV-E250K", 30.03f, false), new C1750a("SAMSUNG", "SHV-E250L", 30.03f, false), new C1750a("SAMSUNG", "SHV-E250S", 30.03f, false), new C1750a("HTC", "HTC DESIRE S", 36.12f, false), new C1750a("HTC", "HTC DESIRE S", 37.612f, true), new C1750a("SONY ERICSSON", "LT18I", 33.046f, false), new C1750a("SONY ERICSSON", "LT18A", 33.046f, false), new C1750a("HTC", "HTC ONE X", 29.243f, false), new C1750a("HTC", "HTC ONE X", 36.312f, true), new C1750a("SAMSUNG", "NEXUS S", 35.781f, false), new C1750a("SAMSUNG", "GT-I9020", 35.781f, false), new C1750a("SAMSUNG", "GT-I9020T", 35.781f, false), new C1750a("SAMSUNG", "GT-I9020A", 35.781f, false), new C1750a("SAMSUNG", "GT-I9023", 35.781f, false), new C1750a("SAMSUNG", "SPH-D720", 35.781f, false), new C1750a("SAMSUNG", "SHW-M200", 35.781f, false), new C1750a("MOTOROLA", "XT910", 40.52f, false), new C1750a("MOTOROLA", "XT912", 40.52f, false), new C1750a("MOTOROLA", "DROID RAZR", 40.52f, false), new C1750a("MOTOROLA", "XT889", 40.52f, false), new C1750a("MOTOROLA", "XT910", 35.154f, true), new C1750a("MOTOROLA", "XT912", 35.154f, true), new C1750a("MOTOROLA", "DROID RAZR", 35.154f, true), new C1750a("MOTOROLA", "XT889", 35.154f, true), new C1750a("SAMSUNG", "GT-P7500", 35.9f, false), new C1750a("SAMSUNG", "GT-P7510", 35.9f, false), new C1750a("SAMSUNG", "GT-P7511", 35.9f, false), new C1750a("SAMSUNG", "GT-P7500", 35.694f, true), new C1750a("SAMSUNG", "GT-P7510", 35.694f, true), new C1750a("SAMSUNG", "GT-P7511", 35.694f, true), new C1750a("SAMSUNG", "GT-P6200", 35.865f, false), new C1750a("SAMSUNG", "GT-P6210", 35.865f, false), new C1750a("SAMSUNG", "GT-P6800", 35.865f, false), new C1750a("SAMSUNG", "GT-P6810", 35.865f, false), new C1750a("SAMSUNG", "GT-P6200", 35.975f, true), new C1750a("SAMSUNG", "GT-P6210", 35.975f, true), new C1750a("SAMSUNG", "GT-P6800", 35.975f, true), new C1750a("SAMSUNG", "GT-P6810", 35.975f, true), new C1750a("SAMSUNG", "GT-N8000", 34.32f, false), new C1750a("LGE", "NEXUS 4", 32.835f, false), new C1750a("LGE", "NEXUS 4", 31.841f, true), new C1750a("SAMSUNG", "GT-I9500", 33.25f, false), new C1750a("SAMSUNG", "GT-I9505", 33.25f, false), new C1750a("SAMSUNG", "GT-I9508", 33.25f, false), new C1750a("SAMSUNG", "GT-I9502", 33.25f, false), new C1750a("SAMSUNG", "SHV-E300K", 33.25f, false), new C1750a("SAMSUNG", "SHV-E300L", 33.25f, false), new C1750a("SAMSUNG", "SHV-E300S", 33.25f, false), new C1750a("SAMSUNG", "SGH-I337", 33.25f, false), new C1750a("SAMSUNG", "SGH-M919", 33.25f, false), new C1750a("SAMSUNG", "SCH-I545", 33.25f, false), new C1750a("SAMSUNG", "SPH-L720", 33.25f, false), new C1750a("SAMSUNG", "SCH-R970", 33.25f, false), new C1750a("SAMSUNG", "SCH-I959", 33.25f, false), new C1750a("SAMSUNG", "SGH-N045", 33.25f, false), new C1750a("SAMSUNG", "SC-04E", 33.25f, false), new C1750a("SAMSUNG", "GT-I9500", 26.856f, true), new C1750a("SAMSUNG", "GT-I9505", 26.856f, true), new C1750a("SAMSUNG", "GT-I9508", 26.856f, true), new C1750a("SAMSUNG", "GT-I9502", 26.856f, true), new C1750a("SAMSUNG", "SHV-E300K", 26.856f, true), new C1750a("SAMSUNG", "SHV-E300L", 26.856f, true), new C1750a("SAMSUNG", "SHV-E300S", 26.856f, true), new C1750a("SAMSUNG", "SGH-I337", 26.856f, true), new C1750a("SAMSUNG", "SGH-M919", 26.856f, true), new C1750a("SAMSUNG", "SCH-I545", 26.856f, true), new C1750a("SAMSUNG", "SPH-L720", 26.856f, true), new C1750a("SAMSUNG", "SCH-R970", 26.856f, true), new C1750a("SAMSUNG", "SCH-I959", 26.856f, true), new C1750a("SAMSUNG", "SGH-N045", 26.856f, true), new C1750a("SAMSUNG", "SC-04E", 26.856f, true), new C1750a("SAMSUNG", "SM-G900", 29.88f, false), new C1750a("SAMSUNG", "SM-G900", 21.06f, true), new C1750a("SAMSUNG", "SM-N910", 29.628f, false), new C1750a("SAMSUNG", "SM-N915", 29.628f, false), new C1750a("LGE", "NEXUS 5X", 27.257f, false), new C1750a("LGE", "NEXUS 5X", 26.16f, true), new C1750a("HUAWEI", "NEXUS 6P", 27.44f, false), new C1750a("HUAWEI", "NEXUS 6P", 27.584f, true), new C1750a("LGE", "NEXUS 5", 31.364f, false), new C1750a("LGE", "NEXUS 5", 35.435f, true), new C1750a("SAMSUNG", "SM-N920", 26.961f, false), new C1750a("SAMSUNG", "SM-N920", 22.904f, true), new C1750a("SAMSUNG", "SM-G930", 28.104f, false), new C1750a("SAMSUNG", "SM-G930", 22.687f, true), new C1750a("SAMSUNG", "SM-G925", 29.327f, false), new C1750a("SAMSUNG", "SM-G925", 24.613f, true)};

    /* renamed from: com.dermandar.a.v$a */
    static class C1750a {
        /* renamed from: a */
        String f5004a;
        /* renamed from: b */
        String f5005b;
        /* renamed from: c */
        float f5006c;
        /* renamed from: d */
        boolean f5007d;

        public C1750a(String str, String str2, float f, boolean z) {
            this.f5004a = str;
            this.f5005b = str2;
            this.f5006c = f;
            this.f5007d = z;
        }
    }

    /* renamed from: a */
    private static float m8329a(String str, String str2, boolean z) {
        for (C1750a c1750a : f5008a) {
            if (c1750a.f5004a.equals(str.toUpperCase()) && str2.toUpperCase().startsWith(c1750a.f5005b) && c1750a.f5007d == z) {
                return c1750a.f5006c;
            }
        }
        return 0.0f;
    }

    /* renamed from: a */
    public static void m8330a(boolean z) {
        if (Build.MANUFACTURER != null && Build.MODEL != null) {
            float a = C1751v.m8329a(Build.MANUFACTURER, Build.MODEL, z);
            if (a > 0.0f) {
                C1753x.f5050x = (double) a;
            }
        }
    }
}
