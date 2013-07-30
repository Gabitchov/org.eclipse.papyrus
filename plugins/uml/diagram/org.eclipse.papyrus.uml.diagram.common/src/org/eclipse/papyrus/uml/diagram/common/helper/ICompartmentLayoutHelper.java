/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.helper;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.papyrus.infra.emf.appearance.commands.SetLayoutKindCommand;

/**
 * the purpose of these kind of object is to. All subclasses are singletons.
 */
public interface ICompartmentLayoutHelper {

	/**
	 * Apply layout on the edit part by taking in account the good toolkit.
	 */
	public void applyLayout(AbstractGraphicalEditPart editPart);

	/**
	 * Sets the layout kind on view.
	 * 
	 * @param layoutKind
	 *        the new layout kind on view
	 */
	public SetLayoutKindCommand setLayoutKindOnView(TransactionalEditingDomain domain, EModelElement view, String layoutKind);

	/**
	 * Gets the layout kind from view.
	 * 
	 * @return the layout kind from view
	 */
	public String getLayoutKindFromView(EModelElement modelElement);
}
