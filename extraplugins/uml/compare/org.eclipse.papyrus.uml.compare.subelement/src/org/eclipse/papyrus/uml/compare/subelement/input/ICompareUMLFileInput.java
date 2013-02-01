/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.subelement.input;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;


public interface ICompareUMLFileInput extends IEditorInput {

	/**
	 * 
	 * @return
	 *         the compared elements
	 */
	public Collection<EObject> getComparedElements();

	/**
	 * 
	 * @return
	 *         the compared elements and their editor
	 */
	public Map<EObject, IEditorPart> getElementsAndEditors();
}
