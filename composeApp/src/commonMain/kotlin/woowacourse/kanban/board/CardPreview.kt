package woowacourse.kanban.board

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_NO
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import woowacourse.kanban.board.constant.EXAMPLE_CONTENT
import woowacourse.kanban.board.constant.EXAMPLE_TITLE
import woowacourse.kanban.board.constant.EXAMPLE_WRITER
import woowacourse.kanban.board.constant.MAX_CONTENT
import woowacourse.kanban.board.constant.MAX_TITLE
import woowacourse.kanban.board.constant.MAX_WRITER

class CardDataProvider : PreviewParameterProvider<CardData> {
    override val values = sequenceOf(
        CardData(title = EXAMPLE_TITLE,
            content = EXAMPLE_CONTENT,
            tags = listOf("컴포넌트", "성능"),
            writer = EXAMPLE_WRITER
        ),
        CardData.createCard(
            title = EXAMPLE_TITLE,
            tags = listOf("컴포넌트", "성능"),
            writer = EXAMPLE_WRITER
        ),
        CardData.createCard(
            title = EXAMPLE_TITLE,
            content = EXAMPLE_CONTENT,
            writer = EXAMPLE_WRITER
        ),
        CardData.createCard(
            title = EXAMPLE_TITLE,
            writer = EXAMPLE_WRITER
        ),
        CardData.createCard(
            title = MAX_TITLE,
            content = MAX_CONTENT,
            tags = listOf("너무너무", "긴 태그", "최대로", "5자 까지", "5개 제한임"),
            writer = MAX_WRITER
        )
    )
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "KanbanBoard_Night_Preview",
    showBackground = true
)
@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "KanbanBoard_Day_Preview",
    showBackground = true
)
annotation class DayAndNightPreviews

@Preview(
    showBackground = true,
    device = "spec:width=411dp,height=891dp",
    name = "device test on phone"
)
@Preview(
    showBackground = true,
    device = "spec:width=1920dp,height=1080dp,dpi=160",
    name = "device test on desktop"
)
annotation class DevicePreviews

@DayAndNightPreviews
@Composable
private fun CardPreview(
    @PreviewParameter(CardDataProvider::class) card: CardData
) {
    KanbanBoardCard(Modifier, card)
}

@DevicePreviews
@Composable
private fun CardPreviewOnDevice(
    @PreviewParameter(CardDataProvider::class) card: CardData
) {
    KanbanBoardCard(Modifier, card)
}