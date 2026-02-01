import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex

object PrintInOrderKt {
    class MutexFoo : OrderedPrinter {
        private val first = Mutex()
        private val second = Mutex(locked = true)
        private val third = Mutex(locked = true)

        override fun first(printFirst: Runnable) = runBlocking {
            first.lock()
            printFirst.run()
            second.unlock()
        }

        override fun second(printSecond: Runnable) = runBlocking {
            second.lock()
            printSecond.run()
            third.unlock()
        }

        override fun third(printThird: Runnable) = runBlocking {
            third.lock()
            printThird.run()
            first.unlock()
        }
    }

    class FlowFoo : OrderedPrinter {
        private val order = MutableStateFlow(Order.FIRST)

        override fun first(printFirst: Runnable) = runBlocking {
            order.first { it == Order.FIRST }
            printFirst.run()
            order.update { Order.SECOND }
        }

        override fun second(printSecond: Runnable) = runBlocking {
            order.first { it == Order.SECOND }
            printSecond.run()
            order.update { Order.THIRD }
        }

        override fun third(printThird: Runnable) = runBlocking {
            order.first { it == Order.THIRD }
            printThird.run()
            order.update { Order.FIRST }
        }

        private enum class Order {
            FIRST, SECOND, THIRD
        }
    }
}
