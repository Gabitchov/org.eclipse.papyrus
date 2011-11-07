/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.groups.core.utils;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * Class used as result of getDefaultModelParent.
 * Object will care 3 information:
 * The IGraphicalEditPart of the default model parent
 * The ERefence with which it will contain the child
 * 
 * @author adaussy
 * 
 */

public class DefaultModelParent {

	/**
	 * The IGraphicalEditPart of the defautl model parent
	 */
	private IGraphicalEditPart iGraphicalEditPart;

	/**
	 * The ERefence with which it will contain the child
	 */
	private EReference eReference;

	public DefaultModelParent(IGraphicalEditPart iGraphicalEditPart, EReference eReference) {
		super();
		this.iGraphicalEditPart = iGraphicalEditPart;
		this.eReference = eReference;
	}


	public IGraphicalEditPart getiGraphicalEditPart() {
		return iGraphicalEditPart;
	}



	public EReference geteReference() {
		return eReference;
	}


}
