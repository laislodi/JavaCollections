package school2;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DaddyPanel extends JPanel {
    private final JFrame frame;
    private final String titulo;

    public DaddyPanel(JFrame frame, String titulo) {
        this.frame = frame;
        this.titulo = titulo;
        frame.setTitle(titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void trocarPainel(DaddyPanel novoPainel) {
        frame.remove(this);
        frame.setTitle(novoPainel.getTitulo());
        frame.add(novoPainel);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }
}
