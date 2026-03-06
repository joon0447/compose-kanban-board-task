package woowacourse.kanban.board.model

data class BoardComponent(val title: String = "", val content: String = "", val tags: List<String> = listOf(), val name: String = "")
