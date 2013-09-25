/*****************************************************************************
 * Copyright (c) 2011, 2013 CEA LIST and others.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Consolidate all hyperlink helper contributions into one tab
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.ui;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.swt.custom.CTabFolder;

/**
 * 
 * Each new tab should extends this class
 * 
 */
public abstract class AbstractHyperLinkTab {

	/**
	 * The id of the tab
	 */
	private String tabId;

	//TODO these parameters should be privated
	/**
	 * The HyperLinkHelper for this tab
	 */
	protected AbstractHyperLinkHelper hyperLinkHelper;

	/**
	 * The hyperlink object
	 */
	protected List<HyperLinkObject> hyperlinkObjects;

	/**
	 * the CTabFolder
	 */
	protected CTabFolder cTabFolder;

	/**
	 * The edited element
	 */
	protected EObject element;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tabId
	 *        the id of the tab
	 * @param helper
	 *        the helper for this tab
	 */
	public AbstractHyperLinkTab(final String tabId, final AbstractHyperLinkHelper helper) {
		this.tabId = tabId;
		this.hyperLinkHelper = helper;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public AbstractHyperLinkTab() {
		//nothing to do
		//used to create the tab from the extension point
	}

	/**
	 * Getter for {@link #tabId}
	 * 
	 * @return
	 *         this{@link #tabId}
	 */
	public final String getTabId() {
		return this.tabId;
	}

	/**
	 * 
	 * @param hyperLinkObjectList
	 */
	public abstract void setInput(final List<HyperLinkObject> hyperLinkObjectList);

	/**
	 * 
	 * @param tabId
	 *        the id of the tab. This parameter can be set only one time!
	 */
	public void setTabId(String tabId) {
		if(this.tabId == null) {
			this.tabId = tabId;
		}
	}

	/**
	 * This method allows to init the parameter of the tab. These parameter can be set only one time!
	 * 
	 * @param cTabFolder
	 *        the CTabFolder for this tab
	 * @param hyperlinkObjects
	 *        the hyperlink objects
	 * @param element
	 *        the edited element
	 */
	public void init(final CTabFolder cTabFolder, List<HyperLinkObject> hyperlinkObjects, final EObject element/* , final IHyperLinkShell shell */) {
		if(this.cTabFolder == null) {
			this.cTabFolder = cTabFolder;
		}
		if(this.hyperlinkObjects == null) {
			this.hyperlinkObjects = hyperlinkObjects;
		}
		if(this.element == null) {
			this.element = element;
		}
	}

	/**
	 * Getter for {@link #hyperlinkObjects}
	 * 
	 * @return
	 *         this{@link #hyperlinkObjects}
	 */
	public List<HyperLinkObject> getHyperlinkObjects() {
		return this.hyperlinkObjects;
	}


}
