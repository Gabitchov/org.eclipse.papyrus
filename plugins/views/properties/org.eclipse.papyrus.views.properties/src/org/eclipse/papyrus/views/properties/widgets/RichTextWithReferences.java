/*****************************************************************************
 * Copyright (c) 2014 CEA
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.widgets;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.TextReferencesHelper;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.RichTextValueEditor;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;

// TODO: Auto-generated Javadoc
/**
 * A rich text property editor with support for TextReferences.
 * 
 * @author Mickael ADAM
 *
 * @see {@link org.eclipse.papyrus.infra.emf.utils.TextReferencesHelper}
 */
public class RichTextWithReferences extends AbstractPropertyEditor {

	/** The text references helper. */
	protected TextReferencesHelper textReferencesHelper;

	/** The editor. */
	protected RichTextEditorWithReferences editor;

	/**
	 * Instantiates a new rich text with references.
	 *
	 * @param parent
	 *        the parent
	 * @param style
	 *        the style
	 */
	public RichTextWithReferences(Composite parent, int style) {
		super();
		setEditor(editor = new RichTextEditorWithReferences(parent, style));
	}

	/**
	 * Sets the text references helper.
	 *
	 * @param helper
	 *        the new text references helper
	 */
	public void setTextReferencesHelper(TextReferencesHelper helper) {
		this.textReferencesHelper = helper;
		editor.setTextReferencesHelper(helper);
		//		installDropListener();
	}

	/**
	 * @see org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor#doBinding()
	 *
	 */
	@Override
	protected void doBinding() {
		super.doBinding();
		IStaticContentProvider provider = input.getContentProvider(propertyPath);
		if(provider != null) {
			editor.setReferenceBrowserContentProvider(provider);
		}

		if(getInputObservableValue() instanceof ICommitListener) {
			editor.addCommitListener((ICommitListener)getInputObservableValue());
		}
	}

	//TODO
	/**
	 * Install drop listener.
	 */
	protected void installDropListener() {
		DropTarget target = new DropTarget(editor.getRichTextEditor(), DND.DROP_LINK);
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

				//				RichTextValueEditor textWidget = getRichTextEditor();
				//				String textToEdit = textWidget.getValue();


				//				int caretPosition = textWidget.getgetPosition();
				while(selectionIterator.hasNext()) {
					EObject selectedEObject = EMFHelper.getEObject(selectionIterator.next());
					if(selectedEObject == null) {
						continue;
					}
					//					textToEdit = textReferencesHelper.insertReference(selectedEObject, textToEdit, caretPosition)

					editor.getRichTextEditor().addHTML(textReferencesHelper.insertReference(selectedEObject, "", 0));
				}

				//				textWidget.setText(textToEdit);
				//				getRichTextEditor().setFocus();
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

	/**
	 * Gets the rich text editor.
	 *
	 * @return the rich text editor
	 */
	protected RichTextValueEditor getRichTextEditor() {
		return (RichTextValueEditor)valueEditor;
	}

	/**
	 * Sets the content provider.
	 *
	 * @param provider
	 *        the new content provider
	 */
	protected void setContentProvider(IStaticContentProvider provider) {
		editor.setReferenceBrowserContentProvider(provider);
	}

	/**
	 * Sets the label provider.
	 *
	 * @param labelProvider
	 *        the new label provider
	 */
	protected void setLabelProvider(ILabelProvider labelProvider) {
		editor.setLabelProvider(labelProvider);
	}
}
