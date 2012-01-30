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
package org.eclipse.papyrus.prototype.infra.gmfdiag.css;


import org.eclipse.e4.ui.css.core.dom.CSSExtendedProperties;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.dom.GMFCSSAdapter;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.CSSShapeStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl.CSSShapeStyleImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;
import org.w3c.dom.css.CSSStyleDeclaration;

@SuppressWarnings("restriction")
public class GMFCSSShape extends ShapeImpl implements CSSStylableElement, CSSShapeStyle {

	protected CSSEngine engine;

	private CSSStylableElement cssAdapter;

	private CSSShapeStyle shapeStyle;

	public GMFCSSShape(CSSEngine engine) {
		this.engine = engine;
		this.cssAdapter = new GMFCSSAdapter(this, engine);
		this.shapeStyle = new CSSShapeStyleImpl(this, this, engine);
	}


	//////////////////////////////////////////
	//	Forwards accesses to CSS properties	//
	//////////////////////////////////////////

	public int getCSSFontColor() {
		if(eIsSet(NotationPackage.eINSTANCE.getFontStyle_FontColor())) {
			return super.getFontColor();
		} else {
			return shapeStyle.getCSSFontColor();
		}
	}

	public java.lang.String getCSSFontName() {
		if(eIsSet(NotationPackage.eINSTANCE.getFontStyle_FontName())) {
			return super.getFontName();
		} else {
			return shapeStyle.getCSSFontName();
		}
	}

	public int getCSSFontHeight() {
		if(eIsSet(NotationPackage.eINSTANCE.getFontStyle_FontHeight())) {
			return super.getFontHeight();
		} else {
			return shapeStyle.getCSSFontHeight();
		}
	}

	public boolean isCSSBold() {
		if(eIsSet(NotationPackage.eINSTANCE.getFontStyle_Bold())) {
			return super.isBold();
		} else {
			return shapeStyle.isCSSBold();
		}
	}

	public boolean isCSSItalic() {
		if(eIsSet(NotationPackage.eINSTANCE.getFontStyle_Italic())) {
			return super.isItalic();
		} else {
			return shapeStyle.isCSSItalic();
		}
	}

	public boolean isCSSUnderline() {
		if(eIsSet(NotationPackage.eINSTANCE.getFontStyle_Underline())) {
			return super.isUnderline();
		} else {
			return shapeStyle.isCSSUnderline();
		}
	}

	public boolean isCSSStrikeThrough() {
		if(eIsSet(NotationPackage.eINSTANCE.getFontStyle_StrikeThrough())) {
			return super.isStrikeThrough();
		} else {
			return shapeStyle.isCSSStrikeThrough();
		}
	}

	public java.lang.String getCSSDescription() {
		if(eIsSet(NotationPackage.eINSTANCE.getDescriptionStyle_Description())) {
			return super.getDescription();
		} else {
			return shapeStyle.getCSSDescription();
		}
	}

	public int getCSSFillColor() {
		if(eIsSet(NotationPackage.eINSTANCE.getFillStyle_FillColor())) {
			return super.getFillColor();
		} else {
			return shapeStyle.getCSSFillColor();
		}
	}

	public int getCSSTransparency() {
		if(eIsSet(NotationPackage.eINSTANCE.getFillStyle_Transparency())) {
			return super.getTransparency();
		} else {
			return shapeStyle.getCSSTransparency();
		}
	}

	public org.eclipse.gmf.runtime.notation.datatype.GradientData getCSSGradient() {
		if(eIsSet(NotationPackage.eINSTANCE.getFillStyle_Gradient())) {
			return super.getGradient();
		} else {
			return shapeStyle.getCSSGradient();
		}
	}

	public int getCSSLineColor() {
		if(eIsSet(NotationPackage.eINSTANCE.getLineStyle_LineColor())) {
			return super.getLineColor();
		} else {
			return shapeStyle.getCSSLineColor();
		}
	}

	public int getCSSLineWidth() {
		if(eIsSet(NotationPackage.eINSTANCE.getLineStyle_LineWidth())) {
			return super.getLineWidth();
		} else {
			return shapeStyle.getCSSLineWidth();
		}
	}

	public int getCSSRoundedBendpointsRadius() {
		if(eIsSet(NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius())) {
			return super.getRoundedBendpointsRadius();
		} else {
			return shapeStyle.getCSSRoundedBendpointsRadius();
		}
	}


	@Override
	public int getFontColor() {
		//return super.getFontColor();
		return getCSSFontColor();
	}

	@Override
	public java.lang.String getFontName() {
		//return super.getFontName();
		return getCSSFontName();
	}

	@Override
	public int getFontHeight() {
		//return super.getFontHeight();
		return getCSSFontHeight();
	}

	@Override
	public boolean isBold() {
		//return super.isBold();
		return isCSSBold();
	}

	@Override
	public boolean isItalic() {
		//return super.isItalic();
		return isCSSItalic();
	}

	@Override
	public boolean isUnderline() {
		//return super.isUnderline();
		return isCSSUnderline();
	}

	@Override
	public boolean isStrikeThrough() {
		//return super.isStrikeThrough();
		return isCSSStrikeThrough();
	}

	@Override
	public java.lang.String getDescription() {
		//return super.getDescription();
		return getCSSDescription();
	}

	@Override
	public int getFillColor() {
		//return super.getFillColor();
		return getCSSFillColor();
	}

	@Override
	public int getTransparency() {
		//return super.getTransparency();
		return getCSSTransparency();
	}

	@Override
	public org.eclipse.gmf.runtime.notation.datatype.GradientData getGradient() {
		//return super.getGradient();
		return getCSSGradient();
	}

	@Override
	public int getLineColor() {
		//return super.getLineColor();
		return getCSSLineColor();
	}

	@Override
	public int getLineWidth() {
		//return super.getLineWidth();
		return getCSSLineWidth();
	}

	@Override
	public int getRoundedBendpointsRadius() {
		//return super.getRoundedBendpointsRadius();
		return getCSSRoundedBendpointsRadius();
	}

	public boolean getCSSElementIcon() {
		return shapeStyle.getCSSElementIcon();
	}

	public boolean getCSSShadow() {
		return shapeStyle.getCSSShadow();
	}

	public int getCSSQualifiedNameDepth() {
		return shapeStyle.getCSSQualifiedNameDepth();
	}

	public String getCSSStereotypeDisplay() {
		return shapeStyle.getCSSStereotypeDisplay();
	}

	public String getCSSTextAlignment() {
		return shapeStyle.getCSSTextAlignment();
	}

	public String getCSSDisplayPlace() {
		return shapeStyle.getCSSDisplayPlace();
	}


	//////////////////////////////////////////
	//	Forwards all calls to cssAdapter	//
	//////////////////////////////////////////

	public String getTagName() {
		return cssAdapter.getTagName();
	}

	public String getAttribute(String name) {
		return cssAdapter.getAttribute(name);
	}

	public void setAttribute(String name, String value) throws DOMException {
		cssAdapter.setAttribute(name, value);
	}

	public void removeAttribute(String name) throws DOMException {
		cssAdapter.removeAttribute(name);
	}

	public Attr getAttributeNode(String name) {
		return cssAdapter.getAttributeNode(name);
	}

	public Attr setAttributeNode(Attr newAttr) throws DOMException {
		return cssAdapter.setAttributeNode(newAttr);
	}

	public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
		return cssAdapter.removeAttributeNode(oldAttr);
	}

	public NodeList getElementsByTagName(String name) {
		return cssAdapter.getElementsByTagName(name);
	}

	public String getAttributeNS(String namespaceURI, String localName) throws DOMException {
		return cssAdapter.getAttributeNS(namespaceURI, localName);
	}

	public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException {
		cssAdapter.setAttributeNS(namespaceURI, qualifiedName, value);
	}

	public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
		cssAdapter.removeAttributeNS(namespaceURI, localName);
	}

	public Attr getAttributeNodeNS(String namespaceURI, String localName) throws DOMException {
		return cssAdapter.getAttributeNodeNS(namespaceURI, localName);
	}

	public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
		return cssAdapter.setAttributeNodeNS(newAttr);
	}

	public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException {
		return cssAdapter.getElementsByTagNameNS(namespaceURI, localName);
	}

	public boolean hasAttribute(String name) {
		return cssAdapter.hasAttribute(name);
	}

	public boolean hasAttributeNS(String namespaceURI, String localName) throws DOMException {
		return cssAdapter.hasAttributeNS(namespaceURI, localName);
	}

	public TypeInfo getSchemaTypeInfo() {
		return cssAdapter.getSchemaTypeInfo();
	}

	public void setIdAttribute(String name, boolean isId) throws DOMException {
		cssAdapter.setIdAttribute(name, isId);
	}

	public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {
		cssAdapter.setIdAttributeNS(namespaceURI, localName, isId);
	}

	public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
		cssAdapter.setIdAttributeNode(idAttr, isId);
	}

	public String getNodeName() {
		return cssAdapter.getNodeName();
	}

	public String getNodeValue() throws DOMException {
		return cssAdapter.getNodeValue();
	}

	public void setNodeValue(String nodeValue) throws DOMException {
		cssAdapter.setNodeValue(nodeValue);
	}

	public short getNodeType() {
		return cssAdapter.getNodeType();
	}

	public Node getParentNode() {
		return cssAdapter.getParentNode();
	}

	public NodeList getChildNodes() {
		return cssAdapter.getChildNodes();
	}

	public Node getFirstChild() {
		return cssAdapter.getFirstChild();
	}

	public Node getLastChild() {
		return cssAdapter.getLastChild();
	}

	public Node getPreviousSibling() {
		return cssAdapter.getPreviousSibling();
	}

	public Node getNextSibling() {
		return cssAdapter.getNextSibling();
	}

	public NamedNodeMap getAttributes() {
		return cssAdapter.getAttributes();
	}

	public Document getOwnerDocument() {
		return cssAdapter.getOwnerDocument();
	}

	public Node insertBefore(Node newChild, Node refChild) throws DOMException {
		return cssAdapter.insertBefore(newChild, refChild);
	}

	public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
		return cssAdapter.replaceChild(newChild, oldChild);
	}

	public Node removeChild(Node oldChild) throws DOMException {
		return cssAdapter.removeChild(oldChild);
	}

	public Node appendChild(Node newChild) throws DOMException {
		return cssAdapter.appendChild(newChild);
	}

	public boolean hasChildNodes() {
		return cssAdapter.hasChildNodes();
	}

	public Node cloneNode(boolean deep) {
		return cssAdapter.cloneNode(deep);
	}

	public void normalize() {
		cssAdapter.normalize();
	}

	public boolean isSupported(String feature, String version) {
		return cssAdapter.isSupported(feature, version);
	}

	public String getNamespaceURI() {
		return cssAdapter.getNamespaceURI();
	}

	public String getPrefix() {
		return cssAdapter.getPrefix();
	}

	public void setPrefix(String prefix) throws DOMException {
		cssAdapter.setPrefix(prefix);
	}

	public String getLocalName() {
		return cssAdapter.getLocalName();
	}

	public boolean hasAttributes() {
		return cssAdapter.hasAttributes();
	}

	public String getBaseURI() {
		return cssAdapter.getBaseURI();
	}

	public short compareDocumentPosition(Node other) throws DOMException {
		return cssAdapter.compareDocumentPosition(other);
	}

	public String getTextContent() throws DOMException {
		return cssAdapter.getTextContent();
	}

	public void setTextContent(String textContent) throws DOMException {
		setTextContent(textContent);
	}

	public boolean isSameNode(Node other) {
		return cssAdapter.isSameNode(other);
	}

	public String lookupPrefix(String namespaceURI) {
		return cssAdapter.lookupPrefix(namespaceURI);
	}

	public boolean isDefaultNamespace(String namespaceURI) {
		return cssAdapter.isDefaultNamespace(namespaceURI);
	}

	public String lookupNamespaceURI(String prefix) {
		return cssAdapter.lookupNamespaceURI(prefix);
	}

	public boolean isEqualNode(Node arg) {
		return cssAdapter.isEqualNode(arg);
	}

	public Object getFeature(String feature, String version) {
		return cssAdapter.getFeature(feature, version);
	}

	public Object setUserData(String key, Object data, UserDataHandler handler) {
		return cssAdapter.setUserData(key, data, handler);
	}

	public Object getUserData(String key) {
		return cssAdapter.getUserData(key);
	}

	public Object getNativeWidget() {
		return cssAdapter.getNativeWidget();
	}

	public String getCSSId() {
		return cssAdapter.getCSSId();
	}

	public String getCSSClass() {
		return cssAdapter.getCSSClass();
	}

	public String getCSSStyle() {
		return cssAdapter.getCSSStyle();
	}

	public CSSStyleDeclaration getDefaultStyleDeclaration(String pseudoE) {
		return cssAdapter.getDefaultStyleDeclaration(pseudoE);
	}

	public void copyDefaultStyleDeclarations(CSSStylableElement stylableElement) {
		cssAdapter.copyDefaultStyleDeclarations(stylableElement);
	}

	public void setDefaultStyleDeclaration(String pseudoE, CSSStyleDeclaration defaultStyleDeclaration) {
		cssAdapter.setDefaultStyleDeclaration(pseudoE, defaultStyleDeclaration);
	}

	public boolean isPseudoInstanceOf(String s) {
		return cssAdapter.isPseudoInstanceOf(s);
	}

	public String[] getStaticPseudoInstances() {
		return cssAdapter.getStaticPseudoInstances();
	}

	public boolean isStaticPseudoInstance(String s) {
		return cssAdapter.isStaticPseudoInstance(s);
	}

	public void onStylesApplied(NodeList nodes) {
		cssAdapter.onStylesApplied(nodes);
	}

	public CSSExtendedProperties getStyle() {
		return cssAdapter.getStyle();
	}

	public void initialize() {
		cssAdapter.initialize();
	}

	public void dispose() {
		cssAdapter.dispose();
	}
}
