/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.ui.perspectiveconfiguration;

import java.util.ArrayList;

/**
 * this class is a structure that contains a configuration
 * 
 */
public class Configuration {

	protected String perspectiveID = null;

	protected ArrayList<String> actionSetIDList = new ArrayList<String>();

	protected ArrayList<String> menuIDList = new ArrayList<String>();

	protected ArrayList<String> toolBarIDList = new ArrayList<String>();

	protected ArrayList<String> preferenceIDList = new ArrayList<String>();

	protected ArrayList<String> categoryIDList = new ArrayList<String>();

	protected ArrayList<String> commandIDList = new ArrayList<String>();

	public ArrayList<String> getCategoryIDList() {
		return categoryIDList;
	}


	public void addCategory(String id) {
		categoryIDList.add(id);
	}

	public void addCommandID(String id) {
		commandIDList.add(id);
	}

	public ArrayList<String> getCommandIDList() {
		return commandIDList;
	}

	public ArrayList<String> getActionSetIDList() {
		return actionSetIDList;
	}

	public void addActionSet(String id) {
		actionSetIDList.add(id);
	}

	public void addMenu(String id) {
		menuIDList.add(id);
	}

	public void addtoolBar(String id) {
		toolBarIDList.add(id);
	}

	public void addPreference(String id) {
		preferenceIDList.add(id);
	}

	public ArrayList<String> getMenuIDList() {
		return menuIDList;
	}

	public ArrayList<String> getToolBarID() {
		return toolBarIDList;
	}

	public ArrayList<String> getPreferenceID() {
		return preferenceIDList;
	}

	public String getPerspectiveID() {
		return perspectiveID;
	}

	public void setPerspectiveID(String perspectiveID) {
		this.perspectiveID = perspectiveID;
	}

	/**
	 * constructor of a perspective
	 * 
	 * @param perspectiveName
	 */
	public Configuration(String perspectiveName) {
		setPerspectiveID(perspectiveName);
	}

}
