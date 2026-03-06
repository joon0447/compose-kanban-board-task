package woowacourse.kanban.board.model

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertIs

class DescriptionTest {
    @Test
    fun `유효한 텍스트인 경우 유효하다`() {
        val description = Description("Description text")
        assertIs<Description>(description)
        val content = description as Description
        assert(content.text == "Description text")
    }
}
