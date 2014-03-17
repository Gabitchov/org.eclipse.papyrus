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

import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * A Test Runner which is aware of Classification-related annotations.
 *
 * It ignores the test methods according to their annotations, and the policy defined
 * in {@link ClassificationConfig}
 *
 *
 * @see {@link ClassificationConfig}
 * @see {@link TestCategory}
 *
 * @author Camille Letavernier
 *
 */
public class ClassificationRunner extends BlockJUnit4ClassRunner {

	public ClassificationRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected void runChild(FrameworkMethod method, RunNotifier notifier) {
		if(ClassificationConfig.shouldRun(method.getAnnotations())) {
			super.runChild(method, notifier);
		} else {
			Description description = describeChild(method);
			notifier.fireTestIgnored(description);
		}
	}

}
