package woowacourse.kanban.board.model

import kotlin.test.Test
import kotlin.test.assertFailsWith

class TitleTest {
    @Test
    fun `제목은 빈 텍스트일 수 없다`() {
        assertFailsWith<IllegalArgumentException> {
            Title("")
        }
    }

    @Test
    fun `제목은 유효한 텍스트로 생성된다`() {
        val title = Title("Task Title")
        assert(title.text == "Task Title")
    }
}
