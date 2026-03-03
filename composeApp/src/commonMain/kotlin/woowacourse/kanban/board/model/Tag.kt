package woowacourse.kanban.board.model

data class Tag(val name: String) {
    init {
        require(name.isNotBlank()) { "태그 이름은 비어 있을 수 없습니다." }
        require(name.length <= MAX_LENGTH) { "태그 이름은 ${MAX_LENGTH}자를 초과할 수 없습니다." }
    }

    companion object {
        const val MAX_LENGTH = 5
    }
}
