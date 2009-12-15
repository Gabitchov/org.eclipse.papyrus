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
package org.eclipse.papyrus.diagram.activity.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.adaptor.gmf.Activator;
import org.eclipse.papyrus.diagram.common.providers.UIAdapterImpl;

/**
 * SelfCompartmentNotificationHelper is a particular NotificationHelper which manages the editparts drawn in a particular compartment for a particular
 * feature. It automatically add or remove appropriate parts when model is modified, so that all contained elements are represented once.
 */
public class SelfCompartmentNotificationHelper extends NotificationHelper {

	/**
	 * Construct a new NotificationHelper which automatically manages contained element for a particular feature.
	 * 
	 * @param compartmentPart
	 *        the compartment part containing parts to manage
	 * @param childFeature
	 *        the feature for children parts (list feature)
	 * @param childType
	 *        the {@link IHintedType} for chidren node parts
	 */
	public SelfCompartmentNotificationHelper(final CompartmentEditPart compartmentPart, final EStructuralFeature childFeature, final IHintedType childType) {
		super(new UIAdapterImpl() {

			@Override
			protected void safeNotifyChanged(Notification msg) {
				if(childFeature != null && childFeature.isMany() && childFeature.equals(msg.getFeature())) {
					updateChildrenParts(compartmentPart, childFeature, childType);
				}
			}
		});
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
	public static void updateChildrenParts(CompartmentEditPart compartmentPart, EStructuralFeature childFeature, IHintedType childType) {
		// Check parameter values
		if(compartmentPart == null || childFeature == null || childType == null) {
			return;
		}
		Object modelElt = compartmentPart.getModel();
		if(modelElt instanceof View) {
			View modelCompartmentView = (View)modelElt;
			Class<?> containerClass = childFeature.getContainerClass();
			if(containerClass.isInstance(modelCompartmentView.getElement())) {
				EObject containerObject = modelCompartmentView.getElement();
				Object untypedOwnedObjects = containerObject.eGet(childFeature);
				if(untypedOwnedObjects instanceof List<?>) {
					List<?> ownedEObjectChildren = (List<?>)untypedOwnedObjects;
					List<EObject> drawnEObjectChildren = new ArrayList<EObject>(ownedEObjectChildren.size());
					// list children already drawn and remove double parts
					for(Object childView : modelCompartmentView.getChildren()) {
						if(childView instanceof View) {
							EObject child = ((View)childView).getElement();
							if(ownedEObjectChildren.contains(child) && !drawnEObjectChildren.contains(child)) {
								drawnEObjectChildren.add(child);
							} else {
								modelCompartmentView.removeChild((View)childView);
							}
						}
					}
					// draw remaining children
					List<Object> childrenToDraw = new ArrayList<Object>(ownedEObjectChildren);
					childrenToDraw.removeAll(drawnEObjectChildren);
					CompositeCommand drawChildrenCommand = new CompositeCommand("draw children nodes");
					for(Object child : childrenToDraw) {
						if(child instanceof EObject) {
							IAdaptable adapter = new EObjectAdapter((EObject)child);
							ViewDescriptor descriptor = new ViewDescriptor(adapter, Node.class, childType.getSemanticHint(), ViewUtil.APPEND, false, compartmentPart.getDiagramPreferencesHint());
							CreateCommand nodeCreationCommand = new CreateCommand(compartmentPart.getEditingDomain(), descriptor, modelCompartmentView);
							drawChildrenCommand.add(nodeCreationCommand);
						}
					}
					if(!drawChildrenCommand.isEmpty()) {
						try {
							OperationHistoryFactory.getOperationHistory().execute(drawChildrenCommand, new NullProgressMonitor(), null);
						} catch (ExecutionException e) {
							e.printStackTrace();
							Activator.getInstance().logError("Unable to create diagram elements", e); //$NON-NLS-1$
						}
					}
				}
			}
		}
	}
}
