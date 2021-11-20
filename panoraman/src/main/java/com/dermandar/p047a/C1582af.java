package com.dermandar.p047a;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;

/* renamed from: com.dermandar.a.af */
class C1582af implements MediaScannerConnectionClient {
    /* renamed from: a */
    private MediaScannerConnection f4405a;
    /* renamed from: b */
    private String f4406b;

    public C1582af(Context context, String str) {
        this.f4406b = str;
        this.f4405a = new MediaScannerConnection(context, this);
        if (this.f4405a != null && context != null) {
            try {
                this.f4405a.connect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onMediaScannerConnected() {
        this.f4405a.scanFile(this.f4406b, null);
    }

    public void onScanCompleted(String str, Uri uri) {
        this.f4405a.disconnect();
    }
}
