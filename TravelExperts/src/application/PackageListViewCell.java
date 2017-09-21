package application;

import javafx.scene.control.ListCell;
import Models.Package;

public class PackageListViewCell extends ListCell<Package> {
	
	@Override
	protected void updateItem(Package pkg, boolean empty) {
		super.updateItem(pkg, empty);
		
		if (empty || pkg == null) {
			setText(null);
			
		}
		else {
			setText(pkg.toString());
		}
	}

}



