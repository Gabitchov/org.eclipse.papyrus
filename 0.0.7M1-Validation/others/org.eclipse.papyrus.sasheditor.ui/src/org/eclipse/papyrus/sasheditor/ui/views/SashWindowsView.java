package org.eclipse.papyrus.sasheditor.ui.views;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.papyrus.sasheditor.editor.IPage;
import org.eclipse.papyrus.sasheditor.editor.IPageChangedListener;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainerChangedListener;
import org.eclipse.papyrus.sasheditor.editor.SashWindowsEventsProvider;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.*;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.core.runtime.IAdaptable;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class SashWindowsView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.papyrus.sasheditor.ui.views.SashWindowsView";

	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;

	/** Class managing selected element rendering */
	private SelectedElementViewer selectedElementViewer;
	
	/** Class to listen on SashWindows events. */ 
	private SashWindowsEventsProvider sashWindowEventsManager;
	/** Active Editor associated to the current container. Can be null.*/
	
	/** Current editor shown by the view, or null */
	private IEditorPart currentEditor = null;
	
	/**
	 * Listener listening on pageChanged event.
	 */
	private IPageChangedListener pageChangedListener = new IPageChangedListener(){
		
		public void pageChanged(IPage newPage) {
			System.out.println(SashWindowsView.this.getClass().getSimpleName()+ ".pageChanged(" + newPage + ")");
			
		}
	};
	
	/**
	 * Listener listening on containerChanged event.
	 */
	private ISashWindowsContainerChangedListener containerChangedListener = new ISashWindowsContainerChangedListener(){
		
		public void sashWindowsContainerChanged(ISashWindowsContainer newContainer)
		{
			// Get the active editor, which should be the one owning the new page
			// Set it to null if the container is null.
			System.out.println(SashWindowsView.this.getClass().getSimpleName()+ ".sashWindowsContainerChanged(" + newContainer + ")");

        	
        	reconnectSelectionListener();
		}
	};
	
	private ISelectionChangedListener selectionChangedListener = new ISelectionChangedListener() {
		
		public void selectionChanged(SelectionChangedEvent event) {
			System.out.println(SashWindowsView.this.getClass().getSimpleName()+ ".selectionChanged(" + event + ")");

			SashWindowsView.this.selectionChanged(event.getSelection());
		}
	};
	
	
	private SelectionListener isVisibleListener = new SelectionListener() {
		
		public void widgetSelected(SelectionEvent e) {
			boolean isVisible = ((Button)e.getSource()).getSelection();
			System.out.println("isVisible=" + isVisible );
			changeSelectedElementIsVisible(isVisible);
		}
		
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	class TreeObject implements IAdaptable {
		private String name;
		private TreeParent parent;
		
		public TreeObject(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setParent(TreeParent parent) {
			this.parent = parent;
		}
		public TreeParent getParent() {
			return parent;
		}
		public String toString() {
			return getName();
		}
		public Object getAdapter(Class key) {
			return null;
		}
	}
	
	class TreeParent extends TreeObject {
		private ArrayList children;
		public TreeParent(String name) {
			super(name);
			children = new ArrayList();
		}
		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}
		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}
		public TreeObject [] getChildren() {
			return (TreeObject [])children.toArray(new TreeObject[children.size()]);
		}
		public boolean hasChildren() {
			return children.size()>0;
		}
	}

	class ViewContentProvider implements IStructuredContentProvider, 
										   ITreeContentProvider {
		private TreeParent invisibleRoot;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot==null) initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}
/*
 * We will set up a dummy model to initialize tree heararchy.
 * In a real code, you will connect to a real model and
 * expose its hierarchy.
 */
		private void initialize() {
			TreeObject to1 = new TreeObject("Leaf 1");
			TreeObject to2 = new TreeObject("Leaf 2");
			TreeObject to3 = new TreeObject("Leaf 3");
			TreeParent p1 = new TreeParent("Parent 1");
			p1.addChild(to1);
			p1.addChild(to2);
			p1.addChild(to3);
			
			TreeObject to4 = new TreeObject("Leaf 4");
			TreeParent p2 = new TreeParent("Parent 2");
			p2.addChild(to4);
			
			TreeParent root = new TreeParent("Root");
			root.addChild(p1);
			root.addChild(p2);
			
			invisibleRoot = new TreeParent("");
			invisibleRoot.addChild(root);
		}
	}
	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}
		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
			   imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public SashWindowsView() {
	}

	/**
	 * Change the Notation.isVisible value of selected element that are gmf Views.
	 * @param isVisible
	 */
	protected void changeSelectedElementIsVisible(boolean isVisible) {
		
		if(currentEditor == null)
			return;
		
		 ISelection selection = currentEditor.getSite().getSelectionProvider().getSelection();
		 if(! (selection instanceof StructuredSelection) )
			 return;
		 
		 StructuredSelection structuredSelection = (StructuredSelection)selection;
		 
		 Iterator<Object> iter = structuredSelection.iterator();
		 while( iter.hasNext())
		 {
			 Object selected = iter.next();
			 System.out.println("selected=" + selected);
//			 if(selected instanceof )
		 }
	}

	/**
	 * The selection has changed.
	 * @param selection
	 */
	protected void selectionChanged(ISelection selection) {
		
		if(selection instanceof TextSelection)
		{
			TextSelection textSelection = (TextSelection)selection;
		  selectedElementViewer.setText(textSelection.getText());
		}
		else if( selection instanceof StructuredSelection)
		{
			StructuredSelection structuredSelection = (StructuredSelection)selection;
			selectedElementViewer.setText(structuredSelection.getFirstElement().toString());
		}
		
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		
		// Create overall container
		Composite container = new Composite(parent, SWT.NONE);
		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.wrap = true;
		layout.fill = true;
		layout.justify = false;
		container.setLayout( layout);
		
		selectedElementViewer = new SelectedElementViewer();
		selectedElementViewer.createPartControl(container);
		selectedElementViewer.addIsVisibleChangedListener(isVisibleListener);
		
//		// Create TreeViewer
//		viewer = new TreeViewer(container, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
//		drillDownAdapter = new DrillDownAdapter(viewer);
//		viewer.setContentProvider(new ViewContentProvider());
//		viewer.setLabelProvider(new ViewLabelProvider());
//		viewer.setSorter(new NameSorter());
//		viewer.setInput(getViewSite());
//
//		// Create the help context id for the viewer's control
//		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "org.eclipse.papyrus.sasheditor.ui.viewer");
//		makeActions();
//		hookContextMenu();
//		hookDoubleClickAction();
//		contributeToActionBars();
	}

	/**
	 * Initialize the view
	 * @see org.eclipse.ui.part.ViewPart#init(org.eclipse.ui.IViewSite)
	 *
	 * @param site
	 * @throws PartInitException
	 */
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		sashWindowEventsManager = new SashWindowsEventsProvider(site.getPage());
		sashWindowEventsManager.addPageChangedListener(pageChangedListener);
		sashWindowEventsManager.addSashWindowsContainerChangedListener(containerChangedListener);
		reconnectSelectionListener();
	}
	
	@Override
	public void dispose() {
		sashWindowEventsManager.dispose();
		selectedElementViewer.dispose();
		super.dispose();
	}
	
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				SashWindowsView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Sash Window ",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
//		viewer.getControl().setFocus();
		selectedElementViewer.setFocus();
	}
	
	/**
	 * This method is called when the Container has changed. This also means that the active editor has changed.
	 */
	protected void reconnectSelectionListener()
	{
		// Remove listening on all editor
		if(currentEditor!=null)
		{
			currentEditor.getSite().getSelectionProvider().removeSelectionChangedListener(selectionChangedListener);
		}
		
		currentEditor = sashWindowEventsManager.activeSashWindowsContainerOwner();
		if(currentEditor!=null)
		{
			currentEditor.getSite().getSelectionProvider().addSelectionChangedListener(selectionChangedListener);
		}
	}
	
	/**
	 * A set of SWT Composite used to render a selected element.
	 * @author dumoulin
	 */
	protected class SelectedElementViewer {

		private FormToolkit toolkit;
		private ScrolledForm form;
		
		private Label label;
		private Text text;
		private Button isVisible;


		/**
		 * Create associated part control.
		 * @param parent
		 */
		public void createPartControl( Composite parent )
		{
			toolkit = new FormToolkit(parent.getDisplay());
			form = toolkit.createScrolledForm(parent);
			form.setText("Hello, Eclipse Forms");

			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			form.getBody().setLayout(layout);
			GridData gd = new GridData();

			Label label = toolkit.createLabel(form.getBody(), "Text field label:");
			text = toolkit.createText(form.getBody(), "", SWT.BORDER);
			text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			isVisible = toolkit.createButton(form.getBody(), "A checkbox in a form", SWT.CHECK | SWT.RIGHT);
			gd = new GridData();
			gd.horizontalSpan = 2;
			isVisible.setLayoutData(gd);
		}

		public void setIsVisible( boolean newValue)
		{
			isVisible.setSelection(newValue);
		}
		
		public void setText( String newText )
		{
			text.setText(newText);
		}
		

		/**
		 * Dispose all resources
		 */
		public void dispose()
		{
			toolkit.dispose();
		}
		
		/**
		 * Set focus to this element.
		 */
		public void setFocus()
		{
			form.setFocus();
		}
		
		/**
		 * Add a listener listening on isVisible value changed.
		 * @param listener
		 */
		public void addIsVisibleChangedListener(SelectionListener listener)
		{
			isVisible.addSelectionListener(listener);
		}
		/**
		 * Remove a listener listening on isVisible value changed.
		 * @param listener
		 */
		public void removeIsVisibleChangedListener(SelectionListener listener)
		{
			isVisible.removeSelectionListener(listener);
		}
	}
}