package woowacourse.kanban.board.model

import woowacourse.kanban.board.constants.CREW_ERROR_MESSAGE

@JvmInline
value class Crew(val name: String) {
    init {
        require(name.isNotBlank()) { CREW_ERROR_MESSAGE }
    }
}
