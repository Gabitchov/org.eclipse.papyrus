/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.AddAllCustomStyleListValueCommand;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;


public class AddAllModelStyleSheetCommand extends AddAllCustomStyleListValueCommand {

	protected final Set<EObject> createdEObjects = new HashSet<EObject>();

	public AddAllModelStyleSheetCommand(EditingDomain domain, View view, String styleName, EClass styleClass, EStructuralFeature styleFeature, Collection<?> values, int index) {
		super(domain, view, styleName, styleClass, styleFeature, values, index);
	}

	public AddAllModelStyleSheetCommand(EditingDomain domain, View view, String styleName, EClass styleClass, EStructuralFeature feature, Collection<?> values) {
		
		super(domain, view, styleName, styleClass, feature, values);
	}

	@Override
	public void execute() {
//		for(Object value : values) {
//			if(value instanceof EObject) {
//				EObject eObject = (EObject)value;
//				if(eObject.eResource() == null) {
//					view.eResource().getContents().add(eObject);
//					createdEObjects.add(eObject);
//				}
//			}
//		}
		Resource notationResource = view.eResource();
				
		ModelStyleSheets modelStyleSheet = StylesheetsFactory.eINSTANCE.createModelStyleSheets();
        StyleSheetReference stylesheetRef = StylesheetsFactory.eINSTANCE.createStyleSheetReference();
        
        for(Object value : values){
        	String path= ((StyleSheetReference) value).getPath();
	        stylesheetRef.setPath(path);
	        notationResource.getContents().add(stylesheetRef);
	        modelStyleSheet.getStylesheets().add(stylesheetRef);
	        notationResource.getContents().add(modelStyleSheet);
	        
	        //notationResource.getContents().add((EObject) value);
	        //createdEObjects.add(eObject);  //to manage undo
        }
		super.execute();
	}

	@Override
	public void undo() {
//		for(Object value : values) {
//			if(value instanceof EObject) {
//				EObject eObject = (EObject)value;
//				if(createdEObjects.contains(eObject)) {
//					eObject.eResource().getContents().remove(eObject);
//				}
//			}
//		}
		super.undo();
	}

}
