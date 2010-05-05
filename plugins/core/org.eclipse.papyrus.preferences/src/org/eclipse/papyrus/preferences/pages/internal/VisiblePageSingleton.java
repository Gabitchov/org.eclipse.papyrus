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
package org.eclipse.papyrus.preferences.pages.internal;

import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusPreferencePage;
import org.eclipse.papyrus.preferences.pages.DiagramPreferencePage;
/**
 * This singleton has bee created to manage the button ok and apply of preference page.
 * In the case of button ok pressed, the behavior of eclipse try of apply in the first preference page found.
 * Here each page has a specific behavior. So to store the preference, the active page is called 
 *
 */
public class VisiblePageSingleton {

	private static VisiblePageSingleton instance;
	private IPreferencePage page;

	/**
	 * 
	 * @return the instance of the {@link VisiblePageSingleton}
	 */
	public static  VisiblePageSingleton getInstance() {
		if( instance==null){
			instance=new VisiblePageSingleton();
		}
		return instance;
	}

	/**
	 * set the visible page
	 * @param page a {@link IPreferencePage} --> {@link DiagramPreferencePage} or {@link AbstractPapyrusPreferencePage}
	 */
	public void  setVisiblePage(IPreferencePage page){
		this.page= page;
	}
	/**
	 * 
	 * @return the Visible Page
	 */
	public   IPreferencePage getVisiblePage(){
		return this.page;
	}
	/**
	 * call the visisble page in order to store preferences
	 */
	public void store(){
		if( this.page!=null){
			if( this.page instanceof DiagramPreferencePage){
				((DiagramPreferencePage)(this.page)).storeAllPreferences();
			}
			if( this.page instanceof AbstractPapyrusPreferencePage){
				((AbstractPapyrusPreferencePage)(this.page)).storeAllPreferences();
			}

		}
	}}
