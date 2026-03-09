package woowacourse.kanban.board.taskCard

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun TaskCard(
    @PreviewParameter(TaskCardPreviewParameterProvider::class) taskInfo: TaskInfo,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.border(2.dp, Color.LightGray, RoundedCornerShape(10.dp))
            .padding(start = 22.5.dp, end = 22.5.dp, top = 22.5.dp, bottom = 22.5.dp),
        verticalArrangement = Arrangement.spacedBy(18.5.dp),
    ) {
        TaskTitle(taskInfo.title)
        taskInfo.contents?.let { TaskContents(taskInfo.contents) }
        taskInfo.tags?.let { TaskTags(taskInfo.tags, Modifier.height(32.dp)) }
        taskInfo.contactName?.let { TaskContact(taskInfo.contactName, Modifier.width(336.dp).height(60.dp)) }
    }
}

private class TaskCardPreviewParameterProvider : PreviewParameterProvider<TaskInfo> {
    override val values: Sequence<TaskInfo> = sequenceOf(
        TaskInfo(
            title = "LazyColumn 컴포넌트 구현",
            contents = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tags = listOf(Tag("컴포넌트"), Tag("성능")),
            contactName = "다이노",
        ),
        TaskInfo(
            title = "LazyColumn 컴포넌트 구현",
            tags = listOf(Tag("컴포넌트"), Tag("성능")),
            contactName = "다이노",
        ),
        TaskInfo(
            title = "LazyColumn 컴포넌트 구현",
            contents = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            contactName = "다이노",
        ),
        TaskInfo(
            title = "LazyColumn 컴포넌트 구현",
            contactName = "다이노",
        ),
        TaskInfo(
            title = "너무너무 긴 제목은 한 줄까지만 노출되고 말줄임표로 처리합니다.",
            contents = "너무너무 긴 본문은 두 줄까지만 노출되고 말줄임표로 처리합니다. 너무너무 긴 본문은 두 줄까지만 노출되고 말줄임표로 처리합니다.",
            tags = listOf(Tag("긴 태그"), Tag("최대로"), Tag("5자까지"), Tag("5개제한임"), Tag("줄임표가되...")),
            contactName = "너무너무너무 긴 담당자도 한 줄 까지만 노출되곷 말줄임표로 처리합니다.",
        ),

        )


}