package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.format.DateFormat;
import android.view.View;

import java.util.Date;

public class FastlabelText extends View{
//    static {
//        System.loadLibrary("FastDraw");
//    }
    public FastlabelText(Context context) {
        super(context);
        System.loadLibrary("FastDraw");
    }

    public final native String drawLine(Context arg1);

    public final native byte[] drawText(byte[] arg1, int arg2);

    public final native byte[] drawTextWithArray(byte[] arg1);

    public final native float fastAlpha(View arg1);

    public final native int fastDraw(Canvas arg1);

    @Override  // android.view.View
    public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener arg2) {
        this.setVisibility(View.VISIBLE);
        this.fastAlpha(((View)this));
        super.addOnAttachStateChangeListener(arg2);
    }

    @Override  // android.view.View
    protected void dispatchDraw(Canvas arg2) {
        this.setVisibility(View.VISIBLE);
        super.dispatchDraw(arg2);
    }

    @Override  // android.view.View
    public void draw(Canvas arg2) {
        this.fastDraw(arg2);
        this.fastAlpha(((View)this));
        super.draw(arg2);
    }
    @Override  // android.view.View
    public CharSequence getAccessibilityPaneTitle() {
        return super.getAccessibilityPaneTitle();
    }

    public static String a(String arg1) {
        return DateFormat.format(arg1, new Date()).toString();
    }

    @Override  // android.view.View
    public float getX() {
        a("yyyy-MM-dd");
        return super.getX();
    }

    @Override  // android.view.View
    public boolean isClickable() {
        Context v0 = this.getContext();
        //g.a(v0, "context");
        return this.init(v0);
    }

    public final native boolean isVisible();
    public final native boolean init(Context arg1);

    @Override  // android.view.View
    public void setAccessibilityDelegate(View.AccessibilityDelegate arg2) {
        this.setVisibility(View.VISIBLE);
        super.setAccessibilityDelegate(arg2);
    }

}
