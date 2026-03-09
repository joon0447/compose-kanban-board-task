package woowacourse.kanban.board

data class CardData(
    val title: String,
    val content: String? = null,
    val tags: List<String> = listOf(),
    val writer: String
) {
    companion object {
        fun createCard(
            title: String,
            content: String? = null,
            tags: List<String> = listOf<String>(),
            writer: String
        ): CardData {

            require(title.isNotBlank()) { "카드의 제목을 입력해주세요." }
            require(writer.isNotBlank()) { "작성자의 닉네임을 입력해주세요." }
            require(tags.size < 6) { "태그는 5개까지 입력 가능합니다." }
            require(isLongerThenFive(tags)) { "한 태그에는 최대 5자까지 입력 가능합니다." }

            return CardData(title, content, tags, writer)
        }

        private fun isLongerThenFive(tags: List<String>): Boolean {
            return !tags.any { it.length > 6 }
        }
    }
}