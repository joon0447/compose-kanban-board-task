package woowacourse.kanban.board

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.kanban.board.constant.*

@Composable
fun App() {

}

// KanbanBoardTaskCard 컴포넌트
@Composable
fun KanbanBoardCard(modifier: Modifier, cardData: CardData) {
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color(CARD_BACKGROUND_COLOR),
                shape = RoundedCornerShape(10.dp)
            )
            .width(286.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color(BOARD_BACKGROUND_COLOR))
            .padding(17.dp)
            .testTag(CARD_BODY_TEST)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(17.dp)) {
            // 제목 컴포넌트 선언부
            CardTitle(Modifier, cardData.title)

            // 본문 컴포넌트 선언부
            CardContent(modifier, cardData.content)

            // 태그 컴포넌트 선언부
            CardTags(Modifier, cardData.tags.toList())

            // 구분선
            HorizontalDivider(thickness = 2.dp)

            // 작성자 컴포넌트 선언부
            CardWriterProfile(Modifier, cardData.writer)
        }
    }
}

@Composable
private fun TextComponent(
    modifier: Modifier,
    text: String,
    maxLines: Int = DEFAULT_MAX_LINES,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    fontSize: Int,
    color: Long
) {
    Box (
        modifier = modifier
    ){
        Text(
            text = text,
            maxLines = maxLines,
            overflow = overflow,
            fontSize = fontSize.sp,
            color = Color(color),
        )
    }
}

// title 컴포넌트 생성 함수
@Composable
private fun CardTitle(modifier: Modifier, title: String) {
    TextComponent(
        modifier = modifier.testTag(CARD_TITLE_TEST),
        text = title,
        overflow = TextOverflow.Ellipsis,
        fontSize = TITLE_FONT_SIZE,
        color = TITLE_COLOR
    )
}

// content 컴포넌트 생성 함수
@Composable
private fun CardContent(modifier: Modifier, content: String?) {
    if (content != null) {
        TextComponent(
            modifier.testTag(CARD_CONTENT_TEST),
            text = content,
            maxLines = MAX_TWO_LINES,
            fontSize = CONTENT_FONT_SIZE,
            color = CONTENT_COLOR
        )
    }
}

// tags 컴포넌트 생성 함수
@Composable
private fun CardTags (modifier: Modifier, tags: List<String>) {
    if (tags.isNotEmpty() && tags.size <= 5) {
        FlowRow(
            modifier = modifier.testTag(CARD_TAGS_TEST),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            for (tag in tags) {
                TagComponent(Modifier, tag)
            }
        }
    }
}

@Composable
private fun TagComponent(modifier: Modifier, tag: String) {
    Box(
        modifier = modifier
            .background(
                color = Color(TAG_BACKGROUND_COLOR),
                shape = RoundedCornerShape(45.dp)
            )
    ) {
        Text(
            tag,
            modifier = modifier
                .padding(6.dp),
            fontSize = 10.sp,
            color = Color(TAG_TEXT_COLOR))
    }
}

// icon & writer 컴포넌트 생성 함수
@Composable
private fun CardWriterProfile(modifier: Modifier ,writer: String) {
    Row(
        modifier = modifier.testTag(CARD_WRITER_TEST),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CardWriterIcon(Modifier)
        CardWriterNickname(writer)
    }
}

@Composable
private fun CardWriterIcon(modifier: Modifier) {
    Icon(
        imageVector = Icons.Default.Person,
        contentDescription = null,
        tint = Color.White,
        modifier = modifier
            .size(25.dp, 25.dp)
            .clip(CircleShape)
            .border(width = 2.dp, color = Color.Gray)
            .background(color = Color.Gray),
    )
}

@Composable
private fun CardWriterNickname(writer: String) {
    Text(
        writer,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        fontSize = 14.sp,
        color = Color(WRITER_TEXT_COLOR)
    )
}