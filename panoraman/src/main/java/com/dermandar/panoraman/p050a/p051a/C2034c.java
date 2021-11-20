package com.dermandar.panoraman.p050a.p051a;

import android.content.Intent;
import android.util.Log;
import org.json.JSONException;

/* renamed from: ir.vira.panoraman.a.a.c */
public class C2034c {
    /* renamed from: a */
    boolean f6035a;
    /* renamed from: b */
    String f6036b;
    /* renamed from: c */
    boolean f6037c;
    /* renamed from: d */
    boolean f6038d;
    /* renamed from: e */
    boolean f6039e;
    /* renamed from: f */
    String f6040f;
    /* renamed from: g */
    int f6041g;
    /* renamed from: h */
    String f6042h;
    /* renamed from: i */
    String f6043i;
    /* renamed from: j */
    C1915a f6044j;

    /* renamed from: ir.vira.panoraman.a.a.c$b */
    public interface C1912b {
    }

    /* renamed from: ir.vira.panoraman.a.a.c$a */
    public interface C1915a {
        /* renamed from: a */
        void mo6539a(C2035d c2035d, C2036e c2036e);
    }

    /* renamed from: a */
    public static String m9124a(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i > -1000) {
            return (i < 0 || i >= split.length) ? String.valueOf(i) + ":Unknown" : split[i];
        } else {
            int i2 = -1000 - i;
            return (i2 < 0 || i2 >= split2.length) ? String.valueOf(i) + ":Unknown IAB Helper Error" : split2[i2];
        }
    }

    /* renamed from: b */
    private void m9125b() {
        if (this.f6038d) {
            throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public int mo6767a(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            mo6772c("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            mo6772c("Unexpected type for intent response code.");
            mo6772c(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
        }
    }

    /* renamed from: a */
    public void mo6768a() {
        mo6771b("Ending async operation: " + this.f6040f);
        this.f6040f = "";
        this.f6039e = false;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo6769a(String str) {
        if (!this.f6037c) {
            mo6772c("Illegal state for operation (" + str + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
        }
    }

    /* renamed from: a */
    public boolean mo6770a(int i, int i2, Intent intent) {
        if (i != this.f6041g) {
            return false;
        }
        m9125b();
        mo6769a("handleActivityResult");
        mo6768a();
        C2035d c2035d;
        if (intent == null) {
            mo6772c("Null data in IAB activity result.");
            c2035d = new C2035d(-1002, "Null data in IAB result");
            if (this.f6044j != null) {
                this.f6044j.mo6539a(c2035d, null);
            }
            return true;
        }
        int a = mo6767a(intent);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (i2 == -1 && a == 0) {
            mo6771b("Successful resultcode from purchase activity.");
            mo6771b("Purchase data: " + stringExtra);
            mo6771b("Data signature: " + stringExtra2);
            mo6771b("Extras: " + intent.getExtras());
            mo6771b("Expected item type: " + this.f6042h);
            if (stringExtra == null || stringExtra2 == null) {
                mo6772c("BUG: either purchaseData or dataSignature is null.");
                mo6771b("Extras: " + intent.getExtras().toString());
                c2035d = new C2035d(-1008, "IAB returned null purchaseData or dataSignature");
                if (this.f6044j != null) {
                    this.f6044j.mo6539a(c2035d, null);
                }
                return true;
            }
            try {
                C2036e c2036e = new C2036e(this.f6042h, stringExtra, stringExtra2);
                String a2 = c2036e.mo6777a();
                if (C2037f.m9137a(this.f6043i, stringExtra, stringExtra2)) {
                    mo6771b("Purchase signature successfully verified.");
                    if (this.f6044j != null) {
                        this.f6044j.mo6539a(new C2035d(0, "Success"), c2036e);
                    }
                } else {
                    mo6772c("Purchase signature verification FAILED for sku " + a2);
                    c2035d = new C2035d(-1003, "Signature verification failed for sku " + a2);
                    if (this.f6044j != null) {
                        this.f6044j.mo6539a(c2035d, c2036e);
                    }
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                mo6772c("Failed to parse purchase data.");
                e.printStackTrace();
                c2035d = new C2035d(-1002, "Failed to parse purchase data.");
                if (this.f6044j != null) {
                    this.f6044j.mo6539a(c2035d, null);
                }
                return true;
            }
        } else if (i2 == -1) {
            mo6771b("Result code was OK but in-app billing response was not OK: " + C2034c.m9124a(a));
            if (this.f6044j != null) {
                this.f6044j.mo6539a(new C2035d(a, "Problem purchashing item."), null);
            }
        } else if (i2 == 0) {
            mo6771b("Purchase canceled - Response: " + C2034c.m9124a(a));
            c2035d = new C2035d(-1005, "User canceled.");
            if (this.f6044j != null) {
                this.f6044j.mo6539a(c2035d, null);
            }
        } else {
            mo6772c("Purchase failed. Result code: " + Integer.toString(i2) + ". Response: " + C2034c.m9124a(a));
            c2035d = new C2035d(-1006, "Unknown purchase response.");
            if (this.f6044j != null) {
                this.f6044j.mo6539a(c2035d, null);
            }
        }
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo6771b(String str) {
        if (this.f6035a) {
            Log.d(this.f6036b, str);
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo6772c(String str) {
        Log.e(this.f6036b, "In-app billing error: " + str);
    }
}
