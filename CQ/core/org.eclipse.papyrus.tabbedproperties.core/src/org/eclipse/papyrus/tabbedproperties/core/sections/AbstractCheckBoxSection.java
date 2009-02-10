/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.sections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.papyrus.tabbedproperties.core.forms.LabeledCheckBoxFigure;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.listeners.BooleanPropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.EmfAdapterWrapper;
import org.eclipse.uml2.uml.Element;

public abstract class AbstractCheckBoxSection<UmlElementType extends Element> extends AbstractEnhancedPropertySection {

	protected LabeledCheckBoxFigure checkboxFigure;

	protected UmlElementType businessElement;

	private BusinessModelListener modelListener = new BusinessModelListener();

	private String labelName;

	private String description;

	public AbstractCheckBoxSection(String labelName, String description) {
		super();
		this.labelName = labelName;
		this.description = description;
	}

	@Override
	public PropertyEditor createFigure() {
		checkboxFigure = new LabeledCheckBoxFigure(labelName, description);
		return checkboxFigure;

	}

	public void initializeFigure() {
		BooleanPropertyChangeListener editorListener = createFigurePropertyChangedListener();
		checkboxFigure.setPropertyChangeListener(editorListener);
	}

	/**
	 * Create the listener on the figure change
	 * 
	 * @return
	 */
	protected abstract BooleanPropertyChangeListener createFigurePropertyChangedListener();

	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		businessElement.eAdapters().add(modelListener);
	}

	@Override
	public void aboutToBeHidden() {
		// Stop listening
		businessElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	@Override
	public void dispose() {
		// stop listening
		if (businessElement != null) {
			businessElement.eAdapters().remove(modelListener);
		}
		if (checkboxFigure != null) {
			checkboxFigure.dispose();
		}
		super.dispose();
	}

	/**
	 * Listen to change in the property from the model..
	 * 
	 * @author dumoulin
	 * 
	 */
	public class BusinessModelListener extends EmfAdapterWrapper {

		public void notifyChanged(Notification notification) {
			refresh();
		}
	}

}