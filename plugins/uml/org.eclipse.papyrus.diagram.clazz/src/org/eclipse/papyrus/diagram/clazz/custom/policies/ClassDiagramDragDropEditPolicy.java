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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import java.util.Collection;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.diagram.clazz.custom.helper.AssociationClassHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ClassLinkMappingHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiDependencyHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;

/**
 * The Class ClassDiagramDragDropEditPolicy.
 */
public class ClassDiagramDragDropEditPolicy extends CustomDiagramDragDropEditPolicy {

	/** The specific drop node. */
	public int[] secificDropNode = { 2014, 2013, 2015 };

	/**
	 * Instantiates a new class diagram drag drop edit policy.
	 */
	public ClassDiagramDragDropEditPolicy() {
		super();
		init(secificDropNode);
	}

	/**
	 * this method has in charge to create command for create an association if the number of endtype is superior of 2 a multi association is dropped. if the number of endtype this is binary
	 * association that is dropped.
	 * 
	 * @param dropRequest
	 *            the drop request
	 * @param semanticLink
	 *            the semantic link
	 * @param nodeVISUALID
	 *            the node visualid
	 * 
	 * @return the command
	 */
	protected Command dropAssociation(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		Collection endtypes = ClassLinkMappingHelper.getSource(semanticLink);
		if (endtypes.size() == 2) {
			Element source = (Element) endtypes.toArray()[0];
			Element target = (Element) endtypes.toArray()[1];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, 4001, dropRequest.getLocation(), semanticLink));
		}
		if (endtypes.size() > 2) {
			MultiAssociationHelper associationHelper = new MultiAssociationHelper(getEditingDomain());
			return associationHelper.dropMutliAssociation((Association) semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart) getHost())
					.getNotationView());
		}
		return UnexecutableCommand.INSTANCE;

	}

	/**
	 * this method send a Command that create views for associationClass
	 * 
	 * @param dropRequest
	 *            the drop request
	 * @param semanticLink
	 *            the semantic link
	 * @param nodeVISUALID
	 *            the node visualid
	 * 
	 * @return the command
	 */
	protected Command dropAssociationClass(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		AssociationClassHelper associationClassHelper = new AssociationClassHelper(getEditingDomain());
		return associationClassHelper.dropAssociationClass((AssociationClass) semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart) getHost())
				.getNotationView());
	}

	/**
	 * this method send a command to create views to display
	 * 
	 * @param dropRequest
	 *            the drop request
	 * @param semanticLink
	 *            the semantic link
	 * @param nodeVISUALID
	 *            the node visualid
	 * 
	 * @return the command
	 */
	protected Command dropDependency(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		Collection sources = ClassLinkMappingHelper.getSource(semanticLink);
		Collection targets = ClassLinkMappingHelper.getTarget(semanticLink);
		if (sources.size() == 1 && targets.size() == 1) {
			Element source = (Element) sources.toArray()[0];
			Element target = (Element) targets.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, 4008, dropRequest.getLocation(), semanticLink));
		}
		if (sources.size() > 1 || targets.size() > 1) {
			MultiDependencyHelper dependencyHelper = new MultiDependencyHelper(getEditingDomain());
			return dependencyHelper.dropMutliDependency((Dependency) semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart) getHost())
					.getNotationView());
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritedDoc}
	 */
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		switch (nodeVISUALID) {
		case 2014:
			return dropDependency(dropRequest, semanticLink, nodeVISUALID);
		case 2013:
			return dropAssociationClass(dropRequest, semanticLink, nodeVISUALID);
		case 2015:
			return dropAssociation(dropRequest, semanticLink, nodeVISUALID);

		default:
			return UnexecutableCommand.INSTANCE;
		}
	}

}
