/*****************************************************************************
 * Copyright (c) 2009 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.resource.Resource;
import org.eclipse.papyrus.resource.util.ResourceUtil;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.parts.FlowPortEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.parts.ResourceEditPart;

/**
 * @generated
 */
public class SysmlDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (SysmlVisualIDRegistry.getVisualID(view)) {
		case ResourceEditPart.VISUAL_ID:
			return getResource_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResource_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Resource modelElement = (Resource) ResourceUtil.getResource(view.getElement());
		List result = new LinkedList();
		for (Iterator it = modelElement.getEobjects().iterator(); it.hasNext();) {
			EObject childElement = (EObject) it.next();
			int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, (EObject) childElement);
			if (visualID == FlowPortEditPart.VISUAL_ID) {
				result.add(new SysmlNodeDescriptor((EObject) childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (SysmlVisualIDRegistry.getVisualID(view)) {
		case ResourceEditPart.VISUAL_ID:
			return getResource_1000ContainedLinks(view);
		case FlowPortEditPart.VISUAL_ID:
			return getFlowPort_2001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (SysmlVisualIDRegistry.getVisualID(view)) {
		case FlowPortEditPart.VISUAL_ID:
			return getFlowPort_2001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (SysmlVisualIDRegistry.getVisualID(view)) {
		case FlowPortEditPart.VISUAL_ID:
			return getFlowPort_2001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResource_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFlowPort_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFlowPort_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFlowPort_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

}
