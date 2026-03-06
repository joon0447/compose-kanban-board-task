package woowacourse.kanban.board.model

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

data class TaskCardDto(
    val title: String,
    val contents: String,
    val tags: List<String>,
    val author: String
) {
    init {
        require(tags.size <= 5) { "[ERROR] 태그 개수는 5개 이하여야 합니다." }
        require(tags.all { it.length <= 5} ) { "[ERROR] 태그 길이는 5자 이하여야 합니다." }
    }
}

 class TaskCardDtoProvider : PreviewParameterProvider<TaskCardDto> {
    override val values: Sequence<TaskCardDto> = sequenceOf(
        TaskCardDto(
            title = "제목",
            contents = "내용",
            tags = listOf("태그", "태그222", "태그3", "태그4", "태그5"),
            author = "별터"
        ),
        TaskCardDto(
            title = "제목",
            contents = "",
            tags = listOf(""),
            author = "별터"
        ),
        TaskCardDto(
            title = "제목",
            contents = "",
            tags = listOf("태그"),
            author = "별터"
        ),
    )
}
