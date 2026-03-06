package woowacourse.kanban.board.model

import kotlin.test.Test
import kotlin.test.assertFailsWith

class TagTest {
    @Test
    fun `태그 텍스트가 공란일 수 없다`() {
        assertFailsWith<IllegalArgumentException> {
            Tag("")
        }
    }

    @Test
    fun `태그 텍스트는 5글자 이하여야 한다`() {
        val tag = Tag("hello")
        assert(tag.text == "hello")
        assert(tag.text.length <= Tag.MAXIMUM_TAG_LENGTH)
    }

    @Test
    fun `태그 텍스트가 5글자를 초과하면 에러가 발생한다`() {
        assertFailsWith<IllegalArgumentException> {
            Tag("toolong")
        }
    }
}
