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
package org.eclipse.papyrus.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.common.dialogs.DiagramNavigationDialog;
import org.eclipse.papyrus.diagram.common.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.diagram.common.helper.DiagramHyperLinkHelper;
import org.eclipse.papyrus.diagram.common.helper.DocumentHyperLinkHelper;
import org.eclipse.papyrus.diagram.common.helper.EditPartHyperLinkHelper;
import org.eclipse.papyrus.diagram.common.helper.HyperlinkHelperFactory;
import org.eclipse.papyrus.diagram.common.helper.WebHyperLinkHelper;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.AdvancedHLManager;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkManagerShell;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject;
import org.eclipse.papyrus.navigation.preference.INavigationPreferenceConstant;
import org.eclipse.papyrus.preferences.Activator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This class is used to open a new diagram when the double click is detected.
 * It is dependent of papyrus environment
 */
public class NavigationEditPolicy extends OpenEditPolicy {

	public static final String NAVIGATION_POLICY = "NavigationEditPolicy";

	private IPageIconsRegistry editorRegistry;

	protected HyperlinkHelperFactory hyperlinkHelperFactory;
	
	public NavigationEditPolicy() {
		// initialization of code to extract hyperlinks.
		// TODO : use extension points instead.
		ArrayList<AbstractHyperLinkHelper> hyperLinkHelpers = new ArrayList<AbstractHyperLinkHelper>();
		hyperLinkHelpers.add(new DiagramHyperLinkHelper());
		hyperLinkHelpers.add(new DocumentHyperLinkHelper());
		hyperLinkHelpers.add(new WebHyperLinkHelper());
		hyperlinkHelperFactory = new HyperlinkHelperFactory(hyperLinkHelpers);
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
	protected Command getOpenCommand(Request request) {
		final IGraphicalEditPart gep;

		// in order to obtain the list of default diagram we need to fin the
		// edit part that refers to default diagram

		gep = (IGraphicalEditPart)getHost();
	

		EObject shape = ((IGraphicalEditPart)getHost()).getNotationView();
		
		while (!(shape instanceof Shape || shape == null)) {
			shape = shape.eContainer();
		}
		
		final EObject semanticElement= gep.resolveSemanticElement();
		
		
		if(shape == null | semanticElement == null) {
			return UnexecutableCommand.INSTANCE;
		}

		EditPartHyperLinkHelper diagramHelper = new EditPartHyperLinkHelper((View) shape);

		try {

			final ArrayList<HyperlinkObject> hyperLinkObjectList;

			// test which kind of navigation by consulting preference
			String navigationKind = Activator.getDefault().getPreferenceStore().getString(INavigationPreferenceConstant.PAPYRUS_NAVIGATION_DOUBLECLICK_KIND);

			// if no navigation, do nothing.
			if(navigationKind.equals(INavigationPreferenceConstant.NO_NAVIGATION)) {
				return UnexecutableCommand.INSTANCE;
			}

			// navigation by using heuristic
			// add list of diagram navigables by using heuristic
			if(navigationKind.equals(INavigationPreferenceConstant.EXPLICIT_IMPLICIT_NAVIGATION)) {

				final HyperlinkHelperFactory finalHyperlinkHelperFactory = this.hyperlinkHelperFactory;

				// GETTING THE HYPERLINKS.
				hyperLinkObjectList = (ArrayList<HyperlinkObject>)diagramHelper.getHyperlinksFromEditPart(hyperlinkHelperFactory);

				// If there's only one hyperlink, setting it as default. 
				if (hyperLinkObjectList.size() == 1){
					hyperLinkObjectList.get(0).setIsDefault(true);
				}
				
				// Default hyperlinks.
				Predicate<HyperlinkObject> filterDefaultHyperlinks = new Predicate<HyperlinkObject>() {

					public boolean apply(HyperlinkObject hyperLinkObject) {
						return hyperLinkObject.getIsDefault();
					};
				};

				Iterable<HyperlinkObject> defaultHyperLinksIterable = Iterables.filter(hyperLinkObjectList, filterDefaultHyperlinks);
				int defaultHyperLinksCount = Iterables.size(defaultHyperLinksIterable);
				final ArrayList<HyperlinkObject> defaultHyperLinkObject = Lists.newArrayList(defaultHyperLinksIterable);

				if(defaultHyperLinksCount == 0) {
					final View shapeAsView = (View) shape;
					Command command = new Command() {

						@Override
						public void execute() {
							HyperLinkManagerShell hyperLinkManagerShell = new AdvancedHLManager(getEditorRegistry(), ((IGraphicalEditPart)getHost()).getEditingDomain(), (Element)gep.getNotationView().getElement(), shapeAsView, topPackage((Element)semanticElement), finalHyperlinkHelperFactory);
							hyperLinkManagerShell.setInput(hyperLinkObjectList);
							hyperLinkManagerShell.open();
						}
					};
					return command;
				}
				if(defaultHyperLinksCount == 1) {
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
				if(defaultHyperLinksCount > 1) {
					// open a dialog to choose a diagram
					DiagramNavigationDialog diagramNavigationDialog = new DiagramNavigationDialog(new Shell(), defaultHyperLinkObject);
					diagramNavigationDialog.open();
					final ArrayList<HyperlinkObject> hList = diagramNavigationDialog.getSelectedHyperlinks();
					Command command = new Command() {

						@Override
						public void execute() {
							super.execute();

							Iterator<HyperlinkObject> iter = hList.iterator();
							while(iter.hasNext()) {
								HyperlinkObject hyperlinkObject = (HyperlinkObject)iter.next();
								hyperlinkObject.executeSelectPressed();
							}
						}
					};
					return command;

				}
			}
		} catch (Exception e) {
			org.eclipse.papyrus.diagram.common.Activator.log.error("Impossible to load hyperlinks", e);
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

	protected IPageIconsRegistry getEditorRegistry() {
		if(editorRegistry == null) {
			editorRegistry = createEditorRegistry();
		}
		return editorRegistry;
	}

}
