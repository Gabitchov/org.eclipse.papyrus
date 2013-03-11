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
package org.eclipse.papyrus.cdo.internal.ui.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.cdo.internal.ui.Activator;

/**
 * This is the AsyncTransactionAction type. Enjoy.
 */
public abstract class AsyncTransactionAction<T> extends AsyncAction<T> {

	public AsyncTransactionAction(Class<? extends T> type, String text, String icon) {
		super(type, text, icon);
	}

	public AsyncTransactionAction(Class<? extends T> type, String text, ImageDescriptor icon) {
		super(type, text, icon);
	}

	protected CDOView getView(T selection) {
		if(!(selection instanceof CDOObject)) {
			throw new IllegalArgumentException("selection is not a CDOObject"); //$NON-NLS-1$
		}
		return ((CDOObject)selection).cdoView();
	}

	@Override
	protected void doRun(T selection, IProgressMonitor monitor) throws CoreException {
		CDOView view = getView(selection);

		if(view instanceof CDOTransaction) {
			doRun(selection, (CDOTransaction)view, monitor);
		} else {
			CDOUtil.setLegacyModeDefault(true);

			final CDOID oid = (selection instanceof CDOObject) ? ((CDOObject)selection).cdoID() : null;

			CDOTransaction transaction = view.getSession().openTransaction();

			try {
				// get the image of the CDOObject in the new transaction
				T localSelection = (oid == null) ? selection : type.cast(transaction.getObject(oid));

				doRun(localSelection, transaction, monitor);

				try {
					transaction.commit();
				} catch (CommitException e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to commit changes: " + getText(), e)); //$NON-NLS-1$
				}
			} finally {
				transaction.close();
			}
		}
	}

	protected abstract void doRun(T selection, CDOTransaction transaction, IProgressMonitor monitor) throws CoreException;
}
