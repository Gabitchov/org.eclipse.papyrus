/**
 * 
 */
package com.cea.papyrus.profile.ui.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;

import com.cea.papyrus.extensionpoints.uml2.library.FilteredRegisteredLibrariesSelectionDialog;
import com.cea.papyrus.extensionpoints.uml2.library.RegisteredLibrary;
import com.cea.papyrus.extensionpoints.uml2.utils.Util;
import com.cea.papyrus.profile.ui.dialogs.PackageImportTreeSelectionDialog;
import com.cea.papyrus.umlutils.PackageUtil;

/**
 * Abstract command for all package import for registered elements actions
 */
public abstract class AbstractPackageImportAction extends AbstractViewActionDelegate {

	/** current selection */
	protected Package selectedElement;

	/** Editing domain of the viewer given to init() method */
	protected EditingDomain editingDomain;

	/** stored instance of the command */
	protected ChangeCommand command; 

	@Override
	public void init(IViewPart view) {
		super.init(view);
		// try to retrieve editing domain
		editingDomain = (EditingDomain)view.getAdapter(EditingDomain.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Package getSelectedElement() {
		return selectedElement;
	}

	/**
	 * Returns <code>true</code> if the element is a Package
	 * @param element the element to test
	 * @return <code>true</code> if the element is a Package
	 */
	@Override
	protected boolean isSelectableElement(Object element) {
		return (element instanceof Package);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSelectedElement(Object selectedElement) {
		if(selectedElement instanceof Package) {
			this.selectedElement = (Package)selectedElement;
		}
	}

	/**
	 * Returns <code>true</code> if the action can be executed
	 * @return <code>true</code> if the action can be executed
	 */
	public boolean canExecute() {
		return getCommand().canExecute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run(IAction action) {
		getCommand().execute();
	}

	/**
	 * returns the command that is executed by this action.
	 * @param domain EMF editing domain used by the command
	 * @return the command that is executed by this action
	 */
	public abstract ChangeCommand getCommand(EditingDomain domain);

	/**
	 * returns the command that is executed by this action.
	 * @return the command that is executed by this action
	 */
	public ChangeCommand getCommand() {
		return getCommand(editingDomain);
	}
}