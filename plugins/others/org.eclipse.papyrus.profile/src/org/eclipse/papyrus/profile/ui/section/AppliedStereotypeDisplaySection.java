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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.section;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.profile.ui.compositeforview.AppearanceForAppliedStereotypeComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Element;

/**
 * The Class StereotypePropertiesAppearanceSection manages the display of stereotype properties in Appearance Tab.
 */
public class AppliedStereotypeDisplaySection extends AbstractPropertySection {

	private AppearanceForAppliedStereotypeComposite appearanceForAppliedStereotype;

	private TransactionalEditingDomain domain;

	private EModelElement diagramElement;

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		appearanceForAppliedStereotype = new AppearanceForAppliedStereotypeComposite(parent, domain);
		appearanceForAppliedStereotype.createContent(parent, getWidgetFactory());

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void refresh() {
		appearanceForAppliedStereotype.refresh();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (selection instanceof IStructuredSelection) {
			Object input = ((IStructuredSelection) selection).getFirstElement();

			if (input instanceof GraphicalEditPart && ((GraphicalEditPart) input).getModel() instanceof View) {
				appearanceForAppliedStereotype.setSelection(selection);
				diagramElement = (EModelElement) ((AbstractGraphicalEditPart) input).getModel();

				if ((diagramElement instanceof View) && ((View) diagramElement).getElement() != null) {
					appearanceForAppliedStereotype.setElement((Element) ((View) diagramElement).getElement());
					appearanceForAppliedStereotype.setInput(new StereotypedElementTreeObject((Element) ((View) diagramElement).getElement()));

					diagramElement = (EModelElement) ((AbstractGraphicalEditPart) input).getModel();
					appearanceForAppliedStereotype.setDiagramElement(diagramElement);

				} else {
					// re-init the diagram element. Else, could cause a bug,
					// when the user selects a diagram element, then a non diagram element.
					// If display button is pressed, the "Toggle Display" button does not work correctly
					diagramElement = null;
				}
				// When the selection is computed from the outline, get the associated editor
				if (part instanceof ContentOutline) {
					IContributedContentsView contributedView = ((IContributedContentsView) ((ContentOutline) part).getAdapter(IContributedContentsView.class));
					if (contributedView != null) {
						part = (IWorkbenchPart) contributedView.getContributingPart();
					}
				}
				if (part instanceof IMultiDiagramEditor) {
					IMultiDiagramEditor editor = (IMultiDiagramEditor) part;
					BackboneContext backbone = editor.getDefaultContext();
					domain = editor.getDefaultContext().getTransactionalEditingDomain();
					appearanceForAppliedStereotype.setDomain(domain);
				} else {
					domain = null;
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.core.ui.properties.tabbed.PropertyViewSection#dispose()
	 */
	/**
	 * 
	 */
	public void dispose() {
		super.dispose();
		if (appearanceForAppliedStereotype != null)
			appearanceForAppliedStereotype.disposeListeners();
	}
}