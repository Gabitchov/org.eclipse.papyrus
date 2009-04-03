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

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.profile.ui.compositeforview.AppliedProfileCompositeWithView;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Element;

/**
 * This section is used to apply a profile on packages or model
 */
public class AppliedProfileSection extends AbstractPropertySection {

	private AppliedProfileCompositeWithView appliedProfileComposite;

	private EModelElement diagramElement;

	private TransactionalEditingDomain editingDomain;

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		appliedProfileComposite = new AppliedProfileCompositeWithView(parent, getWidgetFactory());
		appliedProfileComposite.createContent();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void refresh() {
		appliedProfileComposite.refresh();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		Assert.isTrue(selection instanceof IStructuredSelection);
		Object input = ((IStructuredSelection) selection).getFirstElement();

		if (input instanceof GraphicalEditPart && ((GraphicalEditPart) input).getModel() instanceof View) {
			appliedProfileComposite.setSelection(selection);
			Element UMLElement = (Element) ((View) ((GraphicalEditPart) input).getModel()).getElement();
			if (UMLElement != null) {
				appliedProfileComposite.setSelection(selection);
			}

			diagramElement = (EModelElement) ((AbstractGraphicalEditPart) input).getModel();
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
			editingDomain = editor.getDefaultContext().getTransactionalEditingDomain();
			appliedProfileComposite.setDomain(editingDomain);
		} else
			editingDomain = null;
	}

	/**
	 * 
	 */
	public void dispose() {
		super.dispose();
		if (appliedProfileComposite != null)
			appliedProfileComposite.disposeListeners();
	}
}
