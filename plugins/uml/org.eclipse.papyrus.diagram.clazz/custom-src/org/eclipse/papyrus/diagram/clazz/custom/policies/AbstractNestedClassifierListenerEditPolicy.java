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
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.editpolicies.ListenerEventEditPolicy;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Use as based class for Nested Classifier Listener (for example see {@link ClassNestedClassifierListenerEditPolicy})
 * 
 * @author arthur daussy
 * 
 */
public abstract class AbstractNestedClassifierListenerEditPolicy extends ListenerEventEditPolicy {

	@Override
	public void activate() {
		super.activate();
		validateNestedClassifier();
	}
	/**
	 * Validate that there no orphan view for nested classifier
	 */
	@SuppressWarnings("unchecked")
	private void validateNestedClassifier() {
		try {
			IGraphicalEditPart graphicalEditPart = (IGraphicalEditPart)getHost();
			EObject element = graphicalEditPart.resolveSemanticElement();
			for(EStructuralFeature feature : getEStructuralFeaturesToListen()) {
				Object values = element.eGet(feature);
				if(values instanceof Collection<?>) {
					final Collection<?> valuesFeature = (Collection<?>)values;
					//transform child to view
					Iterable<View> objectToView = Iterables.transform((EList<Object>)graphicalEditPart.getNotationView().getChildren(), new Function<Object, View>() {

						public View apply(Object from) {
							if(from instanceof View) {
								return (View)from;
							}
							return null;
						}
					});
					//get the view to delete (View which refer to element which is not in the collection referred by the listenned feature)
					Iterable<View> viewToDelete = Iterables.filter(objectToView, new Predicate<View>() {

						public boolean apply(View input) {
							if(input != null) {
								return !valuesFeature.contains(input.getElement());
							}
							return false;
						}
					});
					CompositeCommand cc = new CompositeCommand("Delete nested class view for old nested classifier");////$NON-NLS-N$
					for(final View v : viewToDelete) {
						ICommand cmd = new AbstractTransactionalCommand(graphicalEditPart.getEditingDomain(), cc.getLabel(), null) {

							@Override
							protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
								if(v != null) {
									ViewUtil.destroy(v);
									return CommandResult.newOKCommandResult();
								}
								return CommandResult.newErrorCommandResult("The view to delete is equal to null");////$NON-NLS-0$
							}
						};
						if(cmd != null && cmd.canExecute()) {
							cc.compose(cmd);
						}
					}
					executeCommand(new ICommandProxy(cc.reduce()));
				}
			}
		} catch (ClassCastException e) {
			throw new RuntimeException("AbstractNestedClassifierListenerEditPolicy should be installed on a IGraphicalEditPart which refer to an EncapsulatedClassifier element");////$NON-NLS-0$
		}
	}

	/**
	 * Executes the supplied command inside an <code>unchecked action</code> COPIED FROM CANONICAL EDIT POLICY
	 * 
	 * @param cmd
	 *        command that can be executed (i.e., cmd.canExecute() == true)
	 */
	protected void executeCommand(final Command cmd) {
		Map<String, Boolean> options = null;
		EditPart ep = getHost();
		boolean isActivating = true;
		// use the viewer to determine if we are still initializing the diagram
		// do not use the DiagramEditPart.isActivating since ConnectionEditPart's
		// parent will not be a diagram edit part
		EditPartViewer viewer = ep.getViewer();
		if(viewer instanceof DiagramGraphicalViewer) {
			isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
		}
		if(isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart)getHost(), false, false))
			options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
		AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart)getHost()).getEditingDomain(), StringStatics.BLANK, options) {

			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				cmd.execute();
				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "executeCommand", e); //$NON-NLS-1$
			Log.warning(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "executeCommand", e); //$NON-NLS-1$
		}
	}

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

	protected ICommand getCommandForListenEvent(EObject newObject, EObject oldObject, EStructuralFeature feature, int eventType, EObject notifier) {
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
	 * @see org.eclipse.papyrus.diagram.common.editpolicies.ListenerEventEditPolicy#handleNotificationType(int)
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
