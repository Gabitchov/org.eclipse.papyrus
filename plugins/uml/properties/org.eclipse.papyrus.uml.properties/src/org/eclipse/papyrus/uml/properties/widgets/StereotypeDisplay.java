/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.Collections;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.uml.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.uml.properties.modelelement.UMLNotationModelElement;
import org.eclipse.papyrus.uml.properties.profile.ui.compositeforview.AppearanceForAppliedStereotypeComposite;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;


public class StereotypeDisplay extends AbstractPropertyEditor {

	private AppearanceForAppliedStereotypeComposite composite;

	public StereotypeDisplay(Composite parent, int style) {
		composite = new AppearanceForAppliedStereotypeComposite(parent);
		composite.createContent(parent, AbstractEditor.factory);
	}

	@Override
	protected void doBinding() {
		// No Databinding here ; the AppearanceForAppliedStereotypeComposite is responsible
		// for editing the data
		ModelElement element = input.getModelElement(propertyPath);
		if(element instanceof UMLNotationModelElement) {
			View diagramElement = (View)((UMLNotationModelElement)element).getEModelElement();
			EditPart editPart = ((UMLNotationModelElement)element).getEditPart();
			Element umlElement = (Element)diagramElement.getElement();

			composite.setSelection(new StructuredSelection(Collections.singletonList(editPart)));
			composite.setElement(umlElement);
			composite.setInput(new StereotypedElementTreeObject(umlElement));
			composite.setDiagramElement(diagramElement);

			composite.refresh();
		}
	}
}
