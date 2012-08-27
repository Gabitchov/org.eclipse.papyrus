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
package org.eclipse.papyrus.sysml.diagram.internalblock.navigator;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.parts.FlowPortEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.parts.ResourceEditPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.InternalBlockDiagramEditorPlugin;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.SysmlVisualIDRegistry;
import org.eclipse.papyrus.sysml.diagram.internalblock.providers.SysmlElementTypes;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class SysmlNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		InternalBlockDiagramEditorPlugin.getInstance().getImageRegistry().put(
				"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		InternalBlockDiagramEditorPlugin.getInstance().getImageRegistry().put(
				"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof SysmlNavigatorItem && !isOwnView(((SysmlNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof SysmlNavigatorGroup) {
			SysmlNavigatorGroup group = (SysmlNavigatorGroup) element;
			return InternalBlockDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof SysmlNavigatorItem) {
			SysmlNavigatorItem navigatorItem = (SysmlNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (SysmlVisualIDRegistry.getVisualID(view)) {
		case ResourceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://www.eclipse.org/papyurs/0.7.0/Resource?Resource", SysmlElementTypes.Resource_1000); //$NON-NLS-1$
		case FlowPortEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.eclipse.org/papyrus/0.7.0/SysML/PortAndFlows?FlowPort", SysmlElementTypes.FlowPort_2001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = InternalBlockDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && SysmlElementTypes.isKnownElementType(elementType)) {
			image = SysmlElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof SysmlNavigatorGroup) {
			SysmlNavigatorGroup group = (SysmlNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof SysmlNavigatorItem) {
			SysmlNavigatorItem navigatorItem = (SysmlNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (SysmlVisualIDRegistry.getVisualID(view)) {
		case ResourceEditPart.VISUAL_ID:
			return getResource_1000Text(view);
		case FlowPortEditPart.VISUAL_ID:
			return getFlowPort_2001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getResource_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFlowPort_2001Text(View view) {
		FlowPort domainModelElement = (FlowPort) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isIsAtomic());
		} else {
			InternalBlockDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ResourceEditPart.MODEL_ID.equals(SysmlVisualIDRegistry.getModelID(view));
	}

}
