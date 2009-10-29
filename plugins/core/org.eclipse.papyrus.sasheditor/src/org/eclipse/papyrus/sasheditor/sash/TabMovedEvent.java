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
// @unused
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
	// @unused
	public Object getSrcFolder() {
		return srcFolder;
	}

	/**
	 * @param srcFolder
	 *            the srcFolder to set
	 */
	// @unused
	public void setSrcFolder(Object srcFolder) {
		this.srcFolder = srcFolder;
	}

	/**
	 * @return the srcTabIndex
	 */
	// @unused
	public int getSrcTabIndex() {
		return srcTabIndex;
	}

	/**
	 * @param srcTabIndex
	 *            the srcTabIndex to set
	 */
	// @unused
	public void setSrcTabIndex(int srcTabIndex) {
		this.srcTabIndex = srcTabIndex;
	}

	/**
	 * @return the targetFolder
	 */
	// @unused
	public Object getTargetFolder() {
		return targetFolder;
	}

	/**
	 * @param targetFolder
	 *            the targetFolder to set
	 */
	// @unused
	public void setTargetFolder(Object targetFolder) {
		this.targetFolder = targetFolder;
	}

	/**
	 * @return the targetTabIndex
	 */
	// @unused
	public Object getTargetTabIndex() {
		return targetTabIndex;
	}

	/**
	 * @param targetTabIndex
	 *            the targetTabIndex to set
	 */
	// @unused
	public void setTargetTabIndex(Object targetTabIndex) {
		this.targetTabIndex = targetTabIndex;
	}

}
