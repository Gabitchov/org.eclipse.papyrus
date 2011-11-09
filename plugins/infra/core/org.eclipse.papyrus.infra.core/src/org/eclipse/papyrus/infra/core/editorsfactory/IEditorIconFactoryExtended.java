/**
 *  Copyright (c) 2011 Atos.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Atos - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.core.editorsfactory;

/**
 * 
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net">arthur.daussy@atos.net</a>"
 *
 */
public interface IEditorIconFactoryExtended extends IEditorIconFactory {

	/**
	 * Return the icon URL associated to the editor used to render the model. Model represent the top level
	 * object of a model editor.
	 * 
	 * @param pageIdentifier
	 * @return
	 */
	public String getURLMainIcon(Object pageIdentifier);
}
