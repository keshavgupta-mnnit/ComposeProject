package com.keshav.composeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePageUsingConstraintLayout() {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
            .border(color = Color.Black, width = 2.dp, shape = RoundedCornerShape(30.dp))
    ) {
        BoxWithConstraints() {
            val constraints = if (minWidth < 600.dp) {
                portraitConstraints(16.dp)
            } else {
                landscapeConstraints(16.dp)
            }

            ConstraintLayout(constraints) {
                Image(
                    painter = painterResource(id = R.drawable.scorpion),
                    contentDescription = "ScorpionDada",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.Gray, shape = CircleShape)
                        .layoutId("image"),
                    contentScale = ContentScale.Crop
                )
                Text("Scorpion Dada", modifier = Modifier.layoutId("name"))
                Text("Mainpuri", modifier = Modifier.layoutId("place"))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .layoutId("stats")
                ) {
                    ProfileStats("200", "Posts")
                    ProfileStats("150", "Followers")
                    ProfileStats("10", "Following")
                }

                Button(modifier = Modifier.layoutId("button1"), onClick = { /*TODO*/ }) {
                    Text(text = "Follow User")
                }
                Button(modifier = Modifier.layoutId("button2"), onClick = { /*TODO*/ }) {
                    Text(text = "Direct Message")
                }

            }
        }
    }
}

fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val name = createRefFor("name")
        val place = createRefFor("place")
        val stats = createRefFor("stats")
        val button1 = createRefFor("button1")
        val button2 = createRefFor("button2")
        val guideline = createGuidelineFromTop(0.2f)

        constrain(image) {
            top.linkTo(guideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(name) {
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(place) {
            top.linkTo(name.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(stats) {
            top.linkTo(place.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(button1) {
            top.linkTo(stats.bottom, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(button2.start)
            width = Dimension.wrapContent
        }
        constrain(button2) {
            top.linkTo(stats.bottom, margin = margin)
            start.linkTo(button1.end)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
        }
    }
}

fun landscapeConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val name = createRefFor("name")
        val place = createRefFor("place")
        val stats = createRefFor("stats")
        val button1 = createRefFor("button1")
        val button2 = createRefFor("button2")

        constrain(image) {
            top.linkTo(parent.top, margin = margin)
            start.linkTo(parent.start, margin = margin)
        }
        constrain(name) {
            top.linkTo(image.bottom)
            start.linkTo(image.start)
        }
        constrain(place) {
            top.linkTo(name.bottom)
            start.linkTo(name.start)
            end.linkTo(name.end)
        }
        constrain(stats) {
            top.linkTo(image.top)
            start.linkTo(image.end, margin = margin)
            end.linkTo(parent.end)
        }
        constrain(button1) {
            top.linkTo(stats.bottom, margin = margin)
            start.linkTo(stats.start)
            end.linkTo(button2.start)
            width = Dimension.wrapContent
        }
        constrain(button2) {
            top.linkTo(stats.bottom, margin = margin)
            start.linkTo(button1.end)
            end.linkTo(stats.end)
            width = Dimension.wrapContent
        }
    }
}
