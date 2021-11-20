package com.dermandar.panoraman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: ir.vira.panoraman.o */
public class C2152o implements Serializable, Comparable<C2152o> {
    /* renamed from: a */
    private LinkedHashMap<String, String> f6510a;
    /* renamed from: b */
    private SimpleDateFormat f6511b = new SimpleDateFormat("yyMMdd_HHmmss");
    /* renamed from: c */
    private String f6512c;
    /* renamed from: d */
    private String f6513d;
    /* renamed from: e */
    private List<String> f6514e;
    /* renamed from: f */
    private double f6515f;
    /* renamed from: g */
    private double f6516g;
    /* renamed from: h */
    private double f6517h;
    /* renamed from: i */
    private double f6518i;
    /* renamed from: j */
    private long f6519j;
    /* renamed from: k */
    private String f6520k;
    /* renamed from: l */
    private String f6521l;
    /* renamed from: m */
    private String f6522m;
    /* renamed from: n */
    private String f6523n;
    /* renamed from: o */
    private String f6524o;
    /* renamed from: p */
    private String f6525p;
    /* renamed from: q */
    private String f6526q;
    /* renamed from: r */
    private String f6527r;
    /* renamed from: s */
    private String f6528s;

    public C2152o(String str, String str2) {
        this.f6526q = str;
        this.f6527r = str2;
        if (this.f6527r.endsWith("/")) {
            this.f6528s = this.f6527r + this.f6526q;
        } else {
            this.f6528s = this.f6527r + "/" + this.f6526q;
        }
    }

    /* renamed from: a */
    public int compareTo(C2152o c2152o) {
        if (c2152o == null) {
            return -1;
        }
        Date r = mo7069r();
        Date r2 = c2152o.mo7069r();
        return (r == null && r2 == null) ? 0 : (r == null || r2 != null) ? (r != null || r2 == null) ? !r.after(r2) ? 1 : -1 : 1 : -1;
    }

    /* renamed from: a */
    public String mo7045a() {
        return this.f6520k;
    }

    /* renamed from: a */
    public void mo7046a(double d) {
        this.f6515f = d;
    }

    /* renamed from: a */
    public void mo7047a(String str) {
        this.f6512c = str;
    }

    /* renamed from: b */
    public String mo7048b() {
        return this.f6521l;
    }

    /* renamed from: b */
    public void mo7049b(double d) {
        this.f6516g = d;
    }

    /* renamed from: b */
    public void mo7050b(String str) {
        this.f6513d = str;
    }

    /* renamed from: c */
    public String mo7051c() {
        return this.f6522m;
    }

    /* renamed from: c */
    public void mo7052c(double d) {
        this.f6517h = d;
    }

    /* renamed from: c */
    public void mo7053c(String str) {
        this.f6514e = C2096g.m9340d(str);
    }

    /* renamed from: d */
    public String mo7055d() {
        return this.f6523n;
    }

    /* renamed from: e */
    public String mo7056e() {
        return this.f6524o;
    }

    /* renamed from: f */
    public String mo7057f() {
        return this.f6525p;
    }

    /* renamed from: g */
    public String mo7058g() {
        return this.f6526q;
    }

    /* renamed from: h */
    public String mo7059h() {
        return this.f6527r;
    }

    /* renamed from: i */
    public String mo7060i() {
        return this.f6528s;
    }

    /* renamed from: j */
    public String mo7061j() {
        return this.f6512c;
    }

    /* renamed from: k */
    public String mo7062k() {
        return this.f6513d;
    }

    /* renamed from: l */
    public List<String> mo7063l() {
        return this.f6514e;
    }

    /* renamed from: m */
    public double mo7064m() {
        return this.f6515f;
    }

    /* renamed from: n */
    public double mo7065n() {
        return this.f6516g;
    }

    /* renamed from: o */
    public double mo7066o() {
        return this.f6517h;
    }

    /* renamed from: p */
    public double mo7067p() {
        return this.f6518i;
    }

    /* renamed from: q */
    public long mo7068q() {
        return this.f6519j;
    }

    /* renamed from: r */
    public Date mo7069r() {
        try {
            if (this.f6526q.length() == 13) {
                return this.f6511b.parse(this.f6526q);
            }
            throw new Exception();
        } catch (Exception e) {
            return new Date(new File(this.f6527r).lastModified());
        }
    }

    /* renamed from: s */
    public void mo7070s() {
        File file = new File(this.f6527r + "/other.txt");
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                this.f6510a = (LinkedHashMap) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
            }
        } else {
            this.f6510a = new LinkedHashMap();
        }
        this.f6512c = C2096g.m9326a((String) this.f6510a.get("loc_name"), "Untitled");
        this.f6513d = C2096g.m9326a((String) this.f6510a.get("loc_desc"), "");
        this.f6514e = C2096g.m9340d(C2096g.m9326a((String) this.f6510a.get("loc_tags"), ""));
        this.f6515f = C2096g.m9332b(C2096g.m9326a((String) this.f6510a.get("latitude"), "0.0"));
        this.f6516g = C2096g.m9332b(C2096g.m9326a((String) this.f6510a.get("longitude"), "0.0"));
        this.f6517h = C2096g.m9332b(C2096g.m9326a((String) this.f6510a.get("altitude"), "0.0"));
        this.f6518i = C2096g.m9332b(C2096g.m9326a((String) this.f6510a.get("heading"), "-1"));
        this.f6519j = C2096g.m9337c(C2096g.m9326a((String) this.f6510a.get("ctime"), "0"));
        this.f6520k = C2096g.m9326a((String) this.f6510a.get("device_model"), "");
        this.f6521l = C2096g.m9326a((String) this.f6510a.get("device_osname"), "");
        this.f6523n = C2096g.m9326a((String) this.f6510a.get("device_machname"), "");
        this.f6524o = C2096g.m9326a((String) this.f6510a.get("device_hwmodel"), "");
        this.f6525p = C2096g.m9326a((String) this.f6510a.get("app_version"), "");
    }

    /* renamed from: t */
    public void mo7071t() {
        if (this.f6510a != null) {
            this.f6510a.put("loc_name", this.f6512c);
            this.f6510a.put("loc_desc", this.f6513d);
            this.f6510a.put("loc_tags", C2096g.m9327a(this.f6514e));
            this.f6510a.put("latitude", this.f6515f + "");
            this.f6510a.put("longitude", this.f6516g + "");
            this.f6510a.put("altitude", this.f6517h + "");
            this.f6510a.put("heading", this.f6518i + "");
            this.f6510a.put("ctime", this.f6519j + "");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f6527r + "/other.txt"), false);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(this.f6510a);
                objectOutputStream.flush();
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
            }
        }
    }
}
