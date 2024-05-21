import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JPanel mainWindow;
    private JButton button2;
    private JButton enterpathButton;
    private JButton showgraphButton;
    private JButton button4;
    private JButton button5;
    private JPanel picture;
    private JButton button1;

    public UI() {
        enterpathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 弹出输入对话框
                String filePath = JOptionPane.showInputDialog(mainWindow, "Please enter the file path:");

                // 处理用户输入
                if (filePath != null) {
                    System.out.println("File Path Entered: " + filePath);
                    // 可以在这里添加进一步处理逻辑，例如验证路径，读取文件等
                } else {
                    System.out.println("No file path entered.");
                }
            }
        });
        showgraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Load and display the image when the button is clicked
                ImagePanel imagePanel = new ImagePanel("graph.png");
                picture.removeAll(); // Clear any existing content
                picture.add(imagePanel);
                picture.revalidate(); // Refresh the panel to display the new content
                picture.repaint(); // Repaint the panel
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("UI");
        frame.setContentPane(new UI().mainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Set the frame size to 800x600 pixels
        frame.setVisible(true);
    }
}

// Custom JPanel to display an image
class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(String imagePath) {
        try {
            image = new ImageIcon(imagePath).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
