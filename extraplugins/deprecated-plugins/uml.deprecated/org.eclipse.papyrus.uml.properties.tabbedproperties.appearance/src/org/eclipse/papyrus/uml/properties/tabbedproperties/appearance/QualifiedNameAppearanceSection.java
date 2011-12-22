/*****************************************************************************
 * Copyright (c) 2008, 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.tabbedproperties.appearance;

import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.tools.utils.ui.command.SetQualifiedNameDepthCommand;
import org.eclipse.papyrus.uml.tools.utils.ui.helper.QualifiedNameHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * The Class QualifiedNameAppearanceSection allow users to customize the display of qualified name.
 * 
 */
public class QualifiedNameAppearanceSection extends AbstractPropertySection {

	/**
	 * The stereotype appearance.
	 */
	private CLabel qualifiedNameAppearance;

	/**
	 * The combo stereotype appearance.
	 */
	private CCombo comboQualifiedNameAppearance;

	/**
	 * The combo stereotype appearance listener.
	 */
	private SelectionListener comboQualifiedNameAppearanceListener;

	private GraphicalEditPart namedElementEditPart;

	private IMultiDiagramEditor editor;

	private TransactionalEditingDomain editingDomain;

	/**
	 * Creates the controls.
	 * 
	 * @param tabbedPropertySheetPage
	 *        the tabbed property sheet page
	 * @param parent
	 *        the parent
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		qualifiedNameAppearance = getWidgetFactory().createCLabel(composite, "Qualified Name Depth:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		// data.right = new FormAttachment(comboQualifiedNameAppearance,0);
		data.top = new FormAttachment(qualifiedNameAppearance, 1, SWT.CENTER);
		qualifiedNameAppearance.setLayoutData(data);

		comboQualifiedNameAppearance = getWidgetFactory().createCCombo(composite, SWT.BORDER);
		comboQualifiedNameAppearance.add("Full");

		data = new FormData();
		data.left = new FormAttachment(qualifiedNameAppearance, 0);
		data.top = new FormAttachment(0, 0);
		comboQualifiedNameAppearance.setLayoutData(data);

		comboQualifiedNameAppearanceListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				updateSelectedElements();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		comboQualifiedNameAppearance.addSelectionListener(comboQualifiedNameAppearanceListener);

	}

	// @unused
	public int getQualifiedNamedepth(View view) {
		EAnnotation stereotypeDisplayKind = (view).getEAnnotation(VisualInformationPapyrusConstant.QUALIFIED_NAME);
		if(stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			if(entries != null) {
				String depthString = entries.get(VisualInformationPapyrusConstant.QUALIFIED_NAME_DEPTH);
				if(depthString != null) {
					Integer i = new Integer(depthString);
					return i.intValue();
				}
			}
		}
		return 0;
	}

	/*
	 * @see org.eclipse.ui.views.properties.tabbed.view.ITabbedPropertySection#refresh ()
	 */
	/**
	 * Refresh.
	 */
	@Override
	public void refresh() {
		if((!comboQualifiedNameAppearance.isDisposed())) {

			comboQualifiedNameAppearance.removeSelectionListener(comboQualifiedNameAppearanceListener);

			if(namedElementEditPart != null) {

				if((namedElementEditPart.getModel()) != null
						&& ((View)(namedElementEditPart.getModel())).getElement() != null) {

					org.eclipse.uml2.uml.Element element = (Element)((View)(namedElementEditPart.getModel()))
							.getElement();

					if(element instanceof NamedElement) {

						comboQualifiedNameAppearance.setEnabled(true);
						// delete all old items
						comboQualifiedNameAppearance.removeAll();

						// calculate the max depth of qualified name
						int depth = NamedElementUtil.getQualifiedNameMaxDepth((NamedElement)element);

						// build new items
						if(depth != 0) {
							comboQualifiedNameAppearance.add("Full");
							for(int i = 1; i < depth; i++) {
								comboQualifiedNameAppearance.add("-" + i);
							}
							comboQualifiedNameAppearance.add("None");
						} else {// case of root modelElement
							comboQualifiedNameAppearance.add("None");
						}

						int qualifiedNameDepth = QualifiedNameHelper
								.getQualifiedNameDepth((EModelElement)(namedElementEditPart.getModel()));

						if(depth != 0) {
							if(qualifiedNameDepth == 0) {
								comboQualifiedNameAppearance.setText("Full");
							} else if(qualifiedNameDepth >= depth) {
								comboQualifiedNameAppearance.setText("None");
							} else {
								comboQualifiedNameAppearance.setText("-" + qualifiedNameDepth);
							}
						} else {
							comboQualifiedNameAppearance.setText("None");
						}

					} else {
						comboQualifiedNameAppearance.setEnabled(false);
						comboQualifiedNameAppearance.setText("None");
					}
				}
			}
			comboQualifiedNameAppearance.addSelectionListener(comboQualifiedNameAppearanceListener);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		super.dispose();
		if(comboQualifiedNameAppearance != null && !comboQualifiedNameAppearance.isDisposed()) {
			comboQualifiedNameAppearance.removeSelectionListener(comboQualifiedNameAppearanceListener);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		Object input = ((IStructuredSelection)selection).getFirstElement();
		// look for modelManager
		if(input instanceof GraphicalEditPart) {
			namedElementEditPart = ((GraphicalEditPart)input);
			// selectionChanged(selection);
		}
		// When the selection is computed from the outline, get the associated
		// editor
		if(part instanceof ContentOutline) {
			IContributedContentsView contributedView = ((IContributedContentsView)((ContentOutline)part)
					.getAdapter(IContributedContentsView.class));
			if(contributedView != null) {
				part = contributedView.getContributingPart();
			}
		}
		if(part instanceof IMultiDiagramEditor) {
			editor = (IMultiDiagramEditor)part;
			editingDomain = getTransactionalEditingDomain(editor);
		} else {
			editingDomain = null;
		}
	}
	
	/**
	 * Get the {@link TransactionalEditingDomain} from the {@link IMultiDiagramEditor}.
	 * @param editor
	 * @return
	 */
	private TransactionalEditingDomain getTransactionalEditingDomain(IMultiDiagramEditor editor) {
		try {
			return editor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		} catch (ServiceException e) {
			// TODO Log instead of showing the trace.
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Create and execute commands that change the selected elements.
	 */
	private void updateSelectedElements() {
		
		IStructuredSelection selection;
		
		if( getSelection() instanceof IStructuredSelection ) {
			selection = (IStructuredSelection)getSelection();
		}
		else {
			return;
		}
		
		// Iterate over selected elements
		CompoundCommand cc = new CompoundCommand();
		List<Object> selectedElements = selection.toList();
		for( Object element : selectedElements) {

			if(element instanceof GraphicalEditPart) {
				GraphicalEditPart namedElementEditPart = ((GraphicalEditPart)element);
				// selectionChanged(selection);

				String currentQualifiedNameDepth = comboQualifiedNameAppearance.getText();
				String currentQualifiedNameSpec;

				if("Full".equals(currentQualifiedNameDepth)) {
					currentQualifiedNameSpec = "0";
				} else if("None".equals(currentQualifiedNameDepth)) {
					NamedElement ne = (NamedElement)((View)namedElementEditPart.getModel()).getElement();
					currentQualifiedNameSpec = "" + NamedElementUtil.getQualifiedNameMaxDepth(ne);
				} else {
					currentQualifiedNameSpec = currentQualifiedNameDepth.substring(1);
				}

				int qualifiedNameDepth = Integer.parseInt(currentQualifiedNameSpec);

				// Add command
				cc.append(new SetQualifiedNameDepthCommand(editingDomain,((EModelElement)namedElementEditPart.getModel()), qualifiedNameDepth));
			}

		}
		
		if(editingDomain != null) {
			editingDomain.getCommandStack().execute( cc.unwrap() );
			
		}

		refresh();
	}

}
