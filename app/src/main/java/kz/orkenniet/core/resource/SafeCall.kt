package kz.orkenniet.core.resource

inline fun <T> safeCall(action: () -> Resource<T>): Resource<T> {
    return try {
        action()
    } catch (e: Exception) {
        Resource.Error(e.message ?: "An unknown Error Occurred")
    }
}

inline fun <reified T> Resource<T>.doOnSuccess(action: (T) -> Unit) {
    if (this is Resource.Success) {
//        action.invoke(this.data)
    }
}

inline fun <T> Resource<T>.doOnError(action: (T) -> Unit) {
    if (this is Resource.Error) {
//        action.invoke()
    }
}