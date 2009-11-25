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
package org.eclipse.papyrus.sasheditor.sash;

/**
 * Event specifying that a tab has been moved.
 */
public class TabMovedEvent extends ChangeEvent {

	private Object srcFolder;

	private int srcTabIndex;

	private Object targetFolder;

	private Object targetTabIndex;

	/**
	 * Create the specified event.
	 */
	public TabMovedEvent(Object srcFolder, int srcTabIndex, Object targetFolder, Object targetTabIndex) {
		this.srcFolder = srcFolder;
		this.srcTabIndex = srcTabIndex;
		this.targetFolder = targetFolder;
		this.targetTabIndex = targetTabIndex;
	}

	/**
	 * @return the srcFolder
	 */
	public Object getSrcFolder() {
		return srcFolder;
	}

	/**
	 * @param srcFolder
	 *        the srcFolder to set
	 */
	public void setSrcFolder(Object srcFolder) {
		this.srcFolder = srcFolder;
	}

	/**
	 * @return the srcTabIndex
	 */
	public int getSrcTabIndex() {
		return srcTabIndex;
	}

	/**
	 * @param srcTabIndex
	 *        the srcTabIndex to set
	 */
	public void setSrcTabIndex(int srcTabIndex) {
		this.srcTabIndex = srcTabIndex;
	}

	/**
	 * @return the targetFolder
	 */
	public Object getTargetFolder() {
		return targetFolder;
	}

	/**
	 * @param targetFolder
	 *        the targetFolder to set
	 */
	public void setTargetFolder(Object targetFolder) {
		this.targetFolder = targetFolder;
	}

	/**
	 * @return the targetTabIndex
	 */
	public Object getTargetTabIndex() {
		return targetTabIndex;
	}

	/**
	 * @param targetTabIndex
	 *        the targetTabIndex to set
	 */
	public void setTargetTabIndex(Object targetTabIndex) {
		this.targetTabIndex = targetTabIndex;
	}

}
