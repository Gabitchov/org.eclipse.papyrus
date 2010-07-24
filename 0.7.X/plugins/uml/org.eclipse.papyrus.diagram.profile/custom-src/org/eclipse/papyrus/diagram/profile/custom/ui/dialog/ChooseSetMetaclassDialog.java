/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Patrick Tessier patrick.tessier@cea.fr - initial API and implementation
 *    Vincent Lorenzo vincent.lorenzo@cea.fr 
 *******************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.ui.dialog;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.profile.custom.helper.MetaclassHelper;
import org.eclipse.papyrus.diagram.profile.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.profile.ui.dialogs.AlphabeticalViewerSorter;
import org.eclipse.papyrus.profile.ui.dialogs.ChooseSetAssistedDialog;
import org.eclipse.papyrus.profile.ui.dialogs.ElementList;
import org.eclipse.papyrus.profile.ui.dialogs.IChooseDialog;
import org.eclipse.papyrus.ui.toolbox.LookForElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 */
public class ChooseSetMetaclassDialog extends ChooseSetAssistedDialog implements IChooseDialog {


	/**
	 * parent profile (top Profile).
	 */
	protected Profile profile;

	protected ArrayList<Object> addedMetaclasses;

	protected ArrayList<Object> deletedMetaclasses;

	/**
	 * @param parentShell
	 * @param profile
	 */
	public ChooseSetMetaclassDialog(Shell parentShell, Profile profile) {
		this(parentShell, profile, true);
		addedMetaclasses = new ArrayList<Object>();
		deletedMetaclasses = new ArrayList<Object>();
	}

	/**
	 * 
	 * 
	 * @param parentShell
	 * @param profile
	 */
	public ChooseSetMetaclassDialog(Shell parentShell, Profile prof, boolean retrieveImported) {
		super(parentShell, Messages.ChooseSetMetaclassDialog_Metaclasses, Messages.ChooseSetMetaclassDialog_ImportedMetaclasses);


		//this.profile = profile;
		/**
		 * for the moment, all the metaclasses must be imported to the root profile
		 */
		EObject container = prof.eContainer();
		EObject oldContainer = prof;
		while(container != null) {
			oldContainer = container;
			container = container.eContainer();
		}

		this.profile = (Profile)oldContainer;
		selectedElementList = new ElementListWithComparator(new ClassElementComparator());

		labelProvider = new MetaclassLabelProvider();
		decoratedContentProposalProvider = new MetaclassContentProposalProvider();

		if(retrieveImported) {
			Iterator metaclasses = this.profile.getReferencedMetaclasses().iterator();
			while(metaclasses.hasNext()) {
				selectedElementList.addElement(metaclasses.next());
			}
		}

		Iterator metaclasses = LookForElement.getPossibleMetaclasses(this.profile).iterator();
		while(metaclasses.hasNext()) {
			Object currentPossibleMetaclass = metaclasses.next();

			// for each element in the metaclasses collection, check if this class is not already
			// imported
			if(!selectedElementList.contains(currentPossibleMetaclass)) {
				possibleElementList.addElement(currentPossibleMetaclass);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cea.papyrus.core.ui.dialogs.ChooseSetAssistedDialog#createDialogArea(org.eclipse.swt.
	 * widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Control composite = super.createDialogArea(parent);

		// Add 2 columns to the table area
		// possibleElementsTable.setLinesVisible(true);
		possibleElementsTable.setHeaderVisible(true);

		// 1st column with image/checkboxes - NOTE: The SWT.CENTER has no effect!!
		TableColumn column = new TableColumn(possibleElementsTable, SWT.CENTER, 0);
		column.setText(Messages.ChooseSetMetaclassDialog_Metaclass);
		column.setWidth(150);
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				possibleElementsTableViewer.setSorter(new AlphabeticalViewerSorter(0));
			}
		});

		// 2nd column with task Description
		column = new TableColumn(possibleElementsTable, SWT.LEFT, 1);
		column.setText(Messages.ChooseSetMetaclassDialog_Information);
		column.setWidth(165);
		// Add listener to column so tasks are sorted by description when clicked
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				possibleElementsTableViewer.setSorter(new AlphabeticalViewerSorter(1));
			}
		});

		// set sorter to the possible element table viewer
		possibleElementsTableViewer.setSorter(new AlphabeticalViewerSorter(0));

		return composite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.core.ui.dialogs.ChooseSetAssistedDialog#runAddElement(java.lang.String)
	 */
	/**
	 * 
	 * 
	 * @param name
	 */
	@Override
	protected void runAddElement(String name) {
		// find the class in the list
		Class theClass = null;
		Iterator it = possibleElementList.getElements().iterator();
		while(it.hasNext()) {
			Class current = (Class)it.next();
			if(name.equalsIgnoreCase(current.getName()) || name.equalsIgnoreCase(current.getQualifiedName())) {
				theClass = current;
			}
		}
		if(theClass != null) {
			runActionAdd(theClass);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cea.papyrus.core.ui.dialogs.ChooseSetAssistedDialog#isSelectableElement(java.lang.String)
	 */
	/**
	 * 
	 * 
	 * @param text
	 * 
	 * @return
	 */
	@Override
	protected boolean isSelectableElement(String text) {
		// iterate through all possibilities and return true if text corresponds
		Iterator it = possibleElementList.getElements().iterator();
		while(it.hasNext()) {
			Class element = (Class)it.next();
			if(text.equalsIgnoreCase(element.getName()) || text.equalsIgnoreCase(element.getQualifiedName())) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.core.utils.dialog.ChooseSetDialog#okPressed()
	 */
	/**
	 * 
	 */
	@Override
	protected void okPressed() {
		applyModifications();
		super.okPressed();
	}

	/**
	 * Apply modification when the button ok is pressed.
	 */
	protected void applyModifications() {
		//----Obtain the actual imported metaclasses
		EList metaclassSet = profile.getReferencedMetaclasses();
		CompoundCommand deletingCommand = new CompoundCommand();
		CompoundCommand addingCommand = new CompoundCommand();

		for(int i = 0; i < metaclassSet.size(); i++) {
			//we verify if some metaclasses need to be removed
			if(!selectedElementList.contains(metaclassSet.get(i))) {

				//we delete the metaclass
				org.eclipse.uml2.uml.Class theClass = (org.eclipse.uml2.uml.Class)metaclassSet.get(i);
				EList<ElementImport> importSet = profile.getMetaclassReferences();

				for(int j = 0; j < importSet.size(); j++) {
					if((importSet.get(j)).getImportedElement() != null) {
						org.eclipse.uml2.uml.Class importedClass = (org.eclipse.uml2.uml.Class)(importSet.get(j)).getImportedElement();
						if(importedClass.equals(theClass)) {

							//we need to destroy the extensions and remove the attribute in the stereotype
							deletingCommand.add(MetaclassHelper.getDestroyMetaclassCommand(theClass, this.profile));
						}
					}
				}



			}

		}

		if(deletingCommand != null && deletingCommand.canExecute()) {
			try {
				LookForElement.getCommandStack().execute(deletingCommand);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		//we add the new metaclasses
		for(int i = 0; i < selectedElementList.getElements().size(); i++) {
			if(!metaclassSet.contains(selectedElementList.getElements().get(i))) {
				//we create an ElementImport for the new metaclass
				ElementImport ei = UMLFactory.eINSTANCE.createElementImport();
				//we create the class		


				ei.setImportedElement((PackageableElement)selectedElementList.getElements().get(i));

				ei.setAlias(((NamedElement)selectedElementList.getElements().get(i)).getName());
				addedMetaclasses.add(selectedElementList.getElements().get(i));
				ElementImport added = ei;

				//we need make the import only if it doesn't exist yet!
				EList<ElementImport> list = profile.getElementImports();

				//We search if this metaclass is imported yet
				//ListIterator<ElementImport> iterator = list.listIterator();
				for(int iter = 0; iter < list.size(); iter++) {
					if(list.get(iter) != null) {
						String qNameEI = ei.getImportedElement().getQualifiedName();
						if(list.get(iter).getImportedElement() != null) {
							String qNamelist = list.get(iter).getImportedElement().getQualifiedName();
							if(ei.getImportedElement().getQualifiedName().equals(list.get(iter).getImportedElement().getQualifiedName())) {

								//the metaclass is yet imported, we take it to put it in the metaclassReference
								added = list.get(iter);//iterator.previous();
								break;
							}
						}
					}
				}

				//we add the metaclass in metaclassReference
				SetRequest setRequest = new SetRequest(profile, UMLPackage.eINSTANCE.getProfile_MetaclassReference(), added);
				SetValueCommand setValueCommand = new SetValueCommand(setRequest);
				if(setValueCommand != null && setValueCommand.canExecute()) {
					addingCommand.add(new ICommandProxy(setValueCommand));
				}

			}
		}

		if(addingCommand != null && addingCommand.canExecute()) {
			try {
				LookForElement.getCommandStack().execute(addingCommand);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 */
	public class MetaclassContentProposalProvider extends DecoratedContentProposalProvider {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.cea.papyrus.core.ui.dialogs.ChooseSetAssistedDialog.DecoratedContentProposalProvider
		 * #getProposals(java.lang.String, int)
		 */
		/**
		 * 
		 * 
		 * @param contents
		 * @param position
		 * 
		 * @return
		 */
		@Override
		public DecoratedContentProposal[] getProposals(String contents, int position) {
			ArrayList<DecoratedContentProposal> proposals = new ArrayList<DecoratedContentProposal>();

			if(possibleElementList != null) {
				Iterator it = possibleElementList.getElements().iterator();
				while(it.hasNext()) {
					final NamedElement element = (NamedElement)it.next();
					final String simpleName = element.getName();

					if(position < simpleName.length() && contents.substring(0, position).equalsIgnoreCase(simpleName.substring(0, position))) {
						proposals.add(new DecoratedContentProposal(element, labelProvider));
					}
				}
			}

			Collections.sort(proposals);
			return proposals.toArray(new DecoratedContentProposal[proposals.size()]);
		}
	}

	/**
	 * Label provider for metaclasses.
	 * 
	 * @author Remi Schnekenburger
	 *         adapted code by Vincent Lorenzo vincent.lorenzo@cea.fr
	 */
	protected class MetaclassLabelProvider extends LabelProvider implements ITableLabelProvider {


		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
		 */
		private static final String ID = "org.eclipse.uml2.uml.edit"; //$NON-NLS-1$

		private static final String PATH = "/icons/full/obj16/"; //$NON-NLS-1$

		private static final String LOCAL_PATH = "/icons/obj16/"; //$NON-NLS-1$

		private static final String EXTENSION = ".gif"; //$NON-NLS-1$

		private static final String EMPTY_IMAGE = "Empty" + EXTENSION; //$NON-NLS-1$

		//One of the metaclasses without image!
		private static final String DUMMY_IMAGE = "dummy" + EXTENSION; //$NON-NLS-1$

		private static final String EMPTY_IMAGE_PATH = "../../../../../../../../../icons/obj16/Empty.gif"; //$NON-NLS-1$



		/**
		 * 
		 * 
		 * @param element
		 * 
		 * @return the researched image or a blank image if the first doesn't exist
		 */
		@Override
		public Image getImage(Object element) {

			Image image = null;
			String name = getText(element);

			if(element instanceof Class) {
				image = Activator.getPluginIconImage(ID, PATH + name + EXTENSION);
			}

			/**
			 * Some elements doesn't have associated image. For example the UML Element Action doesn't have it!
			 * the returned image is always the same when there isn't image.
			 */
			//if the returned image is the same that with a dummy image : 
			if(image.equals(Activator.getPluginIconImage(ID, PATH + DUMMY_IMAGE + EXTENSION))) {
				//we search the image with the name EMPTY
				image = Activator.getPluginIconImage(UMLDiagramEditorPlugin.ID, LOCAL_PATH + EMPTY_IMAGE);
				//the first time, this image doesn't exist, so we create it!
				if(image.equals(Activator.getPluginIconImage(ID, PATH + DUMMY_IMAGE + EXTENSION))) {
					ImageRegistry registry = Activator.getDefault().getImageRegistry();
					if(registry.getDescriptor(UMLDiagramEditorPlugin.ID + PATH + EMPTY_IMAGE) == null) {
						try {
							ImageDescriptor imDesc = ImageDescriptor.createFromFile(getClass(), EMPTY_IMAGE_PATH);
							String key = UMLDiagramEditorPlugin.ID + LOCAL_PATH + EMPTY_IMAGE;
							registry.put(key, imDesc);
							image = registry.get(key);
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				}


			}


			return image;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
		 */
		/**
		 * 
		 * 
		 * @param element
		 * 
		 * @return
		 */
		@Override
		public String getText(Object element) {
			if(!(element instanceof Class)) {
				return "not a class"; //$NON-NLS-1$
			} else {
				return ((Class)element).getName();
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
		 */
		/**
		 * 
		 * 
		 * @param element
		 * @param columnIndex
		 * 
		 * @return
		 */
		public Image getColumnImage(Object element, int columnIndex) {
			if(columnIndex == 0) {
				return getImage(element);
			}
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
		 */
		/**
		 * 
		 * 
		 * @param element
		 * @param columnIndex
		 * 
		 * @return
		 */
		public String getColumnText(Object element, int columnIndex) {
			if(columnIndex == 0) {
				return getText(element);
			} else if(columnIndex == 1) {
				return ((Class)element).getQualifiedName();
			}
			return "not the right column index"; //$NON-NLS-1$
		}
	}

	/**
	 * Label provider for stereotypes that modifies {@link MetaclassLabelProvider#getText(Object)}.
	 * It returns the qualified name of the Metaclass instead of the simple name.
	 * 
	 * @author Remi Schnekenburger
	 */
	protected class MetaclassQualifiedLabelProvider extends MetaclassLabelProvider {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.cea.papyrus.core.ui.dialogs.ChooseSetStereotypeDialog.StereotypeLabelProvider#getText
		 * (java.lang.Object)
		 */
		@Override
		public String getText(Object element) {
			if(!(element instanceof Class)) {
				return "not a class"; //$NON-NLS-1$
			} else {
				return ((Class)element).getQualifiedName();
			}
		}
	}

	public ElementList getElement() {
		// TODO Auto-generated method stub
		return selectedElementList;
	}

	/**
	 * 
	 * @return the added metaclasses
	 */
	public ArrayList<Object> getAddedMetaclasses() {
		return addedMetaclasses;
	}

	/**
	 * 
	 * @return the deleted metaclasses
	 */
	public ArrayList<Object> getDeletedMetaclasses() {
		return deletedMetaclasses;
	}
}
