package com.inside.developed.zimadtestproject.core.base

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.inside.developed.zimadtestproject.R


abstract class BaseActivity : AppCompatActivity() {
    @LayoutRes
    internal abstract fun obtainLayoutResId(): Int

    private var progressDialog: AlertDialog? = null
    private var dialog: DialogFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(obtainLayoutResId())
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun dismissErrorDialog() {
        dialog?.dismiss()
    }

    fun showProgressDialog() {
        val linearLayoutPadding = 30
        val linearLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(
                linearLayoutPadding,
                linearLayoutPadding,
                linearLayoutPadding,
                linearLayoutPadding
            )
            gravity = Gravity.CENTER
        }
        var linearLayoutParam = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        linearLayoutParam.gravity = Gravity.CENTER
        linearLayout.layoutParams = linearLayoutParam

        val progressBar = ProgressBar(this).apply {
            isIndeterminate = true
            indeterminateDrawable.setColorFilter(
                ContextCompat.getColor(this@BaseActivity, R.color.colorAccent),
                PorterDuff.Mode.SRC_IN
            );
            setPadding(0, 0, linearLayoutPadding, 0)
            layoutParams = linearLayoutParam
        }
        linearLayoutParam = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        linearLayoutParam.gravity = Gravity.CENTER
        val tvText = TextView(this)
        tvText.apply {
            text = "Loading ..."
            setTextColor(Color.parseColor("#C85F24"))
            textSize = 20f
            layoutParams = linearLayoutParam
        }

        linearLayout.addView(progressBar)
        linearLayout.addView(tvText)

        progressDialog = AlertDialog.Builder(this)
            .setCancelable(true)
            .setView(linearLayout)
            .create()
        progressDialog?.show()
        val window = progressDialog?.window
        if (window != null) {
            val layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(progressDialog?.window?.attributes)
            layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            progressDialog?.window?.attributes = layoutParams
        }
    }

    fun dismissProgressDialog() {
        progressDialog?.dismiss()
    }
}