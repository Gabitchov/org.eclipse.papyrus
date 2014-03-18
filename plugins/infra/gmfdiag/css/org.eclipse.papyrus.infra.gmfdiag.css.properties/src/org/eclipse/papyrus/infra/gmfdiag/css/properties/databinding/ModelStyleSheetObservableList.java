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
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.EObjectListValueStyle;
import org.eclipse.papyrus.infra.emf.databinding.EMFObservableList;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DiagramHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.swt.widgets.Display;

public class ModelStyleSheetObservableList extends EMFObservableList implements IChangeListener {

	private Resource notationResource;

	private EditingDomain domain;

	public ModelStyleSheetObservableList(Resource notationResource, List<?> wrappedList, EditingDomain domain, EObject source, EStructuralFeature feature) {
		super(wrappedList, domain, source, feature);
		this.notationResource = notationResource;
		this.domain = domain;
	}

	@Override
	//For manual remove
	public Command getRemoveCommand(Object value) {
		CompoundCommand compoundCommand = new CompoundCommand();

		compoundCommand.append(super.getRemoveCommand(value));

		//Retrieve all instance of EObjectListValueStyleImpl on all CSSDiagramImpl to 
		EList<EObject> objectsFromRessource = notationResource.getContents();
		for(Object objectFromRessource : objectsFromRessource) {
			//For each CSSDiagramImpl of the ressource look for EObjectListValueStyleImpl
			if(objectFromRessource instanceof CSSDiagram) {
				EList<EObject> objectsFromDiagram = ((CSSDiagram)objectFromRessource).getStyles();
				for(Object objectFromDiagram : objectsFromDiagram) {
					//For each EObjectListValueStyleImpl of each diagram
					if(objectFromDiagram instanceof EObjectListValueStyle) {
						for(Object styleSheetReference : ((EObjectListValueStyle)objectFromDiagram).getEObjectListValue()) {
							//If the current style sheet to delete from model exist on a diagram, add it on the root
							if(value == styleSheetReference) {
								compoundCommand.append(new RemoveObjectCommand((TransactionalEditingDomain)domain, (EObject)styleSheetReference));
								compoundCommand.append(new AddModelStyleSheetCommand((TransactionalEditingDomain)domain, notationResource, (EObject)styleSheetReference));
							}
						}
					}
				}
			}
		}
		return compoundCommand;
	}

	@Override
	//Used to remove all Stylesheet before replace the new list
	public Command getRemoveAllCommand(Collection<?> values) {
		return new RemoveAllModelStyleSheetValueCommand((TransactionalEditingDomain)domain, notationResource, values);
	}

	@Override
	//FIXME Refresh don't  work 
	public void handleChange(ChangeEvent event) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				//((CSSDiagram)source).getEngine().resetCache();
				DiagramHelper.setNeedsRefresh();
				DiagramHelper.refreshDiagrams();
			}
		});
	}

}
