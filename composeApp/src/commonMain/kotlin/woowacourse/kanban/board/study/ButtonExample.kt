package woowacourse.kanban.board.study

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ButtonExample() {
    Button(onClick = {
        // 버튼이 클릭되었을 때 실행될 코드
        println("버튼 클릭!")
    }) {
        Text(text = "눌러주세요")
    }
}

@Composable
fun ButtonSummit() {
    Button(onClick = {
        // 버튼이 클릭되었을 때 실행될 코
    }) {
        Text(text = "저장")
    }
}

@Composable
fun ButtonLove() {
    Button(onClick = {
        // 버튼이 클릭되었을 때 실행될 코
    }) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "아이콘"
        )
    }
}

@Composable
fun ButtonLike() {
    Button(onClick = {
        // 버튼이 클릭되었을 때 실행될 코드
    }) {
        Row{
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "아이콘"
            )
            Text(text = "좋아요")
        }
    }
}

