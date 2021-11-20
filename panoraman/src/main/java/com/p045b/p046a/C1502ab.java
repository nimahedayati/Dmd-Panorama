package com.p045b.p046a;

import java.io.PrintWriter;

/* renamed from: com.b.a.ab */
public class C1502ab {
    /* renamed from: a */
    public final int f4115a;
    /* renamed from: b */
    public final int f4116b;
    /* renamed from: c */
    public final long f4117c;
    /* renamed from: d */
    public final long f4118d;
    /* renamed from: e */
    public final long f4119e;
    /* renamed from: f */
    public final long f4120f;
    /* renamed from: g */
    public final long f4121g;
    /* renamed from: h */
    public final long f4122h;
    /* renamed from: i */
    public final long f4123i;
    /* renamed from: j */
    public final long f4124j;
    /* renamed from: k */
    public final int f4125k;
    /* renamed from: l */
    public final int f4126l;
    /* renamed from: m */
    public final int f4127m;
    /* renamed from: n */
    public final long f4128n;

    public C1502ab(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f4115a = i;
        this.f4116b = i2;
        this.f4117c = j;
        this.f4118d = j2;
        this.f4119e = j3;
        this.f4120f = j4;
        this.f4121g = j5;
        this.f4122h = j6;
        this.f4123i = j7;
        this.f4124j = j8;
        this.f4125k = i3;
        this.f4126l = i4;
        this.f4127m = i5;
        this.f4128n = j9;
    }

    /* renamed from: a */
    public void mo5670a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f4115a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f4116b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f4116b) / ((float) this.f4115a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f4117c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f4118d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f4125k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f4119e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f4122h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f4126l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f4120f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f4127m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f4121g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f4123i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f4124j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f4115a + ", size=" + this.f4116b + ", cacheHits=" + this.f4117c + ", cacheMisses=" + this.f4118d + ", downloadCount=" + this.f4125k + ", totalDownloadSize=" + this.f4119e + ", averageDownloadSize=" + this.f4122h + ", totalOriginalBitmapSize=" + this.f4120f + ", totalTransformedBitmapSize=" + this.f4121g + ", averageOriginalBitmapSize=" + this.f4123i + ", averageTransformedBitmapSize=" + this.f4124j + ", originalBitmapCount=" + this.f4126l + ", transformedBitmapCount=" + this.f4127m + ", timeStamp=" + this.f4128n + '}';
    }
}
