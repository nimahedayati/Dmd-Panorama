package com.dermandar.p047a;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/* renamed from: com.dermandar.a.f */
class C1617f extends SurfaceView implements Callback {
    /* renamed from: a */
    private String f4499a = "DMD_Library";
    /* renamed from: b */
    private SurfaceHolder f4500b;
    /* renamed from: c */
    private Camera f4501c;
    /* renamed from: d */
    private boolean f4502d = false;

    public C1617f(Context context, Camera camera) {
        super(context);
        this.f4501c = camera;
        this.f4500b = getHolder();
        this.f4500b.addCallback(this);
        this.f4500b.setType(3);
    }

    /* renamed from: a */
    public void mo5945a() {
        if (this.f4501c != null && !this.f4502d) {
            try {
                this.f4501c.startPreview();
                this.f4502d = true;
            } catch (Exception e) {
                e.printStackTrace();
                C1570ab.m7585b(this.f4499a, "Start preview:" + e.getMessage());
            }
        }
    }

    /* renamed from: a */
    public void mo5946a(Camera camera) {
        this.f4501c = camera;
    }

    /* renamed from: b */
    public void mo5947b() {
        if (this.f4501c != null && this.f4502d) {
            try {
                this.f4501c.stopPreview();
            } catch (Exception e) {
                e.printStackTrace();
                C1570ab.m7585b(this.f4499a, "Stop preview:" + e.getMessage());
            } finally {
                this.f4502d = false;
            }
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.f4500b.getSurface() != null && this.f4501c != null) {
            try {
                mo5947b();
                this.f4501c.setPreviewDisplay(this.f4500b);
                mo5945a();
            } catch (Exception e) {
                e.printStackTrace();
                C1570ab.m7585b(this.f4499a, "Error starting camera preview: " + e.getMessage());
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
