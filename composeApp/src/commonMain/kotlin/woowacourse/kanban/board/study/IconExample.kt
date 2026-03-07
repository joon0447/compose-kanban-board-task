package woowacourse.kanban.board.study

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.my_image
import org.jetbrains.compose.resources.painterResource


@Composable
fun IconExample(){
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "아이콘"
    )
}