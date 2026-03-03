package woowacourse.kanban.board.model

data class TaskCard(
    val title: String,
    val description: String = "",
    val tags: List<Tag> = emptyList(),
    val assignee: String,
) {
    init {
        require(title.isNotBlank()) { "제목은 비어 있을 수 없습니다." }
        require(assignee.isNotBlank()) { "담당자는 비어 있을 수 없습니다." }
        require(tags.size <= MAX_TAG_COUNT) { "태그는 최대 ${MAX_TAG_COUNT}개까지 가능합니다." }
    }

    val hasDescription: Boolean get() = description.isNotBlank()
    val hasTags: Boolean get() = tags.isNotEmpty()

    companion object {
        const val MAX_TAG_COUNT = 5
    }
}
