/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.helper;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;


/**
 * An optional interface implemented by {@link AbstractHyperLinkHelper}s that can recognize an
 * object that they handle and create a {@link Command} to create a hyperlink to it.
 */
public interface IHyperlinkHelperExtension {

	/**
	 * Obtains a command, if possible, that creates a hyperlink from a prospective {@code linkOwner} to a {@code linkTarget}.
	 * 
	 * @param domain
	 *        the transactional editing domain in which to create the command
	 * @param linkOwner
	 *        the object in which to create the hyperlink
	 * @param linkTarget
	 *        the object to which to establish the hyperlink
	 * 
	 * @return the command, or {@code null} if I do not know how to create a command to link to this target
	 * 
	 * @see AbstractHyperLinkHelper#getAddHyperLinkCommand(TransactionalEditingDomain, EModelElement,
	 *      org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject)
	 */
	Command getCreateHyperlinkCommand(TransactionalEditingDomain domain, EModelElement linkOwner, Object linkTarget);
}
