/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.controller;

import org.eclipse.jface.viewers.ILabelProvider;


/**
 * Interface for Controllers using label providers
 */
public interface ILabelProviderController extends IPropertyEditorController {

	/**
	 * Returns the label provider used to display elements in the editor
	 * 
	 * @return the label provider used to display elements in the editor
	 */
	public ILabelProvider getEditorLabelProvider();

}
