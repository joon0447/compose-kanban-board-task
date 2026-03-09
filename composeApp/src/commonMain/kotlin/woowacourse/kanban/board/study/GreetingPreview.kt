package woowacourse.kanban.board.study

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kanbanboard.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import kanbanboard.composeapp.generated.resources.my_image

@Composable
@Preview
fun TextExample() {
    Text(
        text = "Jetpack Compose",
        color = Color.Blue,
        fontSize = 22.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
@Preview
fun ImageExample() {
    Image(
        painter = painterResource(Res.drawable.my_image),
        contentDescription = "설명 텍스트 (접근성을 위해 중요!)",
    )
    Image(
        imageVector = Icons.Default.Favorite,
        contentDescription = "좋아요",
    )
}

@Composable
fun ButtonExample() {
    Button(
        onClick = {
            println("저장")
        },
    ) {
        Text(text = "저장")
    }

    Button(
        onClick = {
            println("저장")
        },
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "좋아요",
            tint = Color.Black,
        )
    }
}

@Composable
@Preview
fun IconButtonExample() {
    Button(
        onClick = {
            println("좋아요")
        },
    ) {
        Row {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "좋아요",
                tint = Color.Black,
            )
            Text("좋아요")
        }
    }
}

@Composable
@Preview
fun SimpleBox() {
    Box(
        modifier = Modifier.size(200.dp).background(Color.White),
    ) {
        Box(
            modifier = Modifier.size(50.dp).background(Color.Red).align(Alignment.TopStart),
        )

        Box(
            modifier = Modifier.size(50.dp).background(Color.Yellow).align(Alignment.Center),
        )


        Box(
            modifier = Modifier.size(50.dp).background(Color.Green).align(Alignment.BottomEnd),
        )
    }
}
