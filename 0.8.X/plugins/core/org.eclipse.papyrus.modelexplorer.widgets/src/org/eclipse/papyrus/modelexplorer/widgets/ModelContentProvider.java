/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.modelexplorer.widgets;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.MoDiscoContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;

/**
 * This is a modisco content provider on which we can parameter the root element
 */
public class ModelContentProvider extends MoDiscoContentProvider implements IStaticContentProvider {

	/**
	 * the root element of the tree explorer
	 */
	protected EObject semanticRoot=null;

	public ModelContentProvider(EObject semanticRoot) {
		this.semanticRoot=semanticRoot;
	}
	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements() {
		return super.getElements(EditorUtils.getMultiDiagramEditor().getServicesRegistry());
	}

	@Override
	public EObject[] getRootElements(Object inputElement) {
		//if the semantic root is null, we use the defaut behavior
		if(semanticRoot==null){
			return super.getRootElements(inputElement);}
		else{
			//we call the super, to ensure that all variable are initialized
			super.getRootElements(inputElement);
			EObject[] eobjectArray= {semanticRoot};
			return eobjectArray;
		}
	}
}
