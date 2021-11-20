package com.dermandar.p047a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.media.ExifInterface;
import android.opengl.GLES20;
import android.os.AsyncTask;
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

import com.nativesystem.ViewerJNI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.dermandar.a.q */
public class C1718q {
    /* renamed from: A */
    private float[] f4802A = new float[16];
    /* renamed from: B */
    private float[] f4803B = new float[4];
    /* renamed from: C */
    private long f4804C = 0;
    /* renamed from: D */
    private int f4805D = 1;
    /* renamed from: E */
    private double f4806E;
    /* renamed from: F */
    private String f4807F;
    /* renamed from: G */
    private String f4808G;
    /* renamed from: H */
    private double f4809H;
    /* renamed from: I */
    private double f4810I;
    /* renamed from: J */
    private double f4811J;
    /* renamed from: K */
    private String f4812K;
    /* renamed from: L */
    private String f4813L;
    /* renamed from: M */
    private boolean f4814M;
    /* renamed from: N */
    private Timer f4815N;
    /* renamed from: O */
    private long f4816O = 5;
    /* renamed from: P */
    private boolean f4817P;
    /* renamed from: Q */
    private boolean f4818Q = false;
    /* renamed from: R */
    private C1581ae.C1580b f4819R = new C16991();
    /* renamed from: S */
    private C1581ae.C1580b f4820S = new C17024();
    /* renamed from: T */
    private Runnable f4821T = new C17035();
    /* renamed from: U */
    private Runnable f4822U = new C17046();
    /* renamed from: V */
    private Runnable f4823V = new C17057();
    /* renamed from: W */
    private ScaleGestureDetector f4824W;
    /* renamed from: X */
    private GestureDetector f4825X;
    /* renamed from: Y */
    private float f4826Y = 1.0f;
    /* renamed from: Z */
    private int f4827Z;
    /* renamed from: a */
    private String f4828a = C1718q.class.toString();
    /* renamed from: aa */
    private int f4829aa = -1;
    /* renamed from: ab */
    private C1584ag.C1583a f4830ab = C1584ag.C1583a.TouchEnd;
    /* renamed from: ac */
    private boolean f4831ac;
    /* renamed from: ad */
    private boolean f4832ad;
    /* renamed from: ae */
    private OnTouchListener f4833ae = new C17108();
    /* renamed from: af */
    private int f4834af;
    /* renamed from: ag */
    private int f4835ag;
    /* renamed from: ah */
    private boolean f4836ah;
    /* renamed from: ai */
    private boolean f4837ai;
    /* renamed from: aj */
    private boolean f4838aj;
    /* renamed from: ak */
    private boolean f4839ak;
    /* renamed from: al */
    private boolean f4840al;
    /* renamed from: am */
    private Runnable f4841am = new C17119();
    /* renamed from: an */
    private boolean f4842an;
    /* renamed from: ao */
    private boolean f4843ao = false;
    /* renamed from: ap */
    private C1590w.C1591m f4844ap = new C169710();
    /* renamed from: b */
    private C1614c f4845b;
    /* renamed from: c */
    private RelativeLayout f4846c;
    /* renamed from: d */
    private C1604ah f4847d;
    /* renamed from: e */
    private ProgressBar f4848e;
    /* renamed from: f */
    private C1581ae f4849f;
    /* renamed from: g */
    private boolean f4850g;
    /* renamed from: h */
    private Handler f4851h;
    /* renamed from: i */
    private String f4852i;
    /* renamed from: j */
    private String f4853j;
    /* renamed from: k */
    private String f4854k;
    /* renamed from: l */
    private long f4855l;
    /* renamed from: m */
    private float f4856m;
    /* renamed from: n */
    private String f4857n;
    /* renamed from: o */
    private float f4858o;
    /* renamed from: p */
    private char f4859p;
    /* renamed from: q */
    private boolean f4860q;
    /* renamed from: r */
    private boolean f4861r;
    /* renamed from: s */
    private boolean f4862s;
    /* renamed from: t */
    private boolean f4863t;
    /* renamed from: u */
    private boolean f4864u;
    /* renamed from: v */
    private boolean f4865v = true;
    /* renamed from: w */
    private boolean f4866w;
    /* renamed from: x */
    private boolean f4867x;
    /* renamed from: y */
    private boolean f4868y;
    /* renamed from: z */
    private boolean f4869z;

    /* renamed from: com.dermandar.a.q$10 */
    class C169710 implements C1590w.C1591m {
        C169710() {
        }

        /* renamed from: a */
        public void mo5869a() {
            Log.e("rmh", "ondestroy123");
            C1718q.this.f4862s = false;
            ViewerJNI.mkaRelease();
            C1718q.this.f4851h.post(C1718q.this.f4822U);
            C1718q.this.f4818Q = true;
        }

        /* renamed from: a */
        public void mo5870a(GL10 gl10) {
            if (C1718q.this.f4860q) {
                Log.e("rmh", "viewerinit2");
                C1718q.this.f4860q = false;
                ViewerJNI.mkaInit((int) C1718q.this.f4855l, C1718q.this.f4856m, C1718q.this.f4853j);
                C1718q.this.f4840al = ViewerJNI.mkaView(C1718q.this.f4852i, C1718q.this.f4854k);
                C1718q.this.f4839ak = true;
                C1718q.this.f4837ai = true;
                ViewerJNI.mkaGyroVisibility(C1718q.this.f4866w);
                ViewerJNI.mkaCardboardVisibility(C1718q.this.f4867x);
                ViewerJNI.mkaSetPPI(C1718q.this.f4806E);
                C1718q.this.f4843ao = true;
            }
            if (C1718q.this.f4863t && C1718q.this.f4843ao && ViewerJNI.mkaIsReady()) {
                C1718q.this.f4863t = false;
                Log.e("rmh", "mFovx: " + C1718q.this.f4858o);
                ViewerJNI.mkaSetFovx(C1718q.this.f4858o);
            }
            if (C1718q.this.f4864u && C1718q.this.f4843ao && ViewerJNI.mkaIsReady()) {
                C1718q.this.f4864u = false;
                ViewerJNI.mkaSetType(C1718q.this.f4859p);
                C1718q.this.f4839ak = true;
                C1718q.this.f4838aj = true;
                C1718q.this.f4842an = true;
                Log.e("rmh", "onDrawFrame onTypeChanged");
                C1718q.this.f4845b.mo5918a(ViewerJNI.mkaGetType());
            }
            if (C1718q.this.f4862s) {
                Log.e("rmh", "isclearviewer2222");
                C1718q.this.f4862s = false;
                ViewerJNI.mkaRelease();
                C1718q.this.f4851h.post(C1718q.this.f4822U);
                C1718q.this.f4818Q = true;
            }
            if (C1718q.this.f4861r) {
                C1718q.this.f4861r = false;
                ViewerJNI.mkaSave(C1718q.this.f4857n);
                C1718q.this.f4836ah = true;
                C1718q.this.f4851h.post(C1718q.this.f4823V);
            }
            if (ViewerJNI.mkaIsReady()) {
                if (C1718q.this.f4837ai) {
                    C1718q.this.f4837ai = false;
                    C1718q.this.f4851h.post(C1718q.this.f4841am);
                }
                if (C1718q.this.f4839ak) {
                    C1718q.this.f4839ak = false;
                    ViewerJNI.mkaUpdatePlayer();
                    C1718q.this.f4836ah = true;
                    C1718q.this.f4838aj = true;
                    if (C1718q.this.f4842an) {
                        C1718q.this.f4842an = false;
                        C1718q.this.f4851h.post(C1718q.this.f4821T);
                    }
                }
                if (C1718q.this.f4836ah) {
                    C1718q.this.f4836ah = false;
                    GLES20.glViewport(0, 0, C1718q.this.f4834af, C1718q.this.f4835ag);
                    ViewerJNI.mkaSetDim(C1718q.this.f4834af, C1718q.this.f4835ag);
                }
                if (C1718q.this.f4838aj) {
                    C1718q.this.f4838aj = false;
                    ViewerJNI.mkaAutoplay();
                }
                if (C1718q.this.f4868y) {
                    long nanoTime = System.nanoTime();
                    if (C1718q.this.f4804C == 0) {
                        C1718q.this.f4804C = nanoTime;
                    }
                    C1718q.this.f4803B[3] = ((float) (nanoTime - C1718q.this.f4804C)) / 1.0E9f;
                    ViewerJNI.updateGyro(C1718q.this.f4802A, C1718q.this.f4803B);
                    C1718q.this.f4804C = nanoTime;
                }
            }
            ViewerJNI.mkaDraw();
        }

        /* renamed from: a */
        public void mo5871a(GL10 gl10, int i, int i2) {
            C1718q.this.f4834af = i;
            C1718q.this.f4835ag = i2;
            C1718q.this.f4836ah = true;
        }

        /* renamed from: a */
        public void mo5872a(GL10 gl10, EGLConfig eGLConfig) {
        }
    }

    /* renamed from: com.dermandar.a.q$11 */
    class C169811 implements Runnable {
        C169811() {
        }

        public void run() {
            C1718q.this.f4860q = true;
        }
    }

    /* renamed from: com.dermandar.a.q$1 */
    class C16991 implements C1581ae.C1580b {
        C16991() {
        }

        /* renamed from: a */
        public void mo5839a(double[] dArr, double[] dArr2, float f) {
        }

        /* renamed from: a */
        public void mo5840a(double[] dArr, double[] dArr2, double[] dArr3, float f) {
            if (C1718q.this.f4868y) {
                float[] fArr = new float[16];
                if (C1718q.this.f4817P) {
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
                if (C1718q.this.f4805D == -1) {
                    float[] fArr2 = new float[16];
                    C1569aa.m7580a(fArr2);
                    C1569aa.m7581a(fArr2, 0.0d, 0.0d, 3.141592653589793d);
                    C1569aa.m7583a(fArr2, fArr, fArr);
                }
                C1718q.this.f4802A = (float[]) fArr.clone();
                synchronized (C1718q.this.f4803B) {
                    if (C1718q.this.f4817P) {
                        C1718q.this.f4803B[1] = ((float) dArr[0]) * ((float) C1718q.this.f4805D);
                        C1718q.this.f4803B[0] = (((float) dArr[1]) * ((float) C1718q.this.f4805D)) * 1.0f;
                        C1718q.this.f4803B[2] = (float) dArr[2];
                    } else {
                        C1718q.this.f4803B[0] = ((float) dArr[0]) * ((float) C1718q.this.f4805D);
                        C1718q.this.f4803B[1] = (((float) dArr[1]) * ((float) C1718q.this.f4805D)) * -1.0f;
                        C1718q.this.f4803B[2] = (float) dArr[2];
                    }
                }
            }
        }
    }

    /* renamed from: com.dermandar.a.q$2 */
    class C17002 implements OnClickListener {
        C17002() {
        }

        public void onClick(View view) {
            if (C1718q.this.f4845b != null) {
                C1718q.this.f4845b.mo5917a();
            }
        }
    }

    /* renamed from: com.dermandar.a.q$3 */
    class C17013 extends TimerTask {
        C17013() {
        }

        public void run() {
            if (C1718q.this.f4847d == null) {
                C1718q.this.m8138h();
            } else {
                C1718q.this.f4847d.mo5859b();
            }
        }
    }

    /* renamed from: com.dermandar.a.q$4 */
    class C17024 implements C1581ae.C1580b {
        C17024() {
        }

        /* renamed from: a */
        public void mo5839a(double[] dArr, double[] dArr2, float f) {
        }

        /* renamed from: a */
        public void mo5840a(double[] dArr, double[] dArr2, double[] dArr3, float f) {
            if (C1718q.this.f4868y) {
                float[] fArr = new float[16];
                if (C1718q.this.f4817P) {
                    if (C1718q.this.f4814M) {
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
                } else if (C1718q.this.f4814M) {
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
                if (C1718q.this.f4805D == -1) {
                    fArr2 = new float[16];
                    C1569aa.m7580a(fArr2);
                    if (C1718q.this.f4817P) {
                        if (!C1718q.this.f4814M) {
                            C1569aa.m7581a(fArr2, 0.0d, 0.0d, 3.141592653589793d);
                            C1569aa.m7583a(fArr2, fArr, fArr);
                        }
                    } else if (C1718q.this.f4814M) {
                        C1569aa.m7581a(fArr2, -1.5707963267948966d, 0.0d, 0.0d);
                        C1569aa.m7583a(fArr, fArr2, fArr);
                    } else {
                        C1569aa.m7581a(fArr2, 0.0d, 0.0d, 3.141592653589793d);
                        C1569aa.m7583a(fArr2, fArr, fArr);
                    }
                } else if (C1718q.this.f4805D == 1 && C1718q.this.f4817P && C1718q.this.f4814M) {
                    fArr2 = new float[16];
                    C1569aa.m7580a(fArr2);
                    if (C1718q.this.f4814M) {
                        C1569aa.m7581a(fArr2, 0.0d, 0.0d, 3.141592653589793d);
                        C1569aa.m7583a(fArr, fArr2, fArr);
                    }
                }
                synchronized (C1718q.this.f4802A) {
                    C1718q.this.f4802A = (float[]) fArr.clone();
                }
                synchronized (C1718q.this.f4803B) {
                    if (C1718q.this.f4817P) {
                        if (C1718q.this.f4814M) {
                            C1718q.this.f4803B[0] = (-1.0f * ((float) dArr[0])) * ((float) C1718q.this.f4805D);
                            C1718q.this.f4803B[1] = ((float) dArr[1]) * ((float) C1718q.this.f4805D);
                            C1718q.this.f4803B[2] = (float) dArr[2];
                        } else {
                            C1718q.this.f4803B[1] = ((float) dArr[0]) * ((float) C1718q.this.f4805D);
                            C1718q.this.f4803B[0] = ((float) dArr[1]) * ((float) C1718q.this.f4805D);
                            C1718q.this.f4803B[2] = (float) dArr[2];
                        }
                    } else if (C1718q.this.f4814M) {
                        C1718q.this.f4803B[1] = (((float) dArr[0]) * ((float) C1718q.this.f4805D)) * -1.0f;
                        C1718q.this.f4803B[0] = (((float) dArr[1]) * ((float) C1718q.this.f4805D)) * -1.0f;
                        C1718q.this.f4803B[2] = (float) dArr[2];
                    } else {
                        C1718q.this.f4803B[0] = ((float) dArr[0]) * ((float) C1718q.this.f4805D);
                        C1718q.this.f4803B[1] = (((float) dArr[1]) * ((float) C1718q.this.f4805D)) * -1.0f;
                        C1718q.this.f4803B[2] = (float) dArr[2];
                    }
                }
            }
        }
    }

    /* renamed from: com.dermandar.a.q$5 */
    class C17035 implements Runnable {
        C17035() {
        }

        public void run() {
            C1718q.this.f4848e.setVisibility(4);
            if (C1718q.this.f4845b != null) {
                C1718q.this.f4845b.mo5920b();
            }
        }
    }

    /* renamed from: com.dermandar.a.q$6 */
    class C17046 implements Runnable {
        C17046() {
        }

        public void run() {
            if (C1718q.this.f4845b != null) {
                C1718q.this.f4845b.mo5923d();
            }
        }
    }

    /* renamed from: com.dermandar.a.q$7 */
    class C17057 implements Runnable {
        C17057() {
        }

        public void run() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("longitude", C1718q.this.f4810I + "");
            linkedHashMap.put("latitude", C1718q.this.f4809H + "");
            linkedHashMap.put("altitude", C1718q.this.f4811J + "");
            linkedHashMap.put("ctime", (System.currentTimeMillis() / 1000) + "");
            linkedHashMap.put("heading", "0");
            linkedHashMap.put("loc_name", C1718q.this.f4812K);
            linkedHashMap.put("loc_desc", C1718q.this.f4813L);
            C1718q.this.m8113a(linkedHashMap, C1718q.this.f4857n);
            if (C1718q.this.f4845b != null) {
                C1718q.this.f4845b.mo5922c();
            }
        }
    }

    /* renamed from: com.dermandar.a.q$8 */
    class C17108 implements OnTouchListener {

        /* renamed from: com.dermandar.a.q$8$3 */
        class C17083 implements Runnable {
            C17083() {
            }

            public void run() {
                ViewerJNI.mkaEnd();
            }
        }

        /* renamed from: com.dermandar.a.q$8$4 */
        class C17094 implements Runnable {
            C17094() {
            }

            public void run() {
                if (C1718q.this.f4832ad) {
                    C1718q.this.f4832ad = false;
                    if (C1718q.this.f4868y) {
                        C1718q.this.f4868y = false;
                        ViewerJNI.mkaSetGyro(false);
                        C1718q.this.f4849f.mo5845c();
                        if (C1718q.this.f4845b != null) {
                            C1718q.this.f4845b.mo5921b(false);
                        }
                    }
                }
            }
        }

        C17108() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!C1718q.this.f4824W.onTouchEvent(motionEvent) || !C1718q.this.f4824W.isInProgress()) {
                final float x;
                final float y;
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        C1718q.this.f4827Z = motionEvent.getPointerId(0);
                        if (C1718q.this.f4830ab == C1584ag.C1583a.TouchEnd) {
                            C1718q.this.f4830ab = C1584ag.C1583a.TouchStart;
                            C1718q.this.f4847d.mo5858a((Runnable) new Runnable() {
                                public void run() {
                                    ViewerJNI.mkaStart((double) x, (double) y);
                                }
                            });
                            break;
                        }
                        break;
                    case 1:
                        C1718q.this.f4826Y = 1.0f;
                        C1718q.this.f4827Z = C1718q.this.f4829aa;
                        if (C1718q.this.f4830ab != C1584ag.C1583a.TouchEnd) {
                            C1718q.this.f4830ab = C1584ag.C1583a.TouchEnd;
                            C1718q.this.f4831ac = true;
                            C1718q.this.f4847d.mo5858a((Runnable) new C17083());
                            break;
                        }
                        break;
                    case 2:
                        int findPointerIndex = motionEvent.findPointerIndex(C1718q.this.f4827Z);
                        if (findPointerIndex >= 0 && findPointerIndex < motionEvent.getPointerCount()) {
                            y = motionEvent.getX(findPointerIndex);
                            x = motionEvent.getY(findPointerIndex);
                            if (C1718q.this.f4830ab == C1584ag.C1583a.TouchStart || C1718q.this.f4830ab == C1584ag.C1583a.TouchMove) {
                                C1718q.this.f4830ab = C1584ag.C1583a.TouchMove;
                                C1718q.this.f4847d.mo5858a((Runnable) new Runnable() {
                                    public void run() {
                                        ViewerJNI.mkaMove((double) y, (double) x);
                                    }
                                });
                                break;
                            }
                        }
                        return false;
                    case 3:
                        C1718q.this.f4827Z = C1718q.this.f4829aa;
                        break;
                }
                if (C1718q.this.f4825X.onTouchEvent(motionEvent)) {
                    C1718q.this.f4832ad = false;
                    return true;
                }
                C1718q.this.f4832ad = true;
                if (!C1718q.this.f4868y || !C1718q.this.f4831ac) {
                    return true;
                }
                C1718q.this.f4831ac = false;
                C1718q.this.f4851h.postDelayed(new C17094(), 300);
                return true;
            } else if (!C1718q.this.f4868y) {
                return true;
            } else {
                C1718q.this.f4868y = false;
                ViewerJNI.mkaSetGyro(false);
                C1718q.this.f4849f.mo5845c();
                if (C1718q.this.f4845b == null) {
                    return true;
                }
                C1718q.this.f4845b.mo5921b(false);
                return true;
            }
        }
    }

    /* renamed from: com.dermandar.a.q$9 */
    class C17119 implements Runnable {
        C17119() {
        }

        public void run() {
            C1718q.this.f4848e.setVisibility(4);
            C1718q.this.f4847d.mo5861d();
            if (C1718q.this.f4845b != null) {
                C1718q.this.f4845b.mo5919a(C1718q.this.f4840al);
            }
            ViewerJNI.mkaSetGyro(true);
            if (C1718q.this.f4866w) {
                C1718q.this.f4868y = true;
                C1718q.this.f4849f.mo5844b();
                if (C1718q.this.f4845b != null) {
                    C1718q.this.f4845b.mo5921b(true);
                }
            }
        }
    }

    /* renamed from: com.dermandar.a.q$a */
    private class C1714a implements OnDoubleTapListener, OnGestureListener {
        private C1714a() {
        }

        /* synthetic */ C1714a(C1718q c1718q, C16991 c16991) {
            this();
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            final float x = motionEvent.getX();
            final float y = motionEvent.getY();
            if (C1718q.this.f4830ab == C1584ag.C1583a.TouchStart || C1718q.this.f4830ab == C1584ag.C1583a.TouchMove) {
                C1718q.this.f4830ab = C1584ag.C1583a.TouchZoom;
                C1718q.this.f4847d.mo5858a((Runnable) new Runnable() {
                    public void run() {
                        ViewerJNI.mkaDblclick((double) x, (double) y);
                    }
                });
            } else if (C1718q.this.f4830ab == C1584ag.C1583a.TouchEnd) {
                C1718q.this.f4830ab = C1584ag.C1583a.TouchZoom;
                C1718q.this.f4847d.mo5858a((Runnable) new Runnable() {
                    public void run() {
                        ViewerJNI.mkaStart((double) x, (double) y);
                        ViewerJNI.mkaDblclick((double) x, (double) y);
                    }
                });
            }
            if (C1718q.this.f4868y) {
                C1718q.this.f4868y = false;
                ViewerJNI.mkaSetGyro(false);
                C1718q.this.f4849f.mo5845c();
                if (C1718q.this.f4845b != null) {
                    C1718q.this.f4845b.mo5921b(false);
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
            ViewerJNI.mkaClick((double) motionEvent.getX(), (double) motionEvent.getY(), C1718q.this.f4817P ? (double) C1753x.f5034h : (double) C1753x.f5035i, C1718q.this.f4817P ? (double) C1753x.f5035i : (double) C1753x.f5034h);
            if (ViewerJNI.mkaClickIsGyro()) {
                C1718q.this.f4868y = !ViewerJNI.mkaGetGyro();
                ViewerJNI.mkaSetGyro(C1718q.this.f4868y);
                if (C1718q.this.f4868y) {
                    C1718q.this.f4849f.mo5844b();
                } else {
                    C1718q.this.f4849f.mo5845c();
                }
                if (C1718q.this.f4845b != null) {
                    C1718q.this.f4845b.mo5921b(C1718q.this.f4868y);
                }
            } else if (C1718q.this.f4845b != null) {
                C1718q.this.f4845b.mo5917a();
            }
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* renamed from: com.dermandar.a.q$b */
    private class C1715b extends AsyncTask<Double, Void, Void> {
        /* renamed from: a */
        Geocoder f4794a;
        /* renamed from: b */
        Context f4795b;
        /* renamed from: c */
        String f4796c = "";
        /* renamed from: d */
        String f4797d = "";

        C1715b(Context context) {
            this.f4795b = context;
        }

        /* Access modifiers changed, original: protected|varargs */
        /* renamed from: a */
        public Void doInBackground(Double... dArr) {
            try {
                List fromLocation = this.f4794a.getFromLocation(dArr[0].doubleValue(), dArr[1].doubleValue(), 1);
                if (fromLocation.size() > 0) {
                    for (int i = 0; i < ((Address) fromLocation.get(0)).getMaxAddressLineIndex(); i++) {
                        if (i > 0) {
                            this.f4796c += " ";
                        }
                        this.f4796c += ((Address) fromLocation.get(0)).getAddressLine(i);
                    }
                    if (((Address) fromLocation.get(0)).getSubAdminArea() != null) {
                        this.f4796c += ", " + ((Address) fromLocation.get(0)).getSubAdminArea();
                    }
                    if (((Address) fromLocation.get(0)).getCountryName() != null) {
                        this.f4796c += ", " + ((Address) fromLocation.get(0)).getCountryName();
                    }
                    if (((Address) fromLocation.get(0)).getFeatureName() != null) {
                        this.f4797d = ((Address) fromLocation.get(0)).getFeatureName();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            C1718q.this.f4812K = this.f4796c;
            C1718q.this.f4813L = this.f4797d;
        }

        /* Access modifiers changed, original: protected */
        public void onPreExecute() {
            this.f4794a = new Geocoder(this.f4795b, Locale.getDefault());
        }
    }

    /* renamed from: com.dermandar.a.q$c */
    private class C1717c extends SimpleOnScaleGestureListener {
        private C1717c() {
        }

        /* synthetic */ C1717c(C1718q c1718q, C16991 c16991) {
            this();
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            C1718q.this.f4826Y = C1718q.this.f4826Y * scaleGestureDetector.getScaleFactor();
            if (C1718q.this.f4830ab == C1584ag.C1583a.TouchStart || C1718q.this.f4830ab == C1584ag.C1583a.TouchPinchZoom || C1718q.this.f4830ab == C1584ag.C1583a.TouchMove) {
                C1718q.this.f4830ab = C1584ag.C1583a.TouchPinchZoom;
                final float ac = C1718q.this.f4826Y;
                C1718q.this.f4847d.mo5858a((Runnable) new Runnable() {
                    public void run() {
                        ViewerJNI.mkaZoom((double) ac);
                    }
                });
            }
            return true;
        }
    }

    /* renamed from: a */
    private void m8113a(LinkedHashMap<String, String> linkedHashMap, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str + "/" + "other.txt"), false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(linkedHashMap);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    private double m8120b(String str) {
        if (str == null || str.isEmpty()) {
            return 0.0d;
        }
        String[] split = str.split(",");
        if (split.length != 3) {
            return 0.0d;
        }
        return Double.parseDouble(split[0].split("/")[0]) + ((Double.parseDouble(split[2].split("/")[0]) + (Double.parseDouble(split[1].split("/")[0]) * 60.0d)) / 3600.0d);
    }

    /* renamed from: g */
    private void m8135g() {
        if (this.f4815N == null) {
            this.f4815N = new Timer();
            this.f4815N.schedule(new C17013(), 0, this.f4816O);
        }
    }

    /* renamed from: h */
    private void m8138h() {
        if (this.f4815N != null) {
            this.f4815N.cancel();
            this.f4815N = null;
        }
    }

    /* renamed from: a */
    public float mo6190a() {
        return ViewerJNI.mkaGetFovx();
    }

    /* renamed from: a */
    public View mo6191a(Context context, C1614c c1614c, String str, String str2, String str3, boolean z) {
        this.f4845b = c1614c;
        this.f4852i = str;
        this.f4853j = str2;
        this.f4854k = str3;
        this.f4866w = true;
        this.f4868y = false;
        this.f4867x = false;
        this.f4869z = false;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f4851h = new Handler();
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 0 || rotation == 2) {
            C1753x.f5034h = displayMetrics.widthPixels;
            C1753x.f5035i = displayMetrics.heightPixels;
        } else {
            C1753x.f5034h = displayMetrics.heightPixels;
            C1753x.f5035i = displayMetrics.widthPixels;
        }
        C1753x.f5036j = ((double) C1753x.f5035i) / ((double) C1753x.f5034h);
        rotation = this.f4817P ? rotation == 0 ? 1 : -1 : rotation == 1 ? 1 : -1;
        this.f4805D = rotation;
        this.f4806E = (double) context.getResources().getDisplayMetrics().xdpi;
        Log.e("T", "Import isTab:" + this.f4817P + " ori:" + this.f4805D);
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        this.f4855l = memoryInfo.availMem / 1024;
        this.f4856m = context.getResources().getDisplayMetrics().density;
        this.f4849f = new C1581ae(context, this.f4820S);
        this.f4846c = new RelativeLayout(context);
        this.f4846c.setLayoutParams(new LayoutParams(-1, -1));
        this.f4824W = new ScaleGestureDetector(context, new C1717c(this, null));
        this.f4825X = new GestureDetector(context, new C1714a(this, null));
        this.f4847d = new C1604ah(context, this.f4844ap);
        this.f4847d.setLayoutParams(new LayoutParams(-1, -1));
        this.f4847d.mo5854a(0);
        this.f4847d.mo5860c();
        this.f4847d.setOnTouchListener(this.f4833ae);
        this.f4846c.addView(this.f4847d);
        this.f4848e = new ProgressBar(context, null, 16842874);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f4848e.setLayoutParams(layoutParams);
        this.f4848e.setVisibility(0);
        this.f4846c.addView(this.f4848e);
        this.f4850g = true;
        this.f4851h = new Handler();
        this.f4851h.postDelayed(new C169811(), z ? 500 : 0);
        try {
            ExifInterface exifInterface = new ExifInterface(this.f4852i);
            this.f4807F = exifInterface.getAttribute("GPSLatitude");
            if (this.f4807F != null) {
                this.f4809H = m8120b(this.f4807F);
            }
            this.f4808G = exifInterface.getAttribute("GPSLongitude");
            if (this.f4808G != null) {
                this.f4810I = m8120b(this.f4808G);
            }
            this.f4811J = exifInterface.getAttributeDouble("GPSAltitude", 0.0d);
            if (!(this.f4807F == null || this.f4808G == null)) {
                new C1715b(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Double[]{Double.valueOf(this.f4809H), Double.valueOf(this.f4810I)});
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return this.f4846c;
    }

    /* renamed from: a */
    public void mo6192a(char c) {
        this.f4859p = c;
        this.f4864u = true;
        if (this.f4848e != null) {
            this.f4848e.setVisibility(0);
            this.f4848e.bringToFront();
        }
    }

    /* renamed from: a */
    public void mo6193a(float f) {
        Log.e("rmh", "dmdimport in set" + f);
        this.f4858o = f;
        this.f4863t = true;
    }

    /* renamed from: a */
    public void mo6194a(int i) {
        int i2 = 1;
        if (this.f4817P) {
            if (i != 0) {
                i2 = -1;
            }
        } else if (i != 1) {
            i2 = -1;
        }
        this.f4805D = i2;
    }

    /* renamed from: a */
    public void mo6195a(String str) {
        this.f4857n = str;
        this.f4861r = true;
    }

    /* renamed from: a */
    public void mo6196a(boolean z) {
        this.f4817P = z;
    }

    /* renamed from: b */
    public char mo6197b() {
        return ViewerJNI.mkaGetType();
    }

    /* renamed from: b */
    public void mo6198b(boolean z) {
        this.f4865v = z;
        if (this.f4847d == null) {
            return;
        }
        if (this.f4865v) {
            this.f4847d.setOnTouchListener(this.f4833ae);
            this.f4847d.setOnClickListener(null);
            return;
        }
        this.f4847d.setOnTouchListener(null);
        this.f4847d.setOnClickListener(new C17002());
    }

    /* renamed from: c */
    public void mo6199c() {
        Log.e("rmh", "cleardata" + this.f4862s);
        this.f4862s = true;
        if (this.f4868y) {
            this.f4849f.mo5845c();
            this.f4868y = false;
        }
    }

    /* renamed from: c */
    public void mo6200c(boolean z) {
        this.f4814M = z;
    }

    /* renamed from: d */
    public void mo6201d() {
        m8138h();
        if (this.f4868y) {
            this.f4849f.mo5845c();
        }
    }

    /* renamed from: d */
    public void mo6202d(boolean z) {
        this.f4868y = z;
        ViewerJNI.setGyro(z);
        if (z) {
            if (this.f4849f != null) {
                this.f4849f.mo5844b();
            }
        } else if (this.f4849f != null) {
            this.f4849f.mo5845c();
        }
    }

    /* renamed from: e */
    public void mo6203e() {
        m8135g();
        if (this.f4868y) {
            this.f4849f.mo5844b();
        }
    }

    /* renamed from: e */
    public void mo6204e(boolean z) {
        this.f4869z = z;
        ViewerJNI.mkaSetCardboard(this.f4869z);
    }

    /* renamed from: f */
    public void mo6205f() {
        this.f4862s = true;
        if (this.f4847d != null) {
            this.f4847d.mo5859b();
        }
        while (!this.f4818Q) {
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.f4818Q = false;
        if (this.f4847d != null) {
            this.f4847d.mo5863f();
        }
    }
}
