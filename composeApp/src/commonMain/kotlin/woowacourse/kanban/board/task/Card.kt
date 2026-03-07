package woowacourse.kanban.board.task

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
private fun TaskCardPreview() {
    MaterialTheme {
        TaskCard(
            title = "LazyColumn 컴포넌트 구현",
            contents = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tagNames = listOf("너무너무", "성능", "긴 태그", "최대로", "5자까지", "5개제한임"),
            contactName = "디이노"
        )
    }
}

@Composable
fun TaskCard(title: String, contents: String? = null, tagNames: List<String> = emptyList(), contactName: String) {
    Column(
        modifier = Modifier
            .width(286.dp)
            .border(2.dp, Color.LightGray, RoundedCornerShape(10.dp))
            .padding(start = 22.5.dp, end = 22.5.dp, top = 22.5.dp, bottom = 22.5.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TaskTitle(title)
        if (contents != null) TaskContents(contents)
        if (tagNames.isNotEmpty()) TaskTags(tagNames.take(5))
        TaskContact(contactName)
    }
}
