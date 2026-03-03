package woowacourse.kanban.board.model

import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class TagTest {

    @Test
    fun `유효한 이름으로 태그를 생성할 수 있다`() {
        val tag = Tag("컴포넌트")
        assertThat(tag.name).isEqualTo("컴포넌트")
    }

    @Test
    fun `태그 이름이 최대 길이와 같으면 정상 생성된다`() {
        val tag = Tag("a".repeat(Tag.MAX_LENGTH))
        assertThat(tag.name).hasSize(Tag.MAX_LENGTH)
    }

    @Test
    fun `태그 이름이 빈 문자열이면 예외가 발생한다`() {
        assertThatThrownBy { Tag("") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `태그 이름이 공백만 포함하면 예외가 발생한다`() {
        assertThatThrownBy { Tag("   ") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `태그 이름이 최대 길이를 초과하면 예외가 발생한다`() {
        assertThatThrownBy { Tag("a".repeat(Tag.MAX_LENGTH + 1)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
