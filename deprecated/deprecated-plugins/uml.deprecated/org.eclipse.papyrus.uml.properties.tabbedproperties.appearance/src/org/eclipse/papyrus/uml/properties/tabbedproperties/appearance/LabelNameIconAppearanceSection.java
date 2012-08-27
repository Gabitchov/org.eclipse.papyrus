/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Thibault Landré (Atos Origin) - fix Bug 291799
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.tabbedproperties.appearance;

import java.util.List;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.uml.tools.utils.ui.command.SetNameLabelIconCommand;
import org.eclipse.papyrus.uml.tools.utils.ui.helper.NameLabelIconHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * The Class QualifiedNameAppearanceSection allow users to customize the display of qualified name.
 */
public class LabelNameIconAppearanceSection extends AbstractModelerPropertySection {

	/**
	 * The stereotype appearance.
	 */
	private CLabel ElementIconLabel;

	/**
	 * The button Gradient appearance.
	 */
	private org.eclipse.swt.widgets.Button checkBox;

	/**
	 * The combo stereotype appearance listener.
	 */
	private SelectionListener checkBoxListener;

	private GraphicalEditPart editPart;

	/**
	 * Creates the controls.
	 * 
	 * @param tabbedPropertySheetPage
	 *        the tabbed property sheet page
	 * @param parent
	 *        the parent
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		ElementIconLabel = getWidgetFactory().createCLabel(composite, "Element icon :");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		ElementIconLabel.setLayoutData(data);

		checkBox = getWidgetFactory().createButton(composite, "", SWT.CHECK);

		data = new FormData();
		data.left = new FormAttachment(ElementIconLabel, 0);
		data.top = new FormAttachment(ElementIconLabel, 1, SWT.CENTER);
		checkBox.setLayoutData(data);

		checkBoxListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				List inputs = getInput();
				for(Object input : inputs) {
					if(input instanceof IGraphicalEditPart) {
						IGraphicalEditPart gep = (IGraphicalEditPart)input;
						if(gep.getModel() instanceof View) {
							getEditingDomain().getCommandStack().execute(
									new SetNameLabelIconCommand(getEditingDomain(), (View)gep.getModel(), checkBox
									.getSelection()));
						}
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		checkBox.addSelectionListener(checkBoxListener);

	}

	/*
	 * @see org.eclipse.ui.views.properties.tabbed.view.ITabbedPropertySection#refresh()
	 */
	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {
		if((!checkBox.isDisposed())) {
			if(editPart != null) {
				if((editPart.getModel()) != null) {
					checkBox.setSelection(NameLabelIconHelper.showLabelIcon((EModelElement)editPart.getModel()));

				} else {
					checkBox.setEnabled(false);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		Object input = ((IStructuredSelection)selection).getFirstElement();
		// look for modelManager
		if(input instanceof GraphicalEditPart) {
			editPart = ((GraphicalEditPart)input);
		}
	}

}
