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
package org.eclipse.papyrus.infra.gmfdiag.css.dom;

import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles.CSS_DIAGRAM_STYLESHEETS_KEY;
import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles.CSS_GMF_CLASS_KEY;
import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles.CSS_GMF_ID_KEY;
import static org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSStyles.CSS_GMF_STYLE_KEY;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.e4.ui.css.core.dom.ElementAdapter;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringListValueStyle;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.SemanticElementHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.listener.CustomStyleListener;
import org.eclipse.papyrus.infra.gmfdiag.common.types.NotationTypesMap;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSDOMSemanticElementHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.StatefulView;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * An Adapter for providing a CSS support to GMF Objects
 *
 * @author Camille Letavernier
 */
@SuppressWarnings("restriction")
public class GMFElementAdapter extends ElementAdapter implements NodeList, IChangeListener, StatefulView {

	public static final String CSS_VALUES_SEPARATOR = " "; //$NON-NLS-1$

	/**
	 * The Semantic Model Element associated to the current styled element
	 * Might also be a GMF Diagram
	 */
	protected EObject semanticElement;

	/**
	 * The current GMF Element
	 */
	protected View notationElement;

	/**
	 * The namespace URI of the semanticElement
	 */
	protected String namespaceURI;

	/**
	 * The unqualified name of the semantic Element
	 */
	protected String localName;

	/**
	 * The list of child nodes for this element
	 */
	protected Node[] children;

	/**
	 * The parent node of this element
	 */
	protected Node parentNode;

	/**
	 * A Listener for standard Style properties
	 */
	protected Adapter styleListener;

	/**
	 * A Listener for custom Style properties
	 */
	protected CustomStyleListener cssStyleListener;

	/**
	 * Returns the CSS ID of the selected element.
	 *
	 * @param sourceElement
	 *        The source element must be a GMF notation object (View, Style, ...)
	 * @return
	 *         The CSS ID associated to the source element, or null if it cannot be found
	 */
	public static String getCSSID(EObject sourceElement) {
		return getCSSValue(sourceElement, CSS_GMF_ID_KEY);
	}

	/**
	 * Returns the CSS Class of the selected element. If more than one CSS
	 * class is associated to the source elements, returns a String containing
	 * all classes, separated with spaces.
	 *
	 * @param sourceElement
	 *        The source element must be a GMF notation object (View, Style, ...)
	 * @return
	 *         The CSS Class associated to the source element, or null if it cannot be found
	 */
	public static String getCSSClass(EObject sourceElement) {
		List<String> allClasses = getCSSValues(sourceElement, CSS_GMF_CLASS_KEY);
		return ListHelper.deepToString(allClasses, " "); //$NON-NLS-1$
	}

	/**
	 * Returns the source element's local CSS style.
	 *
	 * @param sourceElement
	 *        The source element must be a GMF notation object (View, Style, ...)
	 * @return
	 *         the source element's local CSS style.
	 */
	public static String getCSSStyle(EObject sourceElement) {
		return getCSSValue(sourceElement, CSS_GMF_STYLE_KEY);
	}

	private static String getCSSValue(EObject sourceElement, String key) {
		StringValueStyle style = (StringValueStyle)findStyle(sourceElement, key, NotationPackage.eINSTANCE.getStringValueStyle());
		if(style == null) {
			return null;
		}

		return style.getStringValue();
	}

	@SuppressWarnings("unchecked")
	private static List<String> getCSSValues(EObject sourceElement, String key) {
		StringListValueStyle style = (StringListValueStyle)findStyle(sourceElement, key, NotationPackage.eINSTANCE.getStringListValueStyle());
		if(style == null) {
			return Collections.emptyList();
		}


		return style.getStringListValue();
	}

	private static NamedStyle findStyle(EObject sourceElement, String key, EClass type) {
		View view = findView(sourceElement);
		if(view == null) {
			return null;
		}

		return view.getNamedStyle(type, key);
	}

	private static View findView(EObject sourceElement) {
		if(sourceElement == null) {
			return null;
		}

		if(sourceElement instanceof View) {
			return (View)sourceElement;
		}

		return findView(sourceElement.eContainer());
	}

	/**
	 * Creates a new GMF Element Adapter for the requested view.
	 *
	 * @param view
	 *        The view to be adapted
	 * @param engine
	 *        The associated CSS Engine
	 */
	public GMFElementAdapter(View view, ExtendedCSSEngine engine) {
		super(view, engine);

		//Bug 431694: Don't instantiate an ElementAdapter for an Orphaned view
		if(view == null || view.getDiagram() == null) {
			throw new IllegalArgumentException("Cannot handle orphaned view : " + view);
		}

		notationElement = view;
		listenNotationElement();
	}

	/**
	 * Returns the semantic element associated to this adapter. In case of a diagram,
	 * the diagram is itself the semantic element.
	 *
	 * @return
	 *         The semantic element associated to this adapter
	 */
	public EObject getSemanticElement() {
		if(semanticElement == null) {
			semanticElement = CSSDOMSemanticElementHelper.findSemanticElement(notationElement);
			computePseudoInstances();
			listenSemanticElement();
		}
		return semanticElement;
	}

	private void computePseudoInstances() {
		if(CSSDOMSemanticElementHelper.isFloatingLabel(notationElement)) {
			String humanType = NotationTypesMap.instance.getHumanReadableType(notationElement);
			if(humanType == null) {
				humanType = notationElement.getType();
			}

			pseudoInstances.add(new StringIgnoreCase(humanType));
		}
	}

	private Adapter getStyleListener() {
		if(styleListener == null) {
			styleListener = new StyleListener(this);
		}
		return styleListener;
	}

	private void listenNotationElement() {
		notationElement.eAdapters().add(getStyleListener());

		Collection<String> cssStyles = Arrays.asList(new String[]{ CSS_GMF_CLASS_KEY, CSS_GMF_ID_KEY, CSS_GMF_STYLE_KEY, CSS_DIAGRAM_STYLESHEETS_KEY });

		notationElement.eAdapters().add(cssStyleListener = new CustomStyleListener(notationElement, this, cssStyles));
	}

	private ExtendedCSSEngine getEngine() {
		return (ExtendedCSSEngine)engine;
	}

	private void listenSemanticElement() {
		//FIXME: The semantic hierarchy is never refresh (children & parentNode)
		if(semanticElement != null) {
			semanticElement.eAdapters().add(getStyleListener());
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * Returns the first parent Notation Element representing a different semantic object
	 * than self.
	 */
	@Override
	public Node getParentNode() {
		if(parentNode == null) {
			View gmfElement = notationElement;
			while(gmfElement != null) {
				EObject semanticElement = CSSDOMSemanticElementHelper.findSemanticElement(gmfElement);

				if(semanticElement != this.getSemanticElement()) {
					break;
				}

				EObject container = gmfElement.eContainer();

				if(gmfElement == container || !(container instanceof View)) {
					gmfElement = null;
					break;
				}

				gmfElement = (View)container;
			}

			parentNode = engine.getElement(gmfElement);
			if(parentNode == this) {
				return parentNode = null;
			}
		}

		return parentNode;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NodeList getChildNodes() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNamespaceURI() {
		if(namespaceURI == null) {
			namespaceURI = EMFHelper.getQualifiedName(getSemanticElement().eClass().getEPackage(), ".");
		}
		return namespaceURI;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCSSId() {
		return getCSSID(notationElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCSSClass() {
		return getCSSClass(notationElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCSSStyle() {
		return getCSSStyle(notationElement);
	}

	/**
	 * {@inheritDoc}
	 *
	 * The local name is either the diagram type (For a Diagram) or the name of the semantic
	 * element's metaclass
	 */
	@Override
	public String getLocalName() {
		if(localName == null) {
			if(getSemanticElement() instanceof Diagram) {
				Diagram diagram = (Diagram)getSemanticElement();
				String type = diagram.getType();

				String humanType = NotationTypesMap.instance.getHumanReadableType(diagram);
				if(humanType != null) {
					localName = humanType;
				} else {
					localName = type;
				}
			} else if(getNotationElement() instanceof BasicCompartment) {
				return "Compartment";
			} else if(CSSDOMSemanticElementHelper.isFloatingLabel(getNotationElement())) {
				return "Label";
			} else {
				localName = getSemanticElement().eClass().getName();
			}
		}

		return localName;
	}

	/**
	 * {@inheritDoc}
	 *
	 * The attributes are the semantic's element features
	 */
	@Override
	public final String getAttribute(String attr) {
		String value = doGetAttribute(attr);
		if(value != null) {
			return value;
		}

		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * The attributes are the semantic's element features
	 *
	 * Returns null if the attribute is not known
	 */
	protected String doGetAttribute(String attr) {
		if(notationElement instanceof BasicCompartment) {
			//Compartments can be filtered by type (notation::View::type), or by title (From GmfGen model)
			//We add the "kind" attribute which is specific to the CSS (More user-friendly)
			if("kind".equals(attr)) {

				BasicCompartment compartment = (BasicCompartment)notationElement;
				String humanType = NotationTypesMap.instance.getHumanReadableType(compartment);
				if(humanType == null) {
					return compartment.getType();
				}
				return humanType; //7017, 7018, 7019 for Attribute/Operation/Classifier compartments
				//TODO: Create a mapping list between GMF ID (Type) and user-readable labels
			}
		}

		EStructuralFeature feature = getSemanticElement().eClass().getEStructuralFeature(attr);

		if(feature != null) {
			if(feature.isMany()) {
				List<?> values = (List<?>)semanticElement.eGet(feature);
				List<String> cssValues = new LinkedList<String>();
				for(Object value : values) {
					if(value != null) {
						cssValues.add(getCSSValue(feature, value));
					}
				}
				return ListHelper.deepToString(cssValues, CSS_VALUES_SEPARATOR);
			} else {
				Object value = semanticElement.eGet(feature);
				if(value != null) {
					return getCSSValue(feature, value);
				}
			}
		}

		return null;
	}

	/**
	 * Returns the value of the given feature as a formatted String (Valid w.r.t CSS Syntax)
	 * Used by {@link #doGetAttribute(String)}
	 *
	 * Return null if the feature is not supported or the value cannot be converted to a String
	 *
	 * @param feature
	 * @param value
	 * @return
	 */
	protected String getCSSValue(EStructuralFeature feature, Object value) {
		if(value == null) {
			return null;
		}

		if(feature instanceof EReference && value instanceof ENamedElement) {
			return ((ENamedElement)value).getName();
		}

		//Standard case. For EObject values, it might be better to return null than a random label...
		return value.toString();
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



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Node item(int index) {
		return getChildren()[index];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLength() {
		return getChildren().length;
	}

	protected Node[] getChildren() {
		if(children == null) {
			children = computeChildren(notationElement, engine);
		}

		return children;
	}

	/**
	 * Returns the list of notation child elements attached to semantic
	 * elements different than self's semantic element.
	 *
	 * If a notation child element represents the same semantic element
	 * than self, returns its own children (Recursively).
	 */
	protected static Node[] computeChildren(View notationElement, CSSEngine engine) {
		EObject semanticElement = CSSDOMSemanticElementHelper.findSemanticElement(notationElement);
		List<Node> childList = new LinkedList<Node>();
		for(EObject child : notationElement.eContents()) {
			if(child instanceof View) {
				View notationChild = (View)child;
				if(SemanticElementHelper.findSemanticElement(notationChild) != semanticElement) {
					childList.add(engine.getElement(notationChild));
				} else {
					//This is the same semantic element (e.g. label). Compute indirect children, if any
					childList.addAll(Arrays.asList(computeChildren(notationChild, engine)));
				}
			}
		}

		/*
		 * <--------------------
		 * 
		 * //Allows both notations Class > Property and Class > Compartment > Property
		 * 
		 * //FIXME: The Tree is computed through "getParentNode". "getChildren" is barely used. Moreover,
		 * //there is a mapping between Notation element and DOM element, which makes it impossible to associate the same
		 * //notation element to different DOM elements.
		 * 
		 * // for(EObject child : notationElement.eContents()) {
		 * // if(child instanceof BasicCompartment) {
		 * // //Add the Compartment's children to this' children
		 * // childList.addAll(Arrays.asList(computeChildren((View)child, engine)));
		 * // }
		 * // }
		 * 
		 * -------------------->
		 */

		return childList.toArray(new Node[childList.size()]);
	}

	//////////////////////
	//	Handle events	//
	//////////////////////


	/**
	 * The GMF View element associated to this adapter
	 *
	 * @return
	 *         The GMF View element associated to this adapter
	 */
	public View getNotationElement() {
		return notationElement;
	}

	/**
	 * Handles a notification for semantic element change.
	 * Source: styleListener
	 */
	public void semanticElementChanged() {
		if(semanticElement != null && semanticElement != notationElement) {
			semanticElement.eAdapters().remove(styleListener);
			semanticElement = null;
		}

		localName = null;
		parentNode = null;
		namespaceURI = null;
		children = null;
		getEngine().notifyChange(this);
	}

	/**
	 * Handles a notification for Custom style change.
	 * Source: cssStyleListener
	 */
	//Change incoming from one of the cssCustomStyles (class, id, local style or diagram stylesheets)
	@Override
	public void handleChange(ChangeEvent event) {
		if(notationElement instanceof CSSDiagram) {
			//TODO: Use a finer grained event (We should reset only when the
			//change occurs on a DiagramStyleSheet)
			getEngine().reset();
		}

		//Notify the CSS Engine
		getEngine().notifyChange(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		super.dispose();
		notationElement.eAdapters().remove(cssStyleListener);
		cssStyleListener.dispose();

		notationElement.eAdapters().remove(styleListener);

		if(semanticElement != null) {
			semanticElement.eAdapters().remove(styleListener);
		}
	}

	/**
	 * Handles a notification for notation property change
	 * Source : styleListener
	 */
	public void notationPropertyChanged() {
		//Notify the CSSEngine
		getEngine().notifyChange(this);
	}

	/**
	 * Handles a notification for semantic property change
	 * Source : styleListener
	 */
	public void semanticPropertyChanged() {
		//Notify the CSSEngine
		getEngine().notifyChange(this);
	}

	/**
	 * Handles a notification for notation element disposed
	 * Source : styleListener
	 */
	public void notationElementDisposed() {
		dispose();
		//Notify the CSSEngine
		getEngine().handleDispose(notationElement);
	}

	private final Set<StringIgnoreCase> pseudoInstances = new HashSet<StringIgnoreCase>();

	private final static class StringIgnoreCase {

		private final String sourceString;

		private final String sourceStringToLower;

		public StringIgnoreCase(String source) {
			this.sourceString = source;
			this.sourceStringToLower = source == null ? null : source.toLowerCase();
		}

		@Override
		public boolean equals(Object other) {
			if(other instanceof String) {
				return ((String)other).equalsIgnoreCase(sourceString);
			}

			if(other instanceof StringIgnoreCase) {
				return equals(((StringIgnoreCase)other).sourceString);
			}

			return false;
		}

		@Override
		public int hashCode() {
			if(sourceStringToLower == null) {
				return 0;
			}

			return sourceStringToLower.hashCode();
		}

		@Override
		public String toString() {
			return sourceStringToLower;
		}

	}

	@Override
	public boolean isPseudoInstanceOf(String pseudo) {
		return pseudoInstances.contains(new StringIgnoreCase(pseudo));
	}


	//The following methods (Static pseudo instances) are not supported.

	@Override
	public void addStaticPseudoInstance(String pseudo) {
		//Disable the super implementation. Static pseudo instances are not supported.
		throw new UnsupportedOperationException();
	}

	@Override
	public String[] getStaticPseudoInstances() {
		return new String[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.notation.StatefulView#addStates(java.util.Set)
	 */
	@Override
	public void addStates(Set<String> states) {
		for(String state : states) {
			this.pseudoInstances.add(new StringIgnoreCase(state));
		}
		getEngine().notifyChange(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.css.notation.StatefulView#removeStates(java.util.Set)
	 */
	@Override
	public void removeStates(Set<String> states) {
		for(String state : states) {
			this.pseudoInstances.remove(new StringIgnoreCase(state));
		}
		getEngine().notifyChange(this);
	}

	@Override
	public Set<String> getStates() {
		Set<String> result = new HashSet<String>();
		for(StringIgnoreCase element : pseudoInstances) {
			result.add(element.toString());
		}
		return result;
	}
}
