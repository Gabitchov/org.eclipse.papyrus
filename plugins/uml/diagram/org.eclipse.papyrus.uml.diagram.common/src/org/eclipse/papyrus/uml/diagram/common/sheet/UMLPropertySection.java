/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.sheet;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AdvancedPropertySection;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

/**
 * Property Section in charge of the Advanced property view
 */
public class UMLPropertySection extends AdvancedPropertySection implements IPropertySourceProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.IPropertySourceProvider#getPropertySource
	 * (java.lang.Object)
	 */
	public IPropertySource getPropertySource(Object object) {
		if(object instanceof IPropertySource) {
			return (IPropertySource)object;
		}
		AdapterFactory af = getAdapterFactory(object);
		if(af != null) {
			IItemPropertySource ips = (IItemPropertySource)af.adapt(object, IItemPropertySource.class);
			if(ips != null) {
				return new UMLPropertySource(object, ips);
			}
		}
		if(object instanceof IAdaptable) {
			return (IPropertySource)((IAdaptable)object).getAdapter(IPropertySource.class);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.diagram.ui.properties.sections.
	 * AdvancedPropertySection# getPropertySourceProvider()
	 */
	protected IPropertySourceProvider getPropertySourceProvider() {
		return this;
	}

	/**
	 * Modify/unwrap selection.
	 * 
	 */
	protected Object transformSelection(Object selected) {
		if(selected == null) {
			return null;
		}
		if(selected instanceof IAdaptable && ((IAdaptable)selected).getAdapter(IPropertySource.class) != null) {
			return ((IAdaptable)selected).getAdapter(IPropertySource.class);
		}
		if(selected instanceof EditPart) {
			Object model = ((EditPart)selected).getModel();
			return model instanceof View ? ((View)model).getElement() : null;
		}
		if(selected instanceof View) {
			return ((View)selected).getElement();
		}
		if(selected instanceof IAdaptable) {
			View view = (View)((IAdaptable)selected).getAdapter(View.class);
			if(view != null) {
				return view.getElement();
			}
			EObject elem = EMFHelper.getEObject(selected);
			return elem;
		}
		return selected;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.
	 * AdvancedPropertySection#setInput(org .eclipse.ui.IWorkbenchPart,
	 * org.eclipse.jface.viewers.ISelection)
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		if(selection.isEmpty() || false == selection instanceof StructuredSelection) {
			super.setInput(part, selection);
			return;
		}
		final StructuredSelection structuredSelection = ((StructuredSelection)selection);
		ArrayList transformedSelection = new ArrayList(structuredSelection.size());
		for(Iterator it = structuredSelection.iterator(); it.hasNext();) {
			Object r = transformSelection(it.next());
			if(r != null) {
				transformedSelection.add(r);
			}
		}
		super.setInput(part, new StructuredSelection(transformedSelection));
	}

	/**
	 * Get the adapterFactory of the given object
	 * 
	 * @param Object
	 * @return the adapter factory
	 */
	protected AdapterFactory getAdapterFactory(Object object) {
		if(getEditingDomain() instanceof AdapterFactoryEditingDomain) {
			return ((AdapterFactoryEditingDomain)getEditingDomain()).getAdapterFactory();
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(object);
		if(editingDomain != null) {
			return ((AdapterFactoryEditingDomain)editingDomain).getAdapterFactory();
		}
		return null;
	}

}
