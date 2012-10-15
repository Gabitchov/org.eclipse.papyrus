/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.navigation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.OpenDiagramCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

public class NavigationHelper {

	private static class NavigationHelperHolder {

		public static final NavigationHelper instance = new NavigationHelper();
	}

	public static NavigationHelper getInstance() {
		return NavigationHelperHolder.instance;
	}

	private static final String EXTENSION_ID = "org.eclipse.papyrus.infra.gmfdiag.navigation.navigationRules";

	private static final String NAVIGATIONRULE_ID = "navigationRule";

	private static final String RULE_ID = "rule";

	private List<INavigationRule> navigationRules = new LinkedList<INavigationRule>();

	private NavigationHelper() {
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);
		for(IConfigurationElement configElement : configElements) {
			if(NAVIGATIONRULE_ID.equals(configElement.getName())) {
				try {
					Object obj = configElement.createExecutableExtension(RULE_ID);
					if(obj instanceof INavigationRule) {
						navigationRules.add((INavigationRule)obj);
					}
				} catch (CoreException e) {
				}
			}
		}
	}

	private void addNextNavigableElements(NavigableElement currentNavElement, List<NavigableElement> navElements) {

		navElements.add(currentNavElement);

		for(INavigationRule navigationRule : navigationRules) {
			if(navigationRule.handle(currentNavElement.getElement())) {
				List<NavigableElement> nextNavigableElements = navigationRule.getNextPossibleElements(currentNavElement);
				for(NavigableElement nextNavigableElement : nextNavigableElements) {
					addNextNavigableElements(nextNavigableElement, navElements);
				}
			}
		}
	}

	/**
	 * get all navigation possibilities (existing or "to create" elements) from
	 * the specified element.
	 * 
	 * @param element
	 *        the element
	 * @return a list of navigation possibilities
	 */
	public List<NavigableElement> getAllNavigableElements(EObject element) {
		ArrayList<NavigableElement> navElements = new ArrayList<NavigableElement>();
		if(element != null) {
			addNextNavigableElements(new ExistingNavigableElement(element, null), navElements);
		}
		return navElements;
	}

	/**
	 * This method link the created element with its parent and browse the
	 * hierarchy to link the parents between them. Ultimately the hierarchy will
	 * be attached to an {@link ExistingNavigableElement}, so to the original
	 * model.
	 * 
	 * @param createdNavElement
	 */
	public static void linkToModel(CreatedNavigableElement createdNavElement) {
		NavigableElement navElement = createdNavElement;
		while(navElement instanceof CreatedNavigableElement) {
			CreatedNavigableElement cne = (CreatedNavigableElement)navElement;
			cne.linkToModel();
			navElement = cne.getPreviousNavigableElement();
		}
	}

	/**
	 * Same behavior as {@link NavigationHelper#linkToModel(CreatedNavigableElement)} but set the
	 * base name of the elements.
	 * 
	 * @param createdNavElement
	 * @param base
	 */
	public static void setBaseName(CreatedNavigableElement createdNavElement, String base) {
		NavigableElement navElement = createdNavElement;
		while(navElement instanceof CreatedNavigableElement) {
			CreatedNavigableElement cne = (CreatedNavigableElement)navElement;
			cne.setBaseName(base);
			navElement = cne.getPreviousNavigableElement();
		}
	}

	public static CompositeCommand getLinkCreateAndOpenNavigableDiagramCommand(final NavigableElement navElement, ICreationCommand creationCommandInterface, final String diagramName, ModelSet modelSet) {
		CompositeCommand compositeCommand = new CompositeCommand("Create diagram");

		if(navElement instanceof CreatedNavigableElement) {
			compositeCommand.add(new AbstractTransactionalCommand(modelSet.getTransactionalEditingDomain(), "Create hierarchy", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					NavigationHelper.linkToModel((CreatedNavigableElement)navElement);
					NavigationHelper.setBaseName((CreatedNavigableElement)navElement, "");
					return CommandResult.newOKCommandResult();
				}
			});
		}

		ICommand createDiagCommand = creationCommandInterface.getCreateDiagramCommand(modelSet, navElement.getElement(), diagramName);
		compositeCommand.add(createDiagCommand);
		compositeCommand.add(new OpenDiagramCommand(modelSet.getTransactionalEditingDomain(), createDiagCommand));

		return compositeCommand;
	}
}
