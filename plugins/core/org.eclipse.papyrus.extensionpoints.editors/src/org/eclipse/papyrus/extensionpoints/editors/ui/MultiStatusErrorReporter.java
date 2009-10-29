/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.ui;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.extensionpoints.editors.Activator;

/**
 * Implementation of the {@link IErrorReporter} interface that returns a {@link MultiStatus}.
 */
public class MultiStatusErrorReporter implements IErrorReporter {

	/** list of children for multi status */
	private final List<IStatus> childrens = new ArrayList<IStatus>();

	/**
	 * {@inheritDoc}
	 */
	public void reportError(RecognitionException exception) {
		childrens.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, exception.getMessage(), exception));
	}

	/**
	 * {@inheritDoc}
	 */
	public void initErrorReporter() {
		childrens.clear();
	}

	/**
	 * Compiles the new mutli Status and returns it.
	 * 
	 * @return the multistatus compiled.
	 */
	// @unused
	public MultiStatus compileMultiStatus() {
		if (childrens != null && !childrens.isEmpty()) {
			MultiStatus multiStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, "Message for Multistatus", null);
			for (IStatus status : childrens) {
				multiStatus.add(status);
			}
			return multiStatus;
		}
		return new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, "", null);
	}

}
