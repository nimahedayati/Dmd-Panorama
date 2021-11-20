package com.dermandar.panoraman.p050a.p051a;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.dermandar.panoraman.a.a.e */
public class C2036e {
    /* renamed from: a */
    String f6047a;
    /* renamed from: b */
    String f6048b;
    /* renamed from: c */
    String f6049c;
    /* renamed from: d */
    String f6050d;
    /* renamed from: e */
    long f6051e;
    /* renamed from: f */
    int f6052f;
    /* renamed from: g */
    String f6053g;
    /* renamed from: h */
    String f6054h;
    /* renamed from: i */
    String f6055i;
    /* renamed from: j */
    String f6056j;

    public C2036e(String str, String str2, String str3) throws JSONException {
        this.f6047a = str;
        this.f6055i = str2;
        JSONObject jSONObject = new JSONObject(this.f6055i);
        this.f6048b = jSONObject.optString("orderId");
        this.f6049c = jSONObject.optString("packageName");
        this.f6050d = jSONObject.optString("productId");
        this.f6051e = jSONObject.optLong("purchaseTime");
        this.f6052f = jSONObject.optInt("purchaseState");
        this.f6053g = jSONObject.optString("developerPayload");
        this.f6054h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.f6056j = str3;
    }

    /* renamed from: a */
    public String mo6777a() {
        return this.f6050d;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.f6047a + "):" + this.f6055i;
    }
}
