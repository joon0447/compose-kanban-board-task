package woowacourse.kanban.board.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.task_planet
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AddButton(modifier: Modifier, showInputWindow: Boolean, onValueChange: (Boolean) -> Unit) {
    Button(
        onClick = { onValueChange(showInputWindow) },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF5CFFD1),
            contentColor = Color.Black,
        ),
        modifier = modifier.size(height = 100.dp, width = 150.dp).padding(10.dp),
    ) {
        ButtonContents(Res.drawable.task_planet, "할일 적는 행성이")
    }
}

@Composable
private fun ButtonContents(resource: DrawableResource, description: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(resource),
            contentDescription = description,
            modifier = Modifier.size(80.dp),
        )
    }
}
