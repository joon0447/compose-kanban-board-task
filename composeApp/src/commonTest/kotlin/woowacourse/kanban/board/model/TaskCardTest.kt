package woowacourse.kanban.board.model

import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class TaskCardTest {

    @Test
    fun `제목과 담당자만으로 태스크 카드를 생성할 수 있다`() {
        val card = TaskCard(title = "구현하기", assignee = "다이노")

        assertThat(card.title).isEqualTo("구현하기")
        assertThat(card.assignee).isEqualTo("다이노")
        assertThat(card.hasDescription).isFalse()
        assertThat(card.hasTags).isFalse()
    }

    @Test
    fun `설명이 있는 태스크 카드를 생성할 수 있다`() {
        val card = TaskCard(
            title = "구현하기",
            description = "상세 설명입니다",
            assignee = "다이노",
        )

        assertThat(card.hasDescription).isTrue()
        assertThat(card.description).isEqualTo("상세 설명입니다")
    }

    @Test
    fun `빈 설명은 설명이 없는 것으로 판단한다`() {
        val card = TaskCard(title = "구현하기", description = "", assignee = "다이노")
        assertThat(card.hasDescription).isFalse()
    }

    @Test
    fun `공백만 있는 설명은 설명이 없는 것으로 판단한다`() {
        val card = TaskCard(title = "구현하기", description = "   ", assignee = "다이노")
        assertThat(card.hasDescription).isFalse()
    }

    @Test
    fun `태그가 있는 태스크 카드를 생성할 수 있다`() {
        val tags = listOf(Tag("컴포넌트"), Tag("성능"))
        val card = TaskCard(title = "구현하기", tags = tags, assignee = "다이노")

        assertThat(card.hasTags).isTrue()
        assertThat(card.tags).hasSize(2)
    }

    @Test
    fun `태그가 비어 있으면 태그가 없는 것으로 판단한다`() {
        val card = TaskCard(title = "구현하기", tags = emptyList(), assignee = "다이노")
        assertThat(card.hasTags).isFalse()
    }

    @Test
    fun `태그는 최대 5개까지 가능하다`() {
        val tags = List(TaskCard.MAX_TAG_COUNT) { Tag("태그$it") }
        val card = TaskCard(title = "구현하기", tags = tags, assignee = "다이노")
        assertThat(card.tags).hasSize(TaskCard.MAX_TAG_COUNT)
    }

    @Test
    fun `태그가 최대 개수를 초과하면 예외가 발생한다`() {
        assertThatThrownBy {
            TaskCard(
                title = "구현하기",
                tags = List(TaskCard.MAX_TAG_COUNT + 1) { Tag("태그$it") },
                assignee = "다이노",
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `제목이 빈 문자열이면 예외가 발생한다`() {
        assertThatThrownBy { TaskCard(title = "", assignee = "다이노") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `제목이 공백만 포함하면 예외가 발생한다`() {
        assertThatThrownBy { TaskCard(title = "   ", assignee = "다이노") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `담당자가 빈 문자열이면 예외가 발생한다`() {
        assertThatThrownBy { TaskCard(title = "구현하기", assignee = "") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `담당자가 공백만 포함하면 예외가 발생한다`() {
        assertThatThrownBy { TaskCard(title = "구현하기", assignee = "   ") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
