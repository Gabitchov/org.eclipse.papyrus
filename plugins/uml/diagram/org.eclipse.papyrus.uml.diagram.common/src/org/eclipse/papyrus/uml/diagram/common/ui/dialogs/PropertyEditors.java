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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.ui.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.papyrus.infra.widgets.validator.IntegerInputValidator;
import org.eclipse.papyrus.infra.widgets.validator.RealInputValidator;
import org.eclipse.papyrus.infra.widgets.validator.UnlimitedNaturalInputValidator;
import org.eclipse.papyrus.uml.diagram.common.Messages;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * this class provides editor for different types of properties
 */
public class PropertyEditors {

	/**
	 * Editor's Titles
	 */
	/** IntegerEditor Title */
	public static final String IntegerEditor_Title = Messages.PropertyEditors_IntegerTitle;

	/** IntegerEditor Title */
	public static final String RealEditor_Title = Messages.PropertyEditors_RealTitle;


	/** UnlimitedNaturalEditor Title */
	public static final String UnlimitedNaturalEditor_Title = Messages.PropertyEditors_UnlimitedNaturalTitle;

	/** StringEditor Title */
	public static final String StringEditor_Title = Messages.PropertyEditors_StringTitle;

	/** BooleanEditor Title */
	public static final String BooleanEditor_Title = Messages.PropertyEditors_BooleanTitle;

	/** EnumerationEditor Title */
	public static final String EnumerationLiteralEditor_Title = Messages.PropertyEditors_EnumerationLiteralTitle;

	/** StereotypeEditor Title */
	private static final String StereotypeEditor_Title = Messages.PropertyEditors_StereotypeTitle;

	/** MetaclassEditor Title */
	private static final String MetaclassEditor_Title = Messages.PropertyEditors_MetaclassTitle;

	/** DataTypeEditor Title */
	private static final String DataTypeEditor_Title = Messages.PropertyEditors_DataTypeTitle;

	/*
	 * Messages for editors
	 */
	/** the "Value" String */
	public static final String Value = Messages.PropertyEditors_Value;

	/** the "Choice" String */
	public static final String Choice = Messages.PropertyEditors_Choice;

	/*
	 * warning messages
	 */
	/** warning message for metaclass editor */
	public static final String MetaclassEditor_WarningMessage = Messages.PropertyEditors_NoFoundElementMetaclass;

	/** warning message for stereotype editor */
	public static final String StereotypeEditor_WarningMessage = Messages.PropertyEditors_NoFoundElementStereotype;

	/** prefix for the uml elements */
	public static final String UML_PREFIX = "org.eclipse.uml2.uml."; //$NON-NLS-1$

	/** the UML elements who aren't NamedElement */
	static String unNamedElements[] = new String[]{ "ActivityGroup", "Clause", "Comment", "ExceptionHandler", "Image", "LinkEndData", "MultiplicityElement", "ParameterableElement", "QualifierValue", "Relationship", "Slot", "TemplateableElement", "TemplateParameter", "TemplateParameterSubstitution", "TemplateableParameterSubsitution", }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$ //$NON-NLS-15$

	// TODO : we doesn't know edit a property if the initial value is a property
	// need implements this functionality is editors
	/**
	 * Editor for the Type Integer.
	 *
	 * @param property
	 *        : the property to edit
	 * @param oldValue
	 *        : the property value to modify (can be null)
	 *
	 * @return String : null if nothing is written
	 *
	 */
	public static String IntegerEditor(Property property, Object oldValue) {
		String value = null;
		String initialValue = findInitialValue(property, oldValue);
		InputDialogMessage dialog = new InputDialogMessage(new Shell(), IntegerEditor_Title, Value, initialValue, new IntegerInputValidator());
		if(dialog.open() != InputDialogMessage.CANCEL) {
			if(!"".equals(dialog.getValue())) { //$NON-NLS-1$
				value = dialog.getValue();
			}
		} else {
			value = oldValue.toString();
		}
		return value;
	}

	/**
	 * Editor for the Type Integer.
	 *
	 * @param property
	 *        : the property to edit
	 * @param oldValue
	 *        : the property value to modify (can be null)
	 *
	 * @return String : null if nothing is written
	 *
	 */
	public static String RealEditor(Property property, Object oldValue) {
		String value = null;
		String initialValue = findInitialValue(property, oldValue);
		InputDialogMessage dialog = new InputDialogMessage(new Shell(), RealEditor_Title, Value, initialValue, new RealInputValidator());
		if(dialog.open() != InputDialogMessage.CANCEL) {
			if(!"".equals(dialog.getValue())) { //$NON-NLS-1$
				value = dialog.getValue();
			}
		} else {
			value = oldValue.toString();
		}
		return value;
	}

	/**
	 *
	 * @param property
	 *        (the property to edit)
	 * @param oldValue
	 *        (can be null)
	 * @return the inital value for the property
	 */
	private static String findInitialValue(Property property, Object oldValue) {
		String initialValue = null;
		if(oldValue != null) {
			initialValue = oldValue.toString();
		} else if(property.getDefaultValue() != null) {
			initialValue = property.getDefault();
		}
		return initialValue;
	}

	/**
	 * Editor for the Type UnlimitedNatural.
	 *
	 * @param property
	 *        : the property to edit
	 * @param oldValue
	 *        : the property value to modify (can be null)
	 *
	 * @return String : null if nothing is written
	 *
	 */
	public static String UnlimitedNaturalEditor(Property property, Object oldValue) {
		String value = null;
		String initialValue = findInitialValue(property, oldValue);
		InputDialogMessage dialog = new InputDialogMessage(new Shell(), UnlimitedNaturalEditor_Title, Value, initialValue, new UnlimitedNaturalInputValidator());
		if(dialog.open() != InputDialogMessage.CANCEL) {
			if(!"".equals(dialog.getValue())) { //$NON-NLS-1$
				value = dialog.getValue();
			}
		} else {
			if(oldValue != null) {
				value = oldValue.toString();
			}
		}
		return value;
	}

	/**
	 * Editor for the Type String.
	 *
	 * @param property
	 *        : the property to edit
	 * @param oldValue
	 *        : the property value to modify (can be null)
	 *
	 * @return String : null if nothing written
	 */
	public static String StringEditor(Property property, Object oldValue) {
		String value = null;
		String initialValue = findInitialValue(property, oldValue);
		InputDialogMessage dialog = new InputDialogMessage(new Shell(), StringEditor_Title, Value, initialValue, null);
		if(dialog.open() != InputDialogMessage.CANCEL) {
			value = new String(dialog.getValue());
			if(value.equals("")) { //$NON-NLS-1$
				value = null;
			}
		} else {
			if(oldValue != null) {
				return oldValue.toString();
			}
		}
		return value;

	}

	/**
	 * Editor for the type DataType
	 *
	 * @param property
	 *        : the property to edit
	 * @param oldValue
	 *        : the property value to modify (can be null)
	 * @return
	 */
	public static String DataTypeEditor(Property property, Object oldValue) {
		String value = null;
		String initialValue = null;
		if(oldValue != null) { // we are modifying an existing value
			initialValue = oldValue.toString();
		} else if(property.getDefaultValue() != null) {
			initialValue = property.getDefault();
		}

		InputDialogMessage dialog = new InputDialogMessage(new Shell(), DataTypeEditor_Title, Value, initialValue, null);
		if(dialog.open() != InputDialogMessage.CANCEL) {
			if(!"".equals(dialog.getValue())) { //$NON-NLS-1$
				value = dialog.getValue();
			}
		} else {
			if(oldValue != null) {
				value = oldValue.toString();
			}
		}
		return value;
	}

	/**
	 * Editor for the Type Boolean.
	 *
	 * @param property
	 *        : the property to edit
	 * @param oldValue
	 *        : the property value to modify (can be null)
	 *
	 * @return boolean : null if nothing is selected
	 *
	 */
	public static String BooleanEditor(Property property, Object oldValue) {
		String[] listOfChoice;
		String value = null;
		if(property.getLower() > 0) {
			listOfChoice = new String[]{ Boolean.FALSE.toString(), Boolean.TRUE.toString() };
		} else {

			listOfChoice = new String[]{ "", Boolean.FALSE.toString(), Boolean.TRUE.toString() }; //$NON-NLS-1$
		}
		String initialValue = findInitialValue(property, oldValue);

		ComboInputDialog dialog = new ComboInputDialog(new Shell(), BooleanEditor_Title, Choice, initialValue, listOfChoice);
		if(dialog.open() != ComboInputDialog.CANCEL) {
			int selection = dialog.getIndexOfSelection();
			if(listOfChoice[selection] != "") { //$NON-NLS-1$
				value = listOfChoice[selection];
			}
		} else if(oldValue != null) {
			value = oldValue.toString();
		}
		return value;
	}

	/**
	 * Editor for the Type EnumerationLiteral.
	 *
	 * @param property
	 *        : the property to edit
	 * @param oldValue
	 *        : the property value to modify (can be null)
	 *
	 * @return EnumerationLiteral : null if nothing is selected
	 *
	 */
	public static String EnumerationEditor(Property property, Object oldValue) {
		EList<EnumerationLiteral> literals = ((Enumeration)property.getType()).getOwnedLiterals();
		String initialValue = findInitialValue(property, oldValue);
		String value = null;
		String[] listOfChoice;

		if(property.getLower() > 0) {
			listOfChoice = new String[literals.size()];
			for(int i = 0; i < listOfChoice.length; i++) {
				listOfChoice[i] = literals.get(i).getName();
			}
		} else {
			listOfChoice = new String[literals.size() + 1];
			listOfChoice[0] = ""; //$NON-NLS-1$
			for(int i = 1; i < listOfChoice.length; i++) {
				listOfChoice[i] = literals.get(i - 1).getName();
			}
		}

		ComboInputDialog dialog = new ComboInputDialog(new Shell(), EnumerationLiteralEditor_Title, Choice, initialValue, listOfChoice);
		if(dialog.open() != ComboInputDialog.CANCEL) {
			int selection = dialog.getIndexOfSelection();
			if(listOfChoice[selection] != "") { //$NON-NLS-1$
				value = listOfChoice[selection].toString();
			}
		} else if(oldValue != null) {
			value = oldValue.toString();
		}
		return value;
	}

	/**
	 * Editor for the type Class, when the property is composite
	 *
	 * @param property
	 * @param oldValue
	 * @return
	 */
	public static String CompositeClassEditor(Property property, Object oldValue) {
		// TODO
		// we cannot do it!
		return oldValue.toString();
	}

	/**
	 * Editor for the type DataType
	 *
	 * @param property
	 * @param oldValue
	 * @param appliedProfiles
	 * @return
	 */
	public static String StereotypeEditor(Property property, Object oldValue, List<Profile> appliedProfiles) {
		Type type = property.getType();
		String returnedValue = null;
		ArrayList<Object> stereotypedElement = new ArrayList<Object>();
		String initialValue = findInitialValue(property, oldValue);
		String[] proposals = null;

		if(type != null) {
			/*
			 * we research all the elements stereotyped with type!
			 */
			for(Profile profile : appliedProfiles) {
				stereotypedElement.addAll(ElementUtil.getInstancesFilteredByType(profile, null, (Stereotype)type));
			}

			if(property.getLower() > 0) {
				proposals = new String[stereotypedElement.size()];
				for(int i = 0; i < stereotypedElement.size(); i++) {
					if((stereotypedElement.get(i)) instanceof NamedElement) {
						proposals[i] = ((NamedElement)stereotypedElement.get(i)).getQualifiedName();
					} else {
						// TODO need a solution!
						// String label =
						// ((Element)stereotypedElement.get(i)).toString();
						// proposals[i + 1] = label;
						// //we don't obtain the ID from the XMI!
						// UML2Util.getXMIIdentifier((InternalEObject)(((Element)stereotypedElement.get(i))));
					}
				}
			} else {
				proposals = new String[stereotypedElement.size() + 1];
				proposals[0] = ""; //$NON-NLS-1$
				for(int i = 1; i < proposals.length; i++) {
					if((stereotypedElement.get(i - 1)) instanceof NamedElement) {
						proposals[i] = ((NamedElement)stereotypedElement.get(i - 1)).getQualifiedName();
					} else {
						// TODO need a solution!
						// String label =
						// ((Element)stereotypedElement.get(i)).toString();
						// proposals[i + 1] = label;
						// //we don't obtain the ID from the XMI!
						// UML2Util.getXMIIdentifier((InternalEObject)(((Element)stereotypedElement.get(i))));
					}
				}
			}

			ComboDialogWithMessage dialog = new ComboDialogWithMessage(new Shell(), StereotypeEditor_Title, Choice, initialValue, proposals, StereotypeEditor_WarningMessage);
			if(dialog.open() != ComboInputDialog.CANCEL) {
				int selection = dialog.getIndexOfSelection();
				if(proposals[selection] != "") { //$NON-NLS-1$
					returnedValue = dialog.getValue();
				}

			} else if(oldValue != null) {
				returnedValue = oldValue.toString();
			}

		}
		return returnedValue;
	}

	/**
	 * Editor for the type Metaclass
	 *
	 * @param property
	 * @param oldValue
	 * @param appliedProfiles
	 * @return
	 */
	public static String MetaclassEditor(Property property, Object oldValue, List<Profile> appliedProfiles) {

		/*
		 * 1/ find the interesting elements 2/ check if they are problematic 3/
		 * create the proposals
		 */
		Type type = property.getType();
		String returnedValue = null;

		ArrayList<String> problematicMetaclasses = new ArrayList<String>(Arrays.asList(unNamedElements));
		if(type != null && !problematicMetaclasses.contains(((org.eclipse.uml2.uml.Class)type).getName())) {
			String[] proposals;
			ArrayList<Object> metaclassElement = new ArrayList<Object>();
			String initialValue = findInitialValue(property, oldValue);

			/*
			 * we research all the representation of the metaclass
			 */
			String metaclassName = ((org.eclipse.uml2.uml.Class)type).getName();

			// Try to retrieve type of the metaclass
			java.lang.Class<? extends Element> metaType = null;
			try {
				metaType = java.lang.Class.forName("org.eclipse.uml2.uml." + metaclassName).asSubclass(Element.class); //$NON-NLS-1$
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(Profile profile : appliedProfiles) {
				metaclassElement.addAll(ElementUtil.getInstancesFilteredByType(profile, metaType, null));
			}

			/*
			 * we create the list of proposals
			 */
			if(property.getLower() == 0) {
				proposals = new String[metaclassElement.size() + 1];
				proposals[0] = ""; //$NON-NLS-1$
				for(int i = 0; i < metaclassElement.size(); i++) {
					if(metaclassElement.get(i) instanceof NamedElement) {
						proposals[i + 1] = ((NamedElement)metaclassElement.get(i)).getQualifiedName();

					} else {
						// TODO need a solution!
						String label = ((Element)metaclassElement.get(i)).toString();
						proposals[i + 1] = label;
						// we don't obtain the ID from the XMI!
						UML2Util.getXMIIdentifier((InternalEObject)(((Element)metaclassElement.get(i))));
					}
				}
			} else {
				proposals = new String[metaclassElement.size()];
				for(int i = 0; i < metaclassElement.size(); i++) {
					if(metaclassElement.get(i) instanceof NamedElement) {
						proposals[i] = ((NamedElement)metaclassElement.get(i)).getQualifiedName();

					} else {
						// TODO need a solution!
						String label = ((Element)metaclassElement.get(i)).toString();
						proposals[i] = label;
						// We don't obtain the ID from the XMI
						UML2Util.getXMIIdentifier((InternalEObject)(((Element)metaclassElement.get(i))));

					}
				}
			}
			/*
			 * the message dialog
			 */
			ComboDialogWithMessage dialog = new ComboDialogWithMessage(new Shell(), MetaclassEditor_Title, Choice, initialValue, proposals, MetaclassEditor_WarningMessage);
			if(dialog.open() != ComboInputDialog.CANCEL) {
				int selection = dialog.getIndexOfSelection();
				if(proposals[selection] != "") { //$NON-NLS-1$

					returnedValue = dialog.getValue();
				}
			} else if(oldValue != null) {
				returnedValue = oldValue.toString();
			}
		}
		return returnedValue;
	}


}
