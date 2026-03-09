package woowacourse.kanban.board.taskCard

import kotlin.test.Test
import kotlin.test.assertEquals

class TaskInfoTest {
    private val safeTitle = "매우 정상적인 제목"
    private val safeContent = "매우 정상적인 본문"
    private val safeTags = listOf(Tag("정상"), Tag("적인"), Tag("태그"))
    private val safeContactName = "매우 정상적인 담당자명"
    private val blankString = ""
    private val emptyString = " "

    @Test
    fun `정상적인 제목, 본문, 태그, 담당자명을 전달하면 TaskInfo 객체가 생성된다`() {
        // given
        // when
        val taskInfo = TaskInfo(
            title = safeTitle,
            contents = safeContent,
            tags = safeTags,
            contactName = safeContactName,
        )

        // then
        assertEquals(safeTitle, taskInfo.title)
        assertEquals(safeContent, taskInfo.contents)
        assertEquals(safeTags, taskInfo.tags)
        assertEquals(safeContactName, taskInfo.contactName)
    }

    @Test
    fun `제목에 빈 문자열을 전달하면 예외가 발생한다`() {

        try {
            // given
            // when
            val taskInfo = TaskInfo(title = emptyString)

        } catch (e: IllegalArgumentException) {
            // then
            assertEquals("제목은 공백이거나 빈 문자열일 수 없습니다.", e.message)
        }
    }

    @Test
    fun `제목에 공백을 전달하면 예외가 발생한다`() {
        try {
            // given
            // when
            val taskInfo = TaskInfo(title = blankString)

        } catch (e: IllegalArgumentException) {
            // then
            assertEquals("제목은 공백이거나 빈 문자열일 수 없습니다.", e.message)
        }
    }

    @Test
    fun `본문에 빈 문자열을 전달하면 예외가 발생한다`() {

        try {
            // given
            // when
            val taskInfo = TaskInfo(title = safeTitle, contents = emptyString)

        } catch (e: IllegalArgumentException) {
            // then
            assertEquals("본문은 공백이거나 빈 문자열일 수 없습니다.", e.message)
        }
    }

    @Test
    fun `본문에 공백을 전달하면 예외가 발생한다`() {
        try {
            // given
            // when
            val taskInfo = TaskInfo(title = safeTitle, contents = blankString)

        } catch (e: IllegalArgumentException) {
            // then
            assertEquals("본문은 공백이거나 빈 문자열일 수 없습니다.", e.message)
        }
    }

    @Test
    fun `태그에 빈 리스트를 전달하면 예외가 발생한다`() {
        try {
            // given
            val emptyList = emptyList<Tag>()

            // when
            val taskInfo = TaskInfo(title = safeTitle, tags = emptyList)

        } catch (e: IllegalArgumentException) {
            // then
            assertEquals("태그 리스트는 비어있을 수 없습니다.", e.message)
        }
    }

    @Test
    fun `담당자 이름에 빈 문자열을 전달하면 예외가 발생한다`() {
        try {
            // given
            // when
            val taskInfo = TaskInfo(title = safeTitle, contactName = emptyString)

        } catch (e: IllegalArgumentException) {
            // then
            assertEquals("담당자 이름은 공백이거나 빈 문자열일 수 없습니다.", e.message)
        }
    }

    @Test
    fun `담당자 이름에 공백을 전달하면 예외가 발생한다`() {
        try {
            // given
            // when
            val taskInfo = TaskInfo(title = safeTitle, contactName = blankString)

        } catch (e: IllegalArgumentException) {
            // then
            assertEquals("담당자 이름은 공백이거나 빈 문자열일 수 없습니다.", e.message)
        }
    }
}