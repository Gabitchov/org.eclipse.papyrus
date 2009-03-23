package com.cea.papyrus.profile.tree.objects;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

import com.cea.papyrus.profile.ui.dialogs.VSLLabelEditorDialog;
import com.cea.papyrus.profile.ui.dialogs.InputDialogPrimitiveType;
import com.cea.papyrus.profile.utils.Util;

public class DataTypeValueTreeObject extends ValueTreeObject {

	public DataTypeValueTreeObject(PropertyTreeObject parent, Object value) {
		super(parent, value);
		this.value = value;
	}

	@Override
	public void editMe() {
		PropertyTreeObject pTO = (PropertyTreeObject) getParent();
		Property property = pTO.getProperty();
		Type type = property.getType();
		
		// Creates a dialog box to enter value
		//InputDialogPrimitiveType valueDialog = new InputDialogPrimitiveType(new Shell(), property, getValue());
		
		VSLLabelEditorDialog valueDialog = new VSLLabelEditorDialog(new Shell(), getValue().toString(), 0, (DataType)type); 
		
		int val = valueDialog.open();
		
		// Treat Cancel case first
		if (val == InputDialogPrimitiveType.CANCEL) {
			// Close dialog box
			valueDialog.close();
			// And quit
			return;
		}
		// New object as string (user input)
		String dialogValue = valueDialog.getValue();
		// Treat dialogValue
		Object newValue = Util.getValueObjectFromString(dialogValue, type);
		
		updateValue(newValue);
		
		// Close dialog box and refresh table
		valueDialog.close();
	}
		
		
}

