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

package org.eclipse.ocl.examples.xtext.papyrus;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.xtext.resource.XtextResource;

public interface IXtextEMFReconciler2 extends IXtextEMFReconciler
{
	void configureResource(XtextResource result, EObject semanticElement);
}
