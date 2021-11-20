package com.dermandar.p047a;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.nativesystem.YinYangLib;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.dermandar.a.al */
class C1612al extends GLSurfaceView {
    /* renamed from: c */
    private static String f4496c = "Prototype1";
    /* renamed from: a */
    C1611c f4497a;
    /* renamed from: b */
    C1610b f4498b;

    /* renamed from: com.dermandar.a.al$a */
    private static class C1609a implements EGLConfigChooser {
        /* renamed from: g */
        private static int f4484g = 4;
        /* renamed from: h */
        private static int[] f4485h = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, f4484g, 12344};
        /* renamed from: a */
        protected int f4486a;
        /* renamed from: b */
        protected int f4487b;
        /* renamed from: c */
        protected int f4488c;
        /* renamed from: d */
        protected int f4489d;
        /* renamed from: e */
        protected int f4490e;
        /* renamed from: f */
        protected int f4491f;
        /* renamed from: i */
        private int[] f4492i = new int[1];

        public C1609a(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f4486a = i;
            this.f4487b = i2;
            this.f4488c = i3;
            this.f4489d = i4;
            this.f4490e = i5;
            this.f4491f = i6;
        }

        /* renamed from: a */
        private int m7738a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f4492i) ? this.f4492i[0] : i2;
        }

        /* renamed from: a */
        public EGLConfig mo5908a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = m7738a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = m7738a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.f4490e && a2 >= this.f4491f) {
                    a = m7738a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a3 = m7738a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a4 = m7738a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    a2 = m7738a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a == this.f4486a && a3 == this.f4487b && a4 == this.f4488c && a2 == this.f4489d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, f4485h, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, f4485h, eGLConfigArr, i, iArr);
            return mo5908a(egl10, eGLDisplay, eGLConfigArr);
        }
    }

    /* renamed from: com.dermandar.a.al$b */
    private static class C1610b implements EGLContextFactory {
        /* renamed from: a */
        private static int f4493a = 12440;

        private C1610b() {
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            C1612al.m7742b("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{f4493a, 2, 12344});
            C1612al.m7742b("After eglCreateContext", egl10);
            return eglCreateContext;
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* renamed from: com.dermandar.a.al$c */
    private static class C1611c implements Renderer {
        /* renamed from: a */
        boolean f4494a;
        /* renamed from: b */
        boolean f4495b;

        private C1611c() {
            this.f4494a = false;
            this.f4495b = false;
        }

        public void onDrawFrame(GL10 gl10) {
            GLES20.glClear(16384);
            YinYangLib.step();
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            YinYangLib.release();
            YinYangLib.init(i, i2, this.f4495b);
            GLES20.glViewport(0, 0, i, i2);
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        }
    }

    public C1612al(Context context) {
        super(context);
        m7741a(true, 0, 0);
    }

    /* renamed from: a */
    private void m7741a(boolean z, int i, int i2) {
        if (z) {
            getHolder().setFormat(-3);
        }
        this.f4498b = new C1610b();
        setEGLContextFactory(this.f4498b);
        setEGLConfigChooser(new C1609a(8, 8, 8, 8, i, i2));
        this.f4497a = new C1611c();
        setRenderer(this.f4497a);
        setRenderMode(1);
    }

    /* renamed from: b */
    private static void m7742b(String str, EGL10 egl10) {
        while (egl10.eglGetError() != 12288) {
            C1570ab.m7585b(f4496c, String.format("%s: EGL error: 0x%x", new Object[]{str, Integer.valueOf(egl10.eglGetError())}));
        }
    }

    /* renamed from: a */
    public void mo5915a(boolean z) {
        this.f4497a.f4495b = z;
    }
}
