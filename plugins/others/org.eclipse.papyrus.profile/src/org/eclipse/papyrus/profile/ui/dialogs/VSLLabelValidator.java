/*******************************************************************************
 * Copyright (c) 2007 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.profile.ui.dialogs;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLFactory;

// import com.cea.nfp.parsers.modelgenerator.VSLGenerator;
import com.cea.papyrus.classdiagram.parsers.modelgenerator.VSLGenerator;
import com.cea.papyrus.classdiagram.parsers.texteditor.vsldatatypes.IContext;
import com.cea.papyrus.classdiagram.parsers.texteditor.vsldatatypes.VSLPrimitiveTypes;

/**
 * @author RS211865
 * Validator for Property Labels
 * @see org.eclipse.jface.dialogs.InputDialog
 */
public class VSLLabelValidator implements IInputValidator {

	//private static final int String = 0;
	//private Property property;
	private Property property;
	private Slot slot;
	private DataType datatype;
	
	/**
	 * @return the property
	 */
	//public Property getProperty() {
	//	return property;
	//}

	public DataType getDataType() {
		return datatype;
	}

	
	/**
	 * @param property the property to set
	 */
	//public void setProperty(Property property) {
	//	this.property = property;
	//}

	public void setOpaqueExpression(DataType datatype) {
		this.datatype = datatype;
	}

	
	//public TVLLabelValidator(Property property) {
	//	super();
	//	setProperty(property);
	//}
	
	public VSLLabelValidator(DataType datatype) {
		super();
		setOpaqueExpression(datatype);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
	 */
	public String isValid(String newText) {
		String message="";

		VSLGenerator generator = new VSLGenerator(datatype);
		
		if (!datatype.getAllAttributes().isEmpty()) {
			//message = 
			generator.isTupleValid(newText, datatype, 0);
		}
    	else {
    		message = generator.parseAndValidateProperty (newText, datatype);
    	}

		return message;
		
	}


}
