package woowacourse.kanban.board.model

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ContentTest {
    @Test
    fun `본문이 공백이 아닌 문자열이라면 정상적으로 생성된다`() {
        val contentText = "안녕하세요. 본문입니다. 반갑습니다. 잘부탁드립니다"

        val content = Content(contentText)

        assertEquals(contentText, content.text)
    }

    @Test
    fun `본문이 비어있다면 생성되지 않는다`() {
        val contentText = ""

        val exception = assertFailsWith<IllegalArgumentException> {
            Content(contentText)
        }

        assertEquals("본문은 비어있거나 공백일 수 없습니다.", exception.message)
    }

    @Test
    fun `본문에 공백만 있다면 생성되지 않는다`() {
        val contentText = "    "

        val exception = assertFailsWith<IllegalArgumentException> {
            Content(contentText)
        }

        assertEquals("본문은 비어있거나 공백일 수 없습니다.", exception.message)
    }
}
