/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.parts;

// Start of user code for imports

import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public interface ParameterPropertiesEditionPart {

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * Defines a new name
	 * 
	 * @param newValue
	 *        the new name to set
	 */
	public void setName(String newValue);

	public void setMessageForName(String msg, int msgLevel);

	public void unsetMessageForName();

	/**
	 * @return the visibility
	 */
	public Enumerator getVisibility();

	/**
	 * Init the visibility
	 * 
	 * @param eenum
	 *        the enum to manage
	 * @param current
	 *        the current value
	 */
	public void initVisibility(EEnum eenum, Enumerator current);

	/**
	 * Defines a new visibility
	 * 
	 * @param newValue
	 *        the new visibility to set
	 */
	public void setVisibility(Enumerator newValue);





	/**
	 * @return the type
	 */
	public EObject getType();

	/**
	 * Init the type
	 * 
	 * @param allResources
	 *        the ResourceSet where the widget have to process
	 * @param current
	 *        the current value
	 */
	public void initType(ResourceSet allResources, EObject current);

	/**
	 * Defines a new type
	 * 
	 * @param newValue
	 *        the new type to set
	 */
	public void setType(EObject newValue);

	/**
	 * Defines the button mode
	 * 
	 * @param newValue
	 *        the new mode to set
	 */
	public void setTypeButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the type edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToType(ViewerFilter filter);

	/**
	 * Adds the given filter to the type edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToType(ViewerFilter filter);





	/**
	 * @return the direction
	 */
	public Enumerator getDirection();

	/**
	 * Init the direction
	 * 
	 * @param eenum
	 *        the enum to manage
	 * @param current
	 *        the current value
	 */
	public void initDirection(EEnum eenum, Enumerator current);

	/**
	 * Defines a new direction
	 * 
	 * @param newValue
	 *        the new direction to set
	 */
	public void setDirection(Enumerator newValue);





	/**
	 * @return the effect
	 */
	public Enumerator getEffect();

	/**
	 * Init the effect
	 * 
	 * @param eenum
	 *        the enum to manage
	 * @param current
	 *        the current value
	 */
	public void initEffect(EEnum eenum, Enumerator current);

	/**
	 * Defines a new effect
	 * 
	 * @param newValue
	 *        the new effect to set
	 */
	public void setEffect(Enumerator newValue);





	/**
	 * @return the isOrdered
	 */
	public Boolean getIsOrdered();

	/**
	 * Defines a new isOrdered
	 * 
	 * @param newValue
	 *        the new isOrdered to set
	 */
	public void setIsOrdered(Boolean newValue);





	/**
	 * @return the isUnique
	 */
	public Boolean getIsUnique();

	/**
	 * Defines a new isUnique
	 * 
	 * @param newValue
	 *        the new isUnique to set
	 */
	public void setIsUnique(Boolean newValue);





	/**
	 * @return the isException
	 */
	public Boolean getIsException();

	/**
	 * Defines a new isException
	 * 
	 * @param newValue
	 *        the new isException to set
	 */
	public void setIsException(Boolean newValue);





	/**
	 * @return the isStream
	 */
	public Boolean getIsStream();

	/**
	 * Defines a new isStream
	 * 
	 * @param newValue
	 *        the new isStream to set
	 */
	public void setIsStream(Boolean newValue);





	/**
	 * @return the lower
	 */
	public String getLower();

	/**
	 * Defines a new lower
	 * 
	 * @param newValue
	 *        the new lower to set
	 */
	public void setLower(String newValue);

	public void setMessageForLower(String msg, int msgLevel);

	public void unsetMessageForLower();

	/**
	 * @return the upper
	 */
	public String getUpper();

	/**
	 * Defines a new upper
	 * 
	 * @param newValue
	 *        the new upper to set
	 */
	public void setUpper(String newValue);

	public void setMessageForUpper(String msg, int msgLevel);

	public void unsetMessageForUpper();

	/**
	 * @return the parameterSet to add
	 */
	public List getParameterSetToAdd();

	/**
	 * @return the parameterSet to remove
	 */
	public List getParameterSetToRemove();

	/**
	 * @return the current parameterSet table
	 */
	public List getParameterSetTable();

	/**
	 * Init the parameterSet
	 * 
	 * @param current
	 *        the current value
	 * @param containgFeature
	 *        the feature where to navigate if necessary
	 * @param feature
	 *        the feature to manage
	 */
	public void initParameterSet(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the parameterSet
	 * 
	 * @param newValue
	 *        the parameterSet to update
	 */
	public void updateParameterSet(EObject newValue);

	/**
	 * Adds the given filter to the parameterSet edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToParameterSet(ViewerFilter filter);

	/**
	 * Adds the given filter to the parameterSet edition editor.
	 * 
	 * @param filter
	 *        a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToParameterSet(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the parameterSet table
	 */
	public boolean isContainedInParameterSetTable(EObject element);





	// Start of user code for additional methods

	// End of user code

}
