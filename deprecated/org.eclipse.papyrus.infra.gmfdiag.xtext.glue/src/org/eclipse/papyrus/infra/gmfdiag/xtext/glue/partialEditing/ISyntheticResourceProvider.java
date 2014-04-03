/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.xtext.glue.partialEditing;

import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.ImplementedBy;

/**
 * 
 */
@ImplementedBy(SyntheticResourceProvider.class)
public interface ISyntheticResourceProvider {
	/**
	 * @return XtextResource
	 *
	 */
	XtextResource createResource();
}