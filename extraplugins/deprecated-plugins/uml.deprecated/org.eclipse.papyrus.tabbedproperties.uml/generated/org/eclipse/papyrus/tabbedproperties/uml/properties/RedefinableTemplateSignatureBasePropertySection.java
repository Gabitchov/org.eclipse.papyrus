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
package org.eclipse.papyrus.tabbedproperties.uml.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.eef.runtime.api.adapters.SemanticAdapter;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.tabbedproperties.uml.components.RedefinableTemplateSignatureBasePropertiesEditionComponent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.UMLPackage;



/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class RedefinableTemplateSignatureBasePropertySection extends AbstractPropertySection implements IFilter {

	private Composite parent;

	private IPropertiesEditionComponent propertiesEditionComponent;

	/**
	 * The current selected object or the first object in the selection when
	 * multiple objects are selected.
	 */
	protected EObject eObject;

	/**
	 * The view manager
	 */
	private IPropertiesEditionPart editionPart = null;

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		this.parent = parent;
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#setInput(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if(!(selection instanceof IStructuredSelection) ||
				!((part instanceof IEditingDomainProvider) || part.getAdapter(IEditingDomainProvider.class) != null)) {
			return;
		}

		Object firstElement = ((IStructuredSelection)selection).getFirstElement();
		EObject newEObject = resolveSemanticObject(firstElement);

		EditingDomain editingDomain = null;
		if(part instanceof IEditingDomainProvider)
			editingDomain = ((IEditingDomainProvider)part).getEditingDomain();
		else if(part.getAdapter(IEditingDomainProvider.class) != null)
			editingDomain = ((IEditingDomainProvider)part.getAdapter(IEditingDomainProvider.class)).getEditingDomain();

		if(editingDomain != null && newEObject != null && newEObject != eObject) {
			eObject = newEObject;
			if(eObject != null) {
				IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(eObject);
				if(this.propertiesEditionComponent != null)
					this.propertiesEditionComponent.dispose();
				this.propertiesEditionComponent = provider.getPropertiesEditionComponent(eObject, IPropertiesEditionComponent.LIVE_MODE);
				if(this.propertiesEditionComponent != null) {
					this.propertiesEditionComponent.setLiveEditingDomain(editingDomain);
					// FIXME: find a better way to define the Form constant
					this.editionPart = propertiesEditionComponent.getPropertiesEditionPart(1, RedefinableTemplateSignatureBasePropertiesEditionComponent.BASE_PART); //$NON-NLS-1$
					if(editionPart instanceof IFormPropertiesEditionPart) {
						for(int i = 0; i < parent.getChildren().length; i++) {
							Composite child = (Composite)parent.getChildren()[i];
							child.dispose();
						}
						((IFormPropertiesEditionPart)this.editionPart).createFigure(parent, getWidgetFactory());
						parent.layout();
						propertiesEditionComponent.initPart(propertiesEditionComponent.translatePart(RedefinableTemplateSignatureBasePropertiesEditionComponent.BASE_PART), 1, eObject);
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 */
	public void dispose() {
		super.dispose();
		if(this.propertiesEditionComponent != null) {
			this.propertiesEditionComponent.dispose();
			this.propertiesEditionComponent = null;
			this.editionPart = null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 */
	public boolean select(Object toTest) {
		EObject eObjectToTest = resolveSemanticObject(toTest);
		return eObjectToTest != null && eObjectToTest.eClass() == UMLPackage.eINSTANCE.getRedefinableTemplateSignature();
	}

	private EObject resolveSemanticObject(Object object) {
		if(object instanceof EObject) {
			return (EObject)object;
		} else if(object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable)object;
			if(adaptable.getAdapter(SemanticAdapter.class) != null) {
				SemanticAdapter semanticAdapter = (SemanticAdapter)adaptable
						.getAdapter(SemanticAdapter.class);
				return semanticAdapter.getEObject();
			} else if(adaptable.getAdapter(EObject.class) != null) {
				return (EObject)adaptable.getAdapter(EObject.class);
			}
		}
		return null;
	}



}
