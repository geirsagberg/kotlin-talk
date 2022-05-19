import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.string.shouldNotBeEmpty
import net.sagberg.fetchQuote

class FetchQuoteTest : StringSpec({
    "can fetch quote" {
        fetchQuote().toString().shouldNotBeEmpty()
    }
})
