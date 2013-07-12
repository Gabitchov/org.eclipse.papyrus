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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.ws.preferences.tester;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.tester.ITableTester;
import org.eclipse.uml2.uml.Element;


public class PreferencesTableCreationTester implements ITableTester {


	@Override
	public IStatus isAllowed(Object context) {
		if(context instanceof Element) {
			return Status.OK_STATUS;
		}
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selection is not an Uml Element");
	}

}
