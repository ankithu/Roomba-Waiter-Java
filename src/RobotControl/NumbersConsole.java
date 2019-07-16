package RobotControl;


import jcurses.widgets.*;
import jcurses.system.Toolkit;
import jcurses.system.CharColor;

public class NumbersConsole {
        public static void main(String[] args) {
        
            Window w = new Window(40, 20, true, "NumbersConsole");
            DefaultLayoutManager mgr = new DefaultLayoutManager();
            mgr.bindToContainer(w.getRootPanel());

            CharColor color = new CharColor(CharColor.WHITE, CharColor.GREEN);

            w.show();

            int num = 0;

            while ( ! w.isClosed() ) {
                Toolkit.printString( ""+ num, 45, 17, color);
                num++;
            }
        }
}