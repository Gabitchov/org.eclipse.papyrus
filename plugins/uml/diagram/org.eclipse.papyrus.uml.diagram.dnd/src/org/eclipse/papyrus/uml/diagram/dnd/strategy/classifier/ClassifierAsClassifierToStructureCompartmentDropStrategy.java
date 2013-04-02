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
package org.eclipse.papyrus.uml.diagram.dnd.strategy.classifier;

import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.uml.diagram.composite.custom.helper.TypeHelper;
import org.eclipse.papyrus.uml.diagram.dnd.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;

/**
 * A strategy to drop a classifier into the structure compartment (composite structure diagram). There are two options to do this.
 * (1) Drop the classifier itself. It is more likely that the user wants to do this, if the classifier is also a behavior.
 * (2) Create an property typed with the classifier.
 * 
 * @author Ansgar Radermacher
 * 
 */
public class ClassifierAsClassifierToStructureCompartmentDropStrategy extends TransactionalDropStrategy {

	public String getLabel() {
		return "Classifier into structure compartment"; //$NON-NLS-1$
	}

	public String getID() {
		return Activator.PLUGIN_ID + ".ClassifierToStructureCompDrop"; //$NON-NLS-1$
	}

	public String getDescription() {
		return "Drops a classifier into the structure compartment of a class."; //$NON-NLS-1$
	}

	public Image getImage() {
		return null;
	}

	public int getPriority() {
		return 0;
	}

	public void setOptions(Map<String, Object> options) {
		//Nothing
	}

	@Override
	public Command doGetCommand(Request request, EditPart targetEditPart) {

		if(!(request instanceof DropObjectsRequest)) {
			return null;
		}
		DropObjectsRequest dropRequest = (DropObjectsRequest)request;
		EObject targetSemanticElement = getTargetSemanticElement(targetEditPart);

		if((targetSemanticElement instanceof StructuredClassifier) &&
			(dropRequest.getLocation() != null) &&
			(targetEditPart instanceof GraphicalEditPart)) {
			GraphicalEditPart gtEditPart = (GraphicalEditPart)targetEditPart;
			
			TypeHelper helper = new TypeHelper((TransactionalEditingDomain)getEditingDomain(targetEditPart));
			
			Point location = dropRequest.getLocation().getCopy();
			gtEditPart.getContentPane().translateToRelative(location);
			gtEditPart.getContentPane().translateFromParent(location);
			location.translate(gtEditPart.getContentPane().getClientArea().getLocation().getNegated());

			CompoundCommand cc = new CompoundCommand();

			for(EObject dropElement : getSourceEObjects(request)) {
				if(dropElement instanceof Type) {
					Type type = (Type) dropElement;
					// check whether element is a nested classifier of the targetSemanticElement
					if (type.allNamespaces().contains(targetSemanticElement)) {
						cc.add(helper.dropTypeOnClassifier(gtEditPart, (Type)dropElement, location));
					}
				}
			}
			return cc.canExecute() ? cc : null;
		}
		return null;
	}

	public String getCategoryID() {
		return "org.eclipse.papyrus.dnd.ClassifierToStructureCompDrop"; //$NON-NLS-1$
	}

	public String getCategoryLabel() {
		return "Drop a classifier into the structure compartment of a class"; //$NON-NLS-1$
	}
}
