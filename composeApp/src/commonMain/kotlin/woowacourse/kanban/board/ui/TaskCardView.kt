package woowacourse.kanban.board.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.TaskCard

@Composable
fun TaskCardView(taskCard: TaskCard, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.width(240.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = taskCard.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            if (taskCard.hasDescription) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = taskCard.description,
                    fontSize = 13.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            if (taskCard.hasTags) {
                Spacer(modifier = Modifier.height(12.dp))
                TagRow(tags = taskCard.tags.map { it.name })
            }

            Spacer(modifier = Modifier.height(12.dp))
            AssigneeRow(name = taskCard.assignee)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun TagRow(tags: List<String>) {
    FlowRow(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
        tags.forEach { tag ->
            TagChip(text = tag)
        }
    }
}

@Composable
private fun TagChip(text: String) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        color = Color(0xFFF1F1F1),
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun AssigneeRow(name: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(Color(0xFFD9D9D9)),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = name,
            fontSize = 13.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

private class TaskCardPreviewParameter : PreviewParameterProvider<TaskCard> {
    override val values: Sequence<TaskCard>
        get() = sequenceOf(
            TaskCard(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                tags = listOf(Tag("컴포넌트"), Tag("성능")),
                assignee = "다이노",
            ),
            TaskCard(
                title = "LazyColumn 컴포넌트 구현",
                tags = listOf(Tag("컴포넌트"), Tag("성능")),
                assignee = "다이노",
            ),
            TaskCard(
                title = "LazyColumn 컴포넌트 구현",
                description = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                assignee = "다이노",
            ),
            TaskCard(
                title = "LazyColumn 컴포넌트 구현",
                assignee = "다이노",
            ),
            TaskCard(
                title = "너무너무 긴 제목은 한 줄이지만 노출되고 말줄임표로 처리합니다",
                description = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다",
                tags = listOf(Tag("너무너무"), Tag("긴 태그"), Tag("최대로"), Tag("5자까지"), Tag("5개제한임")),
                assignee = "너무너무너무 긴 담당자도 한 줄이지만 노출되고 말줄임표로 처리합니다",
            ),
        )
}

@Preview
@Composable
private fun TaskCardPreview(@PreviewParameter(TaskCardPreviewParameter::class) parameter: TaskCard) {
    MaterialTheme {
        TaskCardView(
            taskCard = parameter,
        )
    }
}
