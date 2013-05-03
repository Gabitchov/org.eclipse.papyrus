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
 *  E.D.Willink - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.constraintwithessentialocl.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.xtext.resource.XtextResource;

/**
 * this reconciler has a context in the case of OCL in order to validate its written
 *
 */
public interface IXtextEMFReconcilerWithContext extends IXtextEMFReconciler
{
	/**
	 * 
	 * @param result the resource that represent the constraint under a from of xtext
	 * @param semanticElement the semantic object that is the context of the constraint
	 */
	void configureResource(XtextResource result, EObject semanticElement);
}
