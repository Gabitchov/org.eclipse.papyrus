/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.service.palette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.papyrus.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.papyrus.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.papyrus.diagram.common.ui.dialogs.PropertyEditors;
import org.eclipse.papyrus.diagram.common.util.SuperString;
import org.eclipse.papyrus.diagram.common.util.Util;
import org.eclipse.papyrus.diagram.common.wizards.PaletteAspectToolEntryProxy;
import org.eclipse.papyrus.diagram.common.wizards.PaletteEntryProxy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Aspect action that applies stereotypes on the edit part newly created
 * 
 * /!\ WARNING
 * always use the setters and getters for manipulating the 2 hashmaps
 * 
 * 
 */
public class StereotypePostAction extends ModelPostAction {

	/*
	 * the icons paths
	 */
	/** up icon path */
	protected static final String ICONS_UP = "/icons/arrow_up.gif"; //$NON-NLS-1$

	/** down icon path */
	protected static final String ICONS_DOWN = "/icons/arrow_down.gif"; //$NON-NLS-1$

	/** add icon path */
	protected static final String ICONS_ADD = "/icons/obj16/Add_16x16.gif"; //$NON-NLS-1$

	/** remove icon path */
	protected static final String ICONS_REMOVE = "/icons/delete.gif"; //$NON-NLS-1$

	/** stereotype icon path */
	protected static final String ICON_STEREOTYPE = "/icons/stereotype.gif"; //$NON-NLS-1$

	/** profile icon path */
	protected static final String ICON_PROFILE = "/icons/profile.gif"; //$NON-NLS-1$

	/** property icon path */
	protected static final String ICON_PROPERTY = "/icons/property.gif"; //$NON-NLS-1$

	/** metaclass icon path */
	protected static final String ICON_METACLASS = "/icons/Metaclass.gif"; //$NON-NLS-1$

	/** boolean icon path */
	protected static final String ICON_LITERALBOOLEAN = "/icons/LiteralBoolean.gif"; //$NON-NLS-1$

	/** integer icon path */
	protected static final String ICON_LITERALINTEGER = "/icons/LiteralInteger.gif"; //$NON-NLS-1$

	/** string icon path */
	protected static final String ICON_LITERALSTRING = "/icons/LiteralString.gif"; //$NON-NLS-1$

	/** unlimited natural icon path */
	protected static final String ICON_LITERALUNLIMITEDNATURAL = "/icons/LiteralUnlimitedNatural.gif"; //$NON-NLS-1$

	/** unknown icon path */
	protected static final String ICON_UNKNOWN = "/icons/Clause.gif"; //$NON-NLS-1$

	/** enumeration icon path */
	protected static final String ICON_ENUMERATION = "/icons/Enumeration.gif"; //$NON-NLS-1$

	/** datatype icon path */
	protected static final String ICON_DATATYPE = "/icons/DataType.gif"; //$NON-NLS-1$

	/** list of properties to update, the key is the property and the value is an Object or an ArrayList<Object> if it's a multi-valued property */
	protected Map<Object, Object> propertiesToUpdate;

	/*
	 * list of the values key = the object value, value = the property containing the value!
	 * we need this map to refind easier the type of the value, because, we use String for :
	 * - integer
	 * - unlimited natural
	 * - string
	 * - ... and maybe others
	 * 
	 * moreover, we have the same problem with multi-valued property
	 * 
	 * So we have the property and property.getType() is easiest!
	 */
	protected Map<Object, Property> valuesToProperties;

	/** list of stereotypes to apply, identified by their qualified names */
	protected List<String> stereotypesToApply;

	/** we can't find the real objects stereotype and property during the init(), so we store them in this hashmap */
	protected Map<String, Object> valuesToApply;

	/** Separator for displaying the different values owned by a multi-valued property */
	protected static final String SEPARATOR = ", "; //$NON-NLS-1$

	/** viewer to display stereotypes to apply */
	protected TreeViewer stereotypesViewer;

	/** entry proxy "parent" of this action when configuring the action */
	protected PaletteEntryProxy entryProxy;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;

	/** stereotypes label provider */
	protected StereotypeLabelProvider stereotypeLabelProvider = new StereotypeLabelProvider();

	/** editor label provider */
	protected EditorLabelProvider editorLabelProvider = new EditorLabelProvider();


	/*
	 * the buttons
	 */

	/** remove button */
	protected Button removeButton;

	/** add button */
	protected Button addButton;

	/** up button */
	protected Button upButton;

	/** down button */
	protected Button downButton;

	/** string used with the upButton */
	public static final String MOVE_DOWN = "move down"; //$NON-NLS-1$

	/** string used with the downButton */
	public static final String MOVE_UP = "move up"; //$NON-NLS-1$

	/** contains the expanded nodes */
	private Object[] expandedElements = null;

	/** constant to identify the type of a Boolean property */
	final static public String UMLPrimitiveTypes_BOOLEAN = "UMLPrimitiveTypes::Boolean"; //$NON-NLS-1$

	/** constant to identify the type of an Integer property */
	final static public String UMLPrimitiveTypes_INTEGER = "UMLPrimitiveTypes::Integer"; //$NON-NLS-1$

	/** constant to identify the type of a String property */
	final static public String UMLPrimitiveTypes_STRING = "UMLPrimitiveTypes::String"; //$NON-NLS-1$

	/** constant to identify the type of an Unlimited Natural property */
	final static public String UMLPrimitiveTypes_UNLIMITED_NATURAL = "UMLPrimitiveTypes::UnlimitedNatural"; //$NON-NLS-1$

	/*
	 * String used to save and init the palette's configuration
	 */
	/** name of the property node */
	public static final String PROPERTY = "property"; //$NON-NLS-1$

	/** name of the property name attribute */
	public static final String PROPERTY_NAME = "propertyName"; //$NON-NLS-1$

	/** name of the stereotype node */
	public static final String STEREOTYPE = "stereotype"; //$NON-NLS-1$

	/** name of the stereotypes to apply node */
	public static final String STEREOTYPE_TO_APPLY = "stereotypesToApply"; //$NON-NLS-1$

	/** name of the property name */
	public static final String STEREOTYPE_NAME = "stereotypeName"; //$NON-NLS-1$

	/** name of the value node */
	public static final String VALUE = "value"; //$NON-NLS-1$

	/**
	 * Constructor.
	 */
	public StereotypePostAction() {
		propertiesToUpdate = new HashMap<Object, Object>();
		valuesToProperties = new HashMap<Object, Property>();
		stereotypesToApply = new ArrayList<String>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus checkPostCondition() {
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus checkPreCondition() {
		return Status.OK_STATUS;
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public void init(Node configurationNode, IAspectActionProvider factory) {
		super.init(configurationNode, factory);
		if(configurationNode == null) {
			return;
		}
		NamedNodeMap nodeAttributes = configurationNode.getAttributes();
		if(null != nodeAttributes.getNamedItem(IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY)) {//old version
			String stereotypesToApplyQN = configurationNode.getAttributes().getNamedItem(IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY).getNodeValue();
			if(stereotypesToApplyQN != null && !"".equals(stereotypesToApplyQN)) { //$NON-NLS-1$
				stereotypesToApply.addAll(PaletteUtil.getStereotypeListFromString(stereotypesToApplyQN));
			}
		} else {//new version

			Node stereotypesToApplyNode = configurationNode.getFirstChild();//stereotypesToApply Node
			if(!IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY.equals(stereotypesToApplyNode.getLocalName())) {
				//the first node must be STEREOTYPE_TO_APPLY
				return;
			}
			NodeList childNodes = stereotypesToApplyNode.getChildNodes();
			valuesToApply = new HashMap<String, Object>();
			if(stereotypesToApplyNode.hasChildNodes()) {
				for(int iter = 0; iter < childNodes.getLength(); iter++) {
					Node steNode = childNodes.item(iter);
					if(STEREOTYPE.equals(steNode.getLocalName())) {//this node is really a stereotype?
						String propertyName = null;
						String stereotypeName = steNode.getAttributes().getNamedItem(STEREOTYPE_NAME).getNodeValue();

						// we store the stereotype
						stereotypesToApply.add(stereotypeName);

						if(steNode.hasChildNodes()) {//there are associated properties and values
							NodeList properties = steNode.getChildNodes();
							for(int i = 0; i < properties.getLength(); i++) {//we iterate on the properties
								Node propertyNode = properties.item(i);
								if(PROPERTY.equals(propertyNode.getLocalName())) {//this node is really a property?
									propertyName = propertyNode.getAttributes().getNamedItem(PROPERTY_NAME).getNodeValue();
									NodeList valuesList = propertyNode.getChildNodes();
									/*
									 * the test on mono-valued or multi-valued property can't do here, because we doesn't have the real properties.
									 * This test should be make in the fillHashMap() method
									 */
									if(valuesList.getLength() == 1) {
										Node valueNode = valuesList.item(0);
										if(VALUE.equals(valueNode.getLocalName())) {//this node is really a value?
											//we store the value
											valuesToApply.put(stereotypeName + NamedElement.SEPARATOR + propertyName, valueNode.getTextContent());
										}
									} else {
										ArrayList<String> values = new ArrayList<String>();
										for(int ii = 0; ii < valuesList.getLength(); ii++) {//we iterate on the values
											Node valueNode = valuesList.item(ii);
											if(valueNode.getLocalName().equals(VALUE)) {//this node is really a value?
												values.add(valueNode.getTextContent());
											}
										}
										//we store the value
										valuesToApply.put(stereotypeName + NamedElement.SEPARATOR + propertyName, values);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * @{inheritDoc
	 */
	public void save(Node parentNode) {
		if(parentNode instanceof Element) {
			Iterator<String> it = stereotypesToApply.listIterator();
			Set<Object> keys = propertiesToUpdate.keySet();
			//((Element)parentNode).appendChild(arg0)
			Element appliedStereotypeNode = ((Element)parentNode).getOwnerDocument().createElement(STEREOTYPE_TO_APPLY);
			while(it.hasNext()) {//iteration on stereotypes
				String currentStereotype = it.next();
				Element stereotypeNode = ((Element)parentNode).getOwnerDocument().createElement(STEREOTYPE);
				stereotypeNode.setAttribute(STEREOTYPE_NAME, currentStereotype);

				for(Object obj : keys) {//iteration on properties
					if((obj instanceof Property) && ((Property)obj).getQualifiedName().contains(currentStereotype)) {//we have a property to save for this stereotype
						Element propertyNode = ((Element)parentNode).getOwnerDocument().createElement(PROPERTY);
						propertyNode.setAttribute(PROPERTY_NAME, ((Property)obj).getName());
						Object values = propertiesToUpdate.get(obj);
						if(values instanceof ArrayList<?>) {
							for(int i = 0; i < ((ArrayList<?>)values).size(); i++) {//iteration on values
								Element valueNode = ((Element)parentNode).getOwnerDocument().createElement(VALUE);
								valueNode.setTextContent(((ArrayList<?>)values).get(i).toString());
								propertyNode.appendChild(valueNode);
							}
						} else {
							Element valueNode = ((Element)parentNode).getOwnerDocument().createElement(VALUE);
							valueNode.setTextContent(values.toString());
							propertyNode.appendChild(valueNode);
						}
						stereotypeNode.appendChild(propertyNode);
					}
				}//end of iteration on properties
				appliedStereotypeNode.appendChild(stereotypeNode);

			}//end of iteration on stereotype
			parentNode.appendChild(appliedStereotypeNode);

			//clean the hashmaps
			propertiesToUpdate.clear();
			valuesToProperties.clear();
		} else {
			Activator.log.error("parent node is not an Element", null); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void run(final EditPart editPart) {
		// Apply the required stereotypes
		ApplyStereotypeRequest request = new ApplyStereotypeRequest(stereotypesToApply);
		request.getExtendedData().put(ApplyStereotypeRequest.NEW_EDIT_PART_NAME, "NEW"); //$NON-NLS-1$
		editPart.performRequest(request);

		/*
		 * Looks like updateValue in ValueTreeObject and CompositeProperty
		 * to apply the values properties to the elements
		 */

		//element where are the properties
		final EObject objectToEdit = ((View)editPart.getModel()).getElement();
		//the current stereotype
		Stereotype currentStereotype = null;
		//all the properties to edit
		Set<String> keys = valuesToApply.keySet();
		if(!(objectToEdit instanceof org.eclipse.uml2.uml.NamedElement)) {
			return;
		}

		for(String steQN : stereotypesToApply) {
			for(String key : keys) {
				if(key.contains(steQN)) {//there is a property to apply!!!
					//get the stereotype
					EList<Stereotype> appliedSte = ((org.eclipse.uml2.uml.Element)objectToEdit).getAppliedStereotypes();
					for(Stereotype ste : appliedSte) {
						if(ste.getQualifiedName().equals(steQN)) {
							currentStereotype = ste;
							break;
						}
					}
					if(currentStereotype == null) {
						return;
					}
					final Stereotype stereotypeToEdit = currentStereotype;
					//get the property
					final Property property = stereotypeToEdit.getAttribute(key.substring(key.lastIndexOf(NamedElement.SEPARATOR) + 2), null);
					final Object propertyValue = valuesToApply.get(property.getQualifiedName());
					final TransactionalEditingDomain editingDomain = org.eclipse.papyrus.core.utils.EditorUtils.getTransactionalEditingDomain();
					try {
						editingDomain.runExclusive(new Runnable() {

							public void run() {
								Display.getCurrent().asyncExec(new Runnable() {

									public void run() {
										Type type = property.getType();
										final Object newValue;
										if(type instanceof PrimitiveType) {
											newValue = getValueFromString(property, propertyValue);
										} else if(Util.isMetaclass(type)) {
											newValue = retrievesMetaclassElementFromString(property, propertyValue);
											// property is an Enumeration 
										} else if(type instanceof org.eclipse.uml2.uml.Enumeration) {
											newValue = retrievesEnumerationLiteralFromString(property, propertyValue);
											// property is a DataType 
										} else if(type instanceof org.eclipse.uml2.uml.DataType) {
											newValue = getValueFromString(property, propertyValue);
											// property is a Stereotype 
										} else if(type instanceof Stereotype) {
											newValue = retrievesStereotypedElementFromString(property, propertyValue);
											// property is a composite class
										} else if((type instanceof org.eclipse.uml2.uml.Class) && !(type instanceof Stereotype) && property.isMultivalued()) {
											//TODO
											newValue = null;
										} else {
											Activator.log.error("impossible to find a correct editor for the property" + property, null); //$NON-NLS-1$
											return;
										}
										//we create and execute the recording command
										if(newValue != null) {
											RecordingCommand command = new RecordingCommand(editingDomain) {

												@Override
												protected void doExecute() {
													((org.eclipse.uml2.uml.Element)objectToEdit).setValue(stereotypeToEdit, property.getName(), newValue);
												}
											};
											editingDomain.getCommandStack().execute(command);
										}
									}

									/**
									 * 
									 * @param property
									 *        : the property to edit
									 * @param propertyValue
									 *        : the value to find
									 * @return the set of the element representing the value to apply to the property or <code>null</code>
									 * 
									 */
									private Object retrievesMetaclassElementFromString(Property property, Object propertyValue) {
										//we search the container for the object
										org.eclipse.uml2.uml.Element packageContainer = ((org.eclipse.uml2.uml.Element)objectToEdit);
										do {
											packageContainer = packageContainer.getOwner();
										} while(!(packageContainer instanceof org.eclipse.uml2.uml.Package));
										//the applied profiles
										EList<Profile> profiles = ((org.eclipse.uml2.uml.Package)packageContainer).getAllAppliedProfiles();

										ArrayList<Object> returnedValues = new ArrayList();
										// the values to apply 
										ArrayList<String> stringValues = new ArrayList<String>();
										ArrayList<Object> metaclassElement = new ArrayList<Object>();
										String metaclassName = ((org.eclipse.uml2.uml.Class)property.getType()).getName();
										if(propertyValue instanceof ArrayList) {
											stringValues.addAll((ArrayList)propertyValue);
										} else if(propertyValue instanceof String) {
											stringValues.add((String)propertyValue);
										}



										/*
										 * we research all the representation of the metaclass in the Profiles
										 */
										// Try to retrieve type of the metaclass
										java.lang.Class metaType = null;
										try {
											metaType = java.lang.Class.forName("org.eclipse.uml2.uml." + metaclassName); //$NON-NLS-1$
										} catch (Exception e) {
											e.printStackTrace();
										}
										for(Profile profile : profiles) {
											metaclassElement.addAll(Util.getInstancesFilteredByType(profile, metaType, null));
										}

										/*
										 * we retrieve the element with its QualifiedName
										 */

										for(String valuesQualifiedName : stringValues) {
											for(Object metaclassRepresentation : metaclassElement) {
												if(metaclassRepresentation instanceof NamedElement) {
													if(((NamedElement)metaclassRepresentation).getQualifiedName().equals(valuesQualifiedName)) {
														((ArrayList)returnedValues).add(metaclassRepresentation);
													}
												}
											}


										}

										if(property.getUpper() != 1) {
											return returnedValues;
										} else if(returnedValues.size() > 0) {
											return returnedValues.get(0);
										}
										return null;
									}

									/**
									 * 
									 * @param property
									 *        : the property to edit
									 * @param propertyValue
									 *        : the value to find
									 * @return the set of the stereotyped element to apply to the property or <code>null</code>
									 * 
									 */
									private Object retrievesStereotypedElementFromString(Property property, Object propertyValue) {

										//we search the container for the object
										org.eclipse.uml2.uml.Element packageContainer = ((org.eclipse.uml2.uml.Element)objectToEdit);
										do {
											packageContainer = packageContainer.getOwner();
										} while(!(packageContainer instanceof org.eclipse.uml2.uml.Package));

										ArrayList returnedValues = new ArrayList();

										ArrayList<String> stringvalues = new ArrayList<String>();
										ArrayList<Object> stereotypedElement = new ArrayList<Object>();
										if(propertyValue instanceof ArrayList) {
											stringvalues.addAll((ArrayList)propertyValue);
										} else if(propertyValue instanceof String) {
											stringvalues.add((String)propertyValue);
										}


										EList<Profile> profiles = ((org.eclipse.uml2.uml.Package)packageContainer).getAllAppliedProfiles();
										/*
										 * we research all the representation of the stereotype in the Profiles
										 */
										for(Profile profile : profiles) {
											stereotypedElement.addAll(Util.getInstancesFilteredByType(profile, null, (Stereotype)property.getType()));
										}

										/*
										 * we retrieve the element with its QualifiedName
										 */
										for(String valuesQualifiedName : stringvalues) {
											for(Object element : stereotypedElement) {
												if(element instanceof NamedElement) {
													if(((NamedElement)element).getQualifiedName().equals(valuesQualifiedName)) {



														//Like in AppliedStereotypePropertyEditor
														EObject newValue = ((NamedElement)element).getStereotypeApplication((Stereotype)property.getType());
														if(newValue == null) {
															EList subStereotypes = ((NamedElement)element).getAppliedSubstereotypes((Stereotype)property.getType());
															if(!subStereotypes.isEmpty()) {
																newValue = ((NamedElement)element).getStereotypeApplication((Stereotype)subStereotypes.get(0));
															}
														}
														//Like in StereotypeValueTreeObject
														if(newValue != null) {

															returnedValues.add(newValue);

														}
														returnedValues.add(element);
														break;
													}
												} else {
													//TODO for the element which don't are NamedElement
												}
											}
										}


										if(property.getUpper() != 1) {
											return returnedValues;
										} else if(returnedValues.size() > 0) {
											return returnedValues.get(0);
										}
										return null;

									}

									/**
									 * 
									 * @param property
									 *        : the property to edit
									 * @param propertyValue
									 *        : the value to find
									 * @return the set of EnumerationLiteral to apply to the property
									 * 
									 */
									private Object retrievesEnumerationLiteralFromString(Property property, Object object) {
										//we search the container for the object
										org.eclipse.uml2.uml.Element packageContainer = ((org.eclipse.uml2.uml.Element)objectToEdit);
										do {
											packageContainer = packageContainer.getOwner();
										} while(!(packageContainer instanceof org.eclipse.uml2.uml.Package));
										ArrayList returnedValues = new ArrayList();

										ArrayList<String> stringvalues = new ArrayList<String>();
										String typeName = property.getType().getName();
										if(object instanceof ArrayList) {
											stringvalues.addAll((ArrayList)object);
										} else if(object instanceof String) {
											stringvalues.add((String)object);
										}

										//get the enumerationLiteral
										Enumeration enume = null;
										String enumerationQN = property.getType().getQualifiedName();
										String profileQN = enumerationQN.substring(0, enumerationQN.lastIndexOf(NamedElement.SEPARATOR));
										Profile profile = null;

										EList<Profile> profiles = ((org.eclipse.uml2.uml.Package)packageContainer).getAllAppliedProfiles();
										for(Profile prof : profiles) {
											if(prof.getQualifiedName().equals(profileQN)) {
												profile = prof;
												break;
											}
										}
										enume = (Enumeration)profile.getPackagedElement(typeName);


										//we research the enumerationLiteral
										for(int i = 0; i < stringvalues.size(); i++) {
											Object obj = enume.getOwnedLiteral(stringvalues.get(i));
											(returnedValues).add(obj);
										}

										if(property.getUpper() != 1) {
											return returnedValues;
										} else if(returnedValues.size() > 0) {
											return returnedValues.get(0);
										}
										return null;
									}


									/**
									 * This function refind the value from a string for the following types :
									 * <ul>
									 * <li>Boolean</li>
									 * <li>Integer</li>
									 * <li>String</li>
									 * <li>UnlimitedNatural</li>
									 * <li>DataType</li>
									 * </ul>
									 * 
									 * @param property
									 *        : the property to edit
									 * @param propertyValue
									 *        : the value to find
									 * @return the set of value to apply to the property
									 * 
									 */
									private Object getValueFromString(Property property, Object object) {
										ArrayList returnedValue = new ArrayList();
										ArrayList<String> stringvalues = new ArrayList<String>();
										String typeName = property.getType().getQualifiedName();
										if(object instanceof ArrayList) {
											stringvalues.addAll((ArrayList)object);
										} else if(object instanceof String) {
											stringvalues.add((String)object);
										}

										if(property.getType() instanceof PrimitiveType) {
											if(UMLPrimitiveTypes_INTEGER.equals(typeName)) {
												for(int i = 0; i < stringvalues.size(); i++) {
													returnedValue.add(Integer.valueOf(stringvalues.get(i)));
												}
											} else if(UMLPrimitiveTypes_UNLIMITED_NATURAL.equals(typeName)) {
												for(int i = 0; i < stringvalues.size(); i++) {
													returnedValue.add(Integer.valueOf(stringvalues.get(i)));
												}
											} else if(UMLPrimitiveTypes_STRING.equals(typeName)) {
												for(int i = 0; i < stringvalues.size(); i++) {
													returnedValue.add(stringvalues.get(i));
												}
											} else if(UMLPrimitiveTypes_BOOLEAN.equals(typeName)) {
												for(int i = 0; i < stringvalues.size(); i++) {
													returnedValue.add(Boolean.valueOf(stringvalues.get(i)));
												}
											} else { // user defined primitive type
												for(int i = 0; i < stringvalues.size(); i++) {
													returnedValue.add(stringvalues.get(i));
												}
											}
										} else if(property.getType() instanceof DataType) {
											for(int i = 0; i < stringvalues.size(); i++) {
												returnedValue.add(stringvalues.get(i));
											}
										}

										if(property.getUpper() == 1) {
											return returnedValue.get(0);
										}
										return returnedValue;
									}
								});
							}
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}


		}

	}

	/**
	 * @{inheritDoc
	 */
	public Control createConfigurationComposite(Composite parent, PaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		this.entryProxy = entryProxy;
		//we can make it before, because, we doesn't have the really stereotype
		fillHashMaps();


		Composite mainComposite = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(5, false);
		mainComposite.setLayout(layout);

		Label titleLabel = new Label(mainComposite, SWT.NONE);
		titleLabel.setText("Stereotypes to Apply"); //$NON-NLS-1$
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		titleLabel.setLayoutData(data);

		downButton = new Button(mainComposite, SWT.NONE);
		downButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_DOWN));
		downButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				moveElement(MOVE_DOWN);
			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
		downButton.setEnabled(false);
		upButton = new Button(mainComposite, SWT.NONE);
		upButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_UP));
		upButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				moveElement(MOVE_UP);
			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
		upButton.setEnabled(false);

		addButton = new Button(mainComposite, SWT.NONE);
		addButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_ADD));
		addButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				performAddButtonPressed();
			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});

		removeButton = new Button(mainComposite, SWT.NONE);
		removeButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_REMOVE));
		removeButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				performRemoveAction();
			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
		removeButton.setEnabled(false);

		// stereotype viewer creation 
		stereotypesViewer = new TreeViewer(mainComposite, SWT.BORDER | SWT.MULTI);
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.horizontalSpan = 3;

		stereotypesViewer.getControl().setLayoutData(data);
		stereotypesViewer.setLabelProvider(stereotypeLabelProvider);
		stereotypesViewer.setContentProvider(new StereotypeContentProvider());

		stereotypesViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				performedSelectionChange(event);

			}
		});

		stereotypesViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {

				performedDoubleClickAction(event);
			}

		});

		stereotypesViewer.getControl().addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {

			}

			public void keyPressed(KeyEvent e) {

				if(e.keyCode == SWT.F2) {
					performF2Action();
				} else if(e.character == SWT.DEL) {
					performRemoveAction();
				} else if(e.stateMask == SWT.CTRL && e.keyCode == 110) {//e.character=='N' seems doesn't work on my computer
					performedCTRL_N_Action(e);
				}

			}
		});
		createColumn(stereotypesViewer);
		updateStereotypeViewer();
		return mainComposite;

	}


	/**
	 * Create the necessary column to have CellEditor in the tree
	 * 
	 * @param stereotypesViewer2
	 */
	protected void createColumn(TreeViewer viewer) {
		TreeViewerColumn stereotypeColumn = new TreeViewerColumn(viewer, SWT.FILL);
		stereotypeColumn.getColumn().setResizable(true);
		stereotypeColumn.getColumn().setWidth(400);
		stereotypeColumn.setLabelProvider(new EditorLabelProvider());
		stereotypeColumn.setEditingSupport(new AttributeEditingSupport(viewer));
		viewer.getTree().setLinesVisible(true);
		viewer.getTree().setHeaderVisible(true);
	}

	/**
	 * updates the stereotype viewer
	 * set the expandedNode
	 * refresh the status button
	 */
	protected void updateStereotypeViewer() {
		if(stereotypesViewer != null) {
			stereotypesViewer.setInput(getStereotypesToApply());
		}
		restoreExpandedNode();
		//to force the update for the buttons!
		performedSelectionChange(new SelectionChangedEvent(stereotypesViewer, stereotypesViewer.getSelection()));

	}

	/**
	 * Action done when the add button is pressed
	 */
	protected void performAddButtonPressed() {
		saveExpandedNode();
		TreeSelection selection = (TreeSelection)stereotypesViewer.getSelection();
		if(selection != null && selection.size() == 1) {
			Object selectedElement = selection.getFirstElement();
			if(valuesToProperties.containsKey(selectedElement)) {
				//it's a property value -> we do nothing
				return;
			} else if(selectedElement instanceof Property) {
				//We want add a value to a multi-valued property or edit a value to a mono-valued property
				Property property = (Property)selectedElement;
				if(property.isMultivalued()) {
					editMe(property, null);//we add a value
				} else if(propertiesToUpdate.containsKey(property)) { //mono-valued property and the valu exists
					editMe(property, propertiesToUpdate.get(property));
				} else {//monovalued property, the value doesn't exist
					editMe(property, null);
				}
				updateStereotypeViewer();
				return;
			}
		}


		// pops-up a dialog window where users can select the additionnal stereotypes to apply
		// it needs the metaclass information...
		// for this, entry Proxy should be a Palette entry proxy
		if(!(entryProxy instanceof PaletteAspectToolEntryProxy)) {
			return;
		}

		// this is a PaletteAspectToolEntryProxy
		// try to find the metaclass on which the element is working
		EClass metaClass = PaletteUtil.getToolMetaclass(((PaletteAspectToolEntryProxy)entryProxy).getEntry());

		if(metaClass == null) {
			Activator.log.error("Impossible to find metaclass", null); //$NON-NLS-1$
			return;
		}

		// retrieve the original stereotype list from the qualified names
		List<Stereotype> stereotypeList = retrieveStereotypesFromQualifiedNames();

		// we have all applied profiles, the list of already applied stereotypes, the metaclass of the created element...
		// just have to open a selection dialog
		final CheckedTreeSelectionDialog selectionDialog = new CheckedTreeSelectionDialog(DisplayUtils.getDisplay().getActiveShell(), stereotypeLabelProvider, new ProfileContentProvider(metaClass));
		selectionDialog.setTitle(Messages.StereotypePostAction_StereotypeSelectionTitle);
		selectionDialog.setMessage(Messages.StereotypePostAction_StereotypeSelectionMessage);
		selectionDialog.setContainerMode(true);
		selectionDialog.setInitialElementSelections(stereotypeList);
		selectionDialog.setInput(appliedProfiles);
		selectionDialog.setExpandedElements(appliedProfiles.toArray());

		ViewerComparator comparator = new ViewerComparator();
		selectionDialog.setComparator(comparator);


		if(CheckedTreeSelectionDialog.OK == selectionDialog.open()) {
			// update the list of stereotype to apply
			Object[] result = selectionDialog.getResult();
			stereotypesToApply = new ArrayList<String>();
			for(int i = 0; i < result.length; i++) {
				if(result[i] instanceof Stereotype) {
					stereotypesToApply.add(((Stereotype)result[i]).getQualifiedName());
				}
			}
			updateStereotypeViewer();
		}


	}

	/**
	 * Action done when the remove button is pressed
	 */
	protected void performRemoveAction() {
		saveExpandedNode();
		// remove the selected stereotype(s) from the list of stereotypes to apply
		ITreeSelection selection = (ITreeSelection)stereotypesViewer.getSelection();

		List<?> selectedElements = ((TreeSelection)selection).toList();
		if(selectedElements == null) {
			return;
		}

		/*
		 * get the level of the selection
		 * level 1 = the stereotypes
		 * level 2 = a mono-valued property
		 * level 3 = the values of the multi-valued properties
		 */
		int level = getSelectionLevel();


		switch(level) {
		case -1:
			return;
		case 1:
			//we remove stereotype
			//1:remove all the property owned by the stereotype, containing by the hashmaps
			for(Object steQN : selectedElements) {
				List<Stereotype> stereotypesList = retrieveStereotypesFromQualifiedNames();
				for(Stereotype stereotype : stereotypesList) {
					if(stereotype.getQualifiedName().equals(steQN)) {
						EList<Property> attributes = stereotype.getOwnedAttributes();
						for(Property property : attributes) {
							destroyPropertyInHashMaps(property);
						}

					}
				}
			}
			//2:remove the stereotype
			stereotypesToApply.removeAll(selection.toList());
			break;
		case 2:
			if((Property)selectedElements.get(0) instanceof Property) {
				Object value = propertiesToUpdate.get(selectedElements.get(0));
				Property property = (Property)selectedElements.get(0);
				removeValueFromHashMaps(property, value);
			}
			break;
		case 3:
			//we remove value from multi-valued properties
			for(Object object : selectedElements) {
				removeValueFromHashMaps(valuesToProperties.get(object), object);
			}
			break;
		default:
			break;
		}



		updateStereotypeViewer();
	}

	/**
	 * Action to do when the F2 key is pressed
	 * <ul>
	 * <li>open a CellEditor for the PrimitiveType and DataType</li>
	 * <li>open a popup editor for others types</li>
	 * </ul>
	 */
	protected void performF2Action() {

		TreeSelection selection = (TreeSelection)stereotypesViewer.getSelection();
		if(selection == null || selection.size() != 1) {
			return;
		}
		int level = getSelectionLevel();
		switch(level) {
		case -1:
			break;
		case 1://stereotype
				//nothing to do
			return;
		case 2://property
				//nothing to do
			break;
		case 3://edit a value
			Object objectToEdit = selection.getFirstElement();
			Property property = valuesToProperties.get(selection.getFirstElement());
			if(property != null) {//it's not a property
				Type type = property.getType();
				if(type instanceof PrimitiveType || type instanceof DataType) {
					stereotypesViewer.editElement(objectToEdit, 0);
				} else {//popupEditor
					saveExpandedNode();
					editMe(property, selection.getFirstElement());
					updateStereotypeViewer();
				}
			}
			break;
		default:
			break;

		}
	}

	/**
	 * Action done when a DoubleClick is received by the tree
	 * 
	 * @param event
	 */
	protected void performedDoubleClickAction(DoubleClickEvent event) {
		saveExpandedNode();
		TreeSelection selection = (TreeSelection)stereotypesViewer.getSelection();
		if(selection == null || selection.size() != 1) {
			return;
		}
		int level = getSelectionLevel();
		switch(level) {
		case -1:
			break;
		case 1://stereotype
				//we expand the node
			stereotypesViewer.setExpandedState(selection.getFirstElement(), !stereotypesViewer.getExpandedState(selection.getFirstElement()));
			return;
		case 2://property
			Property property = (Property)selection.getFirstElement();
			if(property.isMultivalued()) {
				//we expand the node
				stereotypesViewer.setExpandedState(selection.getFirstElement(), !stereotypesViewer.getExpandedState(selection.getFirstElement()));
				return;
			} else {
				//we edit a property value
				if(propertiesToUpdate.containsKey(property)) {
					editMe(property, propertiesToUpdate.get(property));
				} else {
					editMe(property, null);
				}
			}
			break;
		case 3://value
			Property propertyParent = valuesToProperties.get(selection.getFirstElement());
			editMe(propertyParent, selection.getFirstElement());
			break;
		default:
			break;

		}
		updateStereotypeViewer();
	}

	/**
	 * Action done when the user do CTRL^N on the tree
	 * 
	 * @param event
	 */
	protected void performedCTRL_N_Action(KeyEvent e) {
		saveExpandedNode();
		TreeSelection selection = (TreeSelection)stereotypesViewer.getSelection();
		if(selection == null || selection.size() != 1) {
			return;
		}
		int level = getSelectionLevel();
		switch(level) {
		case -1:
			break;
		case 1://stereotype
				//do nothing
			break;
		case 2://property
			Property property = (Property)selection.getFirstElement();
			if(property.isMultivalued()) {
				//can we add a new value?
				if(valuesToProperties.containsKey(property)) {
					int upperMultiplicity = property.getUpper();

					ArrayList<?> values = (ArrayList<?>)propertiesToUpdate.get(property);
					if(upperMultiplicity == -1 || values.size() < upperMultiplicity) {
						editMe(property, null);
					}
				}
				editMe(property, null);
			} else {
				//does a value exists yet?
				if(!propertiesToUpdate.containsKey(property)) {
					editMe(property, null);
				}
			}
			break;
		case 3://value
				//do nothing
			break;
		default:
			break;

		}
		updateStereotypeViewer();
	}

	/**
	 * Set the {@link Button#setEnabled(boolean)} parameter to true or false for the buttons following the selected element
	 * in the {@link StereotypePostAction#stereotypeViewer}
	 * <ul>
	 * <li> {@link StereotypePostAction#addButton}</li>
	 * <li> {@link StereotypePostAction#removeButton}</li>
	 * <li> {@link StereotypePostAction#upButton}</li>
	 * <li> {@link StereotypePostAction#downButton}</li>
	 * </ul>
	 * 
	 * @param event
	 */
	@SuppressWarnings("unchecked")
	protected void performedSelectionChange(SelectionChangedEvent event) {
		ITreeSelection selection = (ITreeSelection)event.getSelection();
		int level = getSelectionLevel();
		/*
		 * remove button state
		 */
		if(selection.size() > 0) {
			switch(level) {
			case -1:
				removeButton.setEnabled(false);
				break;
			case 1://stereotype
				removeButton.setEnabled(true);
				break;
			case 2://property
				Property property = (Property)selection.getFirstElement();
				if(property.getUpper() == 1 && propertiesToUpdate.containsKey(property)) {
					removeButton.setEnabled(true);
				} else {
					removeButton.setEnabled(false);
				}
				break;
			case 3://value
				removeButton.setEnabled(true);
				break;
			default:
				break;
			}
		} else {
			removeButton.setEnabled(false);
		}


		/*
		 * add button state
		 */
		if(selection.size() == 1) {
			switch(level) {
			case -1:
				addButton.setEnabled(false);
				break;
			case 1://stereotype
				addButton.setEnabled(true);
				break;
			case 2://property
				Property prop = (Property)selection.getFirstElement();
				if(!prop.isMultivalued()) {
					if(!propertiesToUpdate.containsKey(prop)) {
						addButton.setEnabled(true);
					} else {
						addButton.setEnabled(false);
					}
				} else {//multi-valued property}
					int upper = prop.getUpper();
					ArrayList<Object> values = (ArrayList<Object>)propertiesToUpdate.get(prop);
					if(values == null || upper == -1) {
						addButton.setEnabled(true);
					} else if(values.size() < upper) {
						addButton.setEnabled(true);
					} else {
						addButton.setEnabled(false);
					}
				}
				break;
			case 3://value
				addButton.setEnabled(false);
				break;
			default:
				break;
			}
		} else if(selection.size() == 0) {
			addButton.setEnabled(true);
		}


		/*
		 * up and down buttons state
		 * 
		 * We change the order of the values for a property, or the order for the stereotype
		 */
		if(selection.size() == 1) {
			switch(level) {
			case -1:

				break;
			case 1://stereotype
				int index = getIndexOf((ArrayList<?>)stereotypesToApply, selection.getFirstElement());
				if(stereotypesToApply.size() == 1) {
					downButton.setEnabled(false);
					upButton.setEnabled(false);
					break;
				} else if(index == 0) {
					downButton.setEnabled(true);
					upButton.setEnabled(false);
				} else if(index == stereotypesToApply.size() - 1) {
					downButton.setEnabled(false);
					upButton.setEnabled(true);
				} else {
					downButton.setEnabled(true);
					upButton.setEnabled(true);
				}
				break;
			case 2://property
				downButton.setEnabled(false);
				upButton.setEnabled(false);
				break;
			case 3://value
				Property property = valuesToProperties.get(selection.getFirstElement());
				ArrayList<Object> valuesList = (ArrayList<Object>)propertiesToUpdate.get(property);
				int index2 = getIndexOf(valuesList, selection.getFirstElement());
				if(((ArrayList<?>)propertiesToUpdate.get(property)).size() == 1) {
					upButton.setEnabled(false);
					downButton.setEnabled(false);
				} else if(index2 == 0) {
					upButton.setEnabled(false);
					downButton.setEnabled(true);
				} else if(index2 == valuesList.size() - 1) {
					upButton.setEnabled(true);
					downButton.setEnabled(false);
				} else {
					upButton.setEnabled(true);
					downButton.setEnabled(true);
				}
				break;
			default:
				break;
			}
		}
	}

	/**
	 * move the selected element in stereotypeViewer following shiftValue
	 * 
	 * shiftValue can take the values :
	 * <ul>
	 * <li>{@link StereotypePostAction#MOVE_UP}</li>
	 * <li>{@link StereotypePostAction#MOVE_DOWN}</li>
	 * </ul>
	 * 
	 * @param shiftValue
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected void moveElement(String shiftValue) {
		saveExpandedNode();
		TreeSelection selection = (TreeSelection)stereotypesViewer.getSelection();
		if(selection != null && selection.size() == 1) {
			Object selectedElement = selection.getFirstElement();

			if(valuesToProperties.containsKey(selectedElement)) {
				/** it's a property value */
				Property property = valuesToProperties.get(selectedElement);
				exchangeTwoValues((ArrayList<Object>)propertiesToUpdate.get(property), selectedElement, shiftValue);

			} else if(stereotypesToApply.contains(selectedElement)) {//it's OK, because it's the qualified name!
				/** it's a stereotype */
				exchangeTwoValues((ArrayList)stereotypesToApply, selectedElement, shiftValue);
			}
			updateStereotypeViewer();
		}
	}

	/**
	 * Exchange the selectedElement with its neighbor, in arrayList, up or down following shiftValue
	 * shiftValue can take the values :
	 * <ul>
	 * <li>{@link StereotypePostAction#MOVE_UP}</li>
	 * <li>{@link StereotypePostAction#MOVE_DOWN}</li>
	 * </ul>
	 * 
	 * @param arrayList
	 * @param selectedElement
	 * @param shiftValue
	 * 
	 */
	protected void exchangeTwoValues(ArrayList<Object> arrayList, Object selectedElement, String shiftValue) {
		int index = getIndexOf(arrayList, selectedElement);
		/**
		 * is it possible to move the object ?
		 */
		if(arrayList == null || arrayList.size() < 2) {
			//the list is to small
			return;
		}
		if((shiftValue.equals(MOVE_UP) && index == 0) || (shiftValue.equals(MOVE_DOWN) && arrayList.size() == (index + 1))) {
			//the selected element is already the first or the last
			return;
		}

		if(shiftValue.equals(MOVE_DOWN)) {
			arrayList.set(index, arrayList.get(index + 1));
			arrayList.set(index + 1, selectedElement);

		} else if(shiftValue.equals(MOVE_UP)) {
			arrayList.set(index, arrayList.get(index - 1));
			arrayList.set(index - 1, selectedElement);
		}
	}

	/**
	 * get the level of the selection
	 * level 1 = the stereotypes
	 * level 2 = a mono-valued property
	 * level 3 = the values of the multi-valued properties
	 * 
	 * return :
	 * - the level
	 * - or -1 if the selected elements belong to different level
	 */

	protected int getSelectionLevel() {
		ITreeSelection selection = (ITreeSelection)stereotypesViewer.getSelection();
		//we do the delete action, only if all the elements have the same level
		List<?> selectedElements = ((TreeSelection)selection).toList();
		if(selectedElements.isEmpty()) {
			return -1;
		}
		TreePath[] path = selection.getPathsFor(selectedElements.get(0));
		if(path == null) {
			return -1;
		}
		//the level for the first selected Element
		int level = path[0].getSegmentCount();
		for(Object object : selectedElements) {
			path = selection.getPathsFor(object);
			if(level != path[0].getSegmentCount()) {
				/**
				 * the selection is a mixed between different types of elements
				 */
				return -1;
			}
		}
		return level;
	}

	/**
	 * Retrieves the stereotype from its qualified name
	 * 
	 * @param stereotypeQualifiedName
	 * @return the stereotype or null if not found
	 */
	protected Stereotype retriveStereotypeFromQualifiedName(String stereotypeQualifiedName) {
		List<Stereotype> stereotypes = retrieveStereotypesFromQualifiedNames();
		for(Stereotype stereotype : stereotypes) {
			if(stereotype.getQualifiedName().equals(stereotypeQualifiedName)) {
				return stereotype;
			}
		}
		return null;
	}

	/**
	 * Retrieves the list of stereotypes to apply
	 * 
	 * @return the list of stereotypes to apply
	 */
	protected List<Stereotype> retrieveStereotypesFromQualifiedNames() {
		List<Stereotype> stereotypes = new ArrayList<Stereotype>();
		for(String qualifiedName : getStereotypesToApply()) {
			Stereotype stereotype = null;
			Iterator<Profile> it = appliedProfiles.iterator();
			while(stereotype == null && it.hasNext()) {
				stereotype = retrieveStereotypeFromQualifiedName(qualifiedName, it.next());
			}
			if(stereotype == null) {
				Activator.log.error("impossible to retrieve stereotype " + qualifiedName, null); //$NON-NLS-1$
			}
			stereotypes.add(stereotype);
		}
		return stereotypes;
	}

	/**
	 * Retrieves a Stereotype in a profile, given its qualified name.
	 * 
	 * @param qualifiedName
	 *        the qualified name of the steretoype to find
	 * @param profile
	 *        the profile to look in
	 * @return <code>null</code> or the found stereotype
	 */
	protected Stereotype retrieveStereotypeFromQualifiedName(String qualifiedName, Profile profile) {
		for(Stereotype stereotype : profile.getOwnedStereotypes()) {
			if(qualifiedName.equals(stereotype.getQualifiedName())) {
				return stereotype;
			}
		}
		return null;
	}

	/**
	 * Returns the list of stereotypes applied by this action
	 * 
	 * @return the list of stereotypes applied by this action
	 */
	public List<String> getStereotypesToApply() {
		return stereotypesToApply;
	}

	/**
	 * This class provides the methods for displaying the stereotypeViewer's column.
	 * This class gives the correct Label and it's {@link Image} to display for each element
	 * 
	 * 
	 */
	protected class EditorLabelProvider extends CellLabelProvider implements ILabelProvider {

		/**
		 * @see org.eclipse.jface.viewers.CellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
		 * 
		 * @param cell
		 */

		@Override
		public void update(ViewerCell cell) {
			cell.setText(getText(cell.getElement()));
			cell.setImage(getImage(cell.getElement()));

		}

		/**
		 * @{inheritDoc
		 */
		public String getText(Object element) {
			if(element instanceof Profile) {
				return ((Profile)element).getLabel();
			} else if(element instanceof Stereotype) {
				return ((Stereotype)element).getLabel();
			} else if(element instanceof Property) {
				Property prop = (Property)element;
				String label = prop.getLabel();
				label += ": " + prop.getType().getLabel() + getPropertyMultiplicity((Property)element) + " = " + getValueToDisplay((Property)element); //$NON-NLS-1$ //$NON-NLS-2$
				return label;
			}
			return element.toString();
		}

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */

		public Image getImage(Object element) {
			if(valuesToProperties.containsKey(element)) {
				//We are in the third level, it a property
				Property property = valuesToProperties.get(element);
				Type type = property.getType();
				if(type instanceof PrimitiveType) {
					String typeName = type.getQualifiedName();
					// property is a boolean property 

					if(UMLPrimitiveTypes_BOOLEAN.equals(typeName)) {
						return Activator.getPluginIconImage(Activator.ID, ICON_LITERALBOOLEAN);

						// property is a String 
					} else if(UMLPrimitiveTypes_STRING.equals(typeName)) {
						return Activator.getPluginIconImage(Activator.ID, ICON_LITERALSTRING);

						// property is an Integer 
					} else if(UMLPrimitiveTypes_INTEGER.equals(typeName)) {
						return Activator.getPluginIconImage(Activator.ID, ICON_LITERALINTEGER);

						// property is an unlimitedNatural 
					} else if(UMLPrimitiveTypes_UNLIMITED_NATURAL.equals(typeName)) {
						return Activator.getPluginIconImage(Activator.ID, ICON_LITERALUNLIMITEDNATURAL);
						// property is a user primitive Type 
					} else {
						//never used!
						//newVTO = new UserPrimitiveTypeValueTreeObject(parent, newValue, domain);
					}

					// property is a Metaclass property 
				} else if(Util.isMetaclass(type)) {
					return Activator.getPluginIconImage(Activator.ID, ICON_METACLASS);

					// property is an Enumeration 
				} else if(type instanceof org.eclipse.uml2.uml.Enumeration) {
					return Activator.getPluginIconImage(Activator.ID, ICON_ENUMERATION);

					// property is a DataType 
				} else if(type instanceof org.eclipse.uml2.uml.DataType) {
					return Activator.getPluginIconImage(Activator.ID, ICON_DATATYPE);

					// property is a Stereotype 
				} else if(type instanceof Stereotype) {
					return Activator.getPluginIconImage(Activator.ID, ICON_STEREOTYPE);

					// property is a composite class 
				} else if((type instanceof org.eclipse.uml2.uml.Class) && !(type instanceof Stereotype) && property.isMultivalued()) {
					//TODO

				}
			}

			/*
			 * the element is not a property value , it's can be :
			 * - a profile
			 * - a root stereotype
			 * - a property
			 */

			if(element instanceof Profile) {
				return Activator.getPluginIconImage(Activator.ID, ICON_PROFILE);
			} else if(element instanceof Property) {
				return Activator.getPluginIconImage(Activator.ID, ICON_PROPERTY);
			} else if(element instanceof String) {//it's a string
				return Activator.getPluginIconImage(Activator.ID, ICON_STEREOTYPE);
			} else if(element instanceof Stereotype) {//it's a stereotype 
				return Activator.getPluginIconImage(Activator.ID, ICON_STEREOTYPE);
			}

			return Activator.getPluginIconImage(Activator.ID, ICON_UNKNOWN);
		}
	}

	/**
	 * Label provider for the stereotype viewer
	 */
	protected class StereotypeLabelProvider implements ILabelProvider {


		/**
		 * @{inheritDoc
		 */
		public Image getImage(Object element) {


			/*
			 * the element is not a property value , it's can be :
			 * - a profile
			 * - a root stereotype
			 * - a property
			 */

			if(element instanceof Profile) {
				return Activator.getPluginIconImage(Activator.ID, ICON_PROFILE);
			} else if(element instanceof Property) {
				return Activator.getPluginIconImage(Activator.ID, ICON_PROPERTY);
			} else if(element instanceof String) {
				return Activator.getPluginIconImage(Activator.ID, ICON_STEREOTYPE);
			} else if(element instanceof Stereotype) {
				return Activator.getPluginIconImage(Activator.ID, ICON_STEREOTYPE);
			}

			return Activator.getPluginIconImage(Activator.ID, ICON_UNKNOWN);
		}

		/**
		 * @{inheritDoc
		 */
		public String getText(Object element) {
			if(element instanceof Profile) {
				return ((Profile)element).getLabel();
			} else if(element instanceof Stereotype) {
				return ((Stereotype)element).getLabel();
			}
			return element.toString();
		}

		/**
		 * @{inheritDoc
		 */
		public void addListener(ILabelProviderListener listener) {

		}

		/**
		 * @{inheritDoc
		 */
		public void dispose() {
		}

		/**
		 * @{inheritDoc
		 */
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		/**
		 * @{inheritDoc
		 */
		public void removeListener(ILabelProviderListener listener) {

		}

	}



	/**
	 * Content provider for the stereotype viewer
	 */
	protected class StereotypeContentProvider implements ITreeContentProvider {

		/**
		 * @{inheritDoc
		 */
		public Object[] getChildren(Object parentElement) {


			if(parentElement instanceof List<?>) {
				return ((List<?>)parentElement).toArray();

			}

			if(parentElement instanceof Property) {
				Property property = (Property)parentElement;
				if(property.isMultivalued()) {
					Object valuesList = propertiesToUpdate.get(property);
					if(valuesList instanceof ArrayList<?>) {
						return ((ArrayList<?>)valuesList).toArray();
					}
				}
			}

			List<Stereotype> steQN = retrieveStereotypesFromQualifiedNames();
			ArrayList<Property> returnedProperty = new ArrayList<Property>();

			for(Stereotype stereotype : steQN) {
				if(stereotype.getQualifiedName().equals(parentElement)) {
					Iterator<Property> propIt = stereotype.getAllAttributes().iterator();
					while(propIt.hasNext()) {
						final Property currentProp = propIt.next();
						// Select authorized properties
						// if(currentProp.isComposite() || (currentProp.getAssociation() == null)) {
						if(currentProp.getAssociation() != null) {
							if(!currentProp.getName().startsWith("base_")) //$NON-NLS-1$
								returnedProperty.add(currentProp);
						} else {
							returnedProperty.add(currentProp);
						}
					}

					return returnedProperty.toArray();
				}
			}


			return new Object[0];
		}

		/**
		 * @{inheritDoc
		 */
		public Object getParent(Object element) {
			return null;
		}

		/**
		 * @{inheritDoc
		 */
		public boolean hasChildren(Object element) {
			return getChildren(element) != null && (getChildren(element).length > 0);


		}

		/**
		 * @{inheritDoc
		 */
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		/**
		 * @{inheritDoc
		 */
		public void dispose() {

		}

		/**
		 * @{inheritDoc
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}
	}

	//	

	/**
	 * Content provider for the selection dialog
	 */
	protected class ProfileContentProvider implements ITreeContentProvider {

		/** metaclass of the element created by the tool */
		final protected EClass metaclass;


		/**
		 * Constructor.
		 * 
		 * @param metaclass
		 *        the metaclass on which stereotypes can be applied
		 */
		public ProfileContentProvider(EClass metaclass) {
			this.metaclass = metaclass;
		}

		/**
		 * @{inheritDoc
		 */
		public Object[] getChildren(Object parentElement) {
			List<org.eclipse.uml2.uml.Element> children = new ArrayList<org.eclipse.uml2.uml.Element>();
			if(parentElement instanceof Profile) {
				for(Stereotype stereotype : ((Profile)parentElement).getOwnedStereotypes()) {
					// check applicability
					boolean isValid = false;
					List<Class> metaclasses = stereotype.getAllExtendedMetaclasses();
					for(Class stMetaclass : metaclasses) {
						java.lang.Class<? extends Class> metaclassClass = stMetaclass.getClass();
						if(metaclassClass != null) {
							EClassifier metaClassifier = UMLPackage.eINSTANCE.getEClassifier(stMetaclass.getName());
							if(((EClass)metaClassifier).isSuperTypeOf(metaclass)) {
								isValid = true;
							}
						}
					}
					if(isValid) {
						children.add(stereotype);
					}
				}
			}
			return children.toArray();
		}

		/**
		 * @{inheritDoc
		 */
		public Object getParent(Object element) {
			if(element instanceof Profile) {
				return ((Profile)element).getOwner();
			} else if(element instanceof Stereotype) {
				return ((Stereotype)element).getProfile();
			}
			return null;
		}

		/**
		 * @{inheritDoc
		 */
		public boolean hasChildren(Object element) {
			return (element instanceof Profile);
		}

		/**
		 * @{inheritDoc
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof List<?>) {
				return ((List<?>)inputElement).toArray();
			}
			return new Object[0];
		}

		/**
		 * @{inheritDoc
		 */
		public void dispose() {

		}

		/**
		 * @{inheritDoc
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

	}

	/**
	 * 
	 * @param prop
	 * @return
	 *         return the string corresponding to the property multiplicity
	 */
	protected String getPropertyMultiplicity(Property prop) {
		String multiplicity = "[" + prop.getLower() + ".."; //$NON-NLS-1$ //$NON-NLS-2$
		int upper = prop.getUpper();
		if(upper == -1) {
			multiplicity += "*"; //$NON-NLS-1$
		} else {
			multiplicity += upper;
		}
		multiplicity += "]"; //$NON-NLS-1$
		return multiplicity;
	}

	/**
	 * 
	 * 
	 * @param property
	 * @return
	 *         return a string corresponding to the value to display for the property
	 * 
	 */
	protected String getValueToDisplay(Property property) {
		Object values = propertiesToUpdate.get(property);
		String stringToDisplay = null;
		if(values != null) {//a value exists. It's an ArrayList<SuperString> or a SuperString
			stringToDisplay = values.toString();
		} else if(property.isMultivalued()) {
			stringToDisplay = "[]"; //$NON-NLS-1$
		} else if(property.isSetDefault()) {
			stringToDisplay = property.getDefault();
		}
		return stringToDisplay;
	}

	/**
	 * Give the correct editor to a property following the property type.
	 * Fill the hashmaps with the new value
	 * <ul>
	 * <li>if {@code value==null}, we add a value to a multi-valued property</li>
	 * <li>if {@code value!=null}, we modify a value</li>
	 * </ul>
	 * 
	 * @param property
	 * @param value
	 */
	public void editMe(Property property, Object valueToEdit) {
		Type type = property.getType();
		String value = null;
		int upperMultiplicity = property.getUpper();
		// property is a a primitive type
		if(type instanceof PrimitiveType) {
			String typeName = type.getQualifiedName();
			// property is a boolean property 
			if(UMLPrimitiveTypes_BOOLEAN.equals(typeName)) {
				value = PropertyEditors.BooleanEditor(property, valueToEdit);
				// property is a String 

			} else if(UMLPrimitiveTypes_STRING.equals(typeName)) {
				value = PropertyEditors.StringEditor(property, valueToEdit);
				// property is an Integer 
			} else if(UMLPrimitiveTypes_INTEGER.equals(typeName)) {
				value = PropertyEditors.IntegerEditor(property, valueToEdit);


				// property is an unlimitedNatural 
			} else if(UMLPrimitiveTypes_UNLIMITED_NATURAL.equals(typeName)) {

				value = PropertyEditors.UnlimitedNaturalEditor(property, valueToEdit);

				/** property is a user primitive Type */
			} else {
				//never used!
				//newVTO = new UserPrimitiveTypeValueTreeObject(parent, newValue, domain);
			}

			// property is a Metaclass property 
		} else if(Util.isMetaclass(type)) {
			value = PropertyEditors.MetaclassEditor(property, valueToEdit, appliedProfiles);

			// property is an Enumeration 
		} else if(type instanceof org.eclipse.uml2.uml.Enumeration) {
			value = PropertyEditors.EnumerationEditor(property, valueToEdit);

			// property is a DataType 
		} else if(type instanceof org.eclipse.uml2.uml.DataType) {

			value = PropertyEditors.DataTypeEditor(property, valueToEdit);

			// property is a Stereotype 
		} else if(type instanceof Stereotype) {
			value = PropertyEditors.StereotypeEditor(property, valueToEdit, appliedProfiles);

			// property is a composite class 
		} else if((type instanceof org.eclipse.uml2.uml.Class) && !(type instanceof Stereotype) && property.isMultivalued()) {
			value = PropertyEditors.CompositeClassEditor(property, valueToEdit);
		} else {
			Activator.log.error("Impossible to find a correct editor for the property" + property, null); //$NON-NLS-1$
			return;
		}

		if(value == null && valueToEdit == null) {
			//nothing to do
			updateStereotypeViewer();
			return;
		} else if(value == null && valueToEdit != null) {
			//we delete a value
			removeValueFromHashMaps(property, value);
		} else if(value != null && valueToEdit == null) {
			//we add a value
			addInHashMaps(property, value);
		} else if(value != null && valueToEdit != null) {
			//we change a value
			replaceValueInHashMaps(property, value, valueToEdit);
		}
	}



	/**
	 * search the object in the ArrayList list, using == and not the equals method
	 * 
	 * @param list
	 * @param obj
	 * @return
	 *         return the index of the object or -1 if it doesn't exist in the list
	 */
	public int getIndexOf(ArrayList<?> list, Object obj) {
		int index = -1;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == obj) {
				index = i;
			}
		}
		return index;
	}


	/**
	 * save the expanded Nodes
	 */
	protected void saveExpandedNode() {
		if(expandedElements == null) {
			expandedElements = stereotypesViewer.getExpandedElements();
		}
	}

	/**
	 * restore the expanded nodes
	 */
	protected void restoreExpandedNode() {
		if(expandedElements != null) {
			stereotypesViewer.setExpandedElements(expandedElements);
			expandedElements = null;
		}
	}

	//-------------------------------------------------------the hashmap methods-------------------------------------------------------------

	/**
	 * 
	 * 
	 * @param propertyQN
	 *        the property identified by its qualified
	 * @return
	 *         <ul>
	 *         <li>the property</li>
	 *         <li>{@code null} if the property was not found</li>
	 *         </ul>
	 * 
	 */
	protected Property findPropertyByQualifiedName(String propertyQN) {

		String stereotypeQualifiedName = propertyQN.substring(0, propertyQN.lastIndexOf(NamedElement.SEPARATOR));
		Stereotype stereotype = retriveStereotypeFromQualifiedName(stereotypeQualifiedName);
		if(stereotype != null) {
			EList<Property> properties = stereotype.getOwnedAttributes();
			for(Property prop : properties) {
				if(prop.getQualifiedName().equals(propertyQN)) {
					return prop;
				}
			}
		}
		return null;
	}

	/**
	 * This function fills the 2 hashmaps {@link StereotypePostAction#valuesToProperties} and {@link StereotypePostAction#propertiesToUpdate}.
	 * This function must be called only one time by {@link StereotypePostAction#createConfigurationComposite(Composite, PaletteEntryProxy, List)} In
	 */

	protected void fillHashMaps() {

		if(!stereotypesToApply.isEmpty() && !valuesToProperties.isEmpty()) {
			return;
		}

		if(valuesToApply == null) {
			return;
		}
		Set<String> keys = valuesToApply.keySet();
		for(String propertyQN : keys) {
			Object value = valuesToApply.get(propertyQN);
			Property property = findPropertyByQualifiedName(propertyQN);
			if(value instanceof ArrayList<?>) {
				for(Object object : ((ArrayList<?>)value)) {
					addInHashMaps(property, object);
				}
			} else {
				addInHashMaps(property, value);
			}
		}
	}


	/**
	 * manage the filling of the two hashmaps!
	 * 
	 * @param property
	 *        the property to add in hasmaps
	 * @param value
	 *        the value associated to this property
	 */
	@SuppressWarnings("unchecked")
	protected void addInHashMaps(Property property, Object value) {
		if(value == null || property == null) {
			return;
		}

		/*
		 * 2 different strings with the same contents have the same hashcode!
		 * 
		 * it's a big problem with the hashmap!, so we use SuperString to have 2 different hashcodes
		 * for string with the same contents
		 */
		if(value instanceof String) {//in fact, all values are String!
			value = new SuperString((String)value);
		}

		valuesToProperties.put(value, property);
		if(property.isMultivalued()) {
			if(propertiesToUpdate.containsKey(property)) {
				((ArrayList<Object>)propertiesToUpdate.get(property)).add(value);
			} else {
				//we create a list
				ArrayList<Object> list = new ArrayList<Object>();
				list.add(value);
				propertiesToUpdate.put(property, list);
			}
		} else {
			propertiesToUpdate.put(property, value);
		}

	}

	/**
	 * manage the remove action in the two hashmaps!
	 * 
	 * @param property
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	protected void removeValueFromHashMaps(Property property, Object value) {
		if(value == null || property == null) {
			return;
		}
		valuesToProperties.remove(value);
		if(property.isMultivalued()) {
			ArrayList<Object> valuesList = (ArrayList<Object>)propertiesToUpdate.get(property);
			int index = getIndexOf(valuesList, value);
			valuesList.remove(index);
			if(valuesList.size() == 0) {
				propertiesToUpdate.remove(property);
			}
		} else {
			propertiesToUpdate.remove(property);
		}
	}

	/**
	 * manage the replace action in the two hashmaps!
	 * 
	 * @param property
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	protected void replaceValueInHashMaps(Property property, Object newValue, Object oldValue) {
		if(newValue == null || property == null || oldValue == null) {
			return;
		}

		if(newValue instanceof String) {
			newValue = new SuperString((String)newValue);
		}
		valuesToProperties.remove(oldValue);
		valuesToProperties.put(newValue, property);

		if(property.isMultivalued()) {
			ArrayList<Object> valuesList = (ArrayList<Object>)propertiesToUpdate.get(property);
			int index = getIndexOf(valuesList, oldValue);
			//we erase the oldValue
			valuesList.set(index, newValue);
		} else {
			//we erase the oldValue
			propertiesToUpdate.put(property, newValue);
		}
	}

	/**
	 * destroy a property in the hashmaps
	 * 
	 * @param property
	 */
	@SuppressWarnings("unchecked")
	protected void destroyPropertyInHashMaps(Property property) {
		if(property == null) {
			return;
		}
		if(propertiesToUpdate.containsKey(property)) {

			if(property.isMultivalued()) {
				ArrayList<Object> valuesList = (ArrayList<Object>)propertiesToUpdate.get(property);
				for(Object object : valuesList) {
					valuesToProperties.remove(object);
				}
			} else {
				valuesToProperties.remove(propertiesToUpdate.get(property));
			}
			propertiesToUpdate.remove(property);
		}
	}

	/**
	 * Class giving cell editors for the {@link stereotypesViewer}
	 */
	protected class AttributeEditingSupport extends EditingSupport {

		/** proposals for boolean */
		protected final String[] booleanProposals = new String[]{ "", "true", "false" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		/**
		 * Constructor.
		 * 
		 * @param viewer
		 *        viewer in which editors will open
		 */
		public AttributeEditingSupport(ColumnViewer viewer) {
			super(viewer);
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		/**
		 * @{inheritDoc
		 */
		@Override
		protected CellEditor getCellEditor(Object element) {
			Property property = null;
			if(element instanceof SuperString) {
				property = valuesToProperties.get(element);
			}
			if(property != null) {
				Type type = property.getType();
				if(type instanceof PrimitiveType) {
					String typeName = type.getQualifiedName();

					// property is a boolean property 
					if(UMLPrimitiveTypes_BOOLEAN.equals(typeName)) {
						return createBooleanEditor(stereotypesViewer.getTree());

						// property is a String 
					} else if(UMLPrimitiveTypes_STRING.equals(typeName)) {
						return new TextCellEditor(stereotypesViewer.getTree());

						// property is an Integer
					} else if(UMLPrimitiveTypes_INTEGER.equals(typeName)) {
						return new TextCellEditor(stereotypesViewer.getTree());
						// property is an unlimitedNatural
					} else if(UMLPrimitiveTypes_UNLIMITED_NATURAL.equals(typeName)) {
						return new TextCellEditor(stereotypesViewer.getTree());

						// property is a user primitive Type
					} else {
						//never used!
						//newVTO = new UserPrimitiveTypeValueTreeObject(parent, newValue, domain);
					}
				}
			}
			return null;


		}

		/**
		 * Creates and return a combobox cell editor for a boolean type
		 * 
		 * @param feature
		 *        the feature to edit
		 * @return the newly created combo box cell editor
		 */
		protected CellEditor createBooleanEditor(Composite parent) {
			return new ComboBoxCellEditor(parent, booleanProposals, SWT.READ_ONLY);
		}


		/**
		 * @{inheritDoc
		 */
		@Override
		protected Object getValue(Object element) {
			Property property = valuesToProperties.get(element);
			Type type = property.getType();

			if(type instanceof PrimitiveType) {
				String typeName = type.getQualifiedName();
				// property is a boolean property 
				if(UMLPrimitiveTypes_BOOLEAN.equals(typeName)) {
					return getBooleanValue((SuperString)element);

				}
				// property is a SuperString 
			} else if(element instanceof SuperString) {
				return ((SuperString)element).toString();
			}

			return element.toString();
		}

		/**
		 * Returns the value from the feature
		 * 
		 * @param feature
		 *        the feature to edit
		 * @return the boolean value
		 */
		protected Object getBooleanValue(SuperString str) {
			List<String> booleans = Arrays.asList(booleanProposals);
			if(str == null) {
				return 0;
			} else {
				return booleans.indexOf(str.toString());
			}
		}

		/**
		 * we use the Cell Editor only to replace a value.
		 */
		@Override
		protected void setValue(Object oldValue, Object newValue) {
			saveExpandedNode();
			//property can't be null, because, we change a value, we never create a new value
			if(!"".equals(newValue)) { //$NON-NLS-1$
				Property property = valuesToProperties.get(oldValue);
				if(property.getType() instanceof PrimitiveType) {
					String typeName = property.getType().getQualifiedName();
					if(UMLPrimitiveTypes_BOOLEAN.equals(typeName)) {
						setBooleanValue(oldValue, newValue);
					} else {
						replaceValueInHashMaps(property, newValue, oldValue);
					}
				} else {

					replaceValueInHashMaps(property, newValue, oldValue);
				}
			}
			updateStereotypeViewer();
		}

		/**
		 * Sets the new boolean value on the given element.
		 * 
		 * @param element
		 *        the model element
		 * @param value
		 *        the new value
		 */
		protected void setBooleanValue(Object oldValue, Object newValue) {
			Property property = valuesToProperties.get(oldValue);
			if(newValue == null || newValue.equals(0)) {
				removeValueFromHashMaps(property, oldValue);
			} else if(newValue.equals(1)) {
				replaceValueInHashMaps(property, booleanProposals[1], oldValue);
			} else if(newValue.equals(2)) {
				replaceValueInHashMaps(property, booleanProposals[2], oldValue);
			} else {
				Activator.log.error("Impossible to set boolean value " + newValue, null); //$NON-NLS-1$
			}
		}

	}

}
