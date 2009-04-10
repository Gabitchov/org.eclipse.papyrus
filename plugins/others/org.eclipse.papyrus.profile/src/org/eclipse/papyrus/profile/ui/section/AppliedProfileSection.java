/*****************************************************************************
 * Copyright (c) 2008 CEA LIST, Obeo.
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
 *  Jerome BENOIS (Obeo) jerome.benois@obeo.fr - improve to deal with EEF based properties view and model explorer
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.section;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.profile.ui.compositeforview.AppliedProfileCompositeWithView;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * This section is used to apply a profile on packages or model
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class AppliedProfileSection extends AbstractPropertySection {

	private AppliedProfileCompositeWithView appliedProfileComposite;

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
		if (selection instanceof IStructuredSelection) {
			Object input = ((IStructuredSelection) selection).getFirstElement();
			if (input instanceof GraphicalEditPart && ((GraphicalEditPart) input).getModel() instanceof View) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) input;
				View view = (View) graphicalEditPart.getModel();				
				if (view.getElement() != null) {
					appliedProfileComposite.setSelection(selection);
				}
			}else if(input instanceof EModelElement){
				appliedProfileComposite.setSelection(selection);
			}
			if(part instanceof IEditingDomainProvider){
				TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) ((IEditingDomainProvider)part).getEditingDomain();
				appliedProfileComposite.setDomain(editingDomain);
			}
		}
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
