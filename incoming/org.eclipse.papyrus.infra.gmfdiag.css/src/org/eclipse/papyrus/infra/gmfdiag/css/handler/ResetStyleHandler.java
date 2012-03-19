/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.handler;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations;


/**
 * This handler resets all the local appearance to their default value
 * for a set of GMF Views.
 * 
 * @author Camille Letavernier
 */
public class ResetStyleHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection;
		try {
			selection = ServiceUtilsForActionHandlers.getInstance().getNestedActiveIEditorPart().getSite().getSelectionProvider().getSelection();
			if(selection.isEmpty()) {
				return null;
			}
		} catch (ServiceException ex) {
			// TODO Auto-generated catch block
			Activator.log.error(ex);
			return null;
		}

		if(!(selection instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection sSelection = (IStructuredSelection)selection;
		Iterator<?> iterator = sSelection.iterator();
		while(iterator.hasNext()) {
			Object selectedItem = iterator.next();
			View view = NotationHelper.findView(selectedItem);
			if(view == null) {
				continue;
			}

			//Remove the "forceValue" annotations
			resetAnnotations(view);

			//Reset the style attribute to their default value
			resetStyle(view);
		}

		return null;
	}

	private void resetStyle(View view) {
		for(Object styleObject : view.getStyles()) {
			if(styleObject instanceof Style) {
				resetStyle((Style)styleObject);
			}
		}
		if(view instanceof Style) {
			resetStyle((Style)view);
		}
	}

	private void resetStyle(Style style) {
		if(style instanceof NamedStyle) {
			//Skip custom styles. 
			//TODO: We should skip CSS Styles (CSSClass, CSSId, CSSStyle, DiagramStyleSheets),
			//and reset custom GMF Styles (elementIcon, shadow, ...). 
			//What about external custom styles (ie. unkwnown styles)?
			//They should be stylable, but they might contain something we don't want to reset...
			return;
		}

		for(EStructuralFeature feature : style.eClass().getEAllStructuralFeatures()) {
			//Only edit Style features
			if(NotationPackage.eINSTANCE.getStyle().isSuperTypeOf(feature.getEContainingClass())) {
				//Reset the value to default
				style.eSet(feature, feature.getDefaultValue());
			}
		}
	}

	private void resetAnnotations(View view) {
		Iterator<EAnnotation> iterator = view.getEAnnotations().iterator();
		while(iterator.hasNext()) {
			if(CSSAnnotations.CSS_FORCE_VALUE.equals(iterator.next().getSource())) {
				iterator.remove();
			}
		}
	}


}
