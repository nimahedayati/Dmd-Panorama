package com.p045b.p046a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import com.p045b.p046a.C1517y.C1518a;
import com.p045b.p046a.C1559t.C1555d;

/* renamed from: com.b.a.o */
class C1544o extends C1532g {
    /* renamed from: b */
    private static final String[] f4221b = new String[]{"orientation"};

    /* renamed from: com.b.a.o$a */
    enum C1543a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        
        /* renamed from: d */
        final int f4218d;
        /* renamed from: e */
        final int f4219e;
        /* renamed from: f */
        final int f4220f;

        private C1543a(int i, int i2, int i3) {
            this.f4218d = i;
            this.f4219e = i2;
            this.f4220f = i3;
        }
    }

    C1544o(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static int m7504a(ContentResolver contentResolver, Uri uri) throws Throwable {
        Cursor cursor;
        Throwable th;
        Cursor query;
        try {
            query = contentResolver.query(uri, f4221b, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(0);
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (RuntimeException e) {
                    cursor = query;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException e2) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return 0;
    }

    /* renamed from: a */
    static C1543a m7505a(int i, int i2) {
        return (i > C1543a.MICRO.f4219e || i2 > C1543a.MICRO.f4220f) ? (i > C1543a.MINI.f4219e || i2 > C1543a.MINI.f4220f) ? C1543a.FULL : C1543a.MINI : C1543a.MICRO;
    }

    /* renamed from: a */
    public C1518a mo5685a(C1565w c1565w, int i) throws Throwable {
        ContentResolver contentResolver = this.f4177a.getContentResolver();
        int a = C1544o.m7504a(contentResolver, c1565w.f4303d);
        String type = contentResolver.getType(c1565w.f4303d);
        Object obj = (type == null || !type.startsWith("video/")) ? null : 1;
        if (c1565w.mo5793d()) {
            C1543a a2 = C1544o.m7505a(c1565w.f4307h, c1565w.f4308i);
            if (obj == null && a2 == C1543a.FULL) {
                return new C1518a(null, mo5723b(c1565w), C1555d.DISK, a);
            }
            Bitmap thumbnail;
            long parseId = ContentUris.parseId(c1565w.f4303d);
            Options c = C1517y.m7407c(c1565w);
            c.inJustDecodeBounds = true;
            C1517y.m7404a(c1565w.f4307h, c1565w.f4308i, a2.f4219e, a2.f4220f, c, c1565w);
            if (obj != null) {
                thumbnail = Thumbnails.getThumbnail(contentResolver, parseId, a2 == C1543a.FULL ? 1 : a2.f4218d, c);
            } else {
                thumbnail = Images.Thumbnails.getThumbnail(contentResolver, parseId, a2.f4218d, c);
            }
            if (thumbnail != null) {
                return new C1518a(thumbnail, null, C1555d.DISK, a);
            }
        }
        return new C1518a(null, mo5723b(c1565w), C1555d.DISK, a);
    }

    /* renamed from: a */
    public boolean mo5686a(C1565w c1565w) {
        Uri uri = c1565w.f4303d;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }
}
