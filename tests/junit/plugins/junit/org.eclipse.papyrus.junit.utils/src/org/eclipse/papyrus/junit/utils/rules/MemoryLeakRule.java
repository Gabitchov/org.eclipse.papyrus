/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.junit.utils.rules;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.JUnit4;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * A simple JUnit rule for tracking memory leaks. Simply {@linkplain #add(Object) add objects} during your test execution, make assertions if desired,
 * and on successful completion of the body of the test, this rule verifies that none of the tracked objects have leaked.
 * Tests that are sensitive to references being retained temporarily via {@link SoftReference}s should be annotated as {@link SoftReferenceSensitive
 * &#x40;SoftReferenceSensitive} so that the rule may employ extra measures to ensure that soft references are cleared.
 * 
 * @see SoftReferenceSensitive
 */
public class MemoryLeakRule extends TestWatcher {

	private static final Map<Class<?>, Boolean> WARMED_UP_SUITES = new WeakHashMap<Class<?>, Boolean>();

	private static boolean warmingUp;

	private ReferenceQueue<Object> queue;

	private List<WeakReference<Object>> tracker;

	private String testName;

	private Class<?> testClass;

	private boolean isSoftReferenceSensitive;

	private ComposedAdapterFactory factory;

	public MemoryLeakRule() {
		super();
	}

	public void add(Object leak) {
		assertThat("Cannot track null references for memory leaks.", leak, notNullValue());

		if(queue == null) {
			queue = new ReferenceQueue<Object>();
			tracker = Lists.newArrayList();
			factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}

		tracker.add(new WeakReference<Object>(leak, queue));
	}

	public String getTestName() {
		return testName;
	}

	@Override
	protected void starting(Description description) {
		testName = description.getMethodName();
		testClass = description.getTestClass();

		isSoftReferenceSensitive = description.getAnnotation(SoftReferenceSensitive.class) != null;

		if(isSoftReferenceSensitive && !isWarmedUp() && !warmingUp) {
			// Warm up the soft-reference sensitive tests by running this one up-front, first,
			// because the first such test to execute always results in a spurious failure
			// (at least, such is the case on the Mac build of JRE 1.6)
			warmingUp = true;
			try {
				warmUp();
			} finally {
				warmingUp = false;
			}
		}
	}

	@Override
	protected void succeeded(Description description) {
		// If the test's assertions (if any) all succeeded, then check for leaks on the way out
		if(tracker == null) {
			// No leaks to assert
			return;
		}

		// Assert that our tracked objects are now all unreachable
		while(!tracker.isEmpty()) {
			Reference<?> ref = dequeueTracker();

			if((ref == null) && isSoftReferenceSensitive) {
				// Maybe there are soft references retaining our objects? Desperation move
				forceClearSoftReferenceCaches();

				// Try once more
				ref = dequeueTracker();
			}

			if(!tracker.remove(ref) && !tracker.isEmpty()) {
				// The remaining tracked elements are leaked
				fail("One or more objects leaked:\n" + Joiner.on('\n').join(Iterables.transform(tracker, label())));
				break; // Unreachable
			}
		}
	}

	@Override
	protected void finished(Description description) {
		// Clean up
		tracker = null;
		queue = null;
		disposeFactory();
	}

	void disposeFactory() {
		if(factory != null) {
			factory.dispose();
			factory = null;
		}
	}

	Reference<?> dequeueTracker() {
		Reference<?> result = null;

		try {
			for(int i = 0; (result == null) && (i < 3); i++) {
				// Try to force GC
				collectGarbage();

				result = queue.remove(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail("JUnit was interrupted");
		}

		return result;
	}

	Function<WeakReference<?>, String> label() {
		return new Function<WeakReference<?>, String>() {

			public String apply(WeakReference<?> input) {
				return label(input.get());
			}
		};
	}

	String label(Object input) {
		IItemLabelProvider provider = (IItemLabelProvider)factory.adapt(input, IItemLabelProvider.class);
		String result = (provider == null) ? String.valueOf(input) : provider.getText(input);

		if(Strings.isNullOrEmpty(result)) {
			result = String.valueOf(input);
		}

		return result;
	}

	void collectGarbage() {
		// Try a few times to decrease the amount of used heap space
		final Runtime rt = Runtime.getRuntime();

		Long usedMem = rt.totalMemory() - rt.freeMemory();
		Long prevUsedMem = usedMem;

		for(int i = 0; (prevUsedMem <= usedMem) && (i < 10); i++) {
			rt.gc();
			Thread.yield();

			prevUsedMem = usedMem;
			usedMem = rt.totalMemory() - rt.freeMemory();
		}
	}

	void forceClearSoftReferenceCaches() {
		// There are components in the Eclipse workbench that maintain soft references to objects for
		// performance caches.  For example, the the Common Navigator Framework used by Model Explorer
		// caches mappings of elements in the tree to the content extensions that provided them using
		// EvalutationReferences [sic] that are SoftReferences

		// This is a really gross HACK and runs the risk that some other thread(s) also may see OOMEs!
		try {
			List<Object[]> hog = Lists.newLinkedList();
			for(int size = getLargeMemorySize(); size > 0; size = getLargeMemorySize()) {
				hog.add(new Object[size]);
			}
		} catch (OutOfMemoryError e) {
			// Good!  The JVM guarantees that all soft references are cleared before throwing OOME,
			// so we can be assured that they are now cleared
		} finally {
			if(warmingUp) {
				// We have successfully warmed up the soft-references hack
				WARMED_UP_SUITES.put(testClass, true);
			}
		}
	}

	private static int getLargeMemorySize() {
		return Math.min(Math.abs((int)Runtime.getRuntime().freeMemory()), Integer.MAX_VALUE);
	}

	private boolean isWarmedUp() {
		return Boolean.TRUE.equals(WARMED_UP_SUITES.get(testClass));
	}

	private void warmUp() {
		try {
			// The first test that relies on the soft-reference clearing hack will
			// always fail, so run such a test once up-front. Call this a metahack
			JUnit4 runner = new JUnit4(testClass);
			runner.filter(new Filter() {

				@Override
				public boolean shouldRun(Description description) {
					return Objects.equal(description.getTestClass(), testClass) && Objects.equal(description.getMethodName(), testName);
				}

				@Override
				public String describe() {
					return "Warm-up test run";
				}
			});
			runner.run(new RunNotifier());
		} catch (Exception e) {
			// Fine, so the warm-up didn't work
			e.printStackTrace();
		}
	}

	//
	// Nested types
	//

	/**
	 * Annotates a test that is sensitive to references being cached by {@link SoftReference}s.
	 * Such tests will take additional drastic measures to try to force the JVM to clear soft
	 * reference caches in order to release all possible references to objects tracked for leaks.
	 * Because the first such test is expected always to result in a spurious failure (at least,
	 * such is the case on the Mac OS X build of J2SE 1.6), the rule "warms up" the test suite
	 * by running one such test in isolation before running any others.
	 */
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface SoftReferenceSensitive {
		// Empty annotation
	}
}
