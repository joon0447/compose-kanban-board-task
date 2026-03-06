package woowacourse.kanban.board.design

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

enum class Font(val size: TextUnit, val weight: FontWeight) {
    TITLE(17.sp, FontWeight.Bold),
    DESCRIPTION(14.sp, FontWeight.Medium),
    TAG(12.sp, FontWeight.Medium),
    ASSIGNEE(14.sp, FontWeight.Medium)
}
