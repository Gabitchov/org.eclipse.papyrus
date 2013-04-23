/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  Vincent Lorenzo(CEA-List) vincent.lorenzo@cea.fr - getCurrentSideOfParent()
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.locators;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.papyrus.uml.diagram.composite.custom.preferences.CustomDiagramPreferencePage;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;

/**
 * This class is used to constrain the position of Port when they are added on a Property or a
 * StructuredClassifier
 * 
 * <pre>
 * 	 +-------------------+
 * 	 |    [Class]        |
 * 	 +-------------------+
 * 	 |                   |
 * 	 |                   |
 * 	 |                  +-+ - Expected position of Port 
 * 	 |                  +-+
 * 	 |                   |
 * 	 +-------------------+
 * 
 * </pre>
 * 
 * <pre>
 * TODO  : The port is not re-sizable
 * 
 */
public class PortPositionLocator implements IBorderItemLocator {

	protected org.eclipse.papyrus.uml.diagram.common.locator.PortPositionLocator currentLocator= null;
	protected  IFigure parentFigure;
	protected int preferredSide;

	/** Constructor **/
	public PortPositionLocator(IFigure parentFigure, int preferredSide) {
		currentLocator= new ExternalPortPositionLocator(parentFigure, preferredSide);
		this.parentFigure= parentFigure;
		this.preferredSide= preferredSide;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getValidLocation(org.eclipse.draw2d.geometry.Rectangle,
	 *      org.eclipse.draw2d.IFigure)
	 * 
	 * @param proposedLocation
	 * @param borderItem
	 * @return a valid location
	 */
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		updateLocator();
		return currentLocator.getValidLocation(proposedLocation, borderItem);
	}

	public void setConstraint(Rectangle constraint) {
		updateLocator();
		currentLocator.setConstraint(constraint);

	}

	public int getCurrentSideOfParent() {
		updateLocator();
		return currentLocator.getCurrentSideOfParent();
	}

	public void relocate(IFigure target) {
		updateLocator();
		currentLocator.relocate(target);

	}
	public Rectangle getPreferredLocation(Rectangle proposedLocation) {
		return currentLocator.getPreferredLocation(proposedLocation);
	}

	public void setInternal(){
		if(currentLocator instanceof ExternalPortPositionLocator){
			currentLocator= new InternalPortPositionLocator(parentFigure, preferredSide);
		}
	}
	public void setExternal(){
		if(currentLocator instanceof InternalPortPositionLocator){
			currentLocator= new ExternalPortPositionLocator(parentFigure, preferredSide);
		}
	}
	protected void updateLocator(){
		boolean isInside=UMLDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(CustomDiagramPreferencePage.IS_INSIDE_COMPOSITE_COMPOSITE_DIAGRAM);
		if(isInside){
			setInternal();
		}
		else{
			setExternal();
		}

	}
}