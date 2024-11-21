package br.com.aldemir.cardexpandable

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardExpandable(modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearOutSlowInEasing
        ), label = ""
    )

    Card(
        modifier = modifier,
        shape = ShapeDefaults.Large,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2c88ff))
                .padding(16.dp)
        ) {
            Text(
                text = "Agendamento",
                fontWeight = FontWeight.Bold,
                color = Color.White.copy(alpha = 0.8f)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "12 de setembro de 2024 as 10:30h",
                    color = Color.White.copy(alpha = 0.8f)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                ))
        ) {
            if (expanded) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        modifier = Modifier
                            .size(70.dp)
                            .clip(RoundedCornerShape(48.dp)),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            text = "Aldemir Gomes",
                            fontWeight = FontWeight.Bold,
                            style = TextStyle(
                                color = Color.Black.copy(alpha = 0.7f)
                            )
                        )
                        Text(
                            text = "29 anos",
                            style = TextStyle(color = Color.Black.copy(alpha = 0.8f))
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                        .fillMaxWidth(),
                ) {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults
                            .buttonColors(containerColor = Color(0xFF2c88ff))
                    ) {
                        Text(text = "Aceitar")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    OutlinedButton(
                        modifier = Modifier.weight(1f),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color(0xFF2c88ff)
                            ),
                        border = BorderStroke(1.dp, Color(0xFF2c88ff))
                    ) {
                        Text(text = "Negar")
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    expanded = !expanded
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = if (expanded) { "Ver menos" } else { "Ver mais" },
                color = Color(0xFF2c88ff),
                fontWeight = FontWeight.Medium
            )
            Icon(
                modifier = Modifier.rotate(rotation),
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = null,
                tint = Color(0xFF2c88ff)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CardExpandablePreview() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        CardExpandable()
    }
}