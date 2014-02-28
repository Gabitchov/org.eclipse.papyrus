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

import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

import org.junit.Assume;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;


/**
 * A JUnit {@linkplain Rule rule} that skips tests annotated as {@linkplain Conditional @Conditional} when their {@linkplain Condition conditions} are
 * not satisfied. This model is compatible with the JUnit execution and reporting in the Papyrus Hudson build, which does not understand
 * {@linkplain Assume#assumeThat(Object, org.hamcrest.Matcher) assumption failures} and reports them as test failures.
 * 
 * @see Conditional
 * @see Condition
 * @see Rule
 */
public class ConditionRule implements MethodRule {

	public ConditionRule() {
		super();
	}

	public Statement apply(final Statement base, final FrameworkMethod method, final Object target) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				if(testCondition(method.getMethod().getDeclaringClass(), method.getAnnotation(Conditional.class), target)) {
					base.evaluate();
				}
			}
		};
	}

	protected boolean testCondition(Class<?> testClass, Conditional conditional, Object test) {
		boolean result = true;

		if(conditional != null) {
			Method conditionMethod = findConditionMethod(testClass, conditional);
			if(conditionMethod != null) {
				result = evaluateCondition(conditionMethod, test);
			} else {
				Field conditionField = findConditionField(testClass, conditional);
				if(conditionField != null) {
					result = evaluateCondition(conditionField, test);
				} else {
					fail("Condition not found: " + conditional.key());
				}
			}
		}

		return result;
	}

	protected Method findConditionMethod(Class<?> testClass, Conditional conditional) {
		Method result = null;

		for(Method next : testClass.getDeclaredMethods()) {
			Condition condition = next.getAnnotation(Condition.class);
			if((condition != null) && match(conditional.key(), condition, next)) {
				result = next;
				break;
			}
		}

		return result;
	}

	protected Field findConditionField(Class<?> testClass, Conditional conditional) {
		Field result = null;

		for(Field next : testClass.getDeclaredFields()) {
			Condition condition = next.getAnnotation(Condition.class);
			if((condition != null) && match(conditional.key(), condition, next)) {
				result = next;
				break;
			}
		}

		return result;
	}

	protected boolean evaluateCondition(Method conditionMethod, Object test) {
		boolean result = true;

		try {
			result = (Boolean)conditionMethod.invoke(test);
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
			fail("Condition method evaluation failed: " + e.getTargetException().getLocalizedMessage());
		} catch (Exception e) {
			fail(String.format("Condition method must be public, accept no arguments, and return a boolean result: %s::%s()", conditionMethod.getDeclaringClass().getSimpleName(), conditionMethod.getName()));
		}

		return result;
	}

	protected boolean evaluateCondition(Field conditionField, Object test) {
		boolean result = true;

		try {
			result = (Boolean)conditionField.get(test);
		} catch (Exception e) {
			fail(String.format("Condition field must be public and boolean-valued: %s::%s", conditionField.getDeclaringClass().getSimpleName(), conditionField.getName()));
		}

		return result;
	}

	static boolean match(String conditionKey, Condition condition, Member conditionMember) {
		String match = condition.key();
		if((match == null) || match.equals("")) {
			match = conditionMember.getName();
		}

		return match.equals(conditionKey);
	}
}
