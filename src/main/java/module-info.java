module org.robots.robots_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.robots.robots_fx to javafx.fxml;
    exports org.robots.robots_fx;
}