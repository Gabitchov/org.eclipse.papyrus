/*******************************************************************************
 * Copyright (c) 2011-2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Grégoire Dupé (Mia-Software) - Bug 365808 - [Unit Test Failure][0.2/4.2][0.2/3.8] org.eclipse.papyrus.emf.facet.widgets.nattable.tests.NatTableAPITests
 *    Grégoire Dupé (Mia-Software) - Bug 367153 - synchronization utilities
 *    Nicolas Bros (Mia-Software) - Bug 370442 - rewrite the Facet loading dialog for v0.2
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * <ul>
 * <li>syncExecWithResult (has return type, throws exception)
 * <li>safeSyncExec (has return type, no exception)
 * <li>voidSyncExec (no return type, throws exception)
 * <li>voidExceptionFreeRunnable (no return type, no exception)
 * </ul>
 */
public class SynchronizedComposite<C extends Composite> extends SynchronizedObject<C> {

	public SynchronizedComposite(final C composite) {
		super(composite, composite.getDisplay());
	}
	
	@Deprecated
	protected C getSynchronizedComposite() {
		return getSynchronizedObject();
	}

}
