// FILE: A.kt

open class A {
    open fun f(): Int = 1
}

// FILE: B.kt
// RECOMPILE

class B : A() {
    override fun f(): Int = super.f() + 2
}

// FILE: box.kt

fun box(): String {
    val af = A().f()
    if (af != 1) return "fail: A().f() == $af"

    val bf = B().f()
    if (bf != 3) return "fail: B().f() == $bf"

    return "OK"
}