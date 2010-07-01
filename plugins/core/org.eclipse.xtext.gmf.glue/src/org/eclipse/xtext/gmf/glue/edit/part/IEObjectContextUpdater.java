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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.xtext.gmf.glue.edit.part;

import org.eclipse.emf.ecore.EObject;


/**
 * @author CEA LIST - Initial contribution and API
 * This interface is used for establishing a link between a textual specification in the context of
 * popup xtext editor, and the corresponding UML model element.
 * It is used for: 
 * 		- preventing the usage of explicit "import" rules in the xtext grammars 
 * 			(in order to have the link towards the context UML model)
 * 		- determining what is the actual model element being edited 
 * 			(i.e., in the case where multiple popup editors are opened, 
 * 			each editor keeps an up-to-date link with the associated UML model element)
 * An EObjectContextUpdater is passed as a parameter for the creation of a {@link PopupXtextEditorHelper}.
 */
public interface IEObjectContextUpdater {
	
	/**
	 * This method is automatically called when a given popup xtext editor gets the focus.
	 * @param context The contextual model element for a given popup xtext editor. This element is then used
	 * for scoping, verification, etc.
	 */
	void updateContext(EObject context) ; 
}
