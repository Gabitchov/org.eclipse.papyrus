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

package org.eclipse.papyrus.qompass.designer.core.transformations.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.uml2.uml.TemplateSignature;


/**
 * Remove signatures from package template (only remove signatures within the
 * template, not others)
 * 
 * @author ansgar
 * 
 */
public class FilterSignatures implements CopyListener {

	public static FilterSignatures getInstance() {
		if(instance == null) {
			instance = new FilterSignatures();
		}
		return instance;
	}

	public EObject copyEObject(Copy copy, EObject sourceEObj) {
		if(sourceEObj instanceof TemplateSignature) {
			if(copy.withinTemplate(sourceEObj)) {
				return null;
			}
		}
		return sourceEObj;
	}

	private static FilterSignatures instance = null;
}
