package com.raiden.learningunittest.chapter8.exercise2

@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.CLASS,
    AnnotationTarget.FILE
)
annotation class Retry(
    //the number of time to try this method before the failure is propagated through
    val times: Int = 2
)
