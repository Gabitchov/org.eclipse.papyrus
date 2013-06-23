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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - add the line 	ViewServiceUtil.forceLoad();
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.DeferredCreateCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.listeners.DropTargetListener;
import org.eclipse.papyrus.uml.diagram.common.util.ViewServiceUtil;
import org.eclipse.swt.dnd.DND;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;

/**
 * @deprecated This class is used to execute the drag and drop from the outline.
 *             It can manage the drop of nodes and binary links.
 */
public abstract class OldCommonDiagramDragDropEditPolicy extends DiagramDragDropEditPolicy {

	/** The specific drop. */
	private Set<Integer> specificDrop = null;

	/** The specified link mapping helper depending on the diagram */
	protected ILinkMappingHelper linkmappingHelper;

	/**
	 * Instantiates a new custom diagram drag drop edit policy.
	 * 
	 * @param mappingHelper
	 *        the mapping helper
	 */
	public OldCommonDiagramDragDropEditPolicy(ILinkMappingHelper mappingHelper) {
		linkmappingHelper = mappingHelper;
	}

	/**
	 * Gets elements visual id that can be dropped in the diagram
	 */
	private Set<Integer> getSpecificDrop() {
		if(specificDrop == null) {
			specificDrop = getDroppableElementVisualId();
		}
		return specificDrop;
	}

	/**
	 * Gets the UML element type for the specified
	 * 
	 * @param elementID
	 *        the element id
	 * 
	 * @return the uML element type
	 */
	public abstract IElementType getUMLElementType(int elementID);

	public abstract int getNodeVisualID(View containerView, EObject domainElement);

	public abstract int getLinkWithClassVisualID(EObject domainElement);

	/**
	 * The list of visualID that the policy manages.
	 */
	protected abstract Set<Integer> getDroppableElementVisualId();

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected Command createViewsAndArrangeCommand(DropObjectsRequest dropRequest, List viewDescriptors) {
		CreateViewRequest createViewRequest = new CreateViewRequest(viewDescriptors);
		createViewRequest.setLocation(dropRequest.getLocation());
		Command createCommand = getHost().getCommand(createViewRequest);
		return createCommand;
	}

	/**
	 * the method provides command to create the binary link into the diagram.
	 * If the source and the target views do not exist, these views will be
	 * created.
	 * 
	 * @param cc
	 *        the composite command that will contain the set of command to
	 *        create the binary link
	 * @param source
	 *        the source the element source of the link
	 * @param target
	 *        the target the element target of the link
	 * @param linkVISUALID
	 *        the link VISUALID used to create the view
	 * @param location
	 *        the location the location where the view will be be created
	 * @param semanticLink
	 *        the semantic link that will be attached to the view
	 * 
	 * @return the composite command
	 */
	public CompositeCommand dropBinaryLink(CompositeCommand cc, Element source, Element target, int linkVISUALID, Point location, Element semanticLink) {
		// look for editpart
		GraphicalEditPart sourceEditPart = (GraphicalEditPart)lookForEditPart(source);
		GraphicalEditPart targetEditPart = (GraphicalEditPart)lookForEditPart(target);

		// descriptor of the link
		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(getUMLElementType(linkVISUALID), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), getDiagramPreferencesHint());

		IAdaptable sourceAdapter = null;
		IAdaptable targetAdapter = null;
		if(sourceEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(source), Node.class, null, ViewUtil.APPEND, true, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart)getHost()).getEditingDomain(), descriptor, ((View)getHost().getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y + 100)); //$NON-NLS-1$
			cc.compose(setBoundsCommand);

			sourceAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();
		} else {
			sourceAdapter = new SemanticAdapter(null, sourceEditPart.getModel());
		}
		if(targetEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(target), Node.class, null, ViewUtil.APPEND, true, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart)getHost()).getEditingDomain(), descriptor, ((View)getHost().getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y - 100)); //$NON-NLS-1$
			cc.compose(setBoundsCommand);
			targetAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();

		} else {
			targetAdapter = new SemanticAdapter(null, targetEditPart.getModel());
		}

		CommonDeferredCreateConnectionViewCommand aLinkCommand = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), sourceAdapter, targetAdapter, getViewer(), getDiagramPreferencesHint(), linkdescriptor, null);
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
		return ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint();
	}

	/**
	 * {@inheritedDoc}.
	 */
	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		/*
		 * when it's the first action after the opening of Papyrus, the
		 * viewService is not loaded! see bug 302555
		 * 
		 * Duration test for 100000 creations of DropCommand : Here 2 solutions
		 * : - call ViewServiceUtil.forceLoad(); for each drop -> ~2500ms
		 * 
		 * - test if the command cc can be executed at the end of the method,
		 * and if not : - call ViewServiceUtil.forceLoad(); - and return
		 * getDropObjectsCommand(getDropObjectsCommand) -> ~4700ms
		 * 
		 * - for information : without call ViewServiceUtil.forceLoad(); ->
		 * ~1600ms
		 * 
		 * It's better don't test if the command is executable!
		 */
		ViewServiceUtil.forceLoad();

		if(dropRequest.getObjects().size() > 0 && dropRequest.getObjects().get(0) instanceof String) {
			return getDropFileCommand(dropRequest);
		}

		// Create a view request from the drop request and then forward getting
		// the command for that.
		CompositeCommand cc = new CompositeCommand("Drop"); //$NON-NLS-1$
		Iterator<?> iter = dropRequest.getObjects().iterator();
		Point location = getTranslatedLocation(dropRequest);

		while(iter.hasNext()) {
			EObject droppedObject = (EObject)iter.next();
			cc.add(getDropObjectCommand(dropRequest, droppedObject, location));
		}

		return new ICommandProxy(cc);
	}

	/**
	 * Check if the ctrl key event is activate
	 * 
	 * @param dropRequest
	 *        the request which contain the event
	 * @return true if ctrl key is activate, else return false
	 */
	public boolean isCopy(DropObjectsRequest dropRequest) {
		if(dropRequest != null && dropRequest.getExtendedData() != null && dropRequest.getExtendedData().get(DropTargetListener.EVENT_DETAIL) instanceof Integer) {
			int eventDetail = (Integer)dropRequest.getExtendedData().get(DropTargetListener.EVENT_DETAIL);
			if(((eventDetail & DND.DROP_COPY) != 0)) {
				return true;
			}
		}
		return false;
	}

	protected IUndoableOperation getDropObjectCommand(DropObjectsRequest dropRequest, EObject droppedObject, Point location) {
		int nodeVISUALID = getNodeVisualID(((IGraphicalEditPart)getHost()).getNotationView(), droppedObject);
		int linkVISUALID = getLinkWithClassVisualID(droppedObject);
		if(getSpecificDrop().contains(nodeVISUALID) || getSpecificDrop().contains(linkVISUALID)) {
			dropRequest.setLocation(location);
			Command specificDropCommand = getSpecificDropCommand(dropRequest, (Element)droppedObject, nodeVISUALID, linkVISUALID);
			CompositeCommand cc = new CompositeCommand("Drop command");
			cc.compose(new CommandProxy(specificDropCommand));
			// If ctrl key activate, get the content of element dropped
			if(isCopy(dropRequest)) {
				// Check for ICommandProxy and CompoundCommand the most command type used
				if(specificDropCommand instanceof ICommandProxy) {
					ICommandProxy specificDropCommandProxy = (ICommandProxy)specificDropCommand;
					createDeferredCommandWithCommandResult(droppedObject, cc, specificDropCommandProxy);
				} else if(specificDropCommand instanceof CompoundCommand) {
					CompoundCommand specificDropCompoundCommand = (CompoundCommand)specificDropCommand;
					ICommandProxy cp = getCommandProxyFromCompoundCommand(specificDropCompoundCommand);
					if(cp != null) {
						createDeferredCommandWithCommandResult(droppedObject, cc, cp);
					}
				}
			}
			return cc;
		}

		if(linkVISUALID == -1 && nodeVISUALID != -1) {
			// The element to drop is a node
			// Retrieve it's expected graphical parent
			EObject graphicalParent = ((GraphicalEditPart)getHost()).resolveSemanticElement();

			// Restrict the default node creation to the following cases:
			// . Take the containment relationship into consideration
			// . Release the constraint when GraphicalParent is a diagram
			if(getHost().getModel() instanceof Diagram) {
				return getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject, dropRequest);

			} else if((graphicalParent instanceof Element) && ((Element)graphicalParent).getOwnedElements().contains(droppedObject)) {
				return getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject, dropRequest);

			}
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;

		}
		if(linkVISUALID != -1) {
			Collection<?> sources = linkmappingHelper.getSource((Element)droppedObject);
			Collection<?> targets = linkmappingHelper.getTarget((Element)droppedObject);
			if(sources.size() == 0 || targets.size() == 0) {
				return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
			}
			// binary association
			Element source = (Element)sources.toArray()[0];
			Element target = (Element)targets.toArray()[0];
			CompositeCommand cc = new CompositeCommand("Add Link"); //$NON-NLS-1$
			dropBinaryLink(cc, source, target, linkVISUALID, dropRequest.getLocation(), (Element)droppedObject);
			return cc;
		}
		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
	}

	/**
	 * Get a command proxy from the compound command
	 * 
	 * @param cc
	 *        the compound command
	 * @return the command proxy found or null
	 */
	protected ICommandProxy getCommandProxyFromCompoundCommand(CompoundCommand cc) {
		if(cc != null && cc.getCommands() != null) {
			for(Object command : cc.getCommands()) {
				if(command instanceof ICommandProxy) {
					return (ICommandProxy)command;
				} else if(command instanceof CompoundCommand) {
					getCommandProxyFromCompoundCommand((CompoundCommand)command);
				}
			}
		}
		return null;
	}

	/**
	 * Create deferred command for a command proxy
	 * 
	 * @param droppedObject
	 *        the dropped object
	 * @param cc
	 *        the composite command to add the deferred command
	 * @param specificDropCommandProxy
	 *        the specific drop command to get the result
	 */
	protected void createDeferredCommandWithCommandResult(EObject droppedObject, CompositeCommand cc, ICommandProxy specificDropCommandProxy) {
		if(specificDropCommandProxy != null && specificDropCommandProxy.getICommand() != null && specificDropCommandProxy.getICommand().getCommandResult() != null && specificDropCommandProxy.getICommand().getCommandResult().getReturnValue() != null) {
			Object object = specificDropCommandProxy.getICommand().getCommandResult().getReturnValue();
			if(object instanceof Collection<?>) {
				for(Object o : (Collection<?>)object) {
					if(o instanceof CreateViewRequest.ViewDescriptor) {
						CreateViewRequest.ViewDescriptor viewDescritor = (CreateViewRequest.ViewDescriptor)o;
						DeferredCreateCommand createCommand2 = new DeferredCreateCommand(getEditingDomain(), droppedObject, (IAdaptable)viewDescritor, getHost().getViewer());
						cc.compose(createCommand2);
					}
				}
			}
		}
	}

	protected Point getTranslatedLocation(DropObjectsRequest dropRequest) {
		Point location = dropRequest.getLocation().getCopy();
		((GraphicalEditPart)getHost()).getContentPane().translateToRelative(location);
		((GraphicalEditPart)getHost()).getContentPane().translateFromParent(location);
		location.translate(((GraphicalEditPart)getHost()).getContentPane().getClientArea().getLocation().getNegated());
		return location;
	}

	/**
	 * This method returns the default drop command for node. Default here means
	 * the no consideration is made regarding the semantic elements, the
	 * expected figure is basically created where expected.
	 * 
	 * @param nodeVISUALID
	 *        the node visual identifier
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @return a CompositeCommand for Drop
	 */
	protected CompositeCommand getDefaultDropNodeCommand(int nodeVISUALID, Point location, EObject droppedObject) {
		return getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject, null);
	}

	/**
	 * This method returns the default drop command for node. Default here means
	 * the no consideration is made regarding the semantic elements, the
	 * expected figure is basically created where expected.
	 * 
	 * @param nodeVISUALID
	 *        the node visual identifier
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @return a CompositeCommand for Drop
	 */
	protected CompositeCommand getDefaultDropNodeCommand(int nodeVISUALID, Point location, EObject droppedObject, DropObjectsRequest request) {
		CompositeCommand cc = new CompositeCommand("Drop"); //$NON-NLS-1$
		IAdaptable elementAdapter = new EObjectAdapter(droppedObject);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, true, getDiagramPreferencesHint());
		CreateCommand createCommand = new CreateCommand(getEditingDomain(), descriptor, ((View)(getHost().getModel())));
		cc.compose(createCommand);

		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)createCommand.getCommandResult().getReturnValue(), location); //$NON-NLS-1$
		cc.compose(setBoundsCommand);
		// If specific drop, the deferred command is already done in the getDropObjectCommand method
		// Only if CTRL key is active
		if(!getSpecificDrop().contains(nodeVISUALID) && isCopy(request)) {
			DeferredCreateCommand createCommand2 = new DeferredCreateCommand(getEditingDomain(), droppedObject, (IAdaptable)createCommand.getCommandResult().getReturnValue(), getHost().getViewer());
			cc.compose(createCommand2);
		}
		return cc;
	}

	/**
	 * Gets the editing domain.
	 * 
	 * @return the editing domain
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

	/**
	 * for specific case of drop, the designers has to write the algorithm of
	 * its own drop. for example case of associationClass, multi dependency
	 * etc....
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param nodeVISUALID
	 *        the node visualid
	 * @param linkVISUALID
	 *        the link visualid
	 * @param semanticLink
	 *        the semantic link
	 * 
	 * @return the specific drop command
	 */
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Gets the viewer.
	 * 
	 * @return the viewer
	 */
	protected EditPartViewer getViewer() {
		return ((IGraphicalEditPart)getHost()).getViewer();
	}

	/**
	 * Look for editPart from its semantic.
	 * 
	 * @param semantic
	 *        the semantic
	 * 
	 * @return the edits the part or null if not found
	 */
	protected EditPart lookForEditPart(EObject semantic) {
		Collection<EditPart> editPartSet = getHost().getViewer().getEditPartRegistry().values();
		Iterator<EditPart> editPartIterator = editPartSet.iterator();
		EditPart existedEditPart = null;
		while(editPartIterator.hasNext() && existedEditPart == null) {
			EditPart currentEditPart = editPartIterator.next();

			if(isEditPartTypeAdapted(currentEditPart.getClass(), semantic.eClass()) && semantic.equals(((GraphicalEditPart)currentEditPart).resolveSemanticElement())) {
				existedEditPart = currentEditPart;
			}
		}
		return existedEditPart;
	}

	/**
	 * Check if the edit part type is the best one to represent an object of the
	 * given EClass type
	 * 
	 * @param editPartClass
	 *        the type of EditPart which may represent a semantic element
	 * @param eClass
	 *        the EClass type of the represented semantic element
	 * @return true if an edit part of this type should be selected
	 */
	private boolean isEditPartTypeAdapted(Class<? extends EditPart> editPartClass, EClass eClass) {
		if(DiagramEditPart.class.isAssignableFrom(editPartClass) || CompartmentEditPart.class.isAssignableFrom(editPartClass)) {
			// the edit part is disqualified, as a compartment or a diagram can
			// not be dropped
			return false;
		} else if(GraphicalEditPart.class.isAssignableFrom(editPartClass)) {
			// check the edit part type against advised ones
			return isEditPartTypeSuitableForEClass(editPartClass.asSubclass(GraphicalEditPart.class), eClass);
		} else {
			// only a GraphicalEditPart must be selected
			return false;
		}
	}

	/**
	 * Check if an edit part type correctly represent a semantic element of the
	 * given EClass. Subclasses should implement this method to restrict the
	 * possibilities during drop of a link. If an edit part is not of a suitable
	 * type, returning false will eliminate it to represent the element as a
	 * source or target edit part. This can be used for example to disable label
	 * edit parts, which may represent the same model element as the main node.
	 * 
	 * @param editPartClass
	 *        the type of EditPart which must be checked
	 * @param eClass
	 *        the EClass type of the element which the edit part must
	 *        represent
	 * @return the only edit part type which can be selected (return a common
	 *         super type if several edit parts can be chosen)
	 */
	protected boolean isEditPartTypeSuitableForEClass(Class<? extends GraphicalEditPart> editPartClass, EClass eClass) {
		return true;
	}

	/**
	 * Returns The command to drop the {@link Constraint} and the links, if the
	 * constraints elements are on the diagram
	 * 
	 * @param comment
	 *        the comment to drop
	 * @param viewer
	 *        the viewer
	 * @param diagramPreferencesHint
	 *        the diagram preference hint
	 * @param location
	 *        the location for the drop
	 * @param containerView
	 *        the container view for the drop
	 * @param commentType
	 *        the IHintedType for the {@link Comment}
	 * @param linkForComment
	 *        the IHintedType for the link which attach the {@link Comment} to the annotated Element
	 * @return The command to drop the {@link Constraint} and the links, if the
	 *         constraints elements are on the diagram
	 */
	protected Command getDropConstraintCommand(Constraint constraint, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, View containerView, IHintedType commentType, IHintedType linkForComment) {
		/* for further information, see bug 302555 */
		CompositeCommand cc = new CompositeCommand("dropConstraint");
		int nbAnnotated = constraint.getConstrainedElements().size();

		// 0. Obtain list of the annotatedElement
		ArrayList<Element> endToConnect = new ArrayList<Element>(constraint.getConstrainedElements());
		GraphicalEditPart[] endEditPart = new GraphicalEditPart[nbAnnotated];

		// 1. Look for if each annotated element is on the diagram
		Iterator<Element> iteratorProp = endToConnect.iterator();
		int index = 0;
		while(iteratorProp.hasNext()) {
			Element currentAnnotatedElement = iteratorProp.next();
			endEditPart[index] = (GraphicalEditPart)lookForEditPart(currentAnnotatedElement);
			index += 1;
		}

		// 2. creation of the node Comment
		IAdaptable elementAdapter = new EObjectAdapter(constraint);
		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, commentType.getSemanticHint(), ViewUtil.APPEND, true, diagramPreferencesHint);
		CreateCommand nodeCreationCommand = new CreateCommand(getEditingDomain(), descriptor, (containerView));
		cc.compose(nodeCreationCommand);

		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), location);
		cc.compose(setBoundsCommand);

		if(nbAnnotated != 0) {
			IAdaptable sourceEventAdapter = null;
			IAdaptable targetEventAdapter = null;

			// obtain the node figure
			sourceEventAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();

			// used in the creation command of each event
			ConnectionViewDescriptor dashedLineViewDescriptor = new ConnectionViewDescriptor(linkForComment, linkForComment.getSemanticHint(), diagramPreferencesHint);

			// 3. creation of the dashed line between the Comment and the
			// annotated element
			for(GraphicalEditPart current : endEditPart) {
				if(current != null) {
					targetEventAdapter = new SemanticAdapter(null, current.getModel());
					CommonDeferredCreateConnectionViewCommand dashedLineCmd = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), linkForComment.getSemanticHint(), (sourceEventAdapter), (targetEventAdapter), viewer, diagramPreferencesHint, dashedLineViewDescriptor, null);
					// dashedLineCmd.setElement(constraint);
					dashedLineCmd.setElement(null);
					if(dashedLineCmd.canExecute()) {
						cc.compose(dashedLineCmd);
					}
				}
			}

		}
		return new ICommandProxy(cc);
	}

	/**
	 * Returns The command to drop the {@link Comment} and the links, if the
	 * attached elements are on the diagram
	 * 
	 * @param comment
	 *        the comment to drop
	 * @param viewer
	 *        the viewer
	 * @param diagramPreferencesHint
	 *        the diagram preference hint
	 * @param location
	 *        the location for the drop
	 * @param containerView
	 *        the container view for the drop
	 * @param commentType
	 *        the IHintedType for the {@link Comment}
	 * @param linkForComment
	 *        the IHintedType for the link which attach the {@link Comment} to the annotated Element
	 * @return The command to drop the {@link Comment} and the link, if the
	 *         attached elements are on the diagram
	 */
	protected Command getDropCommentCommand(Comment comment, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, View containerView, IHintedType commentType, IHintedType linkForComment) {
		/* for further information, see bug 302555 */
		ViewServiceUtil.forceLoad();
		CompositeCommand cc = new CompositeCommand("dropComment");
		int nbAnnotated = comment.getAnnotatedElements().size();

		// 0. Obtain list of the annotatedElement
		ArrayList<Element> endToConnect = new ArrayList<Element>(comment.getAnnotatedElements());
		GraphicalEditPart[] endEditPart = new GraphicalEditPart[nbAnnotated];

		// 1. Look for if each annotated element is on the diagram
		Iterator<Element> iteratorProp = endToConnect.iterator();
		int index = 0;
		while(iteratorProp.hasNext()) {
			Element currentAnnotatedElement = iteratorProp.next();
			endEditPart[index] = (GraphicalEditPart)lookForEditPart(currentAnnotatedElement);
			index += 1;
		}

		// 2. creation of the node Comment
		IAdaptable elementAdapter = new EObjectAdapter(comment);
		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, commentType.getSemanticHint(), ViewUtil.APPEND, true, diagramPreferencesHint);
		CreateCommand nodeCreationCommand = new CreateCommand(getEditingDomain(), descriptor, (containerView));
		cc.compose(nodeCreationCommand);

		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), location);
		cc.compose(setBoundsCommand);
		// obtain the node figure
		IAdaptable sourceEventAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();
		IAdaptable targetEventAdapter = null;
		if(nbAnnotated != 0) {

			// used in the creation command of each event
			ConnectionViewDescriptor dashedLineViewDescriptor = new ConnectionViewDescriptor(linkForComment, linkForComment.getSemanticHint(), diagramPreferencesHint);

			// 3. creation of the dashed line between the Constraint and the
			// constrained element
			for(GraphicalEditPart current : endEditPart) {
				if(current != null) {
					targetEventAdapter = new SemanticAdapter(null, current.getModel());
					CommonDeferredCreateConnectionViewCommand dashedLineCmd = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), linkForComment.getSemanticHint(), (sourceEventAdapter), (targetEventAdapter), viewer, diagramPreferencesHint, dashedLineViewDescriptor, null);
					// dashedLineCmd.setElement(comment);
					dashedLineCmd.setElement(null);
					if(dashedLineCmd.canExecute()) {
						cc.compose(dashedLineCmd);
					}
				}
			}

		}
		return new ICommandProxy(cc);
	}

}
