/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.internal.parts.TextCellEditorEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.ExtendedDirectEditionDialog;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.uml.diagram.common.directedit.FigureControler;
import org.eclipse.papyrus.uml.diagram.common.directedit.ILabelControler;
import org.eclipse.papyrus.uml.diagram.common.directedit.PropertyAccessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Extended edit policy for direct edit. this policy checks if an editor is
 * available in the editor registry for the given edited element
 */
public class ExtendedDirectEditPolicy extends LabelDirectEditPolicy {

	/** direct edition mode (default, undefined, registered editor, etc.) */
	protected int directEditionMode = IDirectEdition.UNDEFINED_DIRECT_EDITOR;

	/** configuration from a registered edit dialog */
	private IDirectEditorConfiguration configuration;

	/** Manager for editing class name */
	protected DirectEditManager manager;

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		return performDirectEdit(request);
	}

	/**
	 * The direct edit mechanism requires the edit part to handle the direct
	 * edit request.
	 * 
	 * @param req
	 *        the request that called the direct edit.
	 */
	public Command performDirectEdit(DirectEditRequest req) {
		if(IDirectEdition.UNDEFINED_DIRECT_EDITOR == directEditionMode) {
			directEditionMode = getDirectEditionType();
		}
		switch(directEditionMode) {
		case IDirectEdition.NO_DIRECT_EDITION:
			// no direct edition mode => does nothing
			return null;
		case IDirectEdition.EXTENDED_DIRECT_EDITOR:
			// opens a dialog using specific configuration
			configuration.preEditAction(getUMLElement());
			final ExtendedDirectEditionDialog dialog = new ExtendedDirectEditionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), getUMLElement(), configuration.getTextToEdit(getUMLElement()), configuration);
			if(Window.OK == dialog.open()) {
				TransactionalEditingDomain domain = getEditingDomain();
				try {
					domain.runExclusive(new RunnableWithResult() {

						private Object result = null;

						private IStatus status = Status.OK_STATUS;

						public Object getResult() {
							return result;
						}

						public IStatus getStatus() {
							return status;
						}

						public void setStatus(IStatus status) {
							this.status = status;
						}

						public void run() {
							result = configuration.postEditAction(getUMLElement(), dialog.getValue());
						}

					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return null;
		case IDirectEdition.DEFAULT_DIRECT_EDITOR:
			return super.getDirectEditCommand(req);
		default:
			return null;
		}

	}

	/**
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View)getHost().getModel();
	}

	/**
	 * Returns the {@link Element} managed by this edit part.
	 * 
	 * @return the {@link Element} managed by this edit part.
	 */
	protected Element getUMLElement() {
		return (Element)getView().getElement();
	}

	/**
	 * Returns the style of direct edition.
	 * <p>
	 * Note: This method should never be overridden. Override sub-methods instead.
	 * </p>
	 * 
	 * @return the style of direct edition
	 */
	public int getDirectEditionType() {
		if(checkExtendedEditor()) {
			initExtendedEditorConfiguration();
			return IDirectEdition.EXTENDED_DIRECT_EDITOR;
		}
		if(checkDefaultEdition()) {
			return IDirectEdition.DEFAULT_DIRECT_EDITOR;
		}

		// not a named element. no specific editor => do nothing
		return IDirectEdition.NO_DIRECT_EDITION;
	}

	/**
	 * Checks if an extended editor is present.
	 * 
	 * @return <code>true</code> if an extended editor is present.
	 */
	protected boolean checkExtendedEditor() {
		if(getUMLElement() != null) {
			return DirectEditorsUtil.hasSpecificEditorConfiguration(IDirectEditorsIds.UML_LANGUAGE, getUMLElement().eClass().getInstanceClassName());
		}
		return false;
	}

	/**
	 * Checks if a default direct edition is available
	 * 
	 * @return <code>true</code> if a default direct edition is available
	 */
	protected boolean checkDefaultEdition() {
		return (getUMLElement() instanceof NamedElement);
	}

	/**
	 * Initializes the extended editor configuration
	 */
	protected void initExtendedEditorConfiguration() {
		if(configuration == null) {
			configuration = DirectEditorsUtil.findEditorConfiguration(IDirectEditorsIds.UML_LANGUAGE, getUMLElement().eClass().getInstanceClassName());
		}
	}

	/**
	 * Init the label direct edit manager. This method should be called when a
	 * Direct Edit request is performed.
	 */
	// @unused
	protected void initLabelEditManager() {
		if(manager == null) {
			// locator for the cell editor (on the name label)
			CellEditorLocator locator = getTextCellEditorLocator();

			// defining how properties are modified in the model
			PropertyAccessor accessor = new PropertyAccessor() {

				@Override
				public String getPropertyName() {
					return "Name";
				}

				@Override
				public String getValue() {
					if(isElementImport()) {
						return getElementImport().getAlias();
					} else if(getUMLElement() instanceof NamedElement) {
						return ((NamedElement)getUMLElement()).getName();
					}
					return "";

				}

				@Override
				public void setValue(String value) {
					if(isElementImport()) {
						getElementImport().setAlias(value);
					} else if(getUMLElement() instanceof NamedElement) {
						((NamedElement)getUMLElement()).setName(value);
					}
				}
			};
			// defines the controller: link between model and view
			ILabelControler labelControler = new FigureControler(getHostFigure(), accessor);

			// creates the editing manager.
			manager = new TextDirectEditManager((GraphicalEditPart)getHost(), TextCellEditorEx.class, locator);
		}
	}

	private CellEditorLocator getTextCellEditorLocator() {
		if(getHostFigure() instanceof WrappingLabel) {
			return new TextCellEditorLocator((WrappingLabel)getHostFigure());
		} else if(getHostFigure() instanceof WrappingLabel) {
			return new LabelCellEditorLocator((Label)getHostFigure());
		} else {
			Activator.log("Problem to locate the direct edit editor. Figure is neither a label nor a wrapping label");
			return null;
		}
	}

	/**
	 * Returns <code>true</code> if the uml element is an element import
	 * 
	 * @return <code>true</code> if the uml element is an element import
	 */
	public boolean isElementImport() {
		return (getUMLElement() instanceof ElementImport);
	}

	/**
	 * Returns the element associated to the edit part hosting this edit policy
	 * 
	 * @return the element associated to the edit part hosting this edit policy
	 *         or <code>null</code> if the element is not an element import
	 */
	public ElementImport getElementImport() {
		if(isElementImport()) {
			return (ElementImport)getUMLElement();
		}
		return null;
	}

	private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private final WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if(getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	private class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private final Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * retrieves the host editing domain
	 * 
	 * @return the {@link TransactionalEditingDomain} of the host edit part.
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

}
