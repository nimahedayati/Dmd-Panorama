package com.dermandar.p047a;

import android.content.Context;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* renamed from: com.dermandar.a.ah */
class C1604ah extends C1590w {
    /* renamed from: a */
    private static String f4476a = "DMD_Library";
    /* renamed from: b */
    private C1591m f4477b;

    /* renamed from: com.dermandar.a.ah$a */
    private static class C1587a implements C1586e {
        /* renamed from: g */
        private static int f4413g = 4;
        /* renamed from: h */
        private static int[] f4414h = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, f4413g, 12344};
        /* renamed from: a */
        protected int f4415a;
        /* renamed from: b */
        protected int f4416b;
        /* renamed from: c */
        protected int f4417c;
        /* renamed from: d */
        protected int f4418d;
        /* renamed from: e */
        protected int f4419e;
        /* renamed from: f */
        protected int f4420f;
        /* renamed from: i */
        private int[] f4421i = new int[1];

        public C1587a(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f4415a = i;
            this.f4416b = i2;
            this.f4417c = i3;
            this.f4418d = i4;
            this.f4419e = i5;
            this.f4420f = i6;
        }

        /* renamed from: a */
        private int m7647a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f4421i) ? this.f4421i[0] : i2;
        }

        /* renamed from: a */
        public EGLConfig mo5849a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, f4414h, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, f4414h, eGLConfigArr, i, iArr);
            return mo5850a(egl10, eGLDisplay, eGLConfigArr);
        }

        /* renamed from: a */
        public EGLConfig mo5850a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = m7647a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = m7647a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.f4419e && a2 >= this.f4420f) {
                    a = m7647a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a3 = m7647a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a4 = m7647a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    a2 = m7647a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a == this.f4415a && a3 == this.f4416b && a4 == this.f4417c && a2 == this.f4418d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: com.dermandar.a.ah$b */
    private static class C1589b implements C1588f {
        /* renamed from: a */
        private static int f4422a = 12440;

        private C1589b() {
        }

        /* renamed from: a */
        public EGLContext mo5851a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            C1570ab.m7587d(C1604ah.f4476a, "creating OpenGL ES 2.0 context");
            C1604ah.m7726b("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{f4422a, 2, 12344});
            C1604ah.m7726b("After eglCreateContext", egl10);
            return eglCreateContext;
        }

        /* renamed from: a */
        public void mo5852a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            C1570ab.m7587d(C1604ah.f4476a, "destroying OpenGL ES 2.0 context");
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    public C1604ah(Context context, C1591m c1591m) {
        super(context);
        m7724a(c1591m, true, 0, 0);
    }

    /* renamed from: a */
    private void m7724a(C1591m c1591m, boolean z, int i, int i2) {
        if (z) {
            getHolder().setFormat(-3);
        }
        mo5856a((C1588f) new C1589b());
        mo5855a((C1586e) new C1587a(8, 8, 8, 8, i, i2));
        this.f4477b = c1591m;
        mo5857a(this.f4477b);
    }

    /* renamed from: b */
    private static void m7726b(String str, EGL10 egl10) {
        while (egl10.eglGetError() != 12288) {
            C1570ab.m7585b(f4476a, String.format("%s: EGL error: 0x%x", new Object[]{str, Integer.valueOf(egl10.eglGetError())}));
        }
    }

    /* renamed from: i */
    public void mo5904i() {
        mo5853a().mo5892g();
    }
}
