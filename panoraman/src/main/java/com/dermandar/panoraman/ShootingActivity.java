package com.dermandar.panoraman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
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
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.dermandar.p047a.C1616e;
import com.dermandar.p047a.C1693n;

import com.dermandar.panoraman.R;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;


public class ShootingActivity extends AppCompatActivity {
    private int f5877A;
    private C2097h f5879C;
    private Bitmap f5880D;
    private AlphaAnimation f5881E;
    private AnimationSet f5882F;
    private View f5883G;
    private View f5884H;
    private TextView f5885I;
    private SimpleDateFormat f5886J;
    private String f5887K;
    private String f5888L;
    private boolean f5889M;
    private boolean f5890N;
    private boolean f5891O;
    private boolean f5892P;
    private boolean f5893Q;
    private boolean f5894R;
    private boolean f5895S;
    private boolean f5896T;
    private boolean f5897U;
    private float f5898V;
    private int f5899W;
    private String f5900X = "";
    private OnTouchListener f5901Y = new C19936();
    private C1616e f5902Z = new C19882();
    private Handler f5908s;
    private RelativeLayout f5909t;
    private ViewGroup f5910u;
    private C1693n f5911v;
    private Display f5912w;
    private DisplayMetrics f5913x;
    private int f5914y;
    private int f5915z;

    class C19861 implements AnimationListener {

        class C19851 implements Runnable {
            public void run() {
                if (ShootingActivity.this.f5883G.getParent() != null) {
                    ShootingActivity.this.f5910u.removeView(ShootingActivity.this.f5883G);
                    ShootingActivity.this.f5910u.invalidate();
                }
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (ShootingActivity.this.f5883G.getParent() != null) {
                ShootingActivity.this.f5908s.post(new C19851());
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class C19882 implements C1616e {

        class C19871 implements AnimationListener {
            public void onAnimationEnd(Animation animation) {
                if (ShootingActivity.this.f5884H.getParent() != null) {
                    ShootingActivity.this.f5910u.removeView(ShootingActivity.this.f5884H);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        }

        public void mo5930a() {
        }

        public void mo5931a(float f) {
        }

        public void mo5932a(int i) {
            ShootingActivity.this.f5891O = i == 1;
            if (!ShootingActivity.this.f5889M) {
                if (i == 1) {
                    ShootingActivity.this.f5910u.setOnTouchListener(ShootingActivity.this.f5901Y);
                    ShootingActivity.this.m9008d("برای شروع ضربه بزنید");
                    return;
                }
                ShootingActivity.this.f5910u.setOnTouchListener(null);
                ShootingActivity.this.m9008d("لطفا دستگاه خود را به حالت عمودی نگه دارید");
            }
        }

        public void mo5933a(Bitmap bitmap) {
            ShootingActivity.this.f5880D = bitmap;
        }

        public void mo5934a(HashMap<String, Object> hashMap) {
            ShootingActivity.this.f5892P = false;
            Log.e("rmh", "fovv:" + hashMap.get("fovx"));
            ShootingActivity.this.setResult(-1);
            //ShootingActivity.this.finish();
            mo1942r();
        }

        public void mo5935a(boolean z) {
            new HashMap().put("nb", ShootingActivity.this.f5899W + "");
            ShootingActivity.this.getWindow().clearFlags(128);
            if (z) {
                ShootingActivity.this.f5885I.setVisibility(View.INVISIBLE);
                ShootingActivity.this.f5892P = true;
                ShootingActivity.this.f5910u.setOnTouchListener(null);
            }
            ShootingActivity.this.m9008d( "لطفا دستگاه خود را به حالت عمودی نگه دارید");
            ShootingActivity.this.f5889M = false;
        }

        public void mo5936b() {
        }

        public void mo5937b(HashMap<String, Object> hashMap) {

        }

        public void mo5938c() {
            ShootingActivity.this.f5890N = true;
        }

        public void mo5939d() {
            ShootingActivity.this.f5890N = false;
        }

        public void mo5940e() {
            ShootingActivity.this.f5890N = true;
            if (C2096g.m9333b() <= 2) {
                if (ShootingActivity.this.f5879C.getParent() != null) {
                    ShootingActivity.this.f5910u.removeView(ShootingActivity.this.f5879C);
                }
                if (ShootingActivity.this.f5879C.getParent() != null) {
                    ShootingActivity.this.f5910u.removeView(ShootingActivity.this.f5879C);
                }
                if (ShootingActivity.this.f5883G.getParent() != null) {
                    ShootingActivity.this.f5910u.removeView(ShootingActivity.this.f5883G);
                }
                ShootingActivity.this.f5879C.setImageBitmap(ShootingActivity.this.f5880D);
                ShootingActivity.this.f5910u.addView(ShootingActivity.this.f5879C);
                ShootingActivity.this.f5910u.addView(ShootingActivity.this.f5883G);
                ShootingActivity.this.f5883G.startAnimation(ShootingActivity.this.f5881E);
                return;
            }
            if (ShootingActivity.this.f5884H.getParent() != null) {
                ShootingActivity.this.f5910u.removeView(ShootingActivity.this.f5884H);
            }
            ShootingActivity.this.f5910u.addView(ShootingActivity.this.f5884H);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
            alphaAnimation.setDuration(600);
            alphaAnimation.setStartOffset(0);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new C19871());
            ShootingActivity.this.f5884H.startAnimation(alphaAnimation);
        }

        public void mo5941f() {
            ShootingActivity.this.f5890N = false;
            ShootingActivity.this.f5899W = ShootingActivity.this.f5899W + 1;
            if (ShootingActivity.this.f5899W <= 0) {
                ShootingActivity.this.m9008d( "برای شروع ضربه بزنید");
            } else if (ShootingActivity.this.f5899W == 1) {
                ShootingActivity.this.m9008d("به راست یا چپ بچرخید");
            } else {
                ShootingActivity.this.m9008d("به چرخش ادامه دهید یا برای متوقف سازی ضربه بزنید");
            }
            if (C2096g.m9333b() <= 2) {
                ShootingActivity.this.f5879C.startAnimation(ShootingActivity.this.f5882F);
            }
            ShootingActivity.this.f5910u.setOnTouchListener(ShootingActivity.this.f5901Y);
        }

        public void mo5942g() {
        }

        public void mo5943h() {
        }

        public void mo5944i() {
        }
    }


    class C19903 implements AnimationListener {

        class C19891 implements Runnable {

            public void run() {
                if (ShootingActivity.this.f5879C.getParent() != null) {
                    ShootingActivity.this.f5910u.removeView(ShootingActivity.this.f5879C);
                }
            }
        }

        public void onAnimationEnd(Animation animation) {
            ShootingActivity.this.f5908s.post(new C19891());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class C19936 implements OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float x = motionEvent.getX();
            float width = 0.1f * ((float) view.getWidth());
            float width2 = ((float) view.getWidth()) - width;
            switch (motionEvent.getAction()) {
                case 0:
                    return x >= width && x <= width2;
                case 1:
                    if (x < width || x > width2) {
                        return false;
                    }
                    if (ShootingActivity.this.f5890N) {
                        return true;
                    }
                    if (ShootingActivity.this.f5889M) {
                        ShootingActivity.this.getWindow().clearFlags(128);
                        if (ShootingActivity.this.f5911v.mo6088k()) {
                            C2096g.f6252H = ShootingActivity.this.f5911v.mo6083f();
                            ShootingActivity.this.f5892P = true;
                            ShootingActivity.this.f5885I.setVisibility(View.INVISIBLE);
                        }
                        ShootingActivity.this.f5889M = false;
                        ShootingActivity.this.m9008d( "برای شروع ضربه بزنید");
                        return true;
                    }
                    ShootingActivity.this.f5899W = 0;
                    ShootingActivity.this.f5887K = ShootingActivity.this.f5886J.format(new Date());
                    if (ShootingActivity.this.f5894R && ShootingActivity.this.m9023m()) {
                        ShootingActivity.this.f5888L = "/storage/extSdCard/Android/data/" + ShootingActivity.this.getPackageName() + "/Panoramas/" + ShootingActivity.this.f5887K + "/";
                    } else {
                        ShootingActivity.this.f5888L = Environment.getExternalStorageDirectory().getPath() + "/" + ".DMD_Pano" + "/" + ShootingActivity.this.f5887K + "/";
                    }
                    if (!ShootingActivity.this.f5911v.mo6076a(ShootingActivity.this.f5888L)) {
                        return true;
                    }
                    new HashMap().put("bubblepod", ShootingActivity.this.f5896T + "");
                    ShootingActivity.this.m9008d( "فوکوس");
                    ShootingActivity.this.f5889M = true;
                    ShootingActivity.this.getWindow().setFlags(128, 128);
                    ShootingActivity.this.f5910u.setOnTouchListener(null);
                    return true;
                case 2:
                    return x >= width && x <= width2;
                default:
                    return false;
            }
        }
    }

    private void m9008d(String i) {
        if (!this.f5900X.equals(i)) {
            LayoutParams layoutParams = new LayoutParams(this.f5913x.widthPixels, -2);
            layoutParams.addRule(14);
            if (i.equals("") || i.equals("لطفا دستگاه خود را به حالت عمودی نگه دارید") || i.equals("برای شروع ضربه بزنید") || i.equals("فوکوس")) {
                layoutParams.addRule(15);
            } else {
                layoutParams.addRule(12);
            }
            this.f5885I.setLayoutParams(layoutParams);
            this.f5885I.setText(i);
            this.f5900X = i;
        }
    }

    private void m9018k() {
        Log.e("rmh", "oncreatesub");
        this.f5912w = getWindowManager().getDefaultDisplay();
        this.f5913x = new DisplayMetrics();
        this.f5912w.getMetrics(this.f5913x);
        this.f5914y = getWindowManager().getDefaultDisplay().getRotation();
        getWindow().setFlags(1024, 1024);
        if (this.f5914y == 0 || this.f5914y == 2) {
            this.f5915z = this.f5913x.widthPixels;
            this.f5877A = this.f5913x.heightPixels;
        } else {
            this.f5915z = this.f5913x.heightPixels;
            this.f5877A = this.f5913x.widthPixels;
        }

        this.f5908s = new Handler();
        this.f5886J = new SimpleDateFormat("yyMMdd_HHmmss");
        m9020l();
        this.f5909t = new RelativeLayout(this);
        this.f5909t.setLayoutParams(new LayoutParams(-1, -1));
        this.f5909t.setBackgroundColor(-16777216);
        this.f5911v = new C1693n();
        Log.e("rmh", "bef initshooter: " + this);
        this.f5910u = this.f5911v.mo6069a(this, this.f5902Z, this.f5912w.getRotation(), true, true, false, this.f5897U, this.f5911v.mo6082e());
        C2096g.f6252H = this.f5911v.mo6083f();
        C2096g.f6272j = this.f5911v.mo6086i();
        this.f5909t.addView(this.f5910u);
        this.f5910u.setOnTouchListener(this.f5901Y);
        this.f5885I = new TextView(this);

        this.f5885I.setTypeface(ResourcesCompat.getFont(ShootingActivity.this, R.font.iransans_bold));
        this.f5885I.setPadding(32,32,32,32);

        this.f5885I.setTextSize(24.0f);
        this.f5885I.setGravity(17);
        this.f5885I.setTextColor(-1);
        m9008d( "برای شروع ضربه بزنید");
        this.f5909t.addView(this.f5885I);
        if (C2096g.m9333b() <= 2) {
            this.f5911v.mo6075a(true);
            this.f5883G = new View(this);
            this.f5883G.setLayoutParams(new LayoutParams(-1, -1));
            this.f5883G.setBackgroundColor(-1);
            this.f5879C = new C2097h(this);
            this.f5879C.setLayoutParams(new LayoutParams(-1, -1));
            this.f5879C.setScaleType(ScaleType.FIT_XY);
            this.f5880D = null;
            this.f5882F = new AnimationSet(true);
            this.f5882F.setInterpolator(new AccelerateInterpolator());
            this.f5881E = new AlphaAnimation(0.65f, 0.0f);
            this.f5881E.setDuration(400);
            this.f5881E.setStartOffset(0);
            this.f5881E.setRepeatCount(0);
            this.f5881E.setFillAfter(true);
            this.f5881E.setAnimationListener(new C19861());
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 1.0f);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            translateAnimation.setDuration(550);
            translateAnimation.setStartOffset(0);
            translateAnimation.setFillAfter(true);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setAnimationListener(new C19903());
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.01f, 1.0f, 0.01f, 1, 1.0f, 1, 1.0f);
            scaleAnimation.setInterpolator(new AccelerateInterpolator());
            scaleAnimation.setDuration(550);
            scaleAnimation.setStartOffset(0);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setRepeatCount(0);
            this.f5882F.addAnimation(translateAnimation);
            this.f5882F.addAnimation(scaleAnimation);
        } else {
            this.f5884H = new View(this);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            this.f5884H.setBackgroundColor(-1);
            this.f5884H.setAlpha(0.9f);
            this.f5884H.setLayoutParams(layoutParams);
        }
        setContentView(this.f5909t);
    }

    private void m9020l() {
        SharedPreferences sharedPreferences = getSharedPreferences("DMDPref", 0);
        this.f5893Q = sharedPreferences.getBoolean("CopyOriginalImages", false);
        this.f5894R = sharedPreferences.getBoolean("UseExternalSdCard", false);
        this.f5898V = sharedPreferences.getFloat("GyroCalibration", 0.0f);
        this.f5895S = sharedPreferences.getBoolean("GyroUseUncalibrated", false);
        this.f5896T = sharedPreferences.getBoolean("ContinuousShooting", false);
        this.f5897U = sharedPreferences.getBoolean("EnableFrontCam", false);
    }

    private boolean m9023m() {
        return new File("/storage/extSdCard/").exists();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f5892P) {
            if (this.f5889M) {
                getWindow().clearFlags(128);
                this.f5911v.mo6087j();
                this.f5889M = false;
                m9008d("برای شروع ضربه بزنید");
                return;
            }
            this.f5911v.mo6077b();
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        Log.e("rmh", "oncreate");
        getWindow().requestFeature(12);
        super.onCreate(bundle);

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                paramThrowable.printStackTrace();
            }
        });

        m9018k();
    }


    public void onPause() {
        super.onPause();
        Log.e("rmh", "shooting onpause");
        if (VERSION.SDK_INT < 23 || (ContextCompat.checkSelfPermission( this, "android.permission.CAMERA") == 0 &&
                ContextCompat.checkSelfPermission( this, "android.permission.READ_EXTERNAL_STORAGE") == 0 &&
                ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
            if (this.f5889M) {
                getWindow().clearFlags(128);
                this.f5911v.mo6087j();
                this.f5889M = false;
                m9008d( "برای شروع ضربه بزنید");
            }
            this.f5911v.mo6079c();
        }
    }

    public void onResume() {
        Log.e("rmh", "shootingactivity onresume");
        super.onResume();
        if (VERSION.SDK_INT < 23 || (ContextCompat.checkSelfPermission( this, "android.permission.CAMERA") == 0 &&
                ContextCompat.checkSelfPermission((Context) this, "android.permission.READ_EXTERNAL_STORAGE") == 0 &&
                ContextCompat.checkSelfPermission((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
            this.f5911v.mo6078b(this.f5895S);
            this.f5909t.requestLayout();
            this.f5911v.mo6074a(this, this.f5915z, this.f5877A);
            this.f5885I.setVisibility(View.VISIBLE);
            this.f5900X = "";
            if (this.f5891O) {
                m9008d( "برای شروع ضربه بزنید");
            } else {
                m9008d( "لطفا دستگاه خود را به حالت عمودی نگه دارید");
            }
            if (this.f5893Q) {
                this.f5911v.mo6089l();
            } else {
                this.f5911v.mo6090m();
            }
            if (this.f5898V != 0.0f) {
                this.f5911v.mo6071a(this.f5898V);
            }
            this.f5911v.mo6080c(this.f5896T);
        }
    }


    public void mo1942r() {
        String str = Environment.getExternalStorageDirectory() + "/" + ".DMD_Pano" + "/";
        File[] listFiles = new File(str).listFiles(new C21127());
        if (listFiles != null) {
            ArrayList<C2152o> arrayList = new ArrayList<>();
            for (File listFile : listFiles) {
                arrayList.add(new C2152o(listFile.getName(), listFile.getPath()));
                Log.e(listFile.getName(), listFile.getPath());
            }
            Collections.sort(arrayList);

            Intent intent = new Intent(ShootingActivity.this, ExportActivity.class);
            intent.putExtra("extra_path", arrayList.get(0).mo7059h());
            intent.putExtra("extra_name", arrayList.get(0).mo7058g());
            startActivity(intent);
            finish();
        }
    }

    static class C21127 implements FileFilter {
        public boolean accept(File file) {
            return file.isDirectory() && !file.getName().startsWith(".");
        }
    }

}
