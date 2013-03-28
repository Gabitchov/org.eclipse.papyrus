/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.helper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.ConfirmActivityParameterNodeAndParameterSyncDialog;
import org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.WarningAndLinkDialog;
import org.eclipse.papyrus.uml.diagram.activity.part.CustomMessages;
import org.eclipse.papyrus.uml.diagram.activity.part.Messages;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * ActivityParameterAndParameterSynchronizer is a validator (see corresponding
 * extensions) to synchronize ActivityParameterNode with its Parameter
 * 
 */
public class ActivityParameterAndParameterSynchronizer extends AbstractModelConstraint {

	/** The label provider */
	private static final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/** The activity parameter nodes to remove with parameter */
	private Set<ActivityParameterNode> nodesToRemove = new HashSet<ActivityParameterNode>();

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("restriction")
	@Override
	public IStatus validate(IValidationContext ctx) {
		try {
			EObject eObject = ctx.getTarget();
			if(eObject instanceof Activity) {
				return handleActivityModification((Activity)eObject, ctx);
			} else if(eObject instanceof ActivityParameterNode) {
				return handleActivityParameterNodeModification((ActivityParameterNode)eObject, ctx);
			} else if(eObject instanceof Parameter) {
				return handleParameterModification((Parameter)eObject, ctx);
			}
			return ctx.createSuccessStatus();
		} catch (RuntimeException rte) {
			// avoid throwing uncaught exception which would disable the
			// constraint
			Log.warning(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "Unexpected exception during Activity Parameter Node and Parameter synchronization : ", rte);
			// ensure that the constraint's failure does not prevent
			// modification
			return ctx.createSuccessStatus();
		}
	}

	/**
	 * Handle activity parameter node modification to forbid activity parameter
	 * node type modification
	 * 
	 * @param eObject
	 * @param ctx
	 * @return the status
	 */
	private IStatus handleActivityParameterNodeModification(ActivityParameterNode eObject, IValidationContext ctx) {
		if(EMFEventType.SET.equals(ctx.getEventType()) && UMLPackage.eINSTANCE.getTypedElement_Type().equals(ctx.getFeature())) {
			// does not allow type change for activity parameter node, display a
			// message to inform the user
			final Parameter parameter = eObject.getParameter();
			if(parameter != null) {
				final String elementLabel = labelProvider.getText(parameter);
				final String message = NLS.bind(CustomMessages.ActivityParameterAndParameterSynchronizer_UnauthorizedModificationRedirection, elementLabel);
				SafeDialogOpenerDuringValidation<Void> opener = new SafeDialogOpenerDuringValidation<Void>() {

					protected Void openDialog() {
						WarningAndLinkDialog dialog = new WarningAndLinkDialog(new Shell(Display.getDefault()), CustomMessages.ActivityParameterAndParameterSynchronizer_UnauthorizedModificationTitle, message, parameter, elementLabel);
						dialog.open();
						return null;
					}
				};
				opener.execute();
				return ctx.createFailureStatus();
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Handle parameter modification to synchronize the type of the associated
	 * activity parameter nodes
	 * 
	 * @param eObject
	 * @param ctx
	 * @return the status
	 */
	private IStatus handleParameterModification(Parameter eObject, IValidationContext ctx) {
		if(EMFEventType.SET.equals(ctx.getEventType()) && UMLPackage.eINSTANCE.getTypedElement_Type().equals(ctx.getFeature())) {
			// change the type of all the associated activity parameter node
			for(ActivityParameterNode node : getActivityParameterNodesFromParameter(eObject)) {
				node.setType(node.getParameter().getType());
			}
		} else if(EMFEventType.SET.equals(ctx.getEventType()) && UMLPackage.eINSTANCE.getNamedElement_Name().equals(ctx.getFeature())) {
			// set the name of all the unnamed associated activity parameter
			// nodes
			for(ActivityParameterNode node : getActivityParameterNodesFromParameter(eObject)) {
				if(node.getName() == null || "".equals(node.getName())) {
					node.setName(eObject.getName());
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Handle activity modification - add parameter node: set the type with the
	 * associated parameter type - remove parameter: remove all the associated
	 * activity parameter nodes
	 * 
	 * @param eObject
	 * @param ctx
	 * @return the status
	 */
	private IStatus handleActivityModification(Activity eObject, IValidationContext ctx) {
		// initialize type when an activity parameter node is created
		if((EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) && ctx.getFeatureNewValue() instanceof ActivityParameterNode) {
			ActivityParameterNode activityParameterNode = (ActivityParameterNode)ctx.getFeatureNewValue();
			// The type of an activity parameter node is the same as the type of
			// its parameter.
			activityParameterNode.setType(activityParameterNode.getParameter().getType());
		}
		// constraint: the nodes of an activity must include one
		// ActivityParameterNode for each parameter
		if((EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) && ctx.getFeatureNewValue() instanceof Parameter) {
			Parameter parameter = (Parameter)ctx.getFeatureNewValue();
			if(getActivityParameterNodesFromParameter(parameter).isEmpty()) {
				ActivityParameterNode apn = UMLFactory.eINSTANCE.createActivityParameterNode();
				apn.setParameter(parameter);
				apn.setName(parameter.getName());
				apn.setType(parameter.getType());
				Command cmd = getAddActivityParameterNodesCmd(eObject, apn);
				if(cmd.canExecute()) {
					cmd.execute();
				} else {
					return ctx.createFailureStatus();
				}
			}
		}
		// parameter deletion
		else if(((EMFEventType.REMOVE.equals(ctx.getEventType()) && ctx.getFeatureNewValue() instanceof Parameter) || EMFEventType.REMOVE_MANY.equals(ctx.getEventType()))) {
			nodesToRemove.clear();
			// remove associated activity parameter nodes with the parameter
			for(Notification n : ctx.getAllEvents()) {
				if(ENotificationImpl.SET == n.getEventType() && UMLPackage.eINSTANCE.getActivityParameterNode_Parameter().equals(n.getFeature()) && n.getNotifier() instanceof ActivityParameterNode) {
					nodesToRemove.add((ActivityParameterNode)n.getNotifier());
				}
				// first request is to remove the activity parameter node, it
				// must not be remove because of parameter deletion
				if(ENotificationImpl.REMOVE == n.getEventType() && n.getOldValue() instanceof ActivityParameterNode) {
					nodesToRemove.remove(n.getOldValue());
				}
			}
			if(!nodesToRemove.isEmpty()) {
				if(askForValidation(nodesToRemove)) {
					Command cmd = getRemoveActivityParameterNodesCmd(eObject, nodesToRemove);
					if(cmd.canExecute()) {
						cmd.execute();
					} else {
						return ctx.createFailureStatus();
					}
				} else {
					return ctx.createFailureStatus();
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Gets the associated activity parameter nodes from a specified parameter.
	 * 
	 * @param parameter
	 *        the parameter
	 * @return the activity parameter nodes
	 */
	private Set<ActivityParameterNode> getActivityParameterNodesFromParameter(Parameter parameter) {
		Set<ActivityParameterNode> references = new HashSet<ActivityParameterNode>();
		if(parameter != null) {
			Collection<Setting> inverseReferences = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(parameter);
			for(Setting ref : inverseReferences) {
				if(UMLPackage.eINSTANCE.getActivityParameterNode_Parameter().equals(ref.getEStructuralFeature()) && ref.getEObject().eContainer() != null) {
					references.add((ActivityParameterNode)ref.getEObject());
				}
			}
		}
		return references;
	}

	/**
	 * Command to remove the activity parameter nodes that's not have associated
	 * parameter.
	 * 
	 * @param owner
	 *        the activity that owns the nodes
	 * @param nodes
	 *        the nodes
	 * @return the remove command
	 */
	private Command getRemoveActivityParameterNodesCmd(Activity owner, Set<ActivityParameterNode> nodes) {
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		return RemoveCommand.create(editingdomain, owner, UMLPackage.eINSTANCE.getActivity_Node(), nodes);
	}

	/**
	 * Gets the adds the activity parameter nodes command.
	 * 
	 * @param owner
	 *        the owner
	 * @param node
	 *        the node
	 * @return the adds the activity parameter nodes command
	 */
	private Command getAddActivityParameterNodesCmd(Activity owner, ActivityParameterNode node) {
		TransactionalEditingDomain editingdomain = EditorUtils.getTransactionalEditingDomain();
		return AddCommand.create(editingdomain, owner, UMLPackage.eINSTANCE.getActivity_Node(), node);
	}

	/**
	 * Ask the user to validate all the implied modifications (parameters and
	 * activity parameter nodes)
	 * 
	 * @param parameterNodes
	 *        the list of impacted activityParameterNodes
	 * @return whether the user validates the modifications
	 */
	protected boolean askForValidation(final Set<? extends NamedElement> parameterNodes) {
		SafeDialogOpenerDuringValidation<Boolean> opener = new SafeDialogOpenerDuringValidation<Boolean>() {

			protected Boolean openDialog() {
				return ConfirmActivityParameterNodeAndParameterSyncDialog.openConfirmFromParameter(Display.getDefault().getActiveShell(), parameterNodes, labelProvider);
			}
		};
		return opener.execute();
	}
}
