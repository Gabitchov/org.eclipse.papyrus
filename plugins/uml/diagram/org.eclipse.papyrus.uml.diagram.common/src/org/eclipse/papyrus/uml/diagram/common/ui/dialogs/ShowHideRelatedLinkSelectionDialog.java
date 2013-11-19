/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.EdgeWithNoSemanticElementRepresentationImpl;
import org.eclipse.papyrus.uml.diagram.common.dialogs.AbstractCheckedTreeColumnViewerSelectionDialog;
import org.eclipse.papyrus.uml.diagram.common.messages.Messages;
import org.eclipse.papyrus.uml.diagram.common.util.LinkEndsMapper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;

/**
 * 
 * The dialog used to select the link to show hide according to the selected gmf nodes
 * 
 */
public class ShowHideRelatedLinkSelectionDialog extends AbstractCheckedTreeColumnViewerSelectionDialog {

	/**
	 * the width for the first column
	 */
	private final int FIRST_COLUMN_WIDTH = 180;

	/**
	 * the width for the others columns
	 */
	private final int OTHERS_COLUMN_WIDTH = 100;

	/**
	 * the titles of the columns
	 */
	private static final String[] columnsTitles = new String[]{ Messages.ShowHideRelatedLinkSelectionDialog_LinksToDisplay, Messages.ShowHideRelatedLinkSelectionDialog_LinkKind, Messages.ShowHideRelatedLinkSelectionDialog_Ends, Messages.ShowHideRelatedLinkSelectionDialog_Sources, Messages.ShowHideRelatedLinkSelectionDialog_Targets };

	/**
	 * the mapping between model links and link end mapper
	 */
	private final Map<EObject, LinkEndsMapper> mapLink;

	/**
	 * the checkStateProvider to use
	 */
	private ICheckStateProvider checkedStateProvider;

	/**
	 * the checkStateListener used to refresh selection
	 */
	private ICheckStateListener checkedStateListener;

	/**
	 * a map between the gmf graphical elements and the availables model links
	 */
	private final Map<EditPart, Set<EObject>> availableLinks;

	/**
	 * the selection
	 */
	private final Set<EObject> selectedElements;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        the parent shell
	 * @param labelProvider
	 *        the label provider
	 * @param contentProvider
	 *        the content provider
	 * @param availableLinks
	 *        a map linking selected editparts and their available links
	 * @param linkEndsMapping
	 *        a map between the links and their ends
	 */
	public ShowHideRelatedLinkSelectionDialog(final Shell parent, final ILabelProvider labelProvider, final ITreeContentProvider contentProvider, final Map<EditPart, Set<EObject>> availableLinks, final Map<EObject, LinkEndsMapper> linkEndsMapping) {
		super(parent, labelProvider, contentProvider, SWT.CENTER | SWT.BORDER | SWT.FULL_SELECTION, columnsTitles.length);
		this.mapLink = linkEndsMapping;
		this.availableLinks = new HashMap<EditPart, Set<EObject>>(availableLinks);
		this.selectedElements = new HashSet<EObject>();
		setContainerMode(true);
		init();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.dialogs.CustomCheckedTreeSelectionDialog#setInitialSelection(java.lang.Object)
	 * 
	 * @param selection
	 */
	public void setInitialSelection(final Collection<EObject> initialSelection) {
		this.selectedElements.addAll(initialSelection);
		super.setInitialSelection(initialSelection.toArray());
	}


	/**
	 * 
	 * @param columnIndex
	 * @return
	 */
	@Override
	protected EditingSupport getEditingSupport(int columnIndex) {
		return null;
	}

	/**
	 * Initialize the columns Width, the columns Titles and the LabelProvider for the viewer.
	 * 
	 */
	protected void init() {
		setColumnTitles(columnsTitles);
		int[] columnWidth = new int[columnsTitles.length];
		columnWidth[0] = FIRST_COLUMN_WIDTH;
		for(int i = 1; i < columnsTitles.length; i++) {
			columnWidth[i] = OTHERS_COLUMN_WIDTH;
		}
		setColumnWidths(columnWidth);
		setColumnCellLabelProvider(new CellLabelProvider[]{ new EObjectLabelProvider(), new LinkEClassLabelProvider(), new EndsElementLabelProvider(), new SourceElementLabelProvider(), new TargetElementLabelProvider() });
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.dialogs.AbstractCheckedTreeColumnViewerSelectionDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Control ctrl = super.createDialogArea(parent);
		this.checkedStateProvider = getOrCreateCheckStateProvider();
		getTreeViewer().setCheckStateProvider(this.checkedStateProvider);
		this.checkedStateListener = getOrCreateCheckStateListener();
		getTreeViewer().addCheckStateListener(this.checkedStateListener);
		updateTree(getTreeViewer());
		return ctrl;
	}

	@Override
	public void create() {
		super.create();
		updateTree(getTreeViewer());
	}

	/**
	 * 
	 * @return
	 *         the checkedStateListener to use
	 */
	protected ICheckStateListener getOrCreateCheckStateListener() {
		if(this.checkedStateListener == null) {
			this.checkedStateListener = new ICheckStateListener() {

				/**
				 * 
				 * @see org.eclipse.jface.viewers.ICheckStateListener#checkStateChanged(org.eclipse.jface.viewers.CheckStateChangedEvent)
				 * 
				 * @param event
				 */
				public void checkStateChanged(CheckStateChangedEvent event) {
					final Object currentElement = event.getElement();
					boolean isChecked = event.getChecked();
					if(currentElement instanceof EditPart) {
						//we update the selected element list
						if(isChecked) {
							selectedElements.addAll(availableLinks.get(currentElement));
						} else {
							selectedElements.removeAll(availableLinks.get(currentElement));
						}

						//in some case, the EditPart can be a link which appears as possible elements of an other selected edit part
						final View view = (View)((EditPart)currentElement).getAdapter(View.class);
						if(view instanceof Edge) {
							final EObject element = view.getElement();
							for(final Set<EObject> currentCol : availableLinks.values()) {
								if(currentCol.contains(element)) {
									if(isChecked) {
										selectedElements.add(element);
									} else {
										selectedElements.remove(element);
									}
								}
							}
						}
					} else {
						//we update the selected element list
						if(isChecked) {
							selectedElements.add((EObject)currentElement);
						} else {
							selectedElements.remove(currentElement);
						}
					}
					updateTree(getTreeViewer());
				}
			};
		}
		return this.checkedStateListener;
	}

	/**
	 * 
	 * @param treeViewer
	 */
	//TODO : probably not the best way...
	protected final void updateTree(final TreeViewer treeViewer) {
		for(final TreeItem items : getTreeViewer().getTree().getItems()) {
			updateTreeItems(getTreeViewer(), items, getOrCreateCheckStateProvider());
		}
	}

	/**
	 * 
	 * @param treeViewer
	 * @param item
	 * @param stateProvider
	 */
	private void updateTreeItems(final TreeViewer treeViewer, final TreeItem item, final ICheckStateProvider stateProvider) {
		boolean isChecked = stateProvider.isChecked(item.getData());
		boolean isGrayed = stateProvider.isGrayed(item.getData());
		item.setChecked(isChecked);
		item.setGrayed(isGrayed);
		for(final TreeItem child : item.getItems()) {
			updateTreeItems(treeViewer, child, stateProvider);
		}
	}

	/**
	 * 
	 * @return
	 *         the checkedStateProvider to use for this dialog
	 */
	protected ICheckStateProvider getOrCreateCheckStateProvider() {
		if(this.checkedStateProvider == null) {
			this.checkedStateProvider = new ICheckStateProvider() {

				/**
				 * 
				 * @see org.eclipse.jface.viewers.ICheckStateProvider#isGrayed(java.lang.Object)
				 * 
				 * @param element
				 * @return
				 */
				public boolean isGrayed(Object element) {
					boolean isGrayed = false;
					if(element instanceof EditPart) {
						Set<EObject> values = availableLinks.get(element);
						final Collection<EObject> tmp = new ArrayList<EObject>(selectedElements);
						tmp.retainAll(values);
						isGrayed = tmp.size() != values.size();
					}
					return isGrayed;
				}

				/**
				 * 
				 * @see org.eclipse.jface.viewers.ICheckStateProvider#isChecked(java.lang.Object)
				 * 
				 * @param element
				 * @return
				 */
				public boolean isChecked(Object element) {
					boolean isChecked = false;
					if(element instanceof EditPart) {
						final Collection<?> possibleLinks = availableLinks.get(element);
						Collection<EObject> tmp = new ArrayList<EObject>(selectedElements);
						tmp.retainAll(possibleLinks);
						isChecked = tmp.size() > 0;


						final View view = (View)((EditPart)element).getAdapter(View.class);
						if(!isChecked && view instanceof Edge) {//the edge edit part could be selected as grayed because the link is already selected for an another edit part
							final EObject eobject = view.getElement();
							isChecked = selectedElements.contains(eobject);
						}


					} else if(element instanceof EObject) {
						isChecked = selectedElements.contains(element);
					}
					return isChecked;
				}
			};
		}
		return this.checkedStateProvider;
	}

	/**
	 * This provider is used by the 2nd column
	 * 
	 */
	protected class LinkEClassLabelProvider extends ColumnLabelProvider {

		/** label provider */
		private final ILabelProvider labelProvider;

		public LinkEClassLabelProvider() {
			labelProvider = getLabelProvider();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Image getImage(final Object element) {
			if(element instanceof EdgeWithNoSemanticElementRepresentationImpl) {
				return null;
			}
			if(element instanceof EObject) {
				return labelProvider.getImage(element);
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText(final Object element) {
			if(element instanceof EdgeWithNoSemanticElementRepresentationImpl) {
				final EObject source = ((EdgeWithNoSemanticElementRepresentationImpl)element).getSource();
				if(source instanceof Comment) {
					return Messages.ShowHideRelatedLinkSelectionDialog_CommentLink;
				}
				if(source instanceof Constraint) {
					return Messages.ShowHideRelatedLinkSelectionDialog_ConstraintLink;
				}
			}
			if(element instanceof EObject) {
				return ((EObject)element).eClass().getName();
			}
			return ""; //$NON-NLS-1$
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
	 * This provider is used by the 2nd column
	 * 
	 */
	protected class EObjectLabelProvider extends ColumnLabelProvider {

		/** label provider */
		private final ILabelProvider labelProvider;

		public EObjectLabelProvider() {
			labelProvider = getLabelProvider();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Image getImage(Object element) {
			if(element instanceof EdgeWithNoSemanticElementRepresentationImpl) {
				final EObject source = ((EdgeWithNoSemanticElementRepresentationImpl)element).getSource();
				if(source instanceof Comment || source instanceof Constraint) {
					return labelProvider.getImage(source);
				}
			}
			return labelProvider.getImage(element);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText(Object element) {
			if(element instanceof EdgeWithNoSemanticElementRepresentationImpl) {
				final EObject source = ((EdgeWithNoSemanticElementRepresentationImpl)element).getSource();
				if(source instanceof Comment) {
					return Messages.ShowHideRelatedLinkSelectionDialog_CommentLink;
				} else if(source instanceof Constraint) {
					return Messages.ShowHideRelatedLinkSelectionDialog_ConstraintLink;
				}
			}
			return labelProvider.getText(element);
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
	 * This provider is used by the 2nd column
	 * 
	 */
	protected class TargetElementLabelProvider extends AbstractLinkEndColumnsLabelProvider {

		/**
		 * 
		 * Constructor.
		 * 
		 * @param labelProvider
		 */
		public TargetElementLabelProvider(final ILabelProvider labelProvider) {
			super(labelProvider);
		}

		/**
		 * 
		 * Constructor.
		 * 
		 */
		public TargetElementLabelProvider() {
			super(getLabelProvider());
		}

		/**
		 * 
		 * @see org.eclipse.papyrus.uml.diagram.menu.dialogs.ShowHideRelatedLinkSelectionDialog.AbstractLinkEndColumnsLabelProvider#getValues(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		protected Collection<?> getValues(Object element) {
			final LinkEndsMapper mapper = mapLink.get(element);
			if(mapper != null) {
				return mapper.getTargets();
			}
			return Collections.emptyList();
		}
	}

	/**
	 * This provider is used by the 2nd column
	 * 
	 */
	protected class SourceElementLabelProvider extends AbstractLinkEndColumnsLabelProvider {

		/**
		 * 
		 * Constructor.
		 * 
		 * @param labelProvider
		 */
		public SourceElementLabelProvider(final ILabelProvider labelProvider) {
			super(labelProvider);
		}

		/**
		 * 
		 * Constructor.
		 * 
		 */
		public SourceElementLabelProvider() {
			super(getLabelProvider());
		}

		/**
		 * 
		 * @param element
		 * @return
		 */
		@Override
		protected Collection<?> getValues(Object element) {
			final LinkEndsMapper mapper = mapLink.get(element);
			if(mapper != null) {
				return mapper.getSources();
			}
			return Collections.emptyList();
		}
	}

	public abstract class AbstractLinkEndColumnsLabelProvider extends ColumnLabelProvider {

		/**
		 * utils constants for label provider
		 */
		public static final String START_LIST = "["; //$NON-NLS-1$

		public static final String END_LIST = "]"; //$NON-NLS-1$

		public static final String VALUE_SEPARATOR = ","; //$NON-NLS-1$

		/**
		 * the label provider to use
		 */
		private final ILabelProvider labelProvider;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param labelProvider
		 */
		public AbstractLinkEndColumnsLabelProvider(final ILabelProvider labelProvider) {
			this.labelProvider = labelProvider;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		public Image getImage(Object element) {
			return null;
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

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText(Object element) {
			final StringBuilder builder = new StringBuilder();
			final Collection<?> ends = getValues(element);
			if(!ends.isEmpty()) {
				builder.append(START_LIST);
				final Iterator<?> iter = ends.iterator();
				while(iter.hasNext()) {
					final Object current = iter.next();
					if(current instanceof Comment) {
						builder.append(Messages.ShowHideRelatedLinkSelectionDialog_Comment_);
					}
					builder.append(this.labelProvider.getText(current));
					if(iter.hasNext()) {
						builder.append(VALUE_SEPARATOR);
					}
				}
				builder.append(END_LIST);
			}
			return builder.toString();
		}

		protected abstract Collection<?> getValues(final Object element);
	}

	/**
	 * This provider is used by the 2nd column
	 * 
	 */
	protected class EndsElementLabelProvider extends AbstractLinkEndColumnsLabelProvider {

		/**
		 * 
		 * Constructor.
		 * 
		 * @param labelProvider
		 */
		public EndsElementLabelProvider(final ILabelProvider labelProvider) {
			super(labelProvider);
		}

		/**
		 * 
		 * Constructor.
		 * 
		 */
		public EndsElementLabelProvider() {
			super(getLabelProvider());
		}

		/**
		 * 
		 * @see org.eclipse.papyrus.uml.diagram.menu.dialogs.ShowHideRelatedLinkSelectionDialog.AbstractLinkEndColumnsLabelProvider#getValues(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		protected Collection<?> getValues(Object element) {
			final LinkEndsMapper mapper = mapLink.get(element);
			if(mapper != null) {
				return mapper.getEnds();
			}
			return Collections.emptyList();
		}
	}


}
