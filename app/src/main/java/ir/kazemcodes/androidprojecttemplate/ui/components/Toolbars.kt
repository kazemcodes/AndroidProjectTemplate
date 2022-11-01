package ir.kazemcodes.androidprojecttemplate.ui.components

import androidx.compose.material3.*

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit) = {},
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    elevation: Dp = 8.dp,
    applyInsets: Boolean = false,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    Surface(
        modifier = modifier,
        color = backgroundColor,
        contentColor = contentColor,
        shadowElevation = elevation,
    ) {
        TopAppBar(
            title = title,
            modifier = if (applyInsets) modifier.statusBarsPadding() else modifier,
            navigationIcon = navigationIcon,
            actions = actions,
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = backgroundColor,
                titleContentColor = contentColor,
                scrolledContainerColor = backgroundColor,
                actionIconContentColor = contentColor,
                navigationIconContentColor =contentColor
            ),
            scrollBehavior = scrollBehavior
        )
    }
}
