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

package org.eclipse.papyrus.qompass.designer.core.deployment;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.qompass.designer.core.extensions.ILangSupport;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.uml2.uml.Class;

/**
 * Gather configuration data for a code generation project
 * In particular, a class might be stereotyped to provide additional information
 * about required compilation options (in case of C++ include paths, libraries, ...)
 * 
 * @author ansgar
 */
public class GatherConfigData implements CopyListener {

	/**
	 * Gather configuration data for a code generation project
	 * Constructor.
	 * 
	 * @param langSupport
	 *        A reference to a class providing the language support interface
	 */
	public GatherConfigData(ILangSupport langSupport) {
		this.langSupport = langSupport;
	}

	public EObject copyEObject(Copy copy, EObject sourceEObj) {
		if(sourceEObj instanceof Class) {
			langSupport.gatherConfigData((Class)sourceEObj);
		}
		return sourceEObj;
	}

	private ILangSupport langSupport;
}
