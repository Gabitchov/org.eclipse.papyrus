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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.tabbed.profile;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.uml2.uml.Element;


/**
 * Basic Papyrus implementation for property view section. Each section in papyrus should override
 * this section, not {@link AbstractViewSection}.
 */
public class AbstractViewSection extends AbstractPropertySection {

	
	protected org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart editPart;

	protected IMultiDiagramEditor editor;

	protected TransactionalEditingDomain editingDomain;

	protected EObject eObject;

	/**
	 * {@inheritDoc}
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		Object input = ((IStructuredSelection)selection).getFirstElement();
		// look for modelManager
		if(input instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) {
			editPart = ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart)input);
			eObject=editPart.resolveSemanticElement();
		}
		else{
			eObject= resolveSemanticObject(input);
		
		}
		if(part instanceof IEditingDomainProvider) {
			 editingDomain = (TransactionalEditingDomain)((IEditingDomainProvider)part).getEditingDomain();
		
		}
		
	}
	/**
	 * Get the {@link TransactionalEditingDomain} from the {@link IMultiDiagramEditor}.
	 * @param editor
	 * @return
	 */
	protected TransactionalEditingDomain getTransactionalEditingDomain(IMultiDiagramEditor editor) {
		try {
			return editor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		} catch (ServiceException e) {
			// TODO Log instead of showing the trace.
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @return the select uml element of null if not
	 */
	protected Element getElement(){
		if(eObject instanceof Element){
			return ((Element)eObject);
		}
		return null;
		
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
}
