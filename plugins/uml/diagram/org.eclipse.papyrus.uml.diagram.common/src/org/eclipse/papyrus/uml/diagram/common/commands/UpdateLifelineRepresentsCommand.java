/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.Iterator;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.StructuredClassifier;

/**
 * Command for updating the represents property associated with a Lifeline
 * 
 * Creation 13 juin 06
 * 
 * @author jlescot
 */
public class UpdateLifelineRepresentsCommand extends AbstractCommand {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
	 */
	@Override
	public boolean canExecute() {

		return true;
	}

	/** The Lifeline to update */
	private final Lifeline lifeline;

	/** The Classifier to associate */
	private final Classifier classifier;

	private boolean createProperty;

	private boolean createConnectorEnd;

	/**
	 * The Property used to link the Classifier with the Lifeline through the
	 * Represents property
	 */
	private ConnectableElement newProperty;

	private ConnectorEnd connectorend;

	private ConnectableElement oldProperty;

	private final EditingDomain editingDomain;

	/**
	 * Create a command for updating InstanceSpecification values
	 * 
	 * @param lifeline
	 *        the current lifeline object
	 * @param classifier
	 *        the new classifier that represents the lifeline
	 * @param domain
	 *        the edit domain
	 */
	// @unused
	public UpdateLifelineRepresentsCommand(Lifeline lifeline, Classifier classifier, EditingDomain domain) {
		this.lifeline = lifeline;
		this.classifier = classifier;
		this.editingDomain = domain;

		this.label = "Updates the Classifier that represents and Lifeline";
		this.isExecutable = true;
		this.isPrepared = true;
	}

	/**
	 * Return the connector end which has the correct property as role, owned by
	 * a connector in the interaction
	 * 
	 * @param interaction
	 *        the owning interaction
	 * @param prop
	 *        the property
	 * 
	 * @return the ConnectorEnd
	 */
	protected ConnectorEnd getConnectorEnd(Interaction interaction, ConnectableElement prop) {
		EList connectors = interaction.getOwnedConnectors();
		Connector connector;
		if(connectors.isEmpty()) {
			connector = interaction.createOwnedConnector(null);
			// LabelHelper.INSTANCE.initName(editDomain, interaction,
			// connector);
			return null;
		}

		Iterator itconnectors = connectors.iterator();
		ConnectorEnd end = null;
		while(end == null && itconnectors.hasNext()) {
			Iterator itends = ((Connector)itconnectors.next()).getEnds().iterator();
			while(end == null && itends.hasNext()) {
				ConnectorEnd e = (ConnectorEnd)itends.next();
				if(e.getRole() == prop) {
					end = e;
				}
			}
		}
		return end;
	}

	/**
	 * Store the old Property associated with the represents property of the
	 * Lifeline and then make the redo
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		oldProperty = lifeline.getRepresents();

		redo();
	}

	/**
	 * Update the lifeline parameters
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		if(classifier == null) {
			deleteAuxElements();

			createProperty = false;
			createConnectorEnd = false;
			return;
		}

		if(lifeline.getRepresents() != null) { // Clean and begin from scratch
			deleteAuxElements();
		}

		// Retrieve the interaction from the Lifeline
		Interaction interaction = lifeline.getInteraction();

		// Try to get the first Property of the given type
		newProperty = interaction.getOwnedAttribute(null, classifier);
		createProperty = newProperty == null;

		// If a such property doesn't exist, create it
		if(createProperty) {
			newProperty = interaction.createOwnedAttribute(null, classifier);
			// LabelHelper.INSTANCE.initName(editDomain, interaction,
			// newProperty);
		}

		// Search a ConnectorEnd with the role set to the found property
		connectorend = getConnectorEnd(interaction, newProperty);

		createConnectorEnd = connectorend == null;

		// if a such property doesn't exist, create it
		if(createConnectorEnd) {
			connectorend = (interaction.getOwnedConnectors().get(0)).createEnd();
			connectorend.setRole(newProperty);
		}

		lifeline.setRepresents(newProperty);
	}

	private void deleteAuxElements() {
		ConnectableElement connectElem = lifeline.getRepresents();
		lifeline.setRepresents(null);
		removeIfNotReferenced(connectElem);

	}

	private void removeIfNotReferenced(ConnectableElement connectElem) {
		// Retrieve the interaction from the Lifeline
		Interaction interaction = lifeline.getInteraction();

		if(interaction.getOwnedConnectors().size() > 0) {
			Connector connector = interaction.getOwnedConnectors().get(0);
			if(connector != null) {
				for(ConnectorEnd cEnd : connector.getEnds()) {
					if(cEnd.getRole().equals(connectElem)) {

						connectElem.destroy();

						cEnd.destroy();

						return;
					}
				}
			}
		}

	}

	/**
	 * Undo the update
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		if(createConnectorEnd) {
			connectorend.setRole(null);
			((Connector)connectorend.getOwner()).getEnds().remove(connectorend);
		}

		if(createProperty) {
			((StructuredClassifier)newProperty.getOwner()).getOwnedAttributes().remove(newProperty);
		}

		lifeline.setRepresents(oldProperty);
	}
}
