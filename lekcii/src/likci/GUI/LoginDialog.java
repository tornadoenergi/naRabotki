package likci.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginDialog extends JDialog
{
    private static final long serialVersionUID = 1L;

    public JTextField tfLogin, tfPassword;
    public JButton    btnOk, btnCancel;

    public LoginDialog(JFrame parent)
    {
        super(parent, "Вход в систему");
        // При выходе из диалогового окна работа заканчивается
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });
        // добавляем расположение в центр окна
        getContentPane().add(createGUI());
        // задаем предпочтительный размер
        pack();
        // выводим окно на экран
        setVisible(true);
    }
    // этот метод будет возвращать панель с созданным расположением
    private JPanel createGUI()
    {
        // Создание панели для размещение компонентов
        JPanel panel = BoxLayoutUtils.createVerticalPanel();
        // Определение отступов от границ ранели. Для этого используем пустую рамку
        panel.setBorder (BorderFactory.createEmptyBorder(12,12,12,12));
        // Создание панели для размещения метки и текстового поля логина
        JPanel name = BoxLayoutUtils.createHorizontalPanel();
        JLabel nameLabel = new JLabel("Имя:");
        name.add(nameLabel);
        name.add(Box.createHorizontalStrut(12));
        tfLogin = new JTextField(15);
        name.add(tfLogin);
        // Создание панели для размещения метки и текстового поля пароля
        JPanel password = BoxLayoutUtils.createHorizontalPanel();
        JLabel passwrdLabel = new JLabel("Пароль:");
        password.add(passwrdLabel);
        password.add(Box.createHorizontalStrut(12));
        tfPassword = new JTextField(15);
        password.add(tfPassword);
        // Создание панели для размещения кнопок управления
        JPanel flow = new JPanel( new FlowLayout( FlowLayout.RIGHT, 0, 0) );
        JPanel grid = new JPanel( new GridLayout( 1,2,5,0) );
        btnOk = new JButton("OK");
        btnCancel = new JButton("Отмена");
        grid.add(btnOk    );
        grid.add(btnCancel);
        flow.add(grid);
        // Выравнивание вложенных панелей по горизонтали
        BoxLayoutUtils.setGroupAlignmentX(new JComponent[] { name, password, panel, flow },
                Component.LEFT_ALIGNMENT);
        // Выравнивание вложенных панелей по вертикали
        BoxLayoutUtils.setGroupAlignmentY(new JComponent[] { tfLogin, tfPassword, nameLabel, passwrdLabel},
                Component.CENTER_ALIGNMENT);
        // Определение размеров надписей к текстовым полям
        GUITools.makeSameSize(new JComponent[] { nameLabel, passwrdLabel } );
        // Определение стандартного вида для кнопок
        GUITools.createRecommendedMargin(new JButton[] { btnOk, btnCancel } );
        // Устранение "бесконечной" высоты текстовых полей
        GUITools.fixTextFieldSize(tfLogin   );
        GUITools.fixTextFieldSize(tfPassword);

        // Сборка интерфейса
        panel.add(name);
        panel.add(Box.createVerticalStrut(12));
        panel.add(password);
        panel.add(Box.createVerticalStrut(17));
        panel.add(flow);
        // готово
        return panel;
    }
    // тестовый метод для проверки диалогового окна
    public static void main(String[] args) {
        new LoginDialog(new JFrame());
    }
}