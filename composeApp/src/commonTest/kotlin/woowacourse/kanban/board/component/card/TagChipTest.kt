package woowacourse.kanban.board.component.card

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TagChipTest {
    @Test
    fun `태그 칩이 정상적으로 생성된다`() = runComposeUiTest {
        val tagName = "난태그야"

        setContent {
            TagChip(tagName)
        }

        onNodeWithText(tagName).assertIsDisplayed()
    }

    @Test
    fun `태그 이름이 5글자 이상일 때 5글자만 보여준다`() = runComposeUiTest {
        val tagName = "난태그야근데좀길어"

        setContent {
            TagChip(tagName)
        }

        onNodeWithText(tagName.take(5)).assertIsDisplayed()
        onNodeWithText(tagName).assertDoesNotExist()
    }

    @Test
    fun `태그 이름이 n글자 이상일 때 n글자만 보여준다`() = runComposeUiTest {
        val tagName = "난태그야근데좀길어"
        val n = 3

        setContent {
            TagChip(
                tag = tagName,
                maxLength = n,
            )
        }

        onNodeWithText(tagName.take(n)).assertIsDisplayed()
        onNodeWithText(tagName).assertDoesNotExist()
    }
}
