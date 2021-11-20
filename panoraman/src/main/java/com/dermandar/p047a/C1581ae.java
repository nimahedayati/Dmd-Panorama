package com.dermandar.p047a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.lang.reflect.Array;

/* renamed from: com.dermandar.a.ae */
class C1581ae {
    /* renamed from: a */
    public static String f4374a = "DMD_Library";
    /* renamed from: A */
    private int f4375A = 30;
    /* renamed from: B */
    private float[][] f4376B = ((float[][]) Array.newInstance(Float.TYPE, new int[]{3, this.f4375A}));
    /* renamed from: C */
    private int f4377C = 0;
    /* renamed from: D */
    private boolean f4378D;
    /* renamed from: E */
    private SensorEventListener f4379E = new C15781();
    /* renamed from: b */
    private final int f4380b = 9;
    /* renamed from: c */
    private final int f4381c = 4;
    /* renamed from: d */
    private C1579a f4382d;
    /* renamed from: e */
    private SensorManager f4383e;
    /* renamed from: f */
    private Sensor f4384f;
    /* renamed from: g */
    private Sensor f4385g;
    /* renamed from: h */
    private Sensor f4386h;
    /* renamed from: i */
    private Sensor f4387i;
    /* renamed from: j */
    private C1580b f4388j;
    /* renamed from: k */
    private Context f4389k;
    /* renamed from: l */
    private int f4390l = 0;
    /* renamed from: m */
    private boolean f4391m = false;
    /* renamed from: n */
    private boolean f4392n = false;
    /* renamed from: o */
    private boolean f4393o = false;
    /* renamed from: p */
    private boolean f4394p = false;
    /* renamed from: q */
    private boolean f4395q = false;
    /* renamed from: r */
    private double[] f4396r = new double[3];
    /* renamed from: s */
    private float[] f4397s = new float[3];
    /* renamed from: t */
    private float[] f4398t = new float[3];
    /* renamed from: u */
    private float[] f4399u = new float[3];
    /* renamed from: v */
    private double f4400v;
    /* renamed from: w */
    private boolean f4401w = false;
    /* renamed from: x */
    private boolean f4402x = false;
    /* renamed from: y */
    private boolean f4403y = false;
    /* renamed from: z */
    private boolean f4404z = false;

    /* renamed from: com.dermandar.a.ae$1 */
    class C15781 implements SensorEventListener {
        C15781() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!C1581ae.this.f4394p) {
                return;
            }
            int i;
            double d;
            float toDegrees;
            if (C1581ae.this.f4391m) {
                float[] k;
                if (sensorEvent.sensor.getType() == C1581ae.this.f4384f.getType()) {
                    C1581ae.this.f4401w = true;
                    for (i = 0; i < C1581ae.this.f4396r.length; i++) {
                        C1581ae.this.f4396r[i] = (double) sensorEvent.values[i];
                    }
                } else if (sensorEvent.sensor.getType() == C1581ae.this.f4385g.getType()) {
                    C1581ae.this.f4402x = true;
                    for (i = 0; i < C1581ae.this.f4397s.length; i++) {
                        C1581ae.this.f4397s[i] = sensorEvent.values[i];
                    }
                } else if (sensorEvent.sensor.getType() == C1581ae.this.f4386h.getType()) {
                    C1581ae.this.f4403y = true;
                    if (C1581ae.this.f4378D) {
                        C1581ae.this.f4378D = false;
                        for (i = 0; i < C1581ae.this.f4375A; i++) {
                            for (int i2 = 0; i2 < 3; i2++) {
                                C1581ae.this.f4376B[i2][i] = sensorEvent.values[i2];
                            }
                        }
                        for (i = 0; i < 3; i++) {
                            C1581ae.this.f4398t[i] = sensorEvent.values[i];
                        }
                    } else {
                        for (i = 0; i < 3; i++) {
                            k = C1581ae.this.f4398t;
                            k[i] = k[i] + ((sensorEvent.values[i] - C1581ae.this.f4376B[i][C1581ae.this.f4377C]) / ((float) C1581ae.this.f4375A));
                            C1581ae.this.f4376B[i][C1581ae.this.f4377C] = sensorEvent.values[i];
                        }
                    }
                    C1581ae.this.f4377C = (C1581ae.this.f4377C + 1) % C1581ae.this.f4375A;
                }
                if (C1581ae.this.f4401w && C1581ae.this.f4402x && C1581ae.this.f4403y) {
                    k = new float[9];
                    float[] fArr = new float[4];
                    double[] dArr = new double[9];
                    double[] dArr2 = new double[4];
                    double[] dArr3 = new double[3];
                    d = 0.0d;
                    for (i = 0; i < C1581ae.this.f4398t.length; i++) {
                        d += (double) (C1581ae.this.f4398t[i] * C1581ae.this.f4398t[i]);
                    }
                    d = 1.0d / Math.sqrt(d);
                    for (i = 0; i < C1581ae.this.f4398t.length; i++) {
                        dArr3[i] = ((double) C1581ae.this.f4398t[i]) * d;
                    }
                    SensorManager.getRotationMatrixFromVector(k, C1581ae.this.f4397s);
                    SensorManager.getQuaternionFromVector(fArr, C1581ae.this.f4397s);
                    for (i = 0; i < k.length; i++) {
                        dArr[i] = (double) k[i];
                    }
                    for (i = 0; i < fArr.length; i++) {
                        dArr2[i] = (double) fArr[i];
                    }
                    double d2 = dArr[1];
                    dArr[1] = dArr[3];
                    dArr[3] = d2;
                    d2 = dArr[2];
                    dArr[2] = dArr[6];
                    dArr[6] = d2;
                    d2 = dArr[5];
                    dArr[5] = dArr[7];
                    dArr[7] = d2;
                    if (C1753x.m8340i() || C1753x.m8341j()) {
                        dArr[2] = dArr3[0];
                        dArr[5] = dArr3[1];
                        dArr[8] = dArr3[2];
                    }
                    if (C1581ae.this.f4388j != null) {
                        toDegrees = ((float) (360.0d - Math.toDegrees(Math.atan2(dArr[6], -dArr[7])))) % 360.0f;
                        C1581ae.this.f4396r[1] = C1581ae.this.f4396r[1] - C1581ae.this.f4400v;
                        C1581ae.this.f4388j.mo5840a(C1581ae.this.f4396r, dArr, dArr2, toDegrees);
                    }
                }
            } else if (C1581ae.this.f4393o) {
                if (sensorEvent.sensor.getType() == 1) {
                    C1581ae.this.f4403y = true;
                    for (i = 0; i < C1581ae.this.f4398t.length; i++) {
                        C1581ae.this.f4398t[i] = sensorEvent.values[i];
                    }
                } else if (sensorEvent.sensor.getType() == 2) {
                    C1581ae.this.f4404z = true;
                    for (i = 0; i < C1581ae.this.f4399u.length; i++) {
                        C1581ae.this.f4399u[i] = sensorEvent.values[i];
                    }
                }
                if (C1581ae.this.f4403y && C1581ae.this.f4404z) {
                    double[] dArr4 = new double[3];
                    double[] dArr5 = new double[3];
                    d = 0.0d;
                    for (i = 0; i < C1581ae.this.f4398t.length; i++) {
                        d += (double) (C1581ae.this.f4398t[i] * C1581ae.this.f4398t[i]);
                    }
                    d = 1.0d / Math.sqrt(d);
                    for (i = 0; i < C1581ae.this.f4398t.length; i++) {
                        dArr4[i] = (-d) * ((double) C1581ae.this.f4398t[i]);
                    }
                    for (i = 0; i < C1581ae.this.f4399u.length; i++) {
                        dArr5[i] = (double) C1581ae.this.f4399u[i];
                    }
                    toDegrees = 0.0f;
                    float[] fArr2 = new float[9];
                    if (SensorManager.getRotationMatrix(fArr2, new float[9], C1581ae.this.f4398t, C1581ae.this.f4399u) && fArr2 != null) {
                        toDegrees = ((float) (360.0d - Math.toDegrees(Math.atan2((double) fArr2[2], (double) (-fArr2[5]))))) % 360.0f;
                    }
                    if (C1581ae.this.f4388j != null) {
                        C1581ae.this.f4388j.mo5839a(dArr4, dArr5, toDegrees);
                    }
                }
            }
        }
    }

    /* renamed from: com.dermandar.a.ae$a */
    public class C1579a extends HandlerThread implements Callback {
        /* renamed from: a */
        Handler f4372a;

        private C1579a() {
            super("SensorDataThread", 10);
        }

        /* synthetic */ C1579a(C1581ae c1581ae, C15781 c15781) {
            this();
        }

        public boolean handleMessage(Message message) {
            return false;
        }
    }

    /* renamed from: com.dermandar.a.ae$b */
    public interface C1580b {
        /* renamed from: a */
        void mo5839a(double[] dArr, double[] dArr2, float f);

        /* renamed from: a */
        void mo5840a(double[] dArr, double[] dArr2, double[] dArr3, float f);
    }

    public C1581ae(Context context, C1580b c1580b) {
        this.f4389k = context;
        this.f4388j = c1580b;
        this.f4382d = new C1579a(this, null);
        this.f4382d.start();
        this.f4382d.f4372a = new Handler(this.f4382d.getLooper(), this.f4382d);
        m7623e();
    }

    /* renamed from: e */
    private void m7623e() {
        int i = 0;
        if (this.f4389k != null) {
            this.f4383e = (SensorManager) this.f4389k.getSystemService("sensor");
            if (this.f4383e != null) {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                boolean z = false;
                int i5 = 0;
                for (Sensor type : this.f4383e.getSensorList(-1)) {
                    int i6;
                    boolean z2;
                    int i7;
                    switch (type.getType()) {
                        case 1:
                            i6 = i;
                            i3 = i4;
                            i = i2;
                            z2 = z;
                            i2 = 1;
                            i7 = i5;
                            break;
                        case 2:
                            i6 = i;
                            i2 = i3;
                            i = 1;
                            i3 = i4;
                            z2 = z;
                            i7 = i5;
                            break;
                        case 4:
                            i6 = i;
                            i = i2;
                            i2 = i3;
                            i3 = i4;
                            z2 = z;
                            i7 = 1;
                            break;
                        case 11:
                            i6 = i;
                            z2 = z;
                            i = i2;
                            i7 = i5;
                            i2 = i3;
                            i3 = 1;
                            break;
                        case 15:
                            i6 = 1;
                            i = i2;
                            i2 = i3;
                            i3 = i4;
                            z2 = z;
                            i7 = i5;
                            break;
                        case 16:
                            i6 = i;
                            i7 = i5;
                            i = i2;
                            i2 = i3;
                            i3 = i4;
                            z2 = true;
                            break;
                        default:
                            i6 = i;
                            i = i2;
                            i2 = i3;
                            i3 = i4;
                            z2 = z;
                            i7 = i5;
                            break;
                    }
                    i5 = i7;
                    z = z2;
                    i4 = i3;
                    i3 = i2;
                    i2 = i;
                    i = i6;
                }
                this.f4392n = z;
                if (!(i5 == 0 || (i4 == 0 && i == 0))) {
                    if (C1753x.m8336e() == 1 || C1753x.m8338g()) {
                        this.f4390l = 1;
                    }
                    this.f4391m = true;
                }
                if (!(i3 == 0 || i2 == 0)) {
                    this.f4393o = true;
                }
                if (!this.f4391m && !this.f4393o) {
                    return;
                }
                if (this.f4391m) {
                    this.f4384f = this.f4383e.getDefaultSensor(4);
                    if (i4 != 0) {
                        this.f4385g = this.f4383e.getDefaultSensor(11);
                    } else {
                        this.f4385g = this.f4383e.getDefaultSensor(15);
                    }
                    this.f4386h = this.f4383e.getDefaultSensor(1);
                } else if (this.f4393o) {
                    this.f4386h = this.f4383e.getDefaultSensor(1);
                    this.f4387i = this.f4383e.getDefaultSensor(2);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo5841a(double d) {
        this.f4400v = d;
    }

    /* renamed from: a */
    public void mo5842a(boolean z) {
        if (!this.f4395q) {
            if (z && mo5843a()) {
                this.f4384f = this.f4383e.getDefaultSensor(16);
            } else if (this.f4391m) {
                this.f4384f = this.f4383e.getDefaultSensor(4);
            }
        }
    }

    /* renamed from: a */
    public boolean mo5843a() {
        return VERSION.SDK_INT >= 18 && this.f4392n;
    }

    /* renamed from: b */
    public void mo5844b() {
        if (!this.f4395q) {
            boolean registerListener;
            boolean registerListener2;
            if (this.f4391m) {
                registerListener = this.f4383e.registerListener(this.f4379E, this.f4384f, this.f4390l, this.f4382d.f4372a);
                registerListener2 = this.f4383e.registerListener(this.f4379E, this.f4385g, this.f4390l, this.f4382d.f4372a);
                boolean registerListener3 = this.f4383e.registerListener(this.f4379E, this.f4386h, this.f4390l, this.f4382d.f4372a);
                if (!(registerListener && registerListener2 && registerListener3)) {
                    if (registerListener) {
                        this.f4383e.unregisterListener(this.f4379E, this.f4384f);
                    }
                    if (registerListener2) {
                        this.f4383e.unregisterListener(this.f4379E, this.f4385g);
                    }
                    if (registerListener3) {
                        this.f4383e.unregisterListener(this.f4379E, this.f4386h);
                    }
                    this.f4391m = false;
                    mo5844b();
                }
                this.f4394p = true;
            } else if (this.f4393o) {
                this.f4378D = true;
                registerListener = this.f4383e.registerListener(this.f4379E, this.f4386h, this.f4390l, this.f4382d.f4372a);
                registerListener2 = this.f4383e.registerListener(this.f4379E, this.f4387i, this.f4390l, this.f4382d.f4372a);
                if (registerListener && registerListener2) {
                    this.f4394p = true;
                } else {
                    if (registerListener) {
                        this.f4383e.unregisterListener(this.f4379E, this.f4386h);
                    }
                    if (registerListener2) {
                        this.f4383e.unregisterListener(this.f4379E, this.f4387i);
                    }
                    this.f4393o = false;
                    return;
                }
            }
            this.f4395q = true;
        }
    }

    /* renamed from: c */
    public void mo5845c() {
        if (this.f4395q) {
            this.f4394p = false;
            if (this.f4391m) {
                this.f4383e.unregisterListener(this.f4379E, this.f4384f);
                this.f4383e.unregisterListener(this.f4379E, this.f4385g);
                this.f4383e.unregisterListener(this.f4379E, this.f4386h);
            } else if (this.f4393o) {
                this.f4383e.unregisterListener(this.f4379E, this.f4386h);
                this.f4383e.unregisterListener(this.f4379E, this.f4387i);
            }
            this.f4395q = false;
            this.f4401w = false;
            this.f4402x = false;
        }
    }

    /* renamed from: d */
    public boolean mo5846d() {
        return this.f4391m;
    }
}
