/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.Label;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;

/**
 * This a WrappingLabel that can display applied stereotypes
 */
public class QualifiedNameWrappingLabelFigure extends PapyrusWrappingLabel implements IPapyrusNodeNamedElementFigure {

	/** the depth of the qualified name **/
	private int depth = 0;
	

	public Label getStereotypesLabel() {	
		return null;
	}
	/**
	 * Calculate the partial qualified name with a specified depth.
	 * 
	 * @param qualifiedName
	 *        the qualified name can return null
	 */
	public String getQualifiedName(String qualifiedName, int depth) {
		int n = -1;
		if(qualifiedName == null) {
			return null;
		}
		int i = 0;
		if(depth <= 0) {
			return qualifiedName;
		}

		while(i < depth) {
			if((n = qualifiedName.indexOf("::", n + 1)) != -1) {
				i++;
			} else {
				return null;
			}
		}

		if(n == -1) {
			return qualifiedName;
		} else {
			return qualifiedName.substring(n + 2);
		}

	}
	
	public void setQualifiedName(String qualifiedName) {
		String tmpQualifiedName = getQualifiedName(qualifiedName, depth);
		// two raisons to remove label!
		// null
		// or the qualified name is equal to 1
		if(qualifiedName == null || tmpQualifiedName == null || !tmpQualifiedName.contains("::")) { // Remove
			setText("");
			setTextWrap(true);
			return;
		}

		// we have to not display name.

		int i = tmpQualifiedName.lastIndexOf("::");
		if(i != -1) {
			tmpQualifiedName = tmpQualifiedName.substring(0, i);
		}
		this.setText("(" + tmpQualifiedName.trim() + ")");
		setTextWrap(true);
		
	}

	/**
	 * Sets the depth.
	 * 
	 * @param depth
	 *        the new depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	//unused Method
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {}
	public void setStereotypePropertiesInCompartment(String stereotypeProperties){}
	public Label getQualifiedNameLabel() {return null;}
	public Label getTaggedLabel() {	return null;}
	public void setStereotypeDisplay(String stereotypes, Image image) {}
	public void setNameLabelIcon(boolean displayNameLabelIcon) {}
	public WrappingLabel getNameLabel() {return null;}
	
	
	public void restoreNameLabel() {
		// TODO Auto-generated method stub
		
	}
	public void removeNameLabel() {
		// TODO Auto-generated method stub
		
	}

}
