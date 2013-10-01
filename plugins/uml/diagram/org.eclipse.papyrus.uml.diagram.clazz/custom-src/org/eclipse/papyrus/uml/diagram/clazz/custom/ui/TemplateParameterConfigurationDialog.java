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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.uml.diagram.common.ui.dialogs.ElementChooseDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.TemplateSignature;

// TODO: Auto-generated Javadoc
/**
 * this class is used to select parameterable element by taking account the kind of the paramter.
 */
public class TemplateParameterConfigurationDialog extends AbstractTemplateParameterConfigurationDialog {

	/** The templatesignature. */
	protected TemplateSignature templatesignature;

	/** The parameterable element. */
	protected ParameterableElement parameterableElement;

	/** The defaultparameterable element. */
	protected ParameterableElement defaultparameterableElement;

	/** The eclass. */
	protected EClass eclass;

	/** The not wanted. */
	protected List<EClass> notWanted = null;

	/**
	 * Gets the parameterable element.
	 * 
	 * @return the parameterable element
	 */
	public ParameterableElement getParameterableElement() {
		return parameterableElement;
	}

	/**
	 * Gets the defaultparameterable element.
	 * 
	 * @return the defaultparameterable element
	 */
	public ParameterableElement getDefaultparameterableElement() {
		return defaultparameterableElement;
	}

	/**
	 * Instantiates a new template parameter configuration dialog.
	 * 
	 * @param parent
	 *        the shell parent
	 * @param style
	 *        the style see {@link SWT}
	 * @param elementtype
	 *        the elementtype the kind of parameterable element that we look for
	 */
	public TemplateParameterConfigurationDialog(Shell parent, int style, EClass elementtype) {
		super(parent, style);
		this.eclass = elementtype;
		this.notWanted = new ArrayList<EClass>();
	}

	/**
	 * Instantiates a new template parameter configuration dialog.
	 * 
	 * @param parent
	 *        the parent
	 * @param style
	 *        the style
	 * @param elementtype
	 *        the elementtype
	 * @param eclassNotWanted
	 *        the list of eclass that we do not want to select, can not be null
	 */
	public TemplateParameterConfigurationDialog(Shell parent, int style, EClass elementtype, List<EClass> eclassNotWanted) {
		super(parent, style);
		this.eclass = elementtype;
		assert (notWanted != null);
		this.notWanted = eclassNotWanted;
	}

	/**
	 * Sets the owner.
	 * 
	 * @param templateSignature
	 *        the new owner
	 */
	public void setOwner(TemplateSignature templateSignature) {
		this.templatesignature = templateSignature;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.clazz.custom.ui.AbstractTemplateParameterConfigurationDialog#createContents()
	 * 
	 */
	@Override
	protected void createContents() {
		// TODO Auto-generated method stub
		super.createContents();
		getParameteredElementContent().setText("");
		getDefaultElementContent().setText("");
		final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
		getChoosePararameteredElementButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				ElementChooseDialog elementChoose = new ElementChooseDialog(new Shell(), SWT.None, templatesignature.getTemplate(), eclass, notWanted);
				if(elementChoose.open() != null) {
					parameterableElement = ((ParameterableElement)elementChoose.getSelectedElement());
					labelProvider.getText(parameterableElement);
					getParameteredElementContent().setText(labelProvider.getText(parameterableElement));
					getParameteredElementContent().setImage(labelProvider.getImage(parameterableElement));
				}
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		getChooseDefaultParameterButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				if(parameterableElement != null) {
					ElementChooseDialog elementChoose = new ElementChooseDialog(new Shell(), SWT.None, templatesignature.getTemplate(), parameterableElement.eClass());
					if(elementChoose.open() != null) {
						defaultparameterableElement = ((ParameterableElement)elementChoose.getSelectedElement());
						labelProvider.getText(defaultparameterableElement);
						getDefaultElementContent().setText(labelProvider.getText(defaultparameterableElement));
						getDefaultElementContent().setImage(labelProvider.getImage(defaultparameterableElement));
					}
				}
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		getBtnCancel().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				getParent().close();
				defaultparameterableElement = null;
				parameterableElement = null;
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		getBtnExecute().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				getParent().close();
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
	}
}
