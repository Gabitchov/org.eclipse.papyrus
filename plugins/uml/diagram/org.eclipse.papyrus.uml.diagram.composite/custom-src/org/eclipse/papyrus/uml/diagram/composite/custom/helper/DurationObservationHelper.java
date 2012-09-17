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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This class handles {@link DurationObservation} drop in diagram.
 * Derived from {@link AssociationHelper}
 */
public class DurationObservationHelper extends ElementHelper {

	/**
	 * Instantiates a new DurationObservation helper.
	 * 
	 * @param editDomain
	 *        the edit domain
	 */
	public DurationObservationHelper(TransactionalEditingDomain editDomain) {
		this.editDomain = editDomain;
	}

	/**
	 * Drop DurationObservation.
	 * 
	 * @param durationobservation
	 *        the association class the semantic element
	 * @param viewer
	 *        the viewer
	 * @param diagramPreferencesHint
	 *        the diagram preferences hint
	 * @param location
	 *        the location of the drop
	 * @param containerView
	 *        the container view that will contain the associationClass views
	 * 
	 * @return the command
	 */
	public Command dropDurationObservation(DurationObservation durationObservation, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, View containerView) {
		CompositeCommand cc = new CompositeCommand("dropDurationObservation");
		int nbEvents = durationObservation.getEvents().size();

		// 0. Obtain list of the events
		ArrayList<NamedElement> endToConnect = new ArrayList<NamedElement>(durationObservation.getEvents());
		GraphicalEditPart[] endEditPart = new GraphicalEditPart[nbEvents];

		// 1. Look for if each event is on the diagram
		Iterator<NamedElement> iteratorProp = endToConnect.iterator();
		int index = 0;
		while(iteratorProp.hasNext()) {

			NamedElement currentEvent = iteratorProp.next();

			// look for if an EditPart exist for this element
			Collection<?> editPartSet = viewer.getEditPartRegistry().values();
			Iterator<?> editPartIterator = editPartSet.iterator();

			while(editPartIterator.hasNext() && endEditPart[index] == null) {

				EditPart currentEditPart = (EditPart)editPartIterator.next();

				if(currentEditPart instanceof GraphicalEditPart && currentEvent.equals(((GraphicalEditPart)currentEditPart).resolveSemanticElement())) {
					/**
					 * Warning : TimeObservationEditPart, TimeObservationStereotypeLabelEditPart and
					 * TimeObservationNameEditPart are equal : This is the object of this 2nd IF!!!
					 */
					if(!(currentEditPart instanceof CompartmentEditPart) && !(currentEditPart instanceof LabelEditPart))
						endEditPart[index] = (GraphicalEditPart)currentEditPart;
				}

			}
			index += 1;
		}

		// 2. creation of the node DurationObservation

		IAdaptable elementAdapter = new EObjectAdapter(durationObservation);
		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)UMLElementTypes.DurationObservation_2093).getSemanticHint(), ViewUtil.APPEND, false, diagramPreferencesHint);
		CreateCommand nodeCreationCommand = new CreateCommand(getEditingDomain(), descriptor, ((View)containerView));
		cc.compose(nodeCreationCommand);

		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), location);
		cc.compose(setBoundsCommand);

		if(nbEvents != 0) {
			IAdaptable sourceEventAdapter = null;
			IAdaptable targetEvent0Adapter = null;
			IAdaptable targetEvent1Adapter = null;

			// obtain the node figure
			sourceEventAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();

			// used in the creation command of each event
			ConnectionViewDescriptor dashedLineViewDescriptor = new ConnectionViewDescriptor(UMLElementTypes.DurationObservationEvent_4019, ((IHintedType)UMLElementTypes.DurationObservationEvent_4019).getSemanticHint(), diagramPreferencesHint);

			// 3. creation of the dashed line between the associationClass link
			if(endEditPart[0] != null) {

				targetEvent0Adapter = new SemanticAdapter(null, endEditPart[0].getModel());
				CommonDeferredCreateConnectionViewCommand dashedLineCmd = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.DurationObservationEvent_4019).getSemanticHint(), ((IAdaptable)sourceEventAdapter), ((IAdaptable)targetEvent0Adapter), viewer, diagramPreferencesHint, dashedLineViewDescriptor, null);
				dashedLineCmd.setElement(durationObservation);
				cc.compose(dashedLineCmd);

			}

			if((nbEvents == 2) && endEditPart[1] != null) {
				targetEvent1Adapter = new SemanticAdapter(null, endEditPart[1].getModel());
				CommonDeferredCreateConnectionViewCommand dashedLineCmd = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.DurationObservationEvent_4019).getSemanticHint(), ((IAdaptable)sourceEventAdapter), ((IAdaptable)targetEvent1Adapter), viewer, diagramPreferencesHint, dashedLineViewDescriptor, null);
				dashedLineCmd.setElement(durationObservation);
				cc.compose(dashedLineCmd);
			}

		}
		return new ICommandProxy(cc);
	}

}
