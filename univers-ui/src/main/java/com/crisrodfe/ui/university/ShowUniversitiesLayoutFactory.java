package com.crisrodfe.ui.university;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crisrodfe.module.entity.University;
import com.crisrodfe.services.university.ShowAllUniversitiesService;
import com.crisrodfe.ui.commons.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class ShowUniversitiesLayoutFactory implements UIComponentBuilder{
	
	private List<University> universities;
	private BeanItemContainer<University> container;

	@Autowired
	private ShowAllUniversitiesService allUniversitiesService;
	
	private class ShowUniversitiesLayout extends VerticalLayout {

		private Grid universityTable;
		
		private ShowUniversitiesLayout load() {
			universities = allUniversitiesService.getAllUniversities();
			return this;
		}
		
		private ShowUniversitiesLayout init() {
			setMargin(true);
			container = new BeanItemContainer<University>(University.class,universities);
			universityTable = new Grid(container);
			universityTable.setColumnOrder("universityName","universityCountry","universityCity");
			universityTable.removeColumn("id");
			universityTable.setImmediate(true);
			
			return this;
		}
		
		private ShowUniversitiesLayout layout() {
			addComponent(universityTable);
			return this;
		}
	}
	
	public void refreshTable() {
		universities = allUniversitiesService.getAllUniversities();
		container.removeAllItems();
		container.addAll(universities);
	}
	
	public Component createComponent() {
		return new ShowUniversitiesLayout().load().init().layout();
	}
}
