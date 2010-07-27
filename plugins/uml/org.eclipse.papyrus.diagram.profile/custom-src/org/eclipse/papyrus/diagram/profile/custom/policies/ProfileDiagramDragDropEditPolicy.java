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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram 
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.profile.custom.commands.SetStereotypeVisibleOnMetaclassCommand;
import org.eclipse.papyrus.diagram.profile.custom.helper.ClassLinkMappingHelper;
import org.eclipse.papyrus.diagram.profile.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.diagram.profile.custom.helper.MultiDependencyHelper;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ElementImportEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ExtensionEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPartCN;
import org.eclipse.papyrus.diagram.profile.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;

/**
 * The Class ClassDiagramDragDropEditPolicy.
 */
public class ProfileDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/**
	 * Instantiates a new class diagram drag drop edit policy.
	 */
	public ProfileDiagramDragDropEditPolicy() {
		super(ClassLinkMappingHelper.getInstance());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		Set<Integer> droppableElementsVisualID = new HashSet<Integer>();
		droppableElementsVisualID.add(DependencyNodeEditPart.VISUAL_ID);
		droppableElementsVisualID.add(ElementImportEditPart.VISUAL_ID);
		droppableElementsVisualID.add(ExtensionEditPart.VISUAL_ID);
		droppableElementsVisualID.add(AssociationNodeEditPart.VISUAL_ID);

		return droppableElementsVisualID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	/**
	 * this method has in charge to create command for create an association if the number of
	 * endtype is superior of 2 a multi association is dropped. if the number of endtype this is
	 * binary association that is dropped.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visualid
	 * 
	 * @return the command
	 */
	protected Command dropAssociation(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		Collection endtypes = ClassLinkMappingHelper.getInstance().getSource(semanticLink);
		if(endtypes.size() == 2) {
			Element source = (Element)endtypes.toArray()[0];
			Element target = (Element)endtypes.toArray()[1];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, 4001, dropRequest.getLocation(), semanticLink)); //$NON-NLS-1$
		}
		if(endtypes.size() > 2) {
			MultiAssociationHelper associationHelper = new MultiAssociationHelper(getEditingDomain());
			return associationHelper.dropMutliAssociation((Association)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
		}
		return UnexecutableCommand.INSTANCE;

	}

	/**
	 * this method send a Command that create views for associationClass
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visualid
	 * 
	 * @return the command
	 */
	//	protected Command dropAssociationClass(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
	//		AssociationClassHelper associationClassHelper = new AssociationClassHelper(getEditingDomain());
	//		return associationClassHelper.dropAssociationClass((AssociationClass)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
	//	}

	/**
	 * this method send a command to create views to display
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visualid
	 * 
	 * @return the command
	 */
	protected Command dropDependency(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		Collection sources = ClassLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection targets = ClassLinkMappingHelper.getInstance().getTarget(semanticLink);
		if(sources.size() == 1 && targets.size() == 1) {
			Element source = (Element)sources.toArray()[0];
			Element target = (Element)targets.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, 4008, dropRequest.getLocation(), semanticLink)); //$NON-NLS-1$
		}
		if(sources.size() > 1 || targets.size() > 1) {
			MultiDependencyHelper dependencyHelper = new MultiDependencyHelper(getEditingDomain());
			return dependencyHelper.dropMutliDependency((Dependency)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
		}
		return UnexecutableCommand.INSTANCE;
	}

	//	protected Command outlineDropContainedClass(DropObjectsRequest dropRequest, Element semanticObject, int nodeVISUALID) {
	//		ContainmentHelper containmentHelper = new ContainmentHelper(getEditingDomain());
	//		Element owner = (Element)semanticObject.getOwner();
	//		boolean ownerviewexist = false;
	//		Collection<EditPart> editPartSet = getViewer().getEditPartRegistry().values();
	//		Iterator<EditPart> editPartIterator = editPartSet.iterator();
	//		while(editPartIterator.hasNext()) {
	//			EditPart currentEditPart = editPartIterator.next();
	//			if((currentEditPart instanceof ClassEditPart)) {
	//				if(((GraphicalEditPart)currentEditPart).resolveSemanticElement().equals(owner)) {
	//					ownerviewexist = true;
	//				}
	//			}
	//		}
	//
	//		if(ownerviewexist) {
	//			return containmentHelper.outlineDropContainedClass((Class)semanticObject, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
	//		} else {
	//			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), semanticObject));
	//		}
	//
	//	}

	//	protected Command compartmentDropContainedClass(DropObjectsRequest dropRequest, Element semanticObject, int nodeVISUALID) {
	//		ContainmentHelper containmentHelper = new ContainmentHelper(getEditingDomain());
	//		CompositeCommand cc = new CompositeCommand("compartmentDropContainedClass");
	//		Point location = dropRequest.getLocation().getCopy();
	//		((GraphicalEditPart)getHost()).getContentPane().translateToRelative(location);
	//		((GraphicalEditPart)getHost()).getContentPane().translateFromParent(location);
	//		location.translate(((GraphicalEditPart)getHost()).getContentPane().getClientArea().getLocation().getNegated());
	//		cc = getDefaultDropNodeCommand(nodeVISUALID, location, semanticObject);
	//		GraphicalEditPart owner = null;
	//		Collection<EditPart> editPartSet = getViewer().getEditPartRegistry().values();
	//		Iterator<EditPart> editPartIterator = editPartSet.iterator();
	//		while(editPartIterator.hasNext()) {
	//			EditPart currentEditPart = editPartIterator.next();
	//			if(currentEditPart instanceof ClassEditPart) {
	//				if(((GraphicalEditPart)currentEditPart).resolveSemanticElement().equals(semanticObject)) {
	//					View view = (View)currentEditPart.getModel();
	//					EList<ConnectorImpl> listlink = view.getTargetEdges();
	//					Iterator<ConnectorImpl> addedlinkIterator = listlink.iterator();
	//					while(addedlinkIterator.hasNext()) {
	//						ConnectorImpl currentconnector = addedlinkIterator.next();
	//						ShapeImpl containmenetshape = (ShapeImpl)currentconnector.getSource();
	//						if(containmenetshape.getType().equals("3032")) {
	//							/* The containment circle node is deleted only if any other link is connected */
	//							if(containmenetshape.getSourceEdges().size() == 1) {
	//								cc.compose(new DeleteCommand(getEditingDomain(), (View)containmenetshape));
	//
	//							}
	//						}
	//					}
	//					cc.add(new DeleteCommand(getEditingDomain(), (View)((GraphicalEditPart)currentEditPart).getModel()));
	//
	//
	//				}
	//			}
	//		}
	//
	//		return new ICommandProxy(cc);
	//	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		// /!\ Warning the order is important! test on the superclass and AssociationNode is a super class for ExtensionEditPart!
		switch(linkVISUALID) {
		case ElementImportEditPart.VISUAL_ID:
			return dropElementImport(dropRequest, semanticLink, nodeVISUALID);
		case ExtensionEditPart.VISUAL_ID:
			return dropExtension(dropRequest, semanticLink, linkVISUALID);
		default:

		}
		switch(nodeVISUALID) {
		case 2014:
			return dropDependency(dropRequest, semanticLink, nodeVISUALID);
			//		case 2013:
			//			return dropAssociationClass(dropRequest, semanticLink, nodeVISUALID);
		case 2015:
			return dropAssociation(dropRequest, semanticLink, nodeVISUALID);
			//		case 3014:
			//			return compartmentDropContainedClass(dropRequest, semanticLink, nodeVISUALID);
			//		case 2008:
			//			return outlineDropContainedClass(dropRequest, semanticLink, nodeVISUALID);

		default:
			return UnexecutableCommand.INSTANCE;
		}


	}

	/**
	 * 
	 * this method send a command to create views to display to drop an extension link
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param linkVISUALID
	 *        hte link visualid
	 * @return
	 */
	protected Command dropExtension(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sources = ClassLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection<?> targets = ClassLinkMappingHelper.getInstance().getTarget(semanticLink);

		Element source = (Element)sources.toArray()[0];
		Element target = (Element)targets.toArray()[0];

		if(sources.size() != 1 && targets.size() != 1) {
			return UnexecutableCommand.INSTANCE;
		}

		return new ICommandProxy(dropBinaryLinkExtension(new CompositeCommand("drop Extension"), source, target, ExtensionEditPart.VISUAL_ID, dropRequest.getLocation(), semanticLink)); //$NON-NLS-1$
	}



	/**
	 * the drop is possible only if the container of the dropped element is the same that the host!!!
	 * 
	 * @param dropRequest
	 * @param semanticLink
	 * @param linkVISUALID
	 * @return
	 */
	protected Command dropElementImport(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		if(semanticLink instanceof ElementImport) {
			if(((ElementImport)semanticLink).getImportedElement() instanceof Class) {

				Class metaclass = (Class)((ElementImport)semanticLink).getImportedElement();

				/**
				 * get the container for the element
				 */
				EObject container = semanticLink.eContainer();


				/**
				 * get the view of the container
				 */
				List<View> containerView = DiagramEditPartsUtil.getEObjectViews(container);
				/**
				 * get the host's model
				 */

				CompositeCommand cc = new CompositeCommand("Drop"); //$NON-NLS-1$
				IAdaptable elementAdapter = new EObjectAdapter(metaclass);

				ViewDescriptor descriptor;

				//we create the view command
				if(containerView.get(0).equals(getHost().getModel())) {//we are on the diagram
					descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(MetaclassEditPart.VISUAL_ID)).getSemanticHint(), ViewUtil.APPEND, false, getDiagramPreferencesHint());
				} else {
					descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(MetaclassEditPartCN.VISUAL_ID)).getSemanticHint(), ViewUtil.APPEND, false, getDiagramPreferencesHint());
				}

				CreateCommand createCommand = new CreateCommand(getEditingDomain(), descriptor, ((View)(getHost().getModel())));
				cc.compose(createCommand);

				SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)createCommand.getCommandResult().getReturnValue(), dropRequest.getLocation()); //$NON-NLS-1$
				cc.compose(setBoundsCommand);

				/*
				 * we set the stereotype <<metaclass>> visible
				 * we can not call AppliedStereotypeHelper.getAddAppliedStereotypeCommand here,
				 * because createCommand.getResult( ((ViewDescriptor)createCommand.getCommandResult().getReturnValue()).getAdapter(View.class) return
				 * null :
				 * the view is not yet created!!!
				 */
				if(createCommand.canExecute()) {
					SetStereotypeVisibleOnMetaclassCommand stereotypeCommand = new SetStereotypeVisibleOnMetaclassCommand(getEditingDomain(), "Set Stereotype Visible", null, semanticLink, (ViewDescriptor)createCommand.getCommandResult().getReturnValue()); //$NON-NLS-1$
					if(stereotypeCommand.canExecute()) {
						cc.add(stereotypeCommand);
					}
				}
				return new ICommandProxy(cc);
			}
		}

		return UnexecutableCommand.INSTANCE;

	}

	/**
	 * this method is the equivalent to dropBinaryLink, except it uses lookForEditPartMetaclass
	 * 
	 * the method provides command to create the binary link into the diagram. If the source and the
	 * target views do not exist, these views will be created.
	 * 
	 * @param cc
	 *        the composite command that will contain the set of command to create the binary
	 *        link
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
	public CompositeCommand dropBinaryLinkExtension(CompositeCommand cc, Element source, Element target, int linkVISUALID, Point location, Element semanticLink) {
		// look for editpart

		GraphicalEditPart sourceEditPart = (GraphicalEditPart)lookForEditPartSource(source);
		GraphicalEditPart targetEditPart = (GraphicalEditPart)lookForEditPartTarget(target, semanticLink);

		// descriptor of the link
		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(getUMLElementType(linkVISUALID), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), getDiagramPreferencesHint());

		IAdaptable sourceAdapter = null;
		IAdaptable targetAdapter = null;
		EList<Adapter> e = source.eAdapters();

		if(sourceEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(source), Node.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());

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
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(target), Node.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());

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
	 * Look for editPart from its semantic.
	 * 
	 * @param semantic
	 *        the semantic
	 * 
	 * @return the edits the part or null if not found
	 */
	private EditPart lookForEditPartSource(EObject semantic) {
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
	 * Look for editPart from its semantic and its container.
	 * 
	 * @param semantic
	 *        the semantic
	 * 
	 * @return the edits the part or null if not found
	 */
	private EditPart lookForEditPartTarget(EObject semantic, Element semanticLink) {
		Collection<EditPart> editPartSet = getHost().getViewer().getEditPartRegistry().values();
		Collection<EditPart> editPartSet2 = getTheFirstLevel(semanticLink);
		Iterator<EditPart> editPartIterator = editPartSet.iterator();
		EditPart existedEditPart = null;

		while(editPartIterator.hasNext() && existedEditPart == null) {
			EditPart currentEditPart = editPartIterator.next();
			if(editPartSet2.contains(currentEditPart)) {
				if(isEditPartTypeAdapted(currentEditPart.getClass(), semantic.eClass()) && semantic.equals(((GraphicalEditPart)currentEditPart).resolveSemanticElement())) {
					existedEditPart = currentEditPart;
				}
			}
		}
		return existedEditPart;
	}

	/**
	 * Check if the edit part type is the best one to represent an object of the given EClass type
	 * 
	 * @param editPartClass
	 *        the type of EditPart which may represent a semantic element
	 * @param eClass
	 *        the EClass type of the represented semantic element
	 * @return true if an edit part of this type should be selected
	 */
	private boolean isEditPartTypeAdapted(java.lang.Class<? extends EditPart> editPartClass, EClass eClass) {
		if(DiagramEditPart.class.isAssignableFrom(editPartClass) || CompartmentEditPart.class.isAssignableFrom(editPartClass)) {
			// the edit part is disqualified, as a compartment or a diagram can not be dropped
			return false;
		} else if(GraphicalEditPart.class.isAssignableFrom(editPartClass)) {
			// check the edit part type against advised ones
			return isEditPartTypeSuitableForEClass(editPartClass.asSubclass(GraphicalEditPart.class), eClass);
		} else {
			// only a GraphicalEditPart must be selected
			return false;
		}
	}

	private Collection<EditPart> getTheFirstLevel(Element semanticLink) {

		EObject linkContainer = semanticLink.eContainer();
		EditPart currentEditPart = null;
		Collection<EditPart> profileContents = new ArrayList<EditPart>();

		Collection<EditPart> editPartSet = getHost().getViewer().getEditPartRegistry().values();
		Iterator<EditPart> editPartIterator = editPartSet.iterator();
		//Je recherche les éléments qui ont le même parent que mon extension
		while(editPartIterator.hasNext()) {
			currentEditPart = editPartIterator.next();
			if(currentEditPart.getParent() != null) {
				Object model = currentEditPart.getParent().getModel();
				if(model instanceof Node) {
					EObject parent = ((Node)model).getElement();
					if(parent.equals(linkContainer)) {
						profileContents.add(currentEditPart);
					}
				}
				if(model instanceof Diagram) {
					EObject parent = ((Diagram)model).getElement();
					if(parent.equals(linkContainer)) {
						profileContents.add(currentEditPart);
					}
				}
			}



		}

		return profileContents;
	}
}
