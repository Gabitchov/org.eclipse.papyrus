/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.editpolicies;


/**
 * 
 * This EditPolicy provides the same behavior that
 * ShowHideClassifierContentsEditPolicy. Currently its used in the Composite
 * Structure Diagram to Show/Hide the related Contents for the properties
 * 
 */
public class ShowHideRelatedContentsEditPolicy extends ShowHideClassifierContentsEditPolicy {

	/** the key for this EditPolicy */
	public static String SHOW_HIDE_RELATED_CONTENTS_POLICY = "Show/Hide Related Contents Policy";

}
