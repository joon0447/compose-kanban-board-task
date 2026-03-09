package woowacourse.kanban.board

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.TaskCard
import woowacourse.kanban.board.model.TaskCardData

@Composable
fun App() {
    FlowRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(38.dp),
        maxItemsInEachRow = 4,
        horizontalArrangement = Arrangement.spacedBy(52.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        TaskCard(
            data = TaskCardData(
                title = "LazyColumn 컴포넌트 구현",
                script = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tags = listOf("컴포넌트", "성능"),
                nickname = "다이노",
            ),
        )
        TaskCard(
            data = TaskCardData(
                title = "LazyColumn 컴포넌트 구현",
                tags = listOf("컴포넌트", "성능"),
                script = "",
                nickname = "다이노",
            ),
        )
        TaskCard(
            data = TaskCardData(
                title = "LazyColumn 컴포넌트 구현",
                script = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tags = emptyList(),
                nickname = "다이노",
            ),
        )
        TaskCard(
            data = TaskCardData(
                title = "LazyColumn 컴포넌트 구현",
                script = "",
                tags = emptyList(),
                nickname = "다이노",
            ),
        )
        TaskCard(
            data = TaskCardData(
                title = "너무 너무 긴 제목은 한 줄 까지만 노출시킵니다.",
                script = "너무 너무 너무 긴 설명은 두 줄까지만 노출하고 말 줄임표로 처리합니다. 두 줄 까지만 노출합니다.",
                tags = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임"),
                nickname = "너무너무긴 담당자 이름도 한줄로 하고 줄임표 처리합니다.",
            ),
        )
    }
}
