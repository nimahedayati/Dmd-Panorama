package com.p045b.p046a;

import android.content.Context;
import android.net.Uri;
import com.p045b.p046a.C1506j.C1507a;
import com.p045b.p046a.C1506j.C1508b;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.CacheControl.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.b.a.s */
public class C1549s implements C1506j {
    /* renamed from: a */
    private final OkHttpClient f4233a;

    public C1549s(Context context) {
        this(C1516ae.m7397b(context));
    }

    public C1549s(OkHttpClient okHttpClient) {
        this.f4233a = okHttpClient;
    }

    public C1549s(File file) {
        this(file, C1516ae.m7382a(file));
    }

    public C1549s(File file, long j) {
        this(C1549s.m7518a());
        try {
            this.f4233a.setCache(new Cache(file, j));
        } catch (IOException e) {
        }
    }

    /* renamed from: a */
    private static OkHttpClient m7518a() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(20000, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(20000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    /* renamed from: a */
    public C1507a mo5676a(Uri uri, int i) throws IOException {
        CacheControl cacheControl = null;
        if (i != 0) {
            if (C1546q.m7512c(i)) {
                cacheControl = CacheControl.FORCE_CACHE;
            } else {
                Builder builder = new Builder();
                if (!C1546q.m7510a(i)) {
                    builder.noCache();
                }
                if (!C1546q.m7511b(i)) {
                    builder.noStore();
                }
                cacheControl = builder.build();
            }
        }
        Request.Builder url = new Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        Response execute = this.f4233a.newCall(url.build()).execute();
        int code = execute.code();
        if (code >= 300) {
            execute.body().close();
            throw new C1508b(code + " " + execute.message(), i, code);
        }
        boolean z = execute.cacheResponse() != null;
        ResponseBody body = execute.body();
        return new C1507a(body.byteStream(), z, body.contentLength());
    }
}
