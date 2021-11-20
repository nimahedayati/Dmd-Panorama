package com.dermandar.p047a;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import java.io.Writer;
import java.util.ArrayList;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.dermandar.a.w */
class C1590w extends SurfaceView implements Callback {

    private static final GLThreadManager sGLThreadManager = new GLThreadManager();
    private boolean mSizeChanged = true;
    private C1599i mGLThread;
    private C1586e mEGLConfigChooser;
    private C1588f mEGLContextFactory;
    private C1596g mEGLWindowSurfaceFactory;
    private C1601k mGLWrapper;
    private int mDebugFlags;
    private int mEGLContextClientVersion;


    public C1590w(Context context) {
        super(context);
        init();
    }

    private void init() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        holder.setFormat(4);
        holder.setType(2);
    }

    public interface C1586e {
        EGLConfig mo5849a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface C1588f {
        EGLContext mo5851a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void mo5852a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface C1591m {
        void mo5872a(GL10 gl10, EGLConfig eGLConfig);

        void mo5871a(GL10 gl10, int i, int i2);

        void mo5870a(GL10 gl10);

        void mo5869a();
    }

    private abstract class BaseConfigChooser implements C1586e {
        protected int[] mConfigSpec;

        public BaseConfigChooser(int[] configSpec) {
            this.mConfigSpec = this.filterConfigSpec(configSpec);
        }

        private int[] filterConfigSpec(int[] configSpec) {
            if (C1590w.this.mEGLContextClientVersion != 2) {
                return configSpec;
            } else {
                int len = configSpec.length;
                int[] newConfigSpec = new int[len + 2];
                System.arraycopy(configSpec, 0, newConfigSpec, 0, len - 1);
                newConfigSpec[len - 1] = 12352;
                newConfigSpec[len] = 4;
                newConfigSpec[len + 1] = 12344;
                return newConfigSpec;
            }
        }

        public EGLConfig mo5849a(EGL10 egl, EGLDisplay display) {
            int[] num_config = new int[1];
            if (!egl.eglChooseConfig(display, this.mConfigSpec, (EGLConfig[]) null, 0, num_config)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            } else {
                int numConfigs = num_config[0];
                if (numConfigs <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                } else {
                    EGLConfig[] configs = new EGLConfig[numConfigs];
                    if (!egl.eglChooseConfig(display, this.mConfigSpec, configs, numConfigs, num_config)) {
                        throw new IllegalArgumentException("eglChooseConfig#2 failed");
                    } else {
                        EGLConfig config = this.mo5873a(egl, display, configs);
                        if (config == null) {
                            throw new IllegalArgumentException("No config chosen");
                        } else {
                            return config;
                        }
                    }
                }
            }
        }

        public abstract EGLConfig mo5873a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mRedSize;
        protected int mGreenSize;
        protected int mBlueSize;
        protected int mAlphaSize;
        protected int mDepthSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ComponentSizeChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
            super(new int[]{12324, redSize, 12323, greenSize, 12322, blueSize, 12321, alphaSize, 12325, depthSize, 12326, stencilSize, 12344});
            this.mRedSize = redSize;
            this.mGreenSize = greenSize;
            this.mBlueSize = blueSize;
            this.mAlphaSize = alphaSize;
            this.mDepthSize = depthSize;
            this.mStencilSize = stencilSize;
        }

        private int m7684a(EGL10 egl, EGLDisplay display, EGLConfig config, int attribute, int defaultValue) {
            return egl.eglGetConfigAttrib(display, config, attribute, this.mValue) ? this.mValue[0] : defaultValue;
        }

        public EGLConfig mo5873a(EGL10 egl, EGLDisplay display, EGLConfig[] configs) {
            EGLConfig[] var4 = configs;
            int var5 = configs.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                EGLConfig config = var4[var6];
                int d = this.m7684a(egl, display, config, 12325, 0);
                int s = this.m7684a(egl, display, config, 12326, 0);
                if (d >= this.mDepthSize && s >= this.mStencilSize) {
                    int r = this.m7684a(egl, display, config, 12324, 0);
                    int g = this.m7684a(egl, display, config, 12323, 0);
                    int b = this.m7684a(egl, display, config, 12322, 0);
                    int a = this.m7684a(egl, display, config, 12321, 0);
                    if (r == this.mRedSize && g == this.mGreenSize && b == this.mBlueSize && a == this.mAlphaSize) {
                        return config;
                    }
                }
            }

            return null;
        }
    }


    private class DefaultContextFactory implements C1588f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public EGLContext mo5851a(EGL10 egl, EGLDisplay display, EGLConfig config) {
            int[] attrib_list = new int[]{this.EGL_CONTEXT_CLIENT_VERSION, C1590w.this.mEGLContextClientVersion, 12344};
            return egl.eglCreateContext(display, config, EGL10.EGL_NO_CONTEXT, C1590w.this.mEGLContextClientVersion != 0 ? attrib_list : null);
        }

        public void mo5852a(EGL10 egl, EGLDisplay display, EGLContext context) {
            if (!egl.eglDestroyContext(display, context)) {
                throw new RuntimeException("eglDestroyContext failed");
            }
        }
    }

    public interface C1596g {
        EGLSurface mo5874a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void mo5875a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    private static class C1597d implements C1596g {
        private C1597d() {
        }

        public EGLSurface mo5874a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
        }

        public void mo5875a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    private class EglHelper {
        EGL10 mEgl;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        EGLConfig mEglConfig;
        EGLContext mEglContext;


        private void throwEglException(String function) {
            this.throwEglException(function, this.mEgl.eglGetError());
        }

        private void throwEglException(String function, int error) {
            String message = function + " failed";
            throw new RuntimeException(message);
        }

        public GL mo5876a(SurfaceHolder holder) {
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.mEglConfig == null) {
                throw new RuntimeException("mEglConfig not initialized");
            } else {
                if (this.mEglSurface != null && this.mEglSurface != EGL10.EGL_NO_SURFACE) {
                    this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                    C1590w.this.mEGLWindowSurfaceFactory.mo5875a(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }

                this.mEglSurface = C1590w.this.mEGLWindowSurfaceFactory.mo5874a(this.mEgl, this.mEglDisplay, this.mEglConfig, holder);
                if (this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE) {
                    int error = this.mEgl.eglGetError();
                    if (error == 12299) {
                        return null;
                    }

                    this.throwEglException("createWindowSurface", error);
                }

                if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
                    this.throwEglException("eglMakeCurrent");
                }

                GL gl = this.mEglContext.getGL();
                if (C1590w.this.mGLWrapper != null) {
                    gl = C1590w.this.mGLWrapper.mo5900a(gl);
                }

                if ((C1590w.this.mDebugFlags & 1) != 0) {
                    int configFlags = 0;
                    Writer log = null;
                    if ((C1590w.this.mDebugFlags & 1) != 0) {
                        configFlags |= 1;
                    }

                    if (C1590w.this.mDebugFlags != 0) {
                        log = new C1590w.C1602l();
                    }

                    gl = GLDebugHelper.wrap(gl, configFlags, log);
                }

                return gl;
            }
        }

        public void mo5877a() {
            this.mEgl = (EGL10) EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            } else {
                int[] version = new int[2];
                if (!this.mEgl.eglInitialize(this.mEglDisplay, version)) {
                    throw new RuntimeException("eglInitialize failed");
                } else {
                    this.mEglConfig = C1590w.this.mEGLConfigChooser.mo5849a(this.mEgl, this.mEglDisplay);
                    this.mEglContext = C1590w.this.mEGLContextFactory.mo5851a(this.mEgl, this.mEglDisplay, this.mEglConfig);
                    if (this.mEglContext == null || this.mEglContext == EGL10.EGL_NO_CONTEXT) {
                        this.mEglContext = null;
                        this.throwEglException("createContext");
                    }

                    this.mEglSurface = null;
                }
            }
        }


        public boolean mo5878b() {
            if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                int error = this.mEgl.eglGetError();
                switch (error) {
                    case 12299:
                        break;
                    case 12302:
                        return false;
                    default:
                        this.throwEglException("eglSwapBuffers", error);
                }
            }

            return true;
        }

        public void mo5879c() {
            if (this.mEglSurface != null && this.mEglSurface != EGL10.EGL_NO_SURFACE) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                C1590w.this.mEGLWindowSurfaceFactory.mo5875a(this.mEgl, this.mEglDisplay, this.mEglSurface);
                this.mEglSurface = null;
            }

        }

        /* renamed from: d */
        public void mo5880d() {
            if (this.mEglContext != null) {
                C1590w.this.mEGLContextFactory.mo5852a(this.mEgl, this.mEglDisplay, this.mEglContext);
                this.mEglContext = null;
            }

            if (this.mEglDisplay != null) {
                this.mEgl.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = null;
            }

        }
    }

    /* renamed from: com.dermandar.a.w$i */
    class C1599i extends Thread {
        private boolean mShouldExit;
        private boolean mExited;
        private boolean mRequestPaused;
        private boolean mPaused;
        private boolean mHasSurface;
        private boolean mWaitingForSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mRenderMode = 1;
        private boolean mRequestRender = true;
        private boolean mBufferSwap = true;
        private boolean mRenderComplete;
        private ArrayList<Runnable> mEventQueue = new ArrayList();
        private C1591m mRenderer;
        private EglHelper mEglHelper;

        C1599i(C1591m renderer) {
            this.mRenderer = renderer;
        }

        public void run() {
            setName("GLThread " + getId());
            try {
                m7702j();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                C1590w.sGLThreadManager.mo5894a(this);
            }
        }

        private void m7700h() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.mo5879c();
            }
        }

        /* renamed from: i */
        private void m7701i() {
            if (this.mHaveEglContext) {
                this.mEglHelper.mo5880d();
                this.mHaveEglContext = false;
                C1590w.sGLThreadManager.mo5899c(this);
            }
        }

        private void m7702j() throws InterruptedException {
            this.mEglHelper = C1590w.this.new EglHelper();
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            boolean var25 = false;

            label359: {
                try {
                    var25 = true;
                    GL10 gl = null;
                    boolean createEglContext = false;
                    boolean createEglSurface = false;
                    boolean lostEglContext = false;
                    boolean sizeChanged = false;
                    boolean wantRenderNotification = false;
                    boolean doRenderNotification = false;
                    int w = 0;
                    int h = 0;
                    Runnable event = null;

                    while (true) {
                        if (this.isInterrupted()) {
                            var25 = false;
                            break;
                        }

                        synchronized (C1590w.sGLThreadManager) {
                            for (; !this.isInterrupted(); C1590w.sGLThreadManager.wait()) {
                                if (this.mShouldExit) {
                                    var25 = false;
                                    break label359;
                                }

                                if (!this.mEventQueue.isEmpty()) {
                                    event = (Runnable) this.mEventQueue.remove(0);
                                    break;
                                }

                                if (this.mPaused != this.mRequestPaused) {
                                    this.mPaused = this.mRequestPaused;
                                    C1590w.sGLThreadManager.notifyAll();
                                }

                                if (lostEglContext) {
                                    this.m7700h();
                                    this.m7701i();
                                    lostEglContext = false;
                                }

                                if (this.mHaveEglSurface && this.mPaused) {
                                    this.m7700h();
                                    if (C1590w.sGLThreadManager.mo5896a()) {
                                        this.m7701i();
                                    }

                                    if (C1590w.sGLThreadManager.mo5897b()) {
                                        this.mEglHelper.mo5880d();
                                    }
                                }

                                if (!this.mHasSurface && !this.mWaitingForSurface) {
                                    if (this.mHaveEglSurface) {
                                        this.m7700h();
                                    }

                                    this.mWaitingForSurface = true;
                                    C1590w.sGLThreadManager.notifyAll();
                                }

                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    C1590w.sGLThreadManager.notifyAll();
                                }

                                if (doRenderNotification) {
                                    wantRenderNotification = false;
                                    doRenderNotification = false;
                                    this.mRenderComplete = true;
                                    C1590w.sGLThreadManager.notifyAll();
                                }

                                if (!this.mPaused && this.mHasSurface && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1)) {
                                    if (!this.mHaveEglContext && C1590w.sGLThreadManager.mo5898b(this)) {
                                        try {
                                            this.mEglHelper.mo5877a();
                                        } catch (RuntimeException var29) {
                                            var29.printStackTrace();
                                            C1590w.sGLThreadManager.mo5899c(this);
                                            throw var29;
                                        }

                                        this.mHaveEglContext = true;
                                        createEglContext = true;
                                        C1590w.sGLThreadManager.notifyAll();
                                    }

                                    if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                        this.mHaveEglSurface = true;
                                        createEglSurface = true;
                                        sizeChanged = true;
                                    }

                                    if (this.mHaveEglSurface) {
                                        if (C1590w.this.mSizeChanged) {
                                            sizeChanged = true;
                                            w = this.mWidth;
                                            h = this.mHeight;
                                            wantRenderNotification = true;
                                            C1590w.this.mSizeChanged = false;
                                        } else {
                                            this.mRequestRender = false;
                                        }

                                        C1590w.sGLThreadManager.notifyAll();
                                        break;
                                    }
                                }
                            }
                        }

                        if (event != null) {
                            event.run();
                            event = null;
                        } else {
                            if (createEglSurface) {
                                gl = (GL10) this.mEglHelper.mo5876a(C1590w.this.getHolder());
                                if (gl == null) {
                                    var25 = false;
                                    break;
                                }

                                C1590w.sGLThreadManager.mo5895a(gl);
                                createEglSurface = false;
                            }

                            if (createEglContext) {
                                this.mRenderer.mo5872a(gl, this.mEglHelper.mEglConfig);
                                createEglContext = false;
                            }

                            if (sizeChanged) {
                                this.mRenderer.mo5871a(gl, w, h);
                                sizeChanged = false;
                            }

                            this.mRenderer.mo5870a(gl);
                            if (this.mBufferSwap && !this.mEglHelper.mo5878b()) {
                                lostEglContext = true;
                            }

                            if (wantRenderNotification) {
                                doRenderNotification = true;
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                } finally {
                    if (var25) {
                        synchronized(C1590w.sGLThreadManager) {
                            this.mRenderer.mo5869a();
                            this.m7700h();
                            this.m7701i();
                        }
                    }
                }

                synchronized(C1590w.sGLThreadManager) {
                    this.mRenderer.mo5869a();
                    this.m7700h();
                    this.m7701i();
                    return;
                }
            }

            synchronized(C1590w.sGLThreadManager) {
                this.mRenderer.mo5869a();
                this.m7700h();
                this.m7701i();
            }
        }

        public void mo5881a() {
            synchronized(C1590w.sGLThreadManager) {
                this.mRequestRender = true;
                C1590w.sGLThreadManager.notifyAll();
            }
        }

        public void mo5882a(int renderMode) {
            if (0 <= renderMode && renderMode <= 1) {
                synchronized(C1590w.sGLThreadManager) {
                    this.mRenderMode = renderMode;
                    C1590w.sGLThreadManager.notifyAll();
                }
            } else {
                throw new IllegalArgumentException("renderMode");
            }
        }

        public void mo5884a(C1591m renderer) {
            synchronized (C1590w.sGLThreadManager) {
                this.mRenderer = renderer;
            }
        }

        public void mo5885a(Runnable r) {
            if (r == null) {
                throw new IllegalArgumentException("r must not be null");
            } else {
                synchronized(C1590w.sGLThreadManager) {
                    this.mEventQueue.add(r);
                    C1590w.sGLThreadManager.notifyAll();
                }
            }
        }


        public void mo5883a(int w, int h) {
            synchronized(C1590w.sGLThreadManager) {
                this.mWidth = w;
                this.mHeight = h;
                C1590w.this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                C1590w.sGLThreadManager.notifyAll();

                while(!this.mExited && !this.mPaused && !this.mRenderComplete) {
                    try {
                        C1590w.sGLThreadManager.wait();
                    } catch (InterruptedException var6) {
                        var6.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }

            }
        }

        public void mo5886a(boolean isSwap) {
            synchronized (C1590w.sGLThreadManager) {
                this.mBufferSwap = isSwap;
            }
        }

        public void mo5889d() {
           // this.f4451b = true;
        }


        public void mo5890e() {
            synchronized(C1590w.sGLThreadManager) {
                this.mRequestPaused = true;
                C1590w.sGLThreadManager.notifyAll();

                while(!this.mExited && !this.mPaused) {
                    try {
                        C1590w.sGLThreadManager.wait();
                    } catch (InterruptedException var4) {
                        var4.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }

            }
        }

        public void mo5891f() {
            synchronized(C1590w.sGLThreadManager) {
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                C1590w.sGLThreadManager.notifyAll();

                while(!this.mExited && this.mPaused && !this.mRenderComplete) {
                    try {
                        C1590w.sGLThreadManager.wait();
                    } catch (InterruptedException var4) {
                        var4.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }

            }
        }


        public void mo5887b() {
            synchronized(C1590w.sGLThreadManager) {
                this.mHasSurface = true;
                C1590w.sGLThreadManager.notifyAll();

                while(this.mWaitingForSurface && !this.mExited) {
                    try {
                        C1590w.sGLThreadManager.wait();
                    } catch (InterruptedException var4) {
                        var4.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }

            }
        }

        public void mo5888c() {
            synchronized(C1590w.sGLThreadManager) {
                this.mHasSurface = false;
                C1590w.sGLThreadManager.notifyAll();

                while(!this.mWaitingForSurface && !this.mExited) {
                    try {
                        C1590w.sGLThreadManager.wait();
                    } catch (InterruptedException var4) {
                        var4.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }

            }
        }

        public void mo5892g() {
            synchronized(C1590w.sGLThreadManager) {
                this.mShouldExit = true;
                C1590w.sGLThreadManager.notifyAll();

                while(!this.mExited) {
                    try {
                        C1590w.sGLThreadManager.wait();
                    } catch (InterruptedException var4) {
                        var4.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }

            }
        }

    }


    private static class GLThreadManager {
        private static String f4468a = "GLThreadManager";
        private boolean mGLESVersionCheckComplete;
        private int mGLESVersion;
        private boolean mGLESDriverCheckComplete;
        private boolean mMultipleGLESContextsAllowed;
        private C1599i mEglOwner;

        private GLThreadManager() {
        }

        public synchronized void mo5894a(C1599i thread) {
            thread.mExited = true;
            if (this.mEglOwner == thread) {
                this.mEglOwner = null;
            }

            this.notifyAll();
        }

        public boolean mo5898b(C1599i thread) {
            if (this.mEglOwner != thread && this.mEglOwner != null) {
                this.checkGLESVersion();
                return this.mMultipleGLESContextsAllowed;
            } else {
                this.mEglOwner = thread;
                this.notifyAll();
                return true;
            }
        }

        private void checkGLESVersion() {
            if (!this.mGLESVersionCheckComplete) {
                this.mGLESVersion = 0;
                if (this.mGLESVersion >= 131072) {
                    this.mMultipleGLESContextsAllowed = true;
                }
                this.mGLESVersionCheckComplete = true;
            }

        }


        public synchronized void mo5895a(GL10 gl) {
            if (!this.mGLESDriverCheckComplete) {
                this.checkGLESVersion();
                if (this.mGLESVersion < 131072) {
                    String renderer = gl.glGetString(7937);
                    this.mMultipleGLESContextsAllowed = !renderer.startsWith("Q3Dimension MSM7500 ");
                    this.notifyAll();
                }

                this.mGLESDriverCheckComplete = true;
            }

        }

        public synchronized boolean mo5896a() {
            return false;
        }

        public synchronized boolean mo5897b() {
            this.checkGLESVersion();
            return !this.mMultipleGLESContextsAllowed;
        }

        public void mo5899c(C1599i thread) {
            if (this.mEglOwner == thread) {
                this.mEglOwner = null;
            }

            this.notifyAll();
        }
    }

    public interface C1601k {
        GL mo5900a(GL gl);
    }


    static class C1602l extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        C1602l() {
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                this.mBuilder.delete(0, this.mBuilder.length());
            }
        }

        public void close() {
            flushBuilder();
        }

        public void flush() {
            flushBuilder();
        }

        public void write(char[] buf, int offset, int count) {
            for (int i = 0; i < count; ++i) {
                char c = buf[offset + i];
                if (c == '\n') {
                    this.flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }
    }

    private class C1603n extends ComponentSizeChooser {
        public C1603n(boolean z) {
            super(5, 6, 5, 0, z ? 16 : 0, 0);
        }
    }


    private void m7664j() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public C1599i mo5853a() {
        return this.mGLThread;
    }

    public void mo5857a(C1591m renderer) {
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new C1603n(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new C1597d();
        }
        if (this.mGLThread == null) {
            this.mGLThread = new C1599i(renderer);
            this.mGLThread.start();
        } else {
            this.mGLThread.mo5884a(renderer);
        }
    }

    public void mo5860c() {
        this.mGLThread.mo5886a(false);
    }

    public void mo5861d() {
        this.mGLThread.mo5886a(true);
    }

    public void mo5855a(C1586e configChooser) {
        m7664j();
        this.mEGLConfigChooser = configChooser;
    }

    public void mo5856a(C1588f factory) {
        m7664j();
        this.mEGLContextFactory = factory;
    }

    public void mo5858a(Runnable runnable) {
        this.mGLThread.mo5885a(runnable);
    }


    /* renamed from: a */
    public void mo5854a(int i) {
        this.mGLThread.mo5882a(i);
    }

    /* renamed from: b */
    public void mo5859b() {
        this.mGLThread.mo5881a();
    }


    /* renamed from: f */
    public void mo5863f() {
        this.mGLThread.mo5889d();
    }



    public void mo5862e() {
        this.mGLThread.mo5890e();
    }

    public void mo5864g() {
        this.mGLThread.mo5891f();
    }


    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }


    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mGLThread.mo5883a(i2, i3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mGLThread.mo5887b();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mGLThread.mo5888c();
    }


}
