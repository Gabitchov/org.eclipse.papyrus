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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.profile.ui.compositeforview.AppliedStereotypeCompositeWithView;
import org.eclipse.papyrus.profile.ui.compositeforview.AppliedStereotypePropertyCompositeWithView;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * This section is used to apply stereotype on uml Element.
 */
public class AppliedStereotypeSectionWithView extends AbstractPropertySection {

	/** The stereotype composite. */
	private AppliedStereotypeCompositeWithView appliedStereotypeComposite;

	/** The property composite. */
	private AppliedStereotypePropertyCompositeWithView propertyComposite;

	private TransactionalEditingDomain editingDomain;

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
		appliedStereotypeComposite = new AppliedStereotypeCompositeWithView(parent, editingDomain);
		appliedStereotypeComposite.createContent(parent, getWidgetFactory());

		propertyComposite = new AppliedStereotypePropertyCompositeWithView(parent, appliedStereotypeComposite);
		propertyComposite.createContent(parent, getWidgetFactory());

		appliedStereotypeComposite.setPropertyComposite(propertyComposite);
	}

	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {
		appliedStereotypeComposite.refresh();
		propertyComposite.refresh();
	}

	/**
	 * Should use extra space.
	 * 
	 * @return true, if successful
	 */
	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if(selection instanceof IStructuredSelection) {
			Object input = ((IStructuredSelection)selection).getFirstElement();

			if(part instanceof IEditingDomainProvider) {
				this.editingDomain = (TransactionalEditingDomain)((IEditingDomainProvider)part).getEditingDomain();
				appliedStereotypeComposite.setDomain(editingDomain);
				propertyComposite.setDomain(editingDomain);
			}

			if(input instanceof GraphicalEditPart && ((GraphicalEditPart)input).getModel() instanceof View) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart)input;
				View view = (View)graphicalEditPart.getModel();
				Element UMLElement = (Element)view.getElement();
				if(UMLElement != null) {
					appliedStereotypeComposite.setDiagramElement(view);
					propertyComposite.setDiagramElement(view);
					appliedStereotypeComposite.setElement(UMLElement);
					appliedStereotypeComposite.setInput(new StereotypedElementTreeObject(UMLElement, editingDomain));
				}
			} 
			else{
				EObject eobject=resolveSemanticObject(input);

				if(eobject instanceof Element) {
					Element UMLElement = (Element)eobject;
					appliedStereotypeComposite.setDiagramElement(null);
					appliedStereotypeComposite.setElement(UMLElement);
					appliedStereotypeComposite.setInput(new StereotypedElementTreeObject(UMLElement, editingDomain));
				}
			}

		}
	}
	/**
	 * Resolve semantic element
	 * 
	 * @param object
	 *            the object to resolve
	 * @return <code>null</code> or the semantic element associated to the specified object
	 */
	private EObject resolveSemanticObject(Object object) {
		if (object instanceof EObject) {
			return (EObject) object;
		} else if (object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) object;
			if (adaptable.getAdapter(EObject.class) != null) {
				return (EObject) adaptable.getAdapter(EObject.class);
			}
		}
		return null;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.core.ui.properties.tabbed.PropertyViewSection#dispose()
	 */
	/**
	 * Dispose.
	 */
	public void dispose() {
		super.dispose();
		if(appliedStereotypeComposite != null)
			appliedStereotypeComposite.disposeListeners();
		if(propertyComposite != null)
			propertyComposite.disposeListeners();
	}
}
