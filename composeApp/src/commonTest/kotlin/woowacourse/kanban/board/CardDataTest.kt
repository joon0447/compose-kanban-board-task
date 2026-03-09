package woowacourse.kanban.board

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

@OptIn(ExperimentalTestApi::class)
class CardDataTest {
    @Test
    fun `제목 미입력 오류 테스트`() = runComposeUiTest {
        assertFailsWith<IllegalArgumentException> {
            CardData.createCard(
                title = "",
                content = "본문",
                tags = listOf("태그"),
                writer = "작성자"
            )
        }
    }

    @Test
    fun `작성자 정보 미입력 오류 테스트`() = runComposeUiTest {
        assertFailsWith<IllegalArgumentException> {
            CardData.createCard(
                title = "제목",
                content = "본문",
                tags = listOf("태그"),
                writer = ""
            )
        }
    }

    @Test
    fun `태그 개수(5개 이상) 검증 테스트`() = runComposeUiTest {
        assertFailsWith<IllegalArgumentException> {
            CardData.createCard(
                title = "제목",
                content = "본문",
                tags = listOf("태그1", "태그2", "태그3", "태그4", "태그5", "태그6"),
                writer = "작성자"
            )
        }
    }

    @Test
    fun `태그 글자수(5글자 이상) 검증 테스트`() = runComposeUiTest {
        assertFailsWith<IllegalArgumentException> {
            CardData.createCard(
                title = "제목",
                content = "본문",
                tags = listOf("5글자 이상인 태그가 존재하면 오류 발생"),
                writer = "작성자"
            )
        }
    }

    @Test
    fun `모든 정보가 입력된 경우`() = runComposeUiTest {
        val card = CardData.createCard(
            title = "제목",
            content = " 본문",
            tags = listOf("태그1", "태그2"),
            writer = "작성자"
        )

        assertNotNull(card, "객체 생성됨")
    }

    @Test
    fun `본문을 입력하지 않았을 경우`() = runComposeUiTest {
        val card = CardData.createCard(
            title = "제목",
            tags = listOf("태그1", "태그2"),
            writer = "작성자"
        )

        assertNotNull(card, "객체 생성됨")
    }

    @Test
    fun `태그를 입력하지 않았을 경우`() = runComposeUiTest {
        val card = CardData.createCard(
            title = "제목",
            content = " 본문",
            writer = "작성자"
        )

        assertNotNull(card, "객체 생성됨")
    }

    @Test
    fun `본문, 태그 둘 다 입력되지 않았을 경우`() = runComposeUiTest {
        val card = CardData.createCard(
            title = "제목",
            writer = "작성자"
        )

        assertNotNull(card, "객체 생성됨")
    }
}