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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.e4.ui.css.core.dom.CSSExtendedProperties;
import org.eclipse.e4.ui.css.core.dom.CSSStylableElement;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.core.impl.dom.CSSExtendedPropertiesImpl;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.CSSConnectorStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.style.impl.CSSConnectorStyleImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.dom.GMFCSSAdapter;

@SuppressWarnings("restriction")
public class GMFCSSConnector extends ConnectorImpl implements CSSStylableElement, CSSConnectorStyle {

	protected CSSEngine engine;

	private CSSStylableElement cssAdapter;

	private CSSConnectorStyle connectorStyle;
	
	public GMFCSSConnector(CSSEngine engine) {
		this.engine = engine;
		this.cssAdapter = new GMFCSSAdapter(this, engine);
		this.connectorStyle = new CSSConnectorStyleImpl(this, this, engine);
	}


	//////////////////////////////////////////
	//	Forwards accesses to CSS properties	//
	//////////////////////////////////////////

	public int getCSSRoundedBendpointsRadius(){
		if (eIsSet(NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius())){
			return super.getRoundedBendpointsRadius();
		} else {
			return connectorStyle.getCSSRoundedBendpointsRadius();
		}
	}

	public Routing getCSSRouting(){
		if (eIsSet(NotationPackage.eINSTANCE.getRoutingStyle_Routing())){
			return super.getRouting();
		} else {
			return connectorStyle.getCSSRouting();
		}
	}

	public Smoothness getCSSSmoothness(){
		if (eIsSet(NotationPackage.eINSTANCE.getRoutingStyle_Smoothness())){
			return super.getSmoothness();
		} else {
			return connectorStyle.getCSSSmoothness();
		}
	}

	public boolean isCSSAvoidObstructions(){
		if (eIsSet(NotationPackage.eINSTANCE.getRoutingStyle_AvoidObstructions())){
			return super.isAvoidObstructions();
		} else {
			return connectorStyle.isCSSAvoidObstructions();
		}
	}

	public boolean isCSSClosestDistance(){
		if (eIsSet(NotationPackage.eINSTANCE.getRoutingStyle_ClosestDistance())){
			return super.isClosestDistance();
		} else {
			return connectorStyle.isCSSClosestDistance();
		}
	}

	public JumpLinkStatus getCSSJumpLinkStatus(){
		if (eIsSet(NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkStatus())){
			return super.getJumpLinkStatus();
		} else {
			return connectorStyle.getCSSJumpLinkStatus();
		}
	}

	public JumpLinkType getCSSJumpLinkType(){
		if (eIsSet(NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkType())){
			return super.getJumpLinkType();
		} else {
			return connectorStyle.getCSSJumpLinkType();
		}
	}

	public boolean isCSSJumpLinksReverse(){
		if (eIsSet(NotationPackage.eINSTANCE.getRoutingStyle_JumpLinksReverse())){
			return super.isJumpLinksReverse();
		} else {
			return connectorStyle.isCSSJumpLinksReverse();
		}
	}

	public int getCSSLineColor(){
		if (eIsSet(NotationPackage.eINSTANCE.getLineStyle_LineColor())){
			return super.getLineColor();
		} else {
			return connectorStyle.getCSSLineColor();
		}
	}

	public int getCSSLineWidth(){
		if (eIsSet(NotationPackage.eINSTANCE.getLineStyle_LineWidth())){
			return super.getLineWidth();
		} else {
			return connectorStyle.getCSSLineWidth();
		}
	}


	@Override
	public int getRoundedBendpointsRadius(){
		//return super.getRoundedBendpointsRadius();
		return getCSSRoundedBendpointsRadius();
	}

	@Override
	public Routing getRouting(){
		//return super.getRouting();
		return getCSSRouting();
	}

	@Override
	public Smoothness getSmoothness(){
		//return super.getSmoothness();
		return getCSSSmoothness();
	}

	@Override
	public boolean isAvoidObstructions(){
		//return super.isAvoidObstructions();
		return isCSSAvoidObstructions();
	}

	@Override
	public boolean isClosestDistance(){
		//return super.isClosestDistance();
		return isCSSClosestDistance();
	}

	@Override
	public JumpLinkStatus getJumpLinkStatus(){
		//return super.getJumpLinkStatus();
		return getCSSJumpLinkStatus();
	}

	@Override
	public JumpLinkType getJumpLinkType(){
		//return super.getJumpLinkType();
		return getCSSJumpLinkType();
	}

	@Override
	public boolean isJumpLinksReverse(){
		//return super.isJumpLinksReverse();
		return isCSSJumpLinksReverse();
	}

	@Override
	public int getLineColor(){
		//return super.getLineColor();
		return getCSSLineColor();
	}

	@Override
	public int getLineWidth(){
		//return super.getLineWidth();
		return getCSSLineWidth();
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
		setAttribute(name, value);
	}
	
	public void removeAttribute(String name) throws DOMException {
		removeAttribute(name);
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
		setAttributeNS(namespaceURI, qualifiedName, value);
	}
	
	public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
		removeAttributeNS(namespaceURI, localName);
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
		setIdAttribute(name, isId);
	}
	
	public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {
		setIdAttributeNS(namespaceURI, localName, isId);
	}
	
	public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
		setIdAttributeNode(idAttr, isId);
	}
	
	public String getNodeName() {
		return cssAdapter.getNodeName();
	}
	
	public String getNodeValue() throws DOMException {
		return cssAdapter.getNodeValue();
	}
	
	public void setNodeValue(String nodeValue) throws DOMException {
		setNodeValue(nodeValue);
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
		normalize();
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
		setPrefix(prefix);
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
		copyDefaultStyleDeclarations(stylableElement);
	}
	
	public void setDefaultStyleDeclaration(String pseudoE, CSSStyleDeclaration defaultStyleDeclaration) {
		setDefaultStyleDeclaration(pseudoE, defaultStyleDeclaration);
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
		onStylesApplied(nodes);
	}
	
	public CSSExtendedProperties getStyle() {
		return cssAdapter.getStyle();
	}
	
	public void initialize() {
		initialize();
	}
	
	public void dispose() {
		dispose();
	}
}