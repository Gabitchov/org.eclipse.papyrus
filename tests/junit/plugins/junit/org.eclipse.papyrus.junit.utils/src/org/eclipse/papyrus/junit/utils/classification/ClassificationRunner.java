/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - add support for conditional tests
 *
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils.classification;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.papyrus.junit.utils.rules.ConditionRule;
import org.eclipse.papyrus.junit.utils.rules.Conditional;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * A Test Runner which is aware of Classification-related annotations and {@link Conditional @Conditional} tests.
 *
 * It ignores the test methods according to their annotations, and the policy defined
 * in {@link ClassificationConfig}
 *
 *
 * @see {@link ClassificationConfig}
 * @see {@link TestCategory}
 * @see Conditional
 *
 * @author Camille Letavernier
 *
 */
public class ClassificationRunner extends BlockJUnit4ClassRunner {

	private final ThreadLocal<Object> preparedTest = new ThreadLocal<Object>();

	public ClassificationRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected void runChild(FrameworkMethod method, RunNotifier notifier) {
		List<Annotation> allAnnotations = ListHelper.asList(method.getAnnotations());
		allAnnotations.addAll(Arrays.asList(method.getMethod().getDeclaringClass().getAnnotations()));
		if(ClassificationConfig.shouldRun(allAnnotations.toArray(new Annotation[allAnnotations.size()])) && conditionSatisfied(method)) {
			super.runChild(method, notifier);
		} else {
			Description description = describeChild(method);
			notifier.fireTestIgnored(description);
		}
	}

	@Override
	protected Object createTest() throws Exception {
		// Look for a prepared test instance
		Object result = preparedTest.get();
		if(result != null) {
			// We won't need this test instance again
			clearPreparedTest();
		} else {
			result = basicCreateTest();
		}

		return result;
	}

	protected final Object basicCreateTest() throws Exception {
		return super.createTest();
	}

	protected final Object prepareTest() throws Exception {
		// Prepare the test instance and stash it to return on the next invocation
		Object result = basicCreateTest();
		preparedTest.set(result);
		return result;
	}

	protected final void clearPreparedTest() {
		preparedTest.remove();
	}

	private boolean conditionSatisfied(FrameworkMethod method) {
		boolean result = true;

		// Does this test declare some precondition?
		Conditional conditional = method.getAnnotation(Conditional.class);
		if(conditional != null) {
			try {
				// We need the test instance to invoke the condition on it, so prepare it now
				Object test = prepareTest();
				result = ConditionRule.testCondition(method.getMethod().getDeclaringClass(), conditional, test);
			} catch (Throwable t) {
				// If we couldn't create the test, then we should just ignore it
				result = false;
			} finally {
				if(!result) {
					// We won't be running the test, so forget the prepared instance (if any)
					clearPreparedTest();
				}
			}
		}

		return result;
	}
}
