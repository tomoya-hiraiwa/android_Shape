# 基礎的な図形一覧

## 四角形

### 基本メソッド

```kotlin
 canvas.drawRect(left: Float,top: Float,right: Float,bottom: Float,paint: Paint)
```

実装例

```kotlin
class RectView(context: Context,attributeSet: AttributeSet): View(context,attributeSet){
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.resources.getColor(R.color.black,context.theme)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(100f,100f,200f,200f,paint)
    }
}
```

![スクリーンショット 2023-12-14 14 54 48](https://github.com/tomoya-hiraiwa/android_origin_view/assets/132980146/30bf7b86-96be-470e-92c1-e0706408a694)

### その他の実装パターン

・先に描画範囲を指定した変数を渡す

```kotlin
  val rect = Rect(100,100,200,200)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(rect,paint)
    }
```

・RectをFloatで指定

```kotlin
 val rectf = RectF(100f,100f,200f,200f)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(rectf,paint)
    }
```

## 円

### 基本メソッド

```kotlin
canvas.drawCircle(cx: Float,cy: Float,radius: Float,paint: Paint)
```

cx:円の中心のx座標,cy:円の中心のy座標,radius: 半径

実装例

```kotlin
class CircleView(context: Context,attributeSet: AttributeSet): View(context,attributeSet){
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.resources.getColor(R.color.red,context.theme)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(150f,150f,100f,paint)
    }
}
```

![スクリーンショット 2023-12-14 15 25 14](https://github.com/tomoya-hiraiwa/android_origin_view/assets/132980146/ef414b36-9bad-4df6-a1ff-8493fbe236a3)

### その他の実装パターン

・塗りつぶしなし

```kotlin
//styleでPaint.Style.STROKEを指定
 val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.resources.getColor(R.color.red,context.theme)
        style = Paint.Style.STROKE
    }
```

## 楕円

### 基本メソッド

```kotlin
  canvas.drawOval(left: Float,top: Float,right: Float,bottom: Float,paint: Paint)
```

実装例

```kotlin
class OvalView(context: Context,attributeSet: AttributeSet): View(context,attributeSet){
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.resources.getColor(R.color.red,context.theme)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawOval(100f,100f,500f,200f,paint)
    }
}
```
![スクリーンショット 2023-12-14 15 39 54](https://github.com/tomoya-hiraiwa/android_origin_view/assets/132980146/ed91cfe3-47f1-4b4c-aa89-47e0b053f6b1)

### その他の実装パターン

・四角形の時と同じくRectFを用いることが可能

```kotlin
 val rectF = RectF(100f,100f,500f,200f)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawOval(rectF,paint)
    }
```

##　孤

### 基本メソッド

```kotlin
 canvas.drawArc(rectF: RectF,startAngle: Float,sweepAngle: Flaot,useCenter: Boolean,paint: Paint)
```

startAngle: 開始地点の角度,seepAngle:終了地点の角度

useCenter:trueだと円グラフみたいに中心に向かって孤ができる

使用例

```kotlin
class ArcView(context: Context,attributeSet: AttributeSet): View(context,attributeSet){
    val rectF = RectF(0f,0f,200f,200f)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.resources.getColor(R.color.red,context.theme)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawArc(rectF,0f,270f,true,paint)
        //offcetは描画位置を指定しているrectのx,y座標を移動するメソッド
        rectF.offset(500f,0f)
        canvas.drawArc(rectF,0f,270f,false,paint)
    }
}
```

![スクリーンショット 2023-12-14 16 07 18](https://github.com/tomoya-hiraiwa/android_origin_view/assets/132980146/3a5dbf05-243a-400a-beae-f5a0d6a4fd53)


## Canvasについて

### 描画基準位置を変更する(translate)

```kotlin
 canvas.drawRect(rectf,paint)
 canvas.translate(100f,100f)
 canvas.drawRect(rectf,paint)
```

![スクリーンショット 2023-12-14 16 11 32](https://github.com/tomoya-hiraiwa/android_origin_view/assets/132980146/580644db-2a4c-45cb-951f-951551fe2269)

元の位置からx:100f,y:100fずれた位置に二つ目のrectが描画される

### 角度を変更する(rotate)

```kotlin
 canvas.drawRect(rectf,paint)
        canvas.translate(100f,100f)
        canvas.rotate(45f)
        canvas.drawRect(rectf,paint)
```

![スクリーンショット 2023-12-14 16 11 32](https://github.com/tomoya-hiraiwa/android_origin_view/assets/132980146/70aebf55-25e9-431e-b6c9-55ad525c0f72)

位置と角度が変更される

### サイズを変更

```kotlin
 canvas.drawRect(rectf,paint)
        canvas.translate(100f,100f)
        canvas.rotate(45f)
        canvas.scale(2f,2f)
        canvas.drawRect(rectf,paint)
```


![スクリーンショット 2023-12-14 16 16 25](https://github.com/tomoya-hiraiwa/android_origin_view/assets/132980146/03026c83-bb91-45bf-b70e-10c6e6d7ddba)

これまでの変化+サイズが2倍

