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
 *
  *****************************************************************************/

package org.eclipse.papyrus.sasheditor.extension;

import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * This descriptor describes a nested diagram. It is used by MultiDiagramEditor to know about the nested diagram. It is fill by an extension.
 */
public class ActionBarButtonDescriptor {

	/**
	 * ID of the plugin containing the icons. Icons are searched from the plugin root.
	 */
	private String pluginID;

	/**
	 * Create action ID. This ID is used to uniquely identify the action.
	 */
	private String actionID;

	/**
	 * Create action label.
	 */
	private String createDiagramLabel;

	/**
	 * Create action tooltip.
	 */
	private String createDiagramTooltip;

	/**
	 * Create action icon path. Path is relative to the plugin (see {@link ActionBarButtonDescriptor#pluginID}). See {@link AbstractUIPlugin#imageDescriptorFromPlugin(String, String)}
	 */
	private String createDiagramImage;

	/**
	 * Create action disable icon path. Path is relative to the (see {@link ActionBarButtonDescriptor#pluginID}) . See {@link AbstractUIPlugin#imageDescriptorFromPlugin(String, String)}
	 */
	private String createDiagramDisableImage;

	/**
	 * Create action implementation class.
	 */
	private Class<?> createEditorActionClass;

	/**
	 * Constructor.
	 */
	public ActionBarButtonDescriptor() {

	}

	/**
	 * Create the create action instance used to create a new diagram.
	 * 
	 * @return the create diagram action
	 */
	public ICreateDiagramAction getCreateDiagramAction() {
		try {
			ICreateDiagramAction action = (ICreateDiagramAction) createEditorActionClass.newInstance();
			return action;
		} catch (InstantiationException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		}

	}

	public String getCreateDiagramLabel() {
		return createDiagramLabel;
	}

	public void setCreateDiagramLabel(String createDiagramLabel) {
		this.createDiagramLabel = createDiagramLabel;
	}

	public String getCreateDiagramTooltip() {
		return createDiagramTooltip;
	}

	public void setCreateDiagramTooltip(String createDiagramTooltip) {
		this.createDiagramTooltip = createDiagramTooltip;
	}

	public String getCreateDiagramImage() {
		return createDiagramImage;
	}

	public void setCreateDiagramImage(String createDiagramImage) {
		this.createDiagramImage = createDiagramImage;
	}

	public String getCreateDiagramDisableImage() {
		return createDiagramDisableImage;
	}

	public void setCreateDiagramDisableImage(String createDiagramDisableImage) {
		this.createDiagramDisableImage = createDiagramDisableImage;
	}

	/**
	 * @return the createEditorActionClass
	 */
	public Class<?> getCreateEditorActionClass() {
		return createEditorActionClass;
	}

	/**
	 * @param createEditorActionClass
	 *            the createEditorActionClass to set
	 */
	public void setCreateEditorActionClass(Class<?> createEditorActionClass) {
		this.createEditorActionClass = createEditorActionClass;
	}

	/**
	 * @return the actionID
	 */
	public String getActionID() {
		return actionID;
	}

	/**
	 * @param actionID
	 *            the actionID to set
	 */
	public void setActionID(String actionID) {
		this.actionID = actionID;
	}

	/**
	 * @return the pluginID
	 */
	public String getPluginID() {
		return pluginID;
	}

	/**
	 * @param pluginID
	 *            the pluginID to set
	 */
	public void setPluginID(String pluginID) {
		this.pluginID = pluginID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + " pluginID=" + pluginID + " actionID=" + actionID + "createDiagramLabel" + createDiagramLabel;
	}
}
