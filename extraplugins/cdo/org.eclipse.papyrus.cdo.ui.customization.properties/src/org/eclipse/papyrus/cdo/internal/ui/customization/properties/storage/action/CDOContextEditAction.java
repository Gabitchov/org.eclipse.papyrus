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
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.internal.ui.customization.properties.Activator;
import org.eclipse.papyrus.cdo.internal.ui.customization.properties.messages.Messages;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextEditAction;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * This is the CDOContextEditAction type. Enjoy.
 */
public class CDOContextEditAction extends AbstractCDOContextAction implements IContextEditAction {

	public String getToolTip() {
		return Messages.CDOContextEditAction_0;
	}

	public void openEditor(Context context, IProgressMonitor monitor) throws CoreException {
		SubMonitor sub = SubMonitor.convert(monitor, NLS.bind(Messages.CDOContextEditAction_1, context.getName()), IProgressMonitor.UNKNOWN);

		CDOTransaction transaction = createTransaction(context);
		try {
			IEditorPart editor = openEditor(getDoppelganger(context, transaction));
			if(editor != null) { // will be null if an editor was already open
				hookCloseListener(editor, transaction);
				hookSaveListener(editor, transaction);
			} else {
				// we didn't open the editor?  Then we don't need the transaction
				transaction.close();
			}
		} finally {
			sub.done();
		}
	}

	protected IEditorPart openEditor(Context context) throws CoreException {
		IEditorPart result = null;

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorInput input = new CDOResourceEditorInput(context.eResource(), context.getName());

		IEditorPart existing = page.findEditor(input);
		if(existing == null) { // don't return the editor if already open
			result = page.openEditor(input, "org.eclipse.papyrus.customization.properties.UIEditor", true); //$NON-NLS-1$;
		}

		return result;
	}

	private void hookCloseListener(final IEditorPart editor, final CDOView view) {
		final IWorkbenchPage page = editor.getSite().getPage();

		page.addPartListener(new IPartListener() {

			public void partClosed(IWorkbenchPart part) {
				if(part == editor) {
					try {
						view.close();
					} finally {
						page.removePartListener(this);
					}
				}
			}

			public void partOpened(IWorkbenchPart part) {
				// pass
			}

			public void partDeactivated(IWorkbenchPart part) {
				// pass
			}

			public void partBroughtToTop(IWorkbenchPart part) {
				// pass
			}

			public void partActivated(IWorkbenchPart part) {
				// pass
			}
		});
	}

	private void hookSaveListener(final IEditorPart editor, final CDOTransaction transaction) {
		editor.addPropertyListener(new IPropertyListener() {

			public void propertyChanged(Object source, int property) {
				if(property == IEditorPart.PROP_DIRTY) {
					if(!editor.isDirty()) {
						// it's not enough for the editor to save, because that only updates
						// the CLOB content of the CDOTextResources that are changed.  We
						// need to commit the changes to the repository
						try {
							transaction.commit();
						} catch (CommitException e) {
							Activator.log.error(e);

							StatusAdapter adapter = new StatusAdapter(new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.CDOContextEditAction_2, e));
							adapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, Messages.CDOContextEditAction_3);
							adapter.setProperty(IStatusAdapterConstants.EXPLANATION_PROPERTY, Messages.CDOContextEditAction_4);
							StatusManager.getManager().handle(adapter, StatusManager.SHOW);
						}
					}
				}
			}
		});
	}
}
