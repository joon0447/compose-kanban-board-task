package woowacourse.kanban.board.model

@JvmInline
value class Title(val text: String) {
    init {
        require(text.isNotEmpty()) {"[ERROR] 제목은 빈 값일 수 없습니다." }
    }
}
