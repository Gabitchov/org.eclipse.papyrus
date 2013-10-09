/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.ui;

import java.util.HashSet;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Association;

/**
 * This class can be launch is order to open a dialog used to choose an association
 */
public class AssociationSelectionDialog extends AbstractAssociationSelectionDialog {

	/** The selected association. */
	protected Association selectedAssociation;

	/** The common associations. */
	protected HashSet<Association> commonAssociations;

	/**
	 * Instantiates a new association selection dialog.
	 * 
	 * @param parent
	 *        the parent shell
	 * @param style
	 *        the style
	 * @param commonAssociations
	 *        list of assocation in which we would like to llok for
	 */
	public AssociationSelectionDialog(Shell parent, int style, HashSet<Association> commonAssociations) {
		super(parent, style);
		this.commonAssociations = commonAssociations;
		this.selectedAssociation = (Association)commonAssociations.toArray()[0];
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.clazz.custom.ui.AbstractAssociationSelectionDialog#createContents()
	 * 
	 */
	protected void createContents() {
		// TODO Auto-generated method stub
		super.createContents();
		final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		final IStructuredContentProvider associationContentProvider = new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				return commonAssociations.toArray();
			}
		};
		final TableViewer tableViewer = new TableViewer(table);
		tableViewer.setLabelProvider(labelProvider);
		tableViewer.setContentProvider(associationContentProvider);
		tableViewer.setInput(commonAssociations);
		btnOk.addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				ISelection selection = tableViewer.getSelection();
				if(selection instanceof IStructuredSelection) {
					selectedAssociation = (Association)((IStructuredSelection)selection).getFirstElement();
					shlAssociationselection.close();
				}
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		btnCancel.setVisible(false);
	}

	/**
	 * Gets the selected association.
	 * 
	 * @return the selected association
	 */
	public Association getSelectedAssociation() {
		return selectedAssociation;
	}
}
