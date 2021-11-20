package com.dermandar.panoraman;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import androidx.appcompat.app.AppCompatActivity;

import com.dermandar.exif.NativeExif;
import com.dermandar.p047a.C1615d;
import com.dermandar.p047a.C1738r;

import com.dermandar.panoraman.p050a.p051a.C2032a;
import com.nativesystem.DMDXMP;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;

public class ExportActivity extends AppCompatActivity {
    /* renamed from: n */
    C1615d f5269n = new C18121();
    /* renamed from: o */
    private String f5270o;
    /* renamed from: p */
    private String f5271p;
    /* renamed from: q */
    private String f5272q;
    /* renamed from: r */
    private C1738r f5273r;
    /* renamed from: s */
    private LinearLayout f5274s;
    /* renamed from: t */
    private boolean f5275t;

    /* renamed from: ir.vira.panoraman.ExportActivity$1 */
    class C18121 implements C1615d {
        C18121() {
        }

        /* renamed from: a */
        private void m8500a(LinkedHashMap<String, String> linkedHashMap, String str) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(ExportActivity.this.f5270o + "/" + str), false);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(linkedHashMap);
                objectOutputStream.flush();
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
            }
        }

        /* renamed from: a */
        public void mo5924a() {
        }

        /* renamed from: a */
        public void mo5925a(int i) {
        }

        /* renamed from: a */
        public void mo5926a(boolean z) {
        }

        /* renamed from: b */
        public void mo5927b() {
            File file = new File(Environment.getExternalStorageDirectory() + "/" + "Panoramas" + "/");
            Log.e("rmh", "c: " + Environment.getExternalStorageDirectory() + "/" + "Panoramas" + "/");
            if (!file.exists()) {
                file.mkdir();
            }
            LinkedHashMap a = ExportActivity.this.m8509a(ExportActivity.this.f5270o);
            ExportActivity.this.f5272q = file.getPath() + "/" + ExportActivity.this.f5271p + ".jpg";
            if (a == null || a.get("HD") == null || !((String) a.get("HD")).equals("True")) {
                ExportActivity.this.f5273r.mo6239b(false);
                C2096g.f6252H = false;
            } else {
                ExportActivity.this.f5273r.mo6239b(true);
                C2096g.f6252H = true;
            }
            ExportActivity.this.f5273r.mo6236a(ExportActivity.this.f5272q, C2096g.m9319a(), 0, 0);
        }

        /* renamed from: c */
        public void mo5928c() {
            ExportActivity.this.setResult(Activity.RESULT_OK);
            ExportActivity.this.finish();
        }

        /* JADX WARNING: Removed duplicated region for block: B:77:0x01c1 A:{SYNTHETIC, Splitter:B:77:0x01c1} */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01cd A:{SYNTHETIC, Splitter:B:83:0x01cd} */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x01da A:{SYNTHETIC, Splitter:B:89:0x01da} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: d */
        public void mo5929d() throws Throwable {
            JSONObject jSONObject;
            Throwable th;
            Object obj = null;
            int i = 0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(ExportActivity.this.f5270o + "/", ExportActivity.this.f5272q);
            m8500a(linkedHashMap, "link.txt");
            C2152o c2152o = new C2152o(new File(ExportActivity.this.f5270o).getName(), ExportActivity.this.f5270o);
            c2152o.mo7070s();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("tags", C2096g.m9327a(c2152o.mo7063l()));
            } catch (JSONException e) {
            }
            try {
                jSONObject2.put("altitude", c2152o.mo7066o());
            } catch (JSONException e2) {
            }
            try {
                jSONObject2.put("description", c2152o.mo7062k());
            } catch (JSONException e3) {
            }
            try {
                jSONObject2.put("direction", c2152o.mo7067p());
            } catch (JSONException e4) {
            }
            try {
                jSONObject2.put("longitude", c2152o.mo7065n());
            } catch (JSONException e5) {
            }
            try {
                jSONObject2.put("latitude", c2152o.mo7064m());
            } catch (JSONException e6) {
            }
            try {
                jSONObject2.put("name", c2152o.mo7061j());
            } catch (JSONException e7) {
            }
            try {
                jSONObject2.put("creation_time", c2152o.mo7068q());
            } catch (JSONException e8) {
            }
            try {
                jSONObject2.put("device_model", c2152o.mo7045a());
            } catch (JSONException e9) {
            }
            try {
                jSONObject2.put("device_osname", c2152o.mo7048b());
            } catch (JSONException e10) {
            }
            try {
                jSONObject2.put("device_osversion", c2152o.mo7051c());
            } catch (JSONException e11) {
            }
            try {
                jSONObject2.put("device_machname", c2152o.mo7055d());
            } catch (JSONException e12) {
            }
            try {
                jSONObject2.put("device_hwmodel", c2152o.mo7056e());
            } catch (JSONException e13) {
            }
            try {
                jSONObject2.put("app_version", c2152o.mo7057f());
            } catch (JSONException e14) {
            }
            String c = ExportActivity.this.m8514b(ExportActivity.this.f5270o);
            if (c != null) {
                try {
                    jSONObject2.put("is_uploaded", true);
                } catch (JSONException e15) {
                }
                String[] split = c.split("/");
                try {
                    jSONObject2.put("web_public_id", split[split.length - 1]);
                } catch (JSONException e16) {
                }
            } else {
                try {
                    jSONObject2.put("is_uploaded", false);
                } catch (JSONException e17) {
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            InputStream fileInputStream;
            try {
                Log.e("rmh", "upload3");
                fileInputStream = new FileInputStream(ExportActivity.this.f5270o + "/data.txt");
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    String readLine;
                    do {
                        readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String[] split2 = readLine.split("\t");
                            if (split2 != null && split2.length == 2) {
                                if (split2[0].equals("fovx")) {
                                    i = Integer.parseInt(split2[1]);
                                }
                                if (split2[0].equals("type")) {
                                    obj = split2[1];
                                    continue;
                                } else {
                                    continue;
                                }
                            }
                        }
                    } while (readLine != null);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                        }
                    }
                } catch (FileNotFoundException e19) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e20) {
                        }
                    }
                    try {
                        jSONObject3.put("fovx", i);
                    } catch (JSONException e21) {
                    }
                    try {
                        jSONObject3.put("type", obj);
                    } catch (JSONException e22) {
                    }
                    jSONObject = new JSONObject();
                    jSONObject.put("dmd_details", jSONObject2);
                    jSONObject.put("dmd_datatxt", jSONObject3);
                    ExportActivity.this.m8511a(c2152o, ExportActivity.this.f5272q, jSONObject);
                    ExportActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(ExportActivity.this.f5272q))));
                    ExportActivity.this.f5273r.mo6240c();
                } catch (IOException e23) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e24) {
                        }
                    }
                    jSONObject3.put("fovx", i);
                    jSONObject3.put("type", obj);
                    jSONObject = new JSONObject();
                    jSONObject.put("dmd_details", jSONObject2);
                    jSONObject.put("dmd_datatxt", jSONObject3);
                    ExportActivity.this.m8511a(c2152o, ExportActivity.this.f5272q, jSONObject);
                    ExportActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(ExportActivity.this.f5272q))));
                    ExportActivity.this.f5273r.mo6240c();
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e25) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e26) {
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                jSONObject3.put("fovx", i);
                jSONObject3.put("type", obj);
                jSONObject = new JSONObject();
                jSONObject.put("dmd_details", jSONObject2);
                jSONObject.put("dmd_datatxt", jSONObject3);
                ExportActivity.this.m8511a(c2152o, ExportActivity.this.f5272q, jSONObject);
                ExportActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(ExportActivity.this.f5272q))));
                ExportActivity.this.f5273r.mo6240c();
            } catch (IOException e27) {
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                jSONObject3.put("fovx", i);
                jSONObject3.put("type", obj);
                jSONObject = new JSONObject();
                jSONObject.put("dmd_details", jSONObject2);
                jSONObject.put("dmd_datatxt", jSONObject3);
                ExportActivity.this.m8511a(c2152o, ExportActivity.this.f5272q, jSONObject);
                ExportActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(ExportActivity.this.f5272q))));
                ExportActivity.this.f5273r.mo6240c();
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                if (fileInputStream != null) {
                }
                throw th;
            }
            if (i > 0 && obj != null) {
                jSONObject3.put("fovx", i);
                jSONObject3.put("type", obj);
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put("dmd_details", jSONObject2);
            } catch (JSONException e28) {
            }
            try {
                jSONObject.put("dmd_datatxt", jSONObject3);
            } catch (JSONException e29) {
            }
            ExportActivity.this.m8511a(c2152o, ExportActivity.this.f5272q, jSONObject);
            ExportActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(ExportActivity.this.f5272q))));
            ExportActivity.this.f5273r.mo6240c();
        }
    }

    /* renamed from: a */
    private LinkedHashMap<String, String> m8509a(String str) {
        File file = new File(str + "/" + "other.txt");
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return linkedHashMap;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00db A:{Catch:{ IOException -> 0x01f1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00db A:{Catch:{ IOException -> 0x01f1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00db A:{Catch:{ IOException -> 0x01f1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00db A:{Catch:{ IOException -> 0x01f1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00db A:{Catch:{ IOException -> 0x01f1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x019b A:{SYNTHETIC, Splitter:B:64:0x019b} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00db A:{Catch:{ IOException -> 0x01f1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a9 A:{SYNTHETIC, Splitter:B:72:0x01a9} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00db A:{Catch:{ IOException -> 0x01f1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b7 A:{SYNTHETIC, Splitter:B:80:0x01b7} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m8511a(C2152o c2152o, String str, JSONObject jSONObject) throws Throwable {
        String jSONObject2;
        String str2;
        String str3;
        int i;
        ExifInterface exifInterface;
        Throwable th;
        String str4 = "";
        if (c2152o != null) {
            try {
                double p = c2152o.mo7067p();
                jSONObject2 = jSONObject.toString();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("data_base64", C2032a.m9117a(jSONObject2.getBytes()));
                str4 = jSONObject3.toString();
                NativeExif.allocInit(str);
                if (str4.length() > 1024) {
                    NativeExif.setMaxBufferSize(str4.length());
                }
                NativeExif.writeGPSImageDirection((float) p);
                NativeExif.writeGPSImageDirectionRef('M');
                NativeExif.writeUserComment(str4);
                NativeExif.saveJPEG(str);
                NativeExif.dealloc();
            } catch (Exception e) {
                str2 = str4;
                Log.e("", "Error:" + e.getMessage());
            }
        }
        str2 = str4;
        str4 = "6";
        try {
            str4 = new ExifInterface(str).getAttribute("Orientation");
            Log.e("rmh", "Ori:" + str4);
            str3 = str4;
        } catch (Exception e2) {
            str3 = str4;
        }
        JSONObject jSONObject4 = new JSONObject();
        int i2 = 0;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(c2152o.mo7059h() + "/data.txt");
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String readLine;
                do {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split("\t");
                        if (split != null && split.length == 2) {
                            if (split[0].equals("fovx")) {
                                i2 = Integer.parseInt(split[1]);
                            }
                            if (split[0].equals("type")) {
                                jSONObject2 = split[1];
                                continue;
                            } else {
                                continue;
                            }
                        }
                    }
                } while (readLine != null);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        i = i2;
                    } catch (IOException e3) {
                        i = i2;
                    }
                    if (i > 0) {
                        Options options = new Options();
                        options.inJustDecodeBounds = true;
                        Bitmap decodeFile = BitmapFactory.decodeFile(this.f5272q, options);
                        if (decodeFile == null) {
                            Log.e("rmh", "errorro");
                        } else {
                            decodeFile.recycle();
                        }
                        try {
                            DMDXMP.writeXMPHeader(this.f5272q, options.outHeight, options.outWidth, true, (double) i, str2);
                        } catch (Exception e4) {
                            Log.e("rmh", "XMP err: " + e4.getMessage());
                        }
                    }
                    exifInterface = new ExifInterface(str);
                    if (c2152o != null) {
                        double n = c2152o.mo7065n();
                        double m = c2152o.mo7064m();
                        double o = c2152o.mo7066o();
                        String str5 = n > 0.0d ? "E" : "W";
                        str4 = m > 0.0d ? "N" : "S";
                        n = Math.abs(n);
                        String a = C2096g.m9322a(Math.abs(m));
                        jSONObject2 = C2096g.m9322a(n);
                        exifInterface.setAttribute("GPSLatitude", a);
                        exifInterface.setAttribute("GPSLatitudeRef", str4);
                        exifInterface.setAttribute("GPSLongitude", jSONObject2);
                        exifInterface.setAttribute("GPSLongitudeRef", str5);
                        exifInterface.setAttribute("GPSAltitude", String.valueOf((int) Math.abs(o)));
                        if (o < 0.0d) {
                            exifInterface.setAttribute("GPSAltitudeRef", "1");
                        } else {
                            exifInterface.setAttribute("GPSAltitudeRef", "0");
                        }
                    }
                    exifInterface.setAttribute("Orientation", str3);
                    exifInterface.saveAttributes();
                }
            } catch (FileNotFoundException e5) {
                if (fileInputStream != null) {
                }
                i = i2;
                if (i > 0) {
                }
                exifInterface = new ExifInterface(str);
                if (c2152o != null) {
                }
                exifInterface.setAttribute("Orientation", str3);
                exifInterface.saveAttributes();
            } catch (IOException e6) {
                if (fileInputStream != null) {
                }
                i = i2;
                if (i > 0) {
                }
                exifInterface = new ExifInterface(str);
                if (c2152o != null) {
                }
                exifInterface.setAttribute("Orientation", str3);
                exifInterface.saveAttributes();
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    i = i2;
                } catch (IOException e8) {
                    i = i2;
                }
                if (i > 0) {
                }
                exifInterface = new ExifInterface(str);
                if (c2152o != null) {
                }
                exifInterface.setAttribute("Orientation", str3);
                exifInterface.saveAttributes();
            }
            i = i2;
            if (i > 0) {
            }
            exifInterface = new ExifInterface(str);
            if (c2152o != null) {
            }
            exifInterface.setAttribute("Orientation", str3);
            exifInterface.saveAttributes();
        } catch (IOException e9) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    i = i2;
                } catch (IOException e10) {
                    i = i2;
                }
                if (i > 0) {
                }
                exifInterface = new ExifInterface(str);
                if (c2152o != null) {
                }
                exifInterface.setAttribute("Orientation", str3);
                exifInterface.saveAttributes();
            }
            i = i2;
            if (i > 0) {
            }
            exifInterface = new ExifInterface(str);
            if (c2152o != null) {
            }
            exifInterface.setAttribute("Orientation", str3);
            exifInterface.saveAttributes();
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e11) {
                }
            }
            throw th;
        }
        i = i2;
        if (i > 0) {
        }
        try {
            exifInterface = new ExifInterface(str);
            if (c2152o != null) {
            }
            exifInterface.setAttribute("Orientation", str3);
            exifInterface.saveAttributes();
        } catch (IOException e12) {
        }
    }

    /* renamed from: b */
    private String m8514b(String str) {
        File file = new File(str + "/" + "url.txt");
        if (!file.exists()) {
            return null;
        }
        try {
            String str2 = file.getPath();
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            if (!str2.endsWith("/")) {
                str2 = str2 + "/";
            }
            return linkedHashMap == null ? null : (String) linkedHashMap.get(str2);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: k */
    private void m8518k() {
        this.f5275t = getSharedPreferences("DMDPref", 0).getBoolean("UseExternalSdCard", false);
    }

    public void onBackPressed() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        setFinishOnTouchOutside(false);
        super.onCreate(bundle);
        setContentView((int) R.layout.export);
        this.f5270o = getIntent().getExtras().getString("extra_path");
        this.f5271p = getIntent().getExtras().getString("extra_name");
        m8518k();
        this.f5274s = (LinearLayout) findViewById(R.id.linearLayoutExport);
        String str = getExternalCacheDir().getPath() + "/" + "viewer_assets";
        Log.e("rmh", "b: " + str);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        AssetManager assets = getAssets();
        if (!new File(str + "/numbers_dg.jpg").exists()) {
            try {
                C2096g.m9321a(str + "/numbers_dg.jpg", assets.open("numbers_dg.jpg"));
            } catch (Exception e) {
            }
        }
        if (!new File(str + "/numbers_lg.jpg").exists()) {
            try {
                C2096g.m9321a(str + "/numbers_lg.jpg", assets.open("numbers_lg.jpg"));
            } catch (Exception e2) {
            }
        }
        if (!new File(str + "/gyrooff.jpg").exists()) {
            try {
                C2096g.m9321a(str + "/gyrooff.jpg", assets.open("gyrooff.jpg"));
            } catch (Exception e3) {
            }
        }
        if (!new File(str + "/gyroon.jpg").exists()) {
            try {
                C2096g.m9321a(str + "/gyroon.jpg", assets.open("gyroon.jpg"));
            } catch (Exception e4) {
            }
        }
        if (!new File(str + "/cb.raw").exists()) {
            try {
                C2096g.m9321a(str + "/cb.raw", assets.open("cb.raw"));
            } catch (Exception e5) {
            }
        }
        if (!new File(str + "/compass-dg.raw").exists()) {
            try {
                C2096g.m9321a(str + "/compass-dg.raw", assets.open("compass-dg.raw"));
            } catch (Exception e6) {
            }
        }
        File file2 = new File(this.f5270o);
        this.f5273r = new C1738r();
        View a = this.f5273r.mo6231a(this, this.f5269n, str, file2.getParentFile().getPath(), file2.getName(), getWindowManager().getDefaultDisplay().getRotation());
        a.setLayoutParams(new LayoutParams(1, 1));
        this.f5274s.addView(a);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        super.onPause();
        this.f5273r.mo6233a();
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
        this.f5273r.mo6238b();
    }

}
