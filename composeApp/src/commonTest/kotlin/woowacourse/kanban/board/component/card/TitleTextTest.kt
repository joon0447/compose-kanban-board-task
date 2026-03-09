package woowacourse.kanban.board.component.card

import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsActions.GetTextLayoutResult
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.test.runComposeUiTest
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.unit.dp
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
class TitleTextTest {
    @Test
    fun `제목이 정상적으로 표시된다`() = runComposeUiTest {
        val title = "안녕하세요"

        setContent {
            TitleText(title = title)
        }

        onNodeWithText(title).assertIsDisplayed()
    }

    @Test
    fun `제목이 길다면 오버플로우 UI가 정상적으로 표시된다`() = runComposeUiTest {
        val title = "안녕하세요. 오버플로우나게 제목을 길게 해보겠습니다.안녕하세요. 오버플로우나게 제목을 길게 해보겠습니다.안녕하세요. 오버플로우나게 제목을 길게 해보겠습니다."

        setContent {
            TitleText(
                title = title,
                modifier = Modifier.width(40.dp),
            )
        }

        val textLayoutResult = mutableListOf<TextLayoutResult>()

        onNodeWithText(title).performSemanticsAction(GetTextLayoutResult) {
            it(textLayoutResult)
        }

        assertEquals(textLayoutResult.first().isLineEllipsized(0), true)
    }

    @Test
    fun `제목이 길어도 한줄로 표시된다`() = runComposeUiTest {
        val title = "안녕하세요. 오버플로우나게 제목을 길게 해보겠습니다.안녕하세요. 오버플로우나게 제목을 길게 해보겠습니다.안녕하세요. 오버플로우나게 제목을 길게 해보겠습니다."

        setContent {
            TitleText(
                title = title,
                modifier = Modifier.width(40.dp),
            )
        }

        val textLayoutResult = mutableListOf<TextLayoutResult>()

        onNodeWithText(title).performSemanticsAction(GetTextLayoutResult) {
            it(textLayoutResult)
        }

        assertEquals(textLayoutResult.first().lineCount, 1)
    }
}
