package woowacourse.kanban.board.model

data class TaskCardData(val title: String?, val script: String?, val tags: List<String>?, val nickname: String?) {
    init {
        require(!title.isNullOrEmpty()) { "제목을 불러오는 중 오류가 발생했습니다." }
        require(script != null) { "내용을 불러오는 중 오류가 발생했습니다." }
        require(tags != null) { "태그를 불러오는 중 오류가 발생했습니다." }
        require(!nickname.isNullOrEmpty()) { "닉네임을 불러오는 중 오류가 발생했습니다." }
    }
}
