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


/**
 * An action that may be contributed to the Properties View customization dialog on the
 * <tt>org.eclipse.papyrus.customization.properties.contextStorage</tt> extension point
 * to support opening an editor on the {@link Context} in the associated storage.
 */
public interface IContextEditAction {

	/**
	 * Queries the (translated) tool tip to show on the "Edit..." button in the Properties
	 * customization dialog for {@link Context}s in the storage providers supported by the
	 * extension.
	 * 
	 * @return the optional tool tip to show on the "Edit..." button in the customization dialog.
	 *         May be {@code null}
	 */
	String getToolTip();

	/**
	 * Open an editor to edit an context.
	 * 
	 * @param context
	 *        The {@link Context} to edit
	 * @param monitor
	 *        A monitor to track the progress of the open-editor operation. Will not be {@code null}
	 * 
	 * @throws CoreException
	 *         On failure to open an editor on the {@code context}
	 */
	void openEditor(Context context, IProgressMonitor monitor) throws CoreException;

}
