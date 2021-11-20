package com.dermandar.p047a;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.dermandar.a.o */
class C1694o {
    /* renamed from: a */
    public C1617f f4755a;
    /* renamed from: b */
    public Camera f4756b;
    /* renamed from: c */
    private String f4757c = null;
    /* renamed from: d */
    private String f4758d = null;

    C1694o() {
    }

    /* renamed from: a */
    public Size mo6091a(List<Size> list) {
        int i = 0;
        if (list == null || list.size() == 0) {
            return null;
        }
        Size size = (Size) list.get(0);
        size.height = 480;
        size.width = 640;
        Size size2 = size;
        while (i < list.size()) {
            size = (Size) list.get(i);
            if (C1753x.m8332a((((double) size.width) * 1.0d) / ((double) size.height), 1.7777777777777777d) && (size.width > size2.width || size.height > size2.height)) {
                size2 = size;
            }
            i++;
        }
        return size2;
    }

    /* renamed from: a */
    public Size mo6092a(List<Size> list, double d) {
        double d2 = Double.MAX_VALUE;
        Size size = null;
        for (Size size2 : list) {
            Size size22 = size2;
            double abs = Math.abs(d - (C1753x.m8334c() ? ((double) size22.height) / ((double) size22.width) : ((double) size22.width) / ((double) size22.height)));
            if (d2 <= abs) {
                if (d2 == abs) {
                    float f = (float) (C1753x.f5035i * C1753x.f5034h);
                    float f2 = (float) (size22.width * size22.height);
                    float f3 = (float) (size.width * size.height);
                    if (f2 > f && f2 - f < Math.abs(f3 - f)) {
                        abs = d2;
                    } else if (Math.abs(f2 - f) < Math.abs(f3 - f)) {
                        abs = d2;
                    }
                }
                size22 = size;
                abs = d2;
            }
            size = size22;
            d2 = abs;
        }
        return size;
    }

    /* renamed from: a */
    public Size mo6093a(List<Size> list, int i, int i2) {
        if (C1753x.m8334c()) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        Size size = null;
        double d = Double.MAX_VALUE;
        double d2 = ((double) i2) / ((double) i);
        for (Size size2 : list) {
            Size size3;
            double d3;
            if (size2.width == i2 || size2.height == i) {
                double abs = Math.abs(d2 - (C1753x.m8334c() ? ((double) size2.height) / ((double) size2.width) : ((double) size2.width) / ((double) size2.height)));
                if (d > abs) {
                    size3 = size2;
                    d3 = abs;
                    size = size3;
                    d = d3;
                }
            }
            double d4 = d;
            size3 = size;
            d3 = d4;
            size = size3;
            d = d3;
        }
        return size;
    }

    /* renamed from: a */
    public Size mo6094a(List<Size> list, int i, boolean z, double d) {
        Size size = null;
        if (!(list == null || list.size() == 0 || i <= 0)) {
            int i2 = 0;
            while (i2 < list.size()) {
                Size size2 = (Size) list.get(i2);
                if ((z ? size2.width : size2.height) < i || (!(d == -1.0d || d == (((double) size2.width) * 1.0d) / (((double) size2.height) * 1.0d)) || (size != null && size2.width >= size.width && size2.height >= size.height))) {
                    size2 = size;
                }
                i2++;
                size = size2;
            }
        }
        return size;
    }

    /* renamed from: a */
    public C1617f mo6095a() {
        return this.f4755a;
    }

    /* renamed from: a */
    public void mo6096a(int i) {
        this.f4755a.setBackgroundColor(i);
    }

    /* renamed from: a */
    public void mo6097a(Context context, LayoutParams layoutParams) {
        this.f4755a = new C1617f(context, this.f4756b);
        this.f4755a.setZOrderMediaOverlay(true);
        this.f4755a.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public void mo6098a(AutoFocusCallback autoFocusCallback) {
        this.f4756b.autoFocus(autoFocusCallback);
    }

    /* renamed from: a */
    public void mo6099a(PreviewCallback previewCallback) {
        this.f4756b.setOneShotPreviewCallback(previewCallback);
    }

    /* renamed from: a */
    public void mo6100a(ShutterCallback shutterCallback, PictureCallback pictureCallback, PictureCallback pictureCallback2) {
        this.f4756b.takePicture(shutterCallback, pictureCallback, pictureCallback2);
    }

    /* renamed from: a */
    public void mo6101a(Camera camera) {
        this.f4755a.mo5946a(camera);
    }

    /* renamed from: a */
    public void mo6102a(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f4755a.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    /* renamed from: a */
    public void mo6103a(String str) {
        if (this.f4756b != null) {
            Parameters parameters = this.f4756b.getParameters();
            parameters.setFlashMode(str);
            try {
                this.f4756b.setParameters(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void mo6104a(boolean z) {
        if (mo6114c()) {
            Parameters parameters = this.f4756b.getParameters();
            parameters.setSceneMode(z ? "hdr" : "auto");
            this.f4756b.setParameters(parameters);
        }
    }

    /* renamed from: b */
    public Size mo6105b(List<Size> list, int i, boolean z, double d) {
        Size size = null;
        if (!(list == null || list.size() == 0 || i <= 0)) {
            int i2 = 0;
            while (i2 < list.size()) {
                Size size2 = (Size) list.get(i2);
                if ((z ? size2.width : size2.height) > i || (!(d == -1.0d || d == (((double) size2.width) * 1.0d) / (((double) size2.height) * 1.0d)) || (size != null && size2.width < size.width && size2.height < size.height))) {
                    size2 = size;
                }
                i2++;
                size = size2;
            }
        }
        return size;
    }

    /* renamed from: b */
    public void mo6106b(int i) {
        this.f4756b = Camera.open(i);
    }

    /* renamed from: b */
    public void mo6107b(Camera camera) {
        this.f4756b = camera;
    }

    /* renamed from: b */
    public void mo6108b(String str) {
        if (this.f4756b != null) {
            Parameters parameters = this.f4756b.getParameters();
            parameters.setColorEffect(str);
            this.f4758d = str;
            try {
                this.f4756b.setParameters(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void mo6109b(boolean z) {
        if (mo6118f()) {
            Parameters parameters = this.f4756b.getParameters();
            parameters.setAutoExposureLock(z);
            this.f4756b.setParameters(parameters);
        }
    }

    /* renamed from: b */
    public boolean mo6110b() {
        return this.f4755a != null;
    }

    /* renamed from: c */
    public void mo6111c(int i) {
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        this.f4756b.setDisplayOrientation(cameraInfo.facing == 1 ? (360 - (cameraInfo.orientation % 360)) % 360 : (cameraInfo.orientation + 360) % 360);
    }

    /* renamed from: c */
    public void mo6112c(String str) {
        if (this.f4756b != null) {
            Parameters parameters = this.f4756b.getParameters();
            parameters.setWhiteBalance(str);
            this.f4757c = str;
            try {
                this.f4756b.setParameters(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    public void mo6113c(boolean z) {
        if (mo6119g()) {
            Parameters parameters = this.f4756b.getParameters();
            parameters.setAutoWhiteBalanceLock(z);
            this.f4756b.setParameters(parameters);
        }
    }

    /* renamed from: c */
    public boolean mo6114c() {
        return (VERSION.SDK_INT < 17 || this.f4756b.getParameters().getSupportedSceneModes() == null || this.f4756b == null) ? false : this.f4756b.getParameters().getSupportedSceneModes().contains("hdr");
    }

    /* renamed from: d */
    public void mo6115d() {
        this.f4755a.mo5947b();
    }

    /* renamed from: d */
    public boolean mo6116d(String str) {
        if (!(this.f4756b == null || this.f4756b.getParameters().getSupportedFlashModes() == null)) {
            for (String equals : this.f4756b.getParameters().getSupportedFlashModes()) {
                if (str.equals(equals)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    public void mo6117e() {
        double d = 1.7777777777777777d;
        if (VERSION.SDK_INT < 14) {
            mo6115d();
        }
        if (this.f4756b != null) {
            Parameters parameters = this.f4756b.getParameters();
            parameters.flatten();
            parameters.isVideoStabilizationSupported();
            parameters.setVideoStabilization(false);
            parameters.set("image-stabilizer", "off");
            parameters.set("ois", "off");
            if (parameters.getSupportedFocusModes() != null && parameters.getSupportedFocusModes().contains("auto")) {
                parameters.setFocusMode("auto");
            }
            if (parameters.getSupportedFlashModes() != null && parameters.getSupportedFlashModes().contains("off")) {
                parameters.setFlashMode("off");
            }
            if (this.f4757c != null) {
                parameters.setWhiteBalance(this.f4757c);
            } else if (parameters.getSupportedWhiteBalance() != null && parameters.getSupportedWhiteBalance().contains("auto")) {
                parameters.setWhiteBalance("auto");
            }
            if (this.f4758d != null) {
                parameters.setColorEffect(this.f4758d);
            } else if (parameters.getSupportedColorEffects() != null && parameters.getSupportedColorEffects().contains("none")) {
                parameters.setColorEffect("none");
            }
            Size a = mo6091a(parameters.getSupportedPictureSizes());
            if (!C1753x.m8332a((((double) a.width) * 1.0d) / ((double) a.height), 1.7777777777777777d)) {
                d = 1.3333333333333333d;
            }
            if (C1753x.f5011C || C1753x.f5010B) {
                a = mo6094a(parameters.getSupportedPictureSizes(), C1753x.m8333b(), !C1753x.m8334c(), d);
                if (a != null) {
                    parameters.setPictureSize(a.width, a.height);
                } else {
                    a = mo6105b(parameters.getSupportedPictureSizes(), C1753x.m8333b(), !C1753x.m8334c(), d);
                    if (a != null) {
                        parameters.setPictureSize(a.width, a.height);
                    } else {
                        parameters.setPictureSize(640, 480);
                    }
                }
            } else {
                parameters.setPictureSize(640, 480);
            }
            a = mo6093a(parameters.getSupportedPreviewSizes(), C1753x.f5034h, C1753x.f5035i);
            if (a != null) {
                parameters.setPreviewSize(a.width, a.height);
            } else {
                a = mo6092a(parameters.getSupportedPreviewSizes(), C1753x.f5036j);
                if (a != null) {
                    parameters.setPreviewSize(a.width, a.height);
                } else {
                    parameters.setPreviewSize(640, 480);
                }
            }
            if (parameters.getSupportedPreviewFormats() != null && parameters.getSupportedPreviewFormats().contains(Integer.valueOf(17))) {
                parameters.setPreviewFormat(17);
            }
            try {
                this.f4756b.setParameters(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: f */
    public boolean mo6118f() {
        return (VERSION.SDK_INT < 14 || this.f4756b == null) ? false : this.f4756b.getParameters().isAutoExposureLockSupported();
    }

    /* renamed from: g */
    public boolean mo6119g() {
        if (VERSION.SDK_INT < 14 || this.f4756b == null) {
            return false;
        }
        boolean isAutoWhiteBalanceLockSupported;
        synchronized (this) {
            isAutoWhiteBalanceLockSupported = this.f4756b.getParameters().isAutoWhiteBalanceLockSupported();
        }
        return isAutoWhiteBalanceLockSupported;
    }

    /* renamed from: h */
    public List<String> mo6120h() {
        return this.f4756b != null ? this.f4756b.getParameters().getSupportedWhiteBalance() : null;
    }

    /* renamed from: i */
    public List<String> mo6121i() {
        if (this.f4756b == null) {
            return null;
        }
        if (!C1753x.m8337f()) {
            return this.f4756b.getParameters().getSupportedColorEffects();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("solarize");
        arrayList.add("sepia");
        arrayList.add("posterize");
        arrayList.add("negative");
        arrayList.add("mono");
        arrayList.add("none");
        return arrayList;
    }

    /* renamed from: j */
    public boolean mo6122j() {
        return this.f4756b != null;
    }

    /* renamed from: k */
    public void mo6123k() {
        this.f4756b.lock();
    }

    /* renamed from: l */
    public void mo6124l() {
        this.f4756b.release();
    }

    /* renamed from: m */
    public Camera mo6125m() {
        return this.f4756b;
    }

    /* renamed from: n */
    public void mo6126n() {
        this.f4756b.cancelAutoFocus();
    }

    /* renamed from: o */
    public void mo6127o() {
        this.f4756b.startPreview();
    }

    /* renamed from: p */
    public void mo6128p() {
        if (this.f4756b != null) {
            C1753x.f5050x = 18.0d / Math.tan((((double) this.f4756b.getParameters().getHorizontalViewAngle()) * 3.141592653589793d) / 360.0d);
        } else {
            C1753x.f5050x = 30.0d;
        }
    }
}
