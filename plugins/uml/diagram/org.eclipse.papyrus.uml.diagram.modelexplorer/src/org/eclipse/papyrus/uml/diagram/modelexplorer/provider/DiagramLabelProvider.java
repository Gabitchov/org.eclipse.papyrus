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
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.modelexplorer.provider;


import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.views.modelexplorer.MoDiscoLabelProvider;
import org.eclipse.uml2.uml.NamedElement;

/**
 * the label provider that inherits of modisco label provider
 * 
 */
public class DiagramLabelProvider extends MoDiscoLabelProvider  {

	/** icon registry */
	private IPageIconsRegistry editorRegistry=null;

	/**

	/**
	 * Get the EditorRegistry used to create editor instances. This default
	 * implementation return the singleton eINSTANCE. This method can be
	 * subclassed to return another registry.
	 * 
	 * @return the singleton eINSTANCE of editor registry
	 * @throws ServiceException
	 */
	@Override
	protected IPageIconsRegistry getEditorRegistry() {
		if(editorRegistry == null) {
			editorRegistry = createEditorRegistry();
		}
		return editorRegistry;
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should
	 * implements this method in order to return the registry associated to the
	 * extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 * @throws ServiceException
	 */
	@Override
	protected IPageIconsRegistry createEditorRegistry() {
		try {
			return EditorUtils.getServiceRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			// Not found, return an empty one which return null for each
			// request.
			return new PageIconsRegistry();
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		String text = super.getText(element);
		if(element instanceof Diagram) {
			Diagram diagram = (Diagram)element;
			if(diagram.getElement() instanceof NamedElement){
				text = text +" [" +((NamedElement)diagram.getElement()).getQualifiedName()+"]"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return text;
	}


}
