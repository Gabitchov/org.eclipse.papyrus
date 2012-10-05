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
 *   Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.listeners;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.interfaces.InterruptibleEdge;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ControlFlowInterruptibleIconEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ObjectFlowInterruptibleIconEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.request.InterruptibleEdgeRequest;
import org.eclipse.papyrus.uml.diagram.common.listeners.AbstractPapyrusModifcationTriggerListener;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.common.util.functions.EObjectToViewFunction;
import org.eclipse.papyrus.uml.diagram.common.util.functions.SettingToEObjectFunction;
import org.eclipse.papyrus.uml.diagram.common.util.predicates.ReferencingViewPredicate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Iterables;

/**
 * This listener handle Interruptible Edge
 * 
 * @author arthur daussy
 * 
 */
public class InterruptibleEdgeListener extends AbstractPapyrusModifcationTriggerListener {

	/**
	 * Id of all Visual ID of the interruptible Icon
	 */
	private static ImmutableBiMap<EClass, String> INTERRUPTIBLE_EDGE_ICON_VISUAL_ID_COLLECTION = ImmutableBiMap.of(UMLPackage.Literals.OBJECT_FLOW, String.valueOf(ObjectFlowInterruptibleIconEditPart.VISUAL_ID), UMLPackage.Literals.CONTROL_FLOW, String.valueOf(ControlFlowInterruptibleIconEditPart.VISUAL_ID));

	private static NotificationFilter FEATURE_FILTER = null;

	public static NotificationFilter getFEATURE_FILTER() {
		if(FEATURE_FILTER == null) {
			FEATURE_FILTER = NotificationFilter.createFeatureFilter(UMLPackage.Literals.ACTIVITY_EDGE__INTERRUPTS);
		}
		return FEATURE_FILTER;
	}

	/**
	 * get the edit part registry
	 * 
	 * @return
	 */
	protected DiagramEditPart getDiagramEditPart() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = page.getActiveEditor();
		if(editor instanceof PapyrusMultiDiagramEditor) {
			PapyrusMultiDiagramEditor papyrusEditor = (PapyrusMultiDiagramEditor)editor;
			return papyrusEditor.getDiagramEditPart();
		}
		return null;
	}

	/**
	 * This command will react on a SET event of the structural feature describe in
	 * {@link InterruptibleEdgeListener#isCorrectStructuralfeature(EStructuralFeature)} This will create a new view if the newValue != null or delete
	 * it if null
	 */
	@Override
	protected ICommand getModificationCommand(Notification notif) {
		if(Notification.SET == notif.getEventType()) {
			CompositeCommand cc = new CompositeCommand("Interruptible Edge Command");////$NON-NLS-0$
			//Handling views
			final Iterable<IGraphicalEditPart> edgesEditPart = DiagramEditPartsUtil.getChildrenByEObject((EObject)notif.getNotifier(), getDiagramEditPart(), true);
			InterruptibleEdgeRequest request = new InterruptibleEdgeRequest();
			Iterable<View> views = getReferencingView(notif);
			if(notif.getNewValue() != null) {
				//handle create view
				request.setType(InterruptibleEdgeRequest.SET_INTERRUPTIBLE_EDGE);
				for(View view : views) {
					try {
						String visualID = INTERRUPTIBLE_EDGE_ICON_VISUAL_ID_COLLECTION.get(view.getElement().eClass());
						ICommand createViewCommand = createInterruptibleEdgeIcon(view, visualID);
						if(createViewCommand != null && createViewCommand.canExecute()) {
							cc.compose(createViewCommand);
						}
					} catch (NullPointerException e) {
						throw new RuntimeException("Unable to find the Visual ID of the Icon of the interruptible Edge for element" + view.getElement());
					}
				}
			} else {
				//handle delete view
				request.setType(InterruptibleEdgeRequest.UNSET_INTERRUPTIBLE_EDGE);
				for(View view : views) {
					try {
						String visualID = INTERRUPTIBLE_EDGE_ICON_VISUAL_ID_COLLECTION.get(view.getElement().eClass());
						ICommand destroyCommand = destroyInterruptibleIcon((View)view, visualID);
						if(destroyCommand != null && destroyCommand.canExecute()) {
							cc.compose(destroyCommand);
						}
					} catch (NullPointerException e) {
						throw new RuntimeException("Unable to find the Visual ID of the Icon of the interruptible Edge for element" + view.getElement());
					}
				}
			}
			for(IGraphicalEditPart edgeEditPart : edgesEditPart) {
				if(edgeEditPart != null && edgeEditPart instanceof InterruptibleEdge && edgeEditPart.getModel() instanceof View) {
					//Ask for the edit if something more else has to be done
					Command command = edgeEditPart.getCommand(request);
					if(command != null && command.canExecute()) {
						cc.compose(new CommandProxy(command));
					}
				}
			}
			return cc;
		}
		return null;
	}

	/**
	 * Get all the view from Notation Model which represent the notifier.
	 * Will only return the view of the same type than the notifier view
	 * 
	 * @param notif
	 * @param edgeEditPart
	 * @return
	 */
	public Iterable<View> getReferencingView(Notification notif) {
		final ActivityEdge element = getElement(notif);
		Resource eResource = element.eResource();
		if(eResource != null) {
			ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(eResource.getResourceSet());
			if(adapter == null) {
				adapter = new ECrossReferenceAdapter();
			}
			Collection<Setting> inverseReferences = adapter.getInverseReferences(element);
			Iterable<EObject> settings = Iterables.transform(inverseReferences, new SettingToEObjectFunction());
			Iterable<EObject> eObjects = Iterables.filter(settings, new ReferencingViewPredicate(element));
			Iterable<View> views = Iterables.transform(eObjects, new EObjectToViewFunction());
			return views;
		}
		return Collections.emptyList();
	}

	private TransactionalEditingDomain getEditingDomain(View model) {
		DiagramEditPart diagramEditPart = getDiagramEditPart();
		if(diagramEditPart != null) {
			return diagramEditPart.getEditingDomain();
		}
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(model);
		if(editingDomain instanceof TransactionalEditingDomain) {
			return (TransactionalEditingDomain)editingDomain;
		}
		return null;
	}

	/**
	 * Create the command to withdraw interruptible edge icon from the activity edge
	 * 
	 * @return
	 */
	private ICommand destroyInterruptibleIcon(final View model, final String visualID) {
		TransactionalEditingDomain editingDomain = getEditingDomain(model);
		if(editingDomain != null) {
			AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "Destroy Interruptible Edge Icon", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					if(model != null) {
						View interruptibleEdgeIconView = ViewUtil.getChildBySemanticHint(model, visualID);
						ViewUtil.destroy(interruptibleEdgeIconView);
						return CommandResult.newOKCommandResult();
					}
					return null;
				}
			};
			return cmd;
		}
		return null;
	}

	/**
	 * Create the Interruptible Edge Icon View
	 * 
	 * @return Command to be executed or {@link UnexecutableCommand#INSTANCE} if unable to create
	 */
	private ICommand createInterruptibleEdgeIcon(final View model, final String visualID) {
		TransactionalEditingDomain editingDomain = getEditingDomain(model);
		if(editingDomain != null) {
			AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(editingDomain, "Create Interruptible Edge Icon", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					if(model != null) {
						Node node = ViewService.createNode((View)model, visualID, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
						if(node != null) {
							return CommandResult.newOKCommandResult(node);
						} else {
							return CommandResult.newErrorCommandResult("Unable to create the view for Interruptible Edge label");
						}
					}
					return null;
				}

				/*
				 * TODO test if needed
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doUndo(org.eclipse.core.runtime.IProgressMonitor,
				 * org.eclipse.core.runtime.IAdaptable)
				 */
				@Override
				protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					IStatus status = super.doUndo(monitor, info);
					getDiagramEditPart().refresh();
					return status;
				}

				/*
				 * TODO test if needed
				 * (non-Javadoc)
				 * 
				 * @see
				 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doUndo(org.eclipse.core.runtime.IProgressMonitor,
				 * org.eclipse.core.runtime.IAdaptable)
				 */
				@Override
				protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					IStatus status = super.doRedo(monitor, info);
					getDiagramEditPart().refresh();
					return status;
				}
			};
			return cmd;
		}
		return null;
	}

	protected ActivityEdge getElement(Notification notif) {
		Object element = notif.getNotifier();
		if(element instanceof ActivityEdge) {
			return (ActivityEdge)element;
		}
		return null;
	}

	@Override
	public NotificationFilter getFilter() {
		return getFEATURE_FILTER();
	}
}
