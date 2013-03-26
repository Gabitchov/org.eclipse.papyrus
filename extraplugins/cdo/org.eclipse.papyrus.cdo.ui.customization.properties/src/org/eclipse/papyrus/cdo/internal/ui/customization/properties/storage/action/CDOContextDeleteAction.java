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
package org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage.action;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.internal.ui.customization.properties.Activator;
import org.eclipse.papyrus.cdo.internal.ui.customization.properties.messages.Messages;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextDeleteAction;
import org.eclipse.papyrus.views.properties.contexts.Context;

/**
 * This is the CDOContextDeleteAction type. Enjoy.
 */
public class CDOContextDeleteAction extends AbstractCDOContextAction implements IContextDeleteAction {

	public String getToolTip() {
		return Messages.CDOContextDeleteAction_0;
	}

	public void delete(Context context, IProgressMonitor monitor) throws CoreException {
		SubMonitor sub = SubMonitor.convert(monitor, NLS.bind(Messages.CDOContextDeleteAction_1, context.getName()), IProgressMonitor.UNKNOWN);

		CDOTransaction transaction = createTransaction(context);

		try {
			getContextFolder(getDoppelganger(context, transaction)).delete(null);
			transaction.commit();
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(), e));
		} finally {
			transaction.close();
			sub.done();
		}
	}

}
