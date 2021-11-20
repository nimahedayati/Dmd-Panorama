package com.p045b.p046a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.b.a.n */
final class C1542n extends InputStream {
    /* renamed from: a */
    private final InputStream f4209a;
    /* renamed from: b */
    private long f4210b;
    /* renamed from: c */
    private long f4211c;
    /* renamed from: d */
    private long f4212d;
    /* renamed from: e */
    private long f4213e;

    public C1542n(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public C1542n(InputStream inputStream, int i) {
        this.f4213e = -1;
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, i);
        }
        this.f4209a = inputStream;
    }

    /* renamed from: a */
    private void m7500a(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f4209a.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    /* renamed from: b */
    private void m7501b(long j) {
        try {
            if (this.f4211c >= this.f4210b || this.f4210b > this.f4212d) {
                this.f4211c = this.f4210b;
                this.f4209a.mark((int) (j - this.f4210b));
            } else {
                this.f4209a.reset();
                this.f4209a.mark((int) (j - this.f4211c));
                m7500a(this.f4211c, this.f4210b);
            }
            this.f4212d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    /* renamed from: a */
    public long mo5748a(int i) {
        long j = this.f4210b + ((long) i);
        if (this.f4212d < j) {
            m7501b(j);
        }
        return this.f4210b;
    }

    /* renamed from: a */
    public void mo5749a(long j) throws IOException {
        if (this.f4210b > this.f4212d || j < this.f4211c) {
            throw new IOException("Cannot reset");
        }
        this.f4209a.reset();
        m7500a(this.f4211c, j);
        this.f4210b = j;
    }

    public int available() throws IOException {
        return this.f4209a.available();
    }

    public void close() throws IOException {
        this.f4209a.close();
    }

    public void mark(int i) {
        this.f4213e = mo5748a(i);
    }

    public boolean markSupported() {
        return this.f4209a.markSupported();
    }

    public int read() throws IOException {
        int read = this.f4209a.read();
        if (read != -1) {
            this.f4210b++;
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        int read = this.f4209a.read(bArr);
        if (read != -1) {
            this.f4210b += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f4209a.read(bArr, i, i2);
        if (read != -1) {
            this.f4210b += (long) read;
        }
        return read;
    }

    public void reset() throws IOException {
        mo5749a(this.f4213e);
    }

    public long skip(long j) throws IOException {
        long skip = this.f4209a.skip(j);
        this.f4210b += skip;
        return skip;
    }
}
