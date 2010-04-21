/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.modelexplorer.dnd;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

/**
 * This class handle Drop events in ModelExplorer view.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
@SuppressWarnings("deprecation")
public class CommonDropAdapterAssistant extends
		org.eclipse.ui.navigator.CommonDropAdapterAssistant {

	public CommonDropAdapterAssistant() {
	}

	@Override
	public IStatus handleDrop(CommonDropAdapter dropAdapter,
			DropTargetEvent dropTargetEvent, Object dropTarget) {
		Object targetElement = (Object) dropTarget;
		if (LocalSelectionTransfer.getInstance().isSupportedType(
				dropAdapter.getCurrentTransfer())) {
			switch (dropAdapter.getCurrentOperation()) {
			case DND.DROP_MOVE:
				handleDropMove(targetElement);
				break;
			// case DND.DROP_COPY:
			// break;
			}

		}
		return null;
	}

	@Override
	public IStatus validateDrop(Object target, int operation,
			TransferData transferType) {
		if (target instanceof IAdaptable) {
			return Status.OK_STATUS;
		}
		return Status.CANCEL_STATUS;
	}

	private void handleDropMove(final Object target) {
		ISelection s = LocalSelectionTransfer.getInstance().getSelection();
		if (s instanceof IStructuredSelection) {
			List<?> selectedElements = ((IStructuredSelection) s).toList();
			for (Object o : selectedElements) {
				if (o instanceof IAdaptable) {
					EObject eObject = (EObject) ((IAdaptable) o)
							.getAdapter(EObject.class);

					moveElementTo(eObject, target);
				}
			}
		}
	}

	private void moveElementTo(final EObject element, final Object target) {
		// TransactionalEditingDomain editingDomain = getEditingDomain();
		// if(editingDomain != null && (element.getNamespace() instanceof
		// Package)) {
		// ChangeCommand changeCommand = new ChangeCommand(editingDomain, new
		// Runnable() {
		//
		// public void run() {
		// Namespace oldOwner = element.getNamespace();
		// if(oldOwner instanceof Package) {
		// // Remove from the old package
		// Package pkg = (Package)oldOwner;
		// pkg.getPackagedElements().remove(element);
		//
		// // Add to the new package
		// target.getPackagedElements().add(element);
		// }
		// }
		// }, "Move " + element.getName() + " to " + target.getName());

		// if(changeCommand.canExecute()) {
		// editingDomain.getCommandStack().execute(changeCommand);
		// }
		// }
	}

	@SuppressWarnings("unused")
	private TransactionalEditingDomain getEditingDomain() {
		return EditorUtils.getTransactionalEditingDomain();
	}

	@SuppressWarnings("unused")
	private IMultiDiagramEditor getMultiDiagramEditor() {
		IEditorPart editorPart = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editorPart instanceof IMultiDiagramEditor) {
			return (IMultiDiagramEditor) editorPart;
		}
		return null;
	}
}
