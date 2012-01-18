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
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.adapter;

import org.eclipse.e4.ui.css.core.dom.ElementAdapter;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class GMFCSSAdapter extends ElementAdapter implements NodeList {

	/**
	 * The UML Element associated to the current styled element
	 * Might also be a GMF Diagram
	 */
	private EObject semanticElement;

	/**
	 * The current GMF Element
	 */
	private EObject notationElement;

	private String namespaceURI;

	private String localName;

	/**
	 * The css id property
	 */
	public static final String CSS_GMF_ID_KEY = "Papyrus.GMF.ID";

	/**
	 * The css class property
	 */
	public static final String CSS_GMF_CLASS_KEY = "Papyrus.GMF.Class";

	/**
	 * The css style property
	 */
	public static final String CSS_GMF_STYLE_KEY = "Papyrus.GMF.Style";

	/**
	 * The name of the EAnnotation containing css informations
	 * 
	 * @see CSS_GMF_ID_KEY
	 * @see CSS_GMF_CLASS_KEY
	 * @see CSS_GMF_STYLE_KEY
	 */
	public static final String CSS_ANNOTATION = "Papyrus.GMF.Style";

	public static String getCSSID(EObject sourceElement) {
		return getCSSValue(sourceElement, CSS_GMF_ID_KEY);
	}

	public static String getCSSClass(EObject sourceElement) {
		return getCSSValue(sourceElement, CSS_GMF_CLASS_KEY);
	}

	public static String getCSSStyle(EObject sourceElement) {
		return getCSSValue(sourceElement, CSS_GMF_STYLE_KEY);
	}

	public static EAnnotation getStyleAnnotation(EModelElement modelElement) {
		if(modelElement == null) {
			return null;
		}

		return modelElement.getEAnnotation(CSS_ANNOTATION);
	}

	private static String getCSSValue(EObject sourceElement, String key) {
		EModelElement modelElement = findModelElement(sourceElement);
		EAnnotation annotation = getStyleAnnotation(modelElement);
		if(annotation == null) {
			return null;
		}

		return annotation.getDetails().get(key);
	}

	private static EModelElement findModelElement(EObject sourceElement) {
		if(sourceElement == null) {
			return null;
		}

		if(sourceElement instanceof EModelElement) {
			return (EModelElement)sourceElement;
		}

		return findModelElement(sourceElement.eContainer());
	}

	public GMFCSSAdapter(EObject eObject, CSSEngine engine) {
		super(eObject, engine);

		notationElement = eObject;
	}

	private EObject findSemanticElement(final EObject notationElement) {
		if(notationElement instanceof Diagram) {
			return notationElement;
		}

		EObject currentElement = notationElement;

		do {
			if(currentElement instanceof View) {
				View view = (View)currentElement;
				return view.getElement();
			}
			currentElement = currentElement.eContainer();
		} while(currentElement != null);

		Activator.log.warn("Cannot find a valid source for " + notationElement);
		return notationElement;
	}

	private EObject getSemanticElement() {
		if(semanticElement == null) {
			semanticElement = findSemanticElement(notationElement);
		}
		return semanticElement;
	}

	public Node getParentNode() {
		return (Node)notationElement.eContainer();
	}

	public NodeList getChildNodes() {
		return this;
	}

	public String getNamespaceURI() {
		return EMFHelper.getQualifiedName(getSemanticElement().eClass(), ".");
	}

	public String getCSSId() {
		return getCSSID(notationElement);
	}

	public String getCSSClass() {
		return getCSSClass(notationElement);
	}

	public String getCSSStyle() {
		return getCSSStyle(notationElement);
	}

	@Override
	public String getLocalName() {
		return getSemanticElement().eClass().getName();
	}

	@Override
	public String getAttribute(String attr) {
		EStructuralFeature feature = notationElement.eClass().getEStructuralFeature(attr);
		if(feature != null) {
			Object value = notationElement.eGet(feature);
			if(value != null) {
				return value.toString();
			}
		}

		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Returns the GMF EObject handled by this adapter
	 */
	@Override
	public EObject getNativeWidget() {
		return notationElement;
	}



	/////////////
	//Node List//
	/////////////



	public Node item(int index) {
		//TODO Some contained elements may not be Nodes
		return (Node)notationElement.eContents().get(index);
	}

	public int getLength() {
		//TODO Some contained elements may not be Nodes
		return notationElement.eContents().size();
	}

}
