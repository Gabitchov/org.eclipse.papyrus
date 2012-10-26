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
 *  Patrick Tessier (CEA LIST)-modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.DiagramsUtil;
import org.eclipse.papyrus.infra.gmfdiag.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.infra.gmfdiag.navigation.NavigableElement;
import org.eclipse.papyrus.infra.gmfdiag.navigation.NavigationHelper;
import org.eclipse.papyrus.infra.gmfdiag.navigation.preference.INavigationPreferenceConstant;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.helper.HyperLinkHelperFactory;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.ui.EditorNavigationDialog;
import org.eclipse.papyrus.infra.hyperlink.ui.HyperLinkManagerShell;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkHelpersRegistrationUtil;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.ui.hyperlinkshell.AdvancedHLManager;
import org.eclipse.papyrus.uml.diagram.common.ui.hyperlinkshell.HyperLinkDiagram;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * This class is used to open a new diagram when the double click is detected.
 * It is dependent of papyrus environment
 */
public class NavigationEditPolicy extends OpenEditPolicy {

	public static final String NAVIGATION_POLICY = "NavigationEditPolicy";

	public NavigationEditPolicy() {
	}

	/**
	 * 
	 * @param element
	 *        a UML element
	 * @return the top package of the given element
	 */
	public static Package topPackage(Element element) {
		if(element.getOwner() == null) {
			return (Package)element;
		} else {
			return topPackage(element.getOwner());
		}
	}

	/**
	 * 
	 * @param request
	 * @return get the command to open a new diagram
	 */
	@Override
	protected Command getOpenCommand(Request request) {
		final IGraphicalEditPart gep;

		// in order to obtain the list of default diagram we need to fin the
		// edit part that refers to default diagram

		// if this a label of a compartment, the good editpart is the parent
		if((IGraphicalEditPart)getHost() instanceof CompartmentEditPart) {
			gep = (IGraphicalEditPart)getHost().getParent();
		} else {

			gep = (IGraphicalEditPart)getHost();
		}
		final EObject semanticElement = gep.resolveSemanticElement();

		// navigable element by using heuristic
		List<NavigableElement> navElements = null;

		// defaultHyperlinks
		final ArrayList<HyperLinkObject> defaultHyperLinkObject = new ArrayList<HyperLinkObject>();
		final ArrayList<HyperLinkObject> hyperLinkObjectList;
		// Diagrams that will be found by using heuristic
		HashMap<NavigableElement, List<Diagram>> existingDiagrams = new HashMap<NavigableElement, List<Diagram>>();

		if(semanticElement == null) {
			return UnexecutableCommand.INSTANCE;
		}
		// initialition of code to extract hyperlinks, in the future to do with
		// extension points
		ArrayList<AbstractHyperLinkHelper> hyperLinkHelpers = new ArrayList<AbstractHyperLinkHelper>();
		//		hyperLinkHelpers.add(new DiagramHyperLinkHelper());
		//		hyperLinkHelpers.add(new DocumentHyperLinkHelper());
		//		hyperLinkHelpers.add(new WebHyperLinkHelper());
		hyperLinkHelpers.addAll(HyperLinkHelpersRegistrationUtil.INSTANCE.getAllRegisteredHyperLinkHelper());
		final HyperLinkHelperFactory hyperlinkHelperFactory = new HyperLinkHelperFactory(hyperLinkHelpers);

		try {
			// fill the list of default hyperlinks
			hyperLinkObjectList = (ArrayList<HyperLinkObject>)hyperlinkHelperFactory.getAllreferenced(gep.getNotationView());

			Iterator<HyperLinkObject> iterator = hyperLinkObjectList.iterator();
			while(iterator.hasNext()) {
				HyperLinkObject hyperlinkObject = iterator.next();
				if(hyperlinkObject.getIsDefault()) {

					defaultHyperLinkObject.add(hyperlinkObject);
				}

			}

			// fill navigation by using heuristics
			navElements = NavigationHelper.getInstance().getAllNavigableElements(semanticElement);
			HashMap<NavigableElement, List<CreationCommandDescriptor>> possibleCreations = new HashMap<NavigableElement, List<CreationCommandDescriptor>>();

			// test which kind of navigation by consulting preference
			String navigationKind = Activator.getDefault().getPreferenceStore().getString(INavigationPreferenceConstant.PAPYRUS_NAVIGATION_DOUBLECLICK_KIND);

			// no naviagation
			if(navigationKind.equals(INavigationPreferenceConstant.NO_NAVIGATION)) {
				// do nothing
				return UnexecutableCommand.INSTANCE;
			}

			// navigation by using heuristic
			// add list of diagram navigables by using heuristic
			if(navigationKind.equals(INavigationPreferenceConstant.EXPLICIT_IMPLICIT_NAVIGATION)) {
				for(NavigableElement navElement : navElements) {
					final EObject element = navElement.getElement();
					if(navElement instanceof ExistingNavigableElement) {
						List<Diagram> associatedDiagrams = DiagramsUtil.getAssociatedDiagrams(element, null);

						// ignore the current diagram
						associatedDiagrams.remove(gep.getNotationView().getDiagram());
						if(associatedDiagrams != null && !associatedDiagrams.isEmpty()) {
							existingDiagrams.put(navElement, associatedDiagrams);
						}
					}
				}

				Iterator<List<Diagram>> iter = existingDiagrams.values().iterator();
				while(iter.hasNext()) {
					List<Diagram> list = iter.next();
					Iterator<Diagram> iterDiagram = list.iterator();
					while(iterDiagram.hasNext()) {
						Diagram diagram = iterDiagram.next();
						HyperLinkDiagram hyperLinkDiagram = new HyperLinkDiagram();
						hyperLinkDiagram.setDiagram(diagram);
						hyperLinkDiagram.setTooltipText(diagram.getName() + " (found by heuristic)");
						// look for if a hyperlink already exists
						HyperLinkObject foundHyperlink = null;
						for(int i = 0; i < defaultHyperLinkObject.size() && foundHyperlink == null; i++) {
							if(defaultHyperLinkObject.get(i).getObject().equals(diagram)) {
								foundHyperlink = defaultHyperLinkObject.get(i);
							}
						}
						// the diagram was not into the list of existing default
						// hyperlink
						if(foundHyperlink == null) {
							defaultHyperLinkObject.add(hyperLinkDiagram);
						}
					}
				}
			}
			if(defaultHyperLinkObject.size() == 0) {
				Command command = new Command() {

					@Override
					public void execute() {
						EObject semanticElement = gep.getNotationView().getElement();
						if(semanticElement instanceof Element) {
							HyperLinkManagerShell hyperLinkManagerShell = new AdvancedHLManager(createEditorRegistry(), ((GraphicalEditPart)getHost()).getEditingDomain(), (Element)semanticElement, gep.getNotationView(), topPackage((Element)semanticElement), hyperlinkHelperFactory);
							hyperLinkManagerShell.setInput(hyperLinkObjectList);
							hyperLinkManagerShell.open();
						}
					}
				};
				return command;
			}
			if(defaultHyperLinkObject.size() == 1) {
				// open the diagram
				Command command = new Command() {

					@Override
					public void execute() {
						super.execute();
						defaultHyperLinkObject.get(0).executeSelectPressed();
					}
				};
				return command;

			}
			if(defaultHyperLinkObject.size() > 1) {
				// open a dialog to choose a diagram
				EditorNavigationDialog diagramNavigationDialog = new EditorNavigationDialog(getHost().getViewer().getControl().getShell(), defaultHyperLinkObject, semanticElement);
				diagramNavigationDialog.open();
				final List<HyperLinkObject> hList = diagramNavigationDialog.getSelectedHyperlinks();
				Command command = new Command() {

					@Override
					public void execute() {
						super.execute();

						Iterator<HyperLinkObject> iter = hList.iterator();
						while(iter.hasNext()) {
							HyperLinkObject hyperlinkObject = iter.next();
							hyperlinkObject.executeSelectPressed();
						}
					}
				};
				return command;

			}

		} catch (Exception e) {
			org.eclipse.papyrus.uml.diagram.common.Activator.log.error("Impossible to load hyperlinks", e);
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should
	 * implements this method in order to return the registry associated to the
	 * extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 * 
	 * @generated NOT
	 */
	protected IPageIconsRegistry createEditorRegistry() {
		try {
			return EditorUtils.getServiceRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			// Return an empty registry always providing null;
			return new PageIconsRegistry();
		}
	}

}
