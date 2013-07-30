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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editparts;

/**
 * This interface is used by the action ShowHideLabelsAction
 * 
 * 
 * 
 */
public interface ILabelRoleProvider {

	/**
	 * Returns the label role
	 * 
	 * @return the label role
	 */
	public String getLabelRole();

	/**
	 * Returns an icon illustrating the label role
	 * 
	 * @return an icon illustrating the label role
	 */
	public String getIconPathRole();
}
