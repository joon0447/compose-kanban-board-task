package woowacourse.kanban.board.component.card

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TagChipGroupTest {
    @Test
    fun `태그 그룹이 정상적으로 표시된다`() = runComposeUiTest {
        val tags = listOf("태그1", "태그2", "태그3")

        setContent {
            TagChipGroup(tags)
        }

        tags.forEach { tag ->
            onNodeWithText(tag).assertIsDisplayed()
        }
    }

    @Test
    fun `태그 그룹의 태그가 5개 이상이면 5개만 표시된다`() = runComposeUiTest {
        val tags = listOf("태그1", "태그2", "태그3", "태그4", "태그5", "태그6")

        setContent {
            TagChipGroup(tags)
        }

        tags.forEachIndexed { index, tag ->
            if (index < 5) {
                onNodeWithText(tag).assertIsDisplayed()
            } else {
                onNodeWithText(tag).assertDoesNotExist()
            }
        }
    }

    @Test
    fun `태그 그룹의 태그가 n개 이상이면 n개만 표시된다`() = runComposeUiTest {
        val tags = listOf("태그1", "태그2", "태그3", "태그4", "태그5", "태그6")
        val n = 3

        setContent {
            TagChipGroup(
                tags = tags,
                maxTagCount = n,
            )
        }

        tags.forEachIndexed { index, tag ->
            if (index < n) {
                onNodeWithText(tag).assertIsDisplayed()
            } else {
                onNodeWithText(tag).assertDoesNotExist()
            }
        }
    }
}
