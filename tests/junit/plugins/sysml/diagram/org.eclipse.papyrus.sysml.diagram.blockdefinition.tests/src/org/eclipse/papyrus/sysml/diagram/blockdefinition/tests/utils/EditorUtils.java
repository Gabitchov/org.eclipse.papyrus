/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Tool;
import org.eclipse.gef.util.EditPartUtilities;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.BlockDefinitionDiagramForMultiEditor;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.factory.DiagramPaletteFactory;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public class EditorUtils {

	public static BlockDefinitionDiagramForMultiEditor getDiagramEditor() throws Exception {

		ServicesRegistry serviceRegistry = (ServicesRegistry)getEditor().getAdapter(ServicesRegistry.class);
		try {
			return (BlockDefinitionDiagramForMultiEditor)ServiceUtils.getInstance().getNestedActiveIEditorPart(serviceRegistry);

		} catch (ServiceException e) {
			throw new Exception("Unable to retrieve service.", e);
		} catch (ClassCastException e) {
			throw new Exception("Active diagram is not a BDD.", e);
		}
	}

	public static DiagramEditPart getDiagramEditPart() throws Exception {

		try {
			return getDiagramEditor().getDiagramEditPart();

		} catch (NullPointerException e) {
			throw new Exception("Could not find diagram edit part.", e);
		}
	}

	public static Diagram getDiagramView() throws Exception {

		try {
			return getDiagramEditor().getDiagram();

		} catch (NullPointerException e) {
			throw new Exception("Could not find diagram view.", e);
		}
	}

	public static EditPart getEditPart(View view) throws Exception {

		// Test if the container is the diagram itself first
		if(getDiagramEditPart().getModel() == view) {
			return getDiagramEditPart();
		}

		// Test diagram children and look for the view
		@SuppressWarnings("unchecked")
		Iterator<EditPart> it = EditPartUtilities.getAllChildren(getDiagramEditPart()).iterator();
		while(it.hasNext()) {
			EditPart editPart = it.next();
			if(editPart.getModel() == view) {
				return editPart;
			}
		}

		// Test diagram nested connections and look for the view
		@SuppressWarnings("unchecked")
		Iterator<EditPart> itLinks = EditPartUtilities.getAllNestedConnectionEditParts(getDiagramEditPart()).iterator();
		while(itLinks.hasNext()) {
			EditPart editPart = itLinks.next();
			if(editPart.getModel() == view) {
				return editPart;
			}
		}

		throw new Exception("Unable to find edit part for the given view.");
	}

	public static Tool getPaletteTool(String toolId) throws Exception {
		DiagramPaletteFactory factory = new DiagramPaletteFactory();
		return factory.createTool(toolId);
	}

	public static IDiagramEditDomain getDiagramEditingDomain() throws Exception {
		return getDiagramEditor().getDiagramEditDomain();
	}

	public static DiagramCommandStack getDiagramCommandStack() throws Exception {
		return getDiagramEditingDomain().getDiagramCommandStack();
	}

	public static CommandStack getCommandStack() throws Exception {
		return getTransactionalEditingDomain().getCommandStack();
	}

	public static TransactionalEditingDomain getTransactionalEditingDomain() throws Exception {

		ServicesRegistry serviceRegistry = (ServicesRegistry)getEditor().getAdapter(ServicesRegistry.class);
		try {
			return (TransactionalEditingDomain)ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);

		} catch (ServiceException e) {
			throw new Exception("Unable to retrieve service.", e);
		}
	}

	public static IEditorPart getEditor() throws Exception {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}

	/**
	 * Returns the list of edit parts of the element with given parameters
	 * 
	 * @param parent
	 *        the parent edit part
	 * @param elementName
	 *        the name of the element, or <code>null</code>
	 * @param semanticHint
	 *        the semantic hint of the edit part to find
	 * @param deepSearch
	 *        <code>true</code> if all the content should be looked, not only the direct children
	 * @param zeroAccepted
	 *        <code>true</code> if 0 Edit Part is a valid result. If <code>false</code>, at least one edit part should be found
	 * @param severalAccepted
	 *        <code>true</code> if more than one Edit Part is a valid result. If <code>false</code>, not more than one edit part should be found
	 * @return the edit part found or <code>null</code> if none was found and zeroAccepted was <code>true</code>
	 * @throws Exception
	 *         exception thrown in case of problem
	 */
	public static IGraphicalEditPart getEditPart(IGraphicalEditPart parent, String elementName, String semanticHint, boolean deepSearch, boolean zeroAccepted, boolean severalAccepted) throws Exception {
		List<IGraphicalEditPart> results = new ArrayList<IGraphicalEditPart>();
		findEditParts(parent, elementName, semanticHint, deepSearch, results);
		
		// convert into a list of unique elements
		Set<IGraphicalEditPart> set = new LinkedHashSet<IGraphicalEditPart>(results);
		List<IGraphicalEditPart> uniqueResults = new ArrayList<IGraphicalEditPart>(set);

		if(uniqueResults.size() == 0) {
			if(zeroAccepted) {
				return null;	
			}
			throw new RuntimeException("At least one element was expected for parent "+parent+"\n element name: "+elementName+"\n semantic hint: "+semanticHint+"\n deep search allowed "+deepSearch);
		}
		
		if(uniqueResults.size() > 1) {
			if(!severalAccepted) {
				throw new RuntimeException("Not more than one element was expected for parent " + parent + "\n element name: " + elementName + "\n semantic hint: " + semanticHint + "\n deep search allowed " + deepSearch);
			} else {
				return uniqueResults.get(0);
			}
		}

		return uniqueResults.get(0);
	}
	
	/**
	 * retrieves the list of edit parts of the element with given parameters and adds it to the list of results
	 * 
	 * @param parent
	 *        the parent edit part
	 * @param elementName
	 *        the name of the element, or <code>null</code>
	 * @param semanticHint
	 *        the semantic hint of the edit part to find
	 * @param deepSearch
	 *        <code>true</code> if all the content should be looked, not only the direct children
	 * @param results
	 *        the list of results to complete
	 * @throws Exception
	 *         exception thrown in case of problem
	 */
	public static void findEditParts(IGraphicalEditPart parent, String elementName, String semanticHint, boolean deepSearch, List<IGraphicalEditPart> results) throws Exception {
		Iterator<EditPart> childrenIterator = EditPartUtilities.getAllChildren(parent).iterator();
		while(childrenIterator.hasNext()) {
			EditPart part = childrenIterator.next();
			if(part instanceof IGraphicalEditPart && part instanceof IPrimaryEditPart) {
				IGraphicalEditPart graphicalEditPart = (IGraphicalEditPart)part;
				Object model = graphicalEditPart.getModel();
				if(model instanceof View) {
					String type = ((View)model).getType();
					if(semanticHint != null) {
						if(semanticHint.equals(type)) {
							// test name
							String name = (EMFCoreUtil.getName(((View)model).getElement()));
							if(elementName != null) {
								if(elementName.equals(name)) {
									results.add(graphicalEditPart);
								}
							} else {
								results.add(graphicalEditPart);
							}
						}
					} else { // no interest in semantic hint. Check By name, which should not be null in this case 
						String name = EMFCoreUtil.getName(((View)model).getElement());
						if(elementName != null) {
							if(elementName.equals(name)) {
								results.add(graphicalEditPart);
							}
						} else {
							throw new Exception("At least semantic hint or name should be given to look for an element");
						}
					}
				}
				if(deepSearch) {
					findEditParts(graphicalEditPart, elementName, semanticHint, deepSearch, results);
				}
			}
		}
	}
}
