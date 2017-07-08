#### 带阴影点击效果，可自定义属性的媒体播放控制按钮。包括【播放(暂停)】按钮，【下一曲(上一曲)】按钮。:blush:

>**自定义 View 开发的可定制大小，颜色，圆角，阴影半径，描边风格的播放，暂停按钮，上一曲，下一曲按钮**

#### 一.开发背景
网易云音乐的很多按钮控件点击时都是带阴影效果的，不同于 material design 的涟漪效果，按钮被点击时图标轮廓四周会有白色“阴影”， 或者可以称为“荧光”效果，

#### 二.效果图
<table align="center">
<tr>
<th align="center">静态图</th>
<th align="center">动态图</th>
</tr>
<tr>
<td width="350"><img src="https://raw.githubusercontent.com/DuanJiaNing/MediaView/master/screenshort1.png" ></td>
<td width="350"><img src="https://raw.githubusercontent.com/DuanJiaNing/MediaView/master/screenshort.gif"></td>
</tr>
</table>

#### 三.介绍
> 控件具有如下继承结构<br>
> |-- android.view.View<br>
> &nbsp;&nbsp;&nbsp;&nbsp;|-- abstract MediaView<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-- SkipView&nbsp;&nbsp;上一曲(下一曲)按钮<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-- PlayView&nbsp;&nbsp;播放按钮<br>
##### 3.1 构成元素

xml 中提供的可定制属性如下：

- radius 半径：整个控件的半径
- shadowRadius 阴影半径

（1） 外圆圈

- strokeWidth 描边宽度
- strokeColor 描边颜色


（2） 上一曲(下一曲)按钮：

- distance 单竖线和三角形顶点距离

1 单竖线：

- innerLineWidth(Height) 宽度，高度：任一者赋值为 0 时不进行绘制。
- innerLineRadius 圆角大小

2 等腰三角形：

- triangleWidth 三角形顶角到底边的距离
- triangleHeight 底边高度
- triangleColor 填充颜色
- triangleRadius 圆角大小
- triangleHollow 是否空心
- triangleStroke 空心时的描边宽度

（3） 播放，暂停按钮

- checked 是否播放，true 为正在播放（此时处于可暂停状态）

1 播放状态：
播放状态下直接绘制继承自 SkipView 的等腰三角形
2 暂停状态：此时两条竖线的属性时完全一致的

- pauseLineDistance 双竖线间距
- pauseLineWidth 竖线宽度
- pauseLineHeight 竖线高度
- pauseLineRadius 竖线圆角
- pauseLineColor 竖线颜色
- pauseLineHollow 是否空心
- pauseLineStroke 空心状态下指定竖线描边宽度

![](https://raw.githubusercontent.com/DuanJiaNing/MediaView/master/anyic1.jpg)

##### 3.2 java 类表示
控件由三个 java 类表示，三个类的定义如下：

- `abstract class MediaView extends View`：
该类定义了控件的基本结构：圆圈构成的固定的最外部，由子类负责绘制的内部。
绘制规则：先绘制外部，再绘制内部
触摸事件处理：`ACTION_DOWN`时开始触摸动画，`ACTION_UP`时开启释放动画。（两个动画都是作用于“阴影大小”）

- ` class SkipView extends MediaView`:
该类继承自 MediaView，实现了 MediaView 定义的`drawInside`方法，完成单竖线和三角形的绘制。

- class PlayView extends SkipView：
- 该类继承自 SkipView ，完成在播放，暂停两种状态下控件的绘制，覆写 onTouchEvent 方法以实现 checked 属性变化监听，同时覆写了 SkipView 的 drawLine 方法，以绘制可播放状态下的双竖线。

#### 四.适用场景：

音乐，视频等媒体文件的播放控制。

#### 五.如何使用
##### 5.1 复制源文件

使用 【上一曲(下一曲)】和【播放(暂停)】控件需复制 MediaView.java ， SkipView.java ， PlayView.java 和 attrs.xml 文件到你的项目中。

如果你只需要 【上一曲(下一曲)】对应的控件：<br>
1 复制 MediaView.java 和 SkipView.java 到你的项目中<br>
2 将 attrs 文件中的 ` <declare-styleable name="MediaView">....</declare-styleable>`及其对应的 attr 属性定义，` <declare-styleable name="SkipView">....</declare-styleable>`及其对应的 attr 属性定义 复制到你项目中的 values 文件夹下的资源文件中。

##### 5.2 使用示例
在完成 5.1 之后就可以在你的项目中使用了。

可以在布局文件中直接使用：
使用时包名替换成你的源文件所在位置

**【上一曲(下一曲)】**
```xml
        <com.duan.mediaviewdemo.view.SkipView
            android:id="@+id/sv_01"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="0.5"

            app:innerLineHeight="30dp"
            app:innerLineWidth="6dp"

            app:innerLineRadius="8dp"

            app:distance="-8dp"
            app:triangleHeight="40dp"

            app:strokeWidth="0dp"
            app:triangleColor="#2ca4a4"
            app:triangleRadius="8dp"

            />
```

**【播放(暂停)】控件**
``` xml
      <com.duan.mediaviewdemo.view.PlayView
            android:layout_width="0dp"

            android:layout_height="match_parent"
            android:layout_weight="0.5"

            android:rotation="180"
            app:checked="true"
            app:pauseLineDistance="8dp"
            app:pauseLineHeight="35dp"

            app:pauseLineHollow="true"

            app:pauseLineRadius="0dp"
            app:pauseLineWidth="10dp"
            app:strokeColor="#e4188f"
            app:triangleColor="#e4188f"
            app:strokeWidth="3dp"
            app:triangleHeight="35dp"


            app:triangleHollow="true"
            app:triangleRadius="5dp"
            app:triangleStroke="7dp" />
```
在 java 中使用：
```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SkipView sv = (SkipView) findViewById(R.id.sv_01);
        PlayView pv = (PlayView) findViewById(R.id.pv_01);

        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });

        pv.setOnCheckedChangeListener(new PlayView.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(PlayView view, boolean checked) {
                Toast.makeText(MainActivity.this, "checked:" + checked, Toast.LENGTH_SHORT).show();
            }
        });

    }
```

#### 六.版本变化
- v 0.1 2017-06-16

- v 0.2 2017-06-29

1 修正【播放/暂停】按钮在`pauseLineHeight`属性未赋值时绘制错误的情况。<br>
2 修改圆环为可设置为空心的圆圈，可以通过`hollow`属性设置圆圈是否为空心，弃用`strokeColor`，使用`solidColor`属性为圆圈指定颜色。<br>
<img src="https://raw.githubusercontent.com/DuanJiaNing/MediaView/master/screenshort3.png" ><br>
`hollow`属性使用示例：<br>
```java
  <com.duan.mediaviewdemo.view.PlayView
        ...
        
        app:checked="true"
        app:hollow="false"
        app:pauseLineColor="#fff"
        app:solidColor="@color/colorAccent"
        app:triangleColor="#fff"
        
        ...
        />
```

- v 0.3 2017-06-29

在 view 的 enable 为 false 时，控件不可用（不响应触摸事件）。<br>

#### 七.未来的开发计划
- [ ] setter 和 getter 方法测试
- [ ] 规范注释
#### 八.Q&A
