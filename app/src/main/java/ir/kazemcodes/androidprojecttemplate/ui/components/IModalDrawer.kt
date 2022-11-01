package ir.kazemcodes.androidprojecttemplate.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IModalDrawer(
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    state: DrawerState,
    sheetContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    if (isEnable) {
        ModalNavigationDrawer(
            modifier = Modifier,
            drawerState = state,
            drawerContent = {
                DismissibleDrawerSheet(
                    drawerContentColor = MaterialTheme.colorScheme.onSurface,
                    drawerContainerColor = MaterialTheme.colorScheme.surface,

                    ) {
                    sheetContent()
                }
            },
            scrimColor = Color.Transparent,
            content = content,
        )
    } else {
        content()
    }
}