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
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.util;



import org.eclipse.papyrus.uml.export.handlers.EditProfileApplicationAction;




public class ChangeProfileApplicationTester extends org.eclipse.core.expressions.PropertyTester {




	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if("ChangeProfileApplication".equals(property) || EditProfileApplicationAction.getIFile(receiver) != null) {


			return EditProfileApplicationAction.isProfileApplicationEditable(receiver);
		}
		return false;
	}


}
