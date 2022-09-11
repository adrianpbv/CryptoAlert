package com.example.android.cryptoalert.ui.widget

import android.animation.*
import android.widget.LinearLayout
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.graphics.drawable.Drawable
import android.graphics.drawable.ColorDrawable
import com.example.android.cryptoalert.ui.widget.ViewLoadingDotsFade
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView
import java.lang.Exception

/**
 * Use this view with width = height or width > height
 * EXAMPLE :
 * android:layout_width="50dp"
 * android:layout_height="30dp"
 *
 *
 * To change dot color you can use :
 * android:background="@color/exampleColor"
 */
class ViewLoadingDotsFade : LinearLayout {

    private var dotContext: Context? = null
    private var img: ImageView? = null
    private val circle = GradientDrawable()
    private var animator: ObjectAnimator? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        dotContext = context
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
        val layoutParams =
            LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setLayoutParams(layoutParams)
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private fun initView() {
        var color = Color.GRAY
        val background = background
        if (background is ColorDrawable) {
            color = background.color
        }
        setBackgroundColor(Color.TRANSPARENT)
        removeAllViews()
        img = ImageView(dotContext)
        circle.shape = GradientDrawable.OVAL
        circle.setColor(color)
        circle.setSize(200, 200)
        img!!.background = circle
        addView(img)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        animateView(true)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        try {
            if (animator!!.isRunning) {
                animator!!.removeAllListeners()
                animator!!.end()
                animator!!.cancel()
            }
        } catch (e: Exception) {
        }
    }

    private fun animateView(show: Boolean) {
        animator = ObjectAnimator()
        val A = PropertyValuesHolder.ofFloat("alpha", 0.0f)
        val B = PropertyValuesHolder.ofFloat("alpha", 1.0f)
        val alpha = if (show) A else B
        animator = ObjectAnimator.ofPropertyValuesHolder(img, alpha)
        animator!!.repeatCount = 0
        animator!!.repeatMode = ValueAnimator.REVERSE
        animator!!.duration = DURATION.toLong()
        animator!!.startDelay = DURATION.toLong()
        animator!!.start()
        animator!!.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                animateView(!show)
            }
        })
    }

    companion object {
        private const val DURATION = 150
    }
}