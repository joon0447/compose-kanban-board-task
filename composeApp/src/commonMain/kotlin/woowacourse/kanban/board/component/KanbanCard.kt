package woowacourse.kanban.board.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource

/**
 * @param tags 최대 5개까지만 표시되는 태그 리스트입니다. 5개를 초과하면 상위 5개만 렌더링됩니다.
 */
@Composable
fun KanbanCard(
    title: String,
    crewName: String,
    modifier: Modifier = Modifier,
    tags: List<String> = emptyList(),
    content: String = "",
    crewImage: DrawableResource? = null,
) {
    require(title.isNotBlank()) { "KanbanCard의 title은 비어 있을 수 없습니다." }

    Column(
        modifier = modifier
            .width(286.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
            .border(Dp.Hairline, Color.Gray, RoundedCornerShape(10.dp))
            .padding(17.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        if (content.isNotBlank()) {
            Text(
                text = content,
                fontSize = 14.sp,
                color = Color.DarkGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }

        if (tags.isNotEmpty()) {
            KanbanCardTags(tags = tags)
        }

        HorizontalDivider(thickness = Dp.Hairline, color = Color.LightGray)

        KanbanCardProfile(
            crewName = crewName,
            crewImage = crewImage,
        )
    }
}

@Composable
private fun KanbanCardTags(tags: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        tags
            .take(5)
            .forEach { tag -> TagChip(name = tag) }
    }
}

data class KanbanCardInfo(
    val title: String,
    val crewName: String,
    val modifier: Modifier = Modifier,
    val tags: List<String> = emptyList(),
    val content: String = "",
    val crewImage: DrawableResource? = null,
)

class KanbanCardPreviewParameterProvider : PreviewParameterProvider<KanbanCardInfo> {
    val tags = listOf("컴포넌트", "성능")
    override val values = sequenceOf(
        KanbanCardInfo(
            title = "LazyColumn 컴포넌트 구현",
            crewName = "바드",
            tags = tags,
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
        ),
        KanbanCardInfo(
            title = "LazyColumn 컴포넌트 구현",
            crewName = "바드",
            tags = tags,
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
        ),
        KanbanCardInfo(
            title = "LazyColumn 컴포넌트 구현",
            crewName = "바드",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
        ),
        KanbanCardInfo(
            title = "LazyColumn 컴포넌트 구현",
            crewName = "바드",
        ),
    )
}

@Preview
@Composable
private fun KanbanCardPreview(@PreviewParameter(KanbanCardPreviewParameterProvider::class) kanbanCardInfo: KanbanCardInfo) {
    Box(modifier = Modifier.padding(12.dp)) {
        KanbanCard(
            title = kanbanCardInfo.title,
            crewName = kanbanCardInfo.crewName,
            modifier = kanbanCardInfo.modifier,
            tags = kanbanCardInfo.tags,
            content = kanbanCardInfo.content,
            crewImage = kanbanCardInfo.crewImage,
        )
    }
}

@Preview
@Composable
private fun KanbanCardMaxPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        KanbanCard(
            title = "너무너무 긴 제목은 한 줄까지만 노출합니다. 그렇습니다. 감사합니다.",
            crewName = "바드바드바드바드바드바드바드바드바드바드바드바드바드바드",
            tags = listOf("컴포넌트", "성능", "긴 태그", "최대로", "5자까지", "5개제한임.", "6개임"),
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.".repeat(3),
        )
    }
}
