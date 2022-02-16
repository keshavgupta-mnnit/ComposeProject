package com.keshav.composeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ProfilePage() {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
            .border(color = Color.Black, width = 2.dp, shape = RoundedCornerShape(30.dp))
    ) {
        Column(
            Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.scorpion),
                contentDescription = "ScorpionDada",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(width = 2.dp, color = Color.Gray, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
            Text("Scorpion Dada")
            Text("Mainpuri")
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ProfileStats("200", "Posts")
                ProfileStats("150", "Followers")
                ProfileStats("10", "Following")
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Follow User")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Direct Message")
                }
            }
        }
    }
}


@Composable
fun ProfileStats(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(count, fontWeight = FontWeight.Bold)
        Text(title)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfilePageUsingConstraintLayout()
}