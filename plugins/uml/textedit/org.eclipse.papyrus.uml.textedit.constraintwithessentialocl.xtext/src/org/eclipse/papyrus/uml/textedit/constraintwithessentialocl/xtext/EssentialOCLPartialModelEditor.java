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
 *  CEA LIST - Architecture refactoring
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.constraintwithessentialocl.xtext;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.xtext.gmf.glue.partialEditing.ISyntheticResourceProvider;
import org.eclipse.xtext.gmf.glue.partialEditing.PartialModelEditor;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.StringInputStream;

/**
 * this partila editoir is used to launch a OCL xtext interpretor 
 *
 */
public class EssentialOCLPartialModelEditor extends PartialModelEditor {

	protected Constraint oclContainer=null;
	/**
	 * 
	 * Constructor.
	 *
	 * @param viewer
	 * @param resourceProvider
	 * @param insertLineBreaks
	 * @param semanticElement
	 * @param modelReconciler
	 */
	public EssentialOCLPartialModelEditor(SourceViewer viewer,
			ISyntheticResourceProvider resourceProvider,
			boolean insertLineBreaks,
			EObject semanticElement,
			IXtextEMFReconciler modelReconciler) {
		
		super(viewer, resourceProvider, insertLineBreaks, semanticElement, modelReconciler);
		if( semanticElement instanceof Constraint){
			this.oclContainer=((Constraint)semanticElement);
			this.semanticElement=oclContainer.getContext();
		}
	}

	@Override
	public XtextResource createResource(String content) {
		XtextResource result = resourceProvider.createResource();
		
		if (modelReconciler instanceof IXtextEMFReconcilerWithContext) {
			((IXtextEMFReconcilerWithContext)modelReconciler).configureResource(result, semanticElement);
		}
		try {
			result.load(new StringInputStream(content, result.getEncoding()), Collections.emptyMap());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
}
