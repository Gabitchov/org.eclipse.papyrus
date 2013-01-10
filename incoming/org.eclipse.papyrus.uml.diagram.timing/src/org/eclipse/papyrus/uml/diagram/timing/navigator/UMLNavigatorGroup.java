/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.navigator;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLNavigatorGroup extends UMLAbstractNavigatorItem {

	/**
	 * @generated
	 */
	private final String myGroupName;

	/**
	 * @generated
	 */
	private final String myIcon;

	/**
	 * @generated
	 */
	private final Collection myChildren = new LinkedList();

	/**
	 * @generated
	 */
	UMLNavigatorGroup(final String groupName, final String icon, final Object parent) {
		super(parent);
		this.myGroupName = groupName;
		this.myIcon = icon;
	}

	/**
	 * @generated
	 */
	public String getGroupName() {
		return this.myGroupName;
	}

	/**
	 * @generated
	 */
	public String getIcon() {
		return this.myIcon;
	}

	/**
	 * @generated
	 */
	public Object[] getChildren() {
		return this.myChildren.toArray();
	}

	/**
	 * @generated
	 */
	public void addChildren(final Collection children) {
		this.myChildren.addAll(children);
	}

	/**
	 * @generated
	 */
	public void addChild(final Object child) {
		this.myChildren.add(child);
	}

	/**
	 * @generated
	 */
	public boolean isEmpty() {
		return this.myChildren.size() == 0;
	}

	/**
	 * @generated
	 */
	@Override
	public boolean equals(final Object obj) {
		if(obj instanceof org.eclipse.papyrus.uml.diagram.timing.navigator.UMLNavigatorGroup) {
			final org.eclipse.papyrus.uml.diagram.timing.navigator.UMLNavigatorGroup anotherGroup = (org.eclipse.papyrus.uml.diagram.timing.navigator.UMLNavigatorGroup)obj;
			if(getGroupName().equals(anotherGroup.getGroupName())) {
				return getParent().equals(anotherGroup.getParent());
			}
		}
		return super.equals(obj);
	}

	/**
	 * @generated
	 */
	@Override
	public int hashCode() {
		return getGroupName().hashCode();
	}

}
