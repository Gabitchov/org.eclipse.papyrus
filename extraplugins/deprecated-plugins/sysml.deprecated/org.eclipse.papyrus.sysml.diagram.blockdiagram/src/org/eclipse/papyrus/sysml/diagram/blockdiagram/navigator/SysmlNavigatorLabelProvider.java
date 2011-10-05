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
package org.eclipse.papyrus.sysml.diagram.blockdiagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.papyrus.diagram.clazz.edit.parts.WrappingLabelEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.OperationEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.ResourceEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlDiagramEditorPlugin;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlVisualIDRegistry;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.providers.SysmlElementTypes;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.providers.SysmlParserProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

/**
 * @generated
 */
public class SysmlNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		SysmlDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		SysmlDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if(element instanceof SysmlNavigatorItem && !isOwnView(((SysmlNavigatorItem)element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if(element instanceof SysmlNavigatorGroup) {
			SysmlNavigatorGroup group = (SysmlNavigatorGroup)element;
			return SysmlDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if(element instanceof SysmlNavigatorItem) {
			SysmlNavigatorItem navigatorItem = (SysmlNavigatorItem)element;
			if(!isOwnView(navigatorItem.getView())) {
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
		switch(SysmlVisualIDRegistry.getVisualID(view)) {
		case ResourceEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/papyurs/0.7.0/Resource?Resource", SysmlElementTypes.Resource_1000); //$NON-NLS-1$
		case BlockEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/papyrus/0.7.0/SysML/Blocks?Block", SysmlElementTypes.Block_2001); //$NON-NLS-1$
		case PropertyEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Property", SysmlElementTypes.Property_3001); //$NON-NLS-1$
		case OperationEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/3.0.0/UML?Operation", SysmlElementTypes.Operation_3102); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = SysmlDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if(image == null && elementType != null && SysmlElementTypes.isKnownElementType(elementType)) {
			image = SysmlElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if(image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if(element instanceof SysmlNavigatorGroup) {
			SysmlNavigatorGroup group = (SysmlNavigatorGroup)element;
			return group.getGroupName();
		}

		if(element instanceof SysmlNavigatorItem) {
			SysmlNavigatorItem navigatorItem = (SysmlNavigatorItem)element;
			if(!isOwnView(navigatorItem.getView())) {
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
		if(view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch(SysmlVisualIDRegistry.getVisualID(view)) {
		case ResourceEditPart.VISUAL_ID:
			return getResource_1000Text(view);
		case BlockEditPart.VISUAL_ID:
			return getBlock_2001Text(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3001Text(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3102Text(view);
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
	private String getBlock_2001Text(View view) {
		IParser parser = SysmlParserProvider.getParser(SysmlElementTypes.Block_2001, view.getElement() != null ? view.getElement() : view, SysmlVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
		if(parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			SysmlDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getProperty_3001Text(View view) {
		Property domainModelElement = (Property)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			SysmlDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOperation_3102Text(View view) {
		Operation domainModelElement = (Operation)view.getElement();
		if(domainModelElement != null) {
			return String.valueOf(domainModelElement.getName());
		} else {
			SysmlDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3102); //$NON-NLS-1$
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
