/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.impl.EObjectListValueStyleImpl;
import org.eclipse.papyrus.infra.emf.databinding.EMFObservableList;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.resource.CSSNotationResource;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;

public class ModelStyleSheetObservableList extends EMFObservableList implements  IChangeListener {

	private Resource notationResource;
	private EObject source;
	private EditingDomain domain;
	
	public ModelStyleSheetObservableList(Resource notationResource, List<?> wrappedList,EditingDomain domain,EObject source,EStructuralFeature feature){
		super(wrappedList, domain, source, feature);
		this.notationResource = notationResource;
		this.source = source;
		this.domain = domain;
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
		vcc.append(new AddModelStyleSheetCommand((TransactionalEditingDomain) domain, notationResource,source));
		return vcc;
	}
	
	@Override
	public Command getRemoveCommand(int index) {
		// TODO Auto-generated method stub
		return super.getRemoveCommand(index);
	}
	
	@Override
	public Command getRemoveCommand(Object value) {	
		StyleSheetReference styleSheetReference = null;
		
		CompoundCommand vcc = new CompoundCommand();
		//vcc.append(super.getRemoveCommand(value));
		
		//Retrieve all instance of EObjectListValueStyleImpl on all CSSDiagramImpl to 
		EList<EObject> objectsFromRessource = notationResource.getContents();
		for(Object objectFromRessource : objectsFromRessource){
			//For each CSSDiagramImpl of the ressource look for EObjectListValueStyleImpl
			if(objectFromRessource instanceof CSSDiagramImpl){
				EList<EObject> objectsFromDiagram = ((CSSDiagramImpl)objectFromRessource).getStyles();
				for(Object objectFromDiagram : objectsFromDiagram){
					//For each EObjectListValueStyleImpl of each diagram
					if(objectFromDiagram instanceof EObjectListValueStyleImpl){
						EObjectListValueStyleImpl vObjListVal = ((EObjectListValueStyleImpl)objectFromDiagram);
						 styleSheetReference = (StyleSheetReference) vObjListVal.getEObjectListValue().get(0);
						 //If the current style sheet to delete from model exist on a diagram, add it on the root
						 if (value == styleSheetReference) {			
							vcc.append(new RemoveObjectCommand((TransactionalEditingDomain)domain,styleSheetReference));
							vcc.append(new AddModelStyleSheetCommand((TransactionalEditingDomain) domain, notationResource,styleSheetReference));
						 }
					}
				}
			}
		}
		
		return vcc;
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
