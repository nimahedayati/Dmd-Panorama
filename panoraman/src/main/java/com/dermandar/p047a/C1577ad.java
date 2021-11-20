package com.dermandar.p047a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import ir.helmik.namya.R;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.dermandar.a.ad */
class C1577ad extends C1572ac implements OnDismissListener {
    /* renamed from: f */
    private View f4351f;
    /* renamed from: g */
    private ImageView f4352g;
    /* renamed from: h */
    private ImageView f4353h;
    /* renamed from: i */
    private LayoutInflater f4354i;
    /* renamed from: j */
    private ViewGroup f4355j;
    /* renamed from: k */
    private TextView f4356k;
    /* renamed from: l */
    private ScrollView f4357l;
    /* renamed from: m */
    private C1575a f4358m;
    /* renamed from: n */
    private C1576b f4359n;
    /* renamed from: o */
    private List<C1568a> f4360o = new ArrayList();
    /* renamed from: p */
    private List<RadioButton> f4361p = new ArrayList();
    /* renamed from: q */
    private List<ImageView> f4362q = new ArrayList();
    /* renamed from: r */
    private List<TextView> f4363r = new ArrayList();
    /* renamed from: s */
    private List<LinearLayout> f4364s = new ArrayList();
    /* renamed from: t */
    private boolean f4365t;
    /* renamed from: u */
    private int f4366u;
    /* renamed from: v */
    private int f4367v;
    /* renamed from: w */
    private int f4368w;
    /* renamed from: x */
    private int f4369x = 0;
    /* renamed from: y */
    private boolean f4370y = false;

    /* renamed from: com.dermandar.a.ad$2 */
    class C15742 implements Runnable {
        C15742() {
        }

        public void run() {
            C1577ad.this.f4357l.fullScroll(130);
        }
    }

    /* renamed from: com.dermandar.a.ad$a */
    public interface C1575a {
        /* renamed from: a */
        void mo5823a(C1577ad c1577ad, int i, int i2);
    }

    /* renamed from: com.dermandar.a.ad$b */
    public interface C1576b {
        /* renamed from: a */
        void mo5824a();
    }

    public C1577ad(Context context) {
        super(context);
        this.f4354i = (LayoutInflater) context.getSystemService("layout_inflater");
        mo5830b(R.layout.popup_vertical);
        this.f4368w = 5;
        this.f4367v = 1;
        this.f4366u = 1;
    }

    /* renamed from: a */
    private void m7595a(int i, int i2) {
        View view = i == R.id.arrow_up ? this.f4352g : this.f4353h;
        View view2 = i == R.id.arrow_up ? this.f4353h : this.f4352g;
        int measuredWidth = this.f4352g.getMeasuredWidth();
        view.setVisibility(0);
        ((MarginLayoutParams) view.getLayoutParams()).leftMargin = i2 - (measuredWidth / 2);
        view2.setVisibility(4);
    }

    /* renamed from: a */
    private void m7596a(int i, int i2, boolean z) {
        int measuredWidth = i2 - (this.f4352g.getMeasuredWidth() / 2);
        switch (this.f4368w) {
            case 1:
                this.f4343b.setAnimationStyle(z ? R.style.Animations_PopUpMenu_Left : R.style.Animations_PopDownMenu_Left);
                return;
            case 2:
                this.f4343b.setAnimationStyle(z ? R.style.Animations_PopUpMenu_Right : R.style.Animations_PopDownMenu_Right);
                return;
            case 3:
                this.f4343b.setAnimationStyle(z ? R.style.Animations_PopUpMenu_Center : R.style.Animations_PopDownMenu_Center);
                return;
            case 4:
                this.f4343b.setAnimationStyle(z ? R.style.Animations_PopUpMenu_Reflect : R.style.Animations_PopDownMenu_Reflect);
                return;
            case 5:
                if (measuredWidth <= i / 4) {
                    this.f4343b.setAnimationStyle(z ? R.style.Animations_PopUpMenu_Left : R.style.Animations_PopDownMenu_Left);
                    return;
                } else if (measuredWidth <= i / 4 || measuredWidth >= (i / 4) * 3) {
                    this.f4343b.setAnimationStyle(z ? R.style.Animations_PopUpMenu_Right : R.style.Animations_PopDownMenu_Right);
                    return;
                } else {
                    this.f4343b.setAnimationStyle(z ? R.style.Animations_PopUpMenu_Center : R.style.Animations_PopDownMenu_Center);
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: g */
    private void m7599g() {
        if (this.f4356k.getParent() != null) {
            ((ViewGroup) this.f4356k.getParent()).removeView(this.f4356k);
            this.f4355j.addView(this.f4356k, 0);
            this.f4356k.setPaintFlags(this.f4356k.getPaintFlags() | 8);
        }
    }

    /* renamed from: a */
    public C1568a mo5825a(int i) {
        return (C1568a) this.f4360o.get(i - 1);
    }

    /* renamed from: a */
    public void mo5826a(C1568a c1568a) {
        this.f4360o.add(c1568a);
        String b = c1568a.mo5808b();
        Drawable c = c1568a.mo5809c();
        boolean g = c1568a.mo5814g();
        LinearLayout linearLayout = new LinearLayout(this.f4342a);
        linearLayout.setOrientation(0);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        if (this.f4370y) {
            layoutParams.topMargin = 3;
            layoutParams.bottomMargin = 3;
        }
        linearLayout.setLayoutParams(layoutParams);
        RadioButton radioButton = new RadioButton(this.f4342a);
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        radioButton.setLayoutParams(layoutParams2);
        ImageView imageView = new ImageView(this.f4342a);
        LayoutParams layoutParams3 = new LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        imageView.setLayoutParams(layoutParams3);
        TextView textView = new TextView(this.f4342a);
        LayoutParams layoutParams4 = new LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        textView.setTextColor(-1);
        if (this.f4370y) {
            layoutParams4.leftMargin = 5;
        }
        textView.setLayoutParams(layoutParams4);
        this.f4361p.add(radioButton);
        this.f4363r.add(textView);
        this.f4362q.add(imageView);
        if (c != null) {
            imageView.setImageDrawable(c);
        } else {
            imageView.setVisibility(8);
        }
        if (b != null) {
            textView.setText(b);
        } else {
            textView.setVisibility(8);
        }
        if (g) {
            radioButton.setChecked(g);
        }
        final int i = this.f4366u;
        final int e = c1568a.mo5812e();
        OnClickListener c15731 = new OnClickListener() {
            public void onClick(View view) {
                if (C1577ad.this.f4358m != null) {
                    C1577ad.this.f4358m.mo5823a(C1577ad.this, i, e);
                }
                if (!C1577ad.this.mo5825a(i).mo5813f()) {
                    C1577ad.this.f4365t = true;
                    C1577ad.this.mo5819c();
                }
            }
        };
        linearLayout.setOnClickListener(c15731);
        radioButton.setOnClickListener(c15731);
        imageView.setOnClickListener(c15731);
        textView.setOnClickListener(c15731);
        linearLayout.setFocusable(true);
        linearLayout.setClickable(true);
        linearLayout.addView(radioButton);
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        this.f4355j.addView(linearLayout, this.f4367v);
        this.f4366u++;
        this.f4367v++;
        this.f4364s.add(linearLayout);
        m7599g();
    }

    /* renamed from: a */
    public void mo5827a(C1575a c1575a) {
        this.f4358m = c1575a;
    }

    /* renamed from: a */
    public void mo5828a(String str) {
        if (this.f4356k == null) {
            return;
        }
        if (str == null || str.isEmpty()) {
            this.f4356k.setVisibility(8);
            this.f4356k.setText("");
            return;
        }
        this.f4356k.setText(str);
        this.f4356k.setVisibility(0);
    }

    /* renamed from: a */
    public void mo5829a(boolean z) {
        this.f4370y = z;
    }

    /* renamed from: b */
    public void mo5830b(int i) {
        this.f4351f = (ViewGroup) this.f4354i.inflate(i, null);
        this.f4355j = (ViewGroup) this.f4351f.findViewById(R.id.tracks);
        this.f4356k = (TextView) this.f4351f.findViewById(R.id.title_mine);
        this.f4353h = (ImageView) this.f4351f.findViewById(R.id.arrow_down);
        this.f4352g = (ImageView) this.f4351f.findViewById(R.id.arrow_up);
        this.f4357l = (ScrollView) this.f4351f.findViewById(R.id.scroller);
        this.f4355j.setBackgroundColor(-10066330);
        this.f4356k.setBackgroundColor(-11711155);
        this.f4356k.setTextColor(-16777216);
        this.f4351f.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        mo5817a(this.f4351f);
    }

    /* renamed from: b */
    public void mo5831b(View view) {
        int width;
        int i;
        mo5818b();
        this.f4365t = false;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        this.f4351f.measure(-2, -2);
        int measuredHeight = this.f4351f.getMeasuredHeight();
        if (this.f4369x == 0) {
            this.f4369x = this.f4351f.getMeasuredWidth();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f4346e.getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        if (rect.left + this.f4369x > i2) {
            width = rect.left - (this.f4369x - view.getWidth());
            if (width < 0) {
                width = 0;
            }
            i = width;
            width = rect.centerX() - width;
        } else {
            width = view.getWidth() > this.f4369x ? rect.centerX() - (this.f4369x / 2) : rect.left;
            i = width;
            width = rect.centerX() - width;
        }
        int i4 = rect.top;
        int i5 = i3 - rect.bottom;
        boolean z = i4 > i5;
        if (!z) {
            int i6 = rect.bottom;
            if (measuredHeight > i5) {
                this.f4357l.getLayoutParams().height = i5;
            }
            measuredHeight = i6;
        } else if (measuredHeight > i4) {
            this.f4357l.getLayoutParams().height = i4 - view.getHeight();
            measuredHeight = 15;
        } else {
            measuredHeight = rect.top - measuredHeight;
        }
        m7595a(z ? R.id.arrow_down : R.id.arrow_up, width);
        m7596a(i2, rect.centerX(), z);
        this.f4343b.showAtLocation(view, 0, i, measuredHeight);
        this.f4357l.post(new C15742());
    }

    /* renamed from: c */
    public void mo5832c(int i) {
        this.f4368w = i;
    }

    /* renamed from: d */
    public List<C1568a> mo5833d() {
        return this.f4360o;
    }

    /* renamed from: e */
    public void mo5834e() {
        this.f4360o.clear();
        this.f4361p.clear();
        this.f4362q.clear();
        this.f4363r.clear();
        for (LinearLayout removeView : this.f4364s) {
            this.f4355j.removeView(removeView);
        }
        this.f4364s.clear();
        this.f4367v = 1;
        this.f4366u = 1;
        m7599g();
    }

    /* renamed from: f */
    public List<RadioButton> mo5835f() {
        return this.f4361p;
    }

    public void onDismiss() {
        if (!this.f4365t && this.f4359n != null) {
            this.f4359n.mo5824a();
        }
    }
}
