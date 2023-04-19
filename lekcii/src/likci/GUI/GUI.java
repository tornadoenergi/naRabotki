package likci.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class GUI extends JFrame {
    private final String[] dataList = {"Бакалея", "Напитки", "Хлеб"};
    private final String[][] dataText = {{"321","321","22","3332"},
           {"123","444","21","2145"},
           {"gdgd","gdg","534g","3451"}};
    private JTextArea content;
    private JPanel contentPane;
    private JList<String> lst_lekc;
    private JButton login;
    private JButton logout;


    public GUI() {
        setContentPane(contentPane);

  //      JFrame frame = new JFrame();
  //      JPanel contents = new JPanel();
        //String[] dataList = {"111","222","333"};
//
        //JList lst_lekc = new JList(dataList);
       // lst_lekc.add(dataList);
        lst_lekc.setListData(dataList);

        lst_lekc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       //JScrollPane myScrollPaneList = new JScrollPane(lst_lekc);
//
  //     content = new JTextArea();
  //     JScrollPane myListLector = new JScrollPane(content);
  //     //GridLayout layout = new GridLayout(1,0,2,0);
  //     JPanel buttonContainer = new JPanel();
  //     JButton btnLogin = new JButton("Войти");
  //     JButton btnLogout = new JButton("Выйти");
  //     buttonContainer.add(btnLogin);
  //     buttonContainer.add(btnLogout);
  //      // Подключения слушателя
       lst_lekc.addListSelectionListener(new listSelectionListener());
       //слушатель мыши
       lst_lekc.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 2) {
                   // Получение элемента
                   int selected = lst_lekc.locationToIndex(e.getPoint());
                   int i = 0;
                   String txt = "";
                   while (i < dataText[selected].length)
                       txt += dataText[selected][i++] + "\n";
                   content.setText(txt);

               }
           }
       });
       login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });
    }
    class listSelectionListener implements ListSelectionListener {
               public void valueChanged(ListSelectionEvent e) {
                   // Выделенная строка
                   int selected = ((JList<?>)e.getSource()).
                           getSelectedIndex();
                   System.out.println ("Выделенная строка : " +
                           String.valueOf(selected));
               }
           }

    private void onLogin(){
        LoginDialog Log = new LoginDialog(this);
    }

 }
  //     });
  //   //  contents.add(buttonContainer);
  //      //contents.setLayout();
  //      contents.setBorder(new TitledBorder("Темы:"));
  //      contents.add(myScrollPaneList,BorderLayout.SOUTH);
  //      frame.setLayout();
  //     //frame.add(contents,BorderLayout.WEST);
  //     //frame.add(myListLector);
  //      CreatePane(frame.getContentPane());
  //      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setTitle("Список лекций");
        //frame.setResizable(true);
        //frame.setVisible(true);
        //frame.setSize(800, 600);
        //frame.pack();

