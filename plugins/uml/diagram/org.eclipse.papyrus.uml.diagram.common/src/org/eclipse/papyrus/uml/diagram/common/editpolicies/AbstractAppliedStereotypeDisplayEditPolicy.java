/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Specific edit policy for label displaying stereotypes and their properties
 * for representing UML elements.
 */
public abstract class AbstractAppliedStereotypeDisplayEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	/** constant for this edit policy role */
	public final static String STEREOTYPE_LABEL_POLICY = "AppliedStereotypeDisplayEditPolicy";

	/** host semantic element */
	protected Element hostSemanticElement;

	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public AbstractAppliedStereotypeDisplayEditPolicy() {
		super();
	}


	/**
	 * clean stereotype to display in Eannotation this method can be called directly
	 * at the activation of this class
	 */
	protected void cleanStereotypeDisplayInEAnnotation(){
		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View)getHost().getModel());

		StringTokenizer strQualifiedName = new StringTokenizer(stereotypesToDisplay, ",");
		while(strQualifiedName.hasMoreElements()) {
			String currentStereotype = strQualifiedName.nextToken();

			// check if current stereotype is applied
			final Element umlElement = getUMLElement();
			Stereotype stereotype = umlElement.getAppliedStereotype(currentStereotype);
			if(stereotype == null) {
				removeEAnnotationAboutStereotype(currentStereotype);
			}

		}
	}
	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		hostSemanticElement = getUMLElement();

		// adds a listener on the view and the element controlled by the
		// editpart
		getDiagramEventBroker().addNotificationListener(view, this);

		if(hostSemanticElement == null) {
			return;
		}
		getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);

		// adds the listener for stereotype application and applied stereotypes
		// add listener to react to the application and remove of a stereotype

		// add a lister to each already applied stereotyped
		for(EObject stereotypeApplication : hostSemanticElement.getStereotypeApplications()) {
			getDiagramEventBroker().addNotificationListener(stereotypeApplication, this);
		}

		refreshDisplay();
		// try to display stereotype properties
		cleanStereotypeDisplayInEAnnotation();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}

		getDiagramEventBroker().removeNotificationListener(view, this);

		if(hostSemanticElement == null) {
			return;
		}
		// remove listeners to applied stereotyped
		for(EObject stereotypeApplication : hostSemanticElement.getStereotypeApplications()) {
			getDiagramEventBroker().removeNotificationListener(stereotypeApplication, this);
		}
		// remove notification on element
		getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);

		// removes the reference to the semantic element
		hostSemanticElement = null;
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * Returns the uml element controlled by the host edit part
	 * 
	 * @return the uml element controlled by the host edit part
	 */
	protected Element getUMLElement() {
		return (Element)getView().getElement();
	}

	/**
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View)getHost().getModel();
	}

	protected void removeEAnnotationAboutStereotype(final String stereotypeQN){

		try {
			if( getView()!=null){
				final TransactionalEditingDomain editingDomain= TransactionUtil.getEditingDomain(getView());
				if( editingDomain!=null){
					editingDomain.runExclusive(new Runnable() {

						public void run() {

							Display.getCurrent().asyncExec(new Runnable() {

								public void run() {
									if( getView()!=null&& editingDomain!=null){
										String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(getView());
										RecordingCommand command = AppliedStereotypeHelper.getRemoveAppliedStereotypeCommand(editingDomain, getView(),stereotypeQN, presentationKind);
										editingDomain.getCommandStack().execute(command);
									}
								}
							});
						}
					});
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
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
		} else if(eventType == PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE) {
			getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
			cleanStereotypeDisplayInEAnnotation();

		}

		// if element that has changed is a stereotype => refresh the label.
		if(notification.getNotifier() instanceof EAnnotation) {
			if(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION == ((EAnnotation)notification.getNotifier()).getSource()) {
				// stereotype annotation has changed => refresh label display
				refreshDisplay();
			}
		}

		// if element that has changed is a stereotype => refresh the label.
		if((eventType == PapyrusStereotypeListener.MODIFIED_STEREOTYPE)) {
			// stereotype annotation has changed => refresh label display
			refreshDisplay();
		}

		// The value of a property of stereotype (dynamic profile) has changed
		// To avoid refresh to be called during stereotype removal (stereotype#base_xxx set to null in particular) a complementary test is 
		// added here to ensure the stereotype is still applied (the notifier is a stereotype application of the semantic element).
		if((notification.getNotifier() instanceof DynamicEObjectImpl) && (hostSemanticElement != null) && (hostSemanticElement.getStereotypeApplications().contains(notification.getNotifier()))) {
			refreshDisplay();
		}
	}

	/**
	 * Refreshes the display for the element controlled by the edit part with
	 * this edit policies
	 */
	public abstract void refreshDisplay();

	/**
	 * Parses the string containing the complete definition of properties to be
	 * displayed, and generates a map.
	 * 
	 * @param stereotypesToDisplay
	 *        the list of stereotypes to display
	 * @param stereotypesPropertiesToDisplay
	 *        the properties of stereotypes to display
	 * @return a map. The keys are the name of displayed stereotypes, the
	 *         corresponding data is a collection of its properties to be
	 *         displayed
	 */
	protected Map<String, List<String>> parseStereotypeProperties(String stereotypesToDisplay, String stereotypesPropertiesToDisplay) {
		Map<String, List<String>> propertiesMap = new HashMap<String, List<String>>();

		StringTokenizer stringTokenizer = new StringTokenizer(stereotypesPropertiesToDisplay, UMLVisualInformationPapyrusConstant.STEREOTYPE_PROPERTIES_LIST_SEPARATOR);
		while(stringTokenizer.hasMoreTokens()) {
			String propertyName = stringTokenizer.nextToken();
			// retrieve the name of the stereotype for this property
			String stereotypeName = propertyName.substring(0, propertyName.lastIndexOf(".")); // stereotypequalifiedName.propertyname
			if(!propertiesMap.containsKey(stereotypeName)) {
				List<String> propertiesForStereotype = new ArrayList<String>();
				propertiesMap.put(stereotypeName, propertiesForStereotype);
			}
			propertiesMap.get(stereotypeName).add(propertyName.substring(propertyName.lastIndexOf(".") + 1, propertyName.length()));
		}
		return propertiesMap;
	}

	/**
	 * Returns the image to be displayed for the applied stereotypes.
	 * 
	 * @return the image that represents the first applied stereotype or <code>null</code> if no image has to be displayed
	 */
	public Image stereotypeIconToDisplay() {
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View)getHost().getModel());
		if(stereotypespresentationKind == null) {
			return null;
		}
		if(stereotypespresentationKind.equals(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION) || stereotypespresentationKind.equals(UMLVisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION)) {

			// retrieve the first stereotype in the list of displayed stereotype
			String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View)getHost().getModel());
			StringTokenizer tokenizer = new StringTokenizer(stereotypesToDisplay, ",");
			if(tokenizer.hasMoreTokens()) {
				String firstStereotypeName = tokenizer.nextToken();
				Stereotype stereotype = getUMLElement().getAppliedStereotype(firstStereotypeName);
				return Activator.getIconElement(getUMLElement(), stereotype, false);
			}
		}
		return null;
	}
}
