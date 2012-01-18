package org.eclipse.papyrus.prototype.infra.gmfdiag.css.adapter;

import org.eclipse.e4.ui.css.core.dom.ElementAdapter;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class GMFCSSAdapter extends ElementAdapter implements NodeList {

	private EObject sourceElement;

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

		sourceElement = eObject;
		namespaceURI = computeNamespaceURI();
		localName = computeLocalName();
	}

	private String computeNamespaceURI() {
		return EMFHelper.getQualifiedName(sourceElement.eClass(), ".");
	}

	private String computeLocalName() {
		return sourceElement.eClass().getName();
	}

	public Node getParentNode() {
		return (Node)sourceElement.eContainer();
	}

	public NodeList getChildNodes() {
		return this;
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

	public String getCSSId() {
		return getCSSID(sourceElement);
	}

	public String getCSSClass() {
		return getCSSClass(sourceElement);
	}

	public String getCSSStyle() {
		return getCSSStyle(sourceElement);
	}

	@Override
	public String getLocalName() {
		return localName;
	}

	@Override
	public String getAttribute(String attr) {
		EStructuralFeature feature = sourceElement.eClass().getEStructuralFeature(attr);
		if(feature != null) {
			Object value = sourceElement.eGet(feature);
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
		return sourceElement;
	}



	/////////////
	//Node List//
	/////////////



	public Node item(int index) {
		//TODO Some contained elements may not be Nodes
		return (Node)sourceElement.eContents().get(index);
	}

	public int getLength() {
		//TODO Some contained elements may not be Nodes
		return sourceElement.eContents().size();
	}

}
