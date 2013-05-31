/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.extension.diagrameditor;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * This descriptor describes a nested diagram. It is used by MultiDiagramEditor
 * to know about the nested diagram. It is fill by an extension.
 * 
 * @author Cedric Dumoulin
 * 
 */
public class EditorDescriptor {

	/**
	 * Editor factory implementation class.
	 */
	private Class<IPluggableEditorFactory> editorFactoryClass;

	/**
	 * EditorActionBarContributor Id used to search the
	 * EditorActionBarContributor requested by the editor.
	 */
	private String actionBarContributorId;

	/**
	 * The icon representing the diagram
	 */
	private ImageDescriptor icon;

	/**
	 * Resource path to the icon
	 */
	private String iconPath;

	/**
	 * Constructor.
	 */
	public EditorDescriptor() {

	}

	/**
	 * 
	 * @param attribute
	 */
	public void setActionBarContributorId(String actionBarContributorId) {
		this.actionBarContributorId = actionBarContributorId;

	}

	/**
	 * @see org.eclipse.papyrus.infra.core.extension.diagrameditor.IEditorDescriptor#getActionBarContributorId()
	 * @return
	 * 
	 */
	public String getActionBarContributorId() {
		return actionBarContributorId;
	}

	/**
	 * get the editor icon path
	 * 
	 * @return the editor icon path
	 */
	public ImageDescriptor getIcon() {
		return icon;
	}

	/**
	 * set the editor icon
	 * 
	 * @param icon
	 *        the icon path
	 */
	public void setIcon(ImageDescriptor icon) {
		this.icon = icon;
	}

	/**
	 * get the class of the editor factory
	 * 
	 * @return the class of the editor
	 */
	public Class<IPluggableEditorFactory> getEditorFactoryClass() {
		return editorFactoryClass;
	}

	/**
	 * set the editor facoty to this descriptor
	 * 
	 * @param editorFactoryClass
	 *        the class that represents the editor factory
	 */
	public void setEditorFactoryClass(Class<IPluggableEditorFactory> editorFactoryClass) {
		this.editorFactoryClass = editorFactoryClass;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		if(editorFactoryClass == null || editorFactoryClass.getName() == null) {
			return "[nestedEditor  editorFactory:" + editorFactoryClass + "(null)]";
		}
		return "[nestedEditor  editorFactory:" + editorFactoryClass.getName() + "]";
	}

	/**
	 * Set the URL of the Icon
	 * 
	 * @param iconPath
	 *        path of the Icon
	 */
	public void setIconURL(String iconPath) {
		this.iconPath = iconPath;
	}

	/**
	 * Get the URL of the based images
	 * 
	 * @return the path of the mai image. can return null if this property is not set
	 */
	public String getIconURL() {
		return iconPath;
	}

	/**
	 * set the Icon thanks to a {@link IConfigurationElement} and {@link String}which represent the path of the Icon
	 * 
	 * @param element
	 * @param iconPath
	 */
	public void setIcon(IConfigurationElement element, String iconPath, String pluginID) {
		setIcon(AbstractUIPlugin.imageDescriptorFromPlugin(element.getNamespaceIdentifier(), iconPath));
		setIconURL(element.getNamespaceIdentifier() + '/' + iconPath);
	}

}
