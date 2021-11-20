package com.dermandar.p047a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.opengl.GLES20;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.dermandar.p047a.C1581ae.C1580b;
import com.dermandar.p047a.C1584ag.C1583a;
import com.dermandar.p047a.C1590w.C1591m;
import com.nativesystem.ViewerJNI;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.dermandar.a.r */
public class C1738r {
    /* renamed from: A */
    private int f4898A = 1;
    /* renamed from: B */
    private double f4899B;
    /* renamed from: C */
    private boolean f4900C;
    /* renamed from: D */
    private int f4901D;
    /* renamed from: E */
    private Timer f4902E;
    /* renamed from: F */
    private long f4903F = 5;
    /* renamed from: G */
    private boolean f4904G = false;
    /* renamed from: H */
    private C1580b f4905H = new C17191();
    /* renamed from: I */
    private String f4906I;
    /* renamed from: J */
    private int f4907J;
    /* renamed from: K */
    private int f4908K;
    /* renamed from: L */
    private int f4909L;
    /* renamed from: M */
    private boolean f4910M;
    /* renamed from: N */
    private Runnable f4911N = new C17202();
    /* renamed from: O */
    private Runnable f4912O = new C17213();
    /* renamed from: P */
    private Runnable f4913P = new C17224();
    /* renamed from: Q */
    private Runnable f4914Q = new C17235();
    /* renamed from: R */
    private ScaleGestureDetector f4915R;
    /* renamed from: S */
    private GestureDetector f4916S;
    /* renamed from: T */
    private float f4917T = 1.0f;
    /* renamed from: U */
    private int f4918U;
    /* renamed from: V */
    private int f4919V = -1;
    /* renamed from: W */
    private C1583a f4920W = C1583a.TouchEnd;
    /* renamed from: X */
    private boolean f4921X;
    /* renamed from: Y */
    private boolean f4922Y;
    /* renamed from: Z */
    private OnTouchListener f4923Z = new C17286();
    /* renamed from: a */
    public String f4924a = "DMD_Library";
    /* renamed from: aa */
    private int f4925aa;
    /* renamed from: ab */
    private int f4926ab;
    /* renamed from: ac */
    private boolean f4927ac;
    /* renamed from: ad */
    private C1591m f4928ad = new C17307();
    /* renamed from: ae */
    private boolean f4929ae;
    /* renamed from: b */
    private Handler f4930b;
    /* renamed from: c */
    private RelativeLayout f4931c;
    /* renamed from: d */
    private C1604ah f4932d;
    /* renamed from: e */
    private ProgressBar f4933e;
    /* renamed from: f */
    private C1581ae f4934f;
    /* renamed from: g */
    private C1615d f4935g;
    /* renamed from: h */
    private boolean f4936h;
    /* renamed from: i */
    private boolean f4937i;
    /* renamed from: j */
    private boolean f4938j;
    /* renamed from: k */
    private boolean f4939k;
    /* renamed from: l */
    private boolean f4940l;
    /* renamed from: m */
    private String f4941m;
    /* renamed from: n */
    private String f4942n;
    /* renamed from: o */
    private String f4943o;
    /* renamed from: p */
    private int f4944p = 0;
    /* renamed from: q */
    private long f4945q;
    /* renamed from: r */
    private boolean f4946r = true;
    /* renamed from: s */
    private boolean f4947s;
    /* renamed from: t */
    private boolean f4948t;
    /* renamed from: u */
    private boolean f4949u;
    /* renamed from: v */
    private boolean f4950v;
    /* renamed from: w */
    private DisplayMetrics f4951w;
    /* renamed from: x */
    private float[] f4952x = new float[16];
    /* renamed from: y */
    private float[] f4953y = new float[4];
    /* renamed from: z */
    private long f4954z = 0;

    /* renamed from: com.dermandar.a.r$1 */
    class C17191 implements C1580b {
        C17191() {
        }

        /* renamed from: a */
        public void mo5839a(double[] dArr, double[] dArr2, float f) {
        }

        /* renamed from: a */
        public void mo5840a(double[] dArr, double[] dArr2, double[] dArr3, float f) {
            if (C1738r.this.f4939k) {
                float[] fArr = new float[16];
                if (C1738r.this.f4929ae) {
                    if (C1738r.this.f4900C) {
                        fArr[0] = (float) dArr2[4];
                        fArr[1] = -((float) dArr2[1]);
                        fArr[2] = -((float) dArr2[7]);
                        fArr[3] = 0.0f;
                        fArr[4] = -((float) dArr2[5]);
                        fArr[5] = (float) dArr2[2];
                        fArr[6] = (float) dArr2[8];
                        fArr[7] = 0.0f;
                        fArr[8] = (float) dArr2[3];
                        fArr[9] = -((float) dArr2[0]);
                        fArr[10] = -((float) dArr2[6]);
                        fArr[11] = 0.0f;
                        fArr[12] = 0.0f;
                        fArr[13] = 0.0f;
                        fArr[14] = 0.0f;
                        fArr[15] = 1.0f;
                    } else {
                        fArr[0] = (float) dArr2[0];
                        fArr[1] = (float) dArr2[3];
                        fArr[2] = (float) dArr2[6];
                        fArr[3] = 0.0f;
                        fArr[4] = (float) dArr2[2];
                        fArr[5] = (float) dArr2[5];
                        fArr[6] = (float) dArr2[8];
                        fArr[7] = 0.0f;
                        fArr[8] = -((float) dArr2[1]);
                        fArr[9] = -((float) dArr2[4]);
                        fArr[10] = -((float) dArr2[7]);
                        fArr[11] = 0.0f;
                        fArr[12] = 0.0f;
                        fArr[13] = 0.0f;
                        fArr[14] = 0.0f;
                        fArr[15] = 1.0f;
                    }
                } else if (C1738r.this.f4900C) {
                    fArr[0] = (float) dArr2[0];
                    fArr[1] = (float) dArr2[3];
                    fArr[2] = (float) dArr2[6];
                    fArr[3] = 0.0f;
                    fArr[4] = (float) dArr2[1];
                    fArr[5] = (float) dArr2[4];
                    fArr[6] = (float) dArr2[7];
                    fArr[7] = 0.0f;
                    fArr[8] = (float) dArr2[2];
                    fArr[9] = (float) dArr2[5];
                    fArr[10] = (float) dArr2[8];
                    fArr[11] = 0.0f;
                    fArr[12] = 0.0f;
                    fArr[13] = 0.0f;
                    fArr[14] = 0.0f;
                    fArr[15] = 1.0f;
                } else {
                    fArr[0] = (float) dArr2[4];
                    fArr[1] = -((float) dArr2[1]);
                    fArr[2] = -((float) dArr2[7]);
                    fArr[3] = 0.0f;
                    fArr[4] = -((float) dArr2[5]);
                    fArr[5] = (float) dArr2[2];
                    fArr[6] = (float) dArr2[8];
                    fArr[7] = 0.0f;
                    fArr[8] = (float) dArr2[3];
                    fArr[9] = -((float) dArr2[0]);
                    fArr[10] = -((float) dArr2[6]);
                    fArr[11] = 0.0f;
                    fArr[12] = 0.0f;
                    fArr[13] = 0.0f;
                    fArr[14] = 0.0f;
                    fArr[15] = 1.0f;
                }
                float[] fArr2;
                if (C1738r.this.f4898A == -1) {
                    fArr2 = new float[16];
                    C1569aa.m7580a(fArr2);
                    if (C1738r.this.f4929ae) {
                        if (!C1738r.this.f4900C) {
                            C1569aa.m7581a(fArr2, 0.0d, 0.0d, 3.141592653589793d);
                            C1569aa.m7583a(fArr2, fArr, fArr);
                        }
                    } else if (C1738r.this.f4900C) {
                        C1569aa.m7581a(fArr2, -1.5707963267948966d, 0.0d, 0.0d);
                        C1569aa.m7583a(fArr, fArr2, fArr);
                    } else {
                        C1569aa.m7581a(fArr2, 0.0d, 0.0d, 3.141592653589793d);
                        C1569aa.m7583a(fArr2, fArr, fArr);
                    }
                } else if (C1738r.this.f4898A == 1 && C1738r.this.f4929ae && C1738r.this.f4900C) {
                    fArr2 = new float[16];
                    C1569aa.m7580a(fArr2);
                    if (C1738r.this.f4900C) {
                        C1569aa.m7581a(fArr2, 0.0d, 0.0d, 3.141592653589793d);
                        C1569aa.m7583a(fArr, fArr2, fArr);
                    }
                }
                synchronized (C1738r.this.f4952x) {
                    C1738r.this.f4952x = (float[]) fArr.clone();
                }
                synchronized (C1738r.this.f4953y) {
                    if (C1738r.this.f4929ae) {
                        if (C1738r.this.f4900C) {
                            C1738r.this.f4953y[0] = (-1.0f * ((float) dArr[0])) * ((float) C1738r.this.f4898A);
                            C1738r.this.f4953y[1] = ((float) dArr[1]) * ((float) C1738r.this.f4898A);
                            C1738r.this.f4953y[2] = (float) dArr[2];
                        } else {
                            C1738r.this.f4953y[1] = ((float) dArr[0]) * ((float) C1738r.this.f4898A);
                            C1738r.this.f4953y[0] = ((float) dArr[1]) * ((float) C1738r.this.f4898A);
                            C1738r.this.f4953y[2] = (float) dArr[2];
                        }
                    } else if (C1738r.this.f4900C) {
                        C1738r.this.f4953y[1] = (((float) dArr[0]) * ((float) C1738r.this.f4898A)) * -1.0f;
                        C1738r.this.f4953y[0] = (((float) dArr[1]) * ((float) C1738r.this.f4898A)) * -1.0f;
                        C1738r.this.f4953y[2] = (float) dArr[2];
                    } else {
                        C1738r.this.f4953y[0] = ((float) dArr[0]) * ((float) C1738r.this.f4898A);
                        C1738r.this.f4953y[1] = (((float) dArr[1]) * ((float) C1738r.this.f4898A)) * -1.0f;
                        C1738r.this.f4953y[2] = (float) dArr[2];
                    }
                }
                if (C1738r.this.f4935g != null) {
                    C1738r.this.f4935g.mo5925a((int) f);
                }
            }
        }
    }

    /* renamed from: com.dermandar.a.r$2 */
    class C17202 implements Runnable {
        C17202() {
        }

        public void run() {
            C1738r.this.m8230f();
            C1738r.this.f4950v = false;
            if (C1738r.this.f4935g != null) {
                C1738r.this.f4935g.mo5928c();
            }
        }
    }

    /* renamed from: com.dermandar.a.r$3 */
    class C17213 implements Runnable {
        C17213() {
        }

        public void run() {
            ViewerJNI.gyroVisibility(C1738r.this.f4937i);
            ViewerJNI.cardboardVisibility(C1738r.this.f4938j);
            ViewerJNI.setPPI(C1738r.this.f4899B);
            C1738r.this.f4948t = true;
            C1738r.this.f4932d.mo5861d();
        }
    }

    /* renamed from: com.dermandar.a.r$4 */
    class C17224 implements Runnable {
        C17224() {
        }

        public void run() {
            if (C1738r.this.f4935g != null) {
                C1738r.this.f4935g.mo5927b();
            }
        }
    }

    /* renamed from: com.dermandar.a.r$5 */
    class C17235 implements Runnable {
        C17235() {
        }

        public void run() {
            C1738r.this.f4948t = true;
            C1738r.this.f4932d.mo5861d();
            if (C1738r.this.f4935g != null) {
                try {
                    C1738r.this.f4935g.mo5929d();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.dermandar.a.r$6 */
    class C17286 implements OnTouchListener {

        /* renamed from: com.dermandar.a.r$6$3 */
        class C17263 implements Runnable {
            C17263() {
            }

            public void run() {
                ViewerJNI.end();
            }
        }

        /* renamed from: com.dermandar.a.r$6$4 */
        class C17274 implements Runnable {
            C17274() {
            }

            public void run() {
                if (C1738r.this.f4922Y) {
                    C1738r.this.f4922Y = false;
                    if (C1738r.this.f4939k) {
                        C1738r.this.f4939k = false;
                        ViewerJNI.setGyro(false);
                        C1738r.this.f4934f.mo5845c();
                        if (C1738r.this.f4935g != null) {
                            C1738r.this.f4935g.mo5926a(false);
                        }
                    }
                }
            }
        }

        C17286() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!C1738r.this.f4915R.onTouchEvent(motionEvent) || !C1738r.this.f4915R.isInProgress()) {
                final float x;
                final float y;
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        C1738r.this.f4918U = motionEvent.getPointerId(0);
                        if (C1738r.this.f4920W == C1583a.TouchEnd) {
                            C1738r.this.f4920W = C1583a.TouchStart;
                            C1738r.this.f4932d.mo5858a((Runnable) new Runnable() {
                                public void run() {
                                    ViewerJNI.start((double) x, (double) y);
                                }
                            });
                            break;
                        }
                        break;
                    case 1:
                        C1738r.this.f4917T = 1.0f;
                        C1738r.this.f4918U = C1738r.this.f4919V;
                        if (C1738r.this.f4920W != C1583a.TouchEnd) {
                            C1738r.this.f4920W = C1583a.TouchEnd;
                            C1738r.this.f4921X = true;
                            C1738r.this.f4932d.mo5858a((Runnable) new C17263());
                            break;
                        }
                        break;
                    case 2:
                        int findPointerIndex = motionEvent.findPointerIndex(C1738r.this.f4918U);
                        if (findPointerIndex >= 0 && findPointerIndex < motionEvent.getPointerCount()) {
                            y = motionEvent.getX(findPointerIndex);
                            x = motionEvent.getY(findPointerIndex);
                            if (C1738r.this.f4920W == C1583a.TouchStart || C1738r.this.f4920W == C1583a.TouchMove) {
                                C1738r.this.f4920W = C1583a.TouchMove;
                                C1738r.this.f4932d.mo5858a((Runnable) new Runnable() {
                                    public void run() {
                                        ViewerJNI.move((double) y, (double) x);
                                    }
                                });
                                break;
                            }
                        }
                        return false;
                    case 3:
                        C1738r.this.f4918U = C1738r.this.f4919V;
                        break;
                }
                if (C1738r.this.f4916S.onTouchEvent(motionEvent)) {
                    C1738r.this.f4922Y = false;
                    return true;
                }
                C1738r.this.f4922Y = true;
                if (!C1738r.this.f4939k || !C1738r.this.f4921X) {
                    return true;
                }
                C1738r.this.f4921X = false;
                C1738r.this.f4930b.postDelayed(new C17274(), 300);
                return true;
            } else if (!C1738r.this.f4939k) {
                return true;
            } else {
                C1738r.this.f4939k = false;
                ViewerJNI.setGyro(false);
                C1738r.this.f4934f.mo5845c();
                if (C1738r.this.f4935g == null) {
                    return true;
                }
                C1738r.this.f4935g.mo5926a(false);
                return true;
            }
        }
    }

    /* renamed from: com.dermandar.a.r$7 */
    class C17307 implements C1591m {

        /* renamed from: com.dermandar.a.r$7$1 */
        class C17291 implements Runnable {
            C17291() {
            }

            public void run() {
                if (C1738r.this.f4931c != null && C1738r.this.f4933e != null && C1738r.this.f4933e.getParent() != null) {
                    C1738r.this.f4931c.removeView(C1738r.this.f4933e);
                }
            }
        }

        C17307() {
        }

        /* renamed from: a */
        public void mo5869a() {
            C1738r.this.f4950v = false;
            C1738r.this.f4948t = false;
            ViewerJNI.release();
            C1738r.this.f4930b.post(C1738r.this.f4911N);
            C1738r.this.f4904G = true;
        }

        /* renamed from: a */
        public void mo5870a(GL10 gl10) {
            if (C1738r.this.f4950v) {
                C1738r.this.f4950v = false;
                C1738r.this.f4948t = false;
                ViewerJNI.release();
                C1738r.this.f4930b.post(C1738r.this.f4911N);
                C1738r.this.f4904G = true;
                return;
            }
            if (C1738r.this.f4949u) {
                C1738r.this.f4949u = false;
                ViewerJNI.view(C1738r.this.f4936h, (int) C1738r.this.f4945q, C1738r.this.f4941m, C1738r.this.f4942n, C1738r.this.f4943o, C1738r.this.f4929ae ? C1753x.f5034h : C1753x.f5035i, C1738r.this.f4929ae ? C1753x.f5035i : C1753x.f5034h, C1738r.this.f4951w.density, C1738r.this.f4944p);
                C1738r.this.f4930b.post(C1738r.this.f4912O);
            }
            if (C1738r.this.f4910M) {
                C1738r.this.f4910M = false;
                ViewerJNI.exportEqui(C1738r.this.f4906I, C1738r.this.f4907J, C1738r.this.f4908K, C1738r.this.f4909L);
                C1738r.this.f4930b.post(C1738r.this.f4914Q);
                return;
            }
            if (ViewerJNI.isReady()) {
                if (C1738r.this.f4947s) {
                    C1738r.this.f4930b.post(C1738r.this.f4913P);
                    C1738r.this.f4947s = false;
                    C1738r.this.f4930b.post(new C17291());
                }
                if (C1738r.this.f4927ac) {
                    C1738r.this.f4927ac = false;
                    GLES20.glViewport(0, 0, C1738r.this.f4925aa, C1738r.this.f4926ab);
                    ViewerJNI.setDim(C1738r.this.f4925aa, C1738r.this.f4926ab, C1738r.this.f4951w.density);
                }
                if (C1738r.this.f4939k) {
                    long nanoTime = System.nanoTime();
                    if (C1738r.this.f4954z == 0) {
                        C1738r.this.f4954z = nanoTime;
                    }
                    C1738r.this.f4953y[3] = ((float) (nanoTime - C1738r.this.f4954z)) / 1.0E9f;
                    synchronized (C1738r.this.f4952x) {
                        ViewerJNI.updateGyro(C1738r.this.f4952x, C1738r.this.f4953y);
                    }
                    C1738r.this.f4954z = nanoTime;
                }
            }
            if (C1738r.this.f4948t) {
                ViewerJNI.draw();
            }
        }

        /* renamed from: a */
        public void mo5871a(GL10 gl10, int i, int i2) {
            C1738r.this.f4925aa = i;
            C1738r.this.f4926ab = i2;
            C1738r.this.f4927ac = true;
        }

        /* renamed from: a */
        public void mo5872a(GL10 gl10, EGLConfig eGLConfig) {
            try {
                int[] iArr = new int[1];
                GLES20.glGetIntegerv(3379, iArr, 0);
                C1753x.f5009A = iArr[0];
            } catch (Exception e) {
                C1753x.f5009A = 2048;
            }
        }
    }

    /* renamed from: com.dermandar.a.r$8 */
    class C17318 implements OnClickListener {
        C17318() {
        }

        public void onClick(View view) {
            if (C1738r.this.f4935g != null) {
                C1738r.this.f4935g.mo5924a();
            }
        }
    }

    /* renamed from: com.dermandar.a.r$9 */
    class C17329 extends TimerTask {
        C17329() {
        }

        public void run() {
            if (C1738r.this.f4932d == null) {
                C1738r.this.m8230f();
            } else {
                C1738r.this.f4932d.mo5859b();
            }
        }
    }

    /* renamed from: com.dermandar.a.r$a */
    private class C1735a implements OnDoubleTapListener, OnGestureListener {
        private C1735a() {
        }

        /* synthetic */ C1735a(C1738r c1738r, C17191 c17191) {
            this();
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            final float x = motionEvent.getX();
            final float y = motionEvent.getY();
            if (C1738r.this.f4920W == C1583a.TouchStart || C1738r.this.f4920W == C1583a.TouchMove) {
                C1738r.this.f4920W = C1583a.TouchZoom;
                C1738r.this.f4932d.mo5858a((Runnable) new Runnable() {
                    public void run() {
                        if (!C1738r.this.f4940l) {
                            ViewerJNI.dblclick((double) x, (double) y);
                        }
                    }
                });
            } else if (C1738r.this.f4920W == C1583a.TouchEnd) {
                C1738r.this.f4920W = C1583a.TouchZoom;
                C1738r.this.f4932d.mo5858a((Runnable) new Runnable() {
                    public void run() {
                        if (!C1738r.this.f4940l) {
                            ViewerJNI.start((double) x, (double) y);
                            ViewerJNI.dblclick((double) x, (double) y);
                        }
                    }
                });
            }
            if (C1738r.this.f4939k) {
                C1738r.this.f4939k = false;
                ViewerJNI.setGyro(false);
                C1738r.this.f4934f.mo5845c();
                if (C1738r.this.f4935g != null) {
                    C1738r.this.f4935g.mo5926a(false);
                }
            }
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            boolean z = false;
            ViewerJNI.click((double) motionEvent.getX(), (double) motionEvent.getY(), C1738r.this.f4929ae ? (double) C1753x.f5034h : (double) C1753x.f5035i, C1738r.this.f4929ae ? (double) C1753x.f5035i : (double) C1753x.f5034h);
            if (ViewerJNI.clickIsSD()) {
                ViewerJNI.setHD(false);
            } else if (ViewerJNI.clickIsHD()) {
                ViewerJNI.setHD(true);
            } else if (ViewerJNI.clickIsGyro()) {
                C1738r.this.f4939k = !ViewerJNI.getGyro();
                ViewerJNI.setGyro(C1738r.this.f4939k);
                if (C1738r.this.f4939k) {
                    C1738r.this.f4934f.mo5844b();
                } else {
                    C1738r.this.f4934f.mo5845c();
                }
                if (C1738r.this.f4935g != null) {
                    C1738r.this.f4935g.mo5926a(C1738r.this.f4939k);
                }
            } else if (ViewerJNI.clickIsCardboard()) {
                C1738r c1738r = C1738r.this;
                if (!ViewerJNI.getCardboard()) {
                    z = true;
                }
                c1738r.f4940l = z;
                ViewerJNI.setCardboard(C1738r.this.f4940l);
            } else if (C1738r.this.f4935g != null) {
                C1738r.this.f4935g.mo5924a();
            }
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: com.dermandar.a.r$b */
    private class C1737b extends SimpleOnScaleGestureListener {
        private C1737b() {
        }

        /* synthetic */ C1737b(C1738r c1738r, C17191 c17191) {
            this();
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            C1738r.this.f4917T = C1738r.this.f4917T * scaleGestureDetector.getScaleFactor();
            if (C1738r.this.f4920W == C1583a.TouchStart || C1738r.this.f4920W == C1583a.TouchPinchZoom || C1738r.this.f4920W == C1583a.TouchMove) {
                C1738r.this.f4920W = C1583a.TouchPinchZoom;
                final float W = C1738r.this.f4917T;
                C1738r.this.f4932d.mo5858a((Runnable) new Runnable() {
                    public void run() {
                        if (!C1738r.this.f4940l) {
                            ViewerJNI.zoom((double) W);
                        }
                    }
                });
            }
            return true;
        }
    }

    /* renamed from: b */
    private View m8219b(Context context, C1615d c1615d, String str, String str2, String str3, int i, int i2) {
        this.f4941m = str;
        this.f4942n = str2;
        this.f4943o = str3;
        this.f4944p = i;
        this.f4935g = c1615d;
        this.f4951w = context.getResources().getDisplayMetrics();
        this.f4930b = new Handler();
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        this.f4901D = i2;
        if (i2 == 0 || i2 == 2) {
            C1753x.f5034h = this.f4951w.widthPixels;
            C1753x.f5035i = this.f4951w.heightPixels;
        } else {
            C1753x.f5034h = this.f4951w.heightPixels;
            C1753x.f5035i = this.f4951w.widthPixels;
        }
        C1753x.f5036j = ((double) C1753x.f5035i) / ((double) C1753x.f5034h);
        rotation = this.f4929ae ? rotation == 0 ? 1 : -1 : rotation == 1 ? 1 : -1;
        this.f4898A = rotation;
        this.f4899B = (double) context.getResources().getDisplayMetrics().xdpi;
        mo6235a(context);
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        this.f4945q = memoryInfo.availMem / 1024;
        this.f4948t = false;
        this.f4950v = false;
        this.f4949u = true;
        this.f4934f = new C1581ae(context, this.f4905H);
        this.f4931c = new RelativeLayout(context);
        this.f4931c.setLayoutParams(new LayoutParams(-1, -1));
        this.f4915R = new ScaleGestureDetector(context, new C1737b(this, null));
        this.f4916S = new GestureDetector(context, new C1735a(this, null));
        this.f4932d = new C1604ah(context, this.f4928ad);
        if (this.f4946r) {
            this.f4932d.setOnTouchListener(this.f4923Z);
        }
        this.f4932d.setLayoutParams(new LayoutParams(-1, -1));
        this.f4932d.mo5854a(0);
        this.f4932d.mo5860c();
        this.f4931c.addView(this.f4932d);
        this.f4933e = new ProgressBar(context, null, 16842874);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f4933e.setLayoutParams(layoutParams);
        this.f4933e.setVisibility(0);
        this.f4931c.addView(this.f4933e);
        this.f4947s = true;
        return this.f4931c;
    }

    /* renamed from: e */
    private void m8227e() {
        if (this.f4902E == null) {
            this.f4902E = new Timer();
            this.f4902E.schedule(new C17329(), 0, this.f4903F);
        }
    }

    /* renamed from: f */
    private void m8230f() {
        if (this.f4902E != null) {
            this.f4902E.cancel();
            this.f4902E = null;
        }
    }

    /* renamed from: a */
    public View mo6231a(Context context, C1615d c1615d, String str, String str2, String str3, int i) {
        this.f4936h = true;
        this.f4937i = true;
        this.f4938j = false;
        return m8219b(context, c1615d, str, str2, str3, 0, i);
    }

    /* renamed from: a */
    public View mo6232a(Context context, C1615d c1615d, String str, String str2, String str3, int i, int i2) {
        this.f4936h = false;
        this.f4937i = true;
        this.f4938j = false;
        return m8219b(context, c1615d, str, str2, str3, i, i2);
    }

    /* renamed from: a */
    public void mo6233a() {
        m8230f();
        if (this.f4939k) {
            this.f4934f.mo5845c();
        }
    }

    /* renamed from: a */
    public void mo6234a(int i) {
        if (this.f4929ae) {
            if (i == 0 || i == 3) {
                this.f4898A = 1;
            } else {
                this.f4898A = -1;
            }
        } else if (i == 0 || i == 3) {
            this.f4898A = -1;
        } else {
            this.f4898A = 1;
        }
    }

    /* renamed from: a */
    public void mo6235a(Context context) {
        File file = new File((Environment.getExternalStorageDirectory().getPath() + "/Panoramas/") + "/log1.txt");
        try {
            String str = "xdpi: " + context.getResources().getDisplayMetrics().xdpi + " ydpi: " + context.getResources().getDisplayMetrics().ydpi + " densityDpi: " + context.getResources().getDisplayMetrics().densityDpi + " widthPixels: " + context.getResources().getDisplayMetrics().widthPixels + " scaledDensity: " + context.getResources().getDisplayMetrics().scaledDensity;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            Log.e("rmh", e2.toString());
        }
    }

    /* renamed from: a */
    public void mo6236a(String str, int i, int i2, int i3) {
        if (this.f4936h) {
            this.f4932d.mo5860c();
            this.f4906I = str;
            this.f4907J = Math.min(i, C1753x.f5009A);
            this.f4908K = i2;
            this.f4909L = i3;
            this.f4948t = false;
            this.f4910M = true;
        }
    }

    /* renamed from: a */
    public void mo6237a(boolean z) {
        this.f4929ae = z;
    }

    /* renamed from: b */
    public void mo6238b() {
        m8227e();
        if (this.f4939k) {
            this.f4934f.mo5844b();
        }
    }

    /* renamed from: b */
    public void mo6239b(boolean z) {
        ViewerJNI.setHD(z);
    }

    /* renamed from: c */
    public void mo6240c() {
        this.f4950v = true;
        if (this.f4939k) {
            this.f4934f.mo5845c();
            this.f4939k = false;
        }
    }

    /* renamed from: c */
    public void mo6241c(boolean z) {
        this.f4940l = z;
        ViewerJNI.setCardboard(this.f4940l);
    }

    /* renamed from: d */
    public void mo6242d() {
        this.f4950v = true;
        if (this.f4932d != null) {
            this.f4932d.mo5859b();
        }
        while (!this.f4904G) {
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f4904G = false;
        if (this.f4932d != null) {
            this.f4932d.mo5863f();
        }
    }

    /* renamed from: d */
    public void mo6243d(boolean z) {
        this.f4946r = z;
        if (this.f4932d == null) {
            return;
        }
        if (this.f4946r) {
            this.f4932d.setOnTouchListener(this.f4923Z);
            this.f4932d.setOnClickListener(null);
            return;
        }
        this.f4932d.setOnTouchListener(null);
        this.f4932d.setOnClickListener(new C17318());
    }

    /* renamed from: e */
    public void mo6244e(boolean z) {
        this.f4939k = z;
        ViewerJNI.setGyro(z);
        if (z) {
            if (this.f4934f != null) {
                this.f4934f.mo5844b();
            }
        } else if (this.f4934f != null) {
            this.f4934f.mo5845c();
        }
    }

    /* renamed from: f */
    public void mo6245f(boolean z) {
        this.f4900C = z;
    }
}
