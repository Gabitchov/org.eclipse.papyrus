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
package org.eclipse.papyrus.properties.uml.widgets;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.profile.tree.objects.StereotypedElementTreeObject;
import org.eclipse.papyrus.profile.ui.compositeforview.AppliedStereotypeCompositeWithView;
import org.eclipse.papyrus.profile.ui.compositeforview.AppliedStereotypePropertyCompositeWithView;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.uml.modelelement.StereotypeApplicationModelElement;
import org.eclipse.papyrus.properties.widgets.AbstractPropertyEditor;
import org.eclipse.papyrus.properties.widgets.layout.PropertiesLayout;
import org.eclipse.papyrus.widgets.editors.AbstractEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.Element;


public class StereotypeApplication extends AbstractPropertyEditor {

	private AppliedStereotypeCompositeWithView stereotypeComposite;

	private AppliedStereotypePropertyCompositeWithView propertyComposite;

	private Composite self;

	public StereotypeApplication(Composite parent, int style) {
		self = new Composite(parent, style);
		self.setLayout(new PropertiesLayout(2, true));

		stereotypeComposite = new AppliedStereotypeCompositeWithView(self);
		stereotypeComposite.createContent(self, AbstractEditor.factory);

		propertyComposite = new AppliedStereotypePropertyCompositeWithView(self, stereotypeComposite);
		propertyComposite.createContent(self, AbstractEditor.factory);

		stereotypeComposite.setPropertyComposite(propertyComposite);
	}

	@Override
	protected void doBinding() {
		// No Databinding here ; the AppliedStereotypeCompositeWithView is responsible
		// for editing the data
		ModelElement element = input.getModelElement(propertyPath);
		if(element instanceof StereotypeApplicationModelElement) {
			StereotypeApplicationModelElement modelElement = (StereotypeApplicationModelElement)element;

			View diagramElement = (View)modelElement.getGraphicalElement();
			//EditPart editPart = ((StereotypeApplicationModelElement)element).getEditPart();
			Element umlElement = modelElement.getUMLElement();

			//stereotypeComposite.setSelection(new StructuredSelection(Collections.singletonList(editPart)));
			stereotypeComposite.setElement(umlElement);
			stereotypeComposite.setInput(new StereotypedElementTreeObject(umlElement));
			stereotypeComposite.setDiagramElement(diagramElement);

			stereotypeComposite.refresh();
		}
	}
}
