package com.example.myapplication.ui.layout

import android.opengl.Visibility
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.key.OperationID
import com.example.myapplication.key.*
import com.example.myapplication.ui.theme.B1
import com.example.myapplication.ui.theme.G3
import com.example.myapplication.ui.theme.LG4
import com.example.myapplication.ui.theme.O2
import com.example.myapplication.ui.viewmodle.Record

private val buttons = arrayOf(
    arrayOf(
        ClearOrClearAllKey() to LG4,
        ReverseKey("+/-") to LG4,
        PercentageKey("%") to LG4,
        QuaternionOperatorKey(OperationID.DIVIDE) to O2
    ),
    arrayOf(
        NumericKey("7") to G3,
        NumericKey("8") to G3,
        NumericKey("9") to G3,
        QuaternionOperatorKey(OperationID.MULTIPLY) to O2
    ),
    arrayOf(
        NumericKey("4") to G3,
        NumericKey("5") to G3,
        NumericKey("6") to G3,
        QuaternionOperatorKey(OperationID.SUBTRACT) to O2
    ),
    arrayOf(
        NumericKey("1") to G3,
        NumericKey("2") to G3,
        NumericKey("3") to G3,
        QuaternionOperatorKey(OperationID.ADD) to O2
    ),
    arrayOf(
        NumericKey("0") to G3,
        PointKey(".") to G3,
        CalculationKey() to O2
    )
)

@Composable
fun Calculator(
    record: Record,
    onRecordChange: (Record) -> Unit = {}
) {
    var stateAC by remember { mutableStateOf(getKeyStateOfRecord(record)) }
    var stateOPT by remember { mutableStateOf(record.shouldReset) }
    Column(
        Modifier
            .background(B1)
            .padding(horizontal = 10.dp)
    ) {
        Box(
            Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        )
        {
            stateAC = getKeyStateOfRecord(record)
            Text(
                record.removeDecimals(record.display),
                fontSize = 100.sp,
                color = Color.White
            )
        }
        Column(Modifier.fillMaxSize()) {
            buttons.forEach {
                Row(
                    Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    it.forEach {

                        CalculatorButton(
                            Modifier
                                .weight(if (it.first.getSymbol() == "0") 2f else 1f)
                                .aspectRatio(if (it.first.getSymbol() == "0") 2f else 1f)
                                .background(it.second),
                            if (it.first is ClearOrClearAllKey) {
                                (it.first as ShiftKey).getSymbol(stateAC)
                            } else {
                                it.first.getSymbol()
                            }
                        ) {

                            var r: Record
                            if (it.first is ClearOrClearAllKey) {
                                r = (it.first as ShiftKey).exercise(record, stateAC)
                                stateAC = stateAC.shift()
                            } else {
                                r = it.first.exercise(record, stateOPT)
                            }
                            if (it.first is CalculationKey) {
                                Log.d("CalculationKey", r.toString())
                                r = r.copy(
                                    factor1 = r.factor2,
                                    factor2 = r.result
                                )
                            }
                            if (it.first is NumericKey) {
                                stateOPT = false;
                            } else if (it.first is QuaternionOperatorKey || it.first is CalculationKey) {
                                stateOPT = true
                            }
                            onRecordChange(r)
                        }
                    }
                }
            }
        }
    }
}

fun getKeyStateOfRecord(record: Record): KeyState {
    return if (record.display != "0.0" && record.display != "0") {
        KeyState.SHIFT
    } else {
        KeyState.DEFAULT
    }
}

@Composable
fun CalculatorButton(modifier: Modifier, symbol: String, onClick: () -> Unit = {}) {
//    var flag by remember { mutableStateOf(true) }
//    val alpha = animateFloatAsState(targetValue = if (flag) 3f else 0.2f){
//        flag=true
//    }
    Box(
        Modifier
            .clip(CircleShape)
            .then(modifier)
//            .graphicsLayer(alpha = alpha.value)
            .clickable {
//                flag = false
                onClick.invoke()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(symbol, fontSize = 40.sp, color = Color.White)
    }
}
