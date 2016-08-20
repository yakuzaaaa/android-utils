/*
 * The default cardview has problem of adding a padding in below api 21 devices.
 * This implementation removes the padding but at the cost of elevation like look
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class LemonadeCardView extends CardView {

    public LemonadeCardView(Context context) {
        super(context);
        init();
    }

    public LemonadeCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LemonadeCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Optional: Prevent pre-L from adding inner card padding
        setPreventCornerOverlap(false);
        // Optional: make Lollipop and above add shadow padding to match pre-L padding
        setUseCompatPadding(true);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        // FIX shadow padding
        if (params instanceof MarginLayoutParams) {
            MarginLayoutParams layoutParams = (MarginLayoutParams) params;
            layoutParams.bottomMargin -= (getPaddingBottom() - getContentPaddingBottom());
            layoutParams.leftMargin -= (getPaddingLeft() - getContentPaddingLeft());
            layoutParams.rightMargin -= (getPaddingRight() - getContentPaddingRight());
            layoutParams.topMargin -= (getPaddingTop() - getContentPaddingTop());
        }

        super.setLayoutParams(params);
    }
}

