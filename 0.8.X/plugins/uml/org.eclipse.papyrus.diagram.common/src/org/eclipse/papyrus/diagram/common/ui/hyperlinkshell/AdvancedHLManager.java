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
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.helper.HyperlinkHelperFactory;
import org.eclipse.papyrus.pastemanager.command.GEFtoEMFCommandWrapper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * 
 * This hyperlink manager can manage default hyperlinks and creation of diagram with heuristic
 */
public class AdvancedHLManager extends HyperLinkManagerShell {
	
	/**
	 * tab to manage default hyperlinks 
	 */
	protected DefaultHyperLinkTab defaultHyperLinkTab;
	/**
	 * tab to manage the creation of diagrams with heuristic
	 */
	protected LocalDefaultLinkDiagramTab defaultLinkDiagramTab;

	/**
	 * 
	 * Constructor.
	 *
	  * @param editorFactoryRegistry
	 *        the editor factory registry
	 * @param model
	 *        the model that contains all elements
	 * @param domain
	 *        the domain in order to execute command
	 * @param umlElement
	 *        the uml element linked to the view
	 * @param aview
	 *        the view of the uml element
	 *   
	 */
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
		defaultLinkDiagramTab = new LocalDefaultLinkDiagramTab(getcTabFolder(), umlElement);
	}


	/**
	 * this method parse the command to extract created diagram and construct a list of hyperlinkDiagrams
	 * @param creationcommand a gmf command
	 * @return the list of hyperlinks diagram
	 */
	protected ArrayList<HyperLinkDiagram>getCreatedHyperlinkDiagramsWithHeuristic(ICommand creationcommand){
		ArrayList<Diagram> diagrams= new ArrayList<Diagram>();
		if(creationcommand instanceof CompositeCommand){
			CompositeCommand compositeCommand=(CompositeCommand)creationcommand;
			Object value=compositeCommand.getCommandResult().getReturnValue();
			if(value instanceof ArrayList){
				diagrams.addAll((Collection<Diagram>)value);
			}
		}
		ArrayList<HyperLinkDiagram> hyperLinkDiagrams= new ArrayList<HyperLinkDiagram>();
		for( int i=0; i<diagrams.size();i++){
			HyperLinkDiagram hyperLinkDiagram = new HyperLinkDiagram();
			hyperLinkDiagram.setDiagram(diagrams.get(i));
			hyperLinkDiagram.setIsDefault(true);
			hyperLinkDiagram.setTooltipText(diagrams.get(i).getName());
			hyperLinkDiagrams.add(hyperLinkDiagram);
		}

		return hyperLinkDiagrams;
	}
	
	
	@Override
	protected void executeOkButton() {
		ArrayList<HyperLinkDiagram> defaultdiagramsWithHeuristic= new ArrayList<HyperLinkDiagram>();

		//if the default diagrams is opened, get created default diagrams
		if(defaultLinkDiagramTab.getDefaultHyperlinkComposite().isVisible()){
			defaultLinkDiagramTab.okPressed();
			ICommand creationCommand=defaultLinkDiagramTab.getCommand();
			transactionalEditingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(defaultLinkDiagramTab.getCommand()));
			defaultdiagramsWithHeuristic.addAll(getCreatedHyperlinkDiagramsWithHeuristic(creationCommand));
		}

		
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
		//add into the list all diagram create by using heuristic
		for(i=0; i<defaultdiagramsWithHeuristic.size();i++){
			allhypHyperlinkObjects.add(0, defaultdiagramsWithHeuristic.get(0));
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



	@Override
	public void setInput(ArrayList<HyperlinkObject> hyperLinkObjectList) {
		super.setInput(hyperLinkObjectList);
		defaultHyperLinkTab.setInput(allhypHyperlinkObjects);
	}
}
