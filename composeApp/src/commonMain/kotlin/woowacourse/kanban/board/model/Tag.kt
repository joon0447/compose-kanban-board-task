package woowacourse.kanban.board.model

data class Tag(val text: String) {
    init {
        require(text.isNotEmpty()) { "[ERROR] 태그 텍스트는 빈 값일 수 없습니다." }
        require(text.length <= MAXIMUM_TAG_LENGTH) { "[ERROR] 태그 텍스트는 ${MAXIMUM_TAG_LENGTH}글자 이하여야 합니다." }
    }

    companion object {
        const val MAXIMUM_TAG_LENGTH = 5
    }
}
