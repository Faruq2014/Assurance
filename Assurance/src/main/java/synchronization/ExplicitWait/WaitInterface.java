package synchronization.ExplicitWait;

import java.util.function.Function;

import org.openqa.selenium.support.ui.Wait;

public class WaitInterface<F> implements Wait<F>{

	/**
		 *<T> T until​(java.util.function.Function<? super F,​T> isTrue)
	Implementations should wait until the condition evaluates to a value that is neither null nor false. Because of this contract, the return type must not be Void.
	If the condition does not become true within a certain time (as defined by the implementing class), this method will throw a non-specified Throwable. This is so that an implementor may throw whatever is idiomatic for a given test infrastructure (e.g. JUnit4 would throw AssertionError).
	
	Type Parameters:
	T - the return type of the method, which must not be Void
	Parameters:
	isTrue - the parameter to pass to the ExpectedCondition
	Returns:
	truthy value from the isTrue condition
	 */
	@Override
	public <T> T until(Function<? super F, T> isTrue) {
		// TODO Auto-generated method stub
		return null;
	}

}
