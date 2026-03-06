package woowacourse.kanban.board.model

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertIs

class TagGroupTest {
    @Test
    fun `최대 5개의 태그를 생성할 수 있다`() {
        val tags = listOf(
            Tag("tag1"),
            Tag("tag2"),
            Tag("tag3"),
            Tag("tag4"),
            Tag("tag5")
        )
        val tagGroup = TagGroup(tags)
        assertIs<TagGroup>(tagGroup)
        val items = tagGroup as TagGroup
        assert(items.tags.size == 5)
    }

    @Test
    fun `태그 개수가 5개를 초과하면 에러가 발생한다`() {
        val tags = listOf(
            Tag("tag1"),
            Tag("tag2"),
            Tag("tag3"),
            Tag("tag4"),
            Tag("tag5"),
            Tag("tag6")
        )
        assertFailsWith<IllegalArgumentException> {
            TagGroup(tags)
        }
    }
}
