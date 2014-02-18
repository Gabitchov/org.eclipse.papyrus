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
package org.eclipse.papyrus.infra.gmfdiag.css.command;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles;


public class ResetStyleCommand extends RecordingCommand {

	private static Set<String> papyrusStyleAnnotations = new HashSet<String>();

	static {
		papyrusStyleAnnotations.add(VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON);
		papyrusStyleAnnotations.add(VisualInformationPapyrusConstants.SHADOWFIGURE);
		papyrusStyleAnnotations.add(VisualInformationPapyrusConstants.QUALIFIED_NAME);
		papyrusStyleAnnotations.add(VisualInformationPapyrusConstants.CUSTOM_APPEARENCE_ANNOTATION);
	}

	private Iterator<?> iterator;

	public ResetStyleCommand(TransactionalEditingDomain domain, Iterator<?> iterator) {
		super(domain);
		this.iterator = iterator;
	}

	@Override
	public void doExecute() {
		while(iterator.hasNext()) {
			Object selectedItem = iterator.next();
			View view = NotationHelper.findView(selectedItem);
			if(view == null) {
				continue;
			}

			if(view instanceof Diagram) {
				resetDiagram((Diagram)view);
				break;
			} else {
				//Reset the style attribute to their default value
				resetStyle(view, true);
			}
		}
	}

	private void resetDiagram(Diagram diagram) {
		for(Object viewObject : diagram.getChildren()) {
			if(viewObject instanceof View) {
				resetStyle((View)viewObject, true);
			}
		}
		for(Object lineObject : diagram.getEdges()) {
			if(lineObject instanceof View) {
				resetStyle((View)lineObject, true);
			}
		}
	}

	private void resetStyle(View view, boolean recursive) {
		resetStyle(view);
		if(recursive) {
			for(Object childObject : view.getChildren()) {
				if(childObject instanceof View) {
					resetStyle((View)childObject, recursive);
				}
			}
		}
	}

	private void resetStyle(View view) {
		//Reset the view (Except for volatile/transient elements which are already derived, e.g. Stereotype compartments)
		if(view.eContainingFeature().isTransient()) {
			return;
		}

		Iterator<?> styleIterator = view.getStyles().iterator();
		while(styleIterator.hasNext()) {
			Object styleObject = styleIterator.next();
			if(styleObject instanceof NamedStyle) {
				NamedStyle customStyle = (NamedStyle)styleObject;

				if(!CSSStyles.RESERVED_KEYWORDS.contains(customStyle.getName())) {

					//Remove only NamedStyle which are supported by the CSS Implementation
					//See org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSViewDelegate.getCSSNamedStyle(EClass, String)
					//See Bug 425190 - [CSS] Loss of Notation information when CSS style is applied on Edges.
					switch(customStyle.eClass().getClassifierID()) {
					case NotationPackage.STRING_VALUE_STYLE:
					case NotationPackage.BOOLEAN_VALUE_STYLE:
					case NotationPackage.INT_VALUE_STYLE:
					case NotationPackage.DOUBLE_VALUE_STYLE:
					case NotationPackage.STRING_LIST_VALUE_STYLE:
						styleIterator.remove();
					}

				}
			} else if(styleObject instanceof Style) {
				resetStyle((Style)styleObject);
			}
		}

		if(view instanceof Style) {
			resetStyle((Style)view);
		}

		//Remove the "forceValue" annotations
		resetAnnotations(view);
		//Remove the Papyrus Style EAnnotations
		resetStyleAnnotations(view);

		//Reset the visibility
		view.eUnset(NotationPackage.eINSTANCE.getView_Visible());
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
				style.eUnset(feature);
			}
		}
	}

	//Resets the "Force Value" annotations (Tags to indicate that the user
	//has manually selected a value, which will override the CSS Style)
	private void resetAnnotations(View view) {
		Iterator<EAnnotation> iterator = view.getEAnnotations().iterator();
		while(iterator.hasNext()) {
			if(CSSAnnotations.CSS_FORCE_VALUE.equals(iterator.next().getSource())) {
				iterator.remove();
			}
		}
	}

	//Resets the "Custom style" Annotations (elementIcon, shadow, qualifiedName)
	private void resetStyleAnnotations(View view) {
		Iterator<EAnnotation> iterator = view.getEAnnotations().iterator();
		while(iterator.hasNext()) {
			if(papyrusStyleAnnotations.contains(iterator.next().getSource())) {
				iterator.remove();
			}
		}
	}
}
