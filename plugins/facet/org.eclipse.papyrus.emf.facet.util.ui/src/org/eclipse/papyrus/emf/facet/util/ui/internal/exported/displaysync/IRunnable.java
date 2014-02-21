/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Grégoire Dupé (Mia-Software) - Bug 365808 - [Unit Test Failure][0.2/4.2][0.2/3.8] org.eclipse.emf.facet.widgets.nattable.tests.NatTableAPITests
 *    Grégoire Dupé (Mia-Software) - Bug 367153 - synchronization utilities
 *******************************************************************************/
package org.eclipse.emf.facet.util.ui.internal.exported.displaysync;

public interface IRunnable<T extends Object, E extends Exception> {
	T run() throws E;
}
