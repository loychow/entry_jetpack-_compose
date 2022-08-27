package com.example.myapplication.ui.layout

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.key.OperationID
import com.example.myapplication.key.*
import com.example.myapplication.ui.theme.*
import com.example.myapplication.ui.viewmodle.Record

private val buttons = arrayOf(
    arrayOf(
        ClearOrClearAllKey(),
        ReverseKey("+/-"),
        PercentageKey("%"),
        QuaternionOperatorKey(OperationID.DIVIDE)
    ),
    arrayOf(
        NumericKey("7"),
        NumericKey("8"),
        NumericKey("9"),
        QuaternionOperatorKey(OperationID.MULTIPLY)
    ),
    arrayOf(
        NumericKey("4"),
        NumericKey("5"),
        NumericKey("6"),
        QuaternionOperatorKey(OperationID.SUBTRACT)
    ),
    arrayOf(
        NumericKey("1"),
        NumericKey("2"),
        NumericKey("3"),
        QuaternionOperatorKey(OperationID.ADD)
    ),
    arrayOf(
        NumericKey("0"),
        PointKey("."),
        CalculationKey()
    )
)

@Composable
fun Calculator(
    record: Record,
    onRecordChange: (Record) -> Unit = {}
) {
    var stateAC by remember { mutableStateOf(getKeyStateOfRecord(record)) }
    var stateshift by remember { mutableStateOf(getKeyStateOfRecord(record)) }
    var selectOpt by remember { mutableStateOf(false) }
    var next by remember { mutableStateOf(record.shouldReset) }
    Column(
        Modifier
            .background(Background)
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
                                .weight(if (it.getSymbol() == "0") 2f else 1f)
                                .aspectRatio(if (it.getSymbol() == "0") 2f else 1f)
                                .background(if (selectOpt) it.getTextColor() else it.getColor()),
                            if (it is ClearOrClearAllKey) {
                                getSymbol(stateAC, it)
                            } else {
                                getSymbol(stateshift, it)
                            },
                            if (selectOpt) it.getColor() else it.getTextColor()
                        ) {

                            var r: Record
                            if (it is ClearOrClearAllKey) {
                                r = (it as ShiftKey).exercise(record, getKeyStateOfRecord(record))
                            } else {
                                r = it.exercise(record, next)
                            }
                            if (it is CalculationKey) {
                                Log.d("CalculationKey", r.toString())
                                r = r.copy(
                                    factor1 = r.factor2,
                                    factor2 = r.result
                                )
                            }
                            if (it is NumericKey) {
                                next = false
                            }
                            if (it is ShiftKey) {
//                                stateAC = stateAC.shift()
                                if (stateAC == KeyState.SHIFT) {
                                    selectOpt = record.opt.symbol == it.getSymbol()
                                }
                                stateshift = stateshift.shift()
                            }
                            if (
                                it is QuaternionOperatorKey) {
                                selectOpt = record.opt.symbol == it.getSymbol()
                                next = true
                            } else {
                                selectOpt = false
                            }
                            if (it is CalculationKey) {
                                next = true
                            }
                            onRecordChange(r)
                        }
                    }
                }
            }
        }
    }
}

fun getSymbol(stateShift: KeyState, key: Key): String {
    return if (stateShift == KeyState.SHIFT) key.shiftSymbol() else key.getSymbol()
}

fun getKeyStateOfRecord(record: Record): KeyState {
    return if (record.display != "0.0" && record.display != "0") {
        KeyState.SHIFT
    } else {
        KeyState.DEFAULT
    }
}

//
@Composable
fun CalculatorButton(
    modifier: Modifier,
    symbol: String,
    textColor: Color,
    onClick: () -> Unit = {}
) {
    Box(
        Modifier
            .clip(CircleShape)
            .then(modifier)
            .clickable {
                onClick.invoke()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(symbol, fontSize = 40.sp, color = textColor)
    }
}
