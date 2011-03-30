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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.helper;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject;


/**
 * this class is an abstract use to serialize and deserialize a HyperLink Object
 *
 */
public abstract class AbstractHyperLinkHelper {

	/**
	 * 
	 * @param eAnnotation that represents a hyperlink object
	 * @return the hyperlink object from the eannotation
	 */
	public  abstract HyperlinkObject getHyperLinkObject(EAnnotation eAnnotation);
	
	
	/**
	 * get a command to serailize a hyperlink object
	 * @param domain the editing domain
	 * @param object the EModelElement to which the hyperlink as attached
	 * @param hyperlinkObject the hyperlinkObject to serailize
	 * @return the command in charge of the serialization
	 */
	public abstract RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperlinkObject hyperlinkObject);
}
