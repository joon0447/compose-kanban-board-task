package woowacourse.kanban.board.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import woowacourse.kanban.board.model.Assignee
import woowacourse.kanban.board.model.Description
import woowacourse.kanban.board.model.TagGroup
import woowacourse.kanban.board.model.TaskCard
import woowacourse.kanban.board.model.Title

@Composable
fun TaskCardView(taskCard: TaskCard) {
    TaskCardView(
        title = Title(taskCard.title),
        description = Description(taskCard.description),
        tagGroup = TagGroup(tags = taskCard.tags),
        assignee = Assignee(name = taskCard.assignee),
    )
}

@Composable
fun TaskCardView(
    title: Title,
    description: Description,
    tagGroup: TagGroup,
    assignee: Assignee,
) {
    Box(
        modifier = Modifier.border(
            border = BorderStroke(1.dp, Color.LightGray),
            shape = RoundedCornerShape(8.dp),
        ).width(250.dp).padding(8.dp),
    ) {
        Column {
            TitleView(title = title)
            if (!description.isEmpty()) {
                DescriptionView(description = description)
            }
            if (!tagGroup.isEmpty()) {
                TagGroupView(tagGroup = tagGroup)
            }
            HorizontalDivider(modifier = Modifier.background(Color.Gray))
            AssigneeView(assignee = assignee)
        }
    }
}
