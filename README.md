# android_Shape

## 基本的な図形の描画
### 必要なもの
1.Viewクラスを継承したカスタムクラス

2.レイアウトファイルにView作成したViewを配置

### 基本手順

1.Viewを作成

```kotlin
class RectView(context: Context,attributeSet: AttributeSet): View(context,attributeSet){

}
```

2.Paint(色やテキストのサイズ、スタイルなどどのように描画するかを決める)を作成

```kotlin
class RectView(context: Context,attributeSet: AttributeSet): View(context,attributeSet){
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { 
        color = context.resources.getColor(R.color.black,context.theme)
    }
}
```

3.onDrawメソッドをoverrideして、図形などを描画

```kotlin
class RectView(context: Context,attributeSet: AttributeSet): View(context,attributeSet){
    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.resources.getColor(R.color.black,context.theme)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //ここのメソッドによって、描画する形が変わる
        canvas.drawRect(100f,100f,200f,300f,paint)
    }
}
```
### 詳細（順次追加）

・[基本図形の描画](https://github.com/tomoya-hiraiwa/android_origin_view/blob/main/text/simpleShape.md)

・[基本図形プログラムファイル](https://github.com/tomoya-hiraiwa/android_origin_view/blob/main/CreateView)



