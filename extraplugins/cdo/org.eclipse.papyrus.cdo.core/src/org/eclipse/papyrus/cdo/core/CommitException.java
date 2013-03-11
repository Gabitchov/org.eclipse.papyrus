/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.l10n.Messages;


/**
 * This is the CommitException type.  Enjoy.
 */
public class CommitException
		extends CoreException {

	private static final long serialVersionUID = 1L;

	public CommitException() {
		this(Messages.CommitException_0);
	}

	public CommitException(String message) {
		super(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message));
	}

	public CommitException(Throwable cause) {
		this(Messages.CommitException_0, cause);
	}

	public CommitException(String message, Throwable cause) {
		super(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, cause));
	}

}
