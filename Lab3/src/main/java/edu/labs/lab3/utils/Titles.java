package edu.labs.lab3.utils;

public class Titles {
    public FileMenu fileMenu;
    public ShapesMenu shapesMenu;
    public String helpMenuTitle;
    public String selectMark;
    public ToolbarMenu toolbarMenu;  // Add this line

    public static class FileMenu {
        public String title;
        public String newItemTitle;
        public String openFileItemTitle;
        public String exitItemTitle;
    }

    public static class ShapesMenu {
        public String title;
        public ShapeTitles shapes;

        public static class ShapeTitles {
            public String ellipseShapeItemTitle;
            public String rectangleShapeItemTitle;
            public String lineShapeItemTitle;
            public String pointShapeItemTitle;
        }
    }

    // Add this new class
    public static class ToolbarMenu {
        public Actions actions;
        public ShapeTitles shapes;

        public static class Actions {
            public String draw;
            public String erase;
        }

        public static class ShapeTitles {
            public String ellipseShapeItemTitle;
            public String rectangleShapeItemTitle;
            public String lineShapeItemTitle;
            public String pointShapeItemTitle;
        }
    }
}

