package com.dermandar.p047a;

/* renamed from: com.dermandar.a.aa */
class C1569aa {
    /* renamed from: a */
    public static void m7580a(float[] fArr) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 1.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    /* renamed from: a */
    public static void m7581a(float[] fArr, double d, double d2, double d3) {
        double cos;
        double sin;
        float[] fArr2 = new float[16];
        if (d != 0.0d) {
            cos = Math.cos(d);
            sin = Math.sin(d);
            C1569aa.m7580a(fArr2);
            fArr2[5] = (float) cos;
            fArr2[6] = (float) (-sin);
            fArr2[9] = (float) sin;
            fArr2[10] = (float) cos;
            C1569aa.m7583a(fArr2, fArr, fArr);
        }
        if (d2 != 0.0d) {
            cos = Math.cos(d2);
            sin = Math.sin(d2);
            C1569aa.m7580a(fArr2);
            fArr2[0] = (float) cos;
            fArr2[2] = (float) sin;
            fArr2[8] = (float) (-sin);
            fArr2[10] = (float) cos;
            C1569aa.m7583a(fArr2, fArr, fArr);
        }
        if (d3 != 0.0d) {
            cos = Math.cos(d3);
            sin = Math.sin(d3);
            C1569aa.m7580a(fArr2);
            fArr2[0] = (float) cos;
            fArr2[1] = (float) (-sin);
            fArr2[4] = (float) sin;
            fArr2[5] = (float) cos;
            C1569aa.m7583a(fArr2, fArr, fArr);
        }
    }

    /* renamed from: a */
    public static void m7582a(float[] fArr, float[] fArr2) {
        for (int i = 0; i < 16; i++) {
            fArr2[i] = fArr[i];
        }
    }

    /* renamed from: a */
    public static void m7583a(float[] fArr, float[] fArr2, float[] fArr3) {
        C1569aa.m7582a(new float[]{(((fArr[0] * fArr2[0]) + (fArr[4] * fArr2[1])) + (fArr[8] * fArr2[2])) + (fArr[12] * fArr2[3]), (((fArr[1] * fArr2[0]) + (fArr[5] * fArr2[1])) + (fArr[9] * fArr2[2])) + (fArr[13] * fArr2[3]), (((fArr[2] * fArr2[0]) + (fArr[6] * fArr2[1])) + (fArr[10] * fArr2[2])) + (fArr[14] * fArr2[3]), (((fArr[3] * fArr2[0]) + (fArr[7] * fArr2[1])) + (fArr[11] * fArr2[2])) + (fArr[15] * fArr2[3]), (((fArr[0] * fArr2[4]) + (fArr[4] * fArr2[5])) + (fArr[8] * fArr2[6])) + (fArr[12] * fArr2[7]), (((fArr[1] * fArr2[4]) + (fArr[5] * fArr2[5])) + (fArr[9] * fArr2[6])) + (fArr[13] * fArr2[7]), (((fArr[2] * fArr2[4]) + (fArr[6] * fArr2[5])) + (fArr[10] * fArr2[6])) + (fArr[14] * fArr2[7]), (((fArr[3] * fArr2[4]) + (fArr[7] * fArr2[5])) + (fArr[11] * fArr2[6])) + (fArr[15] * fArr2[7]), (((fArr[0] * fArr2[8]) + (fArr[4] * fArr2[9])) + (fArr[8] * fArr2[10])) + (fArr[12] * fArr2[11]), (((fArr[1] * fArr2[8]) + (fArr[5] * fArr2[9])) + (fArr[9] * fArr2[10])) + (fArr[13] * fArr2[11]), (((fArr[2] * fArr2[8]) + (fArr[6] * fArr2[9])) + (fArr[10] * fArr2[10])) + (fArr[14] * fArr2[11]), (((fArr[3] * fArr2[8]) + (fArr[7] * fArr2[9])) + (fArr[11] * fArr2[10])) + (fArr[15] * fArr2[11]), (((fArr[0] * fArr2[12]) + (fArr[4] * fArr2[13])) + (fArr[8] * fArr2[14])) + (fArr[12] * fArr2[15]), (((fArr[1] * fArr2[12]) + (fArr[5] * fArr2[13])) + (fArr[9] * fArr2[14])) + (fArr[13] * fArr2[15]), (((fArr[2] * fArr2[12]) + (fArr[6] * fArr2[13])) + (fArr[10] * fArr2[14])) + (fArr[14] * fArr2[15]), (((fArr[3] * fArr2[12]) + (fArr[7] * fArr2[13])) + (fArr[11] * fArr2[14])) + (fArr[15] * fArr2[15])}, fArr3);
    }
}
