/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy (Atos) arthur.daussy@atos.net - Bug 249786: [General] drag'n'drop does not work for elements stored in nested classifier compartment
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ListenerEventEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
/**
 * Use as based class for Nested Classifier Listener (for example see {@link ClassNestedClassifierListenerEditPolicy}
 * @author adaussy
 *
 */
public abstract class AbstractNestedClassifierListenerEditPolicy extends ListenerEventEditPolicy {

	/**
	 * {@link EditPolicy} ID
	 */
	public static String EDIT_POLICY_ID = "NESTED_CLASSIFIER_LISTENER_EDITPOLICY";
	/**
	 * label of the composite command to add new classifier
	 */
	protected static final String MOVE_CLASSIFIER_TO_NESTED_CLASSIFIER_COMPARTMENT = "Move classifier to NestedClassifier Compartment";
	/**
	 * Label of the composite Command to remove orphan classifier
	 */
	protected static final String REMOVE_ORPHAN_CLASSIFIER = "Remove Orphan Classifier";

	public AbstractNestedClassifierListenerEditPolicy() {
		super();
	}

	protected ICommand getCommand(EObject newObject, EObject oldObject, EStructuralFeature feature, int eventType, EObject notifier) {
		ICommand result = null;
		switch(eventType) {
		case Notification.ADD:
			result = handleAddClassifier(newObject);
			break;
		case Notification.REMOVE:
			result = handleRemoveClassifier(oldObject);
			break;
		default:
			result = null;
		}
		return result;
	}

	/**
	 * @param oldObject
	 * @return
	 */
	protected ICommand handleRemoveClassifier(EObject oldObject) {
		EObject oldEObject = (EObject)oldObject;
		Iterable<IGraphicalEditPart> children = DiagramEditPartsUtil.getChildrenByEObject(oldEObject, host(), false);
		CompositeCommand cc = new CompositeCommand(REMOVE_ORPHAN_CLASSIFIER);
		for(IGraphicalEditPart child : children) {
			Object model = child.getModel();
			if(model instanceof View) {
				DeleteCommand cmd = new DeleteCommand((View)model);
				if(cmd != null && cmd.canExecute()) {
					cc.compose(cmd);
				}
			}
		}
		return cc.reduce();
	}

	/**
	 * @param newObject
	 * @return
	 */
	protected ICommand handleAddClassifier(EObject newObject) {
		CompositeCommand cc = new CompositeCommand(MOVE_CLASSIFIER_TO_NESTED_CLASSIFIER_COMPARTMENT);
		ViewDescriptor viewDescriptor = getViewDescriptor((EObject)newObject);
		Iterable<ICommand> deleteCommands = Iterables.transform(DiagramEditPartsUtil.findViews((EObject)newObject, getHost().getViewer()), new Function<View, ICommand>() {
	
			public ICommand apply(View from) {
				return new DeleteCommand(from);
			}
		});
		for(Iterator<ICommand> commandIterator = deleteCommands.iterator(); commandIterator.hasNext();) {
			ICommand command = commandIterator.next();
			if(command != null && command.canExecute()) {
				cc.compose(command);
			}
		}
		CreateViewRequest request = new CreateViewRequest(viewDescriptor);
		Command cmd = getHost().getCommand(request);
		if(cmd != null && cmd.canExecute()) {
			cc.compose(new CommandProxy(cmd));//return new GEFtoEMFCommandWrapper(cmd);
		}
		return cc.reduce();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.ListenerEventEditPolicy#handleNotificationType(int)
	 * 
	 * @param type
	 * @return
	 */
	public boolean handleNotificationType(int type) {
		return Notification.ADD == type || Notification.REMOVE == type;
	}

	/**
	 * Convenience method to create a view descriptor. Will call {@link #getViewDescriptor(IAdaptable, Class, String, int)}
	 * 
	 * @param element
	 *        semantic element.
	 * @return view descriptor
	 */
	protected CreateViewRequest.ViewDescriptor getViewDescriptor(EObject element) {
		// create the view descriptor
		String factoryHint = getDefaultFactoryHint();
		IAdaptable elementAdapter = new ElementListenerAdapter(element, factoryHint);
		int pos = getViewIndexFor(element);
		int childHint = UMLVisualIDRegistry.getNodeVisualID((View)host().getModel(), element);
		CreateViewRequest.ViewDescriptor descriptor = getViewDescriptor(elementAdapter, Node.class, String.valueOf(childHint), pos);
		return descriptor;
	}
}
