/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Assert;

/**
 * Utility class for diagrams
 */
public class DiagramUtils {

	public static IGraphicalEditPart findEditPartforView(IMultiDiagramEditor papyrusEditor, View view, Class<? extends EditPart> editPartClass) {
		DiagramEditPart diagramEditPart = findDiagramEditPart(papyrusEditor);
		Object part = diagramEditPart.getViewer().getEditPartRegistry().get(view);
		Assert.assertNotNull("Cannot find the edit part", part);
		Assert.assertNotNull("part has not the right class", editPartClass.isAssignableFrom(part.getClass()));
		return (IGraphicalEditPart) part;
	}

	public static DiagramEditPart findDiagramEditPart(IMultiDiagramEditor papyrusEditor) {
		DiagramEditPart diagramEditPart = (DiagramEditPart) papyrusEditor.getAdapter(DiagramEditPart.class);
		Assert.assertNotNull("Cannot find the Diagram edit part", diagramEditPart);
		return diagramEditPart;
	}

	/**
	 * Search and returns the first view in the specified container view with the given name
	 * 
	 * @param container
	 *            the view container of the searched view
	 * @param elementName
	 *            the name of the element represented by the search view
	 * @return the found view or <code>null</code> if none was found
	 */
	public static Shape findShape(View container, String elementName) {
		for (Object viewObject : container.getChildren()) {
			View view = (View) viewObject;
			if (view instanceof Shape && view.getElement() instanceof NamedElement) {
				NamedElement element = (NamedElement) view.getElement();
				if (elementName.equals(element.getName())) {
					return (Shape) view;
				}
			}
		}

		Assert.fail("Cannot find the view associated to " + elementName);
		return null;
	}

	/**
	 * Returns the int corresponding to the given tuple
	 * 
	 * @param red
	 * @param green
	 * @param blue
	 * @return
	 */
	public static int rgb(int red, int green, int blue) {
		return red | green << 8 | blue << 16;
	}

	public static Diagram getNotationDiagram(ModelSet modelSet, String string) {
		IModel notationModel = modelSet.getModel(NotationModel.MODEL_ID);

		AbstractBaseModel notationBaseModel = null;
		if (notationModel instanceof AbstractBaseModel) {
			notationBaseModel = (AbstractBaseModel) notationModel;
		} else {
			Assert.fail("notation model is not an abstract base model");
			return null;
		}
		Assert.assertTrue("notation resource contains nothing", notationBaseModel.getResource().getContents().size() >= 1);
		for (EObject object : notationBaseModel.getResource().getContents()) {
			if (object instanceof Diagram && string.equals(((Diagram) object).getName())) {
				return (Diagram) object;
			}
		}
		return null;
	}



}
