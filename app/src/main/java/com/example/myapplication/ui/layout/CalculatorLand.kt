package com.example.myapplication.ui.layout


import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.key.*
import com.example.myapplication.ui.theme.Background
import com.example.myapplication.ui.theme.DarkGray
import com.example.myapplication.ui.theme.LightGray
import com.example.myapplication.ui.theme.Orange
import com.example.myapplication.ui.viewmodle.Record
import kotlinx.coroutines.delay

//横屏时的数据
private val keysLand = arrayOf(
    arrayOf(
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        ClearOrClearAllKey(LightGray),
        ReverseKey(LightGray, "+/-"),
        PercentageKey(LightGray),
        QuaternionOperatorKey(Orange, OperationID.DIVIDE)
    ),
    arrayOf(
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        NumericKey(DarkGray, "7"),
        NumericKey(DarkGray, "8"),
        NumericKey(DarkGray, "9"),
        QuaternionOperatorKey(Orange, OperationID.MULTIPLY)
    ),
    arrayOf(
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        NumericKey(DarkGray, "4"),
        NumericKey(DarkGray, "5"),
        NumericKey(DarkGray, "6"),
        QuaternionOperatorKey(Orange, OperationID.SUBTRACT)
    ),
    arrayOf(
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        NumericKey(DarkGray, "1"),
        NumericKey(DarkGray, "2"),
        NumericKey(DarkGray, "3"),
        QuaternionOperatorKey(Orange, OperationID.ADD)
    ),
    arrayOf(
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        OtherKey(DarkGray),
        NumericKey(DarkGray, "0"),
        PointKey(DarkGray, "."),
        CalculationKey(Orange)
    )
)

//竖屏时的数据
private val keys = arrayOf(
    arrayOf(
        ClearOrClearAllKey(LightGray),
        ReverseKey(LightGray, "+/-"),
        PercentageKey(LightGray),
        QuaternionOperatorKey(Orange, OperationID.DIVIDE)
    ),
    arrayOf(
        NumericKey(DarkGray, "7"),
        NumericKey(DarkGray, "8"),
        NumericKey(DarkGray, "9"),
        QuaternionOperatorKey(Orange, OperationID.MULTIPLY)
    ),
    arrayOf(
        NumericKey(DarkGray, "4"),
        NumericKey(DarkGray, "5"),
        NumericKey(DarkGray, "6"),
        QuaternionOperatorKey(Orange, OperationID.SUBTRACT)
    ),
    arrayOf(
        NumericKey(DarkGray, "1"),
        NumericKey(DarkGray, "2"),
        NumericKey(DarkGray, "3"),
        QuaternionOperatorKey(Orange, OperationID.ADD)
    ),
    arrayOf(
        NumericKey(DarkGray, "0"),
        PointKey(DarkGray, "."),
        CalculationKey(Orange)
    )
)

@Composable
fun Calculator(
    record: Record,
    isExpandedScreen: Boolean,
    onRecordChange: (Record) -> Unit
) {
    var landed: Boolean by rememberSaveable {
        mutableStateOf(false)
    }

    //控制笔刷
    suspend fun showLandAnimation() {
        if (!landed) {
            landed = true
            delay(1000L)
            landed = false
        }
    }

    Column(
        Modifier
            .background(Background)
            .padding(horizontal = 10.dp)

    ) {
        Box(
            Modifier
                .fillMaxHeight(if (isExpandedScreen) 0.2f else 0.3f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        )
        {
            Text(
                record.removeDecimals(record.display),
                fontSize = fontSizeAdapterOfTopBox(isExpandedScreen, record.display),
                color = Color.White,
                maxLines = if (isExpandedScreen) 1 else Int.MAX_VALUE
            )
        }

        KeyboardRow(
            isExpandedScreen,
            landed,
            if (isExpandedScreen) keysLand else keys,
            record,
            onRecordChange
        )
    }
    //进入屏幕后刷一下
    LaunchedEffect(Unit) {
        showLandAnimation()
    }
}

@Composable
fun KeyboardRow(
    isExpandedScreen: Boolean,
    landed: Boolean,
    keys: Array<Array<Key>>,
    record: Record,
    onRecordChange: (Record) -> Unit
) {
    var optKeySelector: Boolean by rememberSaveable {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        keys.forEach {
            Row(
                modifier = Modifier.weight(1f),/*.padding(vertical = 2.dp)*/
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                it.forEach {
                    CalculatorButton(
                        record,
                        it,
                        landed,
                        isExpandedScreen,
                        optKeySelector,
                        Modifier
                            .clip(if (isExpandedScreen) RoundedCornerShape(40) else CircleShape)
                            .weight(parseModifierBy(isExpandedScreen, it)),
                        onRecordChange,
                    ) {
                        //处理：OPT选中状态
                        if (it is QuaternionOperatorKey) {
                            optKeySelector = true /*record.opt.symbol == it.getSymbol()*/
                        } else {
                            if (optKeySelector) {
                                optKeySelector = false
                            }
                        }
                    }
                }
            }
        }
    }
}


//button
@Composable
fun CalculatorButton(
    record: Record,
    key: Key,
    landed: Boolean,
    isExpandedScreen: Boolean,
    isOptKeySelect: Boolean,
    modifier: Modifier,
    onRecordChange: (Record) -> Unit = {},
    onClick: () -> Unit = {}
) {
    //key的状态切换
    var keyState: KeyState by rememberSaveable {
        mutableStateOf(KeyState.DEFAULT)
    }
    //clear/allClear的切换
    var stateAC by rememberSaveable { mutableStateOf(getACKeyStateOfRecord(record)) }

    if (key is ClearOrClearAllKey) {
        stateAC = getACKeyStateOfRecord(record)
        keyState = stateAC
    }
    //四则运算符选中状态
    var optSelector: Boolean by rememberSaveable {
        mutableStateOf(false)
    }
    //获取symbol
    val symbol = if (keyState == KeyState.DEFAULT) {
        key.getSymbol()
    } else {
        if (key is ShiftKey) {
            key.shiftSymbol()
        } else {
            key.getSymbol()
        }
    }

    if ((key is QuaternionOperatorKey) && isOptKeySelect) {
        optSelector = record.opt.symbol == key.getSymbol()
    } else {
        optSelector = false
    }
    //控制运行符按钮的背景颜色
    val bgColor: Color = if (optSelector) key.getTextColor() else key.getColor()
    //控制运算符按钮的字体颜色
    val textColor: Color =
        if (optSelector) key.getColor() else key.getTextColor()

    Box(
        Modifier
            .then(modifier)
            .aspectRatio(parseModifierBy(isExpandedScreen, key))
            .then(onExpanded(landed, bgColor))
            .clickable {
                onClick.invoke()
                eventHandler(key, keyState, record, onRecordChange)
                if (key is ShiftKey) {
                    keyState = keyState.shift()
                    stateAC = stateAC.shift()
                }

            },
        contentAlignment = Alignment.Center
    ) {
        Text(symbol, fontSize = if (isExpandedScreen) 28.sp else 40.sp, color = textColor)
    }
}


fun eventHandler(
    key: Key,
    keyState: KeyState,
    record: Record,
    onRecordChange: (Record) -> Unit = {}
) {
    var r: Record
    var shouldDisplayReset = record.shouldDisplayReset
    //按键的状态切换例如AC
    if (key is ShiftKey) {
        r = key.exercise(record, keyState)
    } else {
        r = key.exercise(record, shouldDisplayReset)
    }

    //计算
    if (key is NumericKey) {
        shouldDisplayReset = false
    }

    //标记什么时候需要重头拼写
    if (key is QuaternionOperatorKey || key is CalculationKey) {
        shouldDisplayReset = true
    }
    if (key is CalculationKey) {
        r = r.copy(
            factor1 = r.factor2,
            factor2 = r.result
        )
    }
    r = r.copy(shouldDisplayReset = shouldDisplayReset)
    onRecordChange(r)
}


@Composable
fun onExpanded(onExpanded: Boolean, color: Color): Modifier {
    return if (onExpanded) {
        Modifier
            .background(getBrush(color, 200))
    } else {
        Modifier
            .background(color)
    }

}


@Composable
fun getBrush(color: Color, delayMillis: Int): Brush {
    val shimmerColor = listOf(
        color.copy(alpha = 1f),
        color.copy(alpha = 0.2f),
        color.copy(alpha = 1f)
    )

    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 300,
                delayMillis = delayMillis,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    return Brush.linearGradient(
        colors = shimmerColor,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )

}

@Composable
fun parseModifierBy(isExpandedScreen: Boolean, key: Key): Float {
    return if (isExpandedScreen) {
        if (key.getSymbol() == "0") 3.2f else 1.5f
    } else {
        if (key.getSymbol() == "0") 2f else 1f
    }
}

//从record中获取AC键的状态
fun getACKeyStateOfRecord(record: Record): KeyState {
    return if (record.display != "0.0" && record.display != "0") {
        KeyState.SHIFT
    } else {
        KeyState.DEFAULT
    }
}
//显示数字的字体大小随长度变化
fun fontSizeAdapterOfTopBox(isExpandedScreen: Boolean, display: String): TextUnit {
    return if (isExpandedScreen) {
        50.sp
    } else {
        when (display.length) {
            in 1..6 -> 100.sp
            in 7..9 -> 70.sp
            else -> 50.sp
        }
    }
}
