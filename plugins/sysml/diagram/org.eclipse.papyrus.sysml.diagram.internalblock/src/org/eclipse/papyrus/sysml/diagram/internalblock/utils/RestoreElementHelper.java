/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *	 Arthur Daussy - arthur.daussy@atos.net - Bug 374809 - [SysML Internal Block Diagram] Provide "refresh block" - "restore connection" feature to ease IBD creation from existing model
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.provider.IGraphicalTypeRegistry;
import org.eclipse.papyrus.infra.core.utils.PapyrusEcoreUtils;
import org.eclipse.papyrus.sysml.diagram.common.util.SysMLLinkDescriptor;
import org.eclipse.papyrus.sysml.diagram.common.util.SysMLNodeDescriptor;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.Activator;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.CustomGraphicalTypeRegistry;
import org.eclipse.papyrus.uml.diagram.common.requests.ArrangeAffixedNodeRequest;
import org.eclipse.papyrus.uml.diagram.common.util.CommandUtil;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.common.util.functions.EObjectToViewFunction;
import org.eclipse.papyrus.uml.diagram.common.util.functions.SettingToEObjectFunction;
import org.eclipse.papyrus.uml.diagram.common.util.predicates.ReferencingViewPredicate;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Helper to restore element (Restore element action)
 * 
 * @author adaussy
 * 
 */
public class RestoreElementHelper {

	/**
	 * Internal block diagram graphical type registry
	 */
	private static CustomGraphicalTypeRegistry registry = new CustomGraphicalTypeRegistry();

	/**
	 * @return Internal block diagram graphical type registry
	 */
	protected static CustomGraphicalTypeRegistry getRegistry() {
		return registry;
	}

	/**
	 * Retrieve of related link to this elements
	 * Warning : for now this method only handle {@link ConnectableElement}
	 * 
	 * @param input
	 *        View on which you want to restore semantic element
	 * @param diagramEditPart
	 *        The {@link DiagramEditPart} of the diagram containg the view
	 * @return List<SysMLLinkDescriptor>
	 */
	protected static List<SysMLLinkDescriptor> getRelatedLinks(View input, DiagramEditPart diagramEditPart) {
		if(getRegistry().isKnownNodeType(input.getType())) {
			List<SysMLLinkDescriptor> result = Lists.newArrayList();
			EObject element = input.getElement();
			if(element instanceof Element) {
				getConnectableElementRelatedLinks(input, diagramEditPart, result, (Element)element);
			}
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * @param input
	 *        View on which you want to restore semantic element
	 * @param diagramEditPart
	 *        The {@link DiagramEditPart} of the diagram containing the view
	 * @param result
	 *        List of which you add descriptor
	 * @param element
	 *        Semantic element
	 */
	private static void getConnectableElementRelatedLinks(View input, DiagramEditPart diagramEditPart, List<SysMLLinkDescriptor> result, Element element) {
		List<? extends Element> connectableElements = null;
		if(element instanceof ConnectableElement) {
			connectableElements = Collections.singletonList(element);
		} else if(element instanceof Class) {
			Class clazz = (Class)element;
			connectableElements = Lists.newArrayList(Iterables.filter(clazz.getAllAttributes(), Predicates.instanceOf(ConnectableElement.class)));
		}
		for(EObject connectableElement : connectableElements) {
			Collection<Setting> reference = PapyrusEcoreUtils.getUsages(connectableElement);
			Iterable<Setting> connectorEndSetting = Iterables.filter(reference, new Predicate<Setting>() {

				public boolean apply(Setting input) {
					if(input.getEObject() instanceof ConnectorEnd) {
						return true;
					}
					return false;
				}
			});
			Iterable<Connector> connectors = Iterables.transform(connectorEndSetting, new Function<Setting, Connector>() {

				public Connector apply(Setting from) {
					EObject eObject = from.getEObject();
					if(eObject instanceof ConnectorEnd) {
						Element owner = ((ConnectorEnd)eObject).getOwner();
						if(owner instanceof Connector) {
							return (Connector)owner;
						}
					}
					return null;
				}
			});
			for(Connector connector : Sets.newHashSet(connectors)) {
				EList<ConnectorEnd> ends = connector.getEnds();
				if(ends.size() == 2) {
					Object conenctorView = getFirstReferencingViewInPartent(connector, getHostDiagram(diagramEditPart));
					if(conenctorView == null) {
						/*
						 * Get view for source
						 * IF none create it
						 */
						ConnectorEnd source = ends.get(0);
						View sourceView = getEndView(source, input.getDiagram());
						if(sourceView == null) {
							createConnectorTargetViews(source, diagramEditPart);
							sourceView = getEndView(source, input.getDiagram());
						}
						/*
						 * Get view for target
						 * IF none create it
						 */
						ConnectorEnd target = ends.get(1);
						View targetView = getEndView(target, input.getDiagram());
						if(targetView == null) {
							createConnectorTargetViews(target, diagramEditPart);
							targetView = getEndView(target, input.getDiagram());
						}
						if(sourceView != null && targetView != null) {
							result.add(new SysMLLinkDescriptor(sourceView, targetView, UMLElementTypes.CONNECTOR, UMLGraphicalTypes.LINK_UML_CONNECTOR_ID, connector));
						}
					}
				}
			}
		}
	}

	/**
	 * Get the correct end view for a specific {@link ConnectorEnd}
	 * 
	 * @param connectorEnd
	 * @param containingDiagram
	 *        Containing diagram
	 * @return
	 */
	protected static View getEndView(ConnectorEnd connectorEnd, Diagram containingDiagram) {
		Property property = connectorEnd.getPartWithPort();
		View ownerView = containingDiagram;
		if(property != null) {
			ownerView = getFirstReferencingViewInPartent(property, containingDiagram);
		}
		ConnectableElement role = connectorEnd.getRole();
		if(ownerView != null && role != null) {
			return getFirstReferencingViewInPartent(role, ownerView);
		}
		return null;
	}

	/**
	 * get the {@link Diagram} element from its edit part
	 * 
	 * @param hostDiagram
	 * @return
	 */
	protected static Diagram getHostDiagram(DiagramEditPart hostDiagram) {
		if(hostDiagram != null) {
			View notationView = hostDiagram.getNotationView();
			if(notationView instanceof Diagram) {
				return (Diagram)notationView;
			}
		}
		return null;
	}

	/**
	 * Create the connector target view
	 * 
	 * @param source
	 *        {@link ConnectorEnd} source
	 * @param diagramEditPart
	 *        {@link DiagramEditPart} containing the view
	 */
	protected static void createConnectorTargetViews(ConnectorEnd source, DiagramEditPart diagramEditPart) {
		Property partWithPort = source.getPartWithPort();
		/*
		 * If partWithPort then create if none nothing to do
		 */
		if(partWithPort != null) {
			View ownerView = getFirstReferencingViewInPartent(partWithPort, getHostDiagram(diagramEditPart));
			if(ownerView != null) {
				IGraphicalEditPart targetEditPart = getEditPart(ownerView, diagramEditPart.getViewer().getEditPartRegistry());
				if(targetEditPart != null) {
					List<SysMLNodeDescriptor> portToAdd = getRelatedPortsToRestore(ownerView);
					List<SysMLNodeDescriptor> filteredPortToAdd = filterPortWithExistingElement(ownerView, portToAdd);
					createRelatedChildNode(targetEditPart, filteredPortToAdd, diagramEditPart);
				}
				diagramEditPart.refresh();
				Command arrangeCommand = targetEditPart.getCommand(new ArrangeAffixedNodeRequest());
				if(arrangeCommand != null && arrangeCommand.canExecute()) {
					CommandUtil.executeCommand(arrangeCommand, targetEditPart);
					targetEditPart.addNotify();
				}
			}
		}
	}

	/**
	 * Return the descriptor of all related port to restore
	 * 
	 * @param containerView
	 *        The container view you want to restore port on
	 * @return List<SysMLNodeDescriptor> of all elements t restore
	 */
	public static List<SysMLNodeDescriptor> getRelatedPortsToRestore(View containerView) {
		if(getRegistry().isKnownNodeType(containerView.getType())) {
			List<SysMLNodeDescriptor> result = Lists.newArrayList();
			EObject element = containerView.getElement();
			if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID.equals(containerView.getType())) {
				result.addAll(getPortForBlockPropertyAsComposite(containerView, element));
			} else if(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID.equals(containerView.getType())) {
				result.addAll(getPortForBlockPropertyAsComposite(containerView, element));
			}
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Get the the list of all port to restore for a BlockProperty
	 * 
	 * @param v
	 * @param element
	 * @return
	 */
	private static List<SysMLNodeDescriptor> getPortForBlockPropertyAsComposite(View v, EObject element) {
		List<SysMLNodeDescriptor> result = null;
		if(element instanceof Property || element instanceof Classifier) {
			result = getPropertyRelatedPort(element);
		}
		return result;
	}

	/**
	 * Get the the list of all port to restore for a Property
	 * 
	 * @param element
	 * @return
	 */
	private static List<SysMLNodeDescriptor> getPropertyRelatedPort(EObject element) {
		Type type = null;
		if(element instanceof Property) {
			Property property = (Property)element;
			type = property.getType();
		} else if(element instanceof Classifier) {
			type = (Classifier)element;
		}
		if(type == null) {
			return Collections.emptyList();
		}
		List<SysMLNodeDescriptor> result = Lists.newArrayList();
		/*
		 * Add owned port
		 */
		if(type instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class clazz = (org.eclipse.uml2.uml.Class)type;
			EList<Property> attributes = clazz.getOwnedAttributes();
			for(Property p : attributes) {
				if(p instanceof Port) {
					String childType = getRegistry().getNodeGraphicalType(p, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID);
					if(!IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(childType)) {
						SysMLNodeDescriptor descriptor = new SysMLNodeDescriptor(p, childType);
						result.add(descriptor);
					}
				}
			}
		}
		/*
		 * Add inherited port
		 */
		if(type instanceof Classifier) {
			Classifier classifier = (Classifier)type;
			EList<NamedElement> inheritedMembers = classifier.getInheritedMembers();
			for(NamedElement namedElem : inheritedMembers) {
				if(namedElem instanceof Port) {
					String childType = getRegistry().getNodeGraphicalType(namedElem, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID);
					if(!IGraphicalTypeRegistry.UNDEFINED_TYPE.equals(childType)) {
						SysMLNodeDescriptor descriptor = new SysMLNodeDescriptor(namedElem, childType);
						result.add(descriptor);
					}
				}
			}
		}
		return result;
	}

	/**
	 * Get the first referencing view of the element
	 * 
	 * @param element
	 * @return
	 */
	public static Iterable<View> getReferencingView(EObject element) {
		Resource eResource = element.eResource();
		if(eResource != null) {
			ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(eResource.getResourceSet());
			if(adapter == null) {
				adapter = new ECrossReferenceAdapter();
			}
			Collection<Setting> inverseReferences = adapter.getInverseReferences(element);
			Iterable<EObject> settings = Iterables.transform(inverseReferences, new SettingToEObjectFunction());
			Iterable<EObject> eObjects = Iterables.filter(settings, new ReferencingViewPredicate(element));
			Iterable<View> views = Iterables.transform(eObjects, new EObjectToViewFunction());
			return views;
		}
		return null;
	}

	/**
	 * Get the first referencing view of the element which match the criteria passed in arguments
	 * 
	 * @param element
	 * @param criterias
	 * @return
	 */
	public static Iterable<View> getFirstReferencingViewWithCriteria(EObject element, Predicate<View>... criterias) {
		Predicate<View> globalPredicate = null;
		for(Predicate<View> pre : criterias) {
			if(globalPredicate == null) {
				globalPredicate = pre;
			} else {
				globalPredicate = Predicates.and(globalPredicate, pre);
			}
		}
		Iterable<View> initialItererable = getReferencingView(element);
		return Iterables.filter(initialItererable, globalPredicate);
	}

	/**
	 * Get the first referencing view of the element contained in the view parent passed in argument
	 * 
	 * @param element
	 * @param criterias
	 * @return
	 */
	public static View getFirstReferencingViewInPartent(EObject element, View parent) {
		Iterable<View> views = getReferencingView(element);
		if(views != null) {
			Iterator<View> ite = views.iterator();
			/*
			 * Take the first view which in the in the diagram
			 */
			while(ite.hasNext()) {
				View v = ite.next();
				if(EcoreUtil.isAncestor(parent, v)) {
					return v;
				}
			}
		}
		return null;
	}

	/**
	 * Create related links corresponding to linkDescriptions
	 * 
	 * @param linkDescriptors
	 * @param hostDiagram
	 * @param domain2NotationMap
	 */
	protected static void createRelatedLinks(Collection<? extends SysMLLinkDescriptor> linkDescriptors, IGraphicalEditPart hostDiagram) {
		for(SysMLLinkDescriptor nextLinkDescriptor : linkDescriptors) {
			/*
			 * Only one view for each element
			 */
			List<View> existingViews = DiagramEditPartsUtil.findViews(nextLinkDescriptor.getModelElement(), hostDiagram.getViewer());
			// only allow one view instance of a single element by diagram
			if(existingViews.isEmpty()) {
				Map editPartRegistry = hostDiagram.getViewer().getEditPartRegistry();
				EditPart sourceEditPart = getEditPart(nextLinkDescriptor.getSource(), editPartRegistry);
				EditPart targetEditPart = getEditPart(nextLinkDescriptor.getDestination(), editPartRegistry);
				// If the parts are still null...
				if(sourceEditPart == null || targetEditPart == null) {
					continue;
				}
				CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), nextLinkDescriptor.getVisualID(), ViewUtil.APPEND, false, hostDiagram.getDiagramPreferencesHint());
				CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
				ccr.setType(RequestConstants.REQ_CONNECTION_START);
				ccr.setSourceEditPart(sourceEditPart);
				sourceEditPart.getCommand(ccr);
				ccr.setTargetEditPart(targetEditPart);
				ccr.setType(RequestConstants.REQ_CONNECTION_END);
				Command cmd = targetEditPart.getCommand(ccr);
				if(cmd != null && cmd.canExecute()) {
					CommandUtil.executeCommand(cmd, hostDiagram);
					hostDiagram.addNotify();
				}
			}
		}
	}

	/**
	 * Retrieves editpart corresponding to domainModelElement
	 * 
	 * @param domainModelElement
	 * @param domain2NotationMap
	 */
	protected static IGraphicalEditPart getEditPart(EObject domainModelElement, Map editPartRegistry) {
		Object editpart = editPartRegistry.get(domainModelElement);
		if(editpart instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart)editpart;
		}
		return null;
	}

	/**
	 * Collects all related links for view
	 * 
	 * @param view
	 * @param hostDiagram
	 * @param domain2NotationMap
	 * 
	 * @return linkdescriptors
	 */
	public static Collection<? extends SysMLLinkDescriptor> restoreRelatedLinks(View view, DiagramEditPart hostDiagram) {
		List<SysMLLinkDescriptor> links = getRelatedLinks(view, hostDiagram);
		createRelatedLinks(links, hostDiagram);
		return links;
	}

	/**
	 * Create the related child node on the specify
	 * 
	 * @param host
	 * @param filteredChildren
	 * @param hostDiagram
	 */
	protected static void createRelatedChildNode(IGraphicalEditPart host, List<SysMLNodeDescriptor> filteredChildren, IGraphicalEditPart hostDiagram) {
		/*
		 * Create element
		 */
		for(SysMLNodeDescriptor child : filteredChildren) {
			CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(new EObjectAdapter(child.getModelElement()), Node.class, child.getVisualID(), Activator.DIAGRAM_PREFERENCES_HINT);
			CreateViewRequest request = new CreateViewRequest(descriptor);
			Command cmd = host.getCommand(request);
			if(cmd != null && cmd.canExecute()) {
				CommandUtil.executeCommand(cmd, host);
				host.addNotify();
			}
		}
	}

	/**
	 * Restore all related port of the view passed in argument
	 * 
	 * @param view
	 *        View you want to restore port on
	 * @param host
	 *        GraphicalEditPart of view
	 * @param hostDiagram
	 *        diagram editpart
	 */
	public static void restoreRelatedPort(View view, IGraphicalEditPart host, IGraphicalEditPart hostDiagram) {
		List<SysMLNodeDescriptor> childrenNodes = RestoreElementHelper.getRelatedPortsToRestore(view);
		List<SysMLNodeDescriptor> filteredChildren = filterPortWithExistingElement(view, childrenNodes);
		RestoreElementHelper.createRelatedChildNode(host, filteredChildren, hostDiagram);
	}

	/**
	 * Filter element to return only element which needs to be restored
	 * 
	 * @param v
	 * @param inputs
	 * @return
	 */
	protected static List<SysMLNodeDescriptor> filterPortWithExistingElement(final View v, List<SysMLNodeDescriptor> inputs) {
		List<SysMLNodeDescriptor> result = Lists.newArrayList(inputs);
		Iterator<SysMLNodeDescriptor> ite = result.iterator();
		while(ite.hasNext()) {
			SysMLNodeDescriptor next = ite.next();
			EObject element = next.getModelElement();
			Collection<Setting> refences = PapyrusEcoreUtils.getUsages(element);
			/*
			 * Return all view which reference the EObject and which are descendant of the containing view
			 */
			Iterable<Setting> views = Iterables.filter(refences, new Predicate<Setting>() {

				public boolean apply(Setting input) {
					EObject eObject = input.getEObject();
					if(eObject instanceof View) {
						View view = (View)eObject;
						if(EcoreUtil.isAncestor(v, view)) {
							return true;
						}
					}
					return false;
				}
			});
			if(Iterables.size(views) != 0) {
				ite.remove();
			}
		}
		return result;
	}
}
