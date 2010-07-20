/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.edit.policies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.composite.custom.edit.parts.PropertyPartEditPartCN;
import org.eclipse.papyrus.diagram.composite.custom.log.Log;
import org.eclipse.papyrus.diagram.composite.edit.parts.PortEditPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;


/**
 * This EditPolicy listens to changes in the type of property. If the type change or if the inherited chain of the type changes,
 * it removes the element owned by the type which are drawn on the property.
 * Currently the type which can show properties in a part are :
 * <ul>
 * <li> {@link Class}</li>
 * <li> {@link DataType}</li>
 * </ul>
 * 
 * @author VL222926
 * 
 */
public class PartEditPolicy extends AbstractEditPolicy implements NotificationListener, IPapyrusListener {

	/** Identifier for this EditPolicy */
	public static Object CLEAN_PART_ROLE = "Part Role Edit Policy"; //$NON-NLS-1$

	/** stores the host associated semantic element */
	protected EObject hostSemanticElement;

	/** the type of the property */
	protected Type type = null;

	/** the property */
	protected Property prop;

	/** if the type is a {@link Class}, contains all its superclass */
	protected List<Classifier> superClasses = new ArrayList<Classifier>();

	/** contains all the EditParts representing the property {@link Property} */
	protected List<EditPart> propertyEditParts = new ArrayList<EditPart>();

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void activate() {
		View view = (View)getHost().getModel();
		hostSemanticElement = view.getElement();
		getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);
		if(hostSemanticElement instanceof Property) {
			prop = (Property)hostSemanticElement;
			type = ((Property)hostSemanticElement).getType();
			if(type != null) {
				getDiagramEventBroker().addNotificationListener(type, this);
				if(type instanceof Classifier) {
					addNotificationListenerOnSuperClasses((Classifier)type);
				}
			}
		}

	}


	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {
		getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);
		if(type != null) {
			getDiagramEventBroker().removeNotificationListener(type, this);
			type = null;
		}
		hostSemanticElement = null;
		//remove the listener on each superclass
		cleanSuperclasses();

	}


	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	private DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}


	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param notification
	 */
	public void notifyChanged(Notification notification) {
		int event = notification.getEventType();
		Object notifier = notification.getNotifier();
		Object oldValue = notification.getOldValue();
		Object newValue = notification.getNewValue();
		if(hostSemanticElement == notifier) {//the notification concerns the property
			if(event == Notification.SET) {
				if(((oldValue != null) && (oldValue == this.type)) || ((Property)hostSemanticElement).getType() == newValue) {//the request concerns the type

					//remove the listener on the old type
					getDiagramEventBroker().removeNotificationListener((Type)oldValue, this);

					//add the listener on the new type
					getDiagramEventBroker().addNotificationListener(type, this);

					//updateView
					updateView();
				}

			}
		} else { //the notification comes from a class
			if(event == Notification.REMOVE) {
				if((oldValue instanceof Port) || (oldValue instanceof Generalization)) {
					updateView();
				}
			}
		}
	}


	/**
	 * <ul>
	 * <li>remove the listener on the classes contained by {@link #superClasses}</li>
	 * <li>add listener on the super classes of {@link #type}</li>
	 * <li>fill {@link #superClasses} with the super classes of {@link #type}</li>
	 * </ul>
	 */
	protected void updateSuperClass() {
		cleanSuperclasses();
		if(type instanceof Classifier) {
			addNotificationListenerOnSuperClasses((Classifier)type);
		}
	}



	/**
	 * <ul>
	 * <li>Remove the listener on classes contained in {@link #superClasses}</li>
	 * <li>Clean {@link #superClasses}</li>
	 * </ul>
	 */
	protected void cleanSuperclasses() {
		for(Classifier currentClass : superClasses) {
			getDiagramEventBroker().removeNotificationListener(currentClass, this);
		}
		superClasses.clear();
	}



	/**
	 * 
	 * <ul>
	 * <li>Add recursively a notification listener on the super classes of <code> myClass </code></li>
	 * <li>Add the super classes into {@link #superClasses}</li>
	 * </ul>
	 * 
	 * @param myClassifier
	 *        the class to manage
	 */
	protected void addNotificationListenerOnSuperClasses(Classifier myClassifier) {
		EList<Generalization> generalizations = myClassifier.getGeneralizations();
		for(Generalization generalization : generalizations) {
			Classifier classifier = generalization.getGeneral();
			this.superClasses.add(classifier);
			getDiagramEventBroker().addNotificationListener(classifier, this);
			addNotificationListenerOnSuperClasses(classifier);
		}
	}



	/**
	 * Call the command to remove the unsignificant views and execute it.
	 */
	protected void updateView() {
		final CompoundCommand command = getUpdateCommand();
		if(command.canExecute()) {
			//with the Undo, the EditPart are not redrawn
			executeCommand(command);

			//2 Undo actions are required to have a correct model
			//executeCommandInCommandStack(command);
		}
	}



	/**
	 * Returns the command to delete all the views which are become insignificant with the last change
	 * 
	 * @return
	 *         the command to delete all the views which are become insignificant with the last change
	 */
	protected CompoundCommand getUpdateCommand() {
		this.type = this.prop.getType();
		updateSuperClass();
		CompoundCommand cc = new CompoundCommand("Delete View Command"); //$NON-NLS-1$
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		//the children EditPart for the hostSemanticElement
		List<EditPart> children = getChildrenEditPartForHostEditPart();
		List<Classifier> allClassesToTest = new ArrayList<Classifier>();
		allClassesToTest.addAll(superClasses);

		if(this.type != null && type instanceof Class) {
			allClassesToTest.add((Class)type);
		}
		for(EditPart currentEP : children) {
			if(currentEP instanceof PortEditPart || currentEP instanceof PropertyPartEditPartCN) {
				EObject element = ((View)currentEP.getModel()).getElement();

				boolean exist = false;
				if(this.type instanceof Classifier) {
					EList<Property> allAttributes = ((Classifier)type).getAllAttributes();

					if(allAttributes.contains(element)) {
						exist = true;
					}
				}
				if(!exist) {
					DeleteCommand cmd = new DeleteCommand(theEditingDomain, (View)currentEP.getModel());
					cc.add(new ICommandProxy(cmd));
				}
			}
		}
		return cc;
	}



	/**
	 * 
	 * Warning : With a Undo, this method do nothing!
	 * 
	 * Executes the supplied command inside an <code>unchecked action</code>
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

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				cmd.execute();

				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Log.getInstance().warn("Ignored exception : " + e);
		}
	}



	/**
	 * Warning : currently this method is not used, because the Undo is done twice.
	 * 
	 * Executes the supplied command inside an <code>unchecked action</code>
	 * 
	 * @param cmd
	 *        command that can be executed (i.e., cmd.canExecute() == true)
	 */
	protected void executeCommandInCommandStack(final CompoundCommand cmd) {
		final TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(cmd.canExecute() && !cmd.isEmpty()) {
			try {
				editingDomain.runExclusive(new Runnable() {

					public void run() {
						Display.getCurrent().asyncExec(new Runnable() {

							public void run() {
								editingDomain.getCommandStack().execute(new GEFtoEMFCommandWrapper(cmd));
							}
						});
					}
				});
			} catch (InterruptedException e) {
				Log.getInstance().error(e);
			}
		}
	}

	/**
	 * Returns the EditPart owned by the representations of {@link #property}, more the contents of the CompartmentEditPart for each representation
	 * 
	 * @return
	 *         the EditPart owned by the representations of {@link #property}, more the contents of the CompartmentEditPart for each representation
	 */
	protected List<EditPart> getChildrenEditPartForHostEditPart() {
		List<EditPart> children = new ArrayList<EditPart>();
		//the list of the views for the property
		List<?> views = DiagramEditPartsUtil.getEObjectViews(this.prop);

		if(!views.isEmpty()) {
			CoreMultiDiagramEditor editor = (CoreMultiDiagramEditor)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			DiagramEditPart rootEP = editor.getDiagramEditPart();

			//we search all the children for this EditPart !
			for(Object currentView : views) {
				if(currentView instanceof View) {
					EditPart propEP = DiagramEditPartsUtil.getEditPartFromView((View)currentView, rootEP);
					List<?> childrenEPs = propEP.getChildren();
					for(Object child : childrenEPs) {

						// Add current child to the list
						children.add((EditPart)child);

						// If current child is a compartment, we add its own children to the list too
						if(child instanceof CompartmentEditPart) {
							Iterator<?> it = ((CompartmentEditPart)child).getChildren().iterator();
							while(it.hasNext()) {
								children.add((EditPart)it.next());
							}
						}


					}
				}
			}
		}
		return children;
	}

}
