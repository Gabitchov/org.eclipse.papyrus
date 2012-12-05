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
 *  Arthur Daussy (Atos) arthur.daussy@atos.net - Bug 363827 - [Improvement] Diagram creation, remember the latest tab chosen
 *  Vincent Lorenzo (CEA-LIST) Vincent.lorenzo@cea.fr (refactoring of the hyperlink)
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.ui;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.hyperlink.helper.HyperLinkHelperFactory;
import org.eclipse.papyrus.infra.hyperlink.ui.AbstractHyperLinkTab;
import org.eclipse.papyrus.infra.hyperlink.ui.HyperLinkManagerShell;

/**
 * 
 * This hyperlink manager can manage default hyperlinks and creation of diagram with heuristic
 */
public class AdvancedHLManager extends HyperLinkManagerShell {


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
	public AdvancedHLManager(IPageIconsRegistry editorFactoryRegistry, TransactionalEditingDomain domain, EModelElement semanticElement, View aview, HyperLinkHelperFactory hyperHelperFactory) {
		super(editorFactoryRegistry, domain, semanticElement, aview, hyperHelperFactory);
	}

	/**
	 * this method parse the command to extract created diagram and construct a list of hyperlinkDiagrams
	 * 
	 * @param creationcommand
	 *        a gmf command
	 * @return the list of hyperlinks diagram
	 */
	protected ArrayList<HyperLinkDiagram> getCreatedHyperlinkDiagramsWithHeuristic(ICommand creationcommand) {
		ArrayList<Diagram> diagrams = new ArrayList<Diagram>();
		if(creationcommand instanceof CompositeCommand) {
			CompositeCommand compositeCommand = (CompositeCommand)creationcommand;
			Object value = compositeCommand.getCommandResult().getReturnValue();
			if(value instanceof ArrayList) {
				diagrams.addAll((Collection<Diagram>)value);
			}
		}
		ArrayList<HyperLinkDiagram> hyperLinkDiagrams = new ArrayList<HyperLinkDiagram>();
		for(int i = 0; i < diagrams.size(); i++) {
			HyperLinkDiagram hyperLinkDiagram = new HyperLinkDiagram();
			hyperLinkDiagram.setDiagram(diagrams.get(i));
			hyperLinkDiagram.setIsDefault(true);
			hyperLinkDiagram.setTooltipText(diagrams.get(i).getName());
			hyperLinkDiagrams.add(hyperLinkDiagram);
		}
		return hyperLinkDiagrams;
	}

	@Override
	protected void doAction() {
		super.doAction();
		//		defaultTab = getDefaultHyperLinkTab();
		final LocalDefaultLinkDiagramTab heuristicTab = getHeuristicTab();
		ArrayList<HyperLinkDiagram> defaultdiagramsWithHeuristic = new ArrayList<HyperLinkDiagram>();
		//if the default diagrams is opened, get created default diagrams
		if(heuristicTab.getDefaultHyperlinkComposite().isVisible()) {
			heuristicTab.okPressed();
			ICommand creationCommand = heuristicTab.getCommand();
			//TODO : should be chained with the others command
			transactionalEditingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(heuristicTab.getCommand()));
			defaultdiagramsWithHeuristic.addAll(getCreatedHyperlinkDiagramsWithHeuristic(creationCommand));
		}



		//add into the list all diagram create by using heuristic
		for(int i = 0; i < defaultdiagramsWithHeuristic.size(); i++) {
			allhypHyperlinkObjects.add(0, defaultdiagramsWithHeuristic.get(i));
		}

	}

	private LocalDefaultLinkDiagramTab getHeuristicTab() {
		int i = 0;
		LocalDefaultLinkDiagramTab tab = null;
		for(AbstractHyperLinkTab current : tabList) {
			if(current instanceof LocalDefaultLinkDiagramTab) {
				tab = (LocalDefaultLinkDiagramTab)current;
				i++;
			}
		}
		Assert.isTrue(i == 1);
		Assert.isNotNull(tab);
		return tab;
	}
}
