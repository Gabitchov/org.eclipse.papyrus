/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.helper.HyperlinkHelperFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * 
 * This hyperlink manager can manage default hyperlinks
 */
public class AdvancedHLManager extends HyperLinkManagerShell {
	DefaultHyperLinkTab defaultHyperLinkTab;
	
	public AdvancedHLManager(IPageIconsRegistry editorFactoryRegistry, TransactionalEditingDomain domain, Element umlElement, View aview, Package model, HyperlinkHelperFactory hyperHelperFactory) {
		super(editorFactoryRegistry, domain, umlElement, aview, model, hyperHelperFactory);
	 defaultHyperLinkTab= new DefaultHyperLinkTab(getcTabFolder(), allhypHyperlinkObjects);
	 
	 // add a listener to refresh default link  tab
	 defaultHyperLinkTab.getMainComposite().addListener(SWT.Show, new Listener() {
			public void handleEvent(Event event) {
				//get all hyperlink from all tabs
				allhypHyperlinkObjects.clear();
				Iterator<HyperLinkTab>iter= tabList.iterator();
				while(iter.hasNext()) {
					HyperLinkTab hyperLinkTab = (HyperLinkTab)iter.next();
					allhypHyperlinkObjects.addAll(hyperLinkTab.getHyperlinkObjects());
				}
				defaultHyperLinkTab.setInput(allhypHyperlinkObjects);
			}
		});
	}

	@Override
	protected void executeOkButton() {
		// empty all hyperlinks
		transactionalEditingDomain.getCommandStack().execute(HyperlinkHelperFactory.getEmptyAllHyperLinkCommand(transactionalEditingDomain, view));
		allhypHyperlinkObjects.clear();
		
		//get all hyperlinks from tabs
		Iterator<HyperLinkTab>iter= tabList.iterator();
		while(iter.hasNext()) {
			HyperLinkTab hyperLinkTab = (HyperLinkTab)iter.next();
			allhypHyperlinkObjects.addAll(hyperLinkTab.getHyperlinkObjects());
		}
		
		//set all hyper links is default to false
		Iterator<HyperlinkObject>iterator= allhypHyperlinkObjects.iterator();
		while(iterator.hasNext()) {
			HyperlinkObject hyperLink = (HyperlinkObject)iterator.next();
			hyperLink.setIsDefault(false);
		}
		
		//look for all hyperlink default and put it as default at the top of the list
		int i=defaultHyperLinkTab.getDefaultHyperLinkObject().size()-1;
		while(i>=0) {
			HyperlinkObject hyperLinkObject = defaultHyperLinkTab.getDefaultHyperLinkObject().get(i);
			hyperLinkObject.setIsDefault(true);
			if(allhypHyperlinkObjects.contains(hyperLinkObject)){
				allhypHyperlinkObjects.remove(hyperLinkObject);
				allhypHyperlinkObjects.add(0,hyperLinkObject);
			}
			
			i--;
		}
		
		// save hyperlink Document list
		try {
			transactionalEditingDomain.getCommandStack().execute(hyperLinkHelperFactory.getAddHyperLinkCommand(transactionalEditingDomain, view, allhypHyperlinkObjects));
		} catch (HyperLinkException error) {
			Activator.log.error(error);
		}

		tabList.clear();
		getHyperLinkShell().close();
	}

	public void initializeLocalHyperLinkFolder() {
		// TODO Auto-generated method stub

	}
	
	
	@Override
	public void setInput(ArrayList<HyperlinkObject> hyperLinkObjectList) {
		super.setInput(hyperLinkObjectList);
		defaultHyperLinkTab.setInput(allhypHyperlinkObjects);
	}
}
