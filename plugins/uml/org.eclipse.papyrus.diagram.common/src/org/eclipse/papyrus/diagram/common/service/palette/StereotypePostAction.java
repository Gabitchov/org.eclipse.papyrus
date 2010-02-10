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
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.service.palette;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.papyrus.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.papyrus.diagram.common.wizards.PaletteAspectToolEntryProxy;
import org.eclipse.papyrus.diagram.common.wizards.PaletteEntryProxy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * Aspect action that applies stereotypes on the edit part newly created
 */
public class StereotypePostAction extends ModelPostAction {

	/** list of stereotypes to apply, identified by their qualified names */
	protected List<String> stereotypesToApply;

	/** add icon path */
	protected static final String ICONS_ADD = "/icons/obj16/Add_16x16.gif";

	/** remove icon path */
	protected static final String ICONS_REMOVE = "/icons/delete.gif";

	/** stereotype icon path */
	protected static final String ICON_STEREOTYPE = "/icons/stereotype.gif";

	/** profile icon path */
	protected static final String ICON_PROFILE = "/icons/profile.gif";

	/** viewer to display stereotypes to apply */
	protected TreeViewer stereotypesViewer;

	/** entry proxy "parent" of this action when configuring the action */
	protected PaletteEntryProxy entryProxy;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;

	/** stereotypes label provider */
	protected StereotypeLabelProvider stereotypeLabelProvider = new StereotypeLabelProvider();

	/** remove button */
	protected Button removeButton;

	/**
	 * Constructor.
	 */
	public StereotypePostAction() {
		stereotypesToApply = new ArrayList<String>();
	}

	/**
	 * {@inheritDoc}
	 */
	public IStatus checkPostCondition() {
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
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
		String stereotypesToApplyQN = configurationNode.getAttributes().getNamedItem(IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY).getNodeValue();
		if(stereotypesToApplyQN != null && !"".equals(stereotypesToApplyQN)) {
			stereotypesToApply.addAll(PaletteUtil.getStereotypeListFromString(stereotypesToApplyQN));
		}
	}

	/**
	 * @{inheritDoc
	 */
	public void save(Node parentNode) {
		if(parentNode instanceof Element) {
			((Element)parentNode).setAttribute(IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY, PaletteUtil.getSerializedStereotypeListFromList(stereotypesToApply));
		} else {
			Activator.log.error("parent node is not an Element", null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public void run(EditPart editPart) {
		ApplyStereotypeRequest request = new ApplyStereotypeRequest(stereotypesToApply);
		request.getExtendedData().put(ApplyStereotypeRequest.NEW_EDIT_PART_NAME, "NEW");
		editPart.performRequest(request);
	}

	/**
	 * @{inheritDoc
	 */
	public Control createConfigurationComposite(Composite parent, PaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		this.entryProxy = entryProxy;
		Composite mainComposite = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(3, false);
		mainComposite.setLayout(layout);

		Label titleLabel = new Label(mainComposite, SWT.NONE);
		titleLabel.setText("Stereotypes to Apply");
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		titleLabel.setLayoutData(data);

		Button addButton = new Button(mainComposite, SWT.NONE);
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
				performRemoveButtonPressed();
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

		stereotypesViewer = new TreeViewer(mainComposite, SWT.BORDER | SWT.MULTI);
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.horizontalSpan = 3;
		stereotypesViewer.getControl().setLayoutData(data);
		stereotypesViewer.setLabelProvider(stereotypeLabelProvider);
		stereotypesViewer.setContentProvider(new StereotypeContentProvider());
		stereotypesViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ITreeSelection selection = (ITreeSelection)event.getSelection();
				if(selection.size() > 0) {
					removeButton.setEnabled(true);
				} else {
					removeButton.setEnabled(false);
				}
			}
		});

		updateStereotypeViewer();

		return mainComposite;
	}

	/**
	 * updates the stereotype viewer
	 */
	protected void updateStereotypeViewer() {
		stereotypesViewer.setInput(getStereotypesToApply());
	}

	/**
	 * Action taken when the button remove is pressed
	 */
	protected void performRemoveButtonPressed() {
		// remove the selected stereotype(s) from the list of stereotypes to apply
		ITreeSelection selection = (ITreeSelection)stereotypesViewer.getSelection();
		if(selection.size() > 0) {
			stereotypesToApply.removeAll(selection.toList());
		}
		updateStereotypeViewer();
	}

	/**
	 * Action taken when the button add is pressed
	 */
	protected void performAddButtonPressed() {
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
			Activator.log.error("Impossible to find metaclass", null);
			return;
		}

		// retrieve the original stereotype list from the qualified names
		List<Stereotype> stereotypeList = retrieveStereotypesFromQualifiedNames();

		// we have all applied profiles, the list of already applied stereotypes, the metaclass of the created element...
		// just have to open a selection dialog
		final CheckedTreeSelectionDialog selectionDialog = new CheckedTreeSelectionDialog(DisplayUtils.getDisplay().getActiveShell(), stereotypeLabelProvider, new ProfileContentProvider(metaClass));
		selectionDialog.setTitle("Stereotype selection");
		selectionDialog.setMessage("Please select the set of stereotypes that will be apply to the new element");
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
				Activator.log.error("impossible to retrieve stereotype " + qualifiedName, null);
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
	 * Label provider for the stereotype viewer
	 */
	protected class StereotypeLabelProvider implements ILabelProvider {

		/**
		 * @{inheritDoc
		 */
		public Image getImage(Object element) {
			if(element instanceof Profile) {
				return Activator.getPluginIconImage(Activator.ID, ICON_PROFILE);
			}
			return Activator.getPluginIconImage(Activator.ID, ICON_STEREOTYPE);
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
}
