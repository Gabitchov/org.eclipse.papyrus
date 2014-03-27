/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 366367 - To be able to change the "CanBePresentedInTheTable" query
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog;

import org.eclipse.swt.widgets.Shell;

/** A simple dialog with a title, a message, and "yes" and "no" buttons */
public interface IQuestionDialog {

	/** Opens the dialog */
	void open();

	/** Programmatically emulate a press on the "Yes" button */
	void pressYes();

	/** Programmatically emulate a press on the "No" button */
	void pressNo();

	/** Add a listener that will be modified when the dialog closes */
	void addCloseListener(final Runnable runnable);

	/**
	 * Get the user's answer
	 * 
	 * @return <ul>
	 *         <li><code>true</code> if the user clicked "Yes"
	 *         <li><code>false</code> if the user clicked "No"
	 *         <li><code>null</code> if the user closed the dialog without clicking either on "Yes" or "No"
	 *         </ul>
	 */
	Boolean getResult();

	/** @return the dialog's shell */
	Shell getShell();
}
