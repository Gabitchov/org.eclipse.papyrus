/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateAppliedStereotypeViewCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.SetNodeVisibilityCommand;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypeConpartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * this edit policy can be apply only on {@link IPapyrusEditPart} in order to
 * access to primary figure. the primary figure has to be a {@link IPapyrusNodeUMLElementFigure}
 */
public class AppliedStereotypeCompartmentEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public AppliedStereotypeCompartmentEditPolicy() {
		super();
	}

	

	@Override
	public void activate() {
		super.activate();

		// if stereotype has been applied, compartment has to be created
		Element umlElement = getUMLElement();
		//umlElement may be null if the semantic element has been deleted and the view hasn't been cleaned
		if(umlElement != null) {
			Iterator<EObject> iterator = umlElement.getStereotypeApplications().iterator();
			while(iterator.hasNext()) {
				final EObject appliedstereotype = iterator.next();
				createAppliedStereotypeCompartment(appliedstereotype);
			}
		}
	}


	protected boolean hasToDisplayCompartment(EObject applicationOfStereotype) {
		String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay((View)getHost().getModel());
		String stereotypesLocalizationToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization((View)getHost().getModel());
		if( !(stereotypesLocalizationToDisplay.equals(UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION))){
			return false;
		}
		HashSet<org.eclipse.uml2.uml.Stereotype> stereoSet = new HashSet<org.eclipse.uml2.uml.Stereotype>();
		ArrayList<String> stPropList = new ArrayList<String>();

		// fill our data structure in order to generate the string
		StringTokenizer propStringTokenizer = new StringTokenizer(stereotypesPropertiesToDisplay, ",");
		while(propStringTokenizer.hasMoreElements()) {
			// extract property to display
			String propertyQN = propStringTokenizer.nextToken();
			// stereotype
			String stereotypeQN = propertyQN.substring(0, propertyQN.indexOf("."));

			Stereotype stereotype = hostSemanticElement.getAppliedStereotype(stereotypeQN);

			if(stereotype != null) {
				stereoSet.add(stereotype);
			}

			stPropList.add(propertyQN);
		}

		// Display each stereotype
		Iterator<org.eclipse.uml2.uml.Stereotype> stereoIter = stereoSet.iterator();
		while(stereoIter.hasNext()) {
			Stereotype stereotype = stereoIter.next();
			if(stereotype != null) {
				if(applicationOfStereotype.equals(hostSemanticElement.getStereotypeApplication(stereotype))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * the goal of this method is to execute the a command to create a notation node for a compartment of stereotype
	 * 
	 * @param editPart
	 *        the editpart owner of the new compartment
	 * @param appliedstereotype
	 *        the stereotype application
	 */
	protected void executeAppliedStereotypeCompatmentCreation(final GraphicalEditPart editPart, final EObject appliedstereotype) {
		try {
			editPart.getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							
							CreateAppliedStereotypeViewCommand command = new CreateAppliedStereotypeViewCommand(editPart.getEditingDomain(), editPart.getNotationView(), appliedstereotype, hasToDisplayCompartment(appliedstereotype));
							//use to avoid to put it in the command stack
							 Map<String,Boolean> options = new HashMap<String,Boolean>();  
								options.put(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
							try{
								InternalTransaction it=((InternalTransactionalEditingDomain) editPart.getEditingDomain()).startTransaction(false, options);
								command.execute();
								it.commit();
							}catch(Exception e){
								System.err.println(e);
							}
							
						}
					});
				}
			});
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
	@Override
	public void notifyChanged(Notification notification) {
		// change the label of the figure managed by the host edit part (managed
		// by the parent edit
		// part in general...)
		// it must be changed only if:
		// - the annotation corresponding to the display of the stereotype
		// changes
		// - the stereotype application list has changed
		final int eventType = notification.getEventType();
		if(eventType == PapyrusStereotypeListener.APPLIED_STEREOTYPE) {
			// a stereotype was applied to the notifier
			// then a new listener should be added to the stereotype application
			getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
			createAppliedStereotypeCompartment((EObject)notification.getNewValue());
		} else if(eventType == PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE) {
			getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
			cleanStereotypeDisplayInEAnnotation();
			removeAppliedStereotypeCompartment((EObject)notification.getNewValue());

		}
		// if element that has changed is a stereotype => refresh the label.
		if(notification.getNotifier() instanceof Node && (notification.getEventType() == Notification.ADD) && (notification.getNewValue() instanceof EAnnotation)) {
			if(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION == ((EAnnotation)notification.getNewValue()).getSource()) {
				// stereotype annotation has changed => refresh label display
				refreshDisplay();
			}
		}
		// if element that has changed is a stereotype => refresh the label.
		if(notification.getNotifier()  instanceof EAnnotation && (notification.getEventType() == Notification.ADD)) {
			if(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION == ((EAnnotation)notification.getNotifier()).getSource()) {
						// stereotype annotation has changed => refresh label display
				refreshDisplay();
			}
		}
	}



	/**
	 * this method creates a node for the compartment of stereotype if it does not exist.
	 * 
	 * @param stereotypeApplication
	 *        the stereotype application
	 */
	public void createAppliedStereotypeCompartment(final EObject stereotypeApplication) {
		final GraphicalEditPart editPart = (GraphicalEditPart)getHost();
		final View node = editPart.getNotationView();
		// llok for the coressponded node for the stereotype application
		View correspondedAppliedStereotype = getCoresspondedStereotypeApplication(stereotypeApplication, node);
		//it does not exist
		if(correspondedAppliedStereotype == null) {
			executeAppliedStereotypeCompatmentCreation(editPart, stereotypeApplication);
		}
	}

	/**
	 * the goal of this method is to execute the a command to create a notation node for a compartment of stereotype
	 * 
	 * @param editPart
	 *        the editpart owner of the new compartment
	 * @param appliedstereotype
	 *        the stereotype application
	 */
	protected void setVisivility(final View view, final boolean isVisible) {
		try {
			final GraphicalEditPart editPart = (GraphicalEditPart)getHost();
			editPart.getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							SetNodeVisibilityCommand setCommand = new SetNodeVisibilityCommand(editPart.getEditingDomain(), view, isVisible);
							//use to avoid to put it in the command stack
							 Map<String,Boolean> options = new HashMap<String,Boolean>();  
								options.put(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
							try{
								InternalTransaction it=((InternalTransactionalEditingDomain) editPart.getEditingDomain()).startTransaction(false, options);
								setCommand.execute();
								it.commit();
							}catch(Exception e){
								System.err.println(e);
							}
						}
					});
				}
			});
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * the goal of this method is to return the node that references the stereotype application
	 * 
	 * @param stereotypeApplication
	 *        the application of the sterotype
	 * @param node
	 *        the notation node where we look for all subnodes
	 * @return the corresponded node or null
	 */
	protected View getCoresspondedStereotypeApplication(final EObject stereotypeApplication, final View node) {
		View correspondedAppliedStereotype = null;
		int i = 0;
		// wee look for through all sub nodes
		while(correspondedAppliedStereotype == null && i < node.getChildren().size()) {
			if((node.getChildren().get(i)) instanceof Node) {
				if(stereotypeApplication.equals(((Node)(node.getChildren().get(i))).getElement())) {
					correspondedAppliedStereotype = ((Node)(node.getChildren().get(i)));
				}
			}
			i++;
		}
		return correspondedAppliedStereotype;
	}

	/**
	 * this method suppress the sub-nodes that references the stereotype application
	 * it cleans also all sub-nodes with the type ApplicationStereotype that not references an application of stereotypes
	 * (this is the case when a stereotype has been unapplied without suppress the compartment.
	 * 
	 * @param stereotypeApplication
	 */
	public void removeAppliedStereotypeCompartment(final EObject stereotypeApplication) {
		if(stereotypeApplication == null) {
			return;
		}
		final GraphicalEditPart editPart = (GraphicalEditPart)getHost();
		final View node = editPart.getNotationView();
		try {
			int i = 0;
			//we go through all sub nodes 
			while(i < node.getChildren().size()) {
				if((node.getChildren().get(i)) instanceof Node) {
					final Node currentNode = (Node)(node.getChildren().get(i));
					//it references the stereotype application?
					if(stereotypeApplication.equals(currentNode.getElement())) {
						//yes, Execution of the Deletion command
						editPart.getEditingDomain().runExclusive(new Runnable() {

							public void run() {
								Display.getCurrent().asyncExec(new Runnable() {

									public void run() {
										DeleteCommand command = new DeleteCommand(currentNode);
										//use to avoid to put it in the command stack
										 Map<String,Boolean> options = new HashMap<String,Boolean>();  
											options.put(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
										try{
											InternalTransaction it=((InternalTransactionalEditingDomain) editPart.getEditingDomain()).startTransaction(false, options);
											GMFtoEMFCommandWrapper warpperCmd= new GMFtoEMFCommandWrapper (command);
											warpperCmd.execute();
											it.commit();
										}catch(Exception e){
											System.err.println(e);
										}
									}
								});
							}
						});
					}
					// the sub nodes has the type appliedStereotypeCompartment but does not references a application of stereotype
					if((currentNode.getType().equals(AppliedStereotypeConpartmentEditPart.ID)) && (!(currentNode.getElement() instanceof DynamicEObjectImpl))) {
						//yes, Execution of the Deletion command
						editPart.getEditingDomain().runExclusive(new Runnable() {

							public void run() {
								Display.getCurrent().asyncExec(new Runnable() {

									public void run() {
										if(currentNode!=null&&editPart.getEditingDomain()!=null){
											DeleteCommand command = new DeleteCommand(editPart.getEditingDomain(),currentNode);
											//use to avoid to put it in the command stack
											 Map<String,Boolean> options = new HashMap<String,Boolean>();  
												options.put(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
											try{
												InternalTransaction it=((InternalTransactionalEditingDomain) editPart.getEditingDomain()).startTransaction(false, options);
												GMFtoEMFCommandWrapper warpperCmd= new GMFtoEMFCommandWrapper (command);
												warpperCmd.execute();
												it.commit();
											}catch(Exception e){
												System.err.println(e);
											}
										}
									}
								});
							}
						});
					}
				}
				i++;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * Refreshes the stereotype display
	 */
	@Override
	protected void refreshAppliedStereotypesPropertiesInCompartment(String stereotypesPropertiesToDisplay, IPapyrusNodeUMLElementFigure figure) {
		final boolean displayInCompartment = AppliedStereotypeHelper.hasAppliedStereotypesPropertiesToDisplay((View)getHost().getModel(), UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);
		// if the string is not empty, then, the figure has to display it. Else,
		// it displays nothing
		final GraphicalEditPart editPart = (GraphicalEditPart)getHost();
		final View node = editPart.getNotationView();
		int i = 0;
		//we go through all sub nodes 
		while(i < node.getChildren().size()) {
			if((node.getChildren().get(i)) instanceof Node) {
				final Node currentNode = (Node)(node.getChildren().get(i));
				if(currentNode.getType().equals(AppliedStereotypeConpartmentEditPart.ID)) {
					EObject stereotypeApplication = currentNode.getElement();
					Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
					if(stereotype != null && stereotypesPropertiesToDisplay.contains(stereotype.getQualifiedName())) {
						setVisivility(currentNode, displayInCompartment);
					} else {
						setVisivility(currentNode, false);
					}
				}
			}
			i++;
		}
	}
}
