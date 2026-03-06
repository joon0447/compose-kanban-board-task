package woowacourse.kanban.board.study

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

class ComposeTestRule {
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun `노드 병합`() = runComposeUiTest {
        setContent {
            Button({ }, modifier = Modifier.testTag("버튼")) {
                Text("확인")
                Text("버튼")
            }
        }
        onNodeWithText("확인").assertExists()
    }
}
