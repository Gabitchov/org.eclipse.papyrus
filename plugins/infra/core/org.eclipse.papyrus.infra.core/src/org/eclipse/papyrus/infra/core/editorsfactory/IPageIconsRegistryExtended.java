/**
 *  Copyright (c) 2011 Atos Origin.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Atos Origin - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.core.editorsfactory;

/**
 * Extends IPageIconsRegistry in order to offer a second methods which will give back the URL of the requested Icon
 * 
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net">arthur.daussy@atos.net</a>"
 * 
 */
public interface IPageIconsRegistryExtended extends IPageIconsRegistry {

	/**
	 * Get the URL icon associated to the editor used to render the model. Model represent the top level
	 * object of a model editor.
	 * 
	 * @param model
	 * @return {@link String} which represent the URL of the resource
	 */
	public String getEditorURLIcon(Object model);

}
