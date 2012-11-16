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

import java.util.StringTokenizer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateAppliedStereotypePropertyViewCommand;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypePropertyEditPart;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This editpolicy is used to add dynamically labels of stereotypes into nodes int the context of AppliedStereorypeCompartmentEditpart
 */
public class AppliedStereotypePropertiesEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {


	public static String APPLIED_STEREOTYPE_VISIBILITY_COMPARTMENT= "AppliedStereotypeVisibilityEditPolicy"; 
	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public AppliedStereotypePropertiesEditPolicy() {
		super();
	}

	/**
	 * Returns the uml element controlled by the host edit part
	 * 
	 * @return the uml element controlled by the host edit part
	 */
	protected Element getUMLElement() {
		return (Element)((View)getView().eContainer()).getElement();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractAppliedStereotypeDisplayEditPolicy#getView()
	 *
	 * @return
	 */
	protected View getView() {
		return (View)((EObject)getHost().getModel()).eContainer();
	}


	/**
	 * this method is used to create a notation node for the property of the stereotype
	 * @param editPart the  editpart container
	 * @param stereotypesPropertiesToDisplay list of applied stereotype properties to display
	 * @param node the comaprtment node that contains all properties
	 * @param stereotype the stereotype associated to compartment node 
	 */
	protected void executeAppliedStereotypePropertytCreation(final GraphicalEditPart editPart, final String stereotypesPropertiesToDisplay,final View node, final Stereotype stereotype) {
		try {
			editPart.getEditingDomain().runExclusive(new Runnable() {
				public void run() {
					Display.getCurrent().asyncExec(new Runnable() {
						public void run() {

							StringTokenizer propStringTokenizer = new StringTokenizer(stereotypesPropertiesToDisplay, ",");
							while(propStringTokenizer.hasMoreElements()) {
								// extract property to display
								String propertyQN = propStringTokenizer.nextToken();
								//get a property that is interesting for us
								if( propertyQN.startsWith(stereotype.getQualifiedName())){

									String propertyName= propertyQN.substring(propertyQN.lastIndexOf(".")+1);
									Property stereotypeProperty=StereotypeUtil.getPropertyByName(stereotype, propertyName);

									Node sterotypePropertyNode= null;
									int i=0;
									//we go through all sub nodes to get sub node that is link to this property
									while(i<node.getChildren().size()&&sterotypePropertyNode==null){
										if( (node.getChildren().get(i)) instanceof Node){
											final Node currentNode=(Node)(node.getChildren().get(i));
											if(currentNode.getType().equals(AppliedStereotypePropertyEditPart.ID)){
												if( currentNode.getElement().equals(stereotypeProperty)){
													sterotypePropertyNode= currentNode;
												}
											}
										}
										i++;
									}
									if( sterotypePropertyNode==null){
										//System.err.println("+ add "+stereotypeProperty );
										CreateAppliedStereotypePropertyViewCommand command= new CreateAppliedStereotypePropertyViewCommand(editPart.getEditingDomain(), editPart.getNotationView(), stereotypeProperty);
										editPart.getEditingDomain().getCommandStack().execute(command);
									}
								}
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
	 * 
	 * {@inheritedDoc}
	 */
	public void notifyChanged(Notification notification) {
		// refresh obly when the EAnnotation about stereotype is added or remove
		// to update only property of stereotype application


		// if element that has changed is a stereotype => refresh the label.
		if(notification.getNotifier() instanceof Node && (notification.getEventType()==Notification.ADD) &&(notification.getNewValue() instanceof EAnnotation)) {
			if(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION == ((EAnnotation)notification.getNewValue()).getSource() ) {
				// stereotype annotation has changed => refresh label display
				refreshDisplay();
			}
		}
	}


	/**
	 * maybe to remove
	 */
	protected void refreshEAnnotation() {
		final GraphicalEditPart editPart= (GraphicalEditPart)getHost();
		String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View)editPart.getNotationView().eContainer());
		EObject stereotypeApplication=editPart.resolveSemanticElement();
		Stereotype stereotype=UMLUtil.getStereotype(stereotypeApplication);
		final RecordingCommand command=AppliedStereotypeHelper.getAddAppliedStereotypeCommand(editPart.getEditingDomain(), editPart.getNotationView(), stereotype.getQualifiedName(), presentationKind);
		try {

			editPart.getEditingDomain().runExclusive(new Runnable() {
				public void run() {
					Display.getCurrent().asyncExec(new Runnable() {
						public void run() {
							editPart.getEditingDomain().getCommandStack().execute(command);
						}
					});
				}
			});

		} catch (Exception e) {
			System.err.println(e);
		}
	}
	protected void refreshStereotypeDisplay() {}


	/**
	 * Refreshes the stereotype application property 
	 */
	public void refreshDisplay() {
		if(((View)getHost().getModel()).eContainer()!=null ){
			String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay((View)((View)getHost().getModel()).eContainer());
			final GraphicalEditPart editPart= (GraphicalEditPart)getHost();
			final View node=editPart.getNotationView();

			//1. Manage adding of application stereotype properties
			EObject stereotypeApplication=editPart.resolveSemanticElement();
			Stereotype stereotype=UMLUtil.getStereotype(stereotypeApplication);
			//if stereotype is null all property of stereotype has to be removed!
			if( stereotype!=null){
				//go through each stereotype property
				executeAppliedStereotypePropertytCreation(editPart, stereotypesPropertiesToDisplay, node, stereotype);

				//Manage removing of Stereotype application properties
				manageRemovingPropertiesNodes(stereotypesPropertiesToDisplay, editPart, node, stereotype);


			}
			else{
				try{
					editPart.getEditingDomain().runExclusive(new Runnable() {
						public void run() {
							Display.getCurrent().asyncExec(new Runnable() {
								public void run() {
									DeleteCommand command= new DeleteCommand((View)getHost().getModel());
									editPart.getEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
								}

							});
						}
					});
				}catch (Exception e) {
					System.err.println(e);
				}

			}
		}
	}



	/**
	 * this method is used to remove nodes of property that are not in a given list
	 *@param stereotypesPropertiesToDisplay a list of qualified name of properties
	 * @param editPart the graphical editpart that is the container
	 * @param node the notation node that is the container
	 * @param stereotype the stereotype that is display in this container
	 */
	protected void manageRemovingPropertiesNodes(String stereotypesPropertiesToDisplay, final GraphicalEditPart editPart, final View node, Stereotype stereotype) {
		int i=0;
		while(i<node.getChildren().size()){
			if( (node.getChildren().get(i)) instanceof Node){
				final Node currentNode=(Node)(node.getChildren().get(i));
				if(currentNode.getType().equals(AppliedStereotypePropertyEditPart.ID)){
					Property property=(Property)currentNode.getElement();
					final String propertyQN= stereotype.getQualifiedName()+"."+property.getName();
					if(!stereotypesPropertiesToDisplay.contains(propertyQN) ){
						try{
							//yes, Execution of the Deletion command
							editPart.getEditingDomain().runExclusive(new Runnable() {
								public void run() {
									Display.getCurrent().asyncExec(new Runnable() {
										public void run() {
											if( currentNode.eContainer()!=null){
												//System.err.println("- remove "+propertyQN );
												DeleteCommand command= new DeleteCommand(currentNode);
												editPart.getEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
											}

										}
									});
								}
							});
						}
						catch (Exception e) {
							System.err.println(e);
						}
					}

				}
			}
			i++;
		}
	}	

}
