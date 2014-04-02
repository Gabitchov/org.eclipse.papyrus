/*****************************************************************************
 * Copyright (c) 2009, 2014 LIFL, CEA LIST, and others. 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 392301
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.swt.graphics.Image;


/**
 * A fake page for testing purpose
 * 
 * @author dumoulin
 */
public class FakePageModel implements IPageModel {

	String title;

	static int count = 0;

	public FakePageModel() {
		title = "noname" + count++;
	}

	/**
	 * @param title
	 */
	public FakePageModel(String title) {
		this.title = title;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getRawModel() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getTabIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTabTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public void dispose() {
		// Pass
	}
}
