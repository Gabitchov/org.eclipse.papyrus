/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.ui.dialogs;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.FCM.ContainerRule;

/**
 * Return a label for ContainerRules. Since the name of the rule itself, is not
 * really interesting for the user, the returned name is based on the interceptor
 * (or extension)
 * 
 * @author ansgar
 * 
 */
public class RuleLabelProvider extends LabelProvider {

	public String getText(Object element) {
		if(element instanceof ContainerRule) {
			ContainerRule rule = (ContainerRule)element;
			// TODO? Add information about contained parts?
			return rule.getBase_Class().getName();
		}
		return null;
	}
};
