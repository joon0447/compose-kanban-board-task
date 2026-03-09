package woowacourse.kanban.board.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.component.card.ContentText
import woowacourse.kanban.board.component.card.Profile
import woowacourse.kanban.board.component.card.TagChipGroup
import woowacourse.kanban.board.component.card.TitleText
import woowacourse.kanban.board.model.Content
import woowacourse.kanban.board.model.Crew
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.Title

@Composable
fun KanbanCard(
    title: Title,
    crew: Crew,
    modifier: Modifier = Modifier,
    content: Content? = null,
    tags: List<Tag> = emptyList(),
) {
    Column(
        modifier = modifier
            .width(286.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .border(1.dp, Color(0xffE5E7EB), shape = RoundedCornerShape(10.dp))
            .padding(17.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TitleText(title.text)
        if (content != null) {
            ContentText(content.text)
        }
        TagChipGroup(tags.map { it.name })
        HorizontalDivider(color = Color(0xffE5E7EB))
        Profile(crew.name)
    }
}

private data class KanbanCardParameters(
    val crew: Crew,
    val title: Title,
    val content: Content? = null,
    val tags: List<Tag> = emptyList(),
)

private class KanbanCardPreviewParameterProvider : PreviewParameterProvider<KanbanCardParameters> {
    override val values = sequenceOf(
        KanbanCardParameters(
            title = Title("LazyColumn 컴포넌트 구현"),
            content = Content("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."),
            tags = listOf(Tag("컴포넌트"), Tag("성능")),
            crew = Crew("다이노"),
        ),
        KanbanCardParameters(
            title = Title("LazyColumn 컴포넌트 구현"),
            tags = listOf(Tag("컴포넌트"), Tag("성능")),
            crew = Crew("다이노"),
        ),
        KanbanCardParameters(
            title = Title("LazyColumn 컴포넌트 구현"),
            content = Content("세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."),
            crew = Crew("다이노"),
        ),
        KanbanCardParameters(
            title = Title("LazyColumn 컴포넌트 구현"),
            crew = Crew("다이노"),
        ),
        KanbanCardParameters(
            title = Title("너무너무 긴 제목은 한 줄까지만 노출 노출 노출 노출 노출"),
            content = Content("너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임"),
            crew = Crew("너무너무너무 긴 담당자도 한 줄너무너무너무 긴 담당자도 한 줄...너무너무너무 긴 담당자도 한 줄...너무너무너무 긴 담당자도 한 줄..."),
            tags = listOf(
                Tag("너무너무"),
                Tag("긴 태그"),
                Tag("최대로"),
                Tag("5자까지"),
                Tag("5개제한임"),
                Tag("나는6번"),
            ),
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun KanbanCardPreview(@PreviewParameter(KanbanCardPreviewParameterProvider::class) parameters: KanbanCardParameters) {
    KanbanCard(
        title = parameters.title,
        content = parameters.content,
        tags = parameters.tags,
        crew = parameters.crew,
    )
}
