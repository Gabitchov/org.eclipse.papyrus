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
package org.eclipse.papyrus.customization.properties.storage.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;


/**
 * An action that may be contributed to the Properties View customization dialog on the
 * <tt>org.eclipse.papyrus.customization.properties.contextStorage</tt> extension point
 * to implement copying a {@link Context} to the corresponding storage provider.
 */
public interface IContextCopyAction {

	/**
	 * Queries the (translated) label to show in a copy button in the Properties customization dialog.
	 * 
	 * @return the label to show in the copy button in the customization dialog
	 */
	String getLabel();

	/**
	 * Queries the (translated) tool tip to show on a copy button in the Properties customization dialog.
	 * 
	 * @return the optional tool tip to show on the copy button in the customization dialog.
	 *         May be {@code null}
	 */
	String getToolTip();

	/**
	 * Copy an existing context to a new one with the given name.
	 * The new context is registered to the {@link ConfigurationManager}.
	 * 
	 * @param source
	 *        The source Context to copy
	 * @param targetName
	 *        The name of the new context
	 * @param monitor
	 *        A monitor to track the progress of the copy operation. Will not be {@code null}
	 * @return
	 *         The new Context
	 * 
	 * @throws CoreException
	 *         If an error occurred : the previous context cannot be read, or
	 *         the new context cannot be created
	 */
	Context copy(Context source, String targetName, IProgressMonitor monitor) throws CoreException;

}
