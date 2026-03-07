package woowacourse.kanban.board.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.card.ContentText
import woowacourse.kanban.board.component.card.TitleText
import woowacourse.kanban.board.component.card.Profile
import woowacourse.kanban.board.component.card.TagChipGroup
import woowacourse.kanban.board.theme.Color.blueGray100
import woowacourse.kanban.board.theme.Color.blueGray200
import kotlin.collections.listOf

@Composable
fun KanbanCard(
    name: String,
    title: String? = null,
    content: String? = null,
    tags: List<String> = emptyList()
) {
    Column(
        modifier = Modifier
            .width(286.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, blueGray100, shape = RoundedCornerShape(10.dp))
            .padding(17.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TitleText(title)
        ContentText(content)
        TagChipGroup(tags)
        HorizontalDivider(color = blueGray200)
        Profile(name)
    }
}


/** preview **/

const val TITLE_MAX_EX = "LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현LazyColumn 컴포넌트 구현"

const val CONTENT_EX = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."
const val CONTENT_MAX_EX =  "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노...너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노..."

const val NAME_EX = "다이노"
const val NAME_MAX_EX = "다이노다이노다이노다이노다이노다이노다이노다이노다이노"

val TAG_GROUP_EX = listOf("컴포넌트", "성능")
val TAG_GROUP_MAX_EX = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임", "나는6번")

data class KanbanCardPreviewData(
    val title: String? = null,
    val content: String? = null,
    val tags: List<String> = emptyList(),
    val name: String = NAME_EX,
)

class TagPreviewParameterProvider : PreviewParameterProvider<KanbanCardPreviewData> {
    override val values = sequenceOf(
        KanbanCardPreviewData(content = CONTENT_EX, tags = TAG_GROUP_EX),
        KanbanCardPreviewData(tags = TAG_GROUP_EX),
        KanbanCardPreviewData(content = CONTENT_EX, tags = TAG_GROUP_EX),
        KanbanCardPreviewData(),
        KanbanCardPreviewData(title = TITLE_MAX_EX, content = CONTENT_EX, TAG_GROUP_MAX_EX, name = CONTENT_MAX_EX)
    )
}


@Preview(showBackground = true)
@Composable
private fun KanbanCardPreview(
    @PreviewParameter(TagPreviewParameterProvider::class) kanbanCardPreview: KanbanCardPreviewData,
) {
    Box(
        modifier = Modifier
            .padding(10.dp),
    ) {
        KanbanCard(
            title = kanbanCardPreview.title,
            content = kanbanCardPreview.content,
            tags = kanbanCardPreview.tags,
            name = kanbanCardPreview.name
        )
    }
}