package woowacourse.kanban.board.taskCard

data class TaskInfo(
    val title: String,
    val contents: String? = null,
    val tags: List<Tag>? = null,
    val contactName: String? = null,
) {
    init {
        require(title.isNotBlank()) { "제목은 공백이거나 빈 문자열일 수 없습니다." }
        contents?.let { require(contents.isNotBlank()) { "본문은 공백이거나 빈 문자열일 수 없습니다." } }
        tags?.let { require(tags.isNotEmpty()) { "태그 리스트는 비어있을 수 없습니다." } }
        contactName?.let { require(contactName.isNotBlank()) { "담당자 이름은 공백이거나 빈 문자열일 수 없습니다." } }
    }
}