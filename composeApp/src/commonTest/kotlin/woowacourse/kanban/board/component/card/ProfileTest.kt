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
class ProfileTest {
    @Test
    fun `크루 이름이 정상적으로 표시된다`() = runComposeUiTest {
        val crewName = "볼트"

        setContent {
            Profile(crewName)
        }

        onNodeWithText(crewName).assertIsDisplayed()
    }

    @Test
    fun `크루 이름 길다면 오버플로우 UI가 정상적으로 표시된다`() = runComposeUiTest {
        val crewName = "볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트"

        setContent {
            Profile(
                name = crewName,
                modifier = Modifier
                    .width(50.dp),
            )
        }

        val textLayoutResult = mutableListOf<TextLayoutResult>()

        onNodeWithText(crewName).performSemanticsAction(GetTextLayoutResult) {
            it(textLayoutResult)
        }

        assertEquals(textLayoutResult.first().isLineEllipsized(0), true)
    }

    @Test
    fun `크루 이름 길어도 한 줄로 표시된다`() = runComposeUiTest {
        val crewName = "볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트볼트"

        setContent {
            Profile(
                name = crewName,
                modifier = Modifier
                    .width(50.dp),
            )
        }

        val textLayoutResult = mutableListOf<TextLayoutResult>()

        onNodeWithText(crewName).performSemanticsAction(GetTextLayoutResult) {
            it(textLayoutResult)
        }

        assertEquals(textLayoutResult.first().lineCount, 1)
    }
}
