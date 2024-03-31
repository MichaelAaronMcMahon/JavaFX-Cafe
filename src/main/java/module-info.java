module projfx.smproj4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens projfx.smproj4 to javafx.fxml;
    exports projfx.smproj4;
}