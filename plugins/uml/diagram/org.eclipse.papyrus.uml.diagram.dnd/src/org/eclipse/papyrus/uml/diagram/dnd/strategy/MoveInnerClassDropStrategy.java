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
package org.eclipse.papyrus.uml.diagram.dnd.strategy;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RefreshConnectionsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.MoveDropStrategy;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentNestedClassifierCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.NestedClassForClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.commands.ShowHideElementsRequest;
import org.eclipse.papyrus.uml.diagram.dnd.Activator;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A DropStrategy to move a Classifier into a Class
 * 
 * @author Camille Letavernier
 */
//FIXME: The Class diagram already automatically displays inner classes 
//when they are added to the semantic model. There might be a conflict with this strategy.
public class MoveInnerClassDropStrategy extends MoveDropStrategy {

	@Override
	public String getLabel() {
		return "Reparent";
	}

	public String getID() {
		return Activator.PLUGIN_ID + ".move.innerClass";
	}

	@Override
	public String getDescription() {
		return "Move the selected class to the target class or package";
	}

	@Override
	protected EStructuralFeature getTargetFeature(Request request, EditPart targetEditPart) {
		EObject targetSemanticElement = getTargetSemanticElement(targetEditPart);
		if(targetSemanticElement instanceof org.eclipse.uml2.uml.Class) {
			//In this case, the service edit will create the GMF View for InnerClass
			return UMLPackage.eINSTANCE.getClass_NestedClassifier();
		}
		if(targetSemanticElement instanceof Interface) {
			return UMLPackage.eINSTANCE.getInterface_NestedClassifier();
		}

		return null;
	}

	public int getPriority() {
		return 101;
	}

	/**
	 * 
	 * @param request
	 * @param targetEditPart
	 * @return A command to edit the graphical view
	 */
	@Override
	protected Command getGraphicalCommand(Request request, EditPart targetEditPart) {
		DropObjectsRequest dropRequest = getDropObjectsRequest(request);
		if(dropRequest == null) {
			return null;
		}

		// Create a view request from the drop request and then forward getting
		// the command for that.

		List<CreateViewRequest.ViewDescriptor> viewDescriptors = new LinkedList<CreateViewRequest.ViewDescriptor>();

		for(EObject eObject : getSourceEObjects(dropRequest)) {
			if(eObject instanceof org.eclipse.uml2.uml.Class) {
				viewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter(eObject), Node.class, Integer.toString(NestedClassForClassEditPart.VISUAL_ID), ((IGraphicalEditPart)targetEditPart).getDiagramPreferencesHint()));
			}
		}
		if(viewDescriptors.isEmpty()) {
			return null;
		}

		CreateViewRequest createViewRequest = new CreateViewRequest(viewDescriptors);
		createViewRequest.setLocation(dropRequest.getLocation());

		targetEditPart = getTargetEditPart(targetEditPart);

		Command createCommand = targetEditPart.getCommand(createViewRequest);

		if(createCommand != null) {
			List<?> result = (List<?>)createViewRequest.getNewObject();
			dropRequest.setResult(result);

			RefreshConnectionsRequest refreshRequest = new RefreshConnectionsRequest(result);
			Command refreshCommand = targetEditPart.getCommand(refreshRequest);

			ArrangeRequest arrangeRequest = new ArrangeRequest(RequestConstants.REQ_ARRANGE_DEFERRED);
			arrangeRequest.setViewAdaptersToArrange(result);
			Command arrangeCommand = targetEditPart.getCommand(arrangeRequest);

			CompoundCommand cc = new CompoundCommand(createCommand.getLabel());

			cc.add(createCommand.chain(refreshCommand));
			cc.add(arrangeCommand);

			for(Object object : dropRequest.getObjects()) {
				if(object instanceof EditPart) {
					EditPart editPart = (EditPart)object;
					ShowHideElementsRequest destroyViewRequest = new ShowHideElementsRequest(editPart);
					Command destroyViewCommand = editPart.getCommand(destroyViewRequest);
					if(destroyViewCommand != null) {
						cc.add(destroyViewCommand);
					}
				}
			}

			return cc;
		}

		return null;
	}

	protected EditPart getTargetEditPart(final EditPart targetEditPart) {
		if(targetEditPart instanceof IGraphicalEditPart) {
			EditPart primaryEditPart = getPrimaryEditPart(targetEditPart);
			View primaryView = ((IGraphicalEditPart)targetEditPart).getPrimaryView();

			int nestedClassSemanticHint = -1;
			switch(UMLVisualIDRegistry.getVisualID(primaryView)) {
			case ClassEditPart.VISUAL_ID:
				nestedClassSemanticHint = ClassNestedClassifierCompartmentEditPart.VISUAL_ID;
				break;
			case ClassEditPartCN.VISUAL_ID:
				nestedClassSemanticHint = ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID;
				break;
			case InterfaceEditPart.VISUAL_ID:
				nestedClassSemanticHint = InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID;
				break;
			case InterfaceEditPartCN.VISUAL_ID:
				nestedClassSemanticHint = InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID;
				break;
			case ComponentEditPart.VISUAL_ID:
				nestedClassSemanticHint = ComponentNestedClassifierCompartmentEditPart.VISUAL_ID;
				break;
			case ComponentEditPartCN.VISUAL_ID:
				nestedClassSemanticHint = ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID;
				break;
			}

			if(nestedClassSemanticHint != -1) {
				String type = UMLVisualIDRegistry.getType(nestedClassSemanticHint);
				EditPart target = ((IGraphicalEditPart)primaryEditPart).getChildBySemanticHint(type);
				if(target != null) {
					return target;
				}
			}
		}

		return targetEditPart;
	}

	protected EditPart getPrimaryEditPart(final EditPart targetEditPart) {
		EditPart currentPart = targetEditPart;

		while(currentPart != null) {
			if(currentPart instanceof IPrimaryEditPart) {
				return currentPart;
			}
			currentPart = currentPart.getParent();
		}

		return targetEditPart;
	}

	public String getCategoryID() {
		return "org.eclipse.papyrus.drop.classToClassifier";
	}

	public String getCategoryLabel() {
		return "Drop a Class on a Classifier";
	}

	public String getCategory() {
		// TODO Auto-generated method stub
		return null;
	}
}
