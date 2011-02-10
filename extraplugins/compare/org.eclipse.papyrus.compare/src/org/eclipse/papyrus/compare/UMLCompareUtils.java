/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch;
import org.eclipse.papyrus.compare.ui.PapyrusLabelProvider;
import org.eclipse.papyrus.compare.ui.PapyrusStyledLabelProvider;
import org.eclipse.papyrus.compare.ui.viewer.structure.StyledDiffLabelSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;


public class UMLCompareUtils {

	private static UMLCompareUtils ourInstance;

	private IBaseLabelProvider myPapyrusLabelProvider;
	
	private UMLDiffSwitch<StyledString> myDiffLabelSwitch = new StyledDiffLabelSwitch();
	
	private UMLCompareUtils() {}
	
	public static UMLCompareUtils getInstance() {
		if (ourInstance == null) {
			ourInstance = new UMLCompareUtils();
		}
		return ourInstance;
	}

	public static boolean isStereotypeApplication(EObject eObject) {
		return UMLUtil.getStereotype(eObject) != null;
	}

	public IBaseLabelProvider getPapyrusLabelProvider() {
		if (myPapyrusLabelProvider == null) {
			myPapyrusLabelProvider = new PapyrusLabelProvider();
		}
		return myPapyrusLabelProvider;
	}

	public String getText(UMLDiffExtension object) {
		StyledString result = myDiffLabelSwitch.doSwitch(object);
		if (result != null) {
			return result.getString();
		}
		return "<LABEL NOT FOUND>";
	}

}
