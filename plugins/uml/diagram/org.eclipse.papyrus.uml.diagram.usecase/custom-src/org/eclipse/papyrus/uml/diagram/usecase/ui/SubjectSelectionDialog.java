/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.ui;

import java.util.ArrayList;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This class can be launch is order to open a dialog used to choose an association
 */
public class SubjectSelectionDialog extends AbstractSubjectMetaclassesSelectionDialog {

	/** The selected association. */
	protected IHintedType selectedMetaclass;

	/** The common metaclasses. */
	ArrayList<IHintedType> subClassifierList;

	/**
	 * Instantiates a new association selection dialog.
	 * 
	 * @param parent
	 *        the parent shell
	 * @param style
	 *        the style
	 */
	public SubjectSelectionDialog(Shell parent, ArrayList<IHintedType> executableHTypeCreation, int style) {
		super(parent, style);
		this.subClassifierList = executableHTypeCreation;
		this.selectedMetaclass = (IHintedType)subClassifierList.toArray()[0];
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.clazz.custom.ui.AbstractAssociationSelectionDialog#createContents()
	 * 
	 */
	protected void createContents() {
		super.createContents();
		final ILabelProvider labelProvider = new LabelProvider() {
			@Override
			public String getText(Object element) {
				if(element instanceof IHintedType) {
					String out = ((IHintedType)element).getDisplayName();
					return out;
				}
				return super.getText(element);
			}

			@Override
			public Image getImage(Object element) {
				final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
				return labelProvider.getImage(UMLFactory.eINSTANCE.createClass());
			}
		};//new EMFLabelProvider();//new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		final IStructuredContentProvider associationContentProvider = new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				return subClassifierList.toArray();
			}
		};
		final TableViewer tableViewer = new TableViewer(table);
		tableViewer.setLabelProvider(labelProvider);
		tableViewer.setContentProvider(associationContentProvider);
		tableViewer.setInput(subClassifierList);
		btnOk.addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				ISelection selection = tableViewer.getSelection();
				if(selection instanceof IStructuredSelection) {
					selectedMetaclass = (IHintedType)((IStructuredSelection)selection).getFirstElement();
					shlmetaclassSelection.close();
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
	public IHintedType getSelectedMetaclass() {
		return selectedMetaclass;
	}
}
