package woowacourse.kanban.board.model

import kotlin.test.Test
import kotlin.test.assertFailsWith

class AssigneeTest {
    @Test
    fun `담당자는 빈 텍스트일 수 없다`() {
        assertFailsWith<IllegalArgumentException> {
            Assignee("")
        }
    }

    @Test
    fun `담당자는 유효한 이름으로 생성된다`() {
        val assignee = Assignee("John Doe")
        assert(assignee.name == "John Doe")
    }
}
