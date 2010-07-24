package org.eclipse.papyrus.profile.ui.section;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.profile.Activator;
import org.eclipse.papyrus.profile.Message;
import org.eclipse.papyrus.profile.ui.dialogs.ComboSelectionDialog;
import org.eclipse.papyrus.profile.ui.dialogs.InputDialogEnumeration;
import org.eclipse.papyrus.profile.ui.dialogs.InputDialogPrimitiveType;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * This class contains static method that allow to edit poperty by taking accoint the type of the property
 * 
 */
public class AppliedStereotypePropertyEditor {

	/**
	 * the method is used to be able to edit a property typed by a primitive type
	 * 
	 * @param shell
	 *        the shell used to lanche an editor
	 * @param property
	 *        the property to edit
	 * @param type
	 *        the type of the property
	 * @return the new value of the property or null
	 */
	public static Object getNewValueForPropertyTypedByPrimitiveType(Shell shell, Property property, Type type) {
		Object newValue = null;
		// Create dialog box for value to add
		InputDialogPrimitiveType valueDialog = new InputDialogPrimitiveType(shell, property, null, -1);
		int val = valueDialog.open();

		// Treat Cancel case first
		if(val == InputDialogPrimitiveType.CANCEL) {
			// Close dialog box
			valueDialog.close();
			// And quit
			return newValue;
		}

		// New object as string (user input)
		String dialogValue = valueDialog.getValue();
		// Treat dialogValue
		newValue = Util.getValueObjectFromString(dialogValue, type);
		valueDialog.close();
		return newValue;
	}

	/**
	 * Pb this method returns always null. TO change. The method is used to be able to edit a property typed by a DataType
	 * 
	 * @param shell
	 *        the shell used to lanch an editor
	 * @param property
	 *        the property to edit
	 * @param type
	 *        the type of the property
	 * @return the new value of the property or null
	 */
	public static Object getNewValueForPropertyTypedByDataType(Shell shell, Property property, Type type) {
		// VSLLabelEditorDialog valueDialog = new VSLLabelEditorDialog(this.getShell(), "", 0, (DataType)type);
		// int val = valueDialog.open();

		//A DataType is treated as a String. 
		//This is due to the fact that a DataType is defined as a java.lang.String during the profile definition step. 
		InputDialogPrimitiveType valueDialog = new InputDialogPrimitiveType(shell, property, null, -1);
		int val = valueDialog.open();

		// Treat Cancel case first
		if (val == InputDialogPrimitiveType.CANCEL) {
			// Close dialog box
			valueDialog.close();
			// And quit
			return null;
		}

		// New object as string (user input)
		String dialogValue = valueDialog.getValue();
		//Treat dialogValue
		Object newValue = Util.getValueObjectFromString(dialogValue, type);
		valueDialog.close();
		return newValue;
	}

	/**
	 * The method is used to be able to edit a property typed by an Enumeration
	 * 
	 * @param shell
	 *        the shell used to launch an editor
	 * @param property
	 *        the property to edit
	 * @param type
	 *        the type of the property
	 * @return the new value of the property or null
	 */
	public static Object getNewValueForPropertyTypedByEnumeration(Shell shell, Property property, Type type) {
		Object newValue = null;
		// Create and Open combo box
		InputDialogEnumeration valueDialog = new InputDialogEnumeration(shell, property, null, -1);
		int val = valueDialog.open();

		if((val == InputDialogEnumeration.OK) && (valueDialog.getSelectionIndex() != -1)) {
			int index = valueDialog.getSelectionIndex();
			newValue = ((Enumeration)type).getOwnedLiterals().get(index);
		}
		valueDialog.close();
		return newValue;
	}

	/**
	 * The method is used to be able to edit a property typed by a stereotype
	 * 
	 * @param shell
	 *        the shell used to launch an editor
	 * @param property
	 *        the property to edit
	 * @param stereotypedElement
	 *        the stereotyped element
	 * @param type
	 *        the type of the property
	 * @return the new value of the property or null
	 */
	public static Object getNewValueForPropertyTypedByStereotype(Shell shell, Property property, Element stereotypedElement, Type type) {
		Object newValue = null;

		final ArrayList filteredElements = Util.getInstancesFilteredByType(stereotypedElement, null, (Stereotype)type);

		// Prepare possible selection for dialog box
		String[] elementsNames = Util.getStringArrayFromList(filteredElements);
		// if no possible selection : abort
		if(elementsNames == null) {
			Message.warning("No element stereotyped <<" + type.getName() + ">> was found in the model.");
			return newValue;
		}

		// Retrieve initial value...
		String initialValue = "";
		if(elementsNames.length > 0) {
			initialValue = elementsNames[0];
		}

		// Creates and open selection dialog
		ComboSelectionDialog valueDialog = new ComboSelectionDialog(shell, "New value:", elementsNames, initialValue);
		int val = valueDialog.open();
		if(val == ComboSelectionDialog.OK) {
			int index = valueDialog.indexOfSelection;
			Element dialogSelectedElt = (Element)filteredElements.get(index);
			newValue = dialogSelectedElt.getStereotypeApplication((Stereotype)type);
			if(newValue == null) {
				EList subStereotypes = dialogSelectedElt.getAppliedSubstereotypes((Stereotype)type);
				if(!subStereotypes.isEmpty()) {
					newValue = dialogSelectedElt.getStereotypeApplication((Stereotype)subStereotypes.get(0));
				}
			}
		}
		valueDialog.close();
		return newValue;

	}

	/**
	 * The method is used to be able to edit a property typed by a metaclass
	 * 
	 * @param shell
	 *        the shell used to launch an editor
	 * @param property
	 *        the property to edit
	 * @param stereotypedElement
	 *        the stereotyped element
	 * @param type
	 *        the type of the property
	 * 
	 * @param currentPropertyValues
	 *        current values for the property
	 *@return the new value of the property or null
	 */
	public static Object getNewValueForPropertyTypedByMetaclass(Shell shell, Property property, Element stereotypedElement, Type type, List currentPropertyValues) {
		Object newValue = null;
		// Retrieve type of the metaclass
		Class metaType = null;
		try {
			metaType = Class.forName("org.eclipse.uml2.uml." + type.getName());
		} catch (Exception ex) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, ex.getLocalizedMessage()));
			ex.printStackTrace();
			// and quit
			return newValue;
		}

		// Retrieve all instances applicable to this property value
		final ArrayList filteredElements = Util.getInstancesFilteredByType(stereotypedElement, metaType, null);
		// If multivalued remove already applied elements from list
		// Removed already added elements from selection list
		if(currentPropertyValues != null) {
			filteredElements.removeAll(currentPropertyValues);
		}

		// Prepare possible selection for dialog box
		String[] elementsNames = Util.getStringArrayFromList(filteredElements);
		// if no possible selection : abort
		if(elementsNames == null) {
			Message.warning("No element typed <<" + type.getName() + ">> was found in the model.");
			return newValue;
		}

		// Retrieve initial value...
		String initialValue = "";
		if(elementsNames.length > 0) {
			initialValue = elementsNames[0];
		}

		// Create and open combo
		ComboSelectionDialog valueDialog = new ComboSelectionDialog(shell, "New value:", elementsNames, initialValue);
		int val = valueDialog.open();
		if(val == ComboSelectionDialog.OK) {
			newValue = filteredElements.get(valueDialog.indexOfSelection);
			valueDialog.close();
		}
		return newValue;
	}

	/**
	 * The method is used to be able to edit a property
	 * 
	 * @param shell
	 *        the shell used to launch an editor
	 * @param property
	 *        the property to edit
	 * @param stereotypedElement
	 *        the stereotyped element
	 * @param type
	 *        the type of the property
	 * 
	 * @param currentPropertyValues
	 *        current values for the property
	 *@return the new value of the property or null
	 */
	public static Object getNewValueForProperty(Shell shell, Property property, Element stereotypedElement, Type type, List currentPropertyValues) {
		Object newValue = null;
		/** primitive type **/
		if(type instanceof PrimitiveType) {
			newValue = AppliedStereotypePropertyEditor.getNewValueForPropertyTypedByPrimitiveType(shell, property, type);
		}
		/** DataType **/
		else if((type instanceof DataType && !(type instanceof Enumeration))) {
			newValue = AppliedStereotypePropertyEditor.getNewValueForPropertyTypedByDataType(shell, property, type);
		}
		/** Enumeration **/
		else if(type instanceof Enumeration) {
			newValue = AppliedStereotypePropertyEditor.getNewValueForPropertyTypedByEnumeration(shell, property, type);
		}
		/** Stereotype **/
		else if(type instanceof Stereotype) {
			newValue = AppliedStereotypePropertyEditor.getNewValueForPropertyTypedByStereotype(shell, property, stereotypedElement, type);
		}
		/** Metaclass **/
		else if(Util.isMetaclass(type)) {
			newValue = AppliedStereotypePropertyEditor.getNewValueForPropertyTypedByMetaclass(shell, property, stereotypedElement, type, currentPropertyValues);
		}
		return newValue;
	}
}
