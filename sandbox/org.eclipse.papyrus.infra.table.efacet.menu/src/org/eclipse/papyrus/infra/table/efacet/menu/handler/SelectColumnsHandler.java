package org.eclipse.papyrus.infra.table.efacet.menu.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.mapping.ModelStatus;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.IFacetManagerFactory;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManagerFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.EObjectLiteralQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.StringLiteralQuery;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactoriesRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.FeatureColumn;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.ui.command.ITableCommandFactory;
import org.eclipse.emf.facet.widgets.table.ui.command.ITableCommandFactoryFactory;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetInternal;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetProvider;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.table.efacet.common.editor.AbstractTableEditor;
import org.eclipse.papyrus.infra.table.efacet.menu.Activator;
import org.eclipse.papyrus.infra.table.efacet.menu.factory.TableInstanceCommandFactory;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.TableContentsUtils;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;


//FIXME : uml dependency
public class SelectColumnsHandler extends AbstractHandler {


	public Object execute(ExecutionEvent event) throws ExecutionException {
		final CompoundCommand compoundCmd = new CompoundCommand("Papyrus Show/Hide columns");
		final PapyrusTable papyrusTable = getPapyrusTable();
		final ITableWidget widget = getTableWidget();
		TransactionalEditingDomain domain = getEditingDomain();
		ICommand addFacetSetToResourceCommand = null;
		if(papyrusTable != null && widget != null) {
			//the contents of the table
			final List<EObject> contents = TableContentsUtils.getTableContents(papyrusTable, papyrusTable.getTable().getContext(), false);

			//all stereotypes used in the table
			final Set<Stereotype> stereotypes = new HashSet<Stereotype>();

			//all stereotypes identified by their qualified name
			final Map<String, Stereotype> mapName_stereotypes = new HashMap<String, Stereotype>();

			//all facets applied on the table + all applicable facets representing stereotypes
			final Set<Facet> allFacets = new TreeSet<Facet>(new EcoreFeatureComparator());

			final SortedSet<ETypedElement> allFeatures = new TreeSet<ETypedElement>(new EcoreFeatureComparator());
			final Map<ETypedElement, Column> columnsFeatureMap = new HashMap<ETypedElement, Column>();
			final Map<EClass, Stereotype> eClassSteMap = new TreeMap<EClass, Stereotype>(new EcoreFeatureComparator());


			//1. Get all direct features and store all used stereotypes
			for(EObject current : contents) {
				allFeatures.addAll(current.eClass().getEAllStructuralFeatures());
				if(current instanceof Element) {
					stereotypes.addAll(((Element)current).getAppliedStereotypes());
				}
			}

			//1. bis 
			//   - complete the list of features with the features of the columns
			//   - map the columns with the features
			for(final Column current : papyrusTable.getTable().getColumns()) {
				if(current instanceof FeatureColumn) {
					final FeatureColumn col = (FeatureColumn)current;
					final ETypedElement feature = col.getFeature();
					columnsFeatureMap.put(feature, col);
					if(feature instanceof FacetElement) {
						allFacets.add((Facet)feature.eContainer());
					}
				}
			}

			//2. look for an existing facetSet representing the stereotype
			final String facetSetName = "localFacetSet";
			final String facetSetURI = "http://www.eclipse.org/papyrustableefacet/localfacetset";
			FacetSet localSet = null;
			EcoreUtil.resolveAll(papyrusTable);
			Resource res = papyrusTable.eResource();
			if(res == null) {
				if(domain == null) {
					domain = TransactionUtil.getEditingDomain(contents.get(0));
				}
				try {
					ServicesRegistry serviceRegistry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry();
					domain = serviceRegistry.getService(TransactionalEditingDomain.class);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				EList<Resource> resources = domain.getResourceSet().getResources();
				for(Resource tmpRes : resources) {
					URI uri = tmpRes.getURI();
					if(uri.fileExtension().equals("notation")) {
						int i = 0;
						i++;
						EList<EObject> allContents = res.getContents();
						i++;
					}
				}
			}
			for(final EObject current : res.getContents()) {
				if(current instanceof FacetSet && facetSetName.equals(((FacetSet)current).getName())) {
					localSet = (FacetSet)current;
					break;
				}
			}

			//2. bis if the facetSet doesn't exist, we create it
			if(localSet == null) {
				final String documentation = "This FacetSet provides facet to edit easily the properties of the stereotypes. It had been generated by the Papyrus Show/Hide columns";
				localSet = FacetFactory.createFacetSet("localfacetset", "localfacetset", "http://www.eclipse.org/papyrustableefacet/localfacetset", documentation);
				final FacetSet set = localSet;
				addFacetSetToResourceCommand = new AbstractTransactionalCommand(getEditingDomain(), "Attach local facetSet to the resource", null) {

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						papyrusTable.eResource().getContents().add(set);
						return CommandResult.newOKCommandResult();
					}
				};
			}

			//3. we associate each stereotype to its qualified name
			for(final Stereotype ste : stereotypes) {
				mapName_stereotypes.put(ste.getQualifiedName(), ste);
			}

			//4. we map the stereotype with the existing Facet //TODO currently, we assume that the stereotype has not changed
			List<Stereotype> unmappedStereotype = new ArrayList<Stereotype>(stereotypes);
			for(final EClassifier currentFacet : localSet.getEClassifiers()) {
				if(currentFacet instanceof Facet) {
					for(final FacetOperation op : ((Facet)currentFacet).getFacetOperations()) {
						if("getStereotypeQualifiedName".equals(op.getName())) {
							final String qName = ((StringLiteralQuery)op.getQuery()).getValue();
							unmappedStereotype.remove(mapName_stereotypes.get(qName));
							break;
						}
					}
				}
			}

			final List<Facet> createdEFacet = new ArrayList<Facet>();

			//5. we create the Facet for the unmapped stereotypes
			for(final Stereotype ste : unmappedStereotype) {
				Facet facet = FacetFactory.createFacet(ste);
				createdEFacet.add(facet);
			}
			allFacets.addAll(createdEFacet);

			//6. we create the input 
			final Collection<EObject> dialogInput = new ArrayList<EObject>();
			dialogInput.addAll(allFeatures);
			dialogInput.addAll(allFacets);

			//7. we build the initial selection
			final Collection<ETypedElement> initialSelection = new ArrayList<ETypedElement>(columnsFeatureMap.keySet());

			ColumnsToHideDialog dialog = new ColumnsToHideDialog(Display.getCurrent().getActiveShell(), dialogInput, initialSelection, getLabelProvider());
			if(dialog.open() == Window.OK) {
				final Object[] result = dialog.getResult();
				final List<Object> resultAsList = Arrays.asList(result);

				final List<Object> columnsToAdd = new ArrayList<Object>(resultAsList);
				columnsToAdd.removeAll(initialSelection);
				//these columns should be set To Visible OR created

				List<Column> columnsToShow = new ArrayList<Column>();
				List<ETypedElement> columnsToCreate = new ArrayList<ETypedElement>();
				for(final Object currentColumn : columnsToAdd) {
					if(columnsFeatureMap.containsKey(currentColumn)) {
						columnsToShow.add(columnsFeatureMap.get(currentColumn));
					} else {
						columnsToCreate.add((ETypedElement)currentColumn);
					}
				}

				List<Object> featureToHide = new ArrayList<Object>(initialSelection);
				featureToHide.removeAll(resultAsList);


				//these columns should be hidden
				List<Column> columnsToHide = new ArrayList<Column>();
				for(final Object current : featureToHide) {
					Column toHide = columnsFeatureMap.get(current);
					if(toHide != null) {
						columnsToHide.add(toHide);
					}
				}

				ITableWidgetInternal widgetController = (ITableWidgetInternal)widget;
				ICommandFactory commandFactory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(domain);
				boolean putOnTheTop = false;

				final Command showHideCommand = TableInstanceCommandFactory.createShowHideColumnCommand(widgetController, domain, commandFactory, papyrusTable.getTable(), columnsToShow, columnsToHide, putOnTheTop);
				if(showHideCommand != null && showHideCommand.canExecute()) {
					compoundCmd.append(showHideCommand);
				}
				if(addFacetSetToResourceCommand != null) { //TODO : test if the current selection need to it!
					compoundCmd.append(new GMFtoEMFCommandWrapper(addFacetSetToResourceCommand));
				}

				//TODO : complete with the removeFacetSetFromResource command or remove Facet from facetSet command				

				if(!createdEFacet.isEmpty()) {
					final FacetSet set = localSet;
					ICommand cmd = new AbstractTransactionalCommand(getEditingDomain(), "Add Facet to the local facetSet", null) {

						@Override
						protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
							set.getEClassifiers().addAll(createdEFacet);
							return CommandResult.newOKCommandResult();
						}
					};
					compoundCmd.append(new GMFtoEMFCommandWrapper(cmd));
				}


				domain.getCommandStack().execute(compoundCmd);
				IFacetSetCatalogManagerFactory.DEFAULT.getOrCreateFacetSetCatalogManager(res.getResourceSet()).registerFacetSet(localSet);
				List<FacetSet> facetSetToAdd = new ArrayList<FacetSet>();
				facetSetToAdd.add(localSet);

				widget.addColumns(columnsToCreate, facetSetToAdd);//TODO should be chained with the previous command
			}
		}

		return null;
	}

	protected Command getBuildedCommand() {
		CompoundCommand compoundCommand = new CompoundCommand();

		return compoundCommand;
	}

	protected Command getShowHideExistingColumnCommand() {
		CompoundCommand compoundCommand = new CompoundCommand();

		return compoundCommand;
	}

	protected Command getAddAndCreateNewColumnsCommand() {
		CompoundCommand compoundCommand = new CompoundCommand();

		return compoundCommand;
	}


	public class EcoreFeatureComparator implements Comparator<ENamedElement> {

		public int compare(ENamedElement o1, ENamedElement o2) {
			return o1.getName().compareToIgnoreCase(o2.getName());
		}

	}

	public class StereotypeNameComparator implements Comparator<Stereotype> {//TODO rename into NamedElement Comparator

		public int compare(Stereotype o1, Stereotype o2) {
			return o1.getName().compareToIgnoreCase(o2.getName());
		}

	}

	private TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain domain = null;
		domain = TransactionUtil.getEditingDomain(getPapyrusTable());
		return domain;
	}

	private AbstractTableEditor getCurrentTableEditor() {

		final IStructuredSelection selection = (IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		final Object current = selection.getFirstElement();
		if(current instanceof EObject) {

			IEditorPart part = null;
			try {
				part = ServiceUtilsForResource.getInstance().getNestedActiveIEditorPart(((EObject)current).eResource());
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
			if(part instanceof AbstractTableEditor) {
				return (AbstractTableEditor)part;
			}

		}
		return null;
	}

	private PapyrusTable getPapyrusTable() {
		IEditorPart part = getCurrentTableEditor();
		if(part != null) {
			return (PapyrusTable)part.getAdapter(PapyrusTable.class);
		}
		return null;
	}

	private ITableWidget getTableWidget() {
		IAdaptable editor = getCurrentTableEditor();
		final ITableWidgetProvider provider = (ITableWidgetProvider)editor.getAdapter(ITableWidgetProvider.class);
		if(provider != null) {
			return provider.getTableWidget();
		}
		return null;
	}

	private ILabelProvider getLabelProvider() {
		AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		final ILabelProvider labelProvider = new AdapterFactoryLabelProvider(factory);
		return labelProvider;
	}
}
