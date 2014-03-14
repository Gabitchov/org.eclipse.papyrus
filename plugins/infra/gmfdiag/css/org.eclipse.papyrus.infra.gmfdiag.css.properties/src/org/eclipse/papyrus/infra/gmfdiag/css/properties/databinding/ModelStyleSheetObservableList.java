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

import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.EObjectListValueStyle;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.impl.EObjectListValueStyleImpl;
import org.eclipse.papyrus.infra.emf.databinding.EMFObservableList;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;

public class ModelStyleSheetObservableList extends EMFObservableList implements  IChangeListener {

	private Resource notationResource;
	private EObject source;
	
	public ModelStyleSheetObservableList(Resource notationResource, List<?> wrappedList,EditingDomain domain,EObject source,EStructuralFeature feature){
		super(wrappedList, domain, source, feature);
		this.notationResource = notationResource;
		this.source = source;
	}

	@Override
	public void handleChange(ChangeEvent event) {
		// TODO Auto-generated method stub
		super.handleChange(event);
	}
	
	
	@Override
	public Command getAddAllCommand(Collection<?> values) {
		CompoundCommand vcc = new CompoundCommand();
		vcc.append(super.getAddAllCommand(values));
		vcc.append(new ModelStyleSheetCommand(notationResource,source));
		return vcc;
	}
	
	@Override
	public Command getRemoveCommand(int index) {
		// TODO Auto-generated method stub
		return super.getRemoveCommand(index);
	}
	
	@Override
	public Command getRemoveCommand(Object value) {	
		StyleSheetReference ref = null;
		
		//Retrieve all instance of NameStyle on CSSDiagramImpl
		EList<EObject> objectsFromRessource = notationResource.getContents();
		for(Object objectFromRessource : objectsFromRessource){
			if(objectFromRessource instanceof CSSDiagramImpl){
				EList<EObject> objectsFromDiagram = ((CSSDiagramImpl)objectFromRessource).getStyles();
				for(Object objectFromDiagram : objectsFromDiagram){
					if(objectFromDiagram instanceof EObjectListValueStyleImpl){
						NamedStyle listValueStyle = ((NamedStyle)objectFromDiagram);
						//listValueStyle.
					}
				}
			}
		}
		
		
		//Compare Objects to the object to remove
//		for(Object object : objects1){
//			if(object instanceof NamedStyle){
//				// If the StyleReference to delete is used on a diagram 
//				if(((Style)object)==value){
//					ref = (StyleSheetReference)value;
//				}
//			}
//		}
		
		
		return super.getRemoveCommand(value);
	}
	
	
	@Override
	public Command getRemoveAllCommand(Collection<?> values) {
	
		return super.getRemoveAllCommand(values);
	}
	
//	public void initialiseModelStyleSheets(){
//		ModelStyleSheetCommand command = new ModelStyleSheetCommand(notationResource,source);
//		 editingDomain.getCommandStack().execute(command);
//	}

}
