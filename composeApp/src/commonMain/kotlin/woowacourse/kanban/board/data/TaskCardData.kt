package woowacourse.kanban.board.data

data class TaskItem(
    val title: String,
    val contents: String?,
    val tagNames: List<String>,
    val contactName: String,
)

object TaskCardData {
    val tasks = listOf(
        TaskItem(
            title = "LazyColumn 컴포넌트 구현",
            contents = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tagNames = listOf("컴포넌트", "성능"),
            contactName = "다이노",
        ),
        TaskItem(
            title = "LazyColumn 컴포넌트 구현",
            contents = null,
            tagNames = listOf("컴포넌트", "성능"),
            contactName = "다이노",
        ),
        TaskItem(
            title = "LazyColumn 컴포넌트 구현",
            contents = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tagNames = emptyList(),
            contactName = "다이노",
        ),
        TaskItem(
            title = "LazyColumn 컴포넌트 구현",
            contents = null,
            tagNames = emptyList(),
            contactName = "다이노",
        ),
        TaskItem(
            title = "너무너무긴제목은 한줄까지만 노출됩니다.",
            contents = "너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다. 너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다.",
            tagNames = listOf("너무너무", "성능", "긴 태그", "최대로", "5자까지", "5개제한임"),
            contactName = "너무너무너무 긴 담당자도 한 줄로 표시됩니다.",
        ),
    )
}

