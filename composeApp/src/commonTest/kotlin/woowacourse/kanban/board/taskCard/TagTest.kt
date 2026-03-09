package woowacourse.kanban.board.taskCard

import kotlin.test.Test
import kotlin.test.assertEquals

class TagTest {
    @Test
    fun `정상적인 태그 명을 전달하면 Tag 객체가 생성된다`() {
        // given
        val safeTagName = "정상태그명"
        // when
        val tag = Tag(safeTagName)
        // then
        assertEquals(safeTagName, tag.name)
    }

    @Test
    fun `태그 명에 공백을 전달하면 예외가 발생한다`() {
        try {
            // given
            val blankTagName = " "
            // when
            val tag = Tag(blankTagName)
        } catch (e: IllegalArgumentException) {
            // then
            assertEquals("태그 명은 공백이거나 빈 문자열일 수 없습니다.", e.message)
        }
    }

    @Test
    fun `태그 명에 빈 문자열을 전달하면 예외가 발생한다`() {
        try {
            // given
            val emptyTagName = ""
            // when
            val tag = Tag(emptyTagName)
        } catch (e: IllegalArgumentException) {
            // then
            assertEquals("태그 명은 공백이거나 빈 문자열일 수 없습니다.", e.message)
        }
    }

    @Test
    fun `n개를 초과하는 태그 리스트를 전달하면 n개만 반환한다`() {
        // given
        val manyTags = listOf(Tag("긴 태그"), Tag("최대로"), Tag("5자까지"), Tag("5개제한임"), Tag("6개부터는 생략됩니다"))
        val maxTagCount = 5
        // when
        val tags = takeNTags(manyTags, maxTagCount)
        // then
        assertEquals(maxTagCount, tags.size)
    }

    @Test
    fun `n글자를 초과하는 태그 명을 전달하면 n글자 뒤는 자르고 말줄임표를 붙여 반환한다`() {
        // given
        val longTagName = "아주아주긴태그명"
        val maxTagLength = 5
        val expectedTagName = longTagName.take(maxTagLength) + "..."
        // when
        val tag = Tag(longTagName)
        val formattedTagName = tag.formatTagName(maxTagLength)
        // then
        assertEquals(expectedTagName, formattedTagName)
    }
}