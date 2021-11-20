package com.dermandar.p047a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.ShutterCallback;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.ExifInterface;
import android.opengl.GLES20;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.dermandar.p047a.C1590w.C1591m;
import com.dermandar.panoraman.R;
import com.nativesystem.Core;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class C1693n {
    private static String f4627m = "DMD_Library";
    private boolean f4628A;
    private RelativeLayout f4629B;
    private int[] f4631D = null;
    private boolean f4632E = false;
    private C1604ah f4633F;
    private C1612al f4634G;
    private ProgressBar f4635H;
    private Display f4636I;
    private DisplayMetrics f4637J;
    private SimpleDateFormat f4638K;
    private C1577ad f4639L;
    private C1605ai f4640M;
    private ImageView f4641N;
    private int f4642O = -1;
    private C1577ad f4643P;
    private C1749u f4644Q;
    private ImageView f4645R;
    private int f4646S = -1;
    private ImageView f4647T;
    private boolean f4648U;
    private boolean f4649V;
    private C1577ad f4650W;
    private C1619h f4651X;
    private ImageView f4652Y;
    private String f4653Z = "none";
    public boolean f4654a;
    private boolean f4655aA;
    private boolean f4656aB;
    private boolean f4657aC = false;
    private C1616e f4658aD;
    private boolean f4659aE;
    private boolean f4660aF;
    private boolean f4661aG;
    private boolean f4662aH;
    private String f4663aI = null;
    private Context f4666aL;
    private C1694o f4667aM;
    private C1696p f4668aN;
    private boolean f4669aO = true;
    private OnTouchListener f4670aP = new C16421();
    private OnTouchListener f4671aQ = new C163412();
    private OnTouchListener f4672aR = new C164623();
    private OnTouchListener f4673aS = new C166032();
    private OnTouchListener f4674aT = new C166537();
    private OnTouchListener f4675aU = new C167038();
    private Runnable f4676aV = new C167139();
    private C1630l f4677aW = new C167340();
    private Runnable f4678aX = new C167441();
    private boolean f4679aY;
    private ShutterCallback f4680aZ = new C16572();
    private ImageView f4681aa;
    private ImageView f4682ab;
    private ImageView f4683ac;
    private boolean f4684ad;
    private boolean f4685ae;
    private ImageView f4686af;
    private boolean f4687ag;
    private boolean f4688ah;
    private C1581ae f4689ai;
    private Handler f4690aj;
    private int f4691ak;
    private int f4692al;
    private boolean f4693am;
    private int f4694an;
    private int f4695ao;
    private int f4696ap;
    private int f4697aq;
    private int f4698ar;
    private int f4699as;
    private LocationManager f4700at;
    private LocationListener f4701au;
    private LocationListener f4702av;
    private float f4703aw;
    private boolean f4704ax;
    private boolean f4705ay;
    private boolean f4706az;
    public boolean f4707b;
    private boolean f4708ba = false;
    private int f4709bb = 0;
    private boolean f4710bc = false;
    private PreviewCallback f4711bd = new C16723();
    private PictureCallback f4712be = new C16754();
    private C1677z f4713bf = new C16785();
    private PreviewCallback f4714bg = new C16806();
    private boolean f4715bh = false;
    private AutoFocusCallback f4716bi = new C16827();
    private Handler f4717bj;
    private C1613b f4718bk = new C16848();
    private Runnable f4719bl = new C16859();
    private Runnable f4720bm = new C163210();
    private Runnable f4721bn = new C163311();
    private Runnable f4722bo = new C163513();
    private Runnable f4723bp = new C163614();
    private Runnable f4724bq = new C163715();
    private Runnable f4725br = new C163816();
    private Runnable f4726bs = new C163917();
    private C1581ae.C1580b f4727bt = new C164018();
    private C1591m f4728bu = new C164119();
    private boolean f4729bv = true;
    private C1691f f4731bx = null;
    public boolean f4732c;
    public boolean f4733d;
    public boolean f4734e;
    public boolean f4735f;
    public boolean f4736g;
    public boolean f4737h;
    public boolean f4738i;
    public String f4739j;
    boolean f4740k = false;
    boolean f4741l = false;
    private int f4742n = 10;
    private int f4743o = 11;
    private int f4744p = 12;
    private int f4745q = 13;
    private int f4746r = 14;
    private int f4747s = 15;
    private int f4748t = 16;
    private int f4749u = 17;
    private int f4750v = 18;
    private boolean f4751w;
    private boolean f4752x;
    private boolean f4753y;
    private boolean f4754z = true;
    
    class C163210 implements Runnable {
        public void run() {
            f4737h = true;
        }
    }
    
    class C163311 implements Runnable {
        public void run() {
            if (f4658aD != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(C1689d.fovx.name(), C1753x.f5019K);
                f4658aD.mo5934a(hashMap);
            }
            if (f4635H.getParent() != null) {
                f4629B.removeView(f4635H);
            }
            LinkedHashMap<String, String> al = m7971y();
            al.put("longitude", C1753x.f5039m + "");
            al.put("latitude", C1753x.f5040n + "");
            al.put("altitude", C1753x.f5041o + "");
            al.put("ctime", (System.currentTimeMillis() / 1000) + "");
            al.put("heading", C1753x.f5043q + "");
            al.put("loc_name", C1753x.f5037k);
            al.put("loc_desc", C1753x.f5038l);
            if (f4687ag) {
                al.put("loc_tags", "HDR");
                al.put("HDR", "True");
            }
            if (f4684ad) {
                al.put("HD", "True");
            }
            m7892a(al);
        }
    }

    class C163412 implements OnTouchListener {
        boolean f4551a;

        @SuppressLint({"UseCompatLoadingForDrawables", "ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f4551a = true;
                    view.setBackgroundColor(f4666aL.getResources().getColor(R.color.color_wb_button_touched));
                    break;
                case 1:
                    if (this.f4551a) {
                        view.setBackgroundColor(0);
                        if (!f4684ad) {
                            if (mo6082e()) {
                                mo6084g();
                                f4684ad = true;
                                f4683ac.setImageDrawable(f4666aL.getResources().getDrawable(R.drawable.fav));
                                break;
                            }
                        }
                        mo6085h();
                        f4684ad = false;
                        f4683ac.setImageDrawable(f4666aL.getResources().getDrawable(R.drawable.fav));
                        break;
                    }
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x < 0 || y < 0 || x >= view.getWidth() || y >= view.getHeight()) {
                        view.setBackgroundColor(0);
                        this.f4551a = false;
                        break;
                    }
            }
            return true;
        }
    }

    class C163513 implements Runnable {

        public void run() {
            if (f4709bb == 4) {
                mo6076a(f4739j);
            }
            f4709bb = 0;
        }
    }

    class C163614 implements Runnable {
        public void run() {
            f4633F.mo5862e();
            f4633F.mo5904i();
            if (f4658aD != null) {
                f4658aD.mo5942g();
            }
        }
    }

    class C163715 implements Runnable {

        public void run() {
            if (f4658aD != null) {
                f4658aD.mo5932a(f4659aE ? 1 : 0);
            }
        }
    }

    class C163816 implements Runnable {

        public void run() {
            if (f4658aD != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(C1687b.kDMDCompassInterference.name(), Boolean.TRUE);
                f4658aD.mo5937b(hashMap);
            }
        }
    }

    class C163917 implements Runnable {

        public void run() {
            if (f4658aD != null) {
                f4658aD.mo5931a(f4703aw);
            }
        }
    }

    class C164018 implements C1581ae.C1580b {
        public void mo5839a(double[] dArr, double[] dArr2, float f) {
            if (f4737h) {
                Core.updateCompass(dArr, dArr2, 1.0d);
                m7967w();
                f4703aw = f;
            }
        }

        public void mo5840a(double[] dArr, double[] dArr2, double[] dArr3, float f) {
            if (f4737h) {
                Core.updateGyro(dArr, dArr2, dArr3);
                m7967w();
                f4703aw = f;
            }
        }
    }


    class C164119 implements C1591m {

        private void m7840b() {
            while (C1753x.f5016H > 0) {
                if (C1753x.f5017I.size() > 0) {
                    C1754y c1754y = C1753x.f5017I.poll();
                    C1753x.f5016H--;
                    if (c1754y.mo6273b() == 17) {
                        Core.loadImage(c1754y.mo6272a(), c1754y.mo6274c(), c1754y.mo6275d(), c1754y.mo6276e(), c1754y.mo6277f(), c1754y.mo6278g(), c1754y.mo6279h());
                    } else if (c1754y.mo6273b() == 256) {
                        Core.loadImage(c1754y.mo6272a(), c1754y.mo6272a().length, 0, c1754y.mo6276e(), c1754y.mo6277f(), c1754y.mo6278g(), c1754y.mo6279h());
                    }
                }
            }
            Core.finishStitching();
            C1753x.f5043q = Core.getHeading(C1753x.f5042p);
            C1753x.f5017I.clear();
            C1753x.f5016H = 0;
        }


        public void mo5869a() {
            f4733d = false;
            f4737h = false;
            Core.clear();
            if (f4740k) {
                mo6070a();
            }
            f4690aj.post(f4723bp);
        }

        public void mo5870a(GL10 gl10) {
            if (f4734e) {
                f4734e = false;
                try {
                    int[] iArr = new int[1];
                    GLES20.glGetIntegerv(3379, iArr, 0);
                    C1753x.f5009A = iArr[0];
                } catch (Exception e) {
                    e.printStackTrace();
                    C1753x.f5009A = 2048;
                }
                Core.init2(C1753x.m8335d(), null, C1753x.m8342k());
                Core.setF35(C1753x.f5050x);
                Core.setIsLandscapeShot(C1753x.m8334c());
                Core.set();
                f4690aj.post(f4720bm);
            }
            if (f4735f) {
                f4735f = false;
                if (f4737h) {
                    Core.setF35(C1753x.f5050x);
                }
            }
            if (f4732c) {
                f4732c = false;
                Core.set();
                f4690aj.post(f4722bo);
                return;
            }
            if (f4654a) {
                f4654a = false;
                Log.e("rmh", "mppath2: " + f4739j);
                Core.setSavePath(f4739j);
                Core.beginStitching(C1753x.m8333b(), C1753x.f5052z);
            }
            if (f4707b) {
                f4707b = false;
                if (C1753x.f5017I != null && C1753x.f5017I.size() > 0 && C1753x.f5016H > 0) {
                    C1754y c1754y = C1753x.f5017I.poll();
                    C1753x.f5016H--;
                    if (c1754y.mo6273b() == 17) {
                        Core.loadImage(c1754y.mo6272a(), c1754y.mo6274c(), c1754y.mo6275d(), c1754y.mo6276e(), c1754y.mo6277f(), c1754y.mo6278g(), c1754y.mo6279h());
                    } else if (c1754y.mo6273b() == 256) {
                        Core.loadImage(c1754y.mo6272a(), c1754y.mo6272a().length, 0, c1754y.mo6276e(), c1754y.mo6277f(), c1754y.mo6278g(), c1754y.mo6279h());
                    }
                }
                if (C1753x.f5017I.size() > 0) {
                    f4707b = true;
                    f4633F.mo5859b();
                    return;
                }
            }
            if (f4736g) {
                m7840b();
                C1753x.f5019K = Core.getFx();
                f4738i = true;
                if (f4736g) {
                    f4736g = false;
                    f4690aj.post(f4721bn);
                }
            } else if (f4733d) {
                f4733d = false;
                f4737h = false;
                Core.clear();
                mo6070a();
                f4690aj.post(f4723bp);
            }
        }

        public void mo5871a(GL10 gl10, int i, int i2) {
        }

        public void mo5872a(GL10 gl10, EGLConfig eGLConfig) {
        }
    }

    class C16421 implements OnTouchListener {
        boolean f4560a;

        @SuppressLint("ClickableViewAccessibility")
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f4560a = true;
                    view.setBackgroundColor(f4666aL.getResources().getColor(R.color.color_wb_button_touched));
                    break;
                case 1:
                    if (this.f4560a) {
                        view.setBackgroundColor(0);
                        f4643P.mo5831b(view);
                        break;
                    }
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x < 0 || y < 0 || x >= view.getWidth() || y >= view.getHeight()) {
                        view.setBackgroundColor(0);
                        this.f4560a = false;
                        break;
                    }
            }
            return true;
        }
    }


    class C164320 implements C1577ad.C1575a {

        public void mo5823a(C1577ad c1577ad, int i, int i2) {
            C1568a a = c1577ad.mo5825a(i);
            int i3 = 0;
            for (C1568a c1568a : f4639L.mo5833d()) {
                if (c1568a.mo5812e() != a.mo5812e()) {
                    c1568a.mo5807a(false);
                    f4639L.mo5835f().get(i3).setChecked(false);
                } else {
                    c1568a.mo5807a(true);
                     f4639L.mo5835f().get(i3).setChecked(true);
                }
                i3++;
            }
            if ((C1753x.f5027a && f4668aN.mo6139b()) || (!C1753x.f5027a && f4667aM.mo6110b())) {
                if (C1753x.f5027a) {
                    f4668aN.mo6142c(a.mo5805a());
                } else {
                    f4667aM.mo6112c(a.mo5805a());
                }
                f4642O = a.mo5812e();
                f4641N.setImageDrawable(a.mo5811d());
            }
        }
    }

    class C164421 implements C1577ad.C1575a {

        @SuppressLint("ClickableViewAccessibility")
        public void mo5823a(C1577ad c1577ad, int i, int i2) {
            boolean z = false;
            boolean z2 = true;
            C1568a a = c1577ad.mo5825a(i);
            int i3 = 0;
            for (C1568a c1568a : f4643P.mo5833d()) {
                if (c1568a.mo5812e() != a.mo5812e()) {
                    c1568a.mo5807a(false);
                   f4643P.mo5835f().get(i3).setChecked(false);
                } else {
                    c1568a.mo5807a(true);
                   f4643P.mo5835f().get(i3).setChecked(true);
                }
                i3++;
            }
            if ((C1753x.f5027a && f4668aN.mo6139b()) || (!C1753x.f5027a && f4667aM.mo6110b())) {
                f4652Y.setAlpha(1.0f);
                f4652Y.setOnTouchListener(f4674aT);
                if (f4647T.getParent() != null) {
                    f4647T.setAlpha(1.0f);
                    f4647T.setOnTouchListener(f4672aR);
                }
                if (C1753x.f5027a) {
                    C1696p e = f4668aN;
                    if (a.mo5812e() == 1) {
                        z = true;
                    }
                    e.mo6138b(z);
                } else {
                    C1694o f = f4667aM;
                    if (a.mo5812e() != 1) {
                        z2 = false;
                    }
                    f.mo6109b(z2);
                }
                f4645R.setImageDrawable(a.mo5811d());
                f4646S = a.mo5812e();
            }
        }
    }

    class C164623 implements OnTouchListener {
        boolean f4565a;

        @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f4565a = true;
                    view.setBackgroundColor(f4666aL.getResources().getColor(R.color.color_wb_button_touched));
                    break;
                case 1:
                    if (this.f4565a) {
                        view.setBackgroundColor(0);
                        if ((C1753x.f5027a && f4668aN.mo6139b()) || (!C1753x.f5027a && f4667aM.mo6110b())) {
                            if (!f4648U) {
                                f4647T.setImageDrawable(f4666aL.getResources().getDrawable(R.drawable.fav));
                                if (C1753x.f5027a) {
                                    f4668aN.mo6130a(2);
                                } else {
                                    f4667aM.mo6103a("torch");
                                }
                                f4648U = true;
                                break;
                            }
                            f4647T.setImageDrawable(f4666aL.getResources().getDrawable(R.drawable.fav));
                            if (C1753x.f5027a) {
                                f4668aN.mo6130a(0);
                            } else {
                                f4667aM.mo6103a("off");
                            }
                            f4648U = false;
                            break;
                        }
                    }
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x < 0 || y < 0 || x >= view.getWidth() || y >= view.getHeight()) {
                        view.setBackgroundColor(0);
                        this.f4565a = false;
                        break;
                    }
            }
            return true;
        }
    }

    class C164825 implements C1577ad.C1575a {

        public void mo5823a(C1577ad c1577ad, int i, int i2) {
            C1568a a = c1577ad.mo5825a(i);
            int i3 = 0;
            for (C1568a c1568a : f4650W.mo5833d()) {
                if (c1568a.mo5812e() != a.mo5812e()) {
                    c1568a.mo5807a(false);
                     f4650W.mo5835f().get(i3).setChecked(false);
                } else {
                    c1568a.mo5807a(true);
                   f4650W.mo5835f().get(i3).setChecked(true);
                }
                i3++;
            }
            if ((C1753x.f5027a && f4668aN.mo6139b()) || (!C1753x.f5027a && f4667aM.mo6110b())) {
                if (C1753x.f5027a) {
                    f4668aN.mo6134a(a.mo5805a());
                } else {
                    f4667aM.mo6108b(a.mo5805a());
                }
                f4653Z = a.mo5805a();
            }
        }
    }

    static class C16572 implements ShutterCallback {

        public void onShutter() {
            C1753x.f5016H++;
            C1753x.f5015G++;
            Core.takingPhoto();
        }
    }


    class C166032 implements OnTouchListener {
        boolean f4586a;

        @SuppressLint("ClickableViewAccessibility")
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f4586a = true;
                    view.setBackgroundColor(f4666aL.getResources().getColor(R.color.color_wb_button_touched));
                    break;
                case 1:
                    if (this.f4586a) {
                        view.setBackgroundColor(0);
                        f4639L.mo5831b(view);
                        break;
                    }
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x < 0 || y < 0 || x >= view.getWidth() || y >= view.getHeight()) {
                        view.setBackgroundColor(0);
                        this.f4586a = false;
                        break;
                    }
            }
            return true;
        }
    }


    class C166234 implements Runnable {

        public void run() {
            f4658aD.mo5940e();
        }
    }

    class C166335 implements Runnable {

        public void run() {
            f4658aD.mo5940e();
        }
    }

    class C166436 implements Runnable {

        public void run() {
            f4658aD.mo5940e();
        }
    }

    class C166537 implements OnTouchListener {
        boolean f4592a;

        @SuppressLint("ClickableViewAccessibility")
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f4592a = true;
                    view.setBackgroundColor(f4666aL.getResources().getColor(R.color.color_wb_button_touched));
                    break;
                case 1:
                    if (this.f4592a) {
                        view.setBackgroundColor(0);
                        f4650W.mo5831b(view);
                        break;
                    }
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (x < 0 || y < 0 || x >= view.getWidth() || y >= view.getHeight()) {
                        view.setBackgroundColor(0);
                        this.f4592a = false;
                        break;
                    }
            }
            return true;
        }
    }

    class C167038 implements OnTouchListener {
        boolean f4598a;

        @SuppressLint({"UseCompatLoadingForDrawables", "ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int i;
            switch (motionEvent.getAction()) {
                case 0:
                    this.f4598a = true;
                    view.setBackgroundColor(f4666aL.getResources().getColor(R.color.color_wb_button_touched));
                    break;
                case 1:
                    if (this.f4598a) {
                        view.setBackgroundColor(0);
                        if (f4687ag) {
                            f4687ag = false;
                            if (C1753x.f5027a) {
                                f4668aN.mo6135a(false);
                            } else {
                                f4667aM.mo6104a(false);
                            }
                            f4686af.setImageDrawable(f4666aL.getResources().getDrawable(R.drawable.fav));
                            f4645R.setAlpha(1.0f);
                            f4645R.setOnTouchListener(f4670aP);
                            f4641N.setAlpha(1.0f);
                            f4641N.setOnTouchListener(f4673aS);
                            f4652Y.setAlpha(1.0f);
                            f4652Y.setOnTouchListener(f4674aT);
                            f4647T.setAlpha(1.0f);
                            f4647T.setOnTouchListener(f4672aR);
                        } else {
                            C1568a c1568a;
                            f4646S = 0;
                            for (i = 0; i < f4643P.mo5833d().size(); i++) {
                                c1568a = f4643P.mo5833d().get(i);
                                if (c1568a.mo5812e() == f4646S) {
                                    f4645R.setImageDrawable(c1568a.mo5811d());
                                    c1568a.mo5807a(true);
                                    f4643P.mo5835f().get(i).setChecked(true);
                                } else {
                                    c1568a.mo5807a(false);
                                   f4643P.mo5835f().get(i).setChecked(false);
                                }
                            }
                            if (C1753x.f5027a) {
                                f4668aN.mo6138b(false);
                            } else {
                                f4667aM.mo6109b(false);
                            }
                            f4645R.setAlpha(0.5f);
                            f4642O = 1;
                            for (i = 0; i < f4639L.mo5833d().size(); i++) {
                                c1568a =  f4639L.mo5833d().get(i);
                                if (c1568a.mo5812e() == f4642O) {
                                    f4641N.setImageDrawable(c1568a.mo5811d());
                                    c1568a.mo5807a(true);
                                    f4639L.mo5835f().get(i).setChecked(true);
                                } else {
                                    c1568a.mo5807a(false);
                                    f4639L.mo5835f().get(i).setChecked(false);
                                }
                            }
                            if (C1753x.f5027a) {
                                f4668aN.mo6143c(false);
                            } else {
                                f4667aM.mo6113c(false);
                            }
                            f4641N.setAlpha(0.5f);
                            if (C1753x.f5027a) {
                                f4653Z = String.valueOf(0);
                            } else {
                                f4653Z = "none";
                            }
                            for (int i2 = 0; i2 < f4650W.mo5833d().size(); i2++) {
                                c1568a = f4650W.mo5833d().get(i2);
                                c1568a.mo5807a(c1568a.mo5805a().equals(f4653Z));
                               f4650W.mo5835f().get(i2).setChecked(c1568a.mo5805a().equals(f4653Z));
                            }
                            if (C1753x.f5027a) {
                                f4668aN.mo6134a(f4653Z);
                            } else {
                                f4667aM.mo6108b(f4653Z);
                            }
                            f4652Y.setAlpha(0.5f);
                            f4648U = f4649V = false;
                            if (C1753x.f5027a) {
                                f4668aN.mo6130a(0);
                            } else {
                                f4667aM.mo6103a("off");
                            }
                            f4647T.setImageDrawable(f4666aL.getResources().getDrawable(R.drawable.fav));
                            f4647T.setAlpha(0.5f);
                            f4687ag = true;
                            if (C1753x.f5027a) {
                                f4668aN.mo6135a(true);
                            } else {
                                f4667aM.mo6104a(true);
                            }
                            f4686af.setImageDrawable(f4666aL.getResources().getDrawable(R.drawable.fav));
                        }
                        if (f4658aD != null) {
                            f4658aD.mo5936b();
                            break;
                        }
                    }
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    i = (int) motionEvent.getY();
                    if (x < 0 || i < 0 || x >= view.getWidth() || i >= view.getHeight()) {
                        view.setBackgroundColor(0);
                        this.f4598a = false;
                        break;
                    }
            }
            return true;
        }
    }

    class C167139 implements Runnable {

        public void run() {
            int i = 0;
            Log.e("rmh", "mRunnableStartCamera ");
            try {
                f4667aM.mo6106b(f4657aC ? m7954q() : m7956r());
                if (f4667aM.mo6122j()) {
                    f4693am = true;
                    if (f4693am) {
                        if (f4705ay) {
                            //f4630C.setVisibility(0);
                            if (f4706az) {
                                f4681aa.setVisibility(View.VISIBLE);
                            }
                            if (f4656aB) {
                                f4682ab.setVisibility(View.VISIBLE);
                            }
                        }
                        m7959s();
                        mo6072a(f4691ak, f4692al);
                        f4667aM.mo6128p();
                        C1751v.m8330a(f4657aC);
                        f4735f = true;
                        m7922b(f4666aL);
                        m7926c(f4666aL);
                        m7931d(f4666aL);
                        m7961t();
                        if (f4657aC) {
                            if (f4655aA) {
                                f4683ac.setVisibility(View.GONE);
                            }
                            if (f4684ad) {
                                mo6085h();
                                f4685ae = true;
                            }
                        } else {
                            if (f4655aA) {
                                f4683ac.setVisibility(View.VISIBLE);
                            }
                            if (f4685ae) {
                                mo6084g();
                                f4685ae = false;
                            }
                            if (f4667aM.mo6114c()) {
                                ImageView l = f4686af;
                                if (!f4705ay) {
                                    i = 8;
                                }
                                l.setVisibility(i);
                                f4686af.setImageDrawable(f4666aL.getResources().getDrawable(f4687ag ? R.drawable.fav : R.drawable.fav));
                                f4667aM.mo6104a(f4687ag);
                            } else {
                                f4687ag = false;
                                f4686af.setVisibility(View.GONE);
                            }
                        }
                        if (f4646S == 1) {
                            f4667aM.mo6109b(true);
                        }
                        if (f4648U) {
                            f4667aM.mo6103a("torch");
                        }
                        f4667aM.mo6108b(f4653Z);
                        f4667aM.mo6112c(f4640M.mo5907a(f4642O));
                        if (C1753x.f5012D && f4631D == null && f4632E) {
                            try {
                                f4631D = new int[(f4694an * f4695ao)];
                            } catch (OutOfMemoryError e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (f4658aD != null) {
                        f4658aD.mo5943h();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Camera returned null");
            } catch (Exception e2) {
                e2.printStackTrace();
                C1570ab.m7585b(C1693n.f4627m, "Error:" + e2.getMessage());
                f4693am = false;
                f4667aM.mo6107b(null);
            }
        }
    }

    class C16723 implements PreviewCallback {

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (camera != null) {
                C1753x.f5017I.offer(new C1754y(bArr, f4698ar, f4694an, f4695ao, Core.getr(), Core.getp(), Core.gety1(), Core.gety2()));
                C1753x.f5015G++;
                C1753x.f5016H++;
                f4710bc = false;
                if (C1753x.f5013E) {
                    f4707b = true;
                    f4633F.mo5859b();
                }
            }
        }
    }

    class C167340 implements C1630l {

        public void mo5995a(boolean z) {
            if (!f4729bv) {
                f4690aj.postDelayed(f4678aX, 0);
            }
        }
    }

    class C167441 implements Runnable {

        public void run() {
            int i = 0;
            try {
                if (C1753x.f5027a) {
                    if (!f4668aN.mo6144c()) {
                        throw new IllegalStateException("Camera returned null");
                    }
                } else if (!f4667aM.mo6122j()) {
                    throw new IllegalStateException("Camera returned null");
                }
                f4693am = true;
            } catch (Exception e) {
                e.printStackTrace();
                C1570ab.m7585b(C1693n.f4627m, "Error:" + e.getMessage());
                f4693am = false;
                if (C1753x.f5027a) {
                    f4668aN.mo6131a(null);
                } else {
                    f4667aM.mo6107b(null);
                }
            }
            if (f4693am) {
                if (f4705ay) {
                    //f4630C.setVisibility(0);
                    if (f4706az) {
                        f4681aa.setVisibility(View.VISIBLE);
                    }
                    if (f4656aB) {
                        f4682ab.setVisibility(View.VISIBLE);
                    }
                }
                m7959s();
                mo6072a(f4691ak, f4692al);
                if (C1753x.f5027a) {
                    f4668aN.mo6154k();
                } else {
                    f4667aM.mo6128p();
                }
                C1751v.m8330a(f4657aC);
                f4735f = true;
                m7922b(f4666aL);
                m7926c(f4666aL);
                m7931d(f4666aL);
                m7961t();
                if (f4657aC) {
                    if (f4655aA) {
                        f4683ac.setVisibility(View.GONE);
                    }
                    if (f4684ad) {
                        mo6085h();
                        f4685ae = true;
                    }
                } else {
                    if (f4655aA) {
                        f4683ac.setVisibility(View.VISIBLE);
                    }
                    if (f4685ae) {
                        mo6084g();
                        f4685ae = false;
                    }
                    if (C1753x.f5027a ? f4668aN.mo6153j() : f4667aM.mo6114c()) {
                        ImageView l = f4686af;
                        if (!f4705ay) {
                            i = 8;
                        }
                        l.setVisibility(i);
                        f4686af.setImageDrawable(f4666aL.getResources().getDrawable(f4687ag ? R.drawable.fav : R.drawable.fav));
                        if (C1753x.f5027a) {
                            f4668aN.mo6135a(f4687ag);
                        } else {
                            f4667aM.mo6104a(f4687ag);
                        }
                    } else {
                        f4687ag = false;
                        f4686af.setVisibility(View.GONE);
                    }
                }
                if (f4646S == 1) {
                    if (C1753x.f5027a) {
                        f4668aN.mo6138b(true);
                    } else {
                        f4667aM.mo6109b(true);
                    }
                }
                if (f4648U) {
                    if (C1753x.f5027a) {
                        f4668aN.mo6130a(2);
                    } else {
                        f4667aM.mo6103a("torch");
                    }
                }
                f4668aN.mo6134a(f4653Z);
                f4668aN.mo6142c(String.valueOf(f4642O));
                if (C1753x.f5012D && f4631D == null && f4632E) {
                    try {
                        f4631D = new int[(f4694an * f4695ao)];
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (f4658aD != null) {
                f4658aD.mo5943h();
            }
        }
    }

    class C16754 implements PictureCallback {

        public void onPictureTaken(byte[] bArr, Camera camera) {
            Core.readExposure(bArr);
            if (f4679aY) {
                Core.photoReady1(f4657aC, 0.0d);
            } else {
                Core.photoReady(f4657aC);
            }
            C1754y r1=  new C1754y(bArr, f4699as, f4696ap, f4697aq, Core.getr(), Core.getp(), Core.gety1(), Core.gety2());
            C1753x.f5017I.offer(r1);
            if (C1753x.f5013E && f4751w) {
                f4707b = true;
                f4633F.mo5859b();
            }
            if (camera != null) {
                try {
                    camera.startPreview();
                } catch (Exception e) {
                    e.printStackTrace();
                    C1570ab.m7585b(C1693n.f4627m, e.getMessage());
                }
            }
            f4710bc = false;
            if (f4658aD != null) {
                f4658aD.mo5941f();
            }
            if (f4662aH) {
                new C1692g().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new C1754y[]{r1});
            }
        }
    }

    class C16785 implements C1677z {

        class C16761 implements Runnable {

            public void run() {
                f4658aD.mo5941f();
            }
        }

        public void mo6048a(byte[] bArr) {
            Core.readExposure(bArr);
            if (f4679aY) {
                Core.photoReady1(f4657aC, 0.0d);
            } else {
                Core.photoReady(f4657aC);
            }
            C1754y r1 = new C1754y(bArr, f4699as, f4696ap, f4697aq, Core.getr(), Core.getp(), Core.gety1(), Core.gety2());
            C1753x.f5017I.offer(r1);
            if (C1753x.f5013E && f4751w) {
                f4707b = true;
                f4633F.mo5859b();
            }
            f4710bc = false;
            if (f4658aD != null) {
                f4717bj.post(new C16761());
            }
            if (f4662aH) {
                new C1692g().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new C1754y[]{r1});
            }
        }
    }

    class C16806 implements PreviewCallback {

        class C16791 implements Runnable {
            public void run() {
                f4658aD.mo5940e();
            }
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (C1753x.f5027a && !f4668aN.mo6144c()) {
                return;
            }
            if (C1753x.f5027a || f4667aM.mo6122j()) {
                if (f4632E) {
                    Bitmap createBitmap;
                    if (f4631D == null) {
                        try {
                            f4631D = new int[(f4694an * f4695ao)];
                        } catch (OutOfMemoryError e) {
                            e.printStackTrace();
                        }
                    }
                    Core.decodeYUV420SP(f4631D, bArr, f4694an, f4695ao, !C1753x.m8334c(), f4657aC);
                    try {
                        createBitmap = Bitmap.createBitmap(f4631D, C1753x.m8334c() ? f4694an : f4695ao, C1753x.m8334c() ? f4695ao : f4694an, Config.ARGB_8888);
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                        createBitmap = null;
                    }
                    if (f4658aD != null) {
                        f4658aD.mo5933a(createBitmap);
                    }
                }
                if (f4658aD != null) {
                    f4717bj.post(new C16791());
                }
                f4667aM.mo6100a(f4680aZ, null, f4712be);
            }
        }
    }

    class C16827 implements AutoFocusCallback {

        class C16811 implements Runnable {
            public void run() {
                f4658aD.mo5940e();
            }
        }

        public void onAutoFocus(boolean z, Camera camera) {
            f4753y = false;
            if (!f4715bh) {
                mo6088k();
            } else if (C1753x.f5027a) {
                if (f4658aD != null) {
                    f4717bj.post(new C16811());
                }
                f4668aN.mo6133a(f4713bf);
            } else {
                f4667aM.mo6099a(f4714bg);
            }
        }
    }

    class C16848 implements C1613b {

        class C16831 implements Runnable {

            public void run() {
                f4658aD.mo5940e();
            }
        }

        public void mo5916a(boolean z) {
            f4753y = false;
            if (!f4715bh) {
                mo6088k();
            } else if (C1753x.f5027a) {
                if (f4658aD != null) {
                    f4717bj.post(new C16831());
                }
                f4668aN.mo6133a(f4713bf);
            } else {
                f4667aM.mo6099a(f4714bg);
            }
        }
    }

    class C16859 implements Runnable {

        public void run() {
            mo6088k();
        }
    }

    public enum C1687b {
        kDMDCompassInterference
    }

    private class C1688c extends AsyncTask<String, Void, Void> {

        public Void doInBackground(String... strArr) {
            int i = 0;
            if (!(strArr == null || strArr[0] == null)) {
                File file = new File(strArr[0]);
                if (file != null && file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        while (i < listFiles.length) {
                            listFiles[i].delete();
                            i++;
                        }
                    }
                    file.delete();
                }
            }
            return null;
        }
    }

    public enum C1689d {
        fovx
    }

    private class C1690e extends AsyncTask<Double, Void, Void> {
        Geocoder f4619a;
        Context f4620b;
        String f4621c = "";
        String f4622d = "";

        C1690e(Context context) {
            this.f4620b = context;
        }


        public Void doInBackground(Double... dArr) {
            try {
                List fromLocation = this.f4619a.getFromLocation(dArr[0].doubleValue(), dArr[1].doubleValue(), 1);
                if (fromLocation.size() > 0) {
                    String locality = ((Address) fromLocation.get(0)).getLocality();
                    String adminArea = ((Address) fromLocation.get(0)).getAdminArea();
                    String countryName = ((Address) fromLocation.get(0)).getCountryName();
                    if (!mo6059a(locality)) {
                        this.f4621c = locality;
                        StringBuilder append = new StringBuilder().append(!mo6059a(adminArea) ? adminArea + ", " : "");
                        if (mo6059a(countryName)) {
                            countryName = "";
                        }
                        this.f4622d = append.append(countryName).toString();
                    } else if (!mo6059a(adminArea)) {
                        this.f4621c = adminArea;
                        if (mo6059a(countryName)) {
                            countryName = "";
                        }
                        this.f4622d = countryName;
                    } else if (!mo6059a(countryName)) {
                        this.f4621c = countryName;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public void onPostExecute(Void voidR) {
            C1753x.f5037k = this.f4621c;
            C1753x.f5038l = this.f4622d;
        }

        public boolean mo6059a(String str) {
            return str == null || str.isEmpty();
        }

        public void onPreExecute() {
            this.f4619a = new Geocoder(this.f4620b, Locale.getDefault());
        }
    }

    public interface C1691f {
        void mo6063a(String str);
    }

    private class C1692g extends AsyncTask<C1754y, Void, Void> {
        private String f4625b;
        private String f4626c;

        public Void doInBackground(C1754y... c1754yArr) {
            C1754y c1754y = c1754yArr[0];
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f4625b + "/" + this.f4626c);
                fileOutputStream.write(c1754y.mo6272a());
                fileOutputStream.close();
                if (!C1753x.m8334c()) {
                    ExifInterface exifInterface = new ExifInterface(this.f4625b + "/" + this.f4626c);
                    exifInterface.setAttribute("Orientation", "6");
                    exifInterface.saveAttributes();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public void onPostExecute(Void voidR) {
            C1582af c1582af = new C1582af(f4666aL, this.f4625b + "/" + this.f4626c);
            if (f4731bx != null) {
                f4731bx.mo6063a(this.f4625b + "/" + this.f4626c);
            }
        }

        public void onPreExecute() {
            this.f4626c = "shot-" + f4638K.format(new Date()) + ".jpg";
            if (f4663aI != null) {
                this.f4625b = f4663aI;
            } else {
                this.f4625b = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() + "/" + C1753x.f5018J + "/";
            }
            try {
                File file = new File(this.f4625b);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static {
        System.loadLibrary("corenew");
    }

    private void m7889a(int i) {
        if (this.f4705ay) {
            if (this.f4706az) {
                this.f4681aa.setVisibility(View.VISIBLE);
            }
            if (this.f4656aB) {
                this.f4682ab.setVisibility(View.VISIBLE);
            }
        }
        boolean b = C1753x.f5027a ? this.f4668aN.mo6139b() : this.f4667aM.mo6110b();
        if (this.f4642O == this.f4640M.mo5905a().mo6264a() && b) {
            if (C1753x.f5027a) {
                this.f4668aN.mo6143c(false);
            } else {
                this.f4667aM.mo6113c(false);
            }
        }
        if (this.f4646S != -1 && b && this.f4646S == 2) {
            if (C1753x.f5027a) {
                this.f4668aN.mo6138b(false);
            } else {
                this.f4667aM.mo6109b(false);
            }
        }
        if (C1753x.f5027a) {
            this.f4668aN.f4760a.mo5983d();
        }
        this.f4709bb = i;
        this.f4751w = false;
        this.f4710bc = false;
        this.f4660aF = true;
        C1753x.f5016H = 0;
        C1753x.f5015G = 0;
        C1753x.f5017I.clear();
        this.f4732c = true;
        this.f4633F.mo5859b();
        C1688c c1688c = new C1688c();
        if (VERSION.SDK_INT >= 11) {
            c1688c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{this.f4739j});
        } else {
            c1688c.execute(new String[]{this.f4739j});
        }
    }

    private void m7892a(LinkedHashMap<String, String> linkedHashMap) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f4739j + "/" + "other.txt"), false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(linkedHashMap);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m7922b(Context context) {
        List f;
        boolean z;
        C1748t a;
        C1568a c1568a;
        int i = 0;
        if (this.f4639L != null) {
            this.f4639L.mo5834e();
        }
        boolean e;
        if (C1753x.f5027a) {
            e = this.f4668aN.mo6148e();
            f = this.f4668aN.mo6149f();
            z = e;
        } else {
            e = this.f4667aM.mo6119g();
            f = this.f4667aM.mo6120h();
            z = e;
        }
        ArrayList<C1568a> arrayList = new ArrayList();
        if (z) {
            a = this.f4640M.mo5905a();
            c1568a = new C1568a(a.mo6264a(), a.mo6267d(), a.mo6268e(), a.mo6265b(), a.mo6266c());
            c1568a.mo5806a(a.mo6269f());
            if (this.f4642O == c1568a.mo5812e()) {
                this.f4641N.setImageDrawable(context.getResources().getDrawable(R.drawable.fav));
                c1568a.mo5807a(true);
            }
            arrayList.add(c1568a);
        }
        if (f != null) {
            if (this.f4641N.getParent() == null) {
               // this.f4630C.addView(this.f4641N, 0);
            }
            while (i < f.size()) {
                a = this.f4640M.mo5906a((String) f.get(i));
                if (a != null) {
                    c1568a = new C1568a(a.mo6264a(), a.mo6267d(), a.mo6268e(), a.mo6265b(), a.mo6266c());
                    c1568a.mo5806a(a.mo6269f());
                    if (this.f4642O == c1568a.mo5812e()) {
                        c1568a.mo5807a(true);
                        this.f4641N.setImageDrawable(c1568a.mo5811d());
                    }
                    arrayList.add(c1568a);
                }
                i++;
            }
            Collections.sort(arrayList);
            for (C1568a c1568a2 : arrayList) {
                this.f4639L.mo5826a(c1568a2);
            }
        } else if (this.f4641N.getParent() != null) {
          //  this.f4630C.removeView(this.f4641N);
        }
    }

    private void m7926c(Context context) {
        if (this.f4643P != null) {
            this.f4643P.mo5834e();
        }
        if (C1753x.f5027a ? this.f4668aN.mo6150g() : this.f4667aM.mo6118f()) {
            C1568a c1568a;
            if (this.f4645R.getParent() == null) {
            //    this.f4630C.addView(this.f4645R, 1);
            }
            ArrayList<C1568a> arrayList = new ArrayList();
            List a = this.f4644Q.mo6270a();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= a.size()) {
                    break;
                }
                C1748t c1748t = (C1748t) a.get(i2);
                c1568a = new C1568a(c1748t.mo6264a(), c1748t.mo6267d(), c1748t.mo6268e(), c1748t.mo6265b(), c1748t.mo6266c());
                c1568a.mo5806a(c1748t.mo6269f());
                if (c1568a.mo5812e() == this.f4646S) {
                    this.f4645R.setImageDrawable(c1568a.mo5811d());
                    c1568a.mo5807a(true);
                }
                arrayList.add(c1568a);
                i = i2 + 1;
            }
            Collections.sort(arrayList);
            for (C1568a c1568a2 : arrayList) {
                this.f4643P.mo5826a(c1568a2);
            }
        } else if (this.f4645R.getParent() != null) {
           // this.f4630C.removeView(this.f4645R);
        }
    }

    private void m7931d(Context context) {
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
        boolean b = C1753x.f5027a ? this.f4668aN.mo6140b("torch") : this.f4667aM.mo6116d("torch");
        if (hasSystemFeature && b) {
            if (this.f4647T.getParent() == null) {
              //  this.f4630C.addView(this.f4647T, 2);
            }
        } else if (this.f4647T.getParent() != null) {
          //  this.f4630C.removeView(this.f4647T);
        }
    }

    private void m7951o() {
        SharedPreferences sharedPreferences = this.f4666aL.getSharedPreferences("DMDPref_Library", 0);
        this.f4642O = sharedPreferences.getInt("WB_MODE", 0);
        this.f4646S = sharedPreferences.getInt("EXP_MODE", 0);
        this.f4648U = sharedPreferences.getBoolean("FLASH_MODE", false);
        this.f4649V = sharedPreferences.getBoolean("WAS_FLASH_ON", false);
        if (C1753x.f5027a) {
            int parseInt;
            this.f4653Z = sharedPreferences.getString("COLOR_MODE", String.valueOf(0));
            try {
                parseInt = Integer.parseInt(this.f4653Z);
            } catch (Exception e) {
                e.printStackTrace();
                parseInt = 0;
            }
            this.f4653Z = String.valueOf(parseInt);
        } else {
            String str = "none";
            this.f4653Z = sharedPreferences.getString("COLOR_MODE", "none");
            try {
                Integer.parseInt(this.f4653Z);
            } catch (Exception e2) {
                e2.printStackTrace();
                str = this.f4653Z;
            }
            this.f4653Z = str;
        }
        this.f4684ad = sharedPreferences.getBoolean("HD_MODE", true);
        this.f4687ag = sharedPreferences.getBoolean("HDR_MODE", false);
        this.f4688ah = sharedPreferences.getBoolean("WAS_HDR_MODE", false);
        this.f4685ae = sharedPreferences.getBoolean("WAS_HD_MODE", false);
        this.f4657aC = sharedPreferences.getBoolean("FRONT_CAM", false);
    }

    /* renamed from: p */
    private void m7953p() {
        Editor edit = this.f4666aL.getSharedPreferences("DMDPref_Library", 0).edit();
        edit.putInt("WB_MODE", this.f4642O);
        edit.putInt("EXP_MODE", this.f4646S);
        edit.putBoolean("FLASH_MODE", this.f4648U);
        edit.putBoolean("WAS_FLASH_ON", this.f4649V);
        edit.putString("COLOR_MODE", this.f4653Z);
        edit.putBoolean("HD_MODE", this.f4684ad);
        edit.putBoolean("HDR_MODE", this.f4687ag);
        edit.putBoolean("WAS_HDR_MODE", this.f4688ah);
        edit.putBoolean("WAS_HD_MODE", this.f4685ae);
        edit.putBoolean("FRONT_CAM", this.f4657aC);
        edit.apply();
    }

    private int m7954q() {
        CameraInfo cameraInfo = new CameraInfo();
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 1) {
                return i;
            }
        }
        return -1;
    }

    private int m7956r() {
        CameraInfo cameraInfo = new CameraInfo();
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                return i;
            }
        }
        return -1;
    }

    private void m7959s() {
        if (C1753x.f5027a && !this.f4668aN.mo6144c()) {
            return;
        }
        if (!C1753x.f5027a && !this.f4667aM.mo6122j()) {
            return;
        }
        if (C1753x.f5027a) {
            this.f4668aN.mo6147e(0);
            this.f4668aN.mo6137b(this.f4668aN.mo6159p());
            return;
        }
        this.f4667aM.mo6096a(0);
        this.f4667aM.mo6101a(this.f4667aM.mo6125m());
        this.f4667aM.mo6117e();
        this.f4667aM.mo6102a(null, 0, 0, 0);
        this.f4667aM.mo6111c(this.f4657aC ? m7954q() : m7956r());
        this.f4667aM.mo6127o();
    }

    private void m7961t() {
        if (this.f4650W != null) {
            this.f4650W.mo5834e();
        }
        List<String> h = C1753x.f5027a ? this.f4668aN.mo6151h() : this.f4667aM.mo6121i();
        ArrayList<C1568a> arrayList = new ArrayList<>();
        if (h != null && h.size() > 1) {
            C1568a c1568a;

            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= h.size()) {
                    break;
                }
                C1748t a = this.f4651X.mo5955a(h.get(i2));
                if (a != null) {
                    c1568a = new C1568a(a.mo6264a(), a.mo6267d(), a.mo6268e(), a.mo6265b(), a.mo6266c());
                    c1568a.mo5806a(a.mo6269f());
                    if (c1568a.mo5805a().equals(this.f4653Z)) {
                        c1568a.mo5807a(true);
                    }
                    arrayList.add(c1568a);
                }
                i = i2 + 1;
            }
            Collections.sort(arrayList);
            for (C1568a c1568a2 : arrayList) {
                this.f4650W.mo5826a(c1568a2);
            }
        }
    }

    private void m7963u() {
        if (this.f4705ay) {
            if (this.f4706az) {
                this.f4681aa.setVisibility(View.GONE);
            }
            if (this.f4656aB) {
                this.f4682ab.setVisibility(View.GONE);
            }
        }
        boolean b = C1753x.f5027a ? this.f4668aN.mo6139b() : this.f4667aM.mo6110b();
        if (this.f4642O == this.f4640M.mo5905a().mo6264a() && b) {
            if (C1753x.f5027a) {
                this.f4668aN.mo6143c(true);
            } else {
                this.f4667aM.mo6113c(true);
            }
        }
        if (this.f4646S != -1 && b && this.f4646S == 2) {
            if (C1753x.f5027a) {
                this.f4668aN.mo6138b(true);
            } else {
                this.f4667aM.mo6109b(true);
            }
        }
        File file = new File(this.f4739j);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f4752x = true;
        this.f4751w = true;
        this.f4754z = false;
        this.f4708ba = false;
        C1753x.f5016H = 0;
        C1753x.f5015G = 0;
        Core.startShooting();
        this.f4654a = true;
        this.f4633F.mo5859b();
    }

    private boolean m7965v() {
        if (this.f4753y) {
            this.f4753y = false;
            if (C1753x.f5027a) {
                this.f4668aN.mo6152i();
            } else {
                this.f4667aM.mo6126n();
            }
        }
        boolean b = C1753x.f5027a ? this.f4668aN.mo6139b() : this.f4667aM.mo6110b();
        if (this.f4642O == this.f4640M.mo5905a().mo6264a() && b) {
            if (C1753x.f5027a) {
                this.f4668aN.mo6143c(false);
            } else {
                this.f4667aM.mo6113c(false);
            }
        }
        if (this.f4646S != -1 && b && this.f4646S == 2) {
            if (C1753x.f5027a) {
                this.f4668aN.mo6138b(false);
            } else {
                this.f4667aM.mo6109b(false);
            }
        }
        this.f4751w = false;
        if (C1753x.f5015G >= 2) {
            m7968x();
            b = true;
        } else {
            m7889a(3);
            b = false;
        }
        if (this.f4658aD != null) {
            this.f4658aD.mo5935a(b);
        }
        return b;
    }

    private void m7967w() {
        C1753x.f5020L = Core.getRoll();
        C1753x.f5021M = Core.getPitch();
        C1753x.f5022N = Core.getPercentage();
        C1753x.f5023O = Core.getDirection();
        C1753x.f5024P = (int) Math.round((Core.getangle() * 180.0d) / 3.141592653589793d);
        this.f4715bh = Core.deviceVertical();
        boolean CompassInterference = Core.CompassInterference();
        if (CompassInterference && !this.f4754z) {
            this.f4754z = true;
            this.f4690aj.post(this.f4725br);
        }
        this.f4690aj.post(this.f4726bs);
        if (this.f4660aF || this.f4715bh != this.f4659aE) {
            this.f4660aF = false;
            this.f4659aE = this.f4715bh;
            this.f4690aj.post(this.f4724bq);
        }
        if (this.f4751w) {
            if (Core.isPreparingToShoot() && this.f4658aD != null) {
                this.f4658aD.mo5938c();
            }
            if (Core.cancelPreparingToShoot() && this.f4658aD != null) {
                this.f4658aD.mo5939d();
            }
            if (CompassInterference || Core.getMaxFxReached() || (!this.f4710bc && Core.deviceHorizontal() && C1753x.f5015G >= 2)) {
                if (!this.f4708ba) {
                    this.f4708ba = true;
                    this.f4690aj.post(this.f4719bl);
                }
            } else if (Core.canTakePhoto() && !this.f4710bc) {
                this.f4710bc = true;
                if (!C1753x.f5012D) {
                    Core.takingPhoto();
                    Core.photoReady(this.f4657aC);
                    if (C1753x.f5027a) {
                        if (this.f4658aD != null) {
                            this.f4717bj.post(new C166436());
                        }
                        this.f4668aN.mo6133a(this.f4713bf);
                        return;
                    }
                    this.f4667aM.mo6099a(this.f4711bd);
                } else if (this.f4752x) {
                    this.f4752x = false;
                    C1753x.f5042p = this.f4703aw;
                    if (this.f4661aG) {
                        this.f4753y = true;
                        if ((C1753x.f5027a && this.f4668aN.mo6144c()) || (!C1753x.f5027a && this.f4667aM.mo6122j())) {
                            if (C1753x.f5027a) {
                                this.f4668aN.mo6132a(this.f4718bk);
                            } else {
                                this.f4667aM.mo6098a(this.f4716bi);
                            }
                        }
                    } else if (!this.f4715bh) {
                        mo6088k();
                    } else if (C1753x.f5027a) {
                        if (this.f4658aD != null) {
                            this.f4717bj.post(new C166234());
                        }
                        this.f4668aN.mo6133a(this.f4713bf);
                    } else {
                        this.f4667aM.mo6099a(this.f4714bg);
                    }
                } else if ((C1753x.f5027a && this.f4668aN.mo6144c()) || (!C1753x.f5027a && this.f4667aM.mo6122j())) {
                    if (C1753x.f5027a) {
                        if (this.f4658aD != null) {
                            this.f4717bj.post(new C166335());
                        }
                        this.f4668aN.mo6133a(this.f4713bf);
                        return;
                    }
                    this.f4667aM.mo6099a(this.f4714bg);
                }
            }
        } else this.f4628A = this.f4715bh;
    }

    private void m7968x() {
        this.f4689ai.mo5845c();
        if (this.f4669aO) {
            this.f4628A = false;
            this.f4634G.setRenderMode(0);
            if (this.f4635H.getParent() != null) {
                this.f4629B.removeView(this.f4635H);
            }
        }
        if (C1753x.f5027a) {
            this.f4668aN.mo6147e(-16777216);
        } else {
            this.f4667aM.mo6096a(-16777216);
        }
        if (this.f4635H.getParent() != null) {
            this.f4629B.removeView(this.f4635H);
        }
        this.f4629B.addView(this.f4635H);
        this.f4736g = true;
        this.f4633F.mo5859b();
    }

    private LinkedHashMap<String, String> m7971y() {
        File file = new File(this.f4739j + "/" + "other.txt");
        if (!file.exists()) {
            return new LinkedHashMap<>();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            LinkedHashMap<String, String> linkedHashMap = (LinkedHashMap<String, String>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return linkedHashMap;
        } catch (Exception e) {
            e.printStackTrace();
            return new LinkedHashMap<>();
        }
    }


    @SuppressLint({"UseCompatLoadingForDrawables", "ClickableViewAccessibility"})
    public ViewGroup mo6069a(final Context context, C1616e c1616e, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        int i2;
        this.f4666aL = context;
        if (this.f4741l) {
            Editor edit = this.f4666aL.getSharedPreferences("DMDPref_Library", 0).edit();
            edit.putBoolean("HD_MODE", this.f4684ad);
            edit.apply();
        }
        this.f4741l = false;
        if (C1753x.f5027a) {
            this.f4668aN = new C1696p(this.f4666aL, this.f4677aW);
        } else {
            this.f4667aM = new C1694o();
        }
        this.f4717bj = new Handler(this.f4666aL.getMainLooper());
        mo6085h();
        Core.f9753a = this.f4666aL;
        this.f4658aD = c1616e;
        boolean z6 = z || !Core.isWhiteLabeled();
        this.f4704ax = z6;
        this.f4705ay = z2;
        this.f4706az = z3;
        this.f4656aB = z4;
        this.f4655aA = z5;
        this.f4751w = false;
        if (this.f4656aB && m7954q() == -1) {
            this.f4656aB = false;
        }
        m7951o();
        if (C1753x.f5027a) {
            this.f4668aN.mo6141c(this.f4657aC ? 0 : 1);
        }
        if (this.f4657aC && this.f4687ag) {
            this.f4687ag = false;
            this.f4688ah = true;
        }
        this.f4638K = new SimpleDateFormat("yyMMdd_HHmmss");
        this.f4636I = ((Activity) context).getWindowManager().getDefaultDisplay();
        this.f4637J = new DisplayMetrics();
        this.f4636I.getMetrics(this.f4637J);
        this.f4661aG = context.getPackageManager().hasSystemFeature("android.hardware.camera.autofocus");
        if (i == 0 || i == 2) {
            C1753x.f5034h = this.f4637J.widthPixels;
            C1753x.f5035i = this.f4637J.heightPixels;
        } else {
            C1753x.f5034h = this.f4637J.heightPixels;
            C1753x.f5035i = this.f4637J.widthPixels;
        }
        C1753x.f5036j = ((double) C1753x.f5035i) / ((double) C1753x.f5034h);
        this.f4689ai = new C1581ae(context, this.f4727bt);
        this.f4629B = new RelativeLayout(context);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f4629B.setLayoutParams(layoutParams);
        if (C1753x.m8334c()) {
            layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else {
            layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(12);
        }
        layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        if (C1753x.f5027a) {
            this.f4668aN.mo6155l().setLayoutParams(layoutParams);
            this.f4629B.addView(this.f4668aN.mo6155l());
        } else {
            this.f4667aM.mo6097a(context, layoutParams);
            this.f4629B.addView(this.f4667aM.mo6095a());
        }
        this.f4633F = new C1604ah(context, this.f4728bu);
        layoutParams = new LayoutParams(1, 1);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.f4633F.setLayoutParams(layoutParams);
        this.f4633F.mo5854a(0);
        this.f4633F.mo5860c();
        if (this.f4633F.getParent() == null) {
            this.f4629B.addView(this.f4633F);
        }
        C1751v.m8330a(this.f4657aC);
        this.f4734e = true;
        this.f4733d = false;
        this.f4634G = new C1612al(context);
        this.f4634G.mo5915a(this.f4689ai.mo5846d());
        this.f4634G.setZOrderOnTop(true);
        this.f4634G.setVisibility(this.f4704ax ? View.VISIBLE : View.GONE);
        int round = (int) Math.round(((double) C1753x.f5034h) * 0.0625d);
        LayoutParams layoutParams2 = new LayoutParams(C1753x.f5034h - (round * 2), (int) Math.round((C1753x.m8334c() ? 0.13392857142857142d : 0.26785714285714285d) * ((double) (C1753x.f5034h - (round * 2)))));
        layoutParams2.topMargin = (int) (((double) C1753x.f5035i) * 0.041666666666666664d);
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        this.f4634G.setLayoutParams(layoutParams2);
        this.f4629B.addView(this.f4634G);
        if (C1753x.f5027a) {
            this.f4640M = new C1607ak(context);
        } else {
            this.f4640M = new C1606aj(context);
        }
        this.f4639L = new C1577ad(context);
        this.f4639L.mo5828a("context.getResources().getString(R.string.wb)");
        this.f4639L.mo5832c(3);
        this.f4641N = new ImageView(context);
        this.f4641N.setId(this.f4742n);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        if (C1753x.m8334c()) {
            layoutParams3.bottomMargin = 10;
        } else {
            layoutParams3.weight = 1.0f;
        }
        this.f4641N.setImageDrawable(context.getResources().getDrawable(R.drawable.fav));
        this.f4641N.setLayoutParams(layoutParams3);
        this.f4639L.mo5827a(new C164320());
        this.f4641N.setOnTouchListener(this.f4673aS);
        this.f4644Q = new C1749u(context);
        this.f4643P = new C1577ad(context);
        this.f4643P.mo5828a("context.getResources().getString(R.string.fav)");
        this.f4643P.mo5832c(3);
        this.f4645R = new ImageView(context);
        this.f4645R.setId(this.f4743o);
        layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        if (C1753x.m8334c()) {
            layoutParams3.bottomMargin = 10;
        } else {
            layoutParams3.weight = 1.0f;
        }
        this.f4645R.setImageDrawable(context.getResources().getDrawable(R.drawable.fav));
        this.f4645R.setLayoutParams(layoutParams3);
        this.f4643P.mo5827a(new C164421());
        if (this.f4687ag) {
            this.f4646S = 0;
            if (C1753x.f5027a) {
                this.f4668aN.mo6138b(false);
            } else {
                this.f4667aM.mo6109b(false);
            }
            this.f4645R.setAlpha(0.5f);

            this.f4642O = 1;
            i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.f4639L.mo5833d().size()) {
                    break;
                }
                C1568a c1568a = this.f4639L.mo5833d().get(i3);
                if (c1568a.mo5812e() == this.f4642O) {
                    this.f4641N.setImageDrawable(c1568a.mo5811d());
                    c1568a.mo5807a(true);
                   this.f4639L.mo5835f().get(i3).setChecked(true);
                } else {
                    c1568a.mo5807a(false);
                     this.f4639L.mo5835f().get(i3).setChecked(false);
                }
                i2 = i3 + 1;
            }
            if (C1753x.f5027a) {
                this.f4668aN.mo6143c(false);
            } else {
                this.f4667aM.mo6113c(false);
            }
            this.f4641N.setAlpha(0.5f);
        } else {
            this.f4645R.setOnTouchListener(this.f4670aP);
            this.f4641N.setOnTouchListener(this.f4673aS);
        }
        if (C1753x.f5027a) {
            this.f4651X = new C1621j(context);
        } else {
            this.f4651X = new C1620i(context);
        }
        this.f4650W = new C1577ad(context);
        this.f4650W.mo5829a(true);
        this.f4650W.mo5832c(3);
        this.f4652Y = new ImageView(context);
        this.f4652Y.setId(this.f4746r);
        this.f4652Y.setImageDrawable(context.getResources().getDrawable(R.drawable.fav));
        layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        if (C1753x.m8334c()) {
            layoutParams3.bottomMargin = 10;
        } else {
            layoutParams3.weight = 1.0f;
        }
        this.f4652Y.setLayoutParams(layoutParams3);
        this.f4650W.mo5827a(new C164825());
        if (this.f4687ag) {
            this.f4652Y.setAlpha(0.5f);
        } else {
            this.f4652Y.setAlpha(1.0f);
            this.f4652Y.setOnTouchListener(this.f4674aT);
        }
        this.f4682ab = new ImageView(context);
        this.f4682ab.setId(this.f4747s);
        ImageView imageView = this.f4682ab;
        i2 = (this.f4705ay && this.f4656aB) ? 0 : 8;
        imageView.setVisibility(i2);
        layoutParams = new LayoutParams(-2, -2);
        if (C1753x.m8334c()) {
            layoutParams.addRule(9);
            if (this.f4706az) {
                layoutParams.addRule(2, this.f4744p);
            } else {
                layoutParams.addRule(12);
            }
            layoutParams.bottomMargin = 10;
            layoutParams.leftMargin = 10;
        } else {
            layoutParams.addRule(9);
            layoutParams.bottomMargin = 25;
            layoutParams.leftMargin = 10;
        }
        this.f4682ab.setLayoutParams(layoutParams);
        this.f4682ab.setImageResource(R.drawable.fav);
        this.f4682ab.setOnTouchListener(new OnTouchListener() {

            boolean f4574a;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                int y;
                int i;
                switch (motionEvent.getAction()) {
                    case 0:
                        this.f4574a = true;
                        view.setBackgroundColor(context.getResources().getColor(R.color.color_wb_button_touched));
                        break;
                    case 1:
                        if (this.f4574a) {
                            view.setBackgroundColor(0);
                            f4657aC = !f4657aC;
                            if (C1753x.f5027a) {
                                f4668aN.mo6157n();
                                f4668aN.mo6137b(null);
                                f4668aN.mo6158o();
                                f4668aN.mo6131a(null);
                            } else {
                                f4667aM.mo6115d();
                                f4667aM.mo6123k();
                                f4667aM.mo6101a(null);
                                f4667aM.mo6124l();
                                f4667aM.mo6107b(null);
                            }
                            y = f4657aC ? m7954q() : m7956r();
                            if (C1753x.f5027a) {
                                f4668aN.mo6136b(f4657aC ? 0 : 1);
                            } else {
                                f4667aM.mo6106b(y);
                            }
                            m7959s();
                            mo6072a(f4691ak, f4692al);
                            if (C1753x.f5027a) {
                                f4668aN.mo6154k();
                            } else {
                                f4667aM.mo6128p();
                            }
                            C1751v.m8330a(f4657aC);
                            f4735f = true;
                            m7922b(f4666aL);
                            m7926c(f4666aL);
                            m7931d(f4666aL);
                            m7961t();
                            if (!f4657aC) {
                                if (f4655aA) {
                                    f4683ac.setVisibility(View.VISIBLE);
                                }
                                if (C1753x.f5027a ? f4668aN.mo6153j() : f4667aM.mo6114c()) {
                                    f4686af.setVisibility(View.VISIBLE);
                                    if (f4688ah) {
                                        C1568a c1568a;
                                        f4688ah = false;
                                        f4687ag = true;
                                        if (C1753x.f5027a) {
                                            f4668aN.mo6135a(true);
                                        } else {
                                            f4667aM.mo6104a(true);
                                        }
                                        f4646S = 0;
                                        for (i = 0; i < f4643P.mo5833d().size(); i++) {
                                            c1568a = (C1568a) f4643P.mo5833d().get(i);
                                            if (c1568a.mo5812e() == f4646S) {
                                                f4645R.setImageDrawable(c1568a.mo5811d());
                                                c1568a.mo5807a(true);
                                                ((RadioButton) f4643P.mo5835f().get(i)).setChecked(true);
                                            } else {
                                                c1568a.mo5807a(false);
                                                ((RadioButton) f4643P.mo5835f().get(i)).setChecked(false);
                                            }
                                        }
                                        if (C1753x.f5027a) {
                                            f4668aN.mo6138b(false);
                                        } else {
                                            f4667aM.mo6109b(false);
                                        }
                                        f4645R.setAlpha(0.5f);
                                        f4642O = 1;
                                        for (i = 0; i < f4639L.mo5833d().size(); i++) {
                                            c1568a = f4639L.mo5833d().get(i);
                                            if (c1568a.mo5812e() == f4642O) {
                                                f4641N.setImageDrawable(c1568a.mo5811d());
                                                c1568a.mo5807a(true);
                                                f4639L.mo5835f().get(i).setChecked(true);
                                            } else {
                                                c1568a.mo5807a(false);
                                               f4639L.mo5835f().get(i).setChecked(false);
                                            }
                                        }
                                        if (C1753x.f5027a) {
                                            f4668aN.mo6143c(false);
                                        } else {
                                            f4667aM.mo6113c(false);
                                        }
                                        f4641N.setAlpha(0.5f);
                                        f4648U = f4649V = false;
                                        f4647T.setAlpha(0.5f);
                                        if (C1753x.f5027a) {
                                            f4653Z = String.valueOf(0);
                                        } else {
                                            f4653Z = "none";
                                        }
                                        for (int i2 = 0; i2 < f4650W.mo5833d().size(); i2++) {
                                            c1568a = f4650W.mo5833d().get(i2);
                                            c1568a.mo5807a(c1568a.mo5805a().equals(f4653Z));
                                             f4650W.mo5835f().get(i2).setChecked(c1568a.mo5805a().equals(f4653Z));
                                        }
                                        if (C1753x.f5027a) {
                                            f4668aN.mo6134a(f4653Z);
                                        } else {
                                            f4667aM.mo6108b(f4653Z);
                                        }
                                        f4652Y.setAlpha(0.5f);

                                    } else {
                                        f4687ag = false;
                                        if (C1753x.f5027a) {
                                            f4668aN.mo6135a(false);
                                        } else {
                                            f4667aM.mo6104a(false);
                                        }
                                    }
                                    f4686af.setImageDrawable(context.getResources().getDrawable(f4687ag ? R.drawable.fav : R.drawable.fav));
                                }
                                if (f4685ae) {
                                    mo6084g();
                                    f4685ae = false;
                                }
                                if (f4649V) {
                                    f4649V = false;
                                    f4648U = true;
                                    f4647T.setImageDrawable(f4666aL.getResources().getDrawable(R.drawable.fav));
                                    if (!C1753x.f5027a) {
                                        f4667aM.mo6103a("torch");
                                        break;
                                    }
                                    f4668aN.mo6130a(2);
                                    break;
                                }
                            }
                            if (f4655aA) {
                                f4683ac.setVisibility(View.GONE);
                            }
                            f4686af.setVisibility(View.GONE);
                            if (f4687ag) {
                                f4687ag = false;
                                f4688ah = true;
                                if (C1753x.f5027a ? f4668aN.mo6153j() : f4667aM.mo6114c()) {
                                    if (C1753x.f5027a) {
                                        f4668aN.mo6135a(false);
                                    } else {
                                        f4667aM.mo6104a(false);
                                    }
                                    f4686af.setImageDrawable(context.getResources().getDrawable(f4687ag ? R.drawable.fav : R.drawable.fav));
                                }
                                f4645R.setAlpha(1.0f);
                                f4645R.setOnTouchListener(f4670aP);
                                f4641N.setAlpha(1.0f);
                                f4641N.setOnTouchListener(f4673aS);
                                f4652Y.setAlpha(1.0f);
                                f4652Y.setOnTouchListener(f4674aT);
                            }
                            if (f4684ad) {
                                mo6085h();
                                f4685ae = true;
                            }
                            if (f4648U) {
                                f4647T.setImageDrawable(f4666aL.getResources().getDrawable(R.drawable.fav));
                                if (C1753x.f5027a) {
                                    f4668aN.mo6130a(0);
                                } else {
                                    f4667aM.mo6103a("off");
                                }
                                f4648U = false;
                                f4649V = true;
                                break;
                            }
                        }
                        break;
                    case 2:
                        y = (int) motionEvent.getX();
                        i = (int) motionEvent.getY();
                        if (y < 0 || i < 0 || y >= view.getWidth() || i >= view.getHeight()) {
                            view.setBackgroundColor(0);
                            this.f4574a = false;
                            break;
                        }
                }
                return true;
            }
        });
        this.f4681aa = new ImageView(context);
        this.f4681aa.setId(this.f4744p);
        imageView = this.f4681aa;
        i2 = (this.f4705ay && this.f4706az) ? 0 : 8;
        imageView.setVisibility(i2);
        layoutParams = new LayoutParams(-2, -2);
        if (C1753x.m8334c()) {
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = 10;
            layoutParams.leftMargin = 10;
        } else {
            layoutParams.addRule(11);
            layoutParams.bottomMargin = 25;
            layoutParams.rightMargin = 10;
        }
        this.f4681aa.setImageDrawable(context.getResources().getDrawable(R.drawable.fav));
        this.f4681aa.setLayoutParams(layoutParams);
        this.f4681aa.setOnTouchListener(new OnTouchListener() {
            boolean f4577a;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.f4577a = true;
                        view.setBackgroundColor(context.getResources().getColor(R.color.color_wb_button_touched));
                        break;
                    case 1:
                        if (this.f4577a) {
                            view.setBackgroundColor(0);
                            if (f4658aD != null) {
                                f4658aD.mo5930a();
                                break;
                            }
                        }
                        break;
                    case 2:
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();
                        if (x < 0 || y < 0 || x >= view.getWidth() || y >= view.getHeight()) {
                            view.setBackgroundColor(0);
                            this.f4577a = false;
                            break;
                        }
                }
                return true;
            }
        });
        this.f4686af = new ImageView(context);
        this.f4686af.setId(this.f4749u);
        this.f4686af.setVisibility(View.GONE);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        if (!C1753x.m8334c()) {
            layoutParams4.weight = 1.0f;
        }
        this.f4686af.setImageDrawable(context.getResources().getDrawable(this.f4687ag ? R.drawable.fav : R.drawable.fav));
        this.f4686af.setLayoutParams(layoutParams4);
        this.f4686af.setOnTouchListener(this.f4675aU);
        this.f4683ac = new ImageView(context);
        this.f4683ac.setId(this.f4748t);
        imageView = this.f4683ac;
        i2 = (this.f4705ay && this.f4655aA) ? 0 : 8;
        imageView.setVisibility(i2);
        layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        if (!C1753x.m8334c()) {
            layoutParams4.weight = 1.0f;
        }
        if (this.f4684ad && mo6082e()) {
            mo6084g();
        }
        this.f4683ac.setImageDrawable(context.getResources().getDrawable(this.f4684ad ? R.drawable.fav : R.drawable.fav));
        this.f4683ac.setLayoutParams(layoutParams4);
        this.f4683ac.setOnTouchListener(this.f4671aQ);
        this.f4647T = new ImageView(context);
        this.f4647T.setId(this.f4745q);
        layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        if (C1753x.m8334c()) {
            layoutParams4.bottomMargin = 10;
        } else {
            layoutParams4.weight = 1.0f;
        }
        this.f4647T.setImageDrawable(context.getResources().getDrawable(this.f4648U ? R.drawable.fav : R.drawable.fav));
        this.f4647T.setLayoutParams(layoutParams4);
        if (this.f4687ag) {
            this.f4647T.setAlpha(0.5f);
        } else {
            this.f4647T.setOnTouchListener(this.f4672aR);
            this.f4647T.setAlpha(1.0f);
        }

        this.f4629B.addView(this.f4681aa);
        this.f4629B.addView(this.f4682ab);
        C1753x.f5018J = "NamyaPanorama";
        this.f4690aj = new Handler();
        if (C1753x.f5017I == null) {
            C1753x.f5017I = new LinkedList();
        }
        this.f4635H = new ProgressBar(context, null, 16842874);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f4635H.setLayoutParams(layoutParams);
        this.f4700at = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        this.f4701au = new LocationListener() {
            public void onLocationChanged(Location location) {
                C1753x.f5039m = location.getLongitude();
                C1753x.f5040n = location.getLatitude();
                C1753x.f5041o = location.getAltitude();
                C1753x.f5044r = location.getTime();
                C1753x.f5045s = true;
                C1690e c1690e = new C1690e(context);
                c1690e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, C1753x.f5040n, C1753x.f5039m);
            }

            public void onProviderDisabled(String str) {
            }

            public void onProviderEnabled(String str) {
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
            }
        };


        this.f4702av = new LocationListener() {
            public void onLocationChanged(Location location) {
                int i = 0;
                if (!C1753x.f5045s) {
                    i = 1;
                } else if (C1753x.f5044r == 0 || location.getTime() - C1753x.f5044r > 120000) {
                    i = 1;
                }
                if (i != 0) {
                    C1753x.f5039m = location.getLongitude();
                    C1753x.f5040n = location.getLatitude();
                    C1753x.f5041o = location.getAltitude();
                    C1753x.f5044r = location.getTime();
                    C1753x.f5045s = false;
                    C1690e c1690e = new C1690e(context);
                    c1690e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, C1753x.f5040n, C1753x.f5039m);
                }
            }

            public void onProviderDisabled(String str) {
            }

            public void onProviderEnabled(String str) {
            }

            public void onStatusChanged(String str, int i, Bundle bundle) {
            }
        };
        if (C1753x.m8336e() > 1) {
            C1753x.f5013E = true;
        }
        return this.f4629B;
    }

    public void mo6070a() {
        this.f4633F.mo5863f();
    }

    public void mo6071a(double d) {
        if (this.f4689ai != null) {
            this.f4689ai.mo5841a(d);
        }
    }

    public void mo6072a(int i, int i2) {
        this.f4691ak = i;
        this.f4692al = i2;
        if (C1753x.f5027a && !this.f4668aN.mo6144c()) {
            return;
        }
        if (C1753x.f5027a || this.f4667aM.mo6122j()) {
            if (C1753x.f5027a) {
                this.f4694an = this.f4668aN.mo6145d().getWidth();
                this.f4695ao = this.f4668aN.mo6145d().getHeight();
                this.f4698ar = 256;
                this.f4699as = 256;
            } else {
                this.f4694an = this.f4667aM.mo6125m().getParameters().getPreviewSize().width;
                this.f4695ao = this.f4667aM.mo6125m().getParameters().getPreviewSize().height;
                this.f4696ap = this.f4667aM.mo6125m().getParameters().getPictureSize().width;
                this.f4697aq = this.f4667aM.mo6125m().getParameters().getPictureSize().height;
                this.f4698ar = this.f4667aM.mo6125m().getParameters().getPreviewFormat();
                this.f4699as = this.f4667aM.mo6125m().getParameters().getPictureFormat();
                C1753x.f5032f = this.f4667aM.mo6125m().getParameters().getPictureSize().width;
                C1753x.f5033g = this.f4667aM.mo6125m().getParameters().getPictureSize().height;
            }
            double d = C1753x.m8334c() ? ((double) this.f4695ao) / ((double) this.f4694an) : ((double) this.f4694an) / ((double) this.f4695ao);
            double d2 = ((double) i2) / ((double) i);
            if (d < d2) {
                i2 = (int) (d * ((double) i));
            } else if (d > d2) {
                i = (int) ((1.0d / d) * ((double) i2));
            }
            LayoutParams layoutParams = new LayoutParams(i, i2);
            layoutParams.addRule(14);
            layoutParams.addRule(15);
            this.f4629B.setLayoutParams(layoutParams);
            int round = (int) Math.round(((double) i) * 0.0625d);
            LayoutParams layoutParams2 = new LayoutParams(i - (round * 2), (int) Math.round((C1753x.m8334c() ? 0.13392857142857142d : 0.26785714285714285d) * ((double) (i - (round * 2)))));
            layoutParams2.topMargin = (int) (((double) i2) * 0.041666666666666664d);
            layoutParams2.addRule(10);
            layoutParams2.addRule(14);
            this.f4634G.setLayoutParams(layoutParams2);
        }
    }

    public void mo6074a(Context context, int i, int i2) {
        this.f4666aL = context;
        this.f4729bv = false;
        this.f4691ak = i;
        this.f4692al = i2;
        try {
            this.f4700at.requestLocationUpdates("gps", 3000, 0.0f, this.f4701au);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f4700at.requestLocationUpdates("network", 3000, 0.0f, this.f4702av);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Location location = null;
        try {
            location = this.f4700at.getLastKnownLocation("gps");
        } catch (Exception e3) {
        e3.printStackTrace();
        }
        if (location != null) {
            this.f4701au.onLocationChanged(location);
        }
        if ((C1753x.f5027a && !this.f4668aN.mo6144c()) || !(C1753x.f5027a || this.f4667aM.mo6122j())) {
            if (!C1753x.f5027a) {
                this.f4690aj.postDelayed(this.f4676aV, 0);
            }
            this.f4733d = false;
            if (!this.f4737h) {
                this.f4734e = true;
            }
            this.f4633F.mo5864g();
            this.f4660aF = true;
            this.f4689ai.mo5844b();
            this.f4634G.setRenderMode(1);
            this.f4634G.onResume();
        }
        if (C1753x.f5027a) {
            this.f4668aN.mo6129a();
        }
    }

    public void mo6075a(boolean z) {
        this.f4632E = z;
    }

    public boolean mo6076a(String str) {
        if (!this.f4628A) {
            return false;
        }
        this.f4739j = str;
        Log.e("rmh", "mppath1: " + this.f4739j);
        C1753x.f5052z = 360;
        m7963u();
        return true;
    }

    public void mo6077b() {
        this.f4740k = true;
    }

    public void mo6078b(boolean z) {
        if (this.f4689ai != null) {
            this.f4689ai.mo5842a(z);
        }
    }

    public void mo6079c() {
        this.f4729bv = true;
        if (C1753x.f5027a) {
            this.f4690aj.removeCallbacks(this.f4678aX);
        } else {
            this.f4690aj.removeCallbacks(this.f4676aV);
        }
        m7953p();
        this.f4700at.removeUpdates(this.f4701au);
        this.f4700at.removeUpdates(this.f4702av);
        this.f4689ai.mo5845c();
        this.f4634G.onPause();
        if (this.f4751w) {
            m7889a(3);
        } else if (this.f4736g && !C1753x.f5013E) {
            this.f4736g = false;
            m7889a(3);
            if (this.f4635H.getParent() != null) {
                this.f4629B.removeView(this.f4635H);
            }
        }
        if ((C1753x.f5027a && this.f4668aN.mo6144c()) || (!C1753x.f5027a && this.f4667aM.mo6122j())) {
            if (C1753x.f5027a) {
                this.f4668aN.mo6156m();
                this.f4668aN.mo6157n();
                this.f4668aN.mo6137b(null);
                this.f4668aN.mo6158o();
                this.f4668aN.mo6131a(null);
            } else {
                this.f4667aM.mo6115d();
                this.f4667aM.mo6123k();
                this.f4667aM.mo6101a(null);
                this.f4667aM.mo6124l();
                this.f4667aM.mo6107b(null);
            }
        }
        if (this.f4658aD != null) {
            this.f4658aD.mo5944i();
        }
        this.f4666aL = null;
    }

    public void mo6080c(boolean z) {
        this.f4679aY = z;
    }

    public boolean mo6082e() {
        return C1753x.m8336e() >= 2;
    }

    public boolean mo6083f() {
        return C1753x.f5010B;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void mo6084g() {
        if (mo6082e()) {
            C1753x.f5010B = true;
            C1753x.f5011C = false;
            if (this.f4633F != null) {
                this.f4633F.mo5859b();
            }
            this.f4684ad = true;
            if (this.f4683ac != null && this.f4655aA) {
                this.f4683ac.setImageDrawable(this.f4666aL.getResources().getDrawable(this.f4684ad ? R.drawable.fav : R.drawable.fav));
            }
            if ((C1753x.f5027a && this.f4668aN == null) || (!C1753x.f5027a && this.f4667aM == null)) {
                this.f4741l = true;
            }
            if (((C1753x.f5027a && this.f4668aN != null && this.f4668aN.mo6144c() && this.f4668aN.mo6139b()) || (!C1753x.f5027a && this.f4667aM != null && this.f4667aM.mo6122j() && this.f4667aM.mo6110b())) && !C1753x.f5027a) {
                this.f4667aM.mo6117e();
                this.f4696ap = this.f4667aM.mo6125m().getParameters().getPictureSize().width;
                this.f4697aq = this.f4667aM.mo6125m().getParameters().getPictureSize().height;
            }
        }
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    public void mo6085h() {
        if (mo6082e()) {
            C1753x.f5010B = false;
            C1753x.f5011C = true;
        } else {
            C1753x.f5010B = false;
            C1753x.f5011C = false;
        }
        if (this.f4633F != null) {
            this.f4633F.mo5859b();
        }
        this.f4684ad = false;
        if (this.f4683ac != null && this.f4655aA) {
            this.f4683ac.setImageDrawable(this.f4666aL.getResources().getDrawable(this.f4684ad ? R.drawable.fav : R.drawable.fav));
        }
        if ((C1753x.f5027a && this.f4668aN == null) || (!C1753x.f5027a && this.f4667aM == null)) {
            this.f4741l = true;
        }
        if (((C1753x.f5027a && this.f4668aN != null && this.f4668aN.mo6144c() && this.f4668aN.mo6139b()) || (!C1753x.f5027a && this.f4667aM != null && this.f4667aM.mo6122j() && this.f4667aM.mo6110b())) && !C1753x.f5027a) {
            this.f4667aM.mo6117e();
            this.f4696ap = this.f4667aM.mo6125m().getParameters().getPictureSize().width;
            this.f4697aq = this.f4667aM.mo6125m().getParameters().getPictureSize().height;
        }
    }

    public boolean mo6086i() {
        return C1753x.m8334c();
    }

    public void mo6087j() {
        m7889a(0);
    }

    public boolean mo6088k() {
        return m7965v();
    }

    public void mo6089l() {
        this.f4662aH = true;
    }

    public void mo6090m() {
        this.f4662aH = false;
    }
}
