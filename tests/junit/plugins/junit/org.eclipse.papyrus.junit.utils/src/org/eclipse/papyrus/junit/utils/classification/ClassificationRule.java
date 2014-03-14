/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils.classification;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * This rule must be used with Classification annotations
 *
 * @author Camille Letavernier
 *
 * @see {@link InvalidTest}
 * @see {@link NotImplemented}
 *
 */
public class ClassificationRule implements MethodRule {

	public Statement apply(final Statement base, final FrameworkMethod method, final Object target) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				if(ClassificationConfig.shouldRun(method.getAnnotations())) {
					System.out.println("Do run");
					base.evaluate();
				} else {
					System.out.println("Skip "+method.getName());
				}
			}
		};
	}
}
