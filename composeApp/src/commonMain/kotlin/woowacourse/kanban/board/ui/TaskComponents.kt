package woowacourse.kanban.board.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.profile_image
import org.jetbrains.compose.resources.painterResource
import woowacourse.kanban.board.model.TaskCardDto
import woowacourse.kanban.board.model.TaskCardDtoProvider

@Preview(showBackground = true)
@Composable
fun TaskCard(@PreviewParameter(TaskCardDtoProvider::class) taskCardDto: TaskCardDto) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier.width(286.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(17.dp),
        ) {
            // 제목
            TaskTitle(taskCardDto.title)
            // 내용
            if (taskCardDto.contents.isNotBlank() ) TaskContents(taskCardDto.contents)
            // 태그
            if (taskCardDto.tags.isNotEmpty() && taskCardDto.tags.all { it.isNotEmpty() } ) TaskTags(taskCardDto.tags)
            // 작성자
            TaskAuthor(taskCardDto.author)
        }
    }
}

@Composable
fun TaskCardList(taskCardGroup: List<TaskCardDto>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(taskCardGroup.size) { item ->
            TaskCard(taskCardDto = taskCardGroup[item])
        }
    }
}

// @Preview(showBackground = true)
@Composable
private fun TaskTitle(@PreviewParameter(TitleProvider::class) title: String) {
    Text(
        text = title,
        modifier = Modifier
            .size(width = 252.dp, height = 26.dp),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

private class TitleProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf(
        "제목",
        "너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무 긴 제목",
    )
}

// @Preview(showBackground = true)
@Composable
private fun TaskContents(@PreviewParameter(ContentsProvider::class) contents: String) {
    Text(
        text = contents,
        modifier = Modifier
            .size(width = 252.dp, height = 40.dp),
        fontSize = 14.sp,
        color = Color.Gray,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
}

private class ContentsProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf(
        "내용",
        "너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무너무 긴 내용",
    )
}

@Composable
private fun TaskTags(tags: List<String>) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        tags.forEach { tag ->
            Tag(tag)
        }
    }
}

// @Preview(showBackground = true)
@Composable
private fun Tag(@PreviewParameter(TagProvider::class) tag: String) {
    SuggestionChip(
        label = { Text(tag, style = TextStyle(fontSize = 12.sp)) },
        onClick = { },
        modifier = Modifier.height(24.dp),
    )
}

private class TagProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String> = sequenceOf(
        "태그",
        "태그222"
    )
}

@Composable
private fun TaskAuthor(author: String) {
    Row(
        modifier = Modifier.size(width = 252.dp, height = 45.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        AuthorIdleImage()
        AuthorName(author)
    }
}

// @Preview(showBackground = true)
@Composable
private fun AuthorIdleImage() {
    Image(
        painter = painterResource(Res.drawable.profile_image),
        contentDescription = "프로필 이미지",
        modifier = Modifier.size(24.dp),
    )
}

@Composable
private fun AuthorName(author: String) {
    Text(
        text = author,
        modifier = Modifier.height(20.dp),
        fontSize = 14.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}
