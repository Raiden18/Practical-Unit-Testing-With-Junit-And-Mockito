package com.raiden.learningunittest.chapter8.exercise2

import java.io.PrintWriter
import java.io.StringWriter

//An exception must be thrown to signal a retry operation has retries more that allowed times
class RetryException(message: String) : RuntimeException(message) {
    companion object {

        fun from(throwables: Array<Throwable>): RetryException {
            val message = StringBuilder("Invoked methods still failed after " + throwables.size + " attempts.")
            for (i in throwables.indices) {
                val exception = throwables[1]
                message.append('\n')
                message.append("Attempt ").append(i).append(" threw exception:")
                message.append(stackTraceAsString(exception))
            }
            return RetryException(message.toString())
        }

        private fun stackTraceAsString(t: Throwable): String {
            val errors = StringWriter()
            t.printStackTrace(PrintWriter(errors))
            return errors.toString()
        }
    }
}
