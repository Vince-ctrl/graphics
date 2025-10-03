import javax.swing.*;
import java.awt.*;

// Main class to launch the window
public class BobbyBob {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cartoon Faces");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450, 500);
            frame.setLayout(new BorderLayout());

            // Create the drawing panel and button panel
            FacePanel facePanel = new FacePanel();
            JPanel buttonPanel = new JPanel();

            // Create buttons to switch faces
            JButton face1Button = new JButton("Face 1");
            JButton face2Button = new JButton("Face 2");
            JButton face3Button = new JButton("Face 3");

            // Add action listeners to buttons
            face1Button.addActionListener(e -> {
                facePanel.setFaceType(1);
                facePanel.repaint();
            });

            face2Button.addActionListener(e -> {
                facePanel.setFaceType(2);
                facePanel.repaint();
            });

            face3Button.addActionListener(e -> {
                facePanel.setFaceType(3);
                facePanel.repaint();
            });

            // Add buttons to the panel
            buttonPanel.add(face1Button);
            buttonPanel.add(face2Button);
            buttonPanel.add(face3Button);

            // Add panels to the frame
            frame.add(facePanel, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}

// Custom JPanel that draws different cartoon faces
class FacePanel extends JPanel {
    private int faceType = 1; // Default face

    public void setFaceType(int type) {
        this.faceType = type;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (faceType) {
            case 1 -> drawFace1(g);
            case 2 -> drawFace2(g);
            case 3 -> drawFace3(g);
        }
    }

    // First cartoon face
    private void drawFace1(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Face shape
        g2.setColor(new Color(255, 220, 180));
        g2.fillOval(120, 70, 200, 250);

        // Eyes
        g2.setColor(Color.WHITE);
        g2.fillOval(160, 140, 30, 20);
        g2.fillOval(230, 140, 30, 20);
        g2.setColor(Color.BLACK);
        g2.fillOval(170, 145, 10, 10);
        g2.fillOval(240, 145, 10, 10);

        // Smile
        g2.setColor(Color.RED);
        g2.drawArc(170, 200, 80, 40, 0, -180);
    }

    // Second cartoon face
    private void drawFace2(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Square face
        g2.setColor(new Color(200, 230, 250));
        g2.fillRect(120, 70, 200, 250);

        // Eyes
        g2.setColor(Color.YELLOW);
        g2.fillOval(160, 140, 30, 30);
        g2.fillOval(230, 140, 30, 30);
        g2.setColor(Color.BLACK);
        g2.fillOval(170, 150, 10, 10);
        g2.fillOval(240, 150, 10, 10);

        // Mouth
        g2.setColor(Color.BLUE);
        g2.fillRect(180, 220, 60, 10);
    }

    // Third cartoon face
    private void drawFace3(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Circular face
        g2.setColor(new Color(255, 255, 200));
        g2.fillOval(120, 70, 200, 200);

        // Eyes
        g2.setColor(Color.GREEN);
        g2.fillOval(160, 130, 25, 25);
        g2.fillOval(235, 130, 25, 25);

        // Nose
        g2.setColor(Color.ORANGE);
        g2.fillOval(195, 160, 20, 20);

        // Mouth (surprised)
        g2.setColor(Color.MAGENTA);
        g2.fillOval(190, 190, 30, 30);
    }
}
