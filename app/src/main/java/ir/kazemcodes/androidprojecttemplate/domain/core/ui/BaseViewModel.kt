package ir.kazemcodes.androidprojecttemplate.domain.core.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import ir.kazemcodes.androidprojecttemplate.R
import ir.kazemcodes.androidprojecttemplate.domain.core.events.UiEvent
import ir.kazemcodes.androidprojecttemplate.domain.core.events.UiText
import ir.kazemcodes.androidprojecttemplate.domain.core.prefs.Preference
import ir.kazemcodes.androidprojecttemplate.domain.core.prefs.PreferenceMutableState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

abstract class BaseViewModel : androidx.lifecycle.ViewModel() {

    protected val scope: CoroutineScope
        get() = viewModelScope

    private val activeScope = MutableStateFlow<CoroutineScope?>(null)

    protected val _eventFlow = MutableSharedFlow<UiEvent>()
    open val eventFlow = _eventFlow.asSharedFlow()

    open fun showSnackBar(message: UiText?) {
        viewModelScope.launch {
            _eventFlow.showSnackBar(message ?: UiText.StringResource(R.string.error_unknown))
        }
    }

    final override fun onCleared() {
        onDestroy()
    }

    open fun onDestroy() {
    }

    fun <T> Preference<T>.asState() = PreferenceMutableState(this, scope)

    fun <T> Preference<T>.asState(onChange: (T) -> Unit): PreferenceMutableState<T> {
        this.changes()
            .onEach { onChange(it) }
            .launchIn(scope)
        return PreferenceMutableState(this, scope)
    }

    fun <T> Flow<T>.asState(initialValue: T, onChange: (T) -> Unit = {}): State<T> {
        val state = mutableStateOf(initialValue)
        scope.launch {
            collect {
                state.value = it
                onChange(it)
            }
        }
        return state
    }

    fun <T> StateFlow<T>.asState(): State<T> {
        val state = mutableStateOf(value)
        scope.launch {
            collect { state.value = it }
        }
        return state
    }

    fun <T> Flow<T>.launchWhileActive(): Job {
        return activeScope
            .filterNotNull()
            .onEach { launchIn(it) }
            .launchIn(scope)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun <T> Flow<T>.launchWhenActive() = channelFlow<T> {
        scope.launch {
            activeScope
            this@launchWhenActive.filterNotNull()
                .first {
                    send(it)
                    true
                }
        }
    }

    internal fun setActive() {
        val currScope = activeScope.value
        if (currScope != null) return
        activeScope.value = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())
    }

    internal fun setInactive() {
        val currScope = activeScope.value
        currScope?.cancel()
        activeScope.value = null
    }
}
suspend fun MutableSharedFlow<UiEvent>.showSnackBar(message: UiText?) {
    this.emit(
        UiEvent.ShowSnackbar(
            uiText = message ?: UiText.StringResource(R.string.error_unknown)
        )
    )
}
