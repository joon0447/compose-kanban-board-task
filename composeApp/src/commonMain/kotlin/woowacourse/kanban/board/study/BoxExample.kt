package woowacourse.kanban.board.study

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SimpleBox() {
    Box(
        modifier = Modifier.size(200.dp).background(Color.White)

    ) {
        // 파란색 사각형, 왼쪽 위에 배치
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.TopStart)
        )

        // 초록색 사각형, 오른쪽 아래에 배치
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .align(Alignment.Center)
        )

        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
                .align(Alignment.BottomEnd)
        )
    }
}