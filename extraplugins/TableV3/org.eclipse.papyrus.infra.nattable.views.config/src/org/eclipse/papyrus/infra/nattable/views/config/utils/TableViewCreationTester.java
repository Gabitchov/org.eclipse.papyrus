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
package org.eclipse.papyrus.infra.nattable.views.config.utils;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.tester.ITableTester;
import org.eclipse.papyrus.infra.nattable.views.config.Activator;
import org.eclipse.papyrus.infra.nattable.views.config.messages.Messages;
import org.eclipse.papyrus.uml.tools.model.UmlModel;


public class TableViewCreationTester implements ITableTester {


	public IStatus isAllowed(Object context) {
		if(context instanceof EObject) {
			final EObject current = (EObject)context;
			if(current.eResource() != null && current.eResource().getURI().fileExtension().equals(UmlModel.UML_FILE_EXTENSION)) {//FIXME remove the uml dependency
				return new Status(IStatus.OK, Activator.PLUGIN_ID, Messages.TableViewCreationTester_TheTableViewCanBeCreated);
			}
		}
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.TableViewCreationTester_TheTableViewCantBeCreated);
	}
}
