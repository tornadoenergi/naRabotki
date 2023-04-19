package likci.main;

import likci.GUI.GUI;

public class Main
{
    public static void main(String[] args)

    {
        GUI gui = new GUI();
        gui.setTitle("Список лекций");
        gui.setResizable(true);
        gui.setVisible(true);
        gui.setSize(80, 60);
        gui.pack();
    }
}


