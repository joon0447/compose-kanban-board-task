package woowacourse.kanban.board

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Checker(modifier: Modifier = Modifier) {
    val checked = remember { mutableStateOf(false) }
    Column(modifier = modifier.testTag("")) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = !checked.value },
            modifier = modifier
        )
    }
    checked.value = true
}

@Composable
@Preview(showBackground = true)
fun App() {
    Checker(modifier = Modifier.padding(20.dp))
}
