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
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * This class provides methods to store the palette configuration concerning the
 * stereotypes application
 * 
 */
public class Configuration {

	/** name of the property node */
	public static final String PROPERTY = "property"; //$NON-NLS-1$

	/** name of the property name attribute */
	public static final String PROPERTY_NAME = "propertyName"; //$NON-NLS-1$

	/** name of the runtimeProperty attribute */
	public static final String RUNTIME_PROPERTY = "runtimeProperty"; //$NON-NLS-1$

	/** name of the stereotype node */
	public static final String STEREOTYPE = "stereotype"; //$NON-NLS-1$

	/** name of the stereotypes to apply node */
	public static final String STEREOTYPE_TO_APPLY = "stereotypesToApply"; //$NON-NLS-1$

	/** name of the property name */
	public static final String STEREOTYPE_NAME = "stereotypeName"; //$NON-NLS-1$

	/** name of the value node */
	public static final String VALUE = "value"; //$NON-NLS-1$

	/** the stereotypes representation list */
	private ArrayList<StereotypeRepresentation> myStereotypesList = new ArrayList<StereotypeRepresentation>();

	/** the configuration node */
	private Node configurationNode;

	/**
	 * the applied profile
	 */
	private List<Profile> appliedProfiles;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param configurationNode
	 */
	public Configuration(Node configurationNode) {
		this.configurationNode = configurationNode;
		this.buildConfiguration();
	}

	/**
	 * builds the configuration with the configurationNode contents That's to
	 * say create :
	 * <ul>
	 * <li> {@link StereotypeRepresentation}</li>
	 * <li> {@link PropertyRepresentation}</li>
	 * <li> {@link Value}</li>
	 * </ul>
	 * corresponding to the configuration node contents to populate the
	 * configuration
	 */
	public void buildConfiguration() {
		if(configurationNode == null) {
			return;
		}
		NamedNodeMap nodeAttributes = configurationNode.getAttributes();
		// transform old version in new version!
		if(null != nodeAttributes.getNamedItem(IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY)) {// old
																								// version
			String stereotypesToApplyQN = configurationNode.getAttributes().getNamedItem(IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY).getNodeValue();
			if(stereotypesToApplyQN != null && !"".equals(stereotypesToApplyQN)) { //$NON-NLS-1$
				List<String> stereotypesToApply = PaletteUtil.getStereotypeListFromString(stereotypesToApplyQN);
				for(String qualifiedName : stereotypesToApply) {
					myStereotypesList.add(new StereotypeRepresentation(qualifiedName));
				}
			}
		} else {// new version

			NodeList configurationChildren = configurationNode.getChildNodes();// stereotypesToApply
																				// Node
			Node stereotypesToApplyNode = null;

			for(int i = 0; i < configurationChildren.getLength(); i++) {
				Node configurationChild = configurationChildren.item(i);
				if(IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY.equals(configurationChild.getLocalName())) {
					stereotypesToApplyNode = configurationChild;
				}
			}

			if(stereotypesToApplyNode != null && stereotypesToApplyNode.hasChildNodes()) {
				NodeList childNodes = stereotypesToApplyNode.getChildNodes();
				for(int iter = 0; iter < childNodes.getLength(); iter++) {
					Node steNode = childNodes.item(iter);
					if(STEREOTYPE.equals(steNode.getLocalName())) {// this node
																	// is really
																	// a
																	// stereotype?

						String stereotypeName = steNode.getAttributes().getNamedItem(STEREOTYPE_NAME).getNodeValue();
						StereotypeRepresentation mySte = null;
						// does this stereotype exist?
						if(getStereotypeRepresentation(stereotypeName) == null) {
							mySte = new StereotypeRepresentation(stereotypeName);
						} else {
							mySte = getStereotypeRepresentation(stereotypeName);
						}

						// we store the stereotype
						if(steNode.hasChildNodes()) {// there are associated
														// properties and values
							NodeList properties = steNode.getChildNodes();
							for(int i = 0; i < properties.getLength(); i++) {// we
																				// iterate
																				// on
																				// the
																				// properties
								Node propertyNode = properties.item(i);
								if(PROPERTY.equals(propertyNode.getLocalName())) {// ist'
																					// a
																					// property
																					// node?
									String propertyName = propertyNode.getAttributes().getNamedItem(PROPERTY_NAME).getNodeValue();
									PropertyRepresentation proper = null;
									if(mySte.getPropertyRepresentation(stereotypeName, propertyName) != null) {
										proper = mySte.getPropertyRepresentation(stereotypeName, propertyName);
									} else {
										proper = new PropertyRepresentation(stereotypeName, propertyName);
										mySte.addProperty(proper);
									}

									NodeList valuesList = propertyNode.getChildNodes();

									for(int ii = 0; ii < valuesList.getLength(); ii++) {// we iterate
																						// on the
																						// values
										Node valueNode = valuesList.item(ii);
										if(VALUE.equals(valueNode.getLocalName())) {// this node
																					// is really
																					// a value?
											Value myValue = new Value(valueNode.getTextContent());
											proper.addValue(myValue);
										}
									}

								} else if(RUNTIME_PROPERTY.equals(propertyNode.getLocalName())) {// it's a runtime
																									// property
									String propertyName = propertyNode.getAttributes().getNamedItem(PROPERTY_NAME).getNodeValue();
									propertyName = propertyNode.getAttributes().getNamedItem(PROPERTY_NAME).getNodeValue();
									PropertyRepresentation prop = null;
									if(mySte.getPropertyRepresentation(stereotypeName, propertyName) != null) {
										prop = mySte.getPropertyRepresentation(stereotypeName, propertyName);
									} else {
										prop = new PropertyRepresentation(stereotypeName, propertyName);
										mySte.addProperty(prop);
									}
									prop.setRuntime(true);
								}
							}
						}
						myStereotypesList.add(mySte);
					}
				}
			}
		}
	}

	/**
	 * This method completes the {@link Configuration} object with the
	 * properties owned by each stereotype. It completes the contents obtained
	 * with the {@link #buildConfiguration()} method. This method is called by :
	 * <ul>
	 * <li>{@link #setAppliedProfiles(List)}</li>
	 * <li>{@link #setStereotypesRepresentations(ArrayList)}</li>
	 * </ul>
	 * 
	 */
	protected void completeData() {
		List<Stereotype> stereotypeList = retrieveAllStereotypesOwnedByTheProfiles();
		if(!stereotypeList.isEmpty()) {
			for(Stereotype ste : stereotypeList) {
				if(ste != null) {
					StereotypeRepresentation currentSte = null;
					// does this stereotype exist?
					if(getStereotypeRepresentation(ste.getQualifiedName()) == null) {
						currentSte = new StereotypeRepresentation(ste.getQualifiedName());
						myStereotypesList.add(currentSte);
					} else {
						currentSte = getStereotypeRepresentation(ste.getQualifiedName());
					}
					currentSte.setUMLStereotype(ste);
					EList<Property> attributs = ste.getAllAttributes();
					for(Property prop : attributs) {
						if(prop != null) {
							if((prop.getAssociation() == null && !prop.isDerived()) || ((prop.getAssociation() != null) && (!prop.getName().startsWith("base_")) && !prop.isDerived())) { //$NON-NLS-1$
								if(currentSte.getPropertyRepresentation(ste.getQualifiedName(), prop.getQualifiedName()) == null) {
									PropertyRepresentation myProp = new PropertyRepresentation(ste.getQualifiedName(), prop.getQualifiedName());
									myProp.setUMLProperty(prop);
									currentSte.addProperty(myProp);
								} else {
									currentSte.getPropertyRepresentation(ste.getQualifiedName(), prop.getQualifiedName()).setUMLProperty(prop);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Saves the configuration in the parentNode}
	 * 
	 * @param parentNode
	 *        the node that contains the configuration
	 */
	public void save(Node parentNode) {
		ListIterator<StereotypeRepresentation> it = getStereotypesRepresentations().listIterator();
		Element appliedStereotypeNode = ((Element)parentNode).getOwnerDocument().createElement(STEREOTYPE_TO_APPLY);
		while(it.hasNext()) {// iteration on stereotypes
			StereotypeRepresentation currentStereotype = it.next();
			Element stereotypeNode = ((Element)parentNode).getOwnerDocument().createElement(STEREOTYPE);
			stereotypeNode.setAttribute(STEREOTYPE_NAME, currentStereotype.getStereotypeQualifiedName());

			// the properties with value
			for(PropertyRepresentation prop : currentStereotype.getPropertiesWithValues()) {
				Element propertyNode = ((Element)parentNode).getOwnerDocument().createElement(PROPERTY);
				propertyNode.setAttribute(PROPERTY_NAME, prop.getQualifiedName());
				ArrayList<Value> values = prop.getValues();

				for(int i = 0; i < ((ArrayList<?>)values).size(); i++) {// iteration
																		// on
																		// values
					Element valueNode = ((Element)parentNode).getOwnerDocument().createElement(VALUE);
					valueNode.setTextContent(((ArrayList<?>)values).get(i).toString());
					propertyNode.appendChild(valueNode);
				}

				stereotypeNode.appendChild(propertyNode);

			}

			// the runtime properties
			for(PropertyRepresentation prop : currentStereotype.getRuntimeProperties()) {
				Element propertyNode = ((Element)parentNode).getOwnerDocument().createElement(RUNTIME_PROPERTY);
				propertyNode.setAttribute(PROPERTY_NAME, prop.getQualifiedName());
				stereotypeNode.appendChild(propertyNode);
			}

			appliedStereotypeNode.appendChild(stereotypeNode);

		}// end of iteration on stereotype
		parentNode.appendChild(appliedStereotypeNode);

	}

	/**
	 * Adds new stereotypes to the {@link Configuration}
	 * 
	 * @param stereotypesQNList
	 *        the list of stereotypes to add, identified by the qualified
	 *        name
	 */
	public void setStereotypesRepresentations(ArrayList<String> stereotypesQNList) {
		// 1. remove unused stereotype
		for(String oldSte : getStereotypesToApplyQN()) {
			if(!stereotypesQNList.contains(oldSte)) {
				myStereotypesList.remove(getStereotypeRepresentation(oldSte));
			}
		}
		// 2. add new stereotypes
		for(String ste : stereotypesQNList) {
			this.myStereotypesList.add(new StereotypeRepresentation(ste));
		}

		// 3. complete datas
		completeData();
	}

	/**
	 * 
	 * @param stereotypeQN
	 *        the stereotype to find in the configuration, identified by its
	 *        qualified name
	 * @return <ul>
	 *         <li>  {@link StereotypeRepresentation} if it exits
	 *         <li> {@code null} if not</li>
	 *         </ul>
	 */
	public StereotypeRepresentation getStereotypeRepresentation(String stereotypeQN) {
		for(StereotypeRepresentation ste : myStereotypesList) {
			if(ste.getStereotypeQualifiedName().equals(stereotypeQN)) {
				return ste;
			}
		}
		return null;
	}

	/**
	 * Returns the list of stereotypes contained by the {@link Configuration}
	 * 
	 * @return all the {@link StereotypeRepresentation} owned by the {@link Configuration}
	 */
	public ArrayList<StereotypeRepresentation> getStereotypesRepresentations() {
		return myStereotypesList;
	}

	/**
	 * Returns the list of applied stereotypes contained by the {@link Configuration}
	 * 
	 * @return the list of applied stereotypes identified by its qualified name
	 */
	public ArrayList<String> getStereotypesToApplyQN() {
		ArrayList<String> stereotypesList = new ArrayList<String>();
		for(StereotypeRepresentation ste : getStereotypesRepresentations()) {
			stereotypesList.add(ste.getStereotypeQualifiedName());
		}
		return stereotypesList;
	}

	/**
	 * 
	 * @param stereotype
	 *        the stereotype to remove from the {@link Configuration}
	 */
	public void removeStereotype(StereotypeRepresentation stereotype) {
		myStereotypesList.remove(stereotype);
	}

	/**
	 * setter for {@link #appliedProfiles} moreover call {@link #completeData()} to complete the {@link Configuration}
	 * 
	 * @param appliedProfiles
	 *        the profiles to apply
	 */
	public void setAppliedProfiles(List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		this.completeData();

	}

	/**
	 * Returns the list of the applied {@link Profile}
	 * 
	 * @return the applied profiles
	 */
	public List<Profile> getAppliedProfiles() {
		return this.appliedProfiles;
	}

	/**
	 * Retrieves the list of stereotypes owned by {@link #appliedProfiles}
	 * 
	 * @return the list of stereotypes owned by the profiles
	 * 
	 */
	protected List<Stereotype> retrieveAllStereotypesOwnedByTheProfiles() {
		List<Stereotype> stereotypes = new ArrayList<Stereotype>();
		for(String qualifiedName : getStereotypesToApplyQN()) {
			Stereotype stereotype = null;
			Iterator<Profile> it = getAppliedProfiles().iterator();
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
	 *        the qualified name of the stereotype to find
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
	 * Returns all the stereotypes
	 * 
	 * @return all the stereotypes
	 */
	public List<Stereotype> getUMLStereotypes() {
		ArrayList<Stereotype> list = new ArrayList<Stereotype>();
		for(StereotypeRepresentation ste : myStereotypesList) {
			list.add(ste.getUMLStereotype());
		}
		return list;
	}

	/**
	 * 
	 * @return <ul>
	 *         <li>  {@code true} if there is runtime properties
	 *         <li> {@code false} if not</li>
	 *         </ul>
	 */
	public boolean hasRuntimeProperties() {
		for(StereotypeRepresentation ste : myStereotypesList) {
			if(ste.hasRuntimeProperties()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the configuration node
	 * 
	 * @return the configuration node
	 */
	public Node getConfigurationNode() {
		return configurationNode;
	}

}
