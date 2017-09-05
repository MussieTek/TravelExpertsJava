package workshop6.team4;

import javafx.scene.control.ListCell;
import workshop6.travelexperts.*;

public class PackageListViewCell extends ListCell<Packages> {
	
	@Override
	protected void updateItem(Packages pkg, boolean empty) {
		super.updateItem(pkg, empty);
		
		if (empty || pkg == null) {
			setText(null);
			
		}
		else {
			setText(pkg.getPkgName());
		}
	}

}
