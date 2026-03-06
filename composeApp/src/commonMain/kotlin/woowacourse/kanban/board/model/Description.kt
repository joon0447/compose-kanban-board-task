package woowacourse.kanban.board.model

data class Description(val text: String) {
    fun isEmpty(): Boolean = text.isEmpty()

    companion object {
        val empty: Description = Description("")
    }
}
