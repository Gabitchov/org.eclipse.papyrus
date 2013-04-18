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
package org.eclipse.papyrus.uml.diagram.dnd.strategy.instancespecification;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest;
import org.eclipse.papyrus.uml.diagram.dnd.Activator;
import org.eclipse.papyrus.uml.diagram.dnd.strategy.instancespecification.command.SelectAndCreateSlotsCommand;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A strategy to drop a Classifier on an InstanceSpecification. The instance
 * specification will be typed by the dropped classifiers, and a dialog will
 * be opened for the user to select the slots to create in the
 * InstanceSpecification.
 * 
 * The slots will correspond to the classifier's property.
 * 
 * @author Camille Letavernier
 * 
 */
public class ClassifierToSlotsDropStrategy extends TransactionalDropStrategy {

	private static final EStructuralFeature feature = UMLPackage.eINSTANCE.getInstanceSpecification_Classifier();

	public String getLabel() {
		return "Type instance specification";
	}

	public String getID() {
		return Activator.PLUGIN_ID + ".instanceSpecification";
	}

	public String getDescription() {
		return "Sets the dropped classifiers as classifiers for the target InstanceSpecification. Slots corresponding to the classifiers' properties are also created.";
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

		if( request instanceof CreateAspectUnspecifiedTypeConnectionRequest){
			return null;
		}
		CompositeCommand cc = new CompositeCommand(getLabel());

		EObject semanticElement = getTargetSemanticElement(targetEditPart);

		List<EObject> sourceElements = getSourceEObjects(request);
		List<Classifier> valuesToAdd = new ArrayList<Classifier>(sourceElements.size());
		for(EObject sourceElement : sourceElements) {
			if(!(sourceElement instanceof Classifier)) {
				return null;
			}
			valuesToAdd.add((Classifier)sourceElement);
		}

		if(!(semanticElement instanceof InstanceSpecification)) {
			return null;
		}

		List<Classifier> currentValues = (List<Classifier>)semanticElement.eGet(feature);

		List<Classifier> values = new LinkedList<Classifier>();
		values.addAll(currentValues);
		values.addAll(valuesToAdd);

		SetRequest setClassifiersRequest = new SetRequest(semanticElement, feature, values);
		SetValueCommand setClassifiersCommand = new SetValueCommand(setClassifiersRequest);

		cc.add(setClassifiersCommand);

		//Add slots
		ICommand editSlotsCommand = getEditSlotsCommand(valuesToAdd, targetEditPart);
		if(editSlotsCommand != null) {
			cc.add(editSlotsCommand);
		}

		return cc.canExecute() ? new ICommandProxy(cc.reduce()) : null;
	}

	protected ICommand getEditSlotsCommand(List<Classifier> classifiers, EditPart targetEditPart) {
		for(Classifier classifier : classifiers) {
			if(!classifier.getAllAttributes().isEmpty()) {
				//FIXME: This is inconsistent with ClassifierPropertiesContentProvider, 
				//which doesn't only relies on getAllAttributes()...
				//When a Class (without any property) implements an Interface (With at least one property),
				//this will return a null command, while the dialog would have displayed the interface's properties

				//There is at least one property
				return new SelectAndCreateSlotsCommand(classifiers, targetEditPart);
			}
		}

		return null;
	}

	public String getCategoryID() {
		return "org.eclipse.papyrus.dnd.classifierToInstanceSpecification";
	}

	public String getCategoryLabel() {
		return "Drop a Classifier on an InstanceSpecification";
	}
}
