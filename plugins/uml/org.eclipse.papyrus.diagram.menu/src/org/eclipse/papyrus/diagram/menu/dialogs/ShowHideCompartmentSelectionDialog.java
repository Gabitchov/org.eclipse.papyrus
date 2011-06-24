/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.diagram.menu.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.dialogs.AbstractCheckedTreeColumnViewerSelectionDialog;
import org.eclipse.papyrus.diagram.common.providers.EditorLabelProvider;
import org.eclipse.papyrus.diagram.common.util.CompartmentTitleRepresentation;
import org.eclipse.papyrus.diagram.common.util.CompartmentUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

/**
 * This class provides a Dialog with 2 columns. In the first column, we have a TreeViewer and in the other one, you have a text.
 * 
 * 
 * 
 */
public class ShowHideCompartmentSelectionDialog extends AbstractCheckedTreeColumnViewerSelectionDialog {

	/** path to the checked box image */
	protected final static String ICON_CHECKED = "/icons/complete_tsk.gif"; //$NON-NLS-1$

	/** path to the unchecked box image */
	protected final static String ICON_UNCHECKED = "/icons/incomplete_tsk.gif"; //$NON-NLS-1$

	/** all the title representation */
	protected List<CompartmentTitleRepresentation> titleRepresentations;

	/** the selected title representation */
	protected List<CompartmentTitleRepresentation> selectedTitles;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        the shell parent
	 * @param labelProvider
	 *        the label provider (used only to get the name of the root elements
	 * @param contentProvider
	 *        the content provider
	 * @param diagramEP
	 *        the current diagram EditPart
	 */
	public ShowHideCompartmentSelectionDialog(Shell parent, ILabelProvider labelProvider, ITreeContentProvider contentProvider) {
		super(parent, labelProvider, contentProvider, SWT.CENTER | SWT.BORDER | SWT.FULL_SELECTION, 2);
		init();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.dialogs.CustomCheckedTreeSelectionDialog#computeResult()
	 * 
	 */
	@Override
	protected void computeResult() {
		List<Object> chekedElement = Arrays.asList(getTreeViewer().getCheckedElements());
		List<Object> returnedValues = new ArrayList<Object>();
		returnedValues.addAll(selectedTitles);
		returnedValues.addAll(chekedElement);
		setResult(returnedValues);
	}

	/**
	 * Setter for {@link #titleRepresentations}
	 * 
	 * @param rep
	 *        the list of the title representation
	 */
	public void setTitleRepresentation(List<CompartmentTitleRepresentation> rep) {
		this.titleRepresentations = rep;
	}

	/**
	 * 
	 * @see org.eclipse.ui.dialogs.SelectionDialog#setInitialElementSelections(java.util.List)
	 * 
	 * @param selectedElements
	 */
	@SuppressWarnings("rawtypes")
	//remove the warning on the parameter (List instead of List<?>
	@Override
	public void setInitialElementSelections(List selectedElements) {
		super.setInitialElementSelections(selectedElements);
		this.selectedTitles = new ArrayList<CompartmentTitleRepresentation>();
		for(Object current : selectedElements) {
			if(current instanceof CompartmentTitleRepresentation) {
				this.selectedTitles.add((CompartmentTitleRepresentation)current);
			}
		}
	}

	/**
	 * Initialize the columns Width, the columns Titles and the LabelProvider for the viewer.
	 * 
	 */
	protected void init() {
		setColumnTitles(new String[]{ "Compartments To Display", "Display Name" });
		setColumnWidths(new int[]{ 300, 200 });
		setColumnCellLabelProvider(new CellLabelProvider[]{ new CompartmentNameProvider(), new CheckBoxLabelProvider() });
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.dialogs.AbstractCheckedTreeColumnViewerSelectionDialog#getEditingSupport(int)
	 * 
	 * @param columnIndex
	 * @return
	 */
	@Override
	protected EditingSupport getEditingSupport(int columnIndex) {
		if(columnIndex == 1) {
			return new NameVisibilityEditingSupport(getTreeViewer());
		}
		return null;
	}

	/**
	 * This class provides the editind support for the visibility of the name of the compartment
	 * 
	 * 
	 * 
	 */
	public class NameVisibilityEditingSupport extends EditingSupport {

		public NameVisibilityEditingSupport(ColumnViewer viewer) {
			super(viewer);
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		protected CellEditor getCellEditor(Object element) {
			if(element instanceof View) {
				TitleStyle style = (TitleStyle)((View)element).getStyle(NotationPackage.eINSTANCE.getTitleStyle());
				if(style != null) {
					CheckboxCellEditor editor = new CheckboxCellEditor();
					editor.setValue(getValue(element));
					return editor;
				}
			}
			return null;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		protected boolean canEdit(Object element) {
			if(element instanceof View) {
				EditPart dummyEP = EditPartService.getInstance().createGraphicEditPart((View)element);
				return dummyEP instanceof CompartmentEditPart;
			}
			return false;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		protected Object getValue(Object element) {
			if(element instanceof View) {
				CompartmentTitleRepresentation rep = CompartmentUtils.getCompartmentTitleRepresentation(titleRepresentations, (View)element);
				if(rep != null) {
					return selectedTitles.contains(rep);
				}
			}
			return false;

		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
		 * 
		 * @param element
		 * @param value
		 */
		@Override
		protected void setValue(Object element, Object value) {
			if(element instanceof View) {
				CompartmentTitleRepresentation rep = CompartmentUtils.getCompartmentTitleRepresentation(titleRepresentations, (View)element);
				if(rep != null) {
					if(value.equals(true)) {
						selectedTitles.add(rep);
					} else if(value.equals(false)) {
						selectedTitles.remove(rep);
					}
				}
			}
			getTreeViewer().refresh();
		}
	}


	/**
	 * This provider is used by the 2nd column
	 * 
	 * 
	 * 
	 */
	class CompartmentNameProvider extends CellLabelProvider implements ILabelProvider {

		/** the label provider */
		private final ILabelProvider provider;

		public CompartmentNameProvider() {
			provider = new EditorLabelProvider();
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public Image getImage(Object element) {
			return provider.getImage(element);
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public String getText(Object element) {
			return provider.getText(element);
		}


		/**
		 * 
		 * @see org.eclipse.jface.viewers.CellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
		 * 
		 * @param cell
		 */
		@Override
		public void update(ViewerCell cell) {
			cell.setImage(getImage(cell.getElement()));
			cell.setText(getText(cell.getElement()));
		}
	}

	/**
	 * The label provider for the 2nd column : Display Name
	 * 
	 * 
	 * 
	 */
	public class CheckBoxLabelProvider extends CellLabelProvider {

		/**
		 * 
		 * @see org.eclipse.jface.viewers.CellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
		 * 
		 * @param cell
		 */
		@Override
		public void update(ViewerCell cell) {
			cell.setImage(getImage(cell.getElement()));
			cell.setText(getText(cell.getElement()));

		}

		/**
		 * 
		 * @param element
		 *        an element
		 * @return
		 *         the text to display for this element
		 */
		private String getText(Object element) {
			if(element instanceof View) {
				TitleStyle style = (TitleStyle)((View)element).getStyle(NotationPackage.eINSTANCE.getTitleStyle());
				if(style == null) {
					return "No title to display";
				}
			}
			return null;
		}

		/**
		 * 
		 * @param element
		 *        an element
		 * @return
		 *         the image to display for this element
		 */
		private Image getImage(Object element) {
			if(element instanceof View) {
				TitleStyle style = (TitleStyle)((View)element).getStyle(NotationPackage.eINSTANCE.getTitleStyle());
				if(style != null) {
					CompartmentTitleRepresentation representation = CompartmentUtils.getCompartmentTitleRepresentation(titleRepresentations, (View)element);
					if(representation != null) {
						if(selectedTitles.contains(representation)) {
							return Activator.getPluginIconImage(Activator.ID, ICON_CHECKED);
						}
						return Activator.getPluginIconImage(Activator.ID, ICON_UNCHECKED);
					}
				} else {
					//nothing to do
				}
			}
			return null;
		}
	}
}
