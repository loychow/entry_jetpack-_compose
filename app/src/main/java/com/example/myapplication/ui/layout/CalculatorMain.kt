package com.example.myapplication.ui.layout

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.MainActivity
import com.example.myapplication.arithmetic.OperationID
import com.example.myapplication.key.*
import com.example.myapplication.ui.theme.B1
import com.example.myapplication.ui.theme.G3
import com.example.myapplication.ui.theme.LG4
import com.example.myapplication.ui.theme.O2
import com.example.myapplication.ui.viewmodle.Record

private val buttons = arrayOf(
    arrayOf(
        ClearOrClearAllKey() to LG4,
        NumericKey("+/-") to LG4,
        NumericKey("%") to LG4,
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
        NumericKey() to G3,
        NumericKey(".") to G3,
        CalculationKey() to O2
    )
)

@Composable
fun Calculator(
    record: Record,
    onRecordChange: (Record) -> Unit = {}
) {
    var state by remember { mutableStateOf(KeyState.DEFAULT) }
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
            Text(record.display, fontSize = 100.sp, color = Color.White)
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
                            it.first.getSymbol()
                        ) {
                            var r: Record
                            if (it.first is ShiftKey) {
                                state = state.shift()
                                r = (it.first as ShiftKey).exercise(record, state)
                            } else {
                                r = it.first.exercise(record)
                            }
                            if (it.first is CalculationKey) {
                                //todo save record
                                Log.d("CalculationKey",r.toString())
//                                r = r.copy(factor1 = r.result, factor2 = r.display.toInt())
                                r = r.copy(factor1 = r.result, factor2 = r.display.toInt())
                            }
                            onRecordChange(r)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CalculatorButton(modifier: Modifier, symbol: String, onClick: () -> Unit = {}) {
    Box(
        Modifier
            .clip(CircleShape)
            .then(modifier)
            /*.background(Color.Blue)*/
            .clickable { onClick.invoke() },
        contentAlignment = Alignment.Center
    ) {
        Text(symbol, fontSize = 40.sp, color = Color.White)
    }
}
