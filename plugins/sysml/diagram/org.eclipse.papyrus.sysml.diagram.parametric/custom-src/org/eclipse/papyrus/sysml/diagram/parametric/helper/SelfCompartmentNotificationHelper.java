/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConnectorEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConstraintPropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.Property2EditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.part.SysmlVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.helper.NotificationHelper;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * SelfCompartmentNotificationHelper is a particular NotificationHelper which manages the editparts
 * drawn in a particular compartment for a particular feature. It automatically add or remove
 * appropriate parts when model is modified, so that all contained elements are represented once.
 */
public class SelfCompartmentNotificationHelper extends NotificationHelper {

	/** The UI adapter that listens model update */
	private UIAdapter adapter = new UIAdapter();

	/** The compartment part. */
	private final ConstraintPropertyEditPart compartmentPart;

	/** The child feature. */
	private final EStructuralFeature childFeature;

	/** The child type. */
	private final IHintedType childType;

	private static CompositeTransactionalCommand command;

	/**
	 * Instantiates a new self compartment notification helper.
	 * 
	 * @param compartmentPart
	 *        the compartment part
	 * @param childFeature
	 *        the child feature
	 * @param childType
	 *        the child type
	 */
	public SelfCompartmentNotificationHelper(final ConstraintPropertyEditPart compartmentPart, final EStructuralFeature childFeature, final IHintedType childType) {
		this.compartmentPart = compartmentPart;
		this.childFeature = childFeature;
		this.childType = childType;
		this.setModelListener(adapter);
	}

	/**
	 * private class UIAdapter.
	 */
	private class UIAdapter extends UIAdapterImpl {

		@Override
		protected void safeNotifyChanged(Notification msg) {
			if(UMLPackage.eINSTANCE.getTypedElement_Type().equals(msg.getFeature())) {
				// listen type once it's set
				listenObject((Notifier)msg.getNewValue());
				updatePropertiesParts(compartmentPart, childFeature, childType);
			} else if(UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute().equals(msg.getFeature())) {
				updatePropertiesParts(compartmentPart, childFeature, childType);
			}
		}
	}

	/**
	 * Update children edit parts so that each child is represented once
	 * 
	 * @param compartmentPart
	 *        the compartment part containing children
	 * @param childFeature
	 *        the feature containing children
	 * @param childType
	 *        the children's IHintedType represented as Node
	 */
	// TODO refactor this method
	public static void updatePropertiesParts(ConstraintPropertyEditPart compartmentPart, EStructuralFeature childFeature, IHintedType childType) {
		if(compartmentPart == null || childFeature == null || childType == null) {
			return;
		}
		command = new CompositeTransactionalCommand(EditorUtils.getTransactionalEditingDomain(), "update children");
		command.setTransactionNestingEnabled(false);
		if(compartmentPart.getModel() instanceof View) {
			View compartmentView = (View)compartmentPart.getModel();
			EObject containerObject = compartmentView.getElement();
			if(containerObject instanceof ConstraintProperty) {
				Property baseProperty = ((ConstraintProperty)containerObject).getBase_Property();
				if(baseProperty != null && baseProperty.getType() != null) {
					Object untypedOwnedObjects = baseProperty.getType().eGet(childFeature);
					if(untypedOwnedObjects instanceof List<?>) {
						List<?> ownedEObjectChildren = (List<?>)untypedOwnedObjects;
						Set<EObject> drawnEObjectChildren = new HashSet<EObject>(ownedEObjectChildren.size());

						// list children already drawn and remove old children
						for(Iterator<?> iterator = compartmentView.getPersistedChildren().iterator(); iterator.hasNext();) {
							EObject childView = (EObject)iterator.next();
							if(childView instanceof View && ((View)childView).getElement() != null) {
								EObject child = ((View)childView).getElement();
								switch(SysmlVisualIDRegistry.getVisualID((View)childView)) {

								case Property2EditPart.VISUAL_ID:
									// property already drawn
									if(ownedEObjectChildren.contains(child)) {
										drawnEObjectChildren.add(child);
									} else {
										// delete old connectors
										deleteConnectorsViews(command, (View)childView);
										// remove remaining property if any
										iterator.remove();
									}
									break;

								case ConstraintPropertyEditPart.VISUAL_ID:
									// property doesn't exist in the model, remove the view
									iterator.remove();
									break;

								default:
									break;
								}
							}
						}
						// draw remaining children
						List<Object> childrenToDraw = new ArrayList<Object>(ownedEObjectChildren);
						childrenToDraw.removeAll(drawnEObjectChildren);
						for(Object child : childrenToDraw) {
							if(child instanceof EObject) {
								IAdaptable adapter = new EObjectAdapter((EObject)child);
								ViewDescriptor descriptor = new ViewDescriptor(adapter, Node.class, childType.getSemanticHint(), ViewUtil.APPEND, true, compartmentPart.getDiagramPreferencesHint());
								CreateCommand nodeCreationCommand = new CreateCommand(compartmentPart.getEditingDomain(), descriptor, compartmentView);
								command.add(nodeCreationCommand);
							}
						}
					}
				} else {
					// constraint property type is set to null, remove old children
					for(Iterator<?> iterator = compartmentView.getPersistedChildren().iterator(); iterator.hasNext();) {
						EObject childView = (EObject)iterator.next();
						if((childView instanceof View) && SysmlVisualIDRegistry.getVisualID((View)childView) == Property2EditPart.VISUAL_ID) {
							// delete old connectors
							deleteConnectorsViews(command, (View)childView);
							// delete parameter view
							iterator.remove();
						}
					}
				}
				// execute transactional command
				execute();
			}
		}
	}

	/**
	 * Execute command.
	 */
	private static void execute() {
		if(!command.isEmpty()) {
			command.getEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
		}
	}

	/**
	 * Delete source and target connectors of the deleted parameter view
	 * 
	 * @param cmd
	 *        the cmd
	 * @param propertyView
	 *        the property view
	 */
	private static void deleteConnectorsViews(ICompositeCommand cmd, View propertyView) {
		for(Iterator<?> it = propertyView.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge)it.next();
			if(SysmlVisualIDRegistry.getVisualID(incomingLink) == ConnectorEditPart.VISUAL_ID) {
				cmd.add(new DeleteCommand(incomingLink));
			}
		}
		for(Iterator<?> it = propertyView.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge)it.next();
			if(SysmlVisualIDRegistry.getVisualID(outgoingLink) == ConnectorEditPart.VISUAL_ID) {
				cmd.add(new DeleteCommand(outgoingLink));
			}
		}
	}
}
