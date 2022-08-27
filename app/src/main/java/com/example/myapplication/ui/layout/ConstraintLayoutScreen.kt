package com.example.myapplication.ui.layout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.material.Text
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle

//class ConstraintLayoutScreen {
//}

@Composable
fun constraintLayoutScreen() {
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .padding(start = 10.dp, end = 10.dp)) {
        val (b1, b2, b3, b4, b5, b6, b7, b8, b9, b10) = createRefs()
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b1) {
                top.linkTo(parent.top, margin = 12.dp)
            }) {
            Text("1")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b2) {
                top.linkTo(parent.top, margin = 12.dp)
            }) {
            Text("2")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b3) {
                top.linkTo(parent.top, margin = 12.dp)
            }) {
            Text("3")
        }

        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b4) {
                top.linkTo(parent.top, margin = 12.dp)
            }) {
            Text("4")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b5) {
                top.linkTo(parent.top, margin = 12.dp)
            }) {
            Text("6")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b6) {
                top.linkTo(parent.top, margin = 12.dp)
            }) {
            Text("7")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b7) {
                top.linkTo(parent.top, margin = 12.dp)
            }) {
            Text("8")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b8) {
                top.linkTo(parent.top, margin = 12.dp)
            }) {
            Text("9")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b9) {
                top.linkTo(parent.top, margin = 12.dp)
            }) {
            Text("10")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b10) {
                top.linkTo(parent.top, margin = 12.dp)
            }) {
            Text("5")
        }

//        createHorizontalChain(b1,b2,b3,b4,b5/*,b6,b7,b8*/, chainStyle = ChainStyle.SpreadInside)
        createVerticalChain(b1, b2, b3, b4, b5)
//        val (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10) = createRefs()
//        Button(onClick = { /*TODO*/ },
//            modifier = Modifier.constrainAs(c1) {
//                top.linkTo(b1.bottom)
//                start.linkTo(b1.start)
//            }) {
//            Text("c1")
//        }
//        Button(onClick = { /*TODO*/ },
//            modifier = Modifier.constrainAs(c2) {
//                top.linkTo(b2.bottom)
//                start.linkTo(b2.start)
//            }) {
//            Text("c2")
//        }
//        Button(onClick = { /*TODO*/ },
//            modifier = Modifier.constrainAs(c3) {
//                top.linkTo(b3.bottom)
//                start.linkTo(b3.start)
//            }) {
//            Text("c3")
//        }
//        Button(onClick = { /*TODO*/ },
//            modifier = Modifier.constrainAs(c4) {
//                top.linkTo(b4.bottom)
//                start.linkTo(b4.start)
//            }) {
//            Text("c4")
//        }
//        Button(onClick = { /*TODO*/ },
//            modifier = Modifier.constrainAs(c5) {
//                top.linkTo(b5.bottom)
//                start.linkTo(b5.start)
//            }) {
//            Text("c5")
//        }

    }

}

@Composable
fun secrendRow() {
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .padding(start = 10.dp, end = 10.dp)
    ) {
        val (b1, b2, b3, b4, b5, b6, b7, b8, b9, b10) = createRefs()
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b1) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }
        ) {
            Text("A")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b2) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }) {
            Text("B")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b3) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }) {
            Text("C")
        }

        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b4) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }) {
            Text("D")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b5) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }) {
            Text("E")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b6) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }) {
            Text("F")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b7) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }) {
            Text("8")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b8) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }) {
            Text("9")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b9) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }) {
            Text("10")
        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(b10) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            }) {
            Text("5")
        }

        createHorizontalChain(b1,b2,b3,b4,b5/*,b6,b7,b8*/, chainStyle = ChainStyle.SpreadInside)
//        createVerticalChain(b1, b2, b3, b4, b5)
    }
}

