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

package org.eclipse.papyrus.diagram.profile.custom.commands;


import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.profile.custom.requests.CustomCreateViewRequest;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPartCN;
import org.eclipse.papyrus.diagram.profile.providers.UMLViewProvider;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

/**
 * A custom creation view command for the metaclass that creates a <code>View</code>.
 */

public class CustomMetaClassCreateCommand extends org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand {

	/** height of a title package, approximatively */
	final static private int HEIGHT_TITLE_PACKAGE = 35;

	/** the height between two added metaclasses */
	final static private int HEIGHT_BETWEEN_TWO_METACLASS = 80;

	/** the view descriptor */
	protected CustomCreateViewRequest.ViewDescriptor myViewDescriptor;

	/** The location of the element */
	protected Point location;

	/**
	 * Creates a new CustomCreateCommand
	 * 
	 * @param editingDomain
	 *        the editing domain through which model changes are made
	 * @param descriptor
	 *        the view descriptor associated with this command
	 * @param containerView
	 *        the view that will contain the new view
	 * @param location
	 *        the location of the new metaclass
	 */

	public CustomMetaClassCreateCommand(TransactionalEditingDomain editingDomain, CustomCreateViewRequest.ViewDescriptor descriptor, View containerView, Point location) {


		// /!\ Warning
		//The new 2nd parameter is unused. It's here only to be in conformity with the superclass's constructor!
		super(editingDomain, new CreateViewRequest.ViewDescriptor(descriptor.getElementAdapter(), descriptor.getViewKind(), descriptor.getSemanticHint(), true, descriptor.getPreferencesHint()), containerView);

		//Assert.isNotNull(viewDescriptor);
		Assert.isNotNull(containerView);
		this.myViewDescriptor = descriptor;

		setLocation(location);
		// make sure the return object is available even before executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
	}


	/**
	 * Execute the command and create all the node contained by the custom request!
	 * 
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		//obtain the semanticHint in the viewDescriptor
		String semanticHint = myViewDescriptor.getSemanticHint();
		int iterNbAddedMetaclasses = 0;

		if(!(semanticHint.equals(((Integer)MetaclassEditPart.VISUAL_ID).toString())) && !(semanticHint.equals(((Integer)MetaclassEditPartCN.VISUAL_ID).toString()))) {
			return super.doExecuteWithResult(monitor, info);
		} else {

			UMLViewProvider viewProvider = new UMLViewProvider();


			Iterator adapterIterator = myViewDescriptor.getRequestAdapters().iterator();
			//-------------pour test
			//creation of the node!
			Iterator adapterIterator2 = myViewDescriptor.getRequestAdapters().iterator();
			CreateElementRequestAdapter adapter2;
			adapter2 = (CreateElementRequestAdapter)adapterIterator2.next();
			CreateElementRequest req = (CreateElementRequest)adapter2.getAdapter(CreateElementRequest.class);
			EObject container = req.getContainer();

			//creation of the nodes!
			while(adapterIterator.hasNext()) {
				CreateElementRequestAdapter adapter = (CreateElementRequestAdapter)adapterIterator.next();
				Node node = viewProvider.createNode(adapter, containerView, myViewDescriptor.getSemanticHint(), myViewDescriptor.getIndex(), myViewDescriptor.isPersisted(), myViewDescriptor.getPreferencesHint());
				Location notationLocation = NotationFactory.eINSTANCE.createBounds();
				notationLocation.setX(location.x);
				notationLocation.setY(location.y + iterNbAddedMetaclasses++ * HEIGHT_BETWEEN_TWO_METACLASS);
				node.setLayoutConstraint(notationLocation);
				//display stereotype
				Element UMLelement= (Element)adapter.getAdapter(EObject.class);
				String stereotypeName=UMLelement.getAppliedStereotypes().get(0).getQualifiedName();
				AppliedStereotypeHelper.getAddAppliedStereotypeCommand(getEditingDomain(), node, stereotypeName, VisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION);
			}
			return CommandResult.newOKCommandResult(myViewDescriptor);
		}

	}

	/**
	 * 
	 * @return
	 *         the location
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * set the location to the node
	 * 
	 * @param location
	 */
	public void setLocation(Point location) {
		this.location = location;
	}


}
