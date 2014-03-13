/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickaël Adam (ALL4TEC) mia@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;

public class ModelStyleSheetCommand extends AbstractCommand {
	
	Resource resource;
	EObject object;
	EObject vRef;
	protected final Set<EObject> createdEObjects = new HashSet<EObject>();
	
	public ModelStyleSheetCommand(Resource resource, EObject object) {
		this.resource= resource;
		this.object=object;
	}
	
	public void execute() {
		
		//add ModelSteelSheet
		resource.getContents().add(object);
		createdEObjects.add(object);

		//add  StyleSheetReference
//		for(Object vObject : ((ModelStyleSheets)object).getStylesheets()) {
//			vRef = StylesheetsFactory.eINSTANCE.createStyleSheetReference();
//			((StyleSheetReference)vRef).setPath(((StyleSheetReference)vObject).getPath());
//			resource.getContents().add(vRef);
//			createdEObjects.add(vRef);
//		}
	}
	
	@Override
	public void undo(){
		if(createdEObjects.contains(object)) {
			object.eResource().getContents().remove(object);
		}
	}
	
	public void redo() {
		execute();
	}
}
