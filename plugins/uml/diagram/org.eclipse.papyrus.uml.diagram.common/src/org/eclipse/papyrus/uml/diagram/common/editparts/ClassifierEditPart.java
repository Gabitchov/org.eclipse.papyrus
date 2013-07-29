/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ClassifierFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.BasicClassifierCompartmentLayoutHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Classifier edit part.
 * 
 * @author tlandre
 */
public abstract class ClassifierEditPart extends NamedElementEditPart {

	/**
	 * isAbstract Classifier property
	 */
	private boolean isAbstract;

	/**
	 * Constructor
	 * 
	 * @param view
	 */
	public ClassifierEditPart(View view) {
		super(view);
		setCompartmentLayoutHelper(BasicClassifierCompartmentLayoutHelper.getInstances());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();
		if(resolveSemanticElement() != null) {
			// Manage isAbstract
			if(UMLPackage.eINSTANCE.getClassifier_IsAbstract().equals(feature)) {
				isAbstract = notification.getNewBooleanValue();
				refreshFont();
			}
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		if(getPrimaryShape() != null && resolveSemanticElement() != null) {
			refreshAbstract();
			refreshIsActive();
		}
	}

	protected void refreshIsActive() {
		if(getUMLElement() instanceof org.eclipse.uml2.uml.Class) {
			if(getPrimaryShape() instanceof ClassifierFigure) {
				((ClassifierFigure)getPrimaryShape()).setActive(((org.eclipse.uml2.uml.Class)getUMLElement()).isActive());
			}
		}
	}

	protected void refreshAbstract() {
		if(getUMLElement() instanceof Classifier) {
			isAbstract = ((Classifier)getUMLElement()).isAbstract();
			refreshFont();

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected FontData getFontData(FontStyle style) {
		FontData data = super.getFontData(style);
		if(isAbstract) {
			data.setStyle(data.getStyle() | SWT.ITALIC); //Force the Italic flag
		} else {
			data.setStyle(data.getStyle() & ~SWT.ITALIC); //Remove the Italic flag
		}
		return data;
	}

}
