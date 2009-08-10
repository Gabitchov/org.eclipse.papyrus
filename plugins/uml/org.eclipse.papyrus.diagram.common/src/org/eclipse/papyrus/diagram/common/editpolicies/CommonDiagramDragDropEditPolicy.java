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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - refactor common behavior between diagrams
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.CustomDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.uml2.uml.Element;

/**
 * This class is used to execute the drag and drop from the outline. It can manage the drop of nodes and binary links.
 */
public abstract class CommonDiagramDragDropEditPolicy extends DiagramDragDropEditPolicy {

	/** The specific drop. */
	private ArrayList specificDrop = new ArrayList();
	
	/** The specified link mapping helper dependeing on the diagram */
	private ILinkMappingHelper linkmappingHelper;
	
	/**
	 * Instantiates a new custom diagram drag drop edit policy.
	 * 
	 * @param mappingHelper the mapping helper
	 */
	public CommonDiagramDragDropEditPolicy(ILinkMappingHelper mappingHelper) {
		linkmappingHelper = mappingHelper;
	}
	
	/**
	 * Gets the UML element type for the specified
	 * 
	 * @param elementID the element id
	 * 
	 * @return the uML element type
	 */
	public abstract IElementType getUMLElementType(int elementID);
	
	public abstract int getNodeVisualID(View containerView, EObject domainElement);
	
	public abstract int getLinkWithClassVisualID(EObject domainElement);

	/**
	 * {@inheritedDoc}
	 */
	protected Command createViewsAndArrangeCommand(DropObjectsRequest dropRequest, List viewDescriptors) {
		CreateViewRequest createViewRequest = new CreateViewRequest(viewDescriptors);
		createViewRequest.setLocation(dropRequest.getLocation());
		Command createCommand = getHost().getCommand(createViewRequest);
		return createCommand;
	}

	/**
	 * the method provides command to create the binary link into the diagram. If the source and the
	 * target views do not exist, these views will be created.
	 * 
	 * @param cc
	 *            the composite command that will contain the set of command to create the binary
	 *            link
	 * @param source
	 *            the source the element source of the link
	 * @param target
	 *            the target the element target of the link
	 * @param linkVISUALID
	 *            the link VISUALID used to create the view
	 * @param location
	 *            the location the location where the view will be be created
	 * @param semanticLink
	 *            the semantic link that will be attached to the view
	 * 
	 * @return the composite command
	 */
	public CompositeCommand dropBinaryLink(CompositeCommand cc, Element source, Element target, int linkVISUALID,
			Point location, Element semanticLink) {
		// look for editpart
		GraphicalEditPart sourceEditPart = (GraphicalEditPart) lookForEditPart(source);
		GraphicalEditPart targetEditPart = (GraphicalEditPart) lookForEditPart(target);

		// descriptor of the link
		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(
				getUMLElementType(linkVISUALID), ((IHintedType) getUMLElementType(linkVISUALID)).getSemanticHint(), getDiagramPreferencesHint());

		IAdaptable sourceAdapter = null;
		IAdaptable targetAdapter = null;
		if (sourceEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(source), Node.class, null,
					ViewUtil.APPEND, false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart) getHost()).getEditingDomain(),
					descriptor, ((View) getHost().getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move",
					(IAdaptable) nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x,
							location.y + 100));
			cc.compose(setBoundsCommand);

			sourceAdapter = (IAdaptable) nodeCreationCommand.getCommandResult().getReturnValue();
		} else {
			sourceAdapter = new SemanticAdapter(null, sourceEditPart.getModel());
		}
		if (targetEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(target), Node.class, null,
					ViewUtil.APPEND, false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart) getHost()).getEditingDomain(),
					descriptor, ((View) getHost().getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move",
					(IAdaptable) nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x,
							location.y - 100));
			cc.compose(setBoundsCommand);
			targetAdapter = (IAdaptable) nodeCreationCommand.getCommandResult().getReturnValue();

		} else {
			targetAdapter = new SemanticAdapter(null, targetEditPart.getModel());
		}

		CustomDeferredCreateConnectionViewCommand aLinkCommand = new CustomDeferredCreateConnectionViewCommand(
				getEditingDomain(), ((IHintedType) getUMLElementType(linkVISUALID)).getSemanticHint(),
				sourceAdapter, targetAdapter, getViewer(), getDiagramPreferencesHint(), linkdescriptor, null);
		aLinkCommand.setElement(semanticLink);
		cc.compose(aLinkCommand);
		return cc;

	}
	
	/**
	 * Gets the diagram preferences hint.
	 * 
	 * @return the diagram preferences hint
	 */
	protected PreferencesHint getDiagramPreferencesHint() {
		return ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint();
	}

	/**
	 * {@inheritedDoc}.
	 */
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		// Create a view request from the drop request and then forward getting
		// the command for that.
		CompositeCommand cc = new CompositeCommand("Drop");
		List viewDescriptors = new ArrayList();
		Iterator iter = dropRequest.getObjects().iterator();
		if (dropRequest.getObjects().size() > 0 && dropRequest.getObjects().get(0) instanceof String) {
			return getDropFileCommand(dropRequest);
		}
		Point location = dropRequest.getLocation().getCopy();
		((GraphicalEditPart) getHost()).getContentPane().translateToRelative(location);
		((GraphicalEditPart) getHost()).getContentPane().translateFromParent(location);
		location.translate(((GraphicalEditPart) getHost()).getContentPane().getClientArea().getLocation().getNegated());
		while (iter.hasNext()) {
			EObject dropObject = (EObject) iter.next();
			int nodeVISUALID = getNodeVisualID(((IGraphicalEditPart) getHost()).getNotationView(),
					dropObject);
			int linkVISUALID = getLinkWithClassVisualID(dropObject);
			if (specificDrop.contains(nodeVISUALID) || specificDrop.contains(linkVISUALID)) {
				return getSpecificDropCommand(dropRequest, (Element) dropObject, nodeVISUALID, linkVISUALID);
			}
			IAdaptable elementAdapter = new EObjectAdapter(dropObject);
			if (linkVISUALID == -1 && nodeVISUALID != -1) {
				// this is a node
				ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class,
						((IHintedType) getUMLElementType(nodeVISUALID)).getSemanticHint(),
						ViewUtil.APPEND, false, getDiagramPreferencesHint());
				CreateCommand createCommand = new CreateCommand(getEditingDomain(), descriptor, ((View) (getHost()
						.getModel())));
				cc.compose(createCommand);

				SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move",
						(IAdaptable) createCommand.getCommandResult().getReturnValue(), location);
				cc.compose(setBoundsCommand);
			} else if (linkVISUALID != -1) {
				Collection sources = linkmappingHelper.getSource((Element) dropObject);
				Collection targets = linkmappingHelper.getTarget((Element) dropObject);
				if (sources.size() == 0 || targets.size() == 0) {
					return UnexecutableCommand.INSTANCE;
				}
				// binary association
				Element source = (Element) sources.toArray()[0];
				Element target = (Element) targets.toArray()[0];
				cc = dropBinaryLink(cc, source, target, linkVISUALID, dropRequest.getLocation(), (Element) dropObject);

			}
		}
		return new ICommandProxy(cc);
	}

	/**
	 * Gets the editing domain.
	 * 
	 * @return the editing domain
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart) getHost()).getEditingDomain();
	}

	/**
	 * for specific case of drop, the designers has to write the algorithm of its own drop. for
	 * example case of associationClass, multi dependency etc....
	 * 
	 * @param dropRequest
	 *            the drop request
	 * @param nodeVISUALID
	 *            the node visualid
	 * @param linkVISUALID
	 *            the link visualid
	 * @param semanticLink
	 *            the semantic link
	 * 
	 * @return the specific drop command
	 */
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID,
			int linkVISUALID) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Gets the viewer.
	 * 
	 * @return the viewer
	 */
	protected EditPartViewer getViewer() {
		return ((IGraphicalEditPart) getHost()).getViewer();
	}

	/**
	 * Inits the.
	 * 
	 * @param arraySpecificDrop
	 *            the array specific drop
	 */
	public void init(int[] arraySpecificDrop) {
		for (int i = 0; i < arraySpecificDrop.length; i++) {
			specificDrop.add(new Integer(arraySpecificDrop[i]));
		}
	}

	/**
	 * Look for editPart from its semantic.
	 * 
	 * @param semantic
	 *            the semantic
	 * 
	 * @return the edits the part or null if not found
	 */
	private EditPart lookForEditPart(EObject semantic) {
		Collection<EditPart> editPartSet = getHost().getViewer().getEditPartRegistry().values();
		Iterator<EditPart> editPartIterator = editPartSet.iterator();
		EditPart existedEditPart = null;
		while (editPartIterator.hasNext() && existedEditPart == null) {

			EditPart currentEditPart = editPartIterator.next();

			if ((!(currentEditPart instanceof DiagramEditPart)) && (!(currentEditPart instanceof CompartmentEditPart))
					&& currentEditPart instanceof GraphicalEditPart
					&& semantic.equals(((GraphicalEditPart) currentEditPart).resolveSemanticElement())) {
				existedEditPart = currentEditPart;
			}
		}
		return existedEditPart;
	}
	
}
