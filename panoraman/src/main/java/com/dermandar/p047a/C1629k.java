package com.dermandar.p047a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest.Key;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.ColorSpaceTransform;
import android.hardware.camera2.params.RggbChannelVector;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.WindowManager;
import com.nativesystem.Core;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.dermandar.a.k */
public class C1629k {
    /* renamed from: n */
    static final /* synthetic */ boolean f4517n = (!C1629k.class.desiredAssertionStatus());
    /* renamed from: o */
    private static final SparseIntArray f4518o = new SparseIntArray();
    /* renamed from: A */
    private int f4519A = 0;
    /* renamed from: B */
    private Semaphore f4520B = new Semaphore(1);
    /* renamed from: C */
    private boolean f4521C;
    /* renamed from: D */
    private CaptureCallback f4522D = new C16254();
    /* renamed from: E */
    private Context f4523E = null;
    /* renamed from: F */
    private C1631m f4524F = null;
    /* renamed from: a */
    public int f4525a = 1;
    /* renamed from: b */
    public final SurfaceTextureListener f4526b = new C16221();
    /* renamed from: c */
    public String f4527c;
    /* renamed from: d */
    public Size f4528d;
    /* renamed from: e */
    float f4529e = -1.0f;
    /* renamed from: f */
    RggbChannelVector f4530f = null;
    /* renamed from: g */
    ColorSpaceTransform f4531g = null;
    /* renamed from: h */
    int f4532h = -1;
    /* renamed from: i */
    boolean f4533i;
    /* renamed from: j */
    int f4534j;
    /* renamed from: k */
    boolean f4535k = true;
    /* renamed from: l */
    public int f4536l;
    /* renamed from: m */
    int f4537m;
    /* renamed from: p */
    private boolean f4538p = false;
    /* renamed from: q */
    private C1618g f4539q;
    /* renamed from: r */
    private CameraCaptureSession f4540r;
    /* renamed from: s */
    private CameraDevice f4541s;
    /* renamed from: t */
    private final StateCallback f4542t = new C16232();
    /* renamed from: u */
    private HandlerThread f4543u;
    /* renamed from: v */
    private Handler f4544v;
    /* renamed from: w */
    private ImageReader f4545w;
    /* renamed from: x */
    private final OnImageAvailableListener f4546x = new C16243();
    /* renamed from: y */
    private Builder f4547y;
    /* renamed from: z */
    private CaptureRequest f4548z;

    /* renamed from: com.dermandar.a.k$1 */
    class C16221 implements SurfaceTextureListener {
        C16221() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (!C1629k.this.f4538p) {
                C1629k.this.mo5975a(i, i2);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            C1629k.this.m7790c(i, i2);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* renamed from: com.dermandar.a.k$2 */
    class C16232 extends StateCallback {
        C16232() {
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            C1629k.this.f4520B.release();
            cameraDevice.close();
            C1629k.this.f4541s = null;
            C1629k.this.f4524F.mo5996a();
        }

        public void onError(CameraDevice cameraDevice, int i) {
            C1629k.this.f4520B.release();
            cameraDevice.close();
            C1629k.this.f4541s = null;
            C1629k.this.f4524F.mo5997a(0);
        }

        public void onOpened(CameraDevice cameraDevice) {
            C1629k.this.f4520B.release();
            C1629k.this.f4541s = cameraDevice;
            C1629k.this.m7804s();
            C1629k.this.f4524F.mo5998a(cameraDevice);
            C1629k.this.f4547y.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(C1629k.this.f4534j));
        }
    }

    /* renamed from: com.dermandar.a.k$3 */
    class C16243 implements OnImageAvailableListener {
        C16243() {
        }

        public void onImageAvailable(ImageReader imageReader) {
            C1629k.this.f4544v.post(new C1628a(imageReader.acquireNextImage(), C1629k.this.f4524F));
        }
    }

    /* renamed from: com.dermandar.a.k$4 */
    class C16254 extends CaptureCallback {
        C16254() {
        }

        /* renamed from: a */
        private void m7780a(CaptureResult captureResult) {
            Integer num;
            switch (C1629k.this.f4519A) {
                case 1:
                    num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                    if (num == null) {
                        C1629k.this.f4519A = 0;
                        C1629k.this.f4524F.mo5999a(false);
                        return;
                    } else if (num.intValue() == 4 || num.intValue() == 2) {
                        C1629k.this.f4519A = 0;
                        CameraManager cameraManager = (CameraManager) C1629k.this.f4523E.getSystemService("camera");
                        C1629k.this.f4524F.mo5999a(true);
                        return;
                    } else if (num.intValue() == 5) {
                        C1629k.this.f4519A = 0;
                        C1629k.this.f4524F.mo5999a(false);
                        return;
                    } else {
                        return;
                    }
                case 2:
                    num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num == null) {
                        C1629k.this.f4519A = 0;
                        C1629k.this.f4524F.mo6001b(false);
                        return;
                    } else if (num.intValue() == 3) {
                        C1629k.this.f4519A = 0;
                        C1629k.this.f4524F.mo6001b(true);
                        return;
                    } else {
                        return;
                    }
                case 5:
                    num = (Integer) captureResult.get(CaptureResult.CONTROL_AWB_STATE);
                    if (num == null) {
                        C1629k.this.f4519A = 0;
                        C1629k.this.f4524F.mo6002c(false);
                        return;
                    } else if (num.intValue() == 3) {
                        C1629k.this.f4519A = 0;
                        C1629k.this.f4524F.mo6002c(true);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            m7780a(totalCaptureResult);
            if (totalCaptureResult.get(TotalCaptureResult.LENS_FOCUS_DISTANCE) != null) {
                C1629k.this.f4529e = ((Float) totalCaptureResult.get(TotalCaptureResult.LENS_FOCUS_DISTANCE)).floatValue();
            }
            if (totalCaptureResult.get(TotalCaptureResult.COLOR_CORRECTION_GAINS) != null && C1629k.this.f4534j == 0 && C1629k.this.f4535k) {
                C1629k.this.f4532h = ((Integer) totalCaptureResult.get(TotalCaptureResult.COLOR_CORRECTION_MODE)).intValue();
                C1629k.this.f4530f = (RggbChannelVector) totalCaptureResult.get(TotalCaptureResult.COLOR_CORRECTION_GAINS);
                C1629k.this.f4531g = (ColorSpaceTransform) totalCaptureResult.get(TotalCaptureResult.COLOR_CORRECTION_TRANSFORM);
            }
        }

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            m7780a(captureResult);
        }
    }

    /* renamed from: com.dermandar.a.k$5 */
    class C16265 extends CameraCaptureSession.StateCallback {
        C16265() {
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Log.e("AMS", "onConfigureFailed :: Failed");
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            if (C1629k.this.f4541s != null) {
                C1629k.this.f4540r = cameraCaptureSession;
                try {
                    if (C1629k.this.mo5992m()) {
                        C1629k.this.f4547y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                    } else if (C1629k.this.mo5991l()) {
                        C1629k.this.f4547y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
                    } else {
                        C1629k.this.f4547y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
                    }
                    C1629k.this.f4548z = C1629k.this.f4547y.build();
                    if (C1629k.this.f4540r != null) {
                        C1629k.this.f4540r.setRepeatingRequest(C1629k.this.f4548z, C1629k.this.f4522D, C1629k.this.f4544v);
                    }
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.dermandar.a.k$6 */
    class C16276 extends CaptureCallback {
        C16276() {
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            Log.e("AMS", "Image Ready");
            try {
                C1629k.this.f4540r.stopRepeating();
                if (C1629k.this.f4529e >= 0.0f) {
                    C1629k.this.f4547y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
                    C1629k.this.f4547y.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
                    C1629k.this.f4547y.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(C1629k.this.f4529e));
                }
                if (C1629k.this.f4530f != null) {
                    C1629k.this.f4535k = false;
                    C1629k.this.f4547y.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(0));
                    C1629k.this.f4547y.set(CaptureRequest.COLOR_CORRECTION_MODE, Integer.valueOf(0));
                    C1629k.this.f4547y.set(CaptureRequest.COLOR_CORRECTION_GAINS, C1629k.this.f4530f);
                    C1629k.this.f4547y.set(CaptureRequest.COLOR_CORRECTION_TRANSFORM, C1629k.this.f4531g);
                }
                C1629k.this.f4540r.setRepeatingRequest(C1629k.this.f4547y.build(), C1629k.this.f4522D, C1629k.this.f4544v);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.dermandar.a.k$a */
    private static class C1628a implements Runnable {
        /* renamed from: a */
        private final Image f4515a;
        /* renamed from: b */
        private C1631m f4516b = null;

        public C1628a(Image image, C1631m c1631m) {
            this.f4515a = image;
            this.f4516b = c1631m;
        }

        public void run() {
            ByteBuffer buffer = this.f4515a.getPlanes()[0].getBuffer();
            byte[] bArr = new byte[buffer.remaining()];
            buffer.get(bArr);
            this.f4516b.mo6000a(bArr, this.f4515a.getWidth(), this.f4515a.getHeight());
            this.f4515a.close();
        }
    }

    public C1629k(Context context, C1631m c1631m) {
        this.f4523E = context;
        this.f4524F = c1631m;
    }

    /* renamed from: a */
    private int m7781a(CameraCharacteristics cameraCharacteristics, int i) {
        if (i == -1) {
            return 0;
        }
        int i2;
        int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        int i3 = ((i + 45) / 90) * 90;
        if ((((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0 ? 1 : 0) != 0) {
            i2 = -i3;
            f4518o.clear();
            f4518o.append(0, 90);
            f4518o.append(90, 180);
            f4518o.append(180, 270);
            f4518o.append(270, 0);
        } else {
            f4518o.clear();
            f4518o.append(0, 270);
            f4518o.append(90, 0);
            f4518o.append(180, 90);
            f4518o.append(270, 180);
            i2 = i3;
        }
        return f4518o.get(((i2 + intValue) + 360) % 360);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m7789b(int i, int i2) {
        CameraManager cameraManager = (CameraManager) this.f4523E.getSystemService("camera");
        try {
            int i3;
            for (String str : cameraManager.getCameraIdList()) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                if (num == null || num.intValue() == this.f4525a) {
                    StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    if (streamConfigurationMap != null) {
                        Size size = null;
                        if (C1753x.f5011C || C1753x.f5010B) {
                            size = mo5972a(Arrays.asList(streamConfigurationMap.getOutputSizes(256)), C1753x.m8333b(), !C1753x.m8334c(), 1.7777777777777777d);
                            if (size == null) {
                                size = mo5977b(Arrays.asList(streamConfigurationMap.getOutputSizes(256)), C1753x.m8333b(), !C1753x.m8334c(), 1.7777777777777777d);
                            }
                        }
                        if (size == null) {
                            size = new Size(640, 480);
                        }
                        this.f4545w = ImageReader.newInstance(size.getWidth(), size.getHeight(), 256, 2);
                        this.f4545w.setOnImageAvailableListener(this.f4546x, this.f4544v);
                        int rotation = ((WindowManager) this.f4523E.getSystemService("window")).getDefaultDisplay().getRotation();
                        int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                        switch (rotation) {
                            case 0:
                            case 2:
                                if (intValue == 90 || intValue == 270) {
                                    i3 = 1;
                                    break;
                                }
                            case 1:
                            case 3:
                                if (intValue == 0 || intValue == 180) {
                                    i3 = 1;
                                    break;
                                }
                            default:
                                Log.e("DMDCamera2", "Display rotation is invalid: " + rotation);
                        }
                        Object obj = null;
                        Point point = new Point();
                        ((WindowManager) this.f4523E.getSystemService("window")).getDefaultDisplay().getSize(point);
                        rotation = point.x;
                        intValue = point.y;
                        if (obj != null) {
                            rotation = point.y;
                            intValue = point.x;
                        }
                        if (rotation > 1920) {
                        }
                        if (intValue > 1080) {
                        }
                        Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
                        List arrayList = new ArrayList();
                        for (intValue = 0; intValue < outputSizes.length; intValue++) {
                            arrayList.add(intValue, outputSizes[intValue]);
                        }
                        this.f4528d = mo5971a(arrayList, C1753x.f5034h, C1753x.f5035i);
                        if (this.f4528d == null) {
                            this.f4528d = mo5970a(arrayList, 1.7777777777777777d);
                        }
                        if (this.f4528d == null) {
                            this.f4528d = new Size(640, 480);
                        }
                        if (this.f4523E.getResources().getConfiguration().orientation == 2) {
                            this.f4539q.mo5951a(this.f4528d.getWidth(), this.f4528d.getHeight());
                        } else {
                            this.f4539q.mo5951a(this.f4528d.getHeight(), this.f4528d.getWidth());
                        }
                        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                        this.f4521C = bool == null ? false : bool.booleanValue();
                        this.f4527c = str;
                        return;
                    }
                }
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            Log.e("AMS", "error occured");
        }
    }

    /* renamed from: c */
    private void m7790c(int i, int i2) {
        if (this.f4539q != null && this.f4528d != null && this.f4523E != null) {
            int rotation = ((WindowManager) this.f4523E.getSystemService("window")).getDefaultDisplay().getRotation();
            Matrix matrix = new Matrix();
            RectF rectF = new RectF(0.0f, 0.0f, (float) i, (float) i2);
            RectF rectF2 = new RectF(0.0f, 0.0f, (float) this.f4528d.getHeight(), (float) this.f4528d.getWidth());
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            if (1 == rotation || 3 == rotation) {
                rectF2.offset(centerX - rectF2.centerX(), centerY - rectF2.centerY());
                matrix.setRectToRect(rectF, rectF2, ScaleToFit.FILL);
                float max = Math.max(((float) i2) / ((float) this.f4528d.getHeight()), ((float) i) / ((float) this.f4528d.getWidth()));
                matrix.postScale(max, max, centerX, centerY);
                matrix.postRotate((float) ((rotation - 2) * 90), centerX, centerY);
            } else if (2 == rotation) {
                matrix.postRotate(180.0f, centerX, centerY);
            }
            this.f4539q.setTransform(matrix);
        }
    }

    /* renamed from: p */
    private void m7801p() {
        try {
            this.f4520B.acquire();
            if (this.f4540r != null) {
                this.f4540r.close();
                this.f4540r = null;
            }
            if (this.f4541s != null) {
                this.f4541s.close();
                this.f4541s = null;
            }
            if (this.f4545w != null) {
                this.f4545w.close();
                this.f4545w = null;
            }
            this.f4520B.release();
            this.f4538p = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Interrupted while trying to lock camera closing.", e);
        } catch (Throwable th) {
            th.printStackTrace();
            this.f4520B.release();
            this.f4538p = false;
        }
    }

    /* renamed from: q */
    private void m7802q() {
        this.f4543u = new HandlerThread("CameraBackground");
        this.f4543u.start();
        this.f4544v = new Handler(this.f4543u.getLooper());
    }

    /* renamed from: r */
    private void m7803r() {
        this.f4543u.quitSafely();
        try {
            this.f4543u.join();
            this.f4543u = null;
            this.f4544v = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: s */
    private void m7804s() {
        try {
            SurfaceTexture surfaceTexture = this.f4539q.getSurfaceTexture();
            if (f4517n || surfaceTexture != null) {
                surfaceTexture.setDefaultBufferSize(this.f4528d.getWidth(), this.f4528d.getHeight());
                Surface surface = new Surface(surfaceTexture);
                this.f4547y = this.f4541s.createCaptureRequest(1);
                this.f4547y.addTarget(surface);
                this.f4541s.createCaptureSession(Arrays.asList(new Surface[]{surface, this.f4545w.getSurface()}), new C16265(), null);
                return;
            }
            throw new AssertionError();
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public Size mo5970a(List<Size> list, double d) {
        double d2 = Double.MAX_VALUE;
        Size size = null;
        for (Size size2 : list) {
            Size size22 = size2;
            double abs = Math.abs(d - (C1753x.m8334c() ? ((double) size22.getHeight()) / ((double) size22.getWidth()) : ((double) size22.getWidth()) / ((double) size22.getHeight())));
            if (d2 <= abs) {
                if (d2 == abs) {
                    float f = (float) (C1753x.f5035i * C1753x.f5034h);
                    float width = (float) (size22.getWidth() * size22.getHeight());
                    float width2 = (float) (size.getWidth() * size.getHeight());
                    if (width > f && width - f < Math.abs(width2 - f)) {
                        abs = d2;
                    } else if (Math.abs(width - f) < Math.abs(width2 - f)) {
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
    public Size mo5971a(List<Size> list, int i, int i2) {
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
            if (size2.getWidth() == i2 || size2.getHeight() == i) {
                double abs = Math.abs(d2 - (C1753x.m8334c() ? ((double) size2.getHeight()) / ((double) size2.getWidth()) : ((double) size2.getWidth()) / ((double) size2.getHeight())));
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
    public Size mo5972a(List<Size> list, int i, boolean z, double d) {
        Size size = null;
        if (!(list == null || list.size() == 0 || i <= 0)) {
            int i2 = 0;
            while (i2 < list.size()) {
                Size size2 = (Size) list.get(i2);
                if ((z ? size2.getWidth() : size2.getHeight()) < i || (!(d == -1.0d || d == (((double) size2.getWidth()) * 1.0d) / (((double) size2.getHeight()) * 1.0d)) || (size != null && size2.getWidth() >= size.getWidth() && size2.getHeight() >= size.getHeight()))) {
                    size2 = size;
                }
                i2++;
                size = size2;
            }
        }
        return size;
    }

    /* renamed from: a */
    public C1618g mo5973a() {
        this.f4539q = new C1618g(this.f4523E);
        return this.f4539q;
    }

    /* renamed from: a */
    public void mo5974a(int i) {
        int i2 = 1;
        try {
            this.f4530f = null;
            this.f4531g = null;
            this.f4532h = -1;
            this.f4535k = i == 0;
            this.f4540r.stopRepeating();
            Builder builder = this.f4547y;
            Key key = CaptureRequest.CONTROL_AWB_MODE;
            if (i > 0) {
                i2 = i;
            }
            builder.set(key, Integer.valueOf(i2));
            this.f4519A = 5;
            this.f4540r.setRepeatingRequest(this.f4547y.build(), this.f4522D, this.f4544v);
            this.f4534j = i;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo5975a(int i, int i2) {
        this.f4538p = true;
        m7789b(i, i2);
        m7790c(i, i2);
        CameraManager cameraManager = (CameraManager) this.f4523E.getSystemService("camera");
        try {
            if (this.f4520B.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                cameraManager.openCamera(this.f4527c, this.f4542t, this.f4544v);
                return;
            }
            throw new RuntimeException("Time out waiting to lock camera opening.");
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            throw new RuntimeException("Interrupted while trying to lock camera opening.", e2);
        }
    }

    /* renamed from: a */
    public void mo5976a(boolean z) {
        try {
            if (this.f4540r != null) {
                this.f4540r.stopRepeating();
            }
            this.f4547y.set(CaptureRequest.CONTROL_SCENE_MODE, Integer.valueOf(18));
            this.f4519A = 2;
            if (this.f4540r != null) {
                this.f4540r.setRepeatingRequest(this.f4547y.build(), this.f4522D, this.f4544v);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public Size mo5977b(List<Size> list, int i, boolean z, double d) {
        Size size = null;
        if (!(list == null || list.size() == 0 || i <= 0)) {
            int i2 = 0;
            while (i2 < list.size()) {
                Size size2 = (Size) list.get(i2);
                if ((z ? size2.getWidth() : size2.getHeight()) > i || (!(d == -1.0d || d == (((double) size2.getWidth()) * 1.0d) / (((double) size2.getHeight()) * 1.0d)) || (size != null && size2.getWidth() < size.getWidth() && size2.getHeight() < size.getHeight()))) {
                    size2 = size;
                }
                i2++;
                size = size2;
            }
        }
        return size;
    }

    /* renamed from: b */
    public void mo5978b() {
        m7802q();
        if (this.f4539q.isAvailable()) {
            Log.e("AMS", "openCamera2");
            if (!this.f4538p) {
                mo5975a(this.f4539q.getWidth(), this.f4539q.getHeight());
                return;
            }
            return;
        }
        this.f4539q.setSurfaceTextureListener(this.f4526b);
    }

    /* renamed from: b */
    public void mo5979b(int i) {
        try {
            this.f4540r.stopRepeating();
            this.f4547y.set(CaptureRequest.FLASH_MODE, Integer.valueOf(i));
            this.f4519A = 2;
            this.f4540r.setRepeatingRequest(this.f4547y.build(), this.f4522D, this.f4544v);
            this.f4536l = i;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo5980b(boolean z) {
        try {
            if (this.f4540r != null) {
                this.f4540r.stopRepeating();
            }
            if (this.f4547y != null) {
                this.f4547y.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.valueOf(z));
                this.f4519A = 2;
                if (this.f4540r != null) {
                    this.f4540r.setRepeatingRequest(this.f4547y.build(), this.f4522D, this.f4544v);
                }
            }
            this.f4533i = z;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void mo5981c() {
        m7801p();
        m7803r();
    }

    /* renamed from: c */
    public void mo5982c(int i) {
        try {
            if (this.f4540r != null) {
                this.f4540r.stopRepeating();
            }
            this.f4547y.set(CaptureRequest.CONTROL_EFFECT_MODE, Integer.valueOf(i));
            this.f4519A = 2;
            if (this.f4540r != null) {
                this.f4540r.setRepeatingRequest(this.f4547y.build(), this.f4522D, this.f4544v);
            }
            this.f4537m = i;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public void mo5983d() {
        try {
            this.f4529e = -1.0f;
            this.f4530f = null;
            this.f4531g = null;
            this.f4532h = -1;
            this.f4535k = true;
            if (mo5992m()) {
                this.f4547y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
            } else if (mo5991l()) {
                this.f4547y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
            } else {
                this.f4547y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
            }
            this.f4547y.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(1));
            this.f4547y.set(CaptureRequest.COLOR_CORRECTION_MODE, Integer.valueOf(1));
            this.f4548z = this.f4547y.build();
            if (this.f4540r != null) {
                this.f4540r.setRepeatingRequest(this.f4548z, this.f4522D, this.f4544v);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public void mo5984e() {
        try {
            C1753x.f5016H++;
            C1753x.f5015G++;
            Core.takingPhoto();
            if (this.f4523E != null && this.f4541s != null) {
                Builder createCaptureRequest = this.f4541s.createCaptureRequest(2);
                createCaptureRequest.addTarget(this.f4545w.getSurface());
                if (this.f4529e >= 0.0f) {
                    createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
                    createCaptureRequest.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(this.f4529e));
                }
                if (this.f4530f != null) {
                    this.f4535k = false;
                    createCaptureRequest.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(0));
                    createCaptureRequest.set(CaptureRequest.COLOR_CORRECTION_MODE, Integer.valueOf(0));
                    createCaptureRequest.set(CaptureRequest.COLOR_CORRECTION_GAINS, this.f4530f);
                    createCaptureRequest.set(CaptureRequest.COLOR_CORRECTION_TRANSFORM, this.f4531g);
                }
                createCaptureRequest.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.valueOf(this.f4533i));
                createCaptureRequest.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.f4536l));
                createCaptureRequest.set(CaptureRequest.CONTROL_EFFECT_MODE, Integer.valueOf(this.f4537m));
                createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(m7781a(((CameraManager) this.f4523E.getSystemService("camera")).getCameraCharacteristics("" + this.f4541s.getId()), ((WindowManager) this.f4523E.getSystemService("window")).getDefaultDisplay().getRotation())));
                C16276 c16276 = new C16276();
                this.f4540r.stopRepeating();
                this.f4540r.capture(createCaptureRequest.build(), c16276, null);
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public void mo5985f() {
        this.f4529e = -1.0f;
        this.f4530f = null;
        this.f4531g = null;
        this.f4532h = -1;
        try {
            if (mo5992m()) {
                this.f4547y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                this.f4547y.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
            } else if (mo5991l()) {
                this.f4547y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
                this.f4547y.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
            } else {
                this.f4547y.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
            }
            this.f4519A = 1;
            this.f4540r.setRepeatingRequest(this.f4547y.build(), this.f4522D, this.f4544v);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public String mo5986g() {
        return this.f4527c;
    }

    /* renamed from: h */
    public boolean mo5987h() {
        CameraCharacteristics cameraCharacteristics;
        try {
            cameraCharacteristics = ((CameraManager) this.f4523E.getSystemService("camera")).getCameraCharacteristics(this.f4527c);
        } catch (CameraAccessException e) {
            e.printStackTrace();
            cameraCharacteristics = null;
        }
        return VERSION.SDK_INT >= 21 ? true : ((Boolean) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_LOCK_AVAILABLE)).booleanValue();
    }

    /* renamed from: i */
    public int[] mo5988i() {
        CameraCharacteristics cameraCharacteristics;
        try {
            cameraCharacteristics = ((CameraManager) this.f4523E.getSystemService("camera")).getCameraCharacteristics(this.f4527c);
        } catch (CameraAccessException e) {
            e.printStackTrace();
            cameraCharacteristics = null;
        }
        return (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
    }

    /* renamed from: j */
    public boolean mo5989j() {
        CameraCharacteristics cameraCharacteristics;
        try {
            cameraCharacteristics = ((CameraManager) this.f4523E.getSystemService("camera")).getCameraCharacteristics(this.f4527c);
        } catch (CameraAccessException e) {
            e.printStackTrace();
            cameraCharacteristics = null;
        }
        return VERSION.SDK_INT >= 21 ? true : ((Boolean) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_LOCK_AVAILABLE)).booleanValue();
    }

    /* renamed from: k */
    public boolean mo5990k() {
        try {
            for (int i : (int[]) ((CameraManager) this.f4523E.getSystemService("camera")).getCameraCharacteristics(this.f4527c).get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES)) {
                if (i == 18) {
                    return true;
                }
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: l */
    public boolean mo5991l() {
        if (mo5992m()) {
            return true;
        }
        CameraCharacteristics cameraCharacteristics;
        try {
            cameraCharacteristics = ((CameraManager) this.f4523E.getSystemService("camera")).getCameraCharacteristics(this.f4527c);
        } catch (CameraAccessException e) {
            e.printStackTrace();
            cameraCharacteristics = null;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        for (int i : iArr) {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public boolean mo5992m() {
        CameraCharacteristics cameraCharacteristics;
        try {
            cameraCharacteristics = ((CameraManager) this.f4523E.getSystemService("camera")).getCameraCharacteristics(this.f4527c);
        } catch (CameraAccessException e) {
            e.printStackTrace();
            cameraCharacteristics = null;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        for (int i : iArr) {
            if (i == 4) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    public boolean mo5993n() {
        if (this.f4527c == null) {
            return false;
        }
        CameraCharacteristics cameraCharacteristics;
        try {
            cameraCharacteristics = ((CameraManager) this.f4523E.getSystemService("camera")).getCameraCharacteristics(this.f4527c);
        } catch (CameraAccessException e) {
            e.printStackTrace();
            cameraCharacteristics = null;
        }
        return ((Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue();
    }

    /* renamed from: o */
    public int[] mo5994o() {
        CameraCharacteristics cameraCharacteristics;
        try {
            cameraCharacteristics = ((CameraManager) this.f4523E.getSystemService("camera")).getCameraCharacteristics(this.f4527c);
        } catch (CameraAccessException e) {
            e.printStackTrace();
            cameraCharacteristics = null;
        }
        return (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_EFFECTS);
    }
}
