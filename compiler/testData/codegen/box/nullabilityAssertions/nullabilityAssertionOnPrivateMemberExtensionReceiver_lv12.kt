// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FILE: test.kt
// LANGUAGE_VERSION: 1.2
class C {
    fun test() { J.s().memberExtension() }
    private fun String.memberExtension() {}
}

inline fun <reified T> shouldThrow(block: () -> Unit) {
    try {
        block()
        throw AssertionError("Should throw")
    }
    catch (e: Throwable) {
        if (e !is T) throw e
    }
}

fun box(): String {
    shouldThrow<IllegalStateException> { C().test() }
    return "OK"
}

// FILE: J.java
public class J {
    public static String s() { return null; }
}