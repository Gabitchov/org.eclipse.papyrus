/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickaël Adam (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ModelCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.resource.CSSNotationResource;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;

public class AddModelStyleSheetCommand extends RecordingCommand {
	
	Resource resource;
	EObject object;
	EObject vRef;
	
	public AddModelStyleSheetCommand(TransactionalEditingDomain domain, Resource resource, EObject object) {
		super(domain);
		this.resource= resource;
		this.object=object;
	}
	
	public void doExecute() {
		
		//add ModelSteelSheet
		resource.getContents().add(object);

		//reloadStyleSheets for the model
//		EList<EObject> objects = resource.getContents();
		
		//((CSSNotationResource)resource).getModelEngine().getAllStylesheets();
		
//		for(EObject object : objects){
//			
//			if(object instanceof ModelCSSEngine){
//				//((ModelCSSEngine)object).reloadStyleSheets();
//			}
//		}
		//Parcourir pour trouver ModelCSSEngine
		
		//refresh
		
		//add  StyleSheetReference
//		for(Object vObject : ((ModelStyleSheets)object).getStylesheets()) {
//			vRef = StylesheetsFactory.eINSTANCE.createStyleSheetReference();
//			((StyleSheetReference)vRef).setPath(((StyleSheetReference)vObject).getPath());
//			resource.getContents().add(vRef);
//			createdEObjects.add(vRef);
//		}
	}
	
}
