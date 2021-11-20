package com.p045b.p046a;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build.VERSION;
import com.p045b.p046a.C1506j.C1507a;
import com.p045b.p046a.C1506j.C1508b;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.b.a.ad */
public class C1509ad implements C1506j {
    /* renamed from: a */
    static volatile Object f4135a;
    /* renamed from: b */
    private static final Object f4136b = new Object();
    /* renamed from: c */
    private static final ThreadLocal<StringBuilder> f4137c = new C15041();
    /* renamed from: d */
    private final Context f4138d;

    /* renamed from: com.b.a.ad$1 */
    static class C15041 extends ThreadLocal<StringBuilder> {
        C15041() {
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    }

    /* renamed from: com.b.a.ad$a */
    private static class C1505a {
        /* renamed from: a */
        static Object m7369a(Context context) throws IOException {
            File b = C1516ae.m7397b(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(b, C1516ae.m7382a(b)) : installed;
        }
    }

    public C1509ad(Context context) {
        this.f4138d = context.getApplicationContext();
    }

    /* renamed from: a */
    private static void m7374a(Context context) {
        if (f4135a == null) {
            try {
                synchronized (f4136b) {
                    if (f4135a == null) {
                        f4135a = C1505a.m7369a(context);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public C1507a mo5676a(Uri uri, int i) throws IOException {
        if (VERSION.SDK_INT >= 14) {
            C1509ad.m7374a(this.f4138d);
        }
        HttpURLConnection a = mo5680a(uri);
        a.setUseCaches(true);
        if (i != 0) {
            String str;
            if (C1546q.m7512c(i)) {
                str = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder stringBuilder = (StringBuilder) f4137c.get();
                stringBuilder.setLength(0);
                if (!C1546q.m7510a(i)) {
                    stringBuilder.append("no-cache");
                }
                if (!C1546q.m7511b(i)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append("no-store");
                }
                str = stringBuilder.toString();
            }
            a.setRequestProperty("Cache-Control", str);
        }
        int responseCode = a.getResponseCode();
        if (responseCode >= 300) {
            a.disconnect();
            throw new C1508b(responseCode + " " + a.getResponseMessage(), i, responseCode);
        }
        long headerFieldInt = (long) a.getHeaderFieldInt("Content-Length", -1);
        return new C1507a(a.getInputStream(), C1516ae.m7396a(a.getHeaderField("X-Android-Response-Source")), headerFieldInt);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public HttpURLConnection mo5680a(Uri uri) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }
}
