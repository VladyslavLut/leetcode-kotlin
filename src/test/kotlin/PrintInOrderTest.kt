import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import java.util.Collections
import kotlin.concurrent.thread

class PrintInOrderTest {

    @DataProvider(name = "implementations")
    fun implementations(): Array<OrderedPrinter> {
        return arrayOf(
            PrintInOrder.SemaphoresFoo(),
            PrintInOrder.SynchronizedFoo(),
            PrintInOrderKt.MutexFoo(),
            PrintInOrderKt.FlowFoo()
        )
    }

    @Test(dataProvider = "implementations")
    fun `concurrency test - normal order`(foo: OrderedPrinter) {
        val result = Collections.synchronizedList(ArrayList<String>())
        
        val t1 = thread(start = false) { foo.first { result.add("first") } }
        val t2 = thread(start = false) { foo.second { result.add("second") } }
        val t3 = thread(start = false) { foo.third { result.add("third") } }

        t1.start()
        t2.start()
        t3.start()
        
        t1.join()
        t2.join()
        t3.join()
        
        assert(result == listOf("first", "second", "third")) {
            "Expected [first, second, third] but got $result for ${foo::class.simpleName}"
        }
    }

    @Test(dataProvider = "implementations")
    fun `concurrency test - reverse order`(foo: OrderedPrinter) {
        val result = Collections.synchronizedList(ArrayList<String>())
        
        val t1 = thread(start = false) { foo.first { result.add("first") } }
        val t2 = thread(start = false) { foo.second { result.add("second") } }
        val t3 = thread(start = false) { foo.third { result.add("third") } }

        t3.start()
        t2.start()
        t1.start()
        
        t1.join()
        t2.join()
        t3.join()
        
        assert(result == listOf("first", "second", "third")) {
            "Expected [first, second, third] but got $result for ${foo::class.simpleName}"
        }
    }

    @Test(dataProvider = "implementations")
    fun `concurrency test - mixed order 1`(foo: OrderedPrinter) {
        val result = Collections.synchronizedList(ArrayList<String>())
        
        val t1 = thread(start = false) { foo.first { result.add("first") } }
        val t2 = thread(start = false) { foo.second { result.add("second") } }
        val t3 = thread(start = false) { foo.third { result.add("third") } }

        t1.start()
        t3.start()
        t2.start()
        
        t1.join()
        t2.join()
        t3.join()
        
        assert(result == listOf("first", "second", "third")) {
            "Expected [first, second, third] but got $result for ${foo::class.simpleName}"
        }
    }
    
    @Test(dataProvider = "implementations")
    fun `concurrency test - mixed order 2`(foo: OrderedPrinter) {
        val result = Collections.synchronizedList(ArrayList<String>())
        
        val t1 = thread(start = false) { foo.first { result.add("first") } }
        val t2 = thread(start = false) { foo.second { result.add("second") } }
        val t3 = thread(start = false) { foo.third { result.add("third") } }

        t2.start()
        t1.start()
        t3.start()
        
        t1.join()
        t2.join()
        t3.join()
        
        assert(result == listOf("first", "second", "third")) {
            "Expected [first, second, third] but got $result for ${foo::class.simpleName}"
        }
    }

    @Test(dataProvider = "implementations")
    fun `concurrency test - loop`(foo: OrderedPrinter) {
        val result = Collections.synchronizedList(ArrayList<String>())
        val loops = 100
        
        val t1 = thread(start = false) { 
            repeat(loops) { 
                foo.first { result.add("first") } 
            }
        }
        val t2 = thread(start = false) { 
            repeat(loops) {
                foo.second { result.add("second") }
            }
        }
        val t3 = thread(start = false) { 
            repeat(loops) {
                foo.third { result.add("third") }
            }
        }

        // Randomize start order to stress test
        listOf(t1, t2, t3)
            .shuffled()
            .onEach { it.start() }
            .onEach { it.join() }
        
        val expected = ArrayList<String>()
        repeat(loops) {
            expected.add("first")
            expected.add("second")
            expected.add("third")
        }
        
        assert(result == expected) {
            "Loop test failed for ${foo::class.simpleName}. \nExpected size: ${expected.size}, Actual size: ${result.size}. \nFirst 10 items: ${result.take(10)}"
        }
    }
}