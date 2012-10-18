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
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.CommandProxyWithResult;
import org.eclipse.papyrus.uml.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.DeferredCreateCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.uml.diagram.common.listeners.DropTargetListener;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.common.util.ViewServiceUtil;
import org.eclipse.swt.dnd.DND;
import org.eclipse.uml2.uml.Element;

/**
 * This class is used to execute the drag and drop from the outline. It can
 * manage the drop of nodes and binary links.
 */
public abstract class CommonDiagramDragDropEditPolicy extends DiagramDragDropEditPolicy {

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
	public CommonDiagramDragDropEditPolicy(ILinkMappingHelper mappingHelper) {
		linkmappingHelper = mappingHelper;
	}

	/**
	 * Gets elements visual id that can be dropped in the diagram
	 */
	protected Set<Integer> getSpecificDrop() {
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
	public CompositeCommand dropBinaryLink(CompositeCommand cc, Element source, Element target, int linkVISUALID, Point absoluteLocation, Element semanticLink) {
		// look for editpart
		GraphicalEditPart sourceEditPart = (GraphicalEditPart)lookForEditPart(source);
		GraphicalEditPart targetEditPart = (GraphicalEditPart)lookForEditPart(target);

		// descriptor of the link
		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(getUMLElementType(linkVISUALID), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), getDiagramPreferencesHint());

		IAdaptable sourceAdapter = null;
		IAdaptable targetAdapter = null;
		if(sourceEditPart == null) {
			ICommand createCommand = getDefaultDropNodeCommand(getLinkSourceDropLocation(absoluteLocation,source, target), source);
			cc.add(createCommand);

			sourceAdapter = (IAdaptable)createCommand.getCommandResult().getReturnValue();
		} else {
			sourceAdapter = new SemanticAdapter(null, sourceEditPart.getModel());
		}
		if(targetEditPart == null) {
			ICommand createCommand = getDefaultDropNodeCommand(getLinkTargetDropLocation(absoluteLocation,source, target), target);
			cc.add(createCommand);

			targetAdapter = (IAdaptable)createCommand.getCommandResult().getReturnValue();
		} else {
			targetAdapter = new SemanticAdapter(null, targetEditPart.getModel());
		}

		CommonDeferredCreateConnectionViewCommand aLinkCommand = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), sourceAdapter, targetAdapter, getViewer(), getDiagramPreferencesHint(), linkdescriptor, null);
		aLinkCommand.setElement(semanticLink);
		cc.compose(aLinkCommand);
		return cc;

	}

	/**
	 * This method allows to specify a location for the creation of a node at
	 * the source of a dropped link. Overriding implementations must not modify
	 * the absoluteLocation parameter (use {@link Point#getCopy()})
	 * 
	 * @param absoluteLocation the request's drop location
	 * @param source the source of the dropped link
	 * @param target the target of the dropped link
	 * @return the new location for the node
	 */
	protected Point getLinkSourceDropLocation(Point absoluteLocation, Element source, Element target) {
		return absoluteLocation;
	}

	/**
	 * This method allows to specify a location for the creation of a node at
	 * the target of a dropped link. Overriding implementations must not modify
	 * the absoluteLocation parameter (use {@link Point#getCopy()})
	 * 
	 * @param absoluteLocation the request's drop location
	 * @param source the source of the dropped link
	 * @param target the target of the dropped link
	 * @return the new location for the node
	 */
	protected Point getLinkTargetDropLocation(Point absoluteLocation, Element source, Element target) {
		if (lookForEditPart(source) == null && lookForEditPart(target) == null) {
			return absoluteLocation.getTranslated(100, 0);
		}
		return absoluteLocation;
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

		while(iter.hasNext()) {
			EObject droppedObject = (EObject)iter.next();
			cc.add(getDropObjectCommand(dropRequest, droppedObject));
		}

		return new ICommandProxy(cc);
	}

	protected IUndoableOperation getDropObjectCommand(DropObjectsRequest dropRequest, EObject droppedObject) {
		Point location = dropRequest.getLocation().getCopy();

		int nodeVISUALID = getNodeVisualID(((IGraphicalEditPart)getHost()).getNotationView(), droppedObject);
		int linkVISUALID = getLinkWithClassVisualID(droppedObject);
		if(getSpecificDrop().contains(nodeVISUALID) || getSpecificDrop().contains(linkVISUALID)) {
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
			dropBinaryLink(cc, source, target, linkVISUALID, location, (Element)droppedObject);
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

	/**
	 * Get a new Point translated to relative coordinate
	 * 
	 * @param absoluteLocation
	 *        the absolute point
	 * @return the relative point
	 */
	protected Point getTranslatedToRelative(Point absoluteLocation) {
		Point relativeLocation = absoluteLocation.getCopy();
		((GraphicalEditPart)getHost()).getContentPane().translateToRelative(relativeLocation);
		((GraphicalEditPart)getHost()).getContentPane().translateFromParent(relativeLocation);
		relativeLocation.translate(((GraphicalEditPart)getHost()).getContentPane().getClientArea().getLocation().getNegated());
		return relativeLocation;
	}

	/**
	 * This method returns the default drop command for node. It create the view
	 * at the specified location, using the gmf command framework so the
	 * policies are used.
	 * 
	 * @param nodeVISUALID
	 *        the node visual identifier
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @param request
	 * 		  the drop request
	 * @return the creation node command
	 */
	protected ICommand getDefaultDropNodeCommand(int nodeVISUALID, Point absoluteLocation, EObject droppedObject, DropObjectsRequest request) {
		return getDefaultDropNodeCommand(getHost(), nodeVISUALID, absoluteLocation, droppedObject);
	}
	
	/**
	 * This method returns the default drop command for node. It create the view
	 * at the specified location, using the gmf command framework so the
	 * policies are used.
	 * 
	 * @param nodeVISUALID
	 *        the node visual identifier
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @return the creation node command
	 */
	protected ICommand getDefaultDropNodeCommand(int nodeVISUALID, Point absoluteLocation, EObject droppedObject) {
		return getDefaultDropNodeCommand(nodeVISUALID, absoluteLocation, droppedObject, null);
	}

	/**
	 * This method returns the default drop command for node. It create the view
	 * at the specified location, using the gmf command framework so the
	 * policies are used.
	 * 
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @return the creation node command
	 */
	protected ICommand getDefaultDropNodeCommand(Point absoluteLocation, EObject droppedObject) {
		return getDefaultDropNodeCommand(getHost(), null, absoluteLocation, droppedObject);
	}

	/**
	 * This method returns the default drop command for node. It create the view
	 * at the specified location, using the gmf command framework so the
	 * policies are used.
	 * 
	 * @param hostEP
	 *        The host edit part which will be the parent of the new node
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @return the creation node command
	 */
	protected ICommand getDefaultDropNodeCommand(EditPart hostEP, Point absoluteLocation, EObject droppedObject) {
		return getDefaultDropNodeCommand(hostEP, null, absoluteLocation, droppedObject);
	}

	/**
	 * This method returns the default drop command for node. It create the view
	 * at the specified location, using the gmf command framework so the
	 * policies are used.
	 * 
	 * @param hostEP
	 *        The host edit part which will be the parent of the new node
	 * @param nodeVISUALID
	 *        the node visual identifier
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @param request
	 * 		  the drop request
	 * @return the creation node command
	 */
	protected ICommand getDefaultDropNodeCommand(EditPart hostEP, int nodeVISUALID, Point absoluteLocation, EObject droppedObject, DropObjectsRequest request) {
		IHintedType type = ((IHintedType)getUMLElementType(nodeVISUALID));

		String semanticHint = null;
		if(type != null) {
			semanticHint = type.getSemanticHint();
		}

		return getDefaultDropNodeCommand(getHost(), semanticHint, absoluteLocation, droppedObject, request);
	}
	
	/**
	 * This method returns the default drop command for node. It create the view
	 * at the specified location, using the gmf command framework so the
	 * policies are used.
	 * 
	 * @param hostEP
	 *        The host edit part which will be the parent of the new node
	 * @param nodeVISUALID
	 *        the node visual identifier
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @return the creation node command
	 */
	protected ICommand getDefaultDropNodeCommand(EditPart hostEP, int nodeVISUALID, Point absoluteLocation, EObject droppedObject) {
		return getDefaultDropNodeCommand(hostEP, nodeVISUALID, absoluteLocation, droppedObject, null);
	}
	
	/**
	 * This method returns the default drop command for node. It create the view
	 * at the specified location, using the gmf command framework so the
	 * policies are used.
	 * 
	 * @param hostEP
	 *        The host edit part which will be the parent of the new node
	 * @param semanticHint
	 *        the semantic hint of the view to create
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @return the creation node command
	 */
	protected ICommand getDefaultDropNodeCommand(EditPart hostEP, String semanticHint, Point absoluteLocation, EObject droppedObject) {
		return getDefaultDropNodeCommand(hostEP, semanticHint, absoluteLocation, droppedObject, null);
	}

	/**
	 * This method returns the default drop command for node. It create the view
	 * at the specified location, using the gmf command framework so the
	 * policies are used.
	 * If the ctrl key is pressed, do a command to add content of the new node
	 * 
	 * @param hostEP
	 *        The host edit part which will be the parent of the new node
	 * @param semanticHint
	 *        the semantic hint of the view to create
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @param request
	 *        the drop request (use to test ctrl key)
	 * @return the creation node command
	 */
	protected ICommand getDefaultDropNodeCommand(EditPart hostEP, String semanticHint, Point absoluteLocation, EObject droppedObject, DropObjectsRequest request) {
		List<View> existingViews = DiagramEditPartsUtil.findViews(droppedObject, getViewer());

		// only allow one view instance of a single element by diagram
		if(existingViews.isEmpty()) {
			IAdaptable elementAdapter = new EObjectAdapter(droppedObject);

			ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, semanticHint, ViewUtil.APPEND, true, getDiagramPreferencesHint());
			CreateViewRequest createViewRequest = new CreateViewRequest(descriptor);
			createViewRequest.setLocation(absoluteLocation);

			// "ask" the host for a command associated with the
			// CreateViewRequest
			Command command = hostEP.getCommand(createViewRequest);
			if(isCopy(request) && createViewRequest.getNewObject() instanceof List) {
				for(Object object : (List<?>)createViewRequest.getNewObject()) {
					if(object instanceof IAdaptable) {
						DeferredCreateCommand createCommand2 = new DeferredCreateCommand(getEditingDomain(), droppedObject, (IAdaptable)object, getHost().getViewer());
						command.chain(new ICommandProxy(createCommand2));
					}
				}
			}
			// set the viewdescriptor as result
			// it then can be used as an adaptable to retrieve the View
			return new CommandProxyWithResult(command, descriptor);
		}

		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
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
}
