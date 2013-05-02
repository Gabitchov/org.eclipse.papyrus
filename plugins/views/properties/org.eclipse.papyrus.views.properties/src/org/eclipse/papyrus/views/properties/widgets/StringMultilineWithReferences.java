/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.widgets;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.TextReferencesHelper;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * 
 * A StringMultiline property editor with support for TextReferences
 * 
 * @author Camille Letavernier
 * 
 * @see {@link org.eclipse.papyrus.infra.emf.utils.TextReferencesHelper}
 */
public class StringMultilineWithReferences extends StringMultiline {

	protected TextReferencesHelper textReferencesHelper;

	public void setTextReferencesHelper(TextReferencesHelper helper) {
		this.textReferencesHelper = helper;
		installDropListener();
	}

	public StringMultilineWithReferences(Composite parent, int style) {
		super(parent, style);
	}

	protected void installDropListener() {
		DropTarget target = new DropTarget(getStringEditor().getText(), DND.DROP_LINK);
		LocalSelectionTransfer selectionTransfer = LocalSelectionTransfer.getTransfer();
		target.setTransfer(new Transfer[]{ selectionTransfer });
		target.addDropListener(new DropTargetListener() {

			public void dropAccept(DropTargetEvent event) {
			}

			public void drop(DropTargetEvent event) {
				IStructuredSelection dropSelection = getSelection(event);
				if(dropSelection == null) {
					return;
				}

				Iterator<?> selectionIterator = dropSelection.iterator();

				Text textWidget = getStringEditor().getText();
				String textToEdit = textWidget.getText();
				int caretPosition = textWidget.getCaretPosition();
				while(selectionIterator.hasNext()) {
					EObject selectedEObject = EMFHelper.getEObject(selectionIterator.next());
					if(selectedEObject == null) {
						continue;
					}
					textToEdit = textReferencesHelper.insertReference(selectedEObject, textToEdit, caretPosition);
				}

				textWidget.setText(textToEdit);
				getStringEditor().setFocus();
			}

			public void dragOver(DropTargetEvent event) {
				verifyDrop(event);
			}

			public void dragOperationChanged(DropTargetEvent event) {
				verifyDrop(event);
			}

			public void dragLeave(DropTargetEvent event) {
			}

			public void dragEnter(DropTargetEvent event) {
				verifyDrop(event);
			}

			private void verifyDrop(DropTargetEvent event) {
				IStructuredSelection selection = getSelection(event);
				if(isValidSelection(selection)) {
					event.feedback = DND.FEEDBACK_INSERT_AFTER;
					event.detail = DND.DROP_LINK;
				} else {
					event.detail = DND.DROP_NONE;
				}
			}

			private IStructuredSelection getSelection(DropTargetEvent event) {
				if(!(event.getSource() instanceof DropTarget)) {
					return null;
				}

				DropTarget target = (DropTarget)event.getSource();

				for(Transfer transfer : target.getTransfer()) {
					if(transfer instanceof LocalSelectionTransfer) {
						LocalSelectionTransfer selectionTransfer = (LocalSelectionTransfer)transfer;
						ISelection selection = selectionTransfer.getSelection();
						if(selection instanceof IStructuredSelection) {
							return (IStructuredSelection)selection;
						}
					}
				}

				return null;
			}

			private boolean isValidSelection(IStructuredSelection dropSelection) {
				if(textReferencesHelper == null) {
					return false;
				}
				if(dropSelection.isEmpty()) {
					return false;
				}

				IStructuredSelection structuredSelection = dropSelection;
				Iterator<?> selectionIterator = structuredSelection.iterator();
				while(selectionIterator.hasNext()) {
					EObject selectedElement = EMFHelper.getEObject(selectionIterator.next());
					if(selectedElement == null) {
						return false;
					}
				}

				return true;
			}
		});
	}

	protected org.eclipse.papyrus.infra.widgets.editors.StringEditor getStringEditor() {
		return (org.eclipse.papyrus.infra.widgets.editors.StringEditor)valueEditor;
	}
}
