package edu.wsc2022.a01.createview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.lifecycleScope
import edu.wsc2022.a01.createview.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
class RectView(context: Context,attributeSet: AttributeSet): View(context,attributeSet){
    val rectF = RectF(100f,100f,200f,200f)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.getColor(R.color.red)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(rectF,paint)
    }
}
class CircleView(context: Context,attributeSet: AttributeSet): View(context,attributeSet){
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.getColor(R.color.red)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(150f,150f,100f,paint)
    }
}
class OvalView(context: Context,attributeSet: AttributeSet): View(context,attributeSet){
    val rectF = RectF(100f,100f,200f,400f)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.getColor(R.color.red)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawOval(rectF,paint)
    }
}
class ArcView(context: Context,attributeSet: AttributeSet): View(context,attributeSet){
    val rectF = RectF(100f,100f,300f,300f)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.getColor(R.color.red)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawArc(rectF,0f,270f,true,paint)
    }
}




