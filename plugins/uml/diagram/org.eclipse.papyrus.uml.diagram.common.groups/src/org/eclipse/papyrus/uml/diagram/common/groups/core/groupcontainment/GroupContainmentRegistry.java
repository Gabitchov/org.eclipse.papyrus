/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.groups.core.groupcontainment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment.AbstractContainerNodeDescriptor;


/**
 * This registry recovers information from the extensions for the GroupContainment point.
 * 
 * @author vhemery
 */
public class GroupContainmentRegistry {

	/** The GroupContainment extension point id */
	private static final String GROUP_EXTENSION_POINT = "org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment";

	/** The name of the extension node for model containment */
	private static final String MODEL_CONTAINER_NODE = "modelContainer";

	/** The name of the extension node for graphical container with model reference */
	private static final String REFERENCE_CONTAINER_NODE = "referenceContainer";

	/** The name of the descriptor attribute */
	private static final String CONTAINER_DESCRIPTOR_ATTRIBUTE = "descriptor";

	/** The name of the edit part type attribute */
	private static final String EDIT_PART_TYPE_ATTRIBUTE = "editPartType";

	/** The map of descriptors for model containers, by type of edit part */
	private static Map<String, AbstractContainerNodeDescriptor> modelContainersDescriptors = new HashMap<String, AbstractContainerNodeDescriptor>();

	/** The map of descriptors for graphical containers only, by type of edit part */
	private static Map<String, AbstractContainerNodeDescriptor> graphicalContainersDescriptors = new HashMap<String, AbstractContainerNodeDescriptor>();

	/** The map of descriptor allowing to recover the group part from a view, by view type */
	private static Map<String, AbstractContainerNodeDescriptor> descriptorForViewType = new HashMap<String, AbstractContainerNodeDescriptor>();


	/**
	 * Initialize the values from the extension point
	 */
	static {
		initialize();
	}

	/**
	 * Load all extensions and register the container descriptors
	 */
	public static void initialize() {
		// Load extensions of edit part mapping
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint(GROUP_EXTENSION_POINT);
		for(IExtension extension : extensionPoint.getExtensions()) {
			for(IConfigurationElement providing : extension.getConfigurationElements()) {
				if(MODEL_CONTAINER_NODE.equals(providing.getName())) {
					String editPartType = providing.getAttribute(EDIT_PART_TYPE_ATTRIBUTE);
					if(editPartType != null) {
						try {
							Object provider = providing.createExecutableExtension(CONTAINER_DESCRIPTOR_ATTRIBUTE);
							if(provider instanceof AbstractContainerNodeDescriptor) {
								modelContainersDescriptors.put(editPartType, (AbstractContainerNodeDescriptor)provider);
							}
						} catch (CoreException e) {
							// ignore this extension node
						}
					}
				} else if(REFERENCE_CONTAINER_NODE.equals(providing.getName())) {
					String editPartType = providing.getAttribute(EDIT_PART_TYPE_ATTRIBUTE);
					if(editPartType != null) {
						try {
							Object provider = providing.createExecutableExtension(CONTAINER_DESCRIPTOR_ATTRIBUTE);
							if(provider instanceof AbstractContainerNodeDescriptor) {
								graphicalContainersDescriptors.put(editPartType, (AbstractContainerNodeDescriptor)provider);
							}
						} catch (CoreException e) {
							// ignore this extension node
						}
					}
				}

			}
		}
	}

	/**
	 * Get the AbstractContainerNodeDescriptor from a EClass
	 * 
	 * @param containerEClass
	 * @return Set<AbstractContainerNodeDescriptor> Return all the descriptor which match the corresponding EClass
	 */
	public static Set<AbstractContainerNodeDescriptor> getDescriptorsWithContainerEClass(EClass containerEClass) {
		Set<AbstractContainerNodeDescriptor> descriptors = new HashSet<AbstractContainerNodeDescriptor>(modelContainersDescriptors.size() + graphicalContainersDescriptors.size());
		Set<AbstractContainerNodeDescriptor> descriptorsResult = new HashSet<AbstractContainerNodeDescriptor>(modelContainersDescriptors.size() + graphicalContainersDescriptors.size());
		descriptors.addAll(modelContainersDescriptors.values());
		descriptors.addAll(graphicalContainersDescriptors.values());
		// filter descriptors
		for(AbstractContainerNodeDescriptor descriptor : descriptors) {
			if(descriptor.getContainerEClass().equals(containerEClass)) {
				descriptorsResult.add(descriptor);
			}
		}
		return descriptorsResult;
	}

	/**
	 * Get all the references which can point to a group
	 * 
	 * @return give back a set of ERefences pointing at group
	 */
	public static Set<EReference> getAllERefencesFromNodeToGroup() {
		Set<EReference> referencesResult = new HashSet<EReference>();
		Set<AbstractContainerNodeDescriptor> descriptors = new HashSet<AbstractContainerNodeDescriptor>(modelContainersDescriptors.size() + graphicalContainersDescriptors.size());
		descriptors.addAll(modelContainersDescriptors.values());
		descriptors.addAll(graphicalContainersDescriptors.values());
		for(AbstractContainerNodeDescriptor descriptor : descriptors) {
			for(EReference ref : descriptor.getChildrenReferences()) {
				EReference eoppositeRef = ref.getEOpposite();
				if(eoppositeRef != null) {
					referencesResult.add(eoppositeRef);
				}
			}

		}
		return referencesResult;
	}

	/**
	 * Know whether the edit part is concerned by the group framework, which means there is a container descriptor for its class.
	 * 
	 * @param editPart
	 *        the edit part to test
	 * @return true if there is a descriptor
	 */
	public static boolean isContainerConcerned(IGraphicalEditPart editPart) {
		if(editPart == null) {
			return false;
		}
		String editPartClassName = editPart.getClass().getCanonicalName();
		return modelContainersDescriptors.containsKey(editPartClassName) || graphicalContainersDescriptors.containsKey(editPartClassName);
	}

	/**
	 * Return true it the element pointed by the EditPart is a node whicj=h is concerned by the framework
	 * 
	 * @param editPart
	 *        of EObject you want to test
	 * @return
	 */
	public static boolean isNodeConcerned(IGraphicalEditPart editPart) {
		EClass current = editPart.resolveSemanticElement().eClass();
		Set<EReference> allReferences = new HashSet<EReference>();
		for(AbstractContainerNodeDescriptor nodeDesc1 : modelContainersDescriptors.values()) {
			allReferences.addAll(nodeDesc1.getChildrenReferences());
		}
		for(AbstractContainerNodeDescriptor nodeDesc2 : graphicalContainersDescriptors.values()) {
			allReferences.addAll(nodeDesc2.getChildrenReferences());
		}
		for(EReference ref : allReferences) {
			if(ref.getEReferenceType().isSuperTypeOf(current)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get the group descriptor of the edit part concerned by the group framework.
	 * Warning the edit part has to be exactly the same than the one register in the extension point.
	 * For example in the case of Activity Diagram. Onlu the compartment edit Part are register.
	 * 
	 * @param editPart
	 *        the edit part to get descriptor of
	 * @return container node descriptor or null if none
	 */
	public static AbstractContainerNodeDescriptor getContainerDescriptor(IGraphicalEditPart editPart) {
		String editPartClassName = editPart.getClass().getCanonicalName();
		if(modelContainersDescriptors.containsKey(editPartClassName)) {
			return modelContainersDescriptors.get(editPartClassName);
		} else if(graphicalContainersDescriptors.containsKey(editPartClassName)) {
			return graphicalContainersDescriptors.get(editPartClassName);
		} else {
			return null;
		}
	}

	/**
	 * Know whether the edit part concerned by the group framework is a model container.
	 * 
	 * @param editPart
	 *        the edit part to test
	 * @return true if the container is a direct model container
	 */
	public static boolean isContainerModel(IGraphicalEditPart editPart) {
		String editPartClassName = editPart.getClass().getCanonicalName();
		return modelContainersDescriptors.containsKey(editPartClassName);
	}

	/**
	 * Get the group compartment part (containing children elements) from a view of the node
	 * 
	 * @param view
	 *        a view, either of the compartment, or the primary node view
	 * @param diagramPart
	 *        the diagram edit part to recover parts from views
	 * @return the group compartment part or null if none is adequate for the group framework
	 */
	public static IGraphicalEditPart getGroupContainingPartFromView(View view, DiagramEditPart diagramPart) {
		String viewType = view.getType();
		if(descriptorForViewType.containsKey(viewType)) {
			// the appropriate descriptor has already been found for this view type
			AbstractContainerNodeDescriptor desc = descriptorForViewType.get(viewType);
			if(desc != null) {
				return desc.getPartFromView(view, diagramPart);
			} else {
				return null;
			}
		} else {
			// find the the appropriate descriptor for this view type
			for(AbstractContainerNodeDescriptor desc : modelContainersDescriptors.values()) {
				IGraphicalEditPart res = desc.getPartFromView(view, diagramPart);
				if(res != null) {
					// register for further use
					descriptorForViewType.put(viewType, desc);
					return res;
				}
			}
			for(AbstractContainerNodeDescriptor desc : graphicalContainersDescriptors.values()) {
				IGraphicalEditPart res = desc.getPartFromView(view, diagramPart);
				if(res != null) {
					// register for further use
					descriptorForViewType.put(viewType, desc);
					return res;
				}
			}
			// register no result for further use
			descriptorForViewType.put(viewType, null);
			return null;
		}
	}
}
