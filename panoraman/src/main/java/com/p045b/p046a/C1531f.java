package com.p045b.p046a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import com.p045b.p046a.C1517y.C1518a;
import com.p045b.p046a.C1559t.C1555d;

import java.io.FileNotFoundException;
import java.io.InputStream;

/* renamed from: com.b.a.f */
class C1531f extends C1517y {
    /* renamed from: a */
    private static final UriMatcher f4175a = new UriMatcher(-1);
    /* renamed from: b */
    private final Context f4176b;

    @TargetApi(14)
    /* renamed from: com.b.a.f$a */
    private static class C1530a {
        /* renamed from: a */
        static InputStream m7457a(ContentResolver contentResolver, Uri uri) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        f4175a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f4175a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f4175a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f4175a.addURI("com.android.contacts", "contacts/#", 3);
        f4175a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    C1531f(Context context) {
        this.f4176b = context;
    }

    /* renamed from: b */
    private InputStream m7458b(C1565w c1565w) throws FileNotFoundException {
        ContentResolver contentResolver = this.f4176b.getContentResolver();
        Uri uri = c1565w.f4303d;
        switch (f4175a.match(uri)) {
            case 1:
                uri = Contacts.lookupContact(contentResolver, uri);
                if (uri == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(uri);
            case 3:
                break;
            default:
                throw new IllegalStateException("Invalid uri: " + uri);
        }
        return VERSION.SDK_INT < 14 ? Contacts.openContactPhotoInputStream(contentResolver, uri) : C1530a.m7457a(contentResolver, uri);
    }

    /* renamed from: a */
    public C1518a mo5685a(C1565w c1565w, int i) throws FileNotFoundException {
        InputStream b = m7458b(c1565w);
        return b != null ? new C1518a(b, C1555d.DISK) : null;
    }

    /* renamed from: a */
    public boolean mo5686a(C1565w c1565w) {
        Uri uri = c1565w.f4303d;
        return "content".equals(uri.getScheme()) && Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f4175a.match(c1565w.f4303d) != -1;
    }
}
