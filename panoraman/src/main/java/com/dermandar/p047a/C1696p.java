package com.dermandar.p047a;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import android.util.Size;
import android.util.SizeF;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.dermandar.a.p */
public class C1696p {
    /* renamed from: a */
    C1629k f4760a;
    /* renamed from: b */
    C1618g f4761b;
    /* renamed from: c */
    CameraDevice f4762c;
    /* renamed from: d */
    C1677z f4763d;
    /* renamed from: e */
    public Context f4764e = null;
    /* renamed from: f */
    C1630l f4765f;
    /* renamed from: g */
    CameraCharacteristics f4766g;
    /* renamed from: h */
    C1613b f4767h;

    /* renamed from: com.dermandar.a.p$1 */
    class C16951 implements C1631m {
        C16951() {
        }

        /* renamed from: a */
        public void mo5996a() {
            C1696p.this.f4762c = null;
            C1696p.this.f4765f.mo5995a(false);
            Log.e("rmh", "Camera Closed");
        }

        /* renamed from: a */
        public void mo5997a(int i) {
        }

        /* renamed from: a */
        public void mo5998a(CameraDevice cameraDevice) {
            C1696p.this.f4762c = cameraDevice;
            C1696p.this.f4765f.mo5995a(true);
            Log.e("rmh", "Camera Opened");
        }

        /* renamed from: a */
        public void mo5999a(boolean z) {
            Log.e("rmh", "Focus Locked: " + z);
            C1696p.this.f4767h.mo5916a(z);
        }

        /* renamed from: a */
        public void mo6000a(byte[] bArr, int i, int i2) {
            Log.e("rmh", "Saving Image... width: " + i + " Height: " + i2);
            C1696p.this.f4763d.mo6048a(bArr);
        }

        /* renamed from: b */
        public void mo6001b(boolean z) {
            Log.e("rmh", "Exposure Locked: " + z);
        }

        /* renamed from: c */
        public void mo6002c(boolean z) {
        }
    }

    public C1696p(Context context, C1630l c1630l) {
        this.f4764e = context;
        this.f4765f = c1630l;
        this.f4760a = new C1629k(this.f4764e, new C16951());
        this.f4761b = this.f4760a.mo5973a();
        mo6129a();
    }

    /* renamed from: a */
    public void mo6129a() {
        Log.e("rmh", "capture2 onresume *****");
        this.f4760a.mo5978b();
    }

    /* renamed from: a */
    public void mo6130a(int i) {
        this.f4760a.mo5979b(i);
    }

    /* renamed from: a */
    public void mo6131a(CameraDevice cameraDevice) {
        C1570ab.m7585b("rmh", cameraDevice + "haaa");
        this.f4762c = cameraDevice;
    }

    /* renamed from: a */
    public void mo6132a(C1613b c1613b) {
        this.f4767h = c1613b;
        if (this.f4760a.mo5991l()) {
            this.f4760a.mo5985f();
        } else {
            this.f4767h.mo5916a(false);
        }
    }

    /* renamed from: a */
    public void mo6133a(C1677z c1677z) {
        this.f4763d = c1677z;
        Log.e("rmh", "takePicture");
        this.f4760a.mo5984e();
    }

    /* renamed from: a */
    public void mo6134a(String str) {
        this.f4760a.mo5982c(Integer.parseInt(str));
    }

    /* renamed from: a */
    public void mo6135a(boolean z) {
        this.f4760a.mo5976a(z);
    }

    /* renamed from: b */
    public void mo6136b(int i) {
        this.f4760a.f4525a = i;
        C1570ab.m7585b("rmh", "openCamooo" + i);
        if (mo6155l() != null) {
            C1570ab.m7585b("rmh", "openCamoo222");
            mo6156m();
            if (this.f4761b.isAvailable()) {
                mo6146d(i);
            }
            mo6129a();
        }
    }

    /* renamed from: b */
    public void mo6137b(CameraDevice cameraDevice) {
    }

    /* renamed from: b */
    public void mo6138b(boolean z) {
        this.f4760a.mo5980b(z);
    }

    /* renamed from: b */
    public boolean mo6139b() {
        return this.f4761b != null;
    }

    /* renamed from: b */
    public boolean mo6140b(String str) {
        return this.f4760a.mo5993n();
    }

    /* renamed from: c */
    public void mo6141c(int i) {
        this.f4760a.f4525a = i;
    }

    /* renamed from: c */
    public void mo6142c(String str) {
        this.f4760a.mo5974a(Integer.parseInt(str));
    }

    /* renamed from: c */
    public void mo6143c(boolean z) {
    }

    /* renamed from: c */
    public boolean mo6144c() {
        return this.f4762c != null;
    }

    /* renamed from: d */
    public Size mo6145d() {
        return this.f4760a.f4528d;
    }

    /* renamed from: d */
    public void mo6146d(int i) {
        C1570ab.m7585b("rmh", this.f4761b.isAvailable() + "avaaa");
        C1570ab.m7585b("rmh", "openCamsss");
        this.f4760a.f4525a = i;
        C1570ab.m7585b("rmh", this.f4761b.isAvailable() + "avaaa2");
        C1570ab.m7585b("rmh", this.f4761b.getWidth() + " wwwwwhxhxhx: " + this.f4761b.getHeight());
        this.f4760a.mo5975a(this.f4761b.getWidth(), this.f4761b.getHeight());
        C1570ab.m7585b("rmh", this.f4761b.isAvailable() + "avaaa3");
    }

    /* renamed from: e */
    public void mo6147e(int i) {
    }

    /* renamed from: e */
    public boolean mo6148e() {
        return this.f4760a.mo5987h();
    }

    /* renamed from: f */
    public List<String> mo6149f() {
        int[] i = this.f4760a.mo5988i();
        ArrayList arrayList = new ArrayList();
        for (int valueOf : i) {
            arrayList.add(String.valueOf(valueOf));
        }
        return arrayList;
    }

    /* renamed from: g */
    public boolean mo6150g() {
        return this.f4760a.mo5989j();
    }

    /* renamed from: h */
    public List<String> mo6151h() {
        if (C1753x.m8337f()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("3");
            arrayList.add("4");
            arrayList.add("5");
            arrayList.add("2");
            arrayList.add("1");
            arrayList.add("0");
            return arrayList;
        }
        int[] o = this.f4760a.mo5994o();
        ArrayList arrayList2 = new ArrayList();
        for (int valueOf : o) {
            arrayList2.add(String.valueOf(valueOf));
        }
        return arrayList2;
    }

    /* renamed from: i */
    public void mo6152i() {
    }

    /* renamed from: j */
    public boolean mo6153j() {
        return this.f4760a.mo5990k();
    }

    /* renamed from: k */
    public void mo6154k() {
        if (this.f4762c == null) {
            C1753x.f5050x = 30.0d;
            return;
        }
        try {
            this.f4766g = ((CameraManager) this.f4764e.getSystemService("camera")).getCameraCharacteristics(this.f4760a.mo5986g());
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        C1753x.f5050x = 18.0d / Math.tan((Math.atan((double) (((SizeF) this.f4766g.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE)).getWidth() / (((float[]) this.f4766g.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS))[0] * 2.0f))) * 2.0d) / 2.0d);
    }

    /* renamed from: l */
    public C1618g mo6155l() {
        return this.f4761b;
    }

    /* renamed from: m */
    public void mo6156m() {
        Log.e("rmh", "stopPreview123");
        this.f4760a.mo5981c();
    }

    /* renamed from: n */
    public void mo6157n() {
    }

    /* renamed from: o */
    public void mo6158o() {
    }

    /* renamed from: p */
    public CameraDevice mo6159p() {
        return this.f4762c;
    }
}
