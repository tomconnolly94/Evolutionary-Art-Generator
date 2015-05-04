package gui;

import input_output.Load;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import biomorphHandling.Biomorph;
import biomorphHandling.BiomorphManager;

public class KeyBoardShortcutListener implements KeyListener{

	private GraphicsMain gm;
	private BiomorphManager bm;
	private JFrame frame;
	
	public KeyBoardShortcutListener(GraphicsMain gm,BiomorphManager bm, JFrame frame){
		this.gm=gm;
		this.bm=bm;
		this.frame=frame;
	}
    public void keyPressed(KeyEvent e){
        if((e.getKeyCode() == KeyEvent.VK_N) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            gm.resetAction();
        }
        else if((e.getKeyCode() == KeyEvent.VK_O) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
        	final JFileChooser fc = new JFileChooser("src/biomorphTextFiles/");
			int returnVal = fc.showOpenDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();
				Load load = new Load(file.getName().replace(".txt", ""));
				System.out.println(file.getName());
				Biomorph loadedBiomorph = load.load();
				bm.addSpecific(loadedBiomorph);
				gm.refreshMainPanel();
			}
        }
        else if((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            System.out.println("woot!");
        }
        else if((e.getKeyCode() == KeyEvent.VK_C) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            System.out.println("woot!");
        }
    }
    public void keyReleased(KeyEvent e){}

    public void keyTyped(KeyEvent e){}



    }