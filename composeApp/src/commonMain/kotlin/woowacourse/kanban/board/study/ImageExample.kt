package woowacourse.kanban.board.study

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import kanbanboard.composeapp.generated.resources.my_image
import org.jetbrains.compose.resources.painterResource
import kanbanboard.composeapp.generated.resources.Res


@Composable
fun ImageExample() {
    Image(
        painter = painterResource(Res.drawable.my_image),
        contentDescription = "설명 텍스트 (접근성을 위해 중요!)"
    )
}
