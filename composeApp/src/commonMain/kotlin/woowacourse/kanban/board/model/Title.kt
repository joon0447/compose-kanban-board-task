package woowacourse.kanban.board.model

import woowacourse.kanban.board.constants.TITLE_ERROR_MESSAGE

@JvmInline
value class Title(val text: String) {
    init {
        require(text.isNotBlank()) { TITLE_ERROR_MESSAGE }
    }
}
