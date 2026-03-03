package woowacourse.kanban.board

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class CheckerTest {

    @Test
    fun `체크박스 체크되지 않았으면 텍스트 미노출`() = runComposeUiTest {
        // given
        var checked by mutableStateOf(false)

        // 세팅: 테스트할 컴포저블 화면을 구성한다
        setContent {
            CheckerView(check = {}, checked = checked)
        }

        // then: Finder를 통해 텍스트를 찾고, Assertion으로 노출 여부를 단언한다
        onNodeWithText("체크됨!!!")
            .assertDoesNotExist()
    }

    @Test
    fun `체크박스 체크되면 텍스트 노출`() = runComposeUiTest {
        // given
        var checked by mutableStateOf(true)

        // 세팅
        setContent {
            CheckerView(check = {}, checked = checked)
        }

        // then
        onNodeWithText("체크됨!!!")
            .assertExists()
    }
}



