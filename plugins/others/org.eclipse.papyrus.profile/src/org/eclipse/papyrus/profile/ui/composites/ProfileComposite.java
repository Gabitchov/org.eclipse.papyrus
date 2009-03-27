/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.ui.composites;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.profile.Activator;
import org.eclipse.papyrus.profile.ImageManager;
import org.eclipse.papyrus.profile.ui.dialogs.FileSelectionFilter;
import org.eclipse.papyrus.profile.ui.dialogs.Message;
import org.eclipse.papyrus.profile.ui.dialogs.ProfileTreeSelectionDialog;
import org.eclipse.papyrus.profile.ui.dialogs.RegisteredProfileSelectionDialog;
import org.eclipse.papyrus.profile.ui.panels.ProfilePanel;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Profile;

import com.cea.papyrus.umlutils.PackageUtil;

//TODO: Auto-generated Javadoc
/**
 * The Class ProfileComposite.
 */
public class ProfileComposite extends Composite {
    
	public final static String TAG_PROFILE_CHANGED = " (has changed, consider re-applying profile)";
    /**
     * The parent panel.
     */
    private ProfilePanel parentPanel;
	
    /**
     * The applied label.
     */
    private CLabel appliedLabel;
	
	/**
	 * The profiles.
	 */
	private List profiles;

	/**
	 * The add registered button.
	 */
	private Button addButton, removeButton, addRegisteredButton;

	/**
	 * Listeners *.
	 */
	private MouseListener addButtonListener, removeButtonListener, addRegisteredButtonListener;

	/**
	 * 
	 */
	private SelectionListener profilesListener;

	/**
	 * 
	 */
	protected TabbedPropertySheetWidgetFactory factory;

	public Profile profiletoApply;


	/**
	 * The default constructor.
	 * 
	 * @param style the style of this panel
	 * @param parent the parent Composite for this panel
	 */
	public ProfileComposite(ProfilePanel parent) {
		super(parent, SWT.NONE);	
		this.setLayout(new FormLayout());

		parentPanel = parent;
	}

	/**
	 * 
	 * 
	 * @param factory 
	 * @param parent 
	 */
	public ProfileComposite(Composite parent, TabbedPropertySheetWidgetFactory factory) {
		super(parent, SWT.NONE);   	
		this.setLayout(new FormLayout());

		this.factory = factory;
	}

	/**
	 * 
	 */
	public void createContent() {

		createLabel();
		createRemButton();
		createRegButton();
		createAddButton();

		profiles = createProfilesList();
		profiles.setVisible(true);
	}

	/**
	 * Gets the selected.
	 * 
	 * @return Returns the selected element.
	 */
	public Package getSelected() {
		return (Package) parentPanel.getSelected();
	}

	/**
	 * Refresh the content of applied the profile list.
	 */
	public void refresh() {

		if (getSelected() == null) {
			return;
		}

		// Refresh profiles
		if (!profiles.isDisposed()) {
			profiles.removeAll();

			Package currentPackage = (Package) getSelected();
			EList<Profile> appliedProfiles = currentPackage.getAllAppliedProfiles();

			for(int i = 0; i < appliedProfiles.size(); i++) {

				Profile currentProfile = (Profile) appliedProfiles.get(i);
				String  currentName    = currentProfile.getQualifiedName();

				if (currentName == null) {
					Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Warning a profile applied on "
							+ currentPackage.getName()
							+ " could not be found : \n\t"
							+ currentProfile.toString()));
				} else if (isDirty(currentPackage, currentProfile)) {
					profiles.add(currentName+ TAG_PROFILE_CHANGED);
					profiles.setData(currentName, currentProfile);					
				}else {
					profiles.add(currentName);
					profiles.setData(currentName, currentProfile);	
				}
			}
		}
	}

	/**
	 * Create a label.
	 */
	private void createLabel() {
		FormData data = new FormData();

		// Label creation
		if(parentPanel != null) {
			appliedLabel = parentPanel.getFactory().createCLabel(this,"Applied profiles:", SWT.NONE);
		} else {
			appliedLabel = factory.createCLabel(this,"Applied profiles:", SWT.NONE);
		}

		// Label placement
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.top  = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		appliedLabel.setLayoutData(data);
	}

	/**
	 * Creates the profiles list.
	 * 
	 * @return the list of applied profiles
	 */
	private List createProfilesList() {
		FormData data = new FormData();

		// List of applied profiles
		List profiles = new List(this, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);		

		// List placement
		data.left    = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.right   = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.top     = new FormAttachment(addButton, ITabbedPropertyConstants.VSPACE);
		data.bottom  = new FormAttachment(100, -ITabbedPropertyConstants.VSPACE);
		profiles.setLayoutData(data);

		// List listeners
		profiles.addSelectionListener(profilesListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return profiles;
	}

	/**
	 * Creates the button that applies new profiles
	 * on selected package.
	 */
	private void createAddButton() {
		FormData data = new FormData();

		// Button creation
		if(parentPanel != null)
			addButton = parentPanel.getFactory().createButton(this, "", SWT.PUSH);
		else
			addButton = factory.createButton(this, "", SWT.PUSH);
		addButton.setImage(ImageManager.IMG_ADD);
		addButton.setToolTipText("Apply profile...");
		addButton.setVisible(true);

		// Button placement
		data.right = new FormAttachment(addRegisteredButton, -ITabbedPropertyConstants.HSPACE);
		data.top   = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		addButton.setLayoutData(data);

		// Button listeners
		addButton.addMouseListener(addButtonListener = new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseUp(MouseEvent e) {
				addButtonPressed();
			}

		});
	}

	/**
	 * Creates the button used to apply a registered (= plugin enclosed)
	 * profile to the selected package.
	 */
	private void createRegButton() {
		FormData data = new FormData();

		// Button creation
		if(parentPanel!=null)
			addRegisteredButton = parentPanel.getFactory().createButton(this, "", SWT.PUSH);
		else
			addRegisteredButton = factory.createButton(this, "", SWT.PUSH);
		addRegisteredButton.setImage(ImageManager.IMG_ADDREG);
		addRegisteredButton.setToolTipText("Apply registered profile...");
		addRegisteredButton.setVisible(true);

		// Button placement
		data.right = new FormAttachment(removeButton, -ITabbedPropertyConstants.HSPACE);
		data.top   = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		addRegisteredButton.setLayoutData(data);

		// Button listeners
		addRegisteredButton.addMouseListener(
				addRegisteredButtonListener = new MouseListener() {
					public void mouseDoubleClick(MouseEvent e) {
					}

					public void mouseDown(MouseEvent e) {
					}

					public void mouseUp(MouseEvent e) {
						addRegButtonPressed();
					}
				});
	}

	/**
	 * Creates a button used to unapply a profile from
	 * the selected package.
	 */
	private void createRemButton() {
		FormData data = new FormData();

		// Button creation
		if(parentPanel!=null)
			removeButton = parentPanel.getFactory().createButton(this, "", SWT.PUSH);
		else
			removeButton = factory.createButton(this, "", SWT.PUSH);
		removeButton.setImage(ImageManager.IMG_DELETE);
		removeButton.setToolTipText("Unapply profiles...");
		removeButton.setVisible(true);

		// Button placement
		data.right = new FormAttachment(100, -ITabbedPropertyConstants.HSPACE);
		data.top   = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		removeButton.setLayoutData(data);

		// Button listeners
		removeButton.addMouseListener(removeButtonListener = new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseUp(MouseEvent e) {
				remButtonPressed();
			}
		});		
	}

	/**
	 * Button action :
	 * open a selection dialog box that allow the user to choose profiles to apply.
	 */
	protected void addButtonPressed() {

		// Create and open the dialog box
		//ResourceSelectionDialog dialog = 
		//	new ResourceSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), "Apply Profiles");
		
		ILabelProvider lp= new WorkbenchLabelProvider();
		ITreeContentProvider cp= new WorkbenchContentProvider();
		
		ArrayList<String> filetypes = new ArrayList<String>();
		filetypes.add("uml");
		
		ElementTreeSelectionDialog dialog =
			new ElementTreeSelectionDialog(getShell(), lp, cp);
		dialog.setTitle("Apply Profiles...");
		dialog.setMessage("Choose profiles to apply");
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		dialog.addFilter(new FileSelectionFilter(filetypes));
		dialog.setValidator(new org.eclipse.papyrus.profile.ui.dialogs.FileSelectionValidator());
		dialog.setDoubleClickSelects(true);
		dialog.setHelpAvailable(false);
		dialog.setAllowMultiple(true);

		dialog.open();

		// If nothing is selected : abort
		if ((dialog.getResult() == null) || (dialog.getResult().length < 1)) {
			return;
		}

		ArrayList<Package> importedModels = new ArrayList<Package>();
		Package package_  = getSelected();

		for(int i = 0; i < dialog.getResult().length; i++) {
			IFile selectedFile     = (IFile) dialog.getResult()[i];
			URI profileUri         = URI.createURI("platform:/resource"+selectedFile.getFullPath().toString());

			ResourceSet resourceSet = package_.eResource().getResourceSet();

			Resource profileResource = resourceSet.getResource(profileUri,true);

			
			
			
			if(profileResource.getContents().get(0) instanceof Package ){
				Package importedModel= (Package)profileResource.getContents().get(0);
				importedModels.add(importedModel);
			}
			

		}
		
		if(importedModels.size()>0){
			ProfileTreeSelectionDialog  profileDialog=new ProfileTreeSelectionDialog(getShell(),importedModels);

			profileDialog.open();
			ArrayList<Profile> profilestoApply= (ArrayList<Profile>) profileDialog.getResult();

			Message message = new Message("Profile application", "Applying profile...");
			message.open();
			Iterator<Profile> iterator= profilestoApply.iterator();
			while(iterator.hasNext()){
				PackageUtil.applyProfile(package_, iterator.next(), false);
			}
			message.close();
		}


		// do a refresh to update list of applied profiles
		refresh();
	}

	/**
	 * Button action :
	 * unaply the profiles selected by the user.
	 */
	protected void remButtonPressed() {

		// Retrieve indices of selected profiles to unapply
		int[] selectionIndices = profiles.getSelectionIndices();		
		if ((selectionIndices == null) || (selectionIndices.length == 0)) {
			return;
		}

		// Parse selection
		for (int i = 0 ; i < selectionIndices.length ; i++) {

			int currentIndex = selectionIndices[i];
			// Remove TAG_PROFILE_CHANGED when it exists
			String itemName  = profiles.getItem(currentIndex).replace(TAG_PROFILE_CHANGED, "");
			Profile profileToUnapply = (Profile) profiles.getData(itemName);

			if (profileToUnapply == null) {
				return;
			}

			// Allow removal if profile is applied on current package
			// Not if it is applied from owner package
			EList appliedProfiles = getSelected().getAppliedProfiles();
			if (appliedProfiles.contains(profileToUnapply)) {		

				/**********************************************************************/
				/** delete imported model libraries and types related to that profile */

				// model libraries handling
				EList importedPackages = ((Package)getSelected()).getPackageImports();
				Iterator<PackageImport> iterPI = importedPackages.iterator();
				ArrayList importedPackagesToRemove = new ArrayList();
				while (iterPI.hasNext()) {
					PackageImport pi = iterPI.next();
					if (pi.getImportedPackage().getOwner()!=null) {
						if (pi.getImportedPackage().getOwner().equals(profileToUnapply)) {
							importedPackagesToRemove.add(pi);
						}
					}
				}

				// remove model librairies
				// this has been done here to avoid concurrent modification of importedPackages
				for(int j = 0 ; j < importedPackagesToRemove.size() ; j++) {
					importedPackages.remove(importedPackagesToRemove.get(j));
				}
			}
			getSelected().unapplyProfile(profileToUnapply);
			// Force model change
			if(parentPanel!=null)
				Util.touchModel(getSelected());
		}

		// do a refresh to update list of applied profiles
		refresh();
	}

	/**
	 * Button action :
	 * open the dialog box for registered profile selection.
	 */
	protected void addRegButtonPressed() {
		RegisteredProfileSelectionDialog d = new RegisteredProfileSelectionDialog(getShell(), getSelected());
		boolean profileApplied = d.run();

		if (profileApplied) {
			// do a refresh to update list of applied profiles
			refresh();

			// Force model change
			if(parentPanel!=null)
				Util.touchModel(getSelected());	
		}
	}

	/**
	 * 
	 * 
	 * @return 
	 */
	protected List getProfiles(){
		return profiles;
	}

	/**
	 * Dispose listeners.
	 */
	public void disposeListeners(){
		if(addButton!=null && !addButton.isDisposed())
			addButton.removeMouseListener(addButtonListener);
		if(removeButton!=null && !removeButton.isDisposed())
			removeButton.removeMouseListener(removeButtonListener);
		if(addRegisteredButton!=null && !addRegisteredButton.isDisposed())
			addRegisteredButton.removeMouseListener(addRegisteredButtonListener);
		if(profiles!=null && !profiles.isDisposed())
			profiles.removeSelectionListener(profilesListener);
	}
	
	/**
	 * Checks if the profile applied has been changed since last application
	 * (definition does not match.
	 * @param _package on which the profile is applied
	 * @param _profile the applied profile
	 * @return true if the profile has changed
	 */
	private boolean isDirty(Package _package, Profile _profile) {
		boolean isDirty = false;
		
		// Retrieve model resourceSet
		ResourceSet pkge_resourceSet = _package.eResource().getResourceSet();
		
		// Retrieve profile resource
		URI prof_URI = _profile.eResource().getURI();
		Resource modelResource = pkge_resourceSet.getResource(prof_URI,true);
			
		if (modelResource.getContents().get(0) instanceof Profile) {
			
			// ckeck applied profile application definition vs profile definition referenced in file
			Profile profileInFile = (Profile) (modelResource.getContents().get(0));
			
			if (_package.getProfileApplication(_profile) != null) {
				EPackage appliedProfileDefinition = _package.getProfileApplication(_profile).getAppliedDefinition();
				EPackage fileProfileDefinition    = null;
				
				// Check profiles qualified names to ensure the correct profiles are compared
				String appliedProfileName = _profile.getQualifiedName();
				String fileProfileName = profileInFile.getQualifiedName();
				if ( ! appliedProfileName.equals(fileProfileName)) {
					
					// The profile must be a subprofile
					Iterator<Profile> it = PackageUtil.getSubProfiles(profileInFile).iterator();
					while (it.hasNext()) {
						Profile current = it.next();
						fileProfileName = current.getQualifiedName();
						if (fileProfileName.equals(appliedProfileName)) {
							profileInFile = current;
						}
					}
				}
				
				fileProfileDefinition = profileInFile.getDefinition();
				
				if (appliedProfileDefinition != fileProfileDefinition) {
					isDirty = true;
				}
			}
			
		}
		
		return isDirty;
	}
}
