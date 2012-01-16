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
package org.eclipse.papyrus.infra.hyperlink.helper;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;



/**
 * 
 * This class is used to manipulate Editors in the HyperLink Shell
 * 
 */
public abstract class AbstractHyperLinkEditorHelper {

	/**
	 * 
	 * @param editor
	 *        an editor
	 * @return
	 *         the HyperLinkEditor for this object or <code>null</code> if the object is not managed by this helper
	 */
	public abstract HyperLinkEditor getHyperLinkObjectFor(final Object editor);

	/**
	 * 
	 * @param domain
	 *        the editing domain for the command
	 * @param object
	 *        the edited object
	 * @param hyperlinkObject
	 *        the HyperLinkObject
	 * @return
	 */
	public abstract CreateEAnnotationCommand getAddHyperLinkCommand(final TransactionalEditingDomain domain, final EModelElement object, final HyperLinkObject hyperlinkObject);

	/**
	 * 
	 * @param eAnnotation
	 *        an eannotation
	 * @return
	 *         The HyperLinkEditor corresponding to this eAnnotation
	 */
	public abstract HyperLinkEditor getHyperLinkObjectForEAnnotation(final EAnnotation eAnnotation);

}
