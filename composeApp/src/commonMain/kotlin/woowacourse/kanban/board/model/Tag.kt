package woowacourse.kanban.board.model

import woowacourse.kanban.board.constants.TAG_ERROR_MESSAGE

@JvmInline
value class Tag(val name: String) {
    init {
        require(name.isNotBlank()) { TAG_ERROR_MESSAGE }
    }
}
