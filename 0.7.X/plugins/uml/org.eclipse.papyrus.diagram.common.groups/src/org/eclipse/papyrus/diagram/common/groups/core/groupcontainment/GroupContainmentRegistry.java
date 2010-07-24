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
package org.eclipse.papyrus.diagram.common.groups.core.groupcontainment;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.groups.groupcontainment.IContainerNodeDescriptor;

/**
 * This registry recovers information from the extensions for the GroupContainment point.
 * 
 * @author vhemery
 */
public class GroupContainmentRegistry {

	/** The GroupContainment extension point id */
	private static final String GROUP_EXTENSION_POINT = "org.eclipse.papyrus.diagram.common.groups.groupcontainment";

	/** The name of the extension node for model containment */
	private static final String MODEL_CONTAINER_NODE = "modelContainer";

	/** The name of the extension node for graphical container with model reference */
	private static final String REFERENCE_CONTAINER_NODE = "referenceContainer";

	/** The name of the descriptor attribute */
	private static final String CONTAINER_DESCRIPTOR_ATTRIBUTE = "descriptor";

	/** The name of the edit part type attribute */
	private static final String EDIT_PART_TYPE_ATTRIBUTE = "editPartType";

	/** The map of descriptors for model containers, by type of edit part */
	private static Map<String, IContainerNodeDescriptor> modelContainersDescriptors = new HashMap<String, IContainerNodeDescriptor>();

	/** The map of descriptors for graphical containers only, by type of edit part */
	private static Map<String, IContainerNodeDescriptor> graphicalContainersDescriptors = new HashMap<String, IContainerNodeDescriptor>();

	/** The map of descriptor allowing to recover the group part from a view, by view type */
	private static Map<String, IContainerNodeDescriptor> descriptorForViewType = new HashMap<String, IContainerNodeDescriptor>();

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
							if(provider instanceof IContainerNodeDescriptor) {
								modelContainersDescriptors.put(editPartType, (IContainerNodeDescriptor)provider);
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
							if(provider instanceof IContainerNodeDescriptor) {
								graphicalContainersDescriptors.put(editPartType, (IContainerNodeDescriptor)provider);
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
	 * Get the group descriptor of the edit part concerned by the group framework.
	 * 
	 * @param editPart
	 *        the edit part to get descriptor of
	 * @return container node descriptor or null if none
	 */
	public static IContainerNodeDescriptor getContainerDescriptor(IGraphicalEditPart editPart) {
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
			IContainerNodeDescriptor desc = descriptorForViewType.get(viewType);
			if(desc != null) {
				return desc.getPartFromView(view, diagramPart);
			} else {
				return null;
			}
		} else {
			// find the the appropriate descriptor for this view type
			for(IContainerNodeDescriptor desc : modelContainersDescriptors.values()) {
				IGraphicalEditPart res = desc.getPartFromView(view, diagramPart);
				if(res != null) {
					// register for further use
					descriptorForViewType.put(viewType, desc);
					return res;
				}
			}
			for(IContainerNodeDescriptor desc : graphicalContainersDescriptors.values()) {
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
