package woowacourse.kanban.board.model

data class TagGroup(val tags: List<Tag>){
    init {
        require(tags.size <= MAXIMUM_TAG_COUNT) { "[ERROR] 태그 개수는 ${MAXIMUM_TAG_COUNT}개 이하여야합니다." }
    }

    fun isEmpty(): Boolean {
        return tags.isEmpty()
    }

    companion object {
        const val MAXIMUM_TAG_COUNT = 5
    }
}