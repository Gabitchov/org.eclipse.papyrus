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
 * 
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.custom.listeners;

import java.util.NoSuchElementException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.DestroyElementPapyrusCommand;
import org.eclipse.papyrus.diagram.common.listeners.AbstractPapyrusModifcationTriggerListener;
import org.eclipse.papyrus.diagram.common.util.predicates.ViewTypePredicate;
import org.eclipse.papyrus.diagram.statemachine.custom.commands.CreateViewCommand;
import org.eclipse.papyrus.diagram.statemachine.custom.commands.HideShowCompartmentIfEmptyCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.InternalTransitionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.InternalTransitionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.TransitionKind;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * Listen the feature TRANSITION__KIND in order to change the apparence of an internal transition
 * 
 * @author adaussy
 * 
 */
public class InternalStateListener extends AbstractPapyrusModifcationTriggerListener {

	private static final String UNABLE_TO_RETREIVE_THE_STATE_EDIT_PART = "Unable to retreive the state edit part";

	protected NotificationFilter filter;

	@Override
	public NotificationFilter getFilter() {
		if(filter == null) {
			filter = NotificationFilter.createFeatureFilter(UMLPackage.Literals.TRANSITION__KIND);
		}
		return filter;
	}

	@Override
	protected CompositeCommand getModificationCommand(Notification notif) {
		Object newValue = notif.getNewValue();
		Object notifier = notif.getNotifier();
		if(newValue instanceof TransitionKind && notifier instanceof EObject) {
			/*
			 * If set to local nothing has to be done
			 */
			if(TransitionKind.LOCAL_LITERAL.equals((TransitionKind)newValue)) {
				return null;
			}
			CompositeCommand cc = new CompositeCommand("Modification command triggered by modedication of the kind of the current selected transition");//$NON-NLS-0$
			EObject eNotifier = (EObject)notifier;
			//Handle deletion of the old EditPart
			boolean becomingInternal = isBecomingInternal(notif);
			ICommand deleteCommant = getDeleteCommand(becomingInternal, eNotifier);
			if(deleteCommant != null && deleteCommant.canExecute()) {
				cc.compose(deleteCommant);
			}
			//handle addition of the new EditPart
			ICommand creationCommand = getCreationCommand(becomingInternal, eNotifier);
			if(creationCommand != null && creationCommand.canExecute()) {
				cc.compose(creationCommand);
			}
			
			return cc;
		}
		return null;
	}
	
	/**
	 * Return true if the the current feature indicate that the new value of the feature is {@link TransitionKind#INTERNAL}
	 * 
	 * @param notif
	 * @return
	 */
	protected boolean isBecomingInternal(Notification notif) {
		Object newValue = notif.getNewValue();
		if(newValue instanceof TransitionKind) {
			TransitionKind newKind = (TransitionKind)newValue;
			return TransitionKind.INTERNAL_LITERAL.equals(newKind);
		}
		return false;
	}

	/**
	 * Delete the old represenation of the transition
	 * 
	 * @param isBecomingInternal
	 * @param eObject
	 * @return
	 */
	private ICommand getDeleteCommand(boolean isBecomingInternal, EObject eObject) {
		Iterable<View> viewToDelete = getReferencingView(eObject, new ViewTypePredicate(getFactoryHint(!isBecomingInternal)));
		CompositeCommand cc = new CompositeCommand("Delete views representing the transition in its old state");////$NON-NLS-1$
		for(View v : viewToDelete) {
			DestroyElementRequest request = new DestroyElementRequest(v, false);
			DestroyElementPapyrusCommand destroyCommand = new DestroyElementPapyrusCommand(request);
			if(destroyCommand != null && destroyCommand.canExecute()) {
				cc.compose(destroyCommand);
			}
		}
		return cc.reduce();
	}

	protected String getFactoryHint(boolean isBecomingInternal) {
		return UMLVisualIDRegistry.getType(isBecomingInternal ? InternalTransitionEditPart.VISUAL_ID : TransitionEditPart.VISUAL_ID);
	}

	protected int getCompartmentID(boolean isBecomingInternal) {
		return isBecomingInternal ? InternalTransitionsCompartmentEditPart.VISUAL_ID : RegionCompartmentEditPart.VISUAL_ID;
	}
	/**
	 * Get the command to create the new views
	 */
	private ICommand getCreationCommand(final boolean isBecomingInternal, EObject eNotifier) {
		//		IGraphicalEditPart
		if(eNotifier instanceof Transition) {
			final Transition transition = (Transition)eNotifier;
			Iterable<View> newContainerViews = getReferencingView(transition.getSource(), new ViewTypePredicate(UMLVisualIDRegistry.getType(StateEditPart.VISUAL_ID)));
			 
			/*
			 * Create IElementType adapter
			 */
			EObjectAdapter transitionAdapter = createIElementTypeAdapter(isBecomingInternal, transition);
			ViewDescriptor descriptor = new ViewDescriptor(transitionAdapter, isBecomingInternal ? Node.class : Edge.class, getFactoryHint(isBecomingInternal), UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			CompositeCommand cc = new CompositeCommand("Create transition view");////$NON-NLS-1$
			for(View containerView : newContainerViews) {
				EditingDomain editinDomain = AdapterFactoryEditingDomain.getEditingDomainFor(transition);
				if(editinDomain instanceof TransactionalEditingDomain) {
					CreateViewCommand createViewCommand = new CreateViewCommand((TransactionalEditingDomain)editinDomain, descriptor, isBecomingInternal ? ViewUtil.getChildBySemanticHint(containerView, UMLVisualIDRegistry.getType(getCompartmentID(isBecomingInternal))) : containerView.getDiagram());
					SetConnectionEndsCommand setConnexionEndCommand = null;
					if(!isBecomingInternal) {
						setConnexionEndCommand = getCreateConnexionCommand(transition, descriptor, containerView, editinDomain, setConnexionEndCommand);
					}
					if(createViewCommand != null && createViewCommand.canExecute()) {
						cc.compose(createViewCommand);
						if(setConnexionEndCommand != null) {
							cc.compose(setConnexionEndCommand);
						}
					}
				}
			}
			for(View containerView : newContainerViews) {
				EditingDomain editinDomain = AdapterFactoryEditingDomain.getEditingDomainFor(transition);
				if(editinDomain instanceof TransactionalEditingDomain) {
					HideShowCompartmentIfEmptyCommand hideCommand = new HideShowCompartmentIfEmptyCommand((TransactionalEditingDomain)editinDomain, "Hide/show compartment",ViewUtil.getChildBySemanticHint(containerView, UMLVisualIDRegistry.getType(InternalTransitionsCompartmentEditPart.VISUAL_ID)));
					if (hideCommand.canExecute()){
						cc.compose(hideCommand);
					}
				}
			}
			return cc;
		}
		return null;
	}

	/**
	 * Get the command to create the edge ( case is not becoming internal)
	 * 
	 * @param transition
	 * @param descriptor
	 * @param containerView
	 * @param editinDomain
	 * @param setConnexionEndCommand
	 * @return
	 */
	protected SetConnectionEndsCommand getCreateConnexionCommand(final Transition transition, ViewDescriptor descriptor, View containerView, EditingDomain editinDomain, SetConnectionEndsCommand setConnexionEndCommand) {
		try {
			EObject stateView = getStateView(transition, containerView);
			if(stateView != null) {
				setConnexionEndCommand = new SetConnectionEndsCommand((TransactionalEditingDomain)editinDomain, "Set source/target of the transition");////$NON-NLS-1$							
				setConnexionEndCommand.setEdgeAdaptor(descriptor);
				setConnexionEndCommand.setNewSourceAdaptor(new EObjectAdapter(stateView));
				setConnexionEndCommand.setNewTargetAdaptor(new EObjectAdapter(stateView));
			} else {
				throw new RuntimeException(UNABLE_TO_RETREIVE_THE_STATE_EDIT_PART);////$NON-NLS-1$
			}
		} catch (NoSuchElementException e) {
			throw new RuntimeException(UNABLE_TO_RETREIVE_THE_STATE_EDIT_PART);////$NON-NLS-1$
		}
		return setConnexionEndCommand;
	}

	/**
	 * Retrieve the state view (source and/or target of the transition)
	 * 
	 * @param transition
	 * @param containerView
	 * @return
	 */
	protected EObject getStateView(final Transition transition, View containerView) {
		if (containerView!= null && containerView.getElement() != null && containerView.getElement().equals(transition.getSource())){
			return containerView;
		}
		return Iterators.find( containerView.eAllContents(), new Predicate<EObject>() {

			public boolean apply(EObject input) {
				if(input instanceof View) {
					View v = (View)input;
					EObject object = v.getElement();
					if(object != null && object.equals(transition.getSource()) && v.getType().equals(StateEditPart.VISUAL_ID)) {
						return true;
					}
				}
				return false;
			}
		});
	}

	/**
	 * Create an {@link IElementType} adapter to create a corresponding transation representation
	 * 
	 * @param isBecomingInternal
	 * @param transition
	 * @return
	 */
	protected EObjectAdapter createIElementTypeAdapter(final boolean isBecomingInternal, final Transition transition) {
		return new EObjectAdapter(transition) {

			@Override
			public Object getAdapter(Class adapter) {
				if(IElementType.class.equals(adapter)) {
					return UMLElementTypes.getElementType(isBecomingInternal ? InternalTransitionEditPart.VISUAL_ID : TransitionEditPart.VISUAL_ID);
				}
				return super.getAdapter(adapter);
			}
		};
	}
}
